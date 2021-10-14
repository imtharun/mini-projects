// Calculator using Java AWT

import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    TextField txt;
    Button b0, b00, b1, b2, b3, b4, b5, b6, b7, b8, b9, div, mul, sub, add, equal;
    Button sqrt, ln, xsq, sin, cos, _10pPowX, period, clear, pi;
    double num1, num2;
    char symbol;

    Calculator(){
        // To make frame window to close on pressing the close button
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }
        });

        // Creating instance for buttons and text fields
        txt = new TextField("", 30);
        txt.setBounds(30, 50, 300,30);

        add(txt);
        b00 = new Button("00");
        b1 = new Button("1");
        b2 = new Button("2");
        b3 = new Button("3");
        b4 = new Button("4");
        b5 = new Button("5");
        b6 = new Button("6");
        b0 = new Button("0");
        b7 = new Button("7");
        b8 = new Button("8");
        b9 = new Button("9");
        sin = new Button("sin()");
        cos = new Button("cos()");
        add = new Button("+");
        sub = new Button ("-");
        mul = new Button("*");
        div = new Button("/");
        equal = new Button("=");
        sqrt = new Button("sqrt()");
        ln = new Button("ln");
        xsq = new Button("x^2");
        period = new Button(".");
        _10pPowX = new Button("10^x");
        clear = new Button("C");
        pi = new Button("π");

        // Setting position, width and height
        // First set
        sqrt.setBounds(30, 85, 50, 50);
        b7.setBounds(90, 85, 50, 50);
        b8.setBounds(150, 85, 50, 50);
        b9.setBounds(210, 85, 50, 50);
        div.setBounds(280, 85, 50, 50);

        // Second set
        _10pPowX.setBounds(30, 145, 50, 50);
        b4.setBounds(90, 145, 50, 50);
        b5.setBounds(150, 145, 50, 50);
        b6.setBounds(210, 145, 50, 50);
        mul.setBounds(280, 145, 50, 50);

        // Third set
        sin.setBounds(30, 205, 50, 50);
        b3.setBounds(90, 205, 50, 50);
        b2.setBounds(150, 205, 50, 50);
        b1.setBounds(210, 205, 50, 50);
        sub.setBounds(280, 205, 50, 50);

        // Fourth set
        cos.setBounds(30, 265, 50, 50);
        b0.setBounds(90, 265, 50, 50);
        add.setBounds(280, 265, 50, 50);
        period.setBounds(150, 265, 50, 50);
        b00.setBounds(210, 265, 50, 50);

        // Fifth set
        pi.setBounds(30, 325, 50, 50);
        xsq.setBounds(90, 325, 50, 50);
        ln.setBounds(150, 325, 50, 50);
        clear.setBounds(210, 325, 50, 50);
        equal.setBounds(280, 325, 50, 50);

        // Adding to Container component
        add(b00);
        add(b0);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(pi);
        add(xsq);
        add(ln);
        add(clear);
        add(period);
        add(sin);
        add(cos);
        add(equal);
        add(sub);
        add(add);
        add(_10pPowX);
        add(mul);
        add(sqrt);
        add(div);

        // Adding action listener
        txt.addActionListener(this);
        b00.addActionListener(this);
        b1.addActionListener(this);
        b0.addActionListener(this);
        b2.addActionListener(this);
        b4.addActionListener(this);
        b3.addActionListener(this);
        b5.addActionListener(this);
        b6.addActionListener(this);
        b7.addActionListener(this);
        b8.addActionListener(this);
        b9.addActionListener(this);
        pi.addActionListener(this);
        sin.addActionListener(this);
        cos.addActionListener(this);
        xsq.addActionListener(this);
        period.addActionListener(this);
        ln.addActionListener(this);
        add.addActionListener(this);
        sub.addActionListener(this);
        mul.addActionListener(this);
        div.addActionListener(this);
        sqrt.addActionListener(this);
        clear.addActionListener(this);
        _10pPowX.addActionListener(this);
        equal.addActionListener(this);
        sqrt.addActionListener(this);

        setTitle("Calculator");
        setSize(350, 400);
        setBackground(Color.BLACK);

        setLayout(null);
        setVisible(true);

    }

    // Setting actions
    public void actionPerformed(ActionEvent ae){
        String str = ae.getActionCommand();
//        System.out.println(str);

        if(ae.getSource() == _10pPowX){
            try{
                String s = txt.getText();
                txt.setText("" + Math.pow(10, Double.parseDouble(s)));
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }


        if(ae.getSource() == pi){
            txt.setText("" + Math.PI);
        }

        if(ae.getSource() == xsq){
            try{
                String s = txt.getText();
                double val = Double.parseDouble(s);
                val = val * val;
                txt.setText("" + val);
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == sin){
            try{
                String s = txt.getText();
                txt.setText("" + Math.sin(Double.parseDouble(s)));
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }
        if(ae.getSource() == ln){
            try{
                String s = txt.getText();
                txt.setText("" + Math.log(Double.parseDouble(s)));
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == cos) {
            try{
                String s = txt.getText();
                txt.setText("" + Math.cos(Double.parseDouble(s)));
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }
        if(ae.getSource() == sqrt){
            try{
                String s = txt.getText();
                double d = Integer.parseInt(s, 10);
                double result = Math.sqrt(d);
                txt.setText(String.valueOf(result));
            }catch (Exception exp){}
        }
        if(ae.getSource() == add){
            try{
                num1 = Double.parseDouble(txt.getText());
                String s = txt.getText();
                txt.setText(s + " + ");
                symbol = '+';
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == sub){
            try{
                num1 = Double.parseDouble(txt.getText());
                String s = txt.getText();
                txt.setText(s + " - ");
                symbol = '-';
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == mul){
            try{
                num1 = Double.parseDouble(txt.getText());
                String s = txt.getText();
                txt.setText(s + " * ");
                symbol = '*';
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == div){
            try{
                num1 = Double.parseDouble(txt.getText());
                String s = txt.getText();
                txt.setText(s + " / ");
                symbol = '/';
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == clear){
            txt.setText("");
        }
        if(ae.getSource() == period){
            String existing = txt.getText();
            txt.setText(existing + ".");
        }

        if(ae.getSource() == equal){
            String s = txt.getText();
            System.out.println(s);
            int index = s.indexOf(symbol);
            System.out.println(index);
            num2 = Double.parseDouble(s.substring(index + 1));
            try{
                if(symbol == '+'){
                    txt.setText("" + (num1 + num2));
                }else if(symbol == '-'){
                    txt.setText("" + (num1 - num2));
                }else if(symbol == '*'){
                    txt.setText("" + (num1 * num2));
                }else if(symbol == '/'){
                    txt.setText("" + (num1 / num2));
                }
            }catch (Exception exp){
                txt.setText("Invalid");
            }
        }

        if(ae.getSource() == b00){
            String existing = txt.getText();
            txt.setText( existing + "00");
        }else if(ae.getSource() == b1){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b2){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b3){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b4){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b5){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b6){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b7){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b8){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b9){
            String existing = txt.getText();
            txt.setText(existing + str);
        }else if(ae.getSource() == b0){
            String existing = txt.getText();
            txt.setText(existing + str);
        }
    }

    public static void main(String[] args) {
        new Calculator();
    }
}
