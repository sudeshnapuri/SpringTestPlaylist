package com.bae.playlist.service;

import java.util.List;
import com.bae.playlist.domain.Playlist;


public interface PlaylistService {
	
	Playlist createPlaylist(Playlist play);
	
	List<Playlist> getAllPlays();
	
	Playlist getPlay(Integer id);
	
	List<Playlist> getAllPlaysByTitle(String type);
	
	Playlist replacePlay(Integer id, Playlist newPlay);
	
	void removePlay(Integer id);

}
