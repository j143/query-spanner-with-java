# query-spanner-with-java

## Create Database

Reference: https://cloud.google.com/spanner/docs/schema-and-data-model


Songs table:

```sql
CREATE TABLE Songs {
  SongId INT64 NOT NULL,
  Title STRING(1024),
  Year INT64,
  Peak INT64
} PRIMARY KEY (SongId);
```

Singers table:

```sql
CREATE TABLE Singers (
  SingerId   INT64 NOT NULL,
  FirstName  STRING(1024),
  LastName   STRING(1024),
  SingerInfo BYTES(MAX),
) PRIMARY KEY (SingerId);
```

## Maven project

Generate empty maven project. Refer https://maven.apache.org/guides/getting-started/index.html

```sh
mvn -B archetype:generate \
  -DarchetypeGroupId=org.apache.maven.archetypes \
  -DgroupId=page.janardhan.labs \
  -DartifactId=spanner-with-java
```


Refer:

0. https://cloud.google.com/spanner/docs/getting-started/java
1. https://cloud.google.com/spanner/docs/adding-spring
2. https://cloud.google.com/appengine/docs/standard/java11/specifying-dependencies

Add dependencies to the `pom.xml`

```xml
<dependency>
      <groupId>com.google.cloud</groupId>
      <artifactId>google-cloud-spanner</artifactId>
      <version>6.5</version>
    </dependency>

    <!-- Google core libraries for Java 
      https://search.maven.org/artifact/com.google.guava/guava/30.1.1-jre/bundle -->
    <dependency>
      <groupId>com.google.guava</groupId>
      <artifactId>guava</artifactId>
      <version>30.1.1-jre</version>
      <type>bundle</type>
    </dependency>

    <!-- Google OAUTH library http
      https://search.maven.org/artifact/com.google.auth/google-auth-library-oauth2-http/0.26.0/jar -->
    <dependency>
      <groupId>com.google.auth</groupId>
      <artifactId>google-auth-library-oauth2-http</artifactId>
      <version>0.26.0</version>
    </dependency>
```

Add Maven assembly and compiler plugins.


## Testing

https://cloud.google.com/spanner/pricing

| #  | Component | price |
| -- | -- | -- |
| 1. | Nodes  | $0.90 /node/hour (europe-west1) |
| 2. | Database storage | $0.33 /GB/month |
| 3. | Backup storage | $0.30 /GB/month |
| 4. | Network | Free in the same region |

Cloud Spanner emulator can be used for testing.

## Usage

```sh
java -jar spanner-with-java/target/spanner-with-java-1.0-SNAPSHOT-jar-with-dependencies.jar
```
