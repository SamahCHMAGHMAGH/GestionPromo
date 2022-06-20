package promo.model;

public class Stagiaire extends Apprenant {

	protected String typeAllocation;
	protected double montantAllocation;

	public Stagiaire(String nom, String prénom, String localDate, String email, String mobile) {
		super(nom, prénom, localDate, email, mobile);

	}

	public String getTypeAllocation() {
		return typeAllocation;
	}

	public void setTypeAllocation(String typeAllocation) {
		this.typeAllocation = typeAllocation;
	}

	public double getMontantAllocation() {
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
