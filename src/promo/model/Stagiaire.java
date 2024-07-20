package promo.model;

import java.time.LocalDate;

//c'est une classe fille qui va hériter tous les attributs de la classe parent "apprenant" en ajoutant des autres 
//qui correspondent à un stagiaire(type et montant d'allocation)
public class Stagiaire extends Apprenant {

	protected String typeAllocation;
	protected double montantAllocation;
	public Stagiaire() {
		super();
	}
	public Stagiaire(String nom, String prenom, LocalDate dateInscription, String email, String mobile,
			String typeAllocation, double montantAllocation) {
		super(nom, prenom, dateInscription, email, mobile);
		this.typeAllocation = typeAllocation;
		this.montantAllocation = montantAllocation;
	}
	//getters et setters
	public String getTypeAllocation() {
		return typeAllocation;
	}

	public void setTypeAllocation(String typeAllocation) {
		this.typeAllocation = typeAllocation;
	}

	public Double getMontantAllocation() {
		return montantAllocation;
	}

	public void setMontantAllocation(double montantAllocation) {
		this.montantAllocation = montantAllocation;
	}

	@Override
	public String toString() {
		return "Stagiaire [typeAllocation=" + typeAllocation + ", montantAllocation=" + montantAllocation + "]";
	}

	public void montantAllocation(double percent) {

		this.montantAllocation = this.montantAllocation + (this.montantAllocation * percent / 100);

	}

}
