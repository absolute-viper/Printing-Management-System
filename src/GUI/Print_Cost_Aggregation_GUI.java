package GUI;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;

public class Print_Cost_Aggregation_GUI extends JFrame implements ActionListener {

    public Print_Cost_Aggregation_GUI(){
        JFrame frame = new JFrame("ICTS                         Aggregation:- Cost Calculation");
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5,10,25,5);

        // Main Search
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Print_Id_lab = new JLabel("Employee Id:");
        frame.add(Print_Id_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.ipadx = 350; gbc.ipady = 3;
        JTextField Print_Id_text = new JTextField("Enter Employee Id");
        frame.add(Print_Id_text,gbc);

        gbc.insets = new Insets(5,10,0,5);
        gbc.gridx = 2; gbc.gridy = 0;
        gbc.ipadx = 0; gbc.ipady = 0;
        JButton Print_Id_but = new JButton("Search");
        frame.add(Print_Id_but,gbc);

        gbc.insets = new Insets(0,10,0,5);
        gbc.gridx = 2; gbc.gridy = 1;
        gbc.ipadx = 6; gbc.ipady = 0;
        JButton Reset_but = new JButton("Reset");
        frame.add(Reset_but,gbc);

        gbc.insets = new Insets(5,10,5,5);
        // Search Output



        gbc.gridx = 0; gbc.gridy = 2;
        gbc.ipadx = 1; gbc.ipady = 0;
        JLabel Emp_Name_lab = new JLabel("Employee Name");
        frame.add(Emp_Name_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        gbc.ipadx = 350; gbc.ipady = 0;
        JTextField Emp_Name_text = new JTextField("John Doe");
        Emp_Name_text.setEditable(false);
        frame.add(Emp_Name_text,gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Contact_No_lab = new JLabel("Contact No.:");
        frame.add(Contact_No_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.ipadx = 350; gbc.ipady = 0;
        JTextField Contact_No_text = new JTextField("+91 XXXXXXXXXX");
        Contact_No_text.setEditable(false);
        frame.add(Contact_No_text,gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Department_lab = new JLabel("Department:");
        frame.add(Department_lab,gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        gbc.ipadx = 350; gbc.ipady = 0;
        JTextField Department_text = new JTextField("Employee Department");
        Department_text.setEditable(false);
        frame.add(Department_text,gbc);


        gbc.gridx = 0; gbc.gridy = 5;gbc.gridwidth = 0;
        gbc.ipadx = 530; gbc.ipady = 150;
        String name = "xyz";
        String[][] data = { {"Sample Data","Sample Data","Sample Data","Sample Data"},
                {"Sample Data","Sample Data","Sample Data","Sample Data"},
                {"Sample Data","Sample Data","Sample Data","Sample Data"}};
        String[] column={"Request ID","Date","Description.","Cost"};
        JTable Print_Cost_Table = new JTable(data,column);
        JScrollPane scrollable = new JScrollPane(Print_Cost_Table);
        frame.add(scrollable,gbc);

        gbc.insets = new Insets(5,270,5,0);
        gbc.gridx = 1; gbc.gridy = 6;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Total_Cost_lab = new JLabel("Total Cost:");
        frame.add(Total_Cost_lab,gbc);

        gbc.insets = new Insets(5,0,5,0);
        gbc.gridx = 2; gbc.gridy = 6;
        gbc.ipadx = 50; gbc.ipady = 0;
        JTextField Total_Cost_text = new JTextField("₹XX.XX");
        Total_Cost_text.setEditable(false);
        frame.add(Total_Cost_text,gbc);

        gbc.insets = new Insets(15,13,5,0);
        gbc.gridx = 0; gbc.gridy = 7;
        gbc.ipadx = 0; gbc.ipady = 0;
        JLabel Message_lab = new JLabel("Message:");
        frame.add(Message_lab,gbc);


        gbc.insets = new Insets(0,13,0,0);
        gbc.gridx = 0; gbc.gridy = 8;
        gbc.ipadx = 430; gbc.ipady = 30;
        JTextArea Message_ar = new JTextArea("Current Status...");
        Message_ar.setEditable(false);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 2);
        Message_ar.setBorder(border);
        frame.add(Message_ar,gbc);

        gbc.weightx = 1;
        gbc.weighty = 1;
        frame.add(new JLabel(" "),gbc);
        frame.setSize(590,540);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    public static void main(String[] args){
        new Print_Cost_Aggregation_GUI();
    }
}
