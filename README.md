# barnacle-generator-test

Automatic integration tests for [Barnacle](https://github.com/arthurpicht/Barnacle) generator functionality.

See repo [barnacle-runtime-test](https://github.com/arthurpicht/barnacle-runtime-test) for integration tests for Barnacle execution functionality.

## Tests

### test group 01: basic functionality

* **TC_01**: Simple entity with simple primary key, smoke test
* **TC_02**: composite primary key, custom table name
* **TC_03**: mapping of basic an object types
* **TC_04**: auto increment fields
* **TC_05**: unique key
* **TC_06**: unique key composite
* **TC_07**: custom type
* **TC_08**: cloneable

### test group 02: 1-to-1 relationship

* **TC_01**: 1:1-relationship, PK-to-PK, single PK key field
* **TC_02**: 1:1-relationship, PK-to-PK, composite PK keys
* **TC_03**: 1:1-relationship, UK-toPK, single PK key field
* **TC_04**: 1:1-relationship, UK-toPK, composite PK keys

### test group 03: n-to-m relationship

* **TC_01**: n:m-relationship, association table, single PK fields on both related entities
* **TC_02**: n:m-relationship, association table, single PK field on one entity, composite PK fields on other entities
* **TC_03**: n:m-relationship, association table, composite PK fields on both entities

## What is tested?

Execution of test cases causes DAOs, VOs and database schema (H2 dialect) to be generated.

* Schema generation is tested against specified expectations.
* Generated VOs and DAOs are tested against expected code

Execution all tests successfully is a precondition for executing tests included in project [barnacle-runtime-test](https://github.com/arthurpicht/barnacle-runtime-test).

## Updating expected results

After changing barnacle and its generated code intentionally, expected results for VOs and DAOs can be updated using
the utility class *CopyExpected*, which copies current generator results to expected code files.
