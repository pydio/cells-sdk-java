# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Build Commands

This repo has two build files. `settings.gradle` defaults to `build-standalone.gradle` when building standalone. `build.gradle` is used when this SDK is a sub-module of `cells-android-app`.

```sh
./gradlew build                           # Compile and build
./gradlew test                            # Run unit tests (integration excluded by default)
./gradlew test -Dtest.profile=integration # Run all tests including integration tests
./gradlew publishToMavenLocal             # Publish to local Maven repo
./gradlew test --tests "com.pydio.cells.transport.StateIDTest"  # Run a single test class
```

## Architecture Overview

This is a **Java SDK for communicating with Pydio Cells (v2/v3) and legacy Pydio 8 servers** via REST/HTTP. File transfer (S3) is intentionally out of scope — only the `S3Client` interface is defined here; the implementation is provided by the calling layer (e.g., `cells-android-app`).

### Package Structure (`com.pydio.cells.*`)

- **`api`** — Core interfaces and value types: `Client`, `Transport`, `Server`, `ServerURL`, `Credentials`, `S3Client`, `SDKException`, `ErrorCodes`, `SdkNames`, `Store`
- **`api.callbacks`** — Functional callback interfaces: `NodeHandler`, `ChangeHandler`, `ProgressListener`, etc.
- **`api.ui`** — UI-layer model objects: `FileNode`, `WorkspaceNode`, `Node`, `ChangeNode`, etc.
- **`client`** — Concrete client implementations: `CellsClient`, `ClientFactory`, `P8Client`, `NoAwsS3Client`
- **`client.model`** — Rich model objects and SAX XML parsers
- **`client.security`** — TLS/crypto utilities: `CertificateTrust`, `Crypto`, `LegacyPasswordManager`
- **`openapi`** — **Swagger-generated** code. Do not manually edit. Regenerate from `cellsapi-rest-4.9.92-alpha1.swagger.yml`.
  - `openapi.api` — ~20 generated REST service APIs (`TreeServiceApi`, `ShareServiceApi`, etc.)
  - `openapi.model` — ~283 generated model classes
- **`legacy`** — Pydio 8 support: `P8Server`, `P8Transport`, `P8Credentials`, `P8Request/Response`
- **`transport`** — Cells transport implementation: `CellsTransport`, `CellsServer`, `ServerFactory`, `StateID`, `ClientData`
- **`transport.auth`** — Token/credential management: `CredentialService`, `Token`, `TokenStore`
- **`transport.auth.jwt`** — JWT parsing: `Claims`, `Header`, `IdToken`, `OAuthConfig`
- **`sync`** — Sync engine: `Merger`, `MergeState`, `Watch`
- **`sync.changes`** — Change tracking and store
- **`utils`** — Platform utilities: `Log`, `Str`, `IoHelpers`, `PathUtils`, `MemoryStore`

### Key Design Patterns

- **Interface-first:** `Client`, `Transport`, `Server`, `ServerURL`, `S3Client` are interfaces in `api`; implementations live in `transport`/`client`/`legacy`.
- **Factory pattern:** `ServerFactory` detects server type (Cells vs. P8) and instantiates the right `Transport`/`Server`.
- **Store pattern:** Generic `Store<T>` interface for persisting servers/transports — implementation provided by the calling app.
- **StateID:** Central composite key (`username + serverURL + path`) for uniquely identifying remote nodes.
- **Platform abstraction:** `Log` is an interface allowing Android vs. pure-Java implementations to differ. Every class declares `private static final String logTag`.

## Testing

- **Framework:** JUnit 4
- **Unit tests** (default): `StateIDTest`, `ServerUrlTest`, `MemoryStateManagerTest`, `RegistryTest`
- **Integration tests** (require a live server): configured via `src/test/resources/accounts/*.properties` with keys `serverURL`, `username`, `pwd`, `defaultWorkspace`, `skipVerify`, `skipServer`
- **Sandbox classes** (`DummyExample`, `ReadMeExample`, `TestRunner`): illustrative examples, not real test suites

## Build Variants

| File | Java target | Use case |
|---|---|---|
| `build-standalone.gradle` | Java 21 | Building this repo directly |
| `build.gradle` | Java 17 | Sub-module of `cells-android-app` |

The standalone build disables Javadoc generation (broken after Java 17 + Gradle 8.1 upgrade) but still publishes a sources JAR.
