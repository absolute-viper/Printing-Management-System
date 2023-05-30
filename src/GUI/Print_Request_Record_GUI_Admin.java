package GUI;

import BasicClasses.Print_Request;
import Database.Database_Connection;
import TableModel.PrintRequestModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Print_Request_Record_GUI_Admin extends JFrame implements ActionListener {
    final private JButton Exit_but;
    final private JFrame AdminFrame;
    Connection con = Database_Connection.connect();
    PreparedStatement p;
    ResultSet rs;

    public Print_Request_Record_GUI_Admin() {

        AdminFrame = new JFrame("Print Records:");
        AdminFrame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.insets = new Insets(5, 5, 25, 5);
        AdminFrame.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Main Search
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        JLabel Print_Id_lab = new JLabel("Print Records:");
        AdminFrame.add(Print_Id_lab, gbc);

        ArrayList<Print_Request> myList = getPrints();
        PrintRequestModel tablemodel = new PrintRequestModel(myList);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.ipadx = 0;
        gbc.ipady = 180;
        JTable verification_Table = new JTable(tablemodel);
        verification_Table.setRowSelectionAllowed(true);
        JScrollPane pane1 = new JScrollPane(verification_Table);
        AdminFrame.add(pane1, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        Exit_but = new JButton("Exit");
        Exit_but.addActionListener(this);
        AdminFrame.add(Exit_but, gbc);

        AdminFrame.setSize(860, 450);
        AdminFrame.setResizable(false);
        AdminFrame.setLocationRelativeTo(null);
        AdminFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        AdminFrame.setVisible(true);
    }

    public ArrayList<Print_Request> getPrints() {
        ArrayList<Print_Request> myList = new ArrayList<>();
        try {
            String sql = "select * from print_details";
            p = con.prepareStatement(sql);
            rs = p.executeQuery();

            while (rs.next()) {
                myList.add(new Print_Request(rs.getInt("reqid"), rs.getInt("empid"),
                        rs.getString("filename"), rs.getString("tasktype"),rs.getString("papersize"),
                        rs.getString("color"),rs.getString("doublesided"),
                        rs.getInt("copies"),rs.getString("orientation")));
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
