package promo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import promo.controller.PromoAppController;
import promo.model.Alternant;
import promo.model.Apprenant;
import promo.model.Promotion;
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
	private Stagiaire stagiaire;
	private Alternant alternant;

	private PromoAppController promoController;
	private Promotion promo;
	private Apprenant apprenant;

	/**
	 * Constructor for a new apprenant, will as to select the Apprentant type via a
	 * comboBox. Then will create the fields appropriately.
	 * 
	 * @param promoController
	 */
	public PromoApprenant(PromoAppController promoController, Promotion promo) {
		this.promoController = promoController;
		this.promo = promo;

		String S1[] = { "Stagiaire", "Alternant" };
		comboboxLabel = new JLabel("Apprenant Type");
		combobox = new JComboBox(S1);

		// All fields will be disabled until after the type of Apprenant is selected
		nomLabel = new JLabel("Nom");
		nomField = new JTextField("");

		prenomLabel = new JLabel("Prénom");
		prenomField = new JTextField("");

		dateInscriptionLabel = new JLabel("Date d'inscription");
		dateInscriptionField = new JTextField("");

		emailLabel = new JLabel("émail");
		emailField = new JTextField("");

		mobileLabel = new JLabel("mobile");
		mobileField = new JTextField("");

		retardLabel = new JLabel("retard");
		retardField = new JTextField("0");

		absenceLabel = new JLabel("absence");
		absenceField = new JTextField("0");

		saveApprenant = new JButton("Save");
		cancelApprenant = new JButton("Cancel");

		nomEntrepriseLabel = new JLabel("Nom d'entreprise");
		nomEntrepriseField = new JTextField("");

		typeAllocationLabel = new JLabel("rémunération");
		typeAllocationField = new JTextField("");

		montantAllocationStagiaireLabel = new JLabel("allocation");
		montantAllocationField = new JTextField("0");

		montantSalaireApprenantLabel = new JLabel("salaire");
		montantSalaireField = new JTextField("0");

		SetUpLayout();
		setupListeners();
		setEnabled();
	}

	public PromoApprenant(PromoAppController promoController, Promotion promo, Apprenant apprenant) {
		System.out.println("PromoApprenant");
		System.out.println(apprenant);

		this.setBackground(Color.cyan);
		this.promoController = promoController;
		this.promo = promo;
		this.apprenant = apprenant;

		String S1[] = { "Stagiaire", "Alternant" };
		comboboxLabel = new JLabel("Apprenant Type");
		combobox = new JComboBox(S1);
		combobox.setEnabled(false);

		if (apprenant instanceof Stagiaire) {
			stagiaire = (Stagiaire) apprenant;
			combobox.setSelectedIndex(0);
		} else {
			alternant = (Alternant) apprenant;
			combobox.setSelectedIndex(1);
		}

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
		setupListeners();
	}

	private void setupListeners() {
		cancelApprenant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.cancelApprenantClicked(promo);
			}
		});

		saveApprenant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (combobox.getSelectedItem().toString() == "Stagiaire") {
					stagiaire.setTypeAllocation(typeAllocationField.getText());
					stagiaire.setMontantAllocation(Double.parseDouble(montantAllocationField.getText()));
					promoController.saveApprenantClicked(promo, stagiaire);
				} else {
					alternant.setSalaire(Double.parseDouble(montantSalaireField.getText()));
					alternant.setNomEntreprise(nomEntrepriseField.getText());
					promoController.saveApprenantClicked(promo, alternant);
				}
				apprenant.setNom(nomField.getText());
				apprenant.setEmail(emailField.getText());
//TODO Fill in all the other fields
				promoController.saveApprenantClicked(promo, apprenant);
			}
		});

		combobox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// apprenant is null when we are creating a new apprenant
				// so create an instance of the sub class object then cast
				// to apprenant;
				if (apprenant == null) {
					if (combobox.getSelectedItem().toString() == "Stagiaire") {
						stagiaire = new Stagiaire();
					} else {
						alternant = new Alternant();
					}
					apprenant = (Apprenant) alternant;
				}
				setEnabled();
			}
		});
	}

	public void setEnabled() {
		if (combobox.getSelectedItem().toString() == "Stagiaire") {
			nomEntrepriseField.setEnabled(false);
			montantSalaireField.setEnabled(false);

			typeAllocationField.setEnabled(true);
			montantAllocationField.setEnabled(true);
		} else {
			nomEntrepriseField.setEnabled(true);
			montantSalaireField.setEnabled(true);

			typeAllocationField.setEnabled(true);
			montantAllocationField.setEnabled(false);
		}
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
}
