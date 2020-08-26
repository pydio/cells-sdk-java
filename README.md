# Cells SDK for Java

## Getting started

The Pydio Cells Java SDK provides a Java implementation to communicate with a Pydio Cells server (and also with the legacy Pydio 8+ versions). Most of the functions are wrapped into the `com.pydio.sdk.core.Client` class that contains methods to easily manage your files on a Cells server.

## Build

We use gradle as a build and publication tool and we ship the wrapper with the code, simply use `./gradlew <your command>` from within the root folder of the repository.

Main version of the code is maintained for the time being in the main `build.gradle` file.

Useful commands:

```sh
# Build the project
./gradlew build

# Publish to local maven repo
./gradlew publishToMavenLocal

# Publish a release to bintray for public exposure

# IMPORTANT: First update version number in main build.gradle file.

# TODO do this automatically via build agent
# Retrieve your username and key and then:
gradle bintrayUpload -Dbintray.user=$UNAME -Dbintray.key=$UKEY
# you can also define corresponding variable in a local.properties file => simply adapt and rename the provided local.properties.sample file and then do
gradle bintrayUpload
```

## Configure and resolve a Cells server

Given an URL, we create a ServerNode object to load the server info

```java
String url = "https://pydio.example.com";
ServerNode node = new ServerNode();
Error error = node.resolve();
if (error != null) {
    // error.code could be one of:
    // Code.ssl_error
    // Code.pydio_server_not_supported
    // Code.con_failed
    // Code.ssl_certificate_not_signed
    System.out.println("failed to resolve server");
    return;
}

System.out.println("version: " + server.getVersion());
System.out.println("version name: " + server.getVersionName());
```

## Working with the Pydio client

### Instantiate a Pydio Client

To create a client pass the resolved server to the client factory

```java
Client client = Client.get(node);
```

### Setting user credentials

```java
Credentials credentials = new DefaultCredentials("login", "password");
client.setCredentials(credentials);
```

### Performing folder list

```java
// Listing the root of the "My Files" workspace
try {
    client.ls("my-files", "/", (n) -> {
        System.out.println(n.label());
    });
} catch(SDKexception e) {
    e.printStackTrace();
    Error error = Error.fromException(e)
    // error.code could be one of:
    // Code.ssl_error or
    // Code.pydio_server_not_supported
    // Code.con_failed
    // Code.ssl_certificate_not_signed
}
```

## Examples

Find more examples in [our sample package](./tree/master/src/main/java/com/pydio/sdk/examples).

## For buidler / maintainer only

We use [swagger-codegen]() to generate the java client.

_**WARNING:** This is work in progress, in order to regain control on the generation of the SDK from the swagger spec_

For the time being, we rather clone the repository in a temp location to generate the new version of the code and then replace the `com.pydio.sdk.core.api.cells` package in the local repository, to avoid polluting the main repo with autogenrated files (gradle, doc, config files...)

```sh
mkdir -p /tmp/forSwagger
cd /tmp/forSwagger
git clone https://bsinou@github.com/pydio/cells-sdk-java.git

cd cells-sdk-java

# Retrieve swagger jar
SWAGGER_VERSION=2.4.15
wget https://oss.sonatype.org/content/repositories/releases/io/swagger/swagger-codegen-cli/${SWAGGER_VERSION}/swagger-codegen-cli-${SWAGGER_VERSION}.jar
mv swagger-codegen-cli-${SWAGGER_VERSION}.jar swagger-codegen-cli.jar

java -jar swagger-codegen-cli.jar generate -l java -i https://raw.githubusercontent.com/pydio/cells/stable/common/proto/rest/rest.swagger.json  --api-package com.pydio.sdk.core.api.cells.api   --invoker-package com.pydio.sdk.core.api.cells --model-package com.pydio.sdk.core.api.cells.model

rm -rf $GIT_PATH/github.com/pydio/cells-sdk-java/src/main/java/com/pydio/sdk/core/api/cells

cd $GIT_PATH/github.com/pydio/cells-sdk-java/src/main/java/com/pydio/sdk/core/api/
mv /tmp/forSwagger/cells-sdk-java/src/main/java/com/pydio/sdk/core/api/cells .

```
