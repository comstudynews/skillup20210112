package org.comstudy21.member.model;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class MemberDTO implements Externalizable  {
	private int idx;
	private String name;
	private String email;
	private String phone;
	
	public MemberDTO() {
		this(0,"","","");
	}

	public MemberDTO(int idx, String name, String email, String phone) {
		this.idx = idx;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		//return idx + "\t" + name + "\t" + email + "\t" + phone;
		return String.format("%4d%10s%20s%20s", idx, name, email, phone);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idx;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MemberDTO other = (MemberDTO) obj;
		if (idx != other.idx)
			return false;
		return true;
	}
	
	@Override
	protected Object clone() {
		try {
			return new MemberDTO(idx, name, email, phone);
		} catch (Exception e) { }
		
		return null;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(idx);
		out.writeObject(name);
		out.writeObject(email);
		out.writeObject(phone);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		idx = (Integer)in.readObject();
		name = (String)in.readObject();
		email = (String)in.readObject();
		phone = (String)in.readObject();
	}
}
