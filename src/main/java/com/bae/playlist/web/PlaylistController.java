package com.bae.playlist.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bae.playlist.domain.Playlist;
import com.bae.playlist.service.PlaylistService;



@RestController // tells Spring this is a controller
				// REST compliant

public class PlaylistController {
	
	private PlaylistService service;
	
	@Autowired 	// tells Spring to fetch the DinoService from the context
				// Dependency Injection
	public PlaylistController(PlaylistService service) {
	super();
	this.service = service;
	}
	
	@GetMapping("/helloWorld")	// endpoint
	public String hello() {
		return "Hello, World!";
	}
	
// CREATE
	@PostMapping("/create")
	public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist play) {
		Playlist created = this.service.createPlaylist(play);
		ResponseEntity<Playlist> response = new ResponseEntity<Playlist>(created, HttpStatus.CREATED);
		return response;
	}
		
// READ ALL
	@GetMapping("/getAll")
	public ResponseEntity<List<Playlist>> getAllPlays() {
		return ResponseEntity.ok(this.service.getAllPlays());
	}

// READ BY ID	
	@GetMapping("/get/{id}")
	public Playlist getPlay(@PathVariable Integer id) {
		return this.service.getPlay(id);
	}
	
// READ BY TITLE	
	@GetMapping("/getByTitle/{title}")
	public ResponseEntity<List<Playlist>> getPlaylistByTitle(@PathVariable String title) {
		List <Playlist> found = this.service.getAllPlaysByTitle(title);
		return ResponseEntity.ok(found);
		}
	                                                                              

// UPDATE BY ID	
	@PutMapping("/replace/{id}")
	public ResponseEntity<Playlist> replacePlay(@PathVariable Integer id, @RequestBody Playlist newPlay) {
		Playlist body = this.service.replacePlay(id, newPlay);
		ResponseEntity<Playlist> response = new ResponseEntity<Playlist>(body, HttpStatus.ACCEPTED);
		return response;
	}

// DELETE BY ID	
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<Playlist> removePlay(@PathVariable Integer id) {
		this.service.removePlay(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
