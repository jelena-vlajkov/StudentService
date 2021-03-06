package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import model.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {

	private static final long serialVersionUID = 8454002200965331257L;

	public static String kolonaDugme = "DUGME";
	
	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount();
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getTekuciPredmet().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if (column < 5) {
			return BazaPredmeta.getInstance().getValueAt(row, column);
		} 
		else if (column == 5)
		{
			JButton button = new JButton("" + row);
			return button;
		}
		return null;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int column) {
		return column == 5;
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return String.class;
		case 1:
			return String.class;
		case 2:
			return String.class;
		case 3:
			return String.class;
		case 4:
			return String.class;
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

}
