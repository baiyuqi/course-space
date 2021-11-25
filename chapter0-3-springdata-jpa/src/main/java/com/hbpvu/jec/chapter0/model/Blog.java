package com.hbpvu.jec.chapter0.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Blog{
	String content;
	@Id
	String id;
	String owner;
	String title;
	int hitCount;
	public String getContent() {
		return content;
	}
	public String getId() {
		return id;
	}
	public String getOwner() {
		return owner;
	}
	public String getTitle() {
		return title;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}