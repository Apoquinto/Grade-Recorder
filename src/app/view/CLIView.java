/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

/**
 *
 * @author Rober
 */
public class CLIView {
    // Colors
    private String reset  = "\u001B[0m";
    private String green  = "\033[32m"; 
    private String yellow = "\033[33m"; 
    private String red    = "\033[31m";

    public CLIView(){
    }

    public String successMessage(String context){
        return green + context + reset;
    }

    public String warningMessage(String context){
        return yellow + context + reset;
    }

    public String errorMessage(String context){
        return red + "Error: " + yellow + context + reset + "\n";
    }

    public String studentInformation(String student, Integer grade){
        String msg;
        
        if(grade < 70)       msg = "[" + red    + "0" + grade.toString() + reset + "] " + student;
        else if(grade <= 85) msg = "[" + yellow + "0" + grade.toString() + reset + "] " + student;
        else if(grade <= 99) msg = "[" + green  + "0" + grade.toString() + reset + "] " + student;
        else                        msg = "[" + green  + grade.toString()       + reset + "] " + student;
        
        return msg + "\n";
    }

    public String studentInformationEarring(String student){
        return "[" + yellow + "???" + reset + "] " + student + "\n";
    }

    public void print(String msg){
        System.out.print(msg);
    }

    public void clear(){
        System.out.println("\n" + green + ">>" + reset + " Reload..." + "\n");
    }

}
