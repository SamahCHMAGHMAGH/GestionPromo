package promo.model;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Promotion {

	protected String nomPromotion;

	public String getNomPromotion() {
		return nomPromotion;
	}

	protected LocalDate dateDebutPromotion;

	public LocalDate getDateDebutPromotion() {
		return dateDebutPromotion;
	}

	protected int dureeTotal=0;

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

	// Méthode de vérification de retard

	public String verifRetard() {
		if (this.delai > 30) {
			
			return "L'apprenant est en retard";
		} else {
			
			return "Tout va bien";
		}
	}
	// Méthode de vérification d'absence
	public String verifAbsence() {
		if (this.absence > 0.1*dureeTotal) {
			
			return "L'apprenant a trop d'absence";
		} else {
			
			return "Tout va bien";
		}
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
