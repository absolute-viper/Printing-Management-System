package GUI;

import BasicClasses.Employee;
import Database.Database_Connection;
import TableModel.EmployeeTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class User_View extends JFrame implements ActionListener {
    final private JButton Exit_but;
    final private JFrame AdminFrame;
    Connection con = Database_Connection.connect();
    PreparedStatement p;
    ResultSet rs;

    public User_View() {

        AdminFrame = new JFrame("User Records:");
        AdminFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 25, 5);
        AdminFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        JLabel Print_Id_lab = new JLabel("All Employees:");
        AdminFrame.add(Print_Id_lab, gbc);

        ArrayList<Employee> myList = getEmployees();
        EmployeeTableModel tablemodel = new EmployeeTableModel(myList);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.ipady = 180;
        JTable employee_Table = new JTable(tablemodel);
        employee_Table.setRowSelectionAllowed(true);
        JScrollPane pane1 = new JScrollPane(employee_Table);
        AdminFrame.add(pane1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        AdminFrame.add(Exit_but, gbc);

        AdminFrame.setSize(560, 450);
        AdminFrame.setResizable(false);
        AdminFrame.setLocationRelativeTo(null);
        AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminFrame.setVisible(true);
    }

    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> myList = new ArrayList<>();
        try {
            String sql = "select * from employee_details";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                myList.add(new Employee(rs.getString("name"),
                        rs.getString("phone"),rs.getInt("empid"),rs.getString("department"),
                        rs.getString("room_no"),rs.getString("print_elig")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return myList;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object Source = e.getSource();
        if (Source == Exit_but) {
            AdminFrame.setVisible(false);
            new AdminFunctions();
        }
    }
}
