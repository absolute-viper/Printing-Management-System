package TableModel;

import BasicClasses.Print_Request;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class PrintRequestModel extends AbstractTableModel {
    private final String[] columnNames = {"Request ID","Emp Id","File Name","TaskType","Paper Size","Color","Double Sided",
            "Copies","Orientation"};
    private List<Print_Request> user;
    public PrintRequestModel() {
        user = new ArrayList<Print_Request>();
    }
    public PrintRequestModel(List<Print_Request> user) {
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
        Print_Request user = getPrint_Request(rowIndex);
        return switch (columnIndex) {
            case 0 -> user.getRequestId();
            case 1 -> user.getEmpId();
            case 2 -> user.getFileId();
            case 3 -> user.getTaskType();
            case 4 -> user.getPaperSize();
            case 5 -> user.getColor();
            case 6 -> user.getDoubleSided();
            case 7 -> user.getCopies();
            case 8 -> user.getOrientation();
            default -> null;
        };
    }
    private Print_Request getPrint_Request(int rowIndex) {
        return user.get(rowIndex);
    }
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value,int row,int column) {
        Print_Request user = getPrint_Request(row);
        switch (column) {
            case 0 -> user.setRequestId((int) value);
            case 1 -> user.setEmpId((int) value);
            case 2 -> user.setFileId((String) value);
            case 3 -> user.setTaskType((String) value);
            case 4 -> user.setPaperSize((String) value);
            case 5 -> user.setColor((String) value);
            case 6 -> user.setDoubleSided((String) value);
            case 7 -> user.setCopies((int) value);
            case 8 -> user.setOrientation((String) value);
        }

        fireTableCellUpdated(row,column);
    }
    public void addPrint_Request(Print_Request user) {
        insertPrint_Request(getRowCount(),user);
    }
    public void insertPrint_Request(int row,Print_Request user) {
        this.user.add(row,user);
        fireTableRowsInserted(row,row);
    }
    public void removePerson(int row) {
        this.user.remove(row);
        fireTableRowsDeleted(row,row);
    }
}
