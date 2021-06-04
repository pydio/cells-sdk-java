# Cells SDK for Java

## Getting started

The Pydio Cells Java SDK provides a Java implementation to communicate with a Pydio Cells server (and also with the legacy Pydio 8+ versions). Most of the functions are wrapped into the `com.pydio.cells.api.Client` class that contains methods to easily manage your files on a Cells server.

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

```
String url = "https://pydio.example.com";
ServerNode node = new ServerNode();
Error error = node.resolve();
if (error != null) {
    // error.code could be one of:
    // ErrorCodes.ssl_error
    // ErrorCodes.pydio_server_not_supported
    // ErrorCodes.con_failed
    // ErrorCodes.ssl_certificate_not_signed
    System.out.println("failed to resolve server");
    return;
}

System.out.println("version: " + server.getVersion());
System.out.println("version name: " + server.getVersionName());
```

## Working with the Pydio client

### Instantiate a Pydio Client

To create a client pass the resolved server to the client factory

```
Client client = Client.get(node);
```

### Setting user credentials

```
Credentials credentials = new DefaultCredentials("login", "password");
client.setCredentials(credentials);
```

### Performing folder list

```
// Listing the root of the "My Files" workspace
try {
    client.ls("my-files", "/", (n) -> {
        System.out.println(n.label());
    });
} catch(SDKexception e) {
    e.printStackTrace();
    Error error = Error.fromException(e)
    // error.code could be one of:
    // ErrorCodes.ssl_error or
    // ErrorCodes.pydio_server_not_supported
    // ErrorCodes.con_failed
    // ErrorCodes.ssl_certificate_not_signed
}
```

## Examples

Find more examples in [our sample package](./tree/master/src/main/java/com/pydio/sdk/examples) and in the [tests](./tree/master/src/test/java/com/pydio/cells).

## References

A list of random resources on the _WWW_ that have helped along the way and are kept here for reference.

- A [must read](https://auth0.com/docs/flows/call-your-api-using-the-authorization-code-flow) to understand how we manage authentication when target remote server is a Pydio Cells instance.

## Legacy note

This repository has been forked from [this legacy repo in Pydio's code base](https://github.com/pydio/pydio-sdk-java-v2).



