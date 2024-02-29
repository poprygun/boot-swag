# Demonstrate Swagger API upgrade using [rewrite-openapi](https://github.com/openrewrite/rewrite-openapi)

Current version of the rewrite-openapi gradle plugin has limited support for some annotation parameters.
Plugin was extended due to missing features [with my version](https://github.com/poprygun/rewrite-openapi)

Features added:

- `@ApiResponse(code = 200, message = "successful operation", response = Donut.class, responseContainer = "List")`, responseContainer
  and response has to be substituted as follows `@ApiResponse(content = @io.swagger.v3.oas.annotations.media.Content(array = @io.swagger.v3.oas.annotations.media.ArraySchema(uniqueItems = false, schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = org.openrewrite.openapi.swagger.Donut.class))))})`


## Use Open Rewrite Plugin to upgrade Swagger 1.x to 2.x to be compatible with Open API

Dry run to show what recipes are applied

```bash
./mvnw rewrite:dryRun
```

Execute to apply recipes

```bash
./mvnw rewrite:run
```

Alternatively if you don't want to modify pom

Make sure to add snapshot repository reference to `.m2/settings.xml` as plugin may depend on snapshot dependencies

```xml
<settings xmlns="http://maven.apache.org/SETTINGS/1.0.0"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.0.0 https://maven.apache.org/xsd/settings-1.0.0.xsd">
    <profiles>
        <profile>
            <id>allow-snapshots</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <repositories>
                <repository>
                    <id>snapshots-repo</id>
                    <url>https://oss.sonatype.org/content/repositories/snapshots</url>
                    <releases>
                        <enabled>false</enabled>
                    </releases>
                    <snapshots>
                        <enabled>true</enabled>
                    </snapshots>
                </repository>
            </repositories>
        </profile>
    </profiles>
</settings>
```

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:dryRun \
  -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-openapi:0.1.0-SNAPSHOT \
  -Drewrite.activeRecipes=org.openrewrite.openapi.swagger.SwaggerToOpenAPI
```

## Search recipes to find source code types, annotations, etc

Configuration is defined in rewrite.yml

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:run \
  -Drewrite.activeRecipes=com.bc.openrewrite.sb.FindChcsDependencies
```
## To Dos

[x] Remove swagger code generation - add generated classes to source tree

[x] Switch to JDK 21

[x] Add dependency on [modified version of rewrite-openapi](https://github.com/poprygun/rewrite-openapi)
