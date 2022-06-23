package promo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import promo.controller.PromoAppController;
import promo.model.Alternant;
import promo.model.Apprenant;
import promo.model.Stagiaire;

public class PromoApprenant extends JPanel {

	// on a défini les attributs par la classe "JLabel" qui permet d'afficher une
	// chaîne courte
	// et par la classe "JTextField" qui permet de modifier une seule ligne de texte
	// on a rajouté a la fin deux attributs de type classe pour sauvgarder et
	// annuler
	private JLabel nomLabel;
	private JLabel prenomLabel;
	private JLabel dateInscriptionLabel;
	private JLabel emailLabel;
	private JLabel mobileLabel;
	private JLabel retardLabel;
	private JLabel absenceLabel;
	private JTextField nomField;
	private JTextField prenomField;
	private JTextField dateInscriptionField;
	private JTextField emailField;
	private JTextField mobileField;
	private JTextField retardField;
	private JTextField absenceField;
	private JButton saveApprenant;
	private JButton cancelApprenant;
	private PromoAppController promoController;
	private JLabel nomEntrepriseLabel;
	private JTextField nomEntrepriseField;
	private JLabel typeAllocationLabel;
	private JTextField typeAllocationField;
	private JLabel montantAllocationStagiaireLabel;
	private JTextField montantAllocationField;
	private JLabel montantSalaireApprenantLabel;
	private JTextField montantSalaireField;
	private JLabel comboboxLabel;
	private JComboBox combobox;

	public PromoApprenant(PromoAppController promoController, Apprenant apprenant) {
		System.out.println("PromoApprenant");
		System.out.println(apprenant);

		this.setBackground(Color.cyan);
		this.promoController = promoController;

		String S1[] = {"Stagiaire", "Alternant"};
		comboboxLabel = new JLabel("Apprenant Type");
		combobox = new JComboBox(S1);
		
		nomLabel = new JLabel("Nom");
		nomField = new JTextField(apprenant.getNom());
		nomLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomField.setBackground(Color.getHSBColor(200, 100, 50));
		
		prenomLabel = new JLabel("Prénom");
		prenomField = new JTextField(apprenant.getPrenom());
		prenomLabel.setFont(new Font("Arial", Font.BOLD, 15));
		prenomField.setBackground(Color.getHSBColor(200, 100, 50));

		dateInscriptionLabel = new JLabel("Date d'inscription");
		dateInscriptionField = new JTextField(apprenant.getDateInscription().toString());
		dateInscriptionLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dateInscriptionField.setBackground(Color.getHSBColor(200, 100, 50));
		
		emailLabel = new JLabel("Email");
		emailField = new JTextField(apprenant.getEmail());
		emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
		emailField.setBackground(Color.getHSBColor(200, 100, 50));

		mobileLabel = new JLabel("Mobile");
		mobileField = new JTextField(apprenant.getMobile());
		mobileLabel.setFont(new Font("Arial", Font.BOLD, 15));
		mobileField.setBackground(Color.getHSBColor(200, 100, 50));
		

		retardLabel = new JLabel("Retard");
		retardField = new JTextField(Integer.toString(apprenant.getRetard()));
		retardLabel.setFont(new Font("Arial", Font.BOLD, 15));
		retardField.setBackground(Color.getHSBColor(200, 100, 50));

		absenceLabel = new JLabel("Absence");
		absenceField = new JTextField(Integer.toString(apprenant.getRetard()));
		absenceLabel.setFont(new Font("Arial", Font.BOLD, 15));
		absenceField.setBackground(Color.getHSBColor(200, 100, 50));

		saveApprenant = new JButton("Save");
		cancelApprenant = new JButton("Cancel");

		if (apprenant instanceof Stagiaire) {
			nomEntrepriseLabel = new JLabel("Nom d'entreprise");
			nomEntrepriseField = new JTextField("N/A");
			nomEntrepriseLabel.setFont(new Font("Arial", Font.BOLD, 15));
			nomEntrepriseField.setBackground(Color.getHSBColor(200, 100, 50));

			typeAllocationLabel = new JLabel("rémunération");
			typeAllocationField = new JTextField(((Stagiaire) apprenant).getTypeAllocation());
			typeAllocationLabel.setFont(new Font("Arial", Font.BOLD, 15));
			typeAllocationField.setBackground(Color.getHSBColor(200, 100, 50));

			montantAllocationStagiaireLabel = new JLabel("allocation");
			montantAllocationField = new JTextField(((Stagiaire) apprenant).getMontantAllocation().toString());
			montantAllocationStagiaireLabel.setFont(new Font("Arial", Font.BOLD, 15));
			montantAllocationField.setBackground(Color.getHSBColor(200, 100, 50));

			montantSalaireApprenantLabel = new JLabel("salaire");
			montantSalaireField = new JTextField("n/a");
			montantSalaireApprenantLabel.setFont(new Font("Arial", Font.BOLD, 15));
			montantSalaireField.setBackground(Color.getHSBColor(200, 100, 50));

		}
		if (apprenant instanceof Alternant) {
			nomEntrepriseLabel = new JLabel("nom");
			nomEntrepriseField = new JTextField(((Alternant) apprenant).getNomEntreprise());

			montantSalaireApprenantLabel = new JLabel("salaire");
			montantSalaireField = new JTextField(((Alternant) apprenant).getSalaire().toString());

			typeAllocationLabel = new JLabel("salaire");
			typeAllocationField = new JTextField("n/a");

			montantAllocationStagiaireLabel = new JLabel("allocation");
			montantAllocationField = new JTextField("n/a");
		}

		SetUpLayout();

	}

	private void SetUpLayout() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbL = new GridBagConstraints();
		gbL.weightx = 0.1;
		gbL.gridx = 0;
		gbL.gridy = 0;
		gbL.anchor = GridBagConstraints.LINE_END;
		gbL.insets = new Insets(0, 0, 0, 10);

		GridBagConstraints gbR = new GridBagConstraints();
		gbR.weightx = 0.8;
		gbR.gridx = 1;
		gbR.gridy = 0;
		gbR.gridwidth = 1;
		gbR.fill = GridBagConstraints.HORIZONTAL;
	
		this.add(comboboxLabel, gbL);
		this.add(combobox, gbR);
		gbL.gridy++;
		gbR.gridy++;
	
		this.add(nomEntrepriseLabel, gbL);
		this.add(nomEntrepriseField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(nomLabel, gbL);
		this.add(nomField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(prenomLabel, gbL);
		this.add(prenomField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(dateInscriptionLabel, gbL);
		this.add(dateInscriptionField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(emailLabel, gbL);
		this.add(emailField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(mobileLabel, gbL);
		this.add(mobileField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(retardLabel, gbL);
		this.add(retardField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(montantAllocationStagiaireLabel, gbL);
		this.add(montantAllocationField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(montantSalaireApprenantLabel, gbL);
		this.add(montantSalaireField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(absenceLabel, gbL);
		this.add(absenceField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(saveApprenant, gbL);
		this.add(cancelApprenant, gbR);
		gbL.gridy++;
		gbR.gridy++;

	}

	public void changeApprenant(Apprenant apprenant) {
		nomField.setText(apprenant.getNom());
		prenomField.setText(apprenant.getPrenom());
		dateInscriptionField.setText(apprenant.getDateInscription().toString());
		emailField.setText(apprenant.getEmail());
		mobileField.setText(apprenant.getMobile());
		retardField.setText(Integer.toString(apprenant.getRetard()));
		absenceField.setText(Integer.toString(apprenant.getRetard()));
		
		if (apprenant instanceof Stagiaire) {
			nomEntrepriseField.setText("N/A");
			typeAllocationField.setText(((Stagiaire) apprenant).getTypeAllocation());
			montantAllocationField.setText(((Stagiaire) apprenant).getMontantAllocation().toString());
			montantSalaireField.setText("n/a");
		}

		if (apprenant instanceof Alternant) {
			nomEntrepriseField.setText(((Alternant) apprenant).getNomEntreprise());
			montantSalaireField.setText(((Alternant) apprenant).getSalaire().toString());
			typeAllocationField.setText("n/a");
			montantAllocationField.setText("n/a");
		}
	}

}
