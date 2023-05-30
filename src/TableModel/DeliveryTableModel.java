package TableModel;

import BasicClasses.Print_Delivery;


import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class DeliveryTableModel extends AbstractTableModel {

    private final String[] columnNames = {"Request Id","Document Name","Delivery Status"};
    private List<Print_Delivery> Print;


    public DeliveryTableModel() {
        Print = new ArrayList<>();
    }

    public DeliveryTableModel(List<Print_Delivery> Print) {
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
        Print_Delivery Data = getPrint(rowIndex);
        return switch (columnIndex) {
            case 0 -> Data.getRequest_id();
            case 1 -> Data.getDocument_name();
            case 2 -> Data.getStatus();
            default -> null;
        };
    }
    private Print_Delivery getPrint(int rowIndex) {
            return Print.get(rowIndex);
        }
        @Override
        public String getColumnName(int column)
        {
            return columnNames[column];
        }

        @Override
        public void setValueAt(Object value,int row,int column) {
            Print_Delivery Data = getPrint(row);
            switch (column) {
                case 0 -> Data.setRequest_id((int) value);
                case 1 -> Data.setDocument_name((String) value);
                case 2 -> Data.setStatus((String) value);
            }

            fireTableCellUpdated(row,column);
        }
        public void addDataDelivery(Print_Delivery Data) {
            insertDataDelivery(getRowCount(),Data);
        }
        public void insertDataDelivery(int row,Print_Delivery Data) {
            Print.add(row,Data);
            fireTableRowsInserted(row,row);
        }
        public void removePerson(int row) {
            Print.remove(row);
            fireTableRowsDeleted(row,row);
        }
        public void removeRow(int row) {
            fireTableRowsDeleted(row, row);
        }
}
