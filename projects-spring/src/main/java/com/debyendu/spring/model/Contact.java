package com.debyendu.spring.model;

import com.debyendu.spring.annotation.CustomAnnotaion;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Contact {

    private int id;
    @CustomAnnotaion(values= {"Krishna"}, message="First name should be Krishna")
    private String firstname;
    private String lastname;
    
    @Size(min = 10, max = 10)
    private String telephone;
    
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;
    private String country;
    private String[] course;

    public Contact() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getCourse() {
		return course;
	}

	public void setCourse(String[] course) {
		this.course = course;
	}

	
    
    
    
}

