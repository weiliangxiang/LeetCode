package demo20171203;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;

class person1{
	private String name;
	private String sex;
	private int age;
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public String getP4() {
		return p4;
	}
	public void setP4(String p4) {
		this.p4 = p4;
	}
	@Override
	public String toString() {
		return "person1 [name=" + name + ", sex=" + sex + ", age=" + age + ", p1=" + p1 + ", p2=" + p2 + ", p3=" + p3
				+ ", p4=" + p4 + "]";
	}
	public person1(String name, String sex, int age, String p1, String p2, String p3, String p4) {
		super();
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
	}
	
}
class person2{
	private String p1;
	private String p2;
	private String p3;
	private String p4;
	private String p5;
	public String getP1() {
		return p1;
	}
	public void setP1(String p1) {
		this.p1 = p1;
	}
	public String getP2() {
		return p2;
	}
	public void setP2(String p2) {
		this.p2 = p2;
	}
	public String getP3() {
		return p3;
	}
	public void setP3(String p3) {
		this.p3 = p3;
	}
	public String getP4() {
		return p4;
	}
	public void setP4(String p4) {
		this.p4 = p4;
	}
	public String getP5() {
		return p5;
	}
	public void setP5(String p5) {
		this.p5 = p5;
	}
	@Override
	public String toString() {
		return "person2 [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + ", p5=" + p5 + "]";
	}
	public person2(String p1, String p2, String p3, String p4, String p5) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3;
		this.p4 = p4;
		this.p5 = p5;
	}
	
}
public class BeanutilsDemo {
public static void main(String[] args) {
	person1 person1=new person1("wlx", "boy", 23, "p1", "p2", "p3", "p4");
	person2 person2=new person2("a1", "a2", "a3", "a4", "a5");
	
try {
	BeanUtils.copyProperties(person2, person1);
} catch (IllegalAccessException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (InvocationTargetException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
System.out.println(person1);
}

}
