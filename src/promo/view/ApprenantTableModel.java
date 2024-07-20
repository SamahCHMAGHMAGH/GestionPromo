package promo.view;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import promo.model.Alternant;
import promo.model.Apprenant;
import promo.model.Stagiaire;

//on a défini la table  de l'apprenant avec ses colonnes, ses lignes et ses valeurs 
public class ApprenantTableModel extends AbstractTableModel {

	List<Apprenant> apprenants;

	private double dureeTotal;

	private int delai;

	public void setDureeTotal(double dureeTotal) {
		this.dureeTotal = dureeTotal;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}
	
	private static final int NOMAPPRENANT = 0;

	private static final int PRENOMAPPRENANT = 1;

	private static final int STATUTAPPRENANT = 2;

	private static final int NOM_TYPE = 3;
	private static final int ALERT_ABSENCE = 4;
	private static final int ALERT_RETARD = 5;

	private static final String[] columns = new String[] { "Name", "First Name", "Type", "Details", "Absence",
			"Retard" };

	private static final Class<?>[] clazz = { String.class, String.class, String.class, String.class, String.class,
			String.class, String.class };

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
				return a.getNom();
			case PRENOMAPPRENANT:
				return a.getPrenom();
			// TODO A VOIR
			case STATUTAPPRENANT:
				return a.getClass().getSimpleName();

			case NOM_TYPE:
				if (a instanceof Stagiaire) {
					return ((Stagiaire) a).getTypeAllocation();
				} else {
					return ((Alternant) a).getNomEntreprise();
				}
			case ALERT_ABSENCE:
				return verifAbsence(a);
			case ALERT_RETARD:
				return verifRetard(a);
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

	// Méthode de vérification de retard
	private String verifRetard(Apprenant a) {
		if (this.delai > 30) {
			return "ALERT";
		} else {

			return "OK";
		}
	}

	// Méthode de vérification d'absence
	private String verifAbsence(Apprenant a) {
		if (a.getAbsence() > 0.1 * dureeTotal) {

			return "ALERT";
		} else {

			return "OK";
		}
	}
}

