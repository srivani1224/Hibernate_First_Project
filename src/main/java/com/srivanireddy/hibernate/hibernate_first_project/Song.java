package com.srivanireddy.hibernate.hibernate_first_project;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {

	//songId, songName, singer
	
	@Id
	@Column(name = "songId")
	public int id;
	
	@Column(name = "songName")
	public String name;
	
	@Column(name = "singer")
	public String singer;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	
	
	
}
