package promo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import promo.controller.PromoAppController;
import promo.model.Promotion;
import promo.model.PromotionList;

//dans cette classe on a d�fini l'affichage du premier onglet de l'application qui contient la liste de promotion
//mettre les composants graphiques appropri�s aux �l�ments et les configurer en utilisant Listeners 
//faire appel � le composant de base ou le conteneur JPanel
public class PromoSelection extends JPanel {
	
	//d�finir le composant graphique appropri� pour chaque �l�ment 
	private JTextField nameField;
	private JLabel nameLabel;

	private JButton updateName;
	private JButton createPromotion;
	private JButton savePromotion;
	private JButton deletePromotion;

	private JButton backupPromoList;

	private JTable promoJTable;
	private PromoTableModel tableModel;
	private PromoAppController promoController;
	private PromotionList promoList;
	private Promotion selectedPromotion;

	//getters et setters pour r�cup�rer la promotion selectionn�e
	public Promotion getSelectedPromotion() {
		return selectedPromotion;
	}

	public void setSelectedPromotion(Promotion selectedPromotion) {
		this.selectedPromotion = selectedPromotion;
	}

	public PromoSelection(PromoAppController promoController, PromotionList promoList) {
		System.out.println("PromoSelection");
		System.out.println(promoList);
		this.setBackground(Color.getHSBColor(0.5f, 0.6f, 0.6f));
		this.promoController = promoController;
		this.promoList = promoList;

		nameLabel = new JLabel("Name : ");
		nameField = new JTextField(promoList.getName());

		nameLabel.setFont(new Font("Arial", Font.BOLD, 15));

		updateName = new JButton("Update Name");

		createPromotion = new JButton("New Promo");
		savePromotion = new JButton("Update Promo");
		savePromotion.setEnabled(false);
		deletePromotion = new JButton("Delete Promo");
		deletePromotion.setEnabled(false);

		tableModel = new PromoTableModel(promoList.getPromoList());
		promoJTable = new JTable(tableModel);
		promoJTable.setBackground(Color.getHSBColor(0.1f, 0.75f, 1f));

		backupPromoList = new JButton("Backup Database");
		setupLayout();
		setupListeners();
	}
	//faire appel � Layout pour positionner les �l�ments � l'int�rieur d'un conteneur en utilisant Grid
	private void setupLayout() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbL = new GridBagConstraints();
		gbL.weightx = 0.1;
		gbL.gridx = 0;
		gbL.gridy = 0;
		gbL.anchor = GridBagConstraints.LINE_END;
		gbL.insets = new Insets(2, 10, 2, 10);

		GridBagConstraints gbR = new GridBagConstraints();
		gbR.weightx = 0.8;
		gbR.gridx = 1;
		gbR.gridy = 0;
		gbR.gridwidth = 1;
		gbR.fill = GridBagConstraints.HORIZONTAL;

		this.add(nameLabel, gbL);
		this.add(nameField, gbR);

		gbL.gridy++;
		gbR.gridy++;
		gbR.gridx = 1;
		this.add(updateName, gbR);

		gbL.gridx = 0;
		gbL.gridy++;
		gbL.gridwidth = 3;
		gbL.fill = GridBagConstraints.BOTH;
		gbL.weighty = 1;
		this.add(new JScrollPane(promoJTable), gbL);

		gbL.gridy++;
		gbL.weighty = 0;
		gbL.gridwidth = 1;
		gbL.fill = GridBagConstraints.NONE;
		gbL.anchor = GridBagConstraints.LINE_START;
		gbL.weightx = 0.5;

		gbL.gridx = 0;
		gbL.gridy++;
		this.add(createPromotion, gbL);
		gbL.gridx++;
		this.add(savePromotion, gbL);
		gbL.gridx++;
		this.add(deletePromotion, gbL);

		gbL.gridy++;
		this.add(backupPromoList, gbL);

	}
	// configurer les boutons des �l�m�nts pour avoir des diff�rentes actions, en utilisant event listener
	private void setupListeners() {
		updateName.addActionListener(new ActionListener() {
			//m�thode pour effectu�e l'action
			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.updateNameClicked(nameField.getText());

			}
		});
		
		createPromotion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.newPromotionClicked();
			}
		});

		savePromotion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.updatePromotionClicked(selectedPromotion, false);
			}
		});

		deletePromotion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.deletePromotionClicked(selectedPromotion);
			}
		});

		backupPromoList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.backupPromoList();
			}
		});

		promoJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			//une m�thode pour configurer et activer le bouton delete et save pour la promotion choisie 
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					deletePromotion.setEnabled(true);
					savePromotion.setEnabled(true);

					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					int row = lsm.getMinSelectionIndex();
					if (!lsm.isSelectionEmpty()) {
						Promotion promo = promoList.getPromoList().get(row);
						selectedPromotion = promo;
					}
				}
			}
		});
	}
}
