package com.hbpvu.jec;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Playaround {

	public static void main(String[] args) throws Throwable {
		ObjectMapper mapper = new ObjectMapper();
		User user = new User();
		user.setEmail("byq@sina.com");
		user.setName("byq");
		String s = mapper.writeValueAsString(user);
		User u = mapper.reader().readValue(s);
		System.out.println(s);

	}

}
class User{
	@JsonIgnore
	String name;
	String email;
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ", locale = "zh", timezone = "GMT+8")
	Date birthday = new Date();
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
