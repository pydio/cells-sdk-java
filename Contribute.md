# Developer Corner

We gather here info and tips for curret and future developers of the Java SDK.

## Regenerate the SDK

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

## Developer Tips

### Various

- We use git submodules to ease dayto day see [this interesting post](https://blog.bitsrc.io/how-to-utilize-submodules-within-git-repos-5dfdd1c62d09)

### Temporary Tips

#### For refactoring

- We might want to change the package that is used by the swagger generated model and rename packages in a future proof way. We will go trough a temporar phase where we put generated methods at 2 distinct locations while deprecating the legacy one. Some solution can be found in [this stackoverflow question](https://stackoverflow.com/questions/5074454/what-is-the-clearest-way-to-deprecate-a-package-in-java).
