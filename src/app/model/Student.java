/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author Rober
 */
public class Student {
    
    private String id;
    private String lastname;
    private String secondLastname;
    private String name;
    private Integer grade;

    public Student(String id, String lastname, String secundLastname, String name) {
        this.id = id;
        this.lastname = lastname;
        this.secondLastname = secundLastname;
        this.name = name;
        this.grade = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSecondLastname() {
        return secondLastname;
    }

    public void setSecondLastname(String secondLastname) {
        this.secondLastname = secondLastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "[" + getId() + "]" + getLastname() + " " + getSecondLastname() + " " + getName();
    }
    
}
