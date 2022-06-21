package promo.model;

import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Promotion {

	protected String nomPromotion;
	protected LocalDate dateDebutPromotion;
	protected int dureeTotal;
	protected List<Apprenant> apprenants;

	public List<Apprenant> getApprenants() {
		return apprenants;
	}

	protected int delai;

	public Promotion(String nomPromotion, LocalDate dateDebutPromotion, int dureeTotal, List<Apprenant> apprenants) {
		super();
		this.nomPromotion = nomPromotion;
		this.dateDebutPromotion = dateDebutPromotion;
		this.dureeTotal = dureeTotal;
		this.apprenants = apprenants;
	}

	// Méthode pour les jours restants
	public long joursPasses(int dureeTotal) {

// TODO A VOIR PLUS TARD
//		LocalDate dbPromo = LocalDate.parse(dureeTotal, DateTimeFormatter.ISO_LOCAL_DATE);
//		LocalDate dateDuJour = LocalDate.now(Clock.systemDefaultZone());
//		long diff = ChronoUnit.DAYS.between(dbPromo, dateDuJour);
//		System.out.println(diff);
//
//		return diff;
		return 0;
	}

	// Méthode de vérification de retard

	public String verifRetard() {
		if (this.delai > 30) {
			System.out.println("L'apprenant est en retard");
			return "L'apprenant est en retard";
		} else {
			System.out.println("L'apprenant est en retard");
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
