package org.example.model;

import org.example.customexception.InvalidPasswordException;

import javax.persistence.*;

@Entity
@Table(name = "USER_INFO", uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
         })

public   class User {

    /**
     * define all the attributes with getters and setters
     * id
     * username
     * password
     * confirmPassword(make it transient)
     * email id
     * address
     */

    @Id
    private String id;
    private String username;
    private String password;
    private transient String confirmPassword;
    private String emailId;
    @Embedded
    /*
    Applied over the instance variable of the Embeddable class.
    This instance variable is placed in the actual entity class.In our case,
     it will be applied over the instance variable(Address type variable) of type Address in User class.
     */
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        boolean isUpperCase = Character.isUpperCase(password.charAt(0));
        System.out.println(password.matches("^[a-zA-Z]*$"));
        try {
           if( isUpperCase==true  ){
               this.password=password;
            }
           else
           {
              throw  new InvalidPasswordException("Password is not valid");
           }
        } catch (Exception ex){
            ex.printStackTrace();
        }
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
