package br.com.challenge.clickbuschallenge.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.challenge.clickbuschallenge.api.PlaceRequest;
import br.com.challenge.clickbuschallenge.api.PlaceResponse;
import br.com.challenge.clickbuschallenge.domain.PlaceService;
import jakarta.validation.Valid;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@Valid @RequestBody PlaceRequest requestParams) {
        if (requestParams.name().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Mono.error(new IllegalArgumentException("Name is required")));
        }
        if (requestParams.city().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Mono.error(new IllegalArgumentException("City is required")));
        }
        if (requestParams.state().isBlank()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Mono.error(new IllegalArgumentException("State is required")));
        }
        var responsePlace = placeService.create(requestParams).map(PlaceMapper::toResponse);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(responsePlace);
    }
}
