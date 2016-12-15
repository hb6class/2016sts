package com.hb.test;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

public class JavaBean {
	
	@Range(min=1111, max=9999)
	int number;
	
	@Range(min=1111, message="입력하라고")
	int number2;
	
	@NotEmpty
	String name;
	
	@NotEmpty(message = "반드시")
	String pw;
	
	@Pattern(regexp=".+@.+\\..+")
	String email;
	
	@Pattern(regexp=".+@.+\\..+", message="이메일좀")
	String email2;
	
	public JavaBean() {
		// TODO Auto-generated constructor stub
	}
	
	
	public JavaBean(int number, int number2, String name, String pw,
			String email, String email2) {
		super();
		this.number = number;
		this.number2 = number2;
		this.name = name;
		this.pw = pw;
		this.email = email;
		this.email2 = email2;
	}


	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public int getNumber2() {
		return number2;
	}


	public void setNumber2(int number2) {
		this.number2 = number2;
	}


	public String getPw() {
		return pw;
	}


	public void setPw(String pw) {
		this.pw = pw;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getEmail2() {
		return email2;
	}


	public void setEmail2(String email2) {
		this.email2 = email2;
	}


	@Override
	public String toString() {
		return "JavaBean [number=" + number + ", number2=" + number2
				+ ", name=" + name + ", pw=" + pw + ", email=" + email
				+ ", email2=" + email2 + "]";
	}
	
	
}
