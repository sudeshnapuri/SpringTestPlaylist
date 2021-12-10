package com.bae.playlist.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // flags class as a table to Spring Data
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT 
	private Integer id;
	
	private String title;
	
	private String artist;

	private Integer duration;

	private String album;
	

	public Playlist() {
		super();
	}
	
	
	public Playlist(Integer id, String title, String artist, Integer duration, String album) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.album = album;
	}


	public Playlist(String title, String artist, Integer duration, String album) {
		super();
		this.title = title;
		this.artist = artist;
		this.duration = duration;
		this.album = album;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	@Override
	public String toString() {
		return "Playlist [id=" + id + ", title=" + title + ", artist=" + artist + ", duration=" + duration + ", album="
				+ album + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
