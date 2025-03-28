# 4. Implement as designpattern

Date: 2025-03-27

## Status

Accepted

## Context

We need to choose a design pattern based on the following question: "Hoe kunnen we verschillende externe vervoersservices (zoals Google Maps of een veerdienst API) integreren zonder afhankelijk te worden van hun specifieke implementaties"

## Decision

We decided to use the adapter pattern to answer the question.The adapter pattern will allow us to create a concistent interface for interacting with various external services while maintaining flexibility and so reducing direct dependencies.This pattern is highly recommended pattern for this kind of question according to the refectoring guru. We also made a small application to test the adapter pattern and that proved that this pattern would be a good option to implement. 

## Consequences
 * We need to introduce an interface that defines the methods required for fetching the data

