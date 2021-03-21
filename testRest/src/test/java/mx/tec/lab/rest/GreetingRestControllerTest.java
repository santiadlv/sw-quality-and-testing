package mx.tec.lab.rest;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest
class GreetingRestControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void givenAHelloRequest_whenEmptyName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
	@Test
	public void givenAHelloRequest_whenProvidedName_thenHelloName() throws Exception {
		this.mockMvc.perform(get("/greeting?name=Travis"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, Travis!")));
	}
	
	@Test
	public void givenAHelloRequest_whenNullName_thenHelloWorld() throws Exception {
		this.mockMvc.perform(get("/greeting?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Hello, World!")));
	}
	
	@Test
	public void givenAGoodbyeRequest_whenEmptyName_thenGoodbyeWorld() throws Exception {
		this.mockMvc.perform(get("/goodbye"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, World!")));
	}
	
	@Test
	public void givenAGoodbyeRequest_whenProvidedName_thenGoodbyeName() throws Exception {
		this.mockMvc.perform(get("/goodbye?name=Rocky"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, Rocky!")));
	}
	
	@Test
	public void givenAGoodbyeRequest_whenNullName_thenGoodbyeWorld() throws Exception {
		this.mockMvc.perform(get("/goodbye?name="))
			.andExpect(status().isOk())
			.andExpect(jsonPath("content", equalTo("Goodbye, World!")));
	}
	
	@Test
	public void givenARequest_whenWrongURL_thenError404() throws Exception {
		this.mockMvc.perform(get("/badRoute"))
			.andExpect(status().isNotFound());
	}
}
