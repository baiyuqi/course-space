package com.hbpvu.jec.bookstore.tst;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = 867755909294344406L;
	String name;
	String id;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	static public void main(String[] args) throws Exception {
		/*User user = new User();
		OutputStream out = new FileOutputStream("d:/user.bin");
		ObjectOutputStream oout = new ObjectOutputStream(out);
		oout.writeObject(user);*/
		InputStream in = new FileInputStream("d:/user.bin");
		ObjectInputStream oin = new ObjectInputStream(in);
		Object rst = oin.readObject();
	}
}
