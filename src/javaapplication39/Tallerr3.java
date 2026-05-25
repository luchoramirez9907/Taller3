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
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tallerr3 extends JFrame {
    
    public static void main(String[] args) {

        new Tallerr3();

    }


    // Campos operaciones
    JTextField txtNum1, txtNum2;
    JLabel lblResultadoMath;

    // Campos temperatura
    JTextField txtTemp;
    JLabel lblResultadoTemp;

    // Campos moneda
    JTextField txtMoneda;
    JLabel lblResultadoMoneda;

    // Botones
    JButton btnSuma, btnResta, btnMulti, btnDiv, btnBorrar;
    JButton btnCF, btnFC, btnBorrarTemp;
    JButton btnUsdCop, btnCopUsd, btnBorrarMoneda;

    double tasa = 3800;

    public Tallerr3() {

        setTitle("Sistema de Conversiones y Operaciones");
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crear pestañas
        JTabbedPane pestañas = new JTabbedPane();

        
        // PESTAÑA OPERACIONES
       
        JPanel panelMath = new JPanel();
        panelMath.setLayout(null);

        JLabel lbl1 = new JLabel("Número 1:");
        lbl1.setBounds(30, 30, 100, 25);
        panelMath.add(lbl1);

        txtNum1 = new JTextField("Ingresa aquí");
        txtNum1.setBounds(140, 30, 180, 25);
        panelMath.add(txtNum1);

        JLabel lbl2 = new JLabel("Número 2:");
        lbl2.setBounds(30, 70, 100, 25);
        panelMath.add(lbl2);

        txtNum2 = new JTextField("Ingresa aquí");
        txtNum2.setBounds(140, 70, 180, 25);
        panelMath.add(txtNum2);

        // Botón suma
        btnSuma = new JButton("Sumar");
        btnSuma.setBounds(30, 130, 100, 35);
        diseñoBoton(btnSuma);
        panelMath.add(btnSuma);

        // Botón resta
        btnResta = new JButton("Restar");
        btnResta.setBounds(150, 130, 100, 35);
        diseñoBoton(btnResta);
        panelMath.add(btnResta);

        // Botón multiplicar
        btnMulti = new JButton("Multiplicar");
        btnMulti.setBounds(270, 130, 120, 35);
        diseñoBoton(btnMulti);
        panelMath.add(btnMulti);

        // Botón dividir
        btnDiv = new JButton("Dividir");
        btnDiv.setBounds(410, 130, 100, 35);
        diseñoBoton(btnDiv);
        panelMath.add(btnDiv);

        // Botón borrar
        btnBorrar = new JButton("Borrar");
        btnBorrar.setBounds(220, 190, 120, 35);
        diseñoBoton(btnBorrar);
        panelMath.add(btnBorrar);

        lblResultadoMath = new JLabel("Resultado:");
        lblResultadoMath.setFont(new Font("Arial", Font.BOLD, 18));
        lblResultadoMath.setBounds(30, 280, 400, 30);
        panelMath.add(lblResultadoMath);

        // Eventos operaciones
        btnSuma.addActionListener(e -> {
            cambiarColor(btnSuma);
            operar("+");
        });

        btnResta.addActionListener(e -> {
            cambiarColor(btnResta);
            operar("-");
        });

        btnMulti.addActionListener(e -> {
            cambiarColor(btnMulti);
            operar("*");
        });

        btnDiv.addActionListener(e -> {
            cambiarColor(btnDiv);
            operar("/");
        });

        btnBorrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtNum1.setText("Ingresa aquí");
                txtNum2.setText("Ingresa aquí");

                lblResultadoMath.setText("Resultado:");

                restaurarBotonesMath();

                btnBorrar.setBackground(Color.GREEN);
            }
        });

      
        // PESTAÑA TEMPERATURA
       
        JPanel panelTemp = new JPanel();
        panelTemp.setLayout(null);

        JLabel lblTemp = new JLabel("Temperatura:");
        lblTemp.setBounds(30, 40, 100, 25);
        panelTemp.add(lblTemp);

        txtTemp = new JTextField("Ingresa aquí");
        txtTemp.setBounds(150, 40, 180, 25);
        panelTemp.add(txtTemp);

        btnCF = new JButton("°C a °F");
        btnCF.setBounds(60, 120, 120, 35);
        diseñoBoton(btnCF);
        panelTemp.add(btnCF);

        btnFC = new JButton("°F a °C");
        btnFC.setBounds(220, 120, 120, 35);
        diseñoBoton(btnFC);
        panelTemp.add(btnFC);

        btnBorrarTemp = new JButton("Borrar");
        btnBorrarTemp.setBounds(380, 120, 100, 35);
        diseñoBoton(btnBorrarTemp);
        panelTemp.add(btnBorrarTemp);

        lblResultadoTemp = new JLabel("Resultado:");
        lblResultadoTemp.setFont(new Font("Arial", Font.BOLD, 18));
        lblResultadoTemp.setBounds(30, 250, 400, 30);
        panelTemp.add(lblResultadoTemp);

        btnCF.addActionListener(e -> {
            cambiarColor(btnCF);
            convertirCF();
        });

        btnFC.addActionListener(e -> {
            cambiarColor(btnFC);
            convertirFC();
        });

        btnBorrarTemp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtTemp.setText("Ingresa aquí");

                lblResultadoTemp.setText("Resultado:");

                btnCF.setBackground(Color.RED);
                btnFC.setBackground(Color.RED);

                btnBorrarTemp.setBackground(Color.GREEN);
            }
        });

       
        // PESTAÑA MONEDA
       
        JPanel panelMoneda = new JPanel();
        panelMoneda.setLayout(null);

        JLabel lblMoneda = new JLabel("Valor:");
        lblMoneda.setBounds(30, 40, 100, 25);
        panelMoneda.add(lblMoneda);

        txtMoneda = new JTextField("Ingresa aquí");
        txtMoneda.setBounds(150, 40, 180, 25);
        panelMoneda.add(txtMoneda);

        btnUsdCop = new JButton("USD a COP");
        btnUsdCop.setBounds(60, 120, 140, 35);
        diseñoBoton(btnUsdCop);
        panelMoneda.add(btnUsdCop);

        btnCopUsd = new JButton("COP a USD");
        btnCopUsd.setBounds(230, 120, 140, 35);
        diseñoBoton(btnCopUsd);
        panelMoneda.add(btnCopUsd);

        btnBorrarMoneda = new JButton("Borrar");
        btnBorrarMoneda.setBounds(400, 120, 100, 35);
        diseñoBoton(btnBorrarMoneda);
        panelMoneda.add(btnBorrarMoneda);

        lblResultadoMoneda = new JLabel("Resultado:");
        lblResultadoMoneda.setFont(new Font("Arial", Font.BOLD, 18));
        lblResultadoMoneda.setBounds(30, 250, 400, 30);
        panelMoneda.add(lblResultadoMoneda);

        btnUsdCop.addActionListener(e -> {
            cambiarColor(btnUsdCop);
            usdCop();
        });

        btnCopUsd.addActionListener(e -> {
            cambiarColor(btnCopUsd);
            copUsd();
        });

        btnBorrarMoneda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtMoneda.setText("Ingresa aquí");

                lblResultadoMoneda.setText("Resultado:");

                btnUsdCop.setBackground(Color.RED);
                btnCopUsd.setBackground(Color.RED);

                btnBorrarMoneda.setBackground(Color.GREEN);
            }
        });

        // Agregar pestañas
        pestañas.addTab("Operaciones", panelMath);
        pestañas.addTab("Temperatura", panelTemp);
        pestañas.addTab("Moneda", panelMoneda);

        add(pestañas);

        setVisible(true);
    }

    
    // DISEÑO BOTONES
   
    public void diseñoBoton(JButton boton) {

        boton.setBackground(Color.RED);
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 14));
        boton.setFocusPainted(false);
    }

    
    // CAMBIAR COLOR
    
    public void cambiarColor(JButton boton) {

        boton.setBackground(Color.GREEN);

    }

  
    // RESTAURAR BOTONES
 
    public void restaurarBotonesMath() {

        btnSuma.setBackground(Color.RED);
        btnResta.setBackground(Color.RED);
        btnMulti.setBackground(Color.RED);
        btnDiv.setBackground(Color.RED);

    }

    
    // OPERACIONES
   
    public void operar(String op) {

        if (txtNum1.getText().isEmpty()
                || txtNum2.getText().isEmpty()
                || txtNum1.getText().equals("Ingresa aquí")
                || txtNum2.getText().equals("Ingresa aquí")) {

            JOptionPane.showMessageDialog(this, "No deje campos vacíos");
            return;
        }

        try {

            double n1 = Double.parseDouble(txtNum1.getText());
            double n2 = Double.parseDouble(txtNum2.getText());

            double r = 0;

            switch (op) {

                case "+":
                    r = n1 + n2;
                    break;

                case "-":
                    r = n1 - n2;
                    break;

                case "*":
                    r = n1 * n2;
                    break;

                case "/":

                    if (n2 == 0) {

                        JOptionPane.showMessageDialog(this,
                                "No se puede dividir entre cero");
                        return;
                    }

                    r = n1 / n2;
                    break;
            }

            lblResultadoMath.setText("Resultado: " + r);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese solo números");

        }
    }

    
    // TEMPERATURA
   
    public void convertirCF() {

        try {

            double c = Double.parseDouble(txtTemp.getText());

            double f = (c * 9 / 5) + 32;

            lblResultadoTemp.setText("Resultado: " + f + " °F");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese un número válido");

        }
    }

    public void convertirFC() {

        try {

            double f = Double.parseDouble(txtTemp.getText());

            double c = (f - 32) * 5 / 9;

            lblResultadoTemp.setText("Resultado: " + c + " °C");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese un número válido");

        }
    }

    
    // MONEDA
    
    public void usdCop() {

        try {

            double usd = Double.parseDouble(txtMoneda.getText());

            double cop = usd * tasa;

            lblResultadoMoneda.setText("Resultado: $" + cop + " COP");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese un número válido");

        }
    }

    public void copUsd() {

        try {

            double cop = Double.parseDouble(txtMoneda.getText());

            double usd = cop / tasa;

            lblResultadoMoneda.setText("Resultado: $" + usd + " USD");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(this,
                    "Ingrese un número válido");

        }
    }

}