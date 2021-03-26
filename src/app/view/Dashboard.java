/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.model.Student;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Rober
 */
public class Dashboard extends CLIView{
    private Scanner input = new Scanner(System.in);
    private String msg;
    private String cmd;
    private String id;
    private String score;
    private ArrayList<Student> studentsList = new ArrayList<>();

    public Dashboard(ArrayList<Student> studentsList) {
        this.msg = "";
        this.id = null;
        this.score = null;
        this.studentsList = studentsList;
    }
    
    public void load(ArrayList<Student> studentsList){
        clear();
        setStudentsList(studentsList);
        Dashboard();
        print(msg);
        command();
    }
    
    public void Dashboard(){
        print("Estudiantes:\n");
        for (Student student : studentsList) {
            if(student.getGrade() == null){
                print(studentInformationEarring(student.toString()));
            }     
            else{
                print(studentInformation(student.toString(), student.getGrade()));
            }       
        }
    }
    
    public void exit(){
        print(warningMessage("Generando archivo de calificaciones...\n"));
        print(successMessage("Que tenga un buen dia :D\n"));
    }
    
    public void score(){
        print("Inserte la matricula del alumno:\n");
        setId(input.nextLine());
        print("Inserte la calificación del alumno:\n");
        setScore(input.nextLine());
    }
    
    public void success(){
        setMsg(successMessage("Captura realizada con exito.\n"));       
    }
    
    public void fail(){
        setMsg(errorMessage("No se admiten calificaciones que no esten entre 0 y 100."));
    }
    
    public void invalidScore(){
        setMsg(errorMessage("La calificacion debe ser entera, no se admiten decimales."));
    }
    
    public void help(){
        setMsg(successMessage("'calificar'") + " para calificar un estudiante.\n" + successMessage("'/q'") + " para salir de la aplicación y generar el documento.\n");
    }
    
    public void unknownCommand(){
        setMsg(errorMessage("Comando desconocido, si quiere puede consultar los comandos con '/h'"));
    }
    
    public void studentNotFound(){
        setMsg(errorMessage("No se encontro la matricula del estudiante en la lista."));
    }

    public ArrayList<Student> getStudentsList() {
        return studentsList;
    }

    public void setStudentsList(ArrayList<Student> studentsList) {
        this.studentsList = studentsList;
    }
    
    public void command(){
        print(successMessage(">> "));
        setCmd(input.nextLine());
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
