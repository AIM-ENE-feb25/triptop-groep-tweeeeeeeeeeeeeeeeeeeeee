package nl.han.soex.twee.prototype.domain;

import java.time.OffsetDateTime;

public record TrainTrip(double price, OffsetDateTime plannedDepartureDateTime, OffsetDateTime plannedArrivalDateTime) implements BuildingBlock {
}
