package br.com.challenge.clickbuschallenge.api;

import java.time.LocalDateTime;

public record PlaceResponse(
    String name, 
    String city,
    String state,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
    ) {
}
