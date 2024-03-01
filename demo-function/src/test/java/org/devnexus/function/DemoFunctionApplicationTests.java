package org.devnexus.function;

import java.util.function.Function;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.function.context.FunctionCatalog;

@SpringBootTest
class DemoFunctionApplicationTests {
	
	@Autowired
	private FunctionCatalog functionCatalog;

	@Test
	void contextLoads() {
		Function<String, String> upercase = functionCatalog.lookup("uppercase");
		System.out.println(upercase.apply("oleg"));
	}

}
