# Tool diagnosis
Diagnostic tool for relational databases.

## Project
This project is a tool to see the health of your relational database. The proposal is to highlight possible flaws and create discussions on how to resolve these highlighted problems.

## Motivation
This project is the result of two years of studies based on the Database Administration and Engineering course offered by Unicamp - State University of Campinas - SP.

## Analysis
The project has two ways of carrying out the evaluation process, which are:

Percentage of null fields per record.
Field density by table.


| Metric | Description | 
|----------|----------|
|Percentage of null fields per record|This metric evaluates the proportion of null fields in relation to the total number of fields in each record in the table. This can help identify missing data patterns and potential integrity issues.|
|Field density by table|This metric measures the average number of fields per table in the database. A high field density may indicate excessive complexity in the table structure, which may negatively impact the efficiency of queries and maintenance operations.|

