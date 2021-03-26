/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Rober
 */
public class CLIModel {
    
    private String currentUser;
    private Map<String, String> users = new HashMap<String, String>();
    private ArrayList<Student> studentsList = new ArrayList<>();

    public CLIModel() {
        this.currentUser = "";
        this.users = loadUsers();
        this.studentsList = loadStudents();
    }

    public Map<String, String> loadUsers(){
        Map<String, String> users = new HashMap<>();
        
        users.put("Apoquinto", "test");
        
        return users;
    }
    
    public ArrayList<Student> loadStudents(){
        ArrayList<Student> students = new ArrayList<>();
        
        Student Apoquinto = new Student("16003312", "Llanes", "Montero", "Roberto Carlos");
        students.add(Apoquinto);

        Student test = new Student("16003321", "Montero", "Llanes", "Carlos Llanes");
        test.setGrade(100);
        students.add(test);
        
        Student test2 = new Student("16003358", "Guerrero", "Torres", "Ruperto");
        test2.setGrade(80);
        students.add(test2);

        Student test3 = new Student("15781000", "Fuentes", "Pech", "Maria Angelica");
        test3.setGrade(65);
        students.add(test3);
        
        return students;
    }
    
    public boolean scoreStudent(String id, Integer score){
        boolean result = false;
        ArrayList<Student> students = getStudentsList();
        
        for (Student student : students) {
            if(student.getId().equals(id)){
                student.setGrade(score);
                setStudentsList(students);
                result = true;
            }    
        }
        
        return result;
    }
    
    public boolean userAuthentication(String user, String pass){
        boolean result = false;
        if(!(users.get(user) == null)){
            if(users.get(user).equals(pass)){
                setCurrentUser(user);
                result = true;
            }
        }
        return result;
    }
    
    public String getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(String currentUser) {
        this.currentUser = currentUser;
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }

    public Map<String, String> getUsers() {
        return users;
    }
}
