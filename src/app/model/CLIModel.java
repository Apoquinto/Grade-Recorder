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
    private FileHandler fileHandler = new FileHandler();
    
    public CLIModel() {
        this.currentUser = "";
        this.users = loadUsers();
        this.studentsList = loadStudents();
        loadGrades();
    }

    public Map<String, String> loadUsers(){
        Map<String, String> users = new HashMap<>();
        ArrayList<String[]> data = fileHandler.readUsers(); 
        
        for (String[] user : data) {
            users.put(user[0], user[1]);
        }
        
        users.put("Admin", "Admin");
        
        return users;
    }
    
    public ArrayList<Student> loadStudents(){
        ArrayList<Student> StudentList = new ArrayList<>();
        ArrayList<String[]> students = fileHandler.readStudents(); 
        
        for (String[] studentData : students) {
            Student tempStudent = new Student(studentData[0], studentData[1], studentData[2], studentData[3]);
            StudentList.add(tempStudent);
        }
        
        return StudentList;
    }
    
    public void loadGrades(){
        ArrayList<String[]> gradesData = fileHandler.readGrades(); 
        
        for (String[] gradeData : gradesData) {
            try{
                scoreStudent(gradeData[0], Integer.parseInt(gradeData[1]));                
            }
            catch(Exception e){
                scoreStudent(gradeData[0], null);
            }
        }
    }
    
    public void generateRecord(){
        fileHandler.writeFile(studentsList);
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
