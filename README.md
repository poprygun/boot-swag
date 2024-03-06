# Demonstrate Spring Boot upgrade using OpenRewrite in combination with Swagger to OpenAPI migration



## Publish customized version of open-rewrite plugin locally

```bash
git clone git@github.com:poprygun/rewrite-openapi.git

cd rewrite-openapi

./gradlew clean build publishToMavenLocal
```

## Upgrade Spring Boot

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:dryRun \
    -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-spring:RELEASE \
    -Drewrite.activeRecipes=org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
```

## Upgrade Swagger - Order is important here!

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:run \
    -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-openapi:0.1.0-SNAPSHOT \
    -Drewrite.activeRecipes=org.openrewrite.openapi.swagger.SwaggerToOpenAPI,com.bc.openrewrite.sb.OpenApiSpringBoot3Dependencies
```

## Optimize imports.  This works before we cleanup dependencies

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:run \
    -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-openapi:0.1.0-SNAPSHOT \
    -Drewrite.activeRecipes=org.openrewrite.java.RemoveUnusedImports
```

## Upgrade dependencies

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:run \
    -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-openapi:0.1.0-SNAPSHOT \
    -Drewrite.activeRecipes=org.openrewrite.openapi.swagger.UpgradeOpenApiDependencies
```

