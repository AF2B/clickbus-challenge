package br.com.challenge.clickbuschallenge.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing;

import br.com.challenge.clickbuschallenge.domain.PlaceRepository;
import br.com.challenge.clickbuschallenge.domain.PlaceService;

@Configuration
@EnableR2dbcAuditing
public class PlaceServiceConfig {
    @Bean
    PlaceService placeService(PlaceRepository placeRepository) {
        return new PlaceService(placeRepository);
    }
}
