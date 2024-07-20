package promo.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ContainerListener;
import java.time.LocalDate;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import promo.controller.PromoAppController;
import promo.model.Alternant;
import promo.model.Apprenant;
import promo.model.Promotion;
import promo.model.Stagiaire;

//dans cette classe on a défini l'affichage du troisième onglet de l'application qui contient la liste des apprenants
//mettre les composants graphiques appropriés aux éléments et les configurer en utilisant Listeners 
//faire appel à le composant de base ou le conteneur JPanel
public class PromoApprenant extends JPanel {

	private static final ContainerListener containerListener = null;
	protected static final AbstractButton Jbutton = null;
	
	//définir le composant graphique approprié pour chaque élément de l'apprenant 
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
	private boolean isNewApprenant = false;

	/**
	 * Constructor for a new apprenant, will as to select the Apprentant type via a
	 * comboBox. Then will create the fields appropriately.
	 * 
	 * @param promoController
	 */
	//faire appel à setUpLayout, setUpListeners et setEnabled pour tous les éléments 
	//qui concernent un apprenant
	public PromoApprenant(PromoAppController promoController, Promotion promo) {
		this.promoController = promoController;
		this.promo = promo;
		this.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.7f));

		isNewApprenant = true;
		String S1[] = { "Stagiaire", "Alternant" };
		comboboxLabel = new JLabel("Apprenant Type");
		combobox = new JComboBox(S1);
		combobox.setSelectedIndex(0);
				
		// All fields will be disabled until after the type of Apprenant is selected
		nomLabel = new JLabel("Nom : ");
		nomField = new JTextField("");
		nomLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		prenomLabel = new JLabel("Prénom : ");
		prenomField = new JTextField("");
		prenomLabel.setFont(new Font("Arial", Font.BOLD, 15));
		prenomField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		dateInscriptionLabel = new JLabel("Date d'inscription : ");
		dateInscriptionField = new JTextField("");
		dateInscriptionLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dateInscriptionField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		emailLabel = new JLabel("Email : ");
		emailField = new JTextField("");
		emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
		emailField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
		

		mobileLabel = new JLabel("Mobile : ");
		mobileField = new JTextField("");
		mobileLabel.setFont(new Font("Arial", Font.BOLD, 15));
		mobileField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		retardLabel = new JLabel("Retard : ");
		retardField = new JTextField("0");
		retardLabel.setFont(new Font("Arial", Font.BOLD, 15));
		retardField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		absenceLabel = new JLabel("Absence : ");
		absenceField = new JTextField("0");
		absenceLabel.setFont(new Font("Arial", Font.BOLD, 15));
		absenceField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		saveApprenant = new JButton("Save");
		cancelApprenant = new JButton("Cancel");

		nomEntrepriseLabel = new JLabel("Nom d'entreprise : ");
		nomEntrepriseField = new JTextField("");
		nomEntrepriseLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomEntrepriseField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		typeAllocationLabel = new JLabel("Type d'allocation : ");
		typeAllocationField = new JTextField("");
		typeAllocationLabel.setFont(new Font("Arial", Font.BOLD, 15));
		typeAllocationField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
		
		montantAllocationStagiaireLabel = new JLabel("Allocation : ");
		montantAllocationField = new JTextField("0");
		montantAllocationStagiaireLabel.setFont(new Font("Arial", Font.BOLD, 15));
		montantAllocationField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		montantSalaireApprenantLabel = new JLabel("Salaire : ");
		montantSalaireField = new JTextField("0");
		montantSalaireApprenantLabel.setFont(new Font("Arial", Font.BOLD, 15));
		montantSalaireField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
		
		 
		SetUpLayout();
		setupListeners();
		setEnabled();
	}
	//une méthode pour définir tous les détails de la liste d'un apprenant
	public PromoApprenant(PromoAppController promoController, Promotion promo, Apprenant apprenant) {
		System.out.println("PromoApprenant");
		System.out.println(apprenant);

		this.setBackground(Color.getHSBColor(0.5f, 0.5f, 0.7f));
		this.promoController = promoController;
		this.promo = promo;
		this.apprenant = apprenant;

		//le composant combobox (un menu déroulant) pour selectionner le type d'apprenant 
		String S1[] = { "Stagiaire", "Alternant" };
		comboboxLabel = new JLabel("Type d'apprenants : ");
		comboboxLabel.setFont(new Font("Arial", Font.BOLD, 15));
		combobox = new JComboBox(S1);
		combobox.setBackground(Color.LIGHT_GRAY);
		combobox.setEnabled(false);

		//dans le cas où on selectionne alternant, on bloque stagiaire
		if (apprenant instanceof Stagiaire) {
			stagiaire = (Stagiaire) apprenant;
			combobox.setSelectedIndex(0);
		} else {
			alternant = (Alternant) apprenant;
			combobox.setSelectedIndex(1);
		}
		//définir la liste de l'alternant
		nomLabel = new JLabel("Nom : ");
		nomField = new JTextField(apprenant.getNom());
		nomLabel.setFont(new Font("Arial", Font.BOLD, 15));
		nomField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		prenomLabel = new JLabel("Prénom : ");
		prenomField = new JTextField(apprenant.getPrenom());
		prenomLabel.setFont(new Font("Arial", Font.BOLD, 15));
		prenomField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		dateInscriptionLabel = new JLabel("Date d'inscription : ");
		dateInscriptionField = new JTextField(apprenant.getDateInscription().toString());
		dateInscriptionLabel.setFont(new Font("Arial", Font.BOLD, 15));
		dateInscriptionField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		emailLabel = new JLabel("Email : ");
		emailField = new JTextField(apprenant.getEmail());
		emailLabel.setFont(new Font("Arial", Font.BOLD, 15));
		emailField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		mobileLabel = new JLabel("Mobile : ");
		mobileField = new JTextField(apprenant.getMobile());
		mobileLabel.setFont(new Font("Arial", Font.BOLD, 15));
		mobileField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		retardLabel = new JLabel("Retard : ");
		retardField = new JTextField(Integer.toString(apprenant.getRetard()));
		retardLabel.setFont(new Font("Arial", Font.BOLD, 15));
		retardField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		absenceLabel = new JLabel("Absence : ");
		absenceField = new JTextField(Integer.toString(apprenant.getAbsence()));
		absenceLabel.setFont(new Font("Arial", Font.BOLD, 15));
		absenceField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		saveApprenant = new JButton("Save");
		cancelApprenant = new JButton("Cancel");
		//si l'apprenant est stagiaire
		if (apprenant instanceof Stagiaire) {
			nomEntrepriseLabel = new JLabel("Entreprise : ");
			nomEntrepriseField = new JTextField("N/A");
			nomEntrepriseLabel.setFont(new Font("Arial", Font.BOLD, 15));
			nomEntrepriseField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
			typeAllocationLabel = new JLabel("Type d'allocation : ");
			typeAllocationField = new JTextField(((Stagiaire) apprenant).getTypeAllocation());
			typeAllocationLabel.setFont(new Font("Arial", Font.BOLD, 15));
			typeAllocationField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

			montantAllocationStagiaireLabel = new JLabel("Allocation : ");
			montantAllocationField = new JTextField(((Stagiaire) apprenant).getMontantAllocation().toString());
			montantAllocationStagiaireLabel.setFont(new Font("Arial", Font.BOLD, 15));
			montantAllocationField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

			montantSalaireApprenantLabel = new JLabel("Salaire : ");
			montantSalaireField = new JTextField("n/a");
			montantSalaireApprenantLabel.setFont(new Font("Arial", Font.BOLD, 15));
			montantSalaireField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		}
		//si l'apprenant est alternant
		if (apprenant instanceof Alternant) {
			nomEntrepriseLabel = new JLabel("Entreprise : ");
			nomEntrepriseField = new JTextField(((Alternant) apprenant).getNomEntreprise());
			nomEntrepriseLabel.setFont(new Font("Arial", Font.BOLD, 15));
			nomEntrepriseField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
			
			montantSalaireApprenantLabel = new JLabel("Salaire : ");
			montantSalaireField = new JTextField(((Alternant) apprenant).getSalaire().toString());

			montantSalaireApprenantLabel.setFont(new Font("Arial", Font.BOLD, 15));
			montantSalaireField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
			
			typeAllocationLabel = new JLabel("Type d' allocation : ");
			typeAllocationField = new JTextField("n/a");
			typeAllocationLabel.setFont(new Font("Arial", Font.BOLD, 15));
			typeAllocationField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

			montantAllocationStagiaireLabel = new JLabel("Allocation : ");
			montantAllocationField = new JTextField("n/a");
			montantAllocationStagiaireLabel.setFont(new Font("Arial", Font.BOLD, 15));
			montantAllocationField.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));
		}

		SetUpLayout();
		setupListeners();
	}
	//l'écouteur d'action est averti chaque fois qu'on clique sur le bouton ou l'élément de menu
	private void setupListeners() {
		cancelApprenant.addActionListener(new ActionListener() {
			
			//écouteur d'action pour effectuer cancelApprenant
			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.cancelApprenantClicked(promo);
			}
		});

		saveApprenant.addActionListener(new ActionListener() {
			 
			//action effectuée pour un nouveau apprenant(ActionEvent), cet évènement est déclanché dès
			//qu'on clique sur un bouton
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isNewApprenant) {
					// when we are creating a new apprenant we need to create
					// an instance of the sub class object then cast to apprenant;
					if (combobox.getSelectedItem().toString() == "Stagiaire") {
						stagiaire = new Stagiaire();
					} else {
						alternant = new Alternant();
					}
					apprenant = (Apprenant) alternant;
				}
				if (combobox.getSelectedItem().toString() == "Stagiaire") {
					stagiaire.setTypeAllocation(typeAllocationField.getText());
					stagiaire.setMontantAllocation(Double.parseDouble(montantAllocationField.getText()));
				} else {
					alternant.setSalaire(Double.parseDouble(montantSalaireField.getText()));
					alternant.setNomEntreprise(nomEntrepriseField.getText());
				}
				apprenant.setNom(nomField.getText());
				apprenant.setPrenom(prenomField.getText());
				apprenant.setEmail(emailField.getText());
				apprenant.setMobile(mobileField.getText());
				apprenant.setDateInscription(LocalDate.parse(dateInscriptionField.getText()));
				apprenant.setRetard(Integer.parseInt(retardField.getText()));
				apprenant.setAbsence(Integer.parseInt(absenceField.getText()));


				promoController.saveApprenantClicked(promo, apprenant, isNewApprenant);
				
				
			}
		});

		combobox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setEnabled();
			}
		});
	
	}
	
	//si on selectionne "Stagiaire" boquer les champs de nomEtreprises et montantSalaire
	//activer les champs de typeAllocation et montantAllocation 
	//sinon on inverse au cas où on selectionne "alternant"
	public void setEnabled() {
		if (combobox.getSelectedItem().toString() == "Stagiaire") {
			nomEntrepriseField.setEnabled(false);
			montantSalaireField.setEnabled(false);

			typeAllocationField.setEnabled(true);
			montantAllocationField.setEnabled(true);
		} else {
			nomEntrepriseField.setEnabled(true);
			montantSalaireField.setEnabled(true);

			typeAllocationField.setEnabled(false);
			montantAllocationField.setEnabled(false);
		}
	}
	
	//utilisation de GridLayout pour organiser et positionner tous les éléments apprenant dans une grille rectangulaire. 
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

		this.add(typeAllocationLabel, gbL);
		this.add(typeAllocationField, gbR);
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
