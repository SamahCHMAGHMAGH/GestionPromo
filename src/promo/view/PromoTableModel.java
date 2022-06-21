package promo.view;

import java.time.LocalDate;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import promo.model.Promotion;

public class PromoTableModel extends AbstractTableModel {
	List<Promotion> promotions;

	private static final int NOMPROMOTION = 0;

	private static final int DATEDEBUTPROMOTION = 1;

	private static final int DUREETOTAL = 2;

	private static final String[] columns = new String[] { "Name", "Date Début", "Duree" };

	private static final Class<?>[] clazz = { String.class, LocalDate.class, Integer.class };

	public PromoTableModel(List<Promotion> promotions) {
		this.promotions = promotions;
	}

	@Override
	public int getRowCount() {
		return promotions.size();
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
		Promotion a = getPromotion(rowIndex);

		if (a != null) {
			switch (columnIndex) {
			case NOMPROMOTION:
				return  a.getNomPromotion();
			case DATEDEBUTPROMOTION:
				return  a.getDateDebutPromotion();
			case DUREETOTAL:
				return a.getDureeTotal();
			}
		}
		return "";
	}

	public Promotion getPromotion(int rowIndex) {
		if (getRowCount() > rowIndex && rowIndex >= 0) {
			return promotions.get(rowIndex);
		}
		return null;
	}
}
