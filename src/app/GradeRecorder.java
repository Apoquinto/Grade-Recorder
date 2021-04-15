/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.controller.CLIController;
import app.model.CLIModel;

/**
 *
 * @author Rober
 */
public class GradeRecorder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CLIModel model = new CLIModel();
        CLIController cli = new CLIController(model);
        cli.start();
    }
    
}
