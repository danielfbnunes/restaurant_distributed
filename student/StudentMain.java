/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author dn
 */
public class StudentMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BarStub barStub = new BarStub("l040101-ws08.ua.pt", 22602);
        TabStub tabStub = new TabStub("l040101-ws05.ua.pt", 22602);
        Student[] students = new Student[7];
        for (int i = 0; i < 7; i++) {
            students[i] = new Student(barStub, tabStub, i);
        }

        for (int i = 0; i < 7; i++) {
            students[i].start();
        }

        try {
            for (int i = 0; i < 7; i++) {
            students[i].join();
        }
        } catch (InterruptedException ex) {}

    }

}
