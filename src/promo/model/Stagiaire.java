package promo.model;

import java.time.LocalDate;

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
