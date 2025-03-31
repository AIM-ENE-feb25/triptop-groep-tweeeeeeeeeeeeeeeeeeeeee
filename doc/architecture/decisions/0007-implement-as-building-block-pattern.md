# 7. Implement as building block strategy

Date: 2025-03-28

## Status

Accepted

## Context

We are looking into a structural software engineering pattern for managing building blocks in the backend. Every building block is slightly different and has a different use case. We need something that caters to each building block's needs. It should be flexible and contain little duplicate code. The backend also needs to communicate data from building blocks to external api's.

## Decision

We decided to try the Facade design pattern, mainly because it keeps the code flexible and allows us to add new APIs without breaking existing code. We also considered the Adapter design pattern, but the refactoring.guru site points out that the design pattern Adapter is better suited if we had one building block instead of multiple.

However, we decided to not use the Facade design pattern. The prototypes, a class diagram and small java application, clearly showed no decrease in complexity by applying the pattern. It actually slightly increased complexity.

Due to time constraints the only other alternative is no pattern. Thus we have decided to use no pattern.

## Consequences

Code without a pattern could be suboptimal and might not be as easy to understand