# Demonstrate Spring Boot upgrade using OpenRewrite.

## Upgrade Swagger

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:dryRun \
  -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-openapi:0.1.0-SNAPSHOT \
  -Drewrite.activeRecipes=org.openrewrite.openapi.swagger.SwaggerToOpenAPI
```

## Upgrade Spring Boot

```bash
./mvnw -U org.openrewrite.maven:rewrite-maven-plugin:run \
  -Drewrite.recipeArtifactCoordinates=org.openrewrite.recipe:rewrite-spring:RELEASE \
  -Drewrite.activeRecipes=org.openrewrite.java.spring.boot3.UpgradeSpringBoot_3_2
```