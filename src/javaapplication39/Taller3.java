/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication39;

/**
 *
 * @author Luisv
 */
import javax.swing.*;

public class Taller3 extends JFrame {

    public Taller3() {

        setTitle("Sistema de Operaciones");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane pestañas = new JTabbedPane();

        // Panel operaciones
        JPanel panel1 = new JPanel();

        JLabel lbl1 = new JLabel("Número 1:");
        JTextField txt1 = new JTextField(10);

        JLabel lbl2 = new JLabel("Número 2:");
        JTextField txt2 = new JTextField(10);

        JButton btnSuma = new JButton("Sumar");
        JButton btnResta = new JButton("Restar");

        panel1.add(lbl1);
        panel1.add(txt1);
        panel1.add(lbl2);
        panel1.add(txt2);
        panel1.add(btnSuma);
        panel1.add(btnResta);

        // Panel temperatura
        JPanel panel2 = new JPanel();

        JTextField txtTemp = new JTextField(10);

        JButton btnCF = new JButton("°C a °F");

        panel2.add(txtTemp);
        panel2.add(btnCF);

        // Panel moneda
        JPanel panel3 = new JPanel();

        JTextField txtMoneda = new JTextField(10);

        JButton btnUsd = new JButton("USD a COP");

        panel3.add(txtMoneda);
        panel3.add(btnUsd);

        pestañas.add("Operaciones", panel1);
        pestañas.add("Temperatura", panel2);
        pestañas.add("Moneda", panel3);

        add(pestañas);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Taller3();
    }
}
