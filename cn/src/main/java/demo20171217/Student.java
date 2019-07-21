package demo20171217;

import java.util.Date;

public class Student {
	private String name;
	private int age;
	private Date date;
	
	public Student() {
		super();
	}

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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Student(String name, int age, Date date) {
		super();
		this.name = name;
		this.age = age;
		this.date = date;
	}
	

}
