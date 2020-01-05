package view;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import controller.ProfesorController;
import model.BazaProfesora;

import java.sql.Date;
import java.util.ArrayList;


	public class AbstractTableModelProfesori extends AbstractTableModel {

		private static final long serialVersionUID = -7886221481965601776L;
		private ArrayList<Boolean> koJeOtkacen;
		
		public AbstractTableModelProfesori() {
			this.koJeOtkacen = new ArrayList<>();
			for(int i = 0; i < BazaProfesora.getInstance().getProfesori().size(); i++) {
				koJeOtkacen.add(false);
			}
		}
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return columnIndex == 9;
		}
	
		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return BazaProfesora.getInstance().getColumnCount();
		}

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return BazaProfesora.getInstance().getTekuci_profesori().size();
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
				return String.class;
			case 6:
				return Date.class;
			case 7:
				return String.class;
			case 8:
				return String.class;
			case 9:
				return JButton.class;
			default:
				return null;
			}
		}
		@Override
		public String getColumnName(int column) {
			return BazaProfesora.getInstance().getColumnName(column);
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return BazaProfesora.getInstance().getValueAt(rowIndex, columnIndex);
		}
		
		public void studentDodat() {
			this.koJeOtkacen.add(false);
		}
		
		public void studentUklonjen(int rowIndex) {
			this.koJeOtkacen.remove(rowIndex);
		}
		
}
