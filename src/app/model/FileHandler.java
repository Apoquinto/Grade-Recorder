/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 *
 * @author Rober
 */
public class FileHandler {
    public ArrayList<String[]> readUsers(){
        ArrayList<String[]> accounts = new ArrayList<>();

        try {
            File csv = new File("users.csv");
            BufferedReader reader = new BufferedReader(new FileReader(csv));
            String user;
            while ((user = reader.readLine()) != null){
                String[] data = user.split(",");
                try {
                    String[] info = {data[0], data[1]};
                    accounts.add(info);
                } catch (Exception e) {
                    System.out.println("Error al leer el archivo .csv");
                }
            }
            reader.close();
            
        } catch (Exception e) {
            accounts = new ArrayList<>();
            System.out.println("Archivo de usuarios no encontrado.");
        }

        return accounts;
    }
    
    public ArrayList<String[]> readStudents(){
        ArrayList<String[]> accounts = new ArrayList<>();

        try {
            File csv = new File("students.csv");
            BufferedReader reader = new BufferedReader(new FileReader(csv));
            String user;
            while ((user = reader.readLine()) != null){
                String[] data = user.split(",");
                try {
                    String[] info = {data[0], data[1], data[2], data[3]};
                    accounts.add(info);
                } catch (Exception e) {
                    System.out.println("Error al leer los datos del estudiante del archivo .csv.");
                }
            }
            reader.close();
            
        } catch (Exception e) {
            accounts = new ArrayList<>();
            System.out.println("Archivo de Estudiantes no encontrado.");
        }

        return accounts;
    }
    
    public ArrayList<String[]> readGrades(){
        ArrayList<String[]> accounts = new ArrayList<>();

        try {
            File csv = new File("grades.csv");
            BufferedReader reader = new BufferedReader(new FileReader(csv));
            String grades;
            while ((grades = reader.readLine()) != null){
                String[] data = grades.split(",");
                try {
                    String[] info = {data[0], data[1]};
                    accounts.add(info);
                } catch (Exception e) {
                    System.out.println("Error al leer la calificación del estudiante " + data[0] + ".");
                }
            }
            reader.close();
            
        } catch (Exception e) {
            accounts = new ArrayList<>();
            System.out.println("Iniciando sin calificaciones iniciales.");
        }

        return accounts;
    }
    
    public void writeFile(ArrayList<Student> students) {
        String file = "report.csv";
        try {
            if (students.size() > 0) {
                File csv = new File(file);
                FileWriter writter = new FileWriter(csv);

                for (Student student : students) {
                    writter.write(student.toRecord());
                }

                writter.close();
            }
        } catch (Exception e) {
            System.out.println("Error while trying to write " + file);
        }
    }
}
