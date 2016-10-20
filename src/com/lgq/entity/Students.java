package com.lgq.entity;

public class Students extends IdEntity {
	private String name;
	private int age;
	private int banji;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getBanji() {
		return banji;
	}

	public void setBanji(int banji) {
		this.banji = banji;
	}

	@Override
	public String toString() {
		return "Students [name=" + name + ", age=" + age + ", banji=" + banji + ", getId()=" + getId() + "]";
	}

}
