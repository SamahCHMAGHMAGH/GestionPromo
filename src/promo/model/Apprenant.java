package promo.model;

import java.io.Serializable;
import java.time.LocalDate;

//c'est classe parent qui est abstraite, elle n'est pas instanciable, elle va servir les autres classes héritées(stagiaire et alternant)  
//on a crée tous les attributs que le centre de formation utilise pour chaque apprenant 
public abstract class Apprenant implements Serializable {

	private String nom;
	private String prenom;
	private LocalDate dateInscription;
	private String email;
	private String mobile;
	private int retard;
	private int absence;

	public Apprenant() {
	}

	public Apprenant(String nom, String prenom, LocalDate dateInscription, String email, String mobile) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateInscription = dateInscription;
		this.email = email;
		this.mobile = mobile;
		this.retard = 0;
		this.absence = 0;
	}
	//getters et setters
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateInscription() {
		return dateInscription;
	}

	public void setDateInscription(LocalDate dateInscription) {
		this.dateInscription = dateInscription;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getRetard() {
		return retard;
	}

	public void setRetard(int retard) {
		this.retard = retard;
	}

	public int getAbsence() {
		return absence;
	}

	public void setAbsence(int absence) {
		this.absence = absence;
	}

	@Override
	public String toString() {
		return "Apprenant [nom=" + nom + ", prénom=" + prenom + ", localDate=" + dateInscription + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

}
