# CLAUDE.md

This file provides guidance for Claude Code when working with this repository.

## Project Overview

This is a **PlanDev Mission Model Template** for NASA's PlanDev framework. It provides scaffolding for building mission models and scheduling/constraint procedures that can be uploaded to PlanDev.

## Project Structure

```
├── missionmodel/          # Core mission model code
│   ├── src/main/java/     # Mission model source (Mission.java, Configuration.java)
│   ├── src/test/java/     # Unit tests
│   └── examples/          # Example activities and models
├── scheduling/            # Scheduling procedures
│   ├── src/main/java/     # Scheduling procedure source
│   └── examples/          # Example scheduling procedures
├── constraints/           # Constraint procedures
│   ├── src/main/java/     # Constraint procedure source
│   └── examples/          # Example constraint procedures
├── docker-compose.yml     # Full PlanDev stack for local development
└── third-party/           # Local JAR dependencies
```

## Build Commands

### Mission Model
```sh
./gradlew :missionmodel:build --refresh-dependencies
```
Output: `missionmodel/build/libs/missionmodel.jar`

### Scheduling Procedures
```sh
./gradlew scheduling:build
./gradlew scheduling:buildAllProcedureJars
```
Output: `scheduling/build/libs/<ProcedureName>.jar`

### Constraint Procedures
```sh
./gradlew constraints:build
./gradlew constraints:buildAllProcedureJars
```
Output: `constraints/build/libs/<ProcedureName>.jar`

### Run Tests
```sh
./gradlew :missionmodel:test
```

## Prerequisites

- **Java**: OpenJDK Temurin 21 (toolchain configured in build.gradle)
- **GitHub Token**: Required for downloading PlanDev Maven packages
  - Create a personal access token with `read-packages` scope
  - Copy `.env.template` to `.env` and fill in `GITHUB_USER` and `GITHUB_TOKEN`

## Key Dependencies

Maven packages from `gov.nasa.jpl.plandev`:
- `merlin-framework` - Core simulation framework
- `merlin-sdk` - SDK interfaces
- `contrib` - Common utilities and mappers
- `merlin-driver` - Simulation driver
- `merlin-framework-junit` - Test support

Procedural libraries from `gov.nasa.ammos.plandev.procedural`:
- `scheduling` - Scheduling procedure support
- `constraints` - Constraint procedure support
- `timeline` - Timeline utilities
- `processor` - Annotation processor for procedures

## Docker Development

Start the full PlanDev stack:
```sh
docker-compose up -d
```

Services:
- **UI**: http://localhost:80
- **Hasura GraphQL**: http://localhost:8080
- **Gateway**: http://localhost:9000

## Key Files

- `missionmodel/src/main/java/missionmodel/package-info.java` - Model annotations and configuration
- `missionmodel/src/main/java/missionmodel/Mission.java` - Main model class
- `missionmodel/src/main/java/missionmodel/Configuration.java` - Model configuration
- `build.gradle` - Root build config with PlanDev version management
- `.env.template` - Environment variables template

## Development Workflow

1. Define resources and activities in the mission model
2. Build the mission model JAR
3. Upload to PlanDev via UI or API
4. Create scheduling/constraint procedures referencing your activity types
5. Build procedure JARs and upload to PlanDev

## Notes

- The template model has no registered activities by default
- Apply `complete-model-tutorial.patch` for a working example model
- Procedure JARs require a completed mission model with registered activities
