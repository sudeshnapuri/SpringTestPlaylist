package com.bae.playlist.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.playlist.domain.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer>{

	
	// Spring will auto-generate all of the basic CRUD functionality
	
	List<Playlist> getAllByTitle(String title);
}
