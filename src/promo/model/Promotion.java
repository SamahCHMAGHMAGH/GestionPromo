package promo.model;

import java.io.Serializable;
import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Promotion implements Serializable {

	protected String nomPromotion;

	public int getDelai() {
		return delai;
	}

	public void setDelai(int delai) {
		this.delai = delai;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	public void setNomPromotion(String nomPromotion) {
		this.nomPromotion = nomPromotion;
	}

	public void setApprenants(List<Apprenant> apprenants) {
		this.apprenants = apprenants;
	}

	public String getNomPromotion() {
		return nomPromotion;
	}

	protected LocalDate dateDebutPromotion;

	public LocalDate getDateDebutPromotion() {
		return dateDebutPromotion;
	}

	protected int dureeTotal;

	public int getDureeTotal() {
		return dureeTotal;
	}

	protected List<Apprenant> apprenants;

	public List<Apprenant> getApprenants() {
		return apprenants;
	}

	protected int delai;
	protected int absence;

	public Promotion(String nomPromotion, LocalDate dateDebutPromotion, int dureeTotal, List<Apprenant> apprenants) {
		super();
		this.nomPromotion = nomPromotion;
		this.dateDebutPromotion = dateDebutPromotion;
		this.dureeTotal = dureeTotal;
		this.apprenants = apprenants;
	}

	public Promotion() {
		this.nomPromotion = "";
		this.dateDebutPromotion = LocalDate.now(Clock.systemDefaultZone());
		this.dureeTotal = 0;
		this.apprenants = new ArrayList<>();
	}

	public void setDateDebutPromotion(LocalDate dateDebutPromotion) {
		this.dateDebutPromotion = dateDebutPromotion;
	}

	public void setDureeTotal(int dureeTotal) {
		this.dureeTotal = dureeTotal;
	}

	// Méthode pour les jours restants
	public Long joursPasses() {

		LocalDate dateDuJour = LocalDate.now(Clock.systemDefaultZone());

		Long diff = ChronoUnit.DAYS.between(dateDebutPromotion, dateDuJour);

		return diff;

	}


	@Override
	public String toString() {
		String s = "Promotion [nomPromotion=" + nomPromotion + ", dateDebutPromotion=" + dateDebutPromotion
				+ ", dureeTotal=" + dureeTotal + ", delai=" + delai + "]";
		for (Apprenant apprenant : apprenants) {
			s += "\n" + apprenant;
		}
		return s;
	}

}
