package org.devnexus.function;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = "spring.main.web-application-type=servlet")
class WebFunctionTests {
	
	@Autowired
	private TestRestTemplate resetTemplate;

	/*
	 * This test assumes you have a function of the following signature 'Function<String, String> test()'
	 * which uppercases a String. hte main point of this test is that a function is invoked and tested as an HTTP endpoint
	 * using Spring Cloud Function, 
	 * so please modify the test and assertion to fit yoru actual function. 
	 */
	@Test
	void validateFunctionViaWeb() throws Exception {
		ResponseEntity<String> result = this.resetTemplate.exchange(
				RequestEntity.post(new URI("/uppercase")).body("hello devnexus"), String.class);
		assertThat(result.getStatusCode()).isEqualTo(HttpStatus.OK);
		System.out.println(result.getBody());
		assertThat(result.getBody()).isEqualTo("HELLO DEVNEXUS");
	}

}
