package promo.model;


import java.time.Clock;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;



public class Promotion {

	protected String nomPromotion;
	protected LocalDate dateDebutPromotion;
	protected CharSequence dureeTotal;
	protected List<Apprenant> apprenants;
	protected int delai;
	
	
	public Promotion(String nomPromotion, LocalDate dateDebutPromotion, CharSequence dureeTotal, List<Apprenant> apprenants) {
		super();
		this.nomPromotion = nomPromotion;
		this.dateDebutPromotion = dateDebutPromotion;
		this.dureeTotal = dureeTotal;
		this.apprenants = apprenants;
	}
	
	// Méthode pour les jours restants
	public long joursPasses(CharSequence dureeTotal) {
		
		// TODO A VOIR PLUS TARD
		LocalDate dbPromo = LocalDate.parse(dureeTotal, DateTimeFormatter.ISO_LOCAL_DATE);
	 	LocalDate dateDuJour = LocalDate.now(Clock.systemDefaultZone());
	 	long diff = ChronoUnit.DAYS.between(dbPromo, dateDuJour); 
        System.out.println(diff);
	        
	        return diff;
	       }
	
	
	// Méthode de vérification de retard
	
	public String verifRetard() {
		if (this.delai > 30) {
			System.out.println("L'apprenant est en retard");
			return "L'apprenant est en retard";
		}
		else {
			System.out.println("L'apprenant est en retard");
			return "Tout va bien";
		}
	}

}
