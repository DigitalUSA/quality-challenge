# Code delivery report

- _Prepared by_: Questionable Quality Consulting
- _Prepared for_: Questionable Quality Software
- _Date_: May 5, 2005
- _Content_: Final delivery report

We want to thank Questionable Quality Software for the opportunity to work with them in this prohect. I would like to highlights the level of quality that this progect has managed to deliver:

- _Code Coverage_: 99.61%
- _Defects_: 0
  - _Blocker_: 0
  - _Critical_: 0
  - _Major_: 0
  - _Minor_: 0
  - _Info_: 0
- _Static analysis issues_: 0
- _Test pass rate_: 100%
- _Test cases_: Approaching 50

Our industry leading results of **99.61%** coverage, a testing pass rate of **100%** and **0** defetcts is something my team is increadible proud of. In addition the majority of classes have code coverage of **100%**!!.

## Required software install

- git
- maven 3.x
- jdk 1.8

## Directory structure

- `quality-challenge-api` contains the APIs OpenAPI defintion along with the server codegen.
- `quality-challenge-code` contains the implementation code for the solution

## Building

Form the top level directory:

```bash
mvn clean install
```

Extensive debugging information is available int he supplied sources, simply remove the commented out lines starting with `//`

## Location of files

- OpenAPI definition is at `quality-challenge-api/src/main/resources/api.yaml`
- The jacoco report is at `quality-challenge-code/target/site/jacoco-ut/index.html`
- The PMD report is at `quality-challenge-code/target/pmd.xml`

## Algorithms used:

We deciding to deliver an extensive utility to support the requirements. As part of that library we utilized the approach outlined at [https://www.cdn.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon](https://www.cdn.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon) At no extra charge we have including substandard fixes to address defects that occur when the point being validated and the imaginary point interest with an end of a polygons edges.