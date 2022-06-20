package promo.model;


public class Alternant extends Apprenant {

	protected String nomEntreprise;
	protected double salaire;
	

	public Alternant(String nom, String prénom, String localDate, String email, String mobile) {
		super(nom, prénom, localDate, email, mobile);
		// TODO Auto-generated constructor stub
	}


	public String getNomEntreprise() {
		return nomEntreprise;
	}


	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}


	public double getSalaire() {
		return salaire;
	}


	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}


	@Override
	public String toString() {
		return "Alternant [nomEntreprise=" + nomEntreprise + ", salaire=" + salaire + "]";
	}

	public void salaire(double percent) {
	
	this.salaire=this.salaire+(this.salaire*percent/100);


	
	}

}
