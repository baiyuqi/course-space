package com.hbpvu.jec.bookstore.common;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import org.springframework.data.mongodb.core.mapping.event.AuditingEventListener;


import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)

public abstract class DateAudit implements Serializable {

	@CreatedDate

	private Date createdAt;

	@LastModifiedDate

	private Date updatedAt;

	public Date getCreatedAt() {
		return createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
