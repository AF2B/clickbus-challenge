package br.com.challenge.clickbuschallenge.domain;

import br.com.challenge.clickbuschallenge.api.PlaceRequest;
import reactor.core.publisher.Mono;

public class PlaceService {
    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    private PlaceRepository placeRepository;

    public Mono<Place> create(PlaceRequest placeRequest) {
        var place = new Place(
            null,
            placeRequest.name(),
            placeRequest.city(),
            placeRequest.state(),
            null,
            null,
            null
        );
        return placeRepository.save(place);
    }
}
