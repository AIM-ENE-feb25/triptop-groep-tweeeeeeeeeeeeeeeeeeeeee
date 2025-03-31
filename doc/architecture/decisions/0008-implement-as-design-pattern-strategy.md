# 8. implement as design pattern strategy

Date: 2025-03-28

## Status

Accepted

## Context

We need to choose a design pattern for how we will implement the delegation of advice strategies. Advice is given to the traveler based upon data received by the api

## Alternative

An alternative is not doing any pattern for this use case.

## Decision

We decided upon the design pattern strategy for this use case. This will allow us to easily switch between the different building blocks. 
We also made a testing application and that proved that this strategy would be a viable option and according too refactoring guru this pattern is preferential for this use case. 

## Consequences

there are multiple strategies that have one superclass that can be used to call advice from all the children