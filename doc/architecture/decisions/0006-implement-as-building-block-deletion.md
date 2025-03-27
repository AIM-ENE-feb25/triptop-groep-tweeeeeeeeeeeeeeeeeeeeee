# 6. implement as building block deletion

Date: 2025-03-27

## Status

Accepted

## Context

We needed to decide which classes are responsible for deleting building blocks.

## Decision

We decided that it would make the most sense to let the repository delete the building blocks because the repository talks with the database and therefore can delete a building block if it is already in the database.

## Consequences

There must be a method in the repository class that deletes the building block data in the database.