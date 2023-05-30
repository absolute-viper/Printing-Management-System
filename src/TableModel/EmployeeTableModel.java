package TableModel;

import BasicClasses.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Emp ID","Name","Department","Phone No.","Room No.","Eligibility"};
    private List<Employee> user;
    public EmployeeTableModel() {
        user = new ArrayList<Employee>();
    }
    public EmployeeTableModel(List<Employee> user) {
        this.user = user;
    }
    @Override
    public int getRowCount() {
        return user.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee user = getEmployee(rowIndex);
        return switch (columnIndex) {
            case 0 -> user.getEmpId();
            case 1 -> user.getName();
            case 2 -> user.getDepartment();
            case 3 -> user.getPhoneNo();
            case 4 -> user.getRoomNo();
            case 5 -> user.getEligibility();
            default -> null;
        };
    }
    private Employee getEmployee(int rowIndex) {
        return user.get(rowIndex);
    }
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value,int row,int column) {
        Employee user = getEmployee(row);
        switch (column) {
            case 0 -> user.setEmpId((int) value);
            case 1 -> user.setName((String) value);
            case 2 -> user.setDepartment((String) value);
            case 3 -> user.setPhoneNo((String) value);
            case 4 -> user.setRoomNo((String) value);
            case 5 -> user.setEligibility((String) value);
        }

        fireTableCellUpdated(row,column);
    }
    public void addEmployee(Employee user) {
        insertEmployee(getRowCount(),user);
    }
    public void insertEmployee(int row,Employee user) {
        this.user.add(row,user);
        fireTableRowsInserted(row,row);
    }
    public void removePerson(int row) {
        this.user.remove(row);
        fireTableRowsDeleted(row,row);
    }

}
