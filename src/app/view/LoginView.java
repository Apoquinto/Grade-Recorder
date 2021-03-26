/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import java.util.Scanner;

/**
 *
 * @author Rober
 */
public class LoginView extends CLIView {
    private Scanner input = new Scanner(System.in);
    
    // Data
    private String msg;
    private String user;
    private String pass;

    public LoginView() {
        this.msg = "";
        this.user = "";
        this.pass = "";
    }
    
    public void load(){
        clear();
        print(msg);
        login();
    }
    
    public void login(){
        print(successMessage("Ingrese su usario: "));
        user = input.nextLine();
        print(successMessage("Ingrese su contra: "));
        pass = input.nextLine();
    }

    public String getUser(){
        return user;
    }

    public String getPass() {
        return pass;
    }    

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
