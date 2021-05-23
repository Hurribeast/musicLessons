package model;

import java.util.Date;

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String email;
    private String phoneNumber;

    public Student(Integer id, String firstName, String lastName, Date birthDate, String email, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getNameAndId(){
        return lastName + " " + firstName + " (Id: " + id + " )";
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
