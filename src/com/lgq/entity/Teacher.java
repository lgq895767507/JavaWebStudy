package com.lgq.entity;

public class Teacher extends IdEntity {

	private String name;
	private int size;
	private String subject;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", size=" + size + ", subject=" + subject + ", getId()=" + getId() + "]";
	}

}
