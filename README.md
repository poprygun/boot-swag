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

## To Dos

[x] Remove swagger code generation - add generated classes to source tree

[x] Switch to JDK 21

[x] Add dependency on [modified version of rewrite-openapi](https://github.com/poprygun/rewrite-openapi)