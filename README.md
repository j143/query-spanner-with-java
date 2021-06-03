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


