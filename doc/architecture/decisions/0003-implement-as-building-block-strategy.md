# 3. Implement as building block strategy

Date: 2025-03-27

## Status

Accepted

## Context

We need a stategy for managing building blocks in the backend. The backend also needs to communicate data from building blocks to external api's.

## Decision

| Criteria | Interface | Abstract Class | Parent Class | No Parent |
|----------|-----------|----------------|--------------|-----------|
| Multiple inheritance | + | - | - | 0 |
| Duplicate code | 0 | + | ++ | -- |
| Testing complexity | ++ | - | -- | 0 |
| Flexibility | ++ | 0 | - | + |

We decided to use an interface for the building blocks. Mainly because it keeps the code flexible and allows us to add new API's without breaking existing code.

## Consequences

The team needs to put some effort into understanding implementation patterns