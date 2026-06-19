# pcbench

pcbench is the public Java benchmark used by the paper's experimental
evaluation. It contains source-level test cases for checking whether
path-sensitive information-flow analysis can refute infeasible taint paths while
retaining feasible ones.

This repository publishes the benchmark cases and configuration only. It does
not contain the IFPC tool implementation.

## Contents

```text
.
├── src/main/java/          # Java benchmark test cases
│   ├── branch/             # branch, switch, else-if, ternary conditions
│   ├── defect/             # source/sink model
│   ├── fields/             # field and access-path cases
│   ├── general/            # arrays, casts, exceptions, polymorphism
│   ├── inter/              # inter-procedural cases
│   ├── loop/               # loop-derived constraints
│   ├── operators/          # boolean/arithmetic/comparison operators
│   ├── recursion/          # recursive helper methods
│   └── sensitivety/        # context-sensitivity cases
├── ifpc.json               # IFPC-style source/sink configuration
├── .inferconfig            # Infer/Pulse/Quandary source-sink configuration
├── pom.xml                 # Maven build file
├── LICENSE
└── README.md
```

## Benchmark Scope

The paper reports 64 test cases in total: 38 infeasible paths and 26 feasible
paths.

| Category | Infeasible paths | Feasible paths |
| --- | ---: | ---: |
| Branch | 5 | 4 |
| Field | 8 | 5 |
| Array | 1 | 1 |
| Cast | 2 | 1 |
| Exception | 1 | 1 |
| Polymorphism | 3 | 3 |
| Inter-procedural | 8 | 5 |
| Loop | 2 | 2 |
| Operator | 5 | 1 |
| Recursion | 2 | 2 |
| Sensitivity | 1 | 1 |
| Total | 38 | 26 |

## Source and Sink Model

The benchmark uses `defect.InfoLeak` as the shared source/sink model:

```java
defect.InfoLeak.source()
defect.InfoLeak.sink(String)
defect.InfoLeak.safe()
```

`ifpc.json` declares the IFPC-style rule:

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

## Build

Compile the benchmark with Maven:

```bash
mvn compile
```

The project targets Java 11 and has no third-party Maven dependencies.

## Notes

- This repository contains the pcbench test suite source code.
- The IFPC analysis tool implementation is not included here.
- The package name `sensitivety` is preserved for compatibility with the original
  benchmark paths.

## License

Apache License 2.0. See [LICENSE](LICENSE).
