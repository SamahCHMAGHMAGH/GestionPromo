package promo.model;

import java.time.LocalDate;

public abstract class Apprenant {

	private String nom;
	private String prenom;
	private LocalDate dateInscription;
	private String email;
	private String mobile;
	private int delai;
	private int absence;

	public Apprenant(String nom, String prenom, LocalDate dateInscription, String email, String mobile) {

		this.nom = nom;
		this.prenom = prenom;
		this.dateInscription = dateInscription;
		this.email = email;
		this.mobile = mobile;
		this.delai = 0;
		this.absence = 0;
	}

	
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

	@Override
	public String toString() {
		return "Apprenant [nom=" + nom + ", prénom=" + prenom + ", localDate=" + dateInscription + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

}
