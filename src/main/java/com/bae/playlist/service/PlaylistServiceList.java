package com.bae.playlist.service;

import java.util.ArrayList;
import java.util.List;

import com.bae.playlist.domain.Playlist;

public class PlaylistServiceList implements PlaylistService {
	
	private List<Playlist> plays = new ArrayList<>();

	@Override
	public Playlist createPlaylist(Playlist play) {
		this.plays.add(play);
		Playlist created = this.plays.get(this.plays.size() - 1);
		return created;
	}

	@Override
	public List<Playlist> getAllPlays() {
		return this.plays;
	}

	@Override
	public Playlist getPlay(Integer id) {
		return this.plays.get(id);
	}

	@Override
	public Playlist replacePlay(Integer id, Playlist newPlay) {
		Playlist found = this.plays.set(id, newPlay);

		return found;
	}

	@Override
	public void removePlay(Integer id) {
		this.plays.remove(id.intValue());
		}

	@Override
	public List<Playlist> getAllPlaysByTitle(String type) {
		// TODO Auto-generated method stub
		return null;
	}


}

