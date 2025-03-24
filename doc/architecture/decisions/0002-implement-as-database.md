# 2. Implement as Database

Date: 2025-03-21

## Status

Accepted

## Context

We need a database for the Triptop planning application. We expect it to handle 10.000 queries per minute.

## Decision

| Database           | Redis (on disk) | Microsoft SQL Server | Neo4J |
|--------------------|----------------|----------------------|------|
| Scalability        | +              | 0                    | +    |
| Learnability       | 0              | ++                   | 0    |
| Performance        | +              | ++                   | 0    |
| Price              | +              | --                   | -    |
| Communitiy Support | 0              | ++                   | 0    |

We decided on Microsoft SQL Server. We took into account that the development team has preexisting knowledge of Microsoft SQL Server, thus saving a significant amount of work by choosing it, which makes it very attractive as the development is under tight time constraints

## Consequences

We must use the 'Microsoft SQL Server' SQL language.
Integration with other Microsoft technologies and tools will be simplified.