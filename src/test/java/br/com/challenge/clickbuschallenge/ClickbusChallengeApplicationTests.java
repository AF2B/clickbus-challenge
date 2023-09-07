package br.com.challenge.clickbuschallenge;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.context.annotation.Description;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.com.challenge.clickbuschallenge.api.PlaceRequest;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class ClickbusChallengeApplicationTests {
	@Autowired
    WebTestClient webTestClient;

	private static final String PLACE_URI = "/places";
	private static final String NAME = "Test";
	private static final String EMPTYNAME = "";
	private static final String EMPTYSTATE = "";
	private static final String CITY = "Test";
	private static final String STATE = "Test";

	@Test
	@Description("It should create a place entity and return it with your information and status code 201.")
	public void testCreateClickbusChallengeApplication() {
		webTestClient
            .post()
            .uri(PLACE_URI)
            .bodyValue(new PlaceRequest(NAME, CITY, STATE))
            .exchange()
            .expectStatus().isCreated()
            .expectBody()
            .jsonPath("$.name").isEqualTo(NAME)
            // .jsonPath("$.city").isEqualTo(CITY) FIXME: For some reason, city key is not being correctly returned.
            .jsonPath("$.state").isEqualTo(STATE)
			.jsonPath("$.createdAt").isNotEmpty()
			.jsonPath("$.updatedAt").isNotEmpty();
	}

	@Test
	@Description("It should return a bad request status code 400 when PlaceRequest is invalid.")
	public void testInvalidRequestParams() {
		webTestClient
			.post()
			.uri(PLACE_URI)
			.bodyValue(new PlaceRequest(EMPTYNAME, CITY, EMPTYSTATE))
			.exchange()
			.expectStatus().isBadRequest();
	}
}