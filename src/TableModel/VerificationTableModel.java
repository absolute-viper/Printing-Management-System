package TableModel;

import BasicClasses.Print_Verification;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class VerificationTableModel extends AbstractTableModel {
    private final String[] columnNames = {"Request Id","Status"};
    private List<Print_Verification> Print;


    public VerificationTableModel() {
        Print = new ArrayList<>();
    }

    public VerificationTableModel(List<Print_Verification> Print) {
        this.Print = Print;
    }

    @Override
    public int getRowCount() {
        return Print.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Print_Verification Data = getPrint(rowIndex);
        return switch (columnIndex) {
            case 0 -> Data.getRequest_id();
            case 1 -> Data.getStatus();
            default -> null;
        };
    }
    private Print_Verification getPrint(int rowIndex) {
        return Print.get(rowIndex);
    }
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }

    @Override
    public void setValueAt(Object value,int row,int column) {
        Print_Verification Data = getPrint(row);
        switch (column) {
            case 0 -> Data.setRequest_id((int) value);
            case 1 -> Data.setStatus((String) value);
        }

        fireTableCellUpdated(row,column);
    }
    public void addPrint_Verification(Print_Verification Data) {
        insertPrint_Verification(getRowCount(),Data);
    }
    public void insertPrint_Verification(int row,Print_Verification Data) {
        Print.add(row,Data);
        fireTableRowsInserted(row,row);
    }

    public void removeRow(int row) {
        fireTableRowsDeleted(row, row);
    }
}
