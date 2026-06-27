# PCBench: A Java Benchmark for Refuting Infeasible Taint Paths

PCBench is a source-level Java benchmark for evaluating path-feasibility
reasoning in static taint analysis. It accompanies the paper **"Refuting
Infeasible Paths for False Alarm Reduction"** and is designed to test whether
an analysis can reject infeasible source-to-sink paths without removing
feasible ones.

Static taint analyzers often report paths that are valid in a data-flow graph
but impossible in any concrete execution. PCBench isolates such cases in small
Java programs covering branches, aliases, fields, arrays, casts, exceptions,
polymorphism, interprocedural flows, loops, operators, recursion, and context
sensitivity.

This repository contains the benchmark source code and source/sink
configuration. It does not include the implementation of the IFPC path
refutation tool described in the paper.

## Paper

**Refuting Infeasible Paths for False Alarm Reduction**

The paper proposes a lightweight static path-feasibility checker for reports
produced by static analysis tools. Given a candidate path, the method builds an
alias-aware value-flow graph, collects control- and data-dependency
constraints, and uses an SMT solver to refute paths whose constraints are
unsatisfiable.

In the paper's evaluation, PCBench contains 64 source-to-sink paths: 38
infeasible paths and 26 feasible paths. The proposed method refutes 33 of the
38 infeasible paths and does not refute any feasible path.

## Benchmark Design

PCBench is intended to evaluate false-alarm reduction for taint reports. The
ground truth is defined at the path level:

- **Infeasible path**: a reported source-to-sink path whose path constraints are
  contradictory and therefore cannot occur at runtime.
- **Feasible path**: a source-to-sink path that can occur in at least one
  execution and should not be suppressed.

The benchmark uses compact Java classes rather than large applications. Each
case focuses on one language feature or one interaction between features, so
the reason for feasibility or infeasibility can be inspected directly from the
source code.

## Artifact Structure

```text
.
|-- src/main/java/              Java benchmark cases
|   |-- branch/                 Branch, switch, else-if, ternary, shortcuts
|   |-- defect/                 Shared source/sink model
|   |-- fields/                 Field sensitivity and access-path cases
|   |-- general/
|   |   |-- arrays/             Array cases
|   |   |-- cast/               Cast and type-test cases
|   |   |-- exception/          Exception-control-flow cases
|   |   `-- polymorphism/       Interface, inheritance, override cases
|   |-- inter/                  Interprocedural taint paths
|   |-- loop/                   Loop-derived path constraints
|   |-- operators/              Boolean, arithmetic, and comparison operators
|   |-- recursion/              Recursive helper methods
|   `-- sensitivety/            Context-sensitivity cases
|-- ifpc.json                   IFPC-style source/sink configuration
|-- .inferconfig                Infer Pulse/Quandary source-sink configuration
|-- pom.xml                     Maven build file
|-- LICENSE
`-- README.md
```

The package name `sensitivety` is intentionally preserved for compatibility
with the original benchmark paths.

## Benchmark Composition

| Category | Infeasible paths | Feasible paths |
| --- | ---: | ---: |
| Branch | 5 | 4 |
| Field | 8 | 5 |
| Array | 1 | 1 |
| Cast | 2 | 1 |
| Exception | 1 | 1 |
| Polymorphism | 3 | 3 |
| Interprocedural | 8 | 5 |
| Loop | 2 | 2 |
| Operator | 5 | 1 |
| Recursion | 2 | 2 |
| Sensitivity | 1 | 1 |
| **Total** | **38** | **26** |

## Taint Specification

All benchmark cases use `defect.InfoLeak` as the shared source/sink model:

```java
defect.InfoLeak.source();       // taint source
defect.InfoLeak.sink(String);   // taint sink
defect.InfoLeak.safe();         // untainted value
```

The IFPC-style configuration in `ifpc.json` declares:

```json
{
  "sources": [
    "<defect.InfoLeak: java.lang.String source()>"
  ],
  "sinks": [
    "<defect.InfoLeak: void sink(java.lang.String)>"
  ]
}
```

The Infer configuration in `.inferconfig` provides equivalent source/sink
entries for Pulse and Quandary.

## Case Naming

Most benchmark classes use method names to indicate the expected semantic
outcome:

- `good` denotes a false-alarm case: the taint path is infeasible and should be
  refuted.
- `bad` denotes a real-leak case: the taint path is feasible and should be
  retained.

This naming follows the benchmark convention that "good" means no real
information leak is possible, while "bad" means a real source-to-sink flow is
possible. Some historical class names, such as `C01good` and `C01bad`, follow
the same convention.

## Build Instructions

PCBench targets Java 11 and has no third-party Maven dependencies.

```bash
mvn compile
```

The command compiles the benchmark classes into `target/classes`.

## Evaluation Usage

A typical evaluation workflow is:

1. Configure a taint analyzer with `defect.InfoLeak.source` as the source and
   `defect.InfoLeak.sink` as the sink.
2. Run the analyzer on the Java source files or on the compiled classes.
3. Collect the reported source-to-sink paths.
4. Compare the reports with the ground-truth feasible and infeasible paths
   summarized above.
5. For a path-refutation tool, report how many infeasible paths are rejected
   and verify that no feasible paths are rejected.

PCBench can be used with tools that consume Java source code, bytecode, or
Maven projects. The included `ifpc.json` and `.inferconfig` files are provided
as starting points for IFPC-style tools and Infer-based experiments.

## Scope and Limitations

PCBench is a focused micro-benchmark suite. It is intended to test
path-feasibility reasoning over representative Java language features, not to
replace large real-world project evaluations.

The repository provides benchmark cases and configuration only. It does not
provide a runner, scorecard generator, or implementation of the path-refutation
algorithm from the paper.

## License

PCBench is released under the Apache License 2.0. See `LICENSE` for details.
