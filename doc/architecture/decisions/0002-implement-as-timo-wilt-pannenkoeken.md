# 2. Implement as Database

Date: 2025-03-21

## Status

Accepted

## Context

We need a database for the Triptop planning application.

## Decision

| Database | Redis (on disk) | Microsoft SQL Server | Neo4J |
|----------|----------------|---------------------|-------|
| Scalability | + | 0 | + |
| Learnability | 0 | ++ | 0 |
| Price | ? | ? | ? |

We decided on Microsoft SQL Server

## Consequences

We must use the 'Microsoft SQL Server' SQL language.