package promo.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import promo.model.Apprenant;

public class ApprenantTableModel extends AbstractTableModel {

	
		List<Apprenant> apprenants;

		private static final int NOMAPPRENANT = 0;

		private static final int PRENOMAPPRENANT = 1;

		private static final int STATUTAPPRENANT = 2;

		private static final String[] columns = new String[] { "Name", "First Name", "Statut" };

		private static final Class<?>[] clazz = { String.class, String.class, String.class };

		public ApprenantTableModel(List<Apprenant> apprenants) {
			this.apprenants = apprenants;
		}

		@Override
		public int getRowCount() {
			return apprenants.size();
		}

		@Override
		public int getColumnCount() {
			return columns.length;
		}

		@Override
		public String getColumnName(int columnIndex) {
			return columns[columnIndex];
		}

		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return clazz[columnIndex];
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Apprenant a = getApprenant(rowIndex);

			if (a != null) {
				switch (columnIndex) {
				case NOMAPPRENANT:
					return  a.getNom();
				case PRENOMAPPRENANT:
					return  a.getPrenom();
					// TODO A VOIR
				case STATUTAPPRENANT:
//					return a.getDureeTotal();
				}
			}
			return "";
		}

		public Apprenant getApprenant(int rowIndex) {
			if (getRowCount() > rowIndex && rowIndex >= 0) {
				return apprenants.get(rowIndex);
			}
			return null;
		}
	}
