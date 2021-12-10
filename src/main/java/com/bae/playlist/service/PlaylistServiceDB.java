package com.bae.playlist.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bae.playlist.domain.Playlist;
import com.bae.playlist.repository.PlaylistRepository;

@Service
public class PlaylistServiceDB implements PlaylistService {
	
	private PlaylistRepository repo;

	@Autowired
	public PlaylistServiceDB(PlaylistRepository repo) {
		super();
		this.repo = repo;
	}

	@Override
	public Playlist createPlaylist(Playlist play) {
		Playlist created = this.repo.save(play); // INSERT INTO PLAYLIST...
		return created;
	}

	@Override
	public List<Playlist> getAllPlays() {
		return this.repo.findAll(); // SELECT * FROM PLAYLIST...
	}

	@Override
	public Playlist getPlay(Integer id) {
		Optional<Playlist> found = this.repo.findById(id); // SELECT * FROM PLAYLIST... WHERE ID=
		return found.get();
	}

	public List<Playlist> getAllPlaysByTitle(String title) {
		List<Playlist> found = this.repo.getAllByTitle(title);
		return found;
	}
	
	@Override
	public Playlist replacePlay(Integer id, Playlist newPlay) {
		Playlist existing = this.repo.findById(id).get(); // SELECT * FROM PLAYLIST... WHERE ID= AND REPLACE AND UPDATE LIST

		existing.setTitle(newPlay.getTitle());
		existing.setArtist(newPlay.getArtist());
		existing.setDuration(newPlay.getDuration());
		existing.setAlbum(newPlay.getAlbum());

		Playlist updated = this.repo.save(existing);
		return updated;
	}

	@Override
	public void removePlay(Integer id) {
		this.repo.deleteById(id); // DELETE FROM PLAYLIST WHERE ID=
	}


}

