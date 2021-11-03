import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationForm extends JFrame implements ActionListener{
    JLabel firstName, lastName, email, password, retypePassword, age, gender, phoneNumber, address,
             country;
    JTextField fName, lName, mail, number, Country;
    JTextArea Address;
    JPasswordField pass, rePass;
    ButtonGroup Gender;
    JButton submit;
    JRadioButton Male, Female, Others;
    JSpinner Age;

    RegistrationForm(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
                dispose();
            }
        });
        
        firstName = new JLabel("First name:");
        fName = new JTextField(20);
        lastName = new JLabel("Last name:");
        lName = new JTextField(20);
        email = new JLabel("Email: ");
        mail = new JTextField(20);
        password = new JLabel("Password:");
        pass = new JPasswordField(20);
        retypePassword = new JLabel("Retype Password:");
        rePass = new JPasswordField(20);
        age = new JLabel("Age");
        Age = new JSpinner();
        gender = new JLabel("Gender: ");
        Male = new JRadioButton("Male");
        Female = new JRadioButton("Female");
        Others = new JRadioButton("Others");
        Gender = new ButtonGroup();
        Gender.add(Male);
        Gender.add(Female);
        Gender.add(Others);
        phoneNumber = new JLabel("Phone number: ");
        number = new JTextField(20);
        address = new JLabel("Address: ");
        Address = new JTextArea();
        country = new JLabel("Country: ");
        Country = new JTextField();
        submit = new JButton("Submit");

        fName.setBounds(20, 55, 400, 20);
        firstName.setBounds(20, 30, 80, 20);
        lName.setBounds(20, 105, 400, 20);
        lastName.setBounds(20, 80, 80, 20);
        mail.setBounds(20, 155, 400, 20);
        email.setBounds(20, 130, 80, 20);
        pass.setBounds(20, 205, 400, 20);
        password.setBounds(20, 180, 80, 20);
        rePass.setBounds(20, 255, 400, 20);
        retypePassword.setBounds(20, 230, 120, 20);
        Age.setBounds(20, 305, 100, 25);
        age.setBounds(20, 280, 120, 20);
        gender.setBounds(20, 340, 120, 20);
        Male.setBounds(20, 365, 80, 20);
        Female.setBounds(100, 365, 80, 20);
        Others.setBounds(180, 365, 80, 20);
        phoneNumber.setBounds(20, 400, 120, 20);
        number.setBounds(20, 430, 400, 20);
        address.setBounds(20, 460, 80, 20);
        Address.setBounds(20, 480, 400, 60);
        country.setBounds(20, 540, 80, 20);
        Country.setBounds(20, 570, 400, 20);
        submit.setBounds(180, 600, 80, 30);
        
        add(fName);
        add(submit);
        add(firstName);
        add(lName);
        add(lastName);
        add(email);
        add(mail);
        add(pass);
        add(password);
        add(rePass);
        add(retypePassword);
        add(age);
        add(Age);
        add(gender);
        add(Male);
        add(Female);
        add(Others);
        add(phoneNumber);
        add(number);
        add(address);
        add(Address);
        add(country);
        add(Country);
        
        submit.addActionListener(this);

        setSize(500, 1000);
        setLayout(null);
        setVisible(true);
        setTitle("Registration Form");
        
        
    }
    
    public static void create(String fname, String lname, String email, String pass, String repass, String age, String gender, String num, String addr, String country) throws Exception {
    	Connection con = DriverManager.getConnection("jdbc:derby:regisForm;create=true");
    	Statement st = con.createStatement();
    	String str = "CREATE TABLE rec (FNAME VARCHAR(30), LNAME VARCHAR(30),  EMAIL VARCHAR(30), PASS VARCHAR(30), REPASS VARCHAR(30), AGE VARCHAR(3), GENDER VARCHAR(10), NUM VARCHAR(10), ADDR VARCHAR(100), COUNTRY VARCHAR(20))";
    	
    	st.executeUpdate(str);
    	PreparedStatement ps = con.prepareStatement("INSERT INTO rec VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
    	ps.setString(1, fname);
    	ps.setString(2, lname);
    	ps.setString(3, email);ps.setString(4, pass);ps.setString(5, repass);ps.setString(6, age);ps.setString(7, gender);
    	ps.setString(8, num);ps.setString(9, addr);ps.setString(10, country);
    	ps.executeUpdate();
    }
    
    public static void retrive() throws Exception{
    	String str = "SELECT * FROM rec";
    	Connection con = DriverManager.getConnection("jdbc:derby:regisForm;create=true");
    	Statement st = con.createStatement();
    	ResultSet rs = st.executeQuery(str);
    	
    	while(rs.next()) {
    		System.out.println("Firstname: " + rs.getString(1));
    		System.out.println("Lastname: " + rs.getString(2));
    		System.out.println("Email: " + rs.getString(3));
    		System.out.println("Password: " + rs.getString(4));
    		System.out.println("Re-password: " + rs.getString(5));
    		System.out.println("Age: " + rs.getString(6));
    		System.out.println("Gender: " + rs.getString(7));
    		System.out.println("Phone number: " + rs.getString(8));
    		System.out.println("Address: " + rs.getString(9));
    		System.out.println("Country: " + rs.getString(10));
    	}
    }
    public void actionPerformed(ActionEvent ae){

    	if(ae.getSource() == submit) {
    		String fname, lname, email, pa, repa, age, gen = null, num, addr, country;
    		if(Male.isSelected()) {
    			gen = "Male";
    		}else if (Female.isSelected()) {
    			gen = "Female";
    		}else if(Others.isSelected()) {
    			gen = "Others";
    		}
    		fname = fName.getText();
    		lname = lName.getText();
    		email = mail.getText();
    		pa = pass.getPassword().toString();
    		repa = rePass.getPassword().toString();
    		age = Age.getValue().toString();
    		num = number.getText();
    		addr = Address.getText();
    		country = Country.getText();
    		
    		try {    			
    			create(fname, lname, email, pa, repa, age, gen, num, addr, country);
    			retrive();
    		}catch (Exception exp) {
    			System.out.println(exp);
    		}
    	}

    }
    public static void main(String[] args) {
        new RegistrationForm();
    }
}
