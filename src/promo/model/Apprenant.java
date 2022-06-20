package promo.model;

public abstract class Apprenant {

	protected String nom;
	protected String prenom;
	protected String localDate;
	protected String email;
	protected String mobile;

	public Apprenant(String nom, String prenom, String localDate, String email, String mobile) {

		this.nom = nom;
		this.prenom = prenom;
		this.localDate = localDate;
		this.email = email;
		this.mobile = mobile;
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

	public String getLocalDate() {
		return localDate;
	}

	public void setLocalDate(String localDate) {
		this.localDate = localDate;
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

	@Override
	public String toString() {
		return "Apprenant [nom=" + nom + ", prénom=" + prenom + ", localDate=" + localDate + ", email=" + email
				+ ", mobile=" + mobile + "]";
	}

}
