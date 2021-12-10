package com.bae.playlist.web;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.bae.playlist.domain.Playlist;
import com.fasterxml.jackson.databind.ObjectMapper;

// Boots the entire context - random port to avoid collisions
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc // sets up the MockMVC object
@Sql(scripts = { "classpath:playlist-schema.sql",
"classpath:playlist-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)

public class PlaylistControllerIntegrationTest {

	@Autowired // pulls the MockMVC object from the context
	private MockMvc mvc; // class that performs the request (kind of postman equivalent)
	
	@Autowired
	private ObjectMapper mapper;
	
	@Test
	void testCreate() throws Exception {
		Playlist testPlay = new Playlist(null, "sampletitle", "sampleartist", 245, "samplealbum");
		String testPlayAsJSON = this.mapper.writeValueAsString(testPlay);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testPlayAsJSON);

		Playlist testCreatedPlay = new Playlist(2, "sampletitle", "sampleartist", 245, "samplealbum");
		String testCreatedPlayAsJSON = this.mapper.writeValueAsString(testCreatedPlay);
		ResultMatcher checkStatus = status().isCreated(); // is status 201 - created
		ResultMatcher checkBody = content().json(testCreatedPlayAsJSON); // does the body match my testCreatedPlayAsJSON

		// sends request - checks the status - checks the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void testCreate2() throws Exception {
		Playlist testPlay = new Playlist(null, "sampletitle", "sampleartist", 245, "samplealbum");
		String testPlayAsJSON = this.mapper.writeValueAsString(testPlay);
		RequestBuilder req = post("/create").contentType(MediaType.APPLICATION_JSON).content(testPlayAsJSON);

		Playlist testCreatedPlay = new Playlist(2, "sampletitle", "sampleartist", 245, "samplealbum");
		String testCreatedPlayAsJSON = this.mapper.writeValueAsString(testCreatedPlay);
		ResultMatcher checkStatus = status().isCreated(); // is status 201 - created
		ResultMatcher checkBody = content().json(testCreatedPlayAsJSON); // does the body match my testCreatedPlayAsJSON

		// sends request - checks the status - checks the body
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	void getAllTest() throws Exception {
		List<Playlist> testPlay = List.of(new Playlist(1, "songtitle", "songartist", 100, "songalbum"));
		String testPlayAsJSON = this.mapper.writeValueAsString(testPlay);
		
		RequestBuilder req = get("/getAll");
		ResultMatcher checkStatus = status().isOk();
		ResultMatcher checkBody = content().json(testPlayAsJSON); 

		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
		
	}
	
}



