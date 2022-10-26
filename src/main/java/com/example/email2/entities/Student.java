package com.example.email2.entities;

public class Student {

    private String id;
    private String nameSurname;
    private String email;

    public Student(){}

    public Student(String id, String nameSurname, String email){
        this.email=email;
        this.id=id;
        this.nameSurname=nameSurname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
