package org.example.customexception;

public class InvalidPasswordException extends Exception {
    public    InvalidPasswordException(String s){
        super(s);
        System.out.println("Password is not valid ");
    }
}
