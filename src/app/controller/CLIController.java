/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controller;

import java.math.BigDecimal;

import app.model.CLIModel;
import app.view.Dashboard;
import app.view.LoginView;

/**
 *
 * @author Rober
 */
public class CLIController {
    
    private CLIModel model;
    private LoginView login;
    private Dashboard dashboard;
    
    public CLIController(CLIModel model) {
        this.model = model;
        this.login = new LoginView();
        this.dashboard = new Dashboard(model.getStudentsList());
    }
    
    public void start(){
        loginController();
        dashboardController();
    }
    
    public void loginController(){
        login.load();
        if(!model.userAuthentication(login.getUser(), login.getPass())){
            login.setMsg(login.errorMessage("Usuario y/o contra incorrectos."));
            loginController();
        }
    }
    
    public void dashboardController(){
        dashboard.load(model.getStudentsList());
        evalCommand(dashboard.getCmd());        
    }
    
    public void evalCommand(String command){
        switch (command) {
            case "/q":
                model.generateRecord();
                dashboard.exit();
                break;
            case "calificar":
                dashboard.score();
                try {
                    BigDecimal cal = new BigDecimal(dashboard.getScore());
                    if(cal.compareTo(new BigDecimal(0)) > 0 && cal.compareTo(new BigDecimal(100)) <= 0){
                        if(model.scoreStudent(dashboard.getId(), cal)){
                            dashboard.success();
                        }
                        else{
                            dashboard.studentNotFound();
                        }
                    }
                    else{
                        dashboard.fail();
                    }
                } catch (Exception e) {
                    dashboard.invalidScore();
                }
                dashboardController();
                break;
            case "/h":
                dashboard.help();
                dashboardController();
                break;
            default:
                dashboard.unknownCommand();
                dashboardController();
        }
    }
}
