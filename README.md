# ms-spring-boot-template
This archetype will create a project with:
- [Spring Boot 2.4.4](https://spring.io/blog/2021/03/18/spring-boot-2-4-4-available-now)
- [Java 11](https://openjdk.java.net/projects/jdk/11/)
- [OpenFeign](https://spring.io/projects/spring-cloud-openfeign)
- [Swagger UI](https://swagger.io/docs/open-source-tools/swagger-ui/usage/installation/) in container
- [JUnit 5](https://junit.org/junit5/) and [Mockito](https://site.mockito.org/)
- [Wiremock using Junit 5](http://wiremock.org/docs/spring-boot/)

and java source code format is using [google-java-format](https://github.com/google/google-java-format) to comply with [Google Java Style](https://google.github.io/styleguide/javaguide.html).

## How to use
Clone the project:
```
$ git clone git@github.com:valdemarjuniorr/spring-boot-maven-archetype.git
```
in the same folder the command was executed:
```
$ cd spring-boot-maven-archetype
$ mvn install
```
and then to creating a new Spring Boot project is easy as ever. Simply copy the command below:
```
$ mvn archetype:generate -B -DarchetypeArtifactId=ms-spring-boot-template \
  -DarchetypeGroupId=com.valdemarjuniorr \
  -DgroupId={GROUP_ID} \
  -DartifactId={ARTIFACT_ID}
```
change **GROUP_ID** and **ARTIFACT_ID** and run. The project it will be generated in current folder.
