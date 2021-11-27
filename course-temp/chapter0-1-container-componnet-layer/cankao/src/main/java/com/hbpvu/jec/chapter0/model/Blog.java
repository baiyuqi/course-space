package com.hbpvu.jec.chapter0.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
@GenericGenerator(name = "jpa-uuid", strategy = "uuid")
public class Blog{
	@GeneratedValue(generator = "jpa-uuid")
	@Id
	String id;
	String owner;
	String title;
	String content;
	int hitCount;
	public int getHitCount() {
		return hitCount;
	}
	public void setHitCount(int hitCount) {
		this.hitCount = hitCount;
	}
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