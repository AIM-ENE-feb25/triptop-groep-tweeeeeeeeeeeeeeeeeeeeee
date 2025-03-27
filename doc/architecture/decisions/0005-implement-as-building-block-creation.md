# 5. implement as building block creation

Date: 2025-03-27

## Status

Accepted

## Context

We needed to decide which classes are responsible for creating building blocks.

## Decision

We decided that it would make the most sense to let the service create the building blocks because the service is the first class that gets the information about building blocks from external api's.


## Consequences

There must be a method in the service class that creates an instance of the building block it receives.