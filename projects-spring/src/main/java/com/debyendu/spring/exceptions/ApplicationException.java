package com.debyendu.spring.exceptions;

public class ApplicationException extends Exception {

	public ApplicationException(Exception s) 
    { 
        super(s);
        System.out.println("This exception is : "+s.getMessage());
    } 
}
