package br.com.challenge.clickbuschallenge.web;

import br.com.challenge.clickbuschallenge.api.PlaceResponse;
import br.com.challenge.clickbuschallenge.domain.Place;

public class PlaceMapper {
    public static PlaceResponse toResponse(Place place) {
        return new PlaceResponse(
            place.name(),
            place.city(),
            place.state(),
            place.createdAt(),
            place.updatedAt()
        );
    }
}
