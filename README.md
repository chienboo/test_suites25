# pcbench

English | [中文](#中文)

## Overview

pcbench is a benchmark test suite designed for evaluating Information Flow Path Checking (IFPC) static analysis tools. This project provides a comprehensive collection of test cases covering various Java language features and analysis scenarios.

## Project Structure

```
pcbench/
├── src/main/java/          # Test case source code
│   ├── branch/            # Branch analysis tests (short-circuit evaluation)
│   ├── defect/            # Information leak defect simulation
│   ├── fields/            # Field access analysis
│   ├── general/           # General language features
│   │   ├── arrays/        # Array operations
│   │   ├── cast/          # Type casting
│   │   ├── exception/     # Exception handling
│   │   └── polymorphism/  # Polymorphism tests
│   ├── inter/             # Inter-procedural analysis
│   ├── loop/              # Loop analysis
│   ├── operators/         # Operator analysis
│   ├── recursion/         # Recursion tests
│   └── sensitivety/       # Context sensitivity
├── pom.xml                 # Maven configuration
├── ifpc.json              # IFPC analysis configuration
└── README.md              # This file
```

## Test Categories

### Branch Analysis (`branch/`)
Tests for short-circuit evaluation in conditional statements.

### Field Analysis (`fields/`)
Tests for field access and modification operations.

### General Language Features (`general/`)
- **Arrays**: Array operations and indexing
- **Cast**: Type conversion and casting
- **Exception**: Exception handling flow
- **Polymorphism**: Inheritance and polymorphic calls

### Inter-Procedural Analysis (`inter/`)
Tests for method calls and cross-method information flow.

### Loop Analysis (`loop/`)
Tests for information flow within and across loops.

### Operator Analysis (`operators/`)
Tests for various Java operators.

### Recursion (`recursion/`)
Tests for recursive method calls.

### Context Sensitivity (`sensitivety/`)
Tests for context-sensitive analysis capabilities.

## Technology Stack

- **Language**: Java 11
- **Build Tool**: Maven
- **Analysis Tool**: IFPC (Information Flow Path Checking)

## Requirements

- Java 11 or higher
- Maven 3.6+
- IFPC static analysis tool

## Usage

### Compile the Project

```bash
mvn compile
```

### Run IFPC Analysis

```bash
java -jar ifpc-core.jar \
  --config ifpc.json \
  --default-entry \
  -fd
```

### IFPC Configuration

The `ifpc.json` file configures the analysis parameters:

```json
{
  "entries": [],
  "rules": [
    {
      "ruleName": "cmd",
      "sources": [
        "<defect.InfoLeak: java.lang.String source()>"
      ],
      "sinks": [
        "<defect.InfoLeak: void sink(java.lang.String)>"
      ]
    }
  ],
  "appPath": ".",
  "useTaintWrapper": true,
  "verbose": true,
  "writeOutput": true,
  "libPaths": [
    "./ifpc-testcase/jdk/rt.jar"
  ]
}
```

## Dependencies

This project is designed to work with IFPC static analysis tools. Key dependencies include:

- JDK runtime library (rt.jar)
- IFPC analysis framework

## Statistics

Based on analysis runs:
- **Total Test Cases**: 71
- **Categories**: 9 major categories
- **Call Graph Size**: ~747 nodes
- **Analysis Coverage**: Comprehensive coverage of Java language features

## License

[Specify your license here]

## Repository

Repository: `git@github.com:chienboo/test_suites25.git`

---

# 中文

## 项目简介

pcbench 是一个用于评估信息流路径检查（IFPC）静态分析工具的基准测试套件。本项目提供了一套全面的测试用例，涵盖了各种 Java 语言特性和分析场景。

## 项目结构

```
pcbench/
├── src/main/java/          # 测试用例源代码
│   ├── branch/            # 分支分析测试（短路求值）
│   ├── defect/            # 信息泄露缺陷模拟
│   ├── fields/            # 字段访问分析
│   ├── general/           # 通用语言特性
│   │   ├── arrays/        # 数组操作
│   │   ├── cast/          # 类型转换
│   │   ├── exception/     # 异常处理
│   │   └── polymorphism/  # 多态性测试
│   ├── inter/             # 过程间分析
│   ├── loop/              # 循环分析
│   ├── operators/         # 操作符分析
│   ├── recursion/         # 递归测试
│   └── sensitivety/       # 上下文敏感性
├── pom.xml                 # Maven 配置文件
├── ifpc.json              # IFPC 分析配置
└── README.md              # 本文件
```

## 测试类别

### 分支分析 (`branch/`)
测试条件语句中的短路求值。

### 字段分析 (`fields/`)
测试字段访问和修改操作。

### 通用语言特性 (`general/`)
- **数组 (arrays)**: 数组操作和索引
- **类型转换 (cast)**: 类型转换和强制类型转换
- **异常 (exception)**: 异常处理流程
- **多态性 (polymorphism)**: 继承和多态调用

### 过程间分析 (`inter/`)
测试方法调用和跨方法信息流。

### 循环分析 (`loop/`)
测试循环内部和跨循环的信息流。

### 操作符分析 (`operators/`)
测试各种 Java 操作符。

### 递归 (`recursion/`)
测试递归方法调用。

### 上下文敏感性 (`sensitivety/`)
测试上下文敏感分析能力。

## 技术栈

- **编程语言**: Java 11
- **构建工具**: Maven
- **分析工具**: IFPC（信息流路径检查）

## 环境要求

- Java 11 或更高版本
- Maven 3.6+
- IFPC 静态分析工具

## 使用方法

### 编译项目

```bash
mvn compile
```

### 运行 IFPC 分析

```bash
java -jar ifpc-core.jar \
  --config ifpc.json \
  --default-entry \
  -fd
```

### IFPC 配置

`ifpc.json` 文件配置了分析参数：

```json
{
  "entries": [],
  "rules": [
    {
      "ruleName": "cmd",
      "sources": [
        "<defect.InfoLeak: java.lang.String source()>"
      ],
      "sinks": [
        "<defect.InfoLeak: void sink(java.lang.String)>"
      ]
    }
  ],
  "appPath": ".",
  "useTaintWrapper": true,
  "verbose": true,
  "writeOutput": true,
  "libPaths": [
    "./ifpc-testcase/jdk/rt.jar"
  ]
}
```

## 依赖项

本项目设计用于与 IFPC 静态分析工具配合使用。主要依赖包括：

- JDK 运行时库（rt.jar）
- IFPC 分析框架

## 统计信息

基于分析运行结果：
- **测试用例总数**: 71 个
- **测试类别**: 9 个主要类别
- **调用图大小**: 约 747 个节点
- **分析覆盖率**: 全面覆盖 Java 语言特性

## 许可证

[在此指定许可证]

## 仓库地址

仓库: `git@github.com:chienboo/test_suites25.git`
