package com.paramjot.rest.upgradedpancake.person;

public class NewPerson {
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String lastName;

    public NewPerson(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
