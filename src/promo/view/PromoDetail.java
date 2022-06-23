package promo.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import promo.controller.PromoAppController;
import promo.model.Apprenant;
import promo.model.Promotion;

public class PromoDetail extends JPanel {

	private JTextField namePromoField;
	private JLabel namePromoLabel;

	private JButton createAlternant;
	private JButton saveAlternant;
	private JButton deleteAlternant;
	private JTextField nomPromoField;
	private JLabel dateDebutLabel;
	private JTextField dateDebutField;
	private JLabel dureeActuelLabel;
	private JTextField dureeActuelField;
	private JLabel dureeTotalLabel;
	private JTextField dureeTotalField;

	private JTable alternantTable;
	private ApprenantTableModel tableModelAlternant;
	private PromoAppController promoController;
	private Promotion promo;
	private JMenuItem saveItem, saveAllItem;

	public PromoDetail(PromoAppController promoController, Promotion promo) {
		System.out.println("PromoDetail");
		System.out.println(promo);
		this.promoController = promoController;
		this.promo = promo;

		this.setBackground(Color.getHSBColor(200, 100, 50));

		namePromoLabel = new JLabel("Formations : ");
		namePromoField = new JTextField(promo.getNomPromotion());
		namePromoLabel.setFont(new Font("Arial", Font.BOLD, 15));
	

		dateDebutLabel = new JLabel("Debut de la formation : ");
		dateDebutField = new JTextField(promo.getDateDebutPromotion().toString());
		dateDebutLabel.setFont(new Font("Arial", Font.BOLD, 15));
	

		dureeActuelLabel = new JLabel("Temps passee : ");
		dureeActuelField = new JTextField(promo.joursPasses().toString());
		dureeActuelLabel.setFont(new Font("Arial", Font.BOLD, 15));
	

		dureeTotalLabel = new JLabel("Duree totale : ");
		dureeTotalField = new JTextField(Integer.toString(promo.getDureeTotal()));
		dureeTotalLabel.setFont(new Font("Arial", Font.BOLD, 15));
		

		createAlternant = new JButton("New");
		saveAlternant = new JButton("Save");
		deleteAlternant = new JButton("Delete");

		tableModelAlternant = new ApprenantTableModel(promo.getApprenants());
		alternantTable = new JTable(tableModelAlternant);
		alternantTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		alternantTable.setBackground(Color.getHSBColor(200, 100, 50));
		
		setupLayout();
		setupListeners();

	}

	private void setupLayout() {
		this.setLayout(new GridBagLayout());
		GridBagConstraints gbL = new GridBagConstraints();
		gbL.weightx = 1;
		gbL.gridx = 0;
		gbL.gridy = 0;
		gbL.anchor = GridBagConstraints.LINE_END;
		gbL.insets = new Insets(10, 10, 10, 10);

		GridBagConstraints gbR = new GridBagConstraints();
		gbR.weightx = 1;
		gbR.gridx = 1;
		gbR.gridy = 0;
		gbR.gridwidth = 1;
		gbR.fill = GridBagConstraints.HORIZONTAL;

		this.add(namePromoLabel, gbL);
		this.add(namePromoField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(dateDebutLabel, gbL);
		this.add(dateDebutField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(dureeActuelLabel, gbL);
		this.add(dureeActuelField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		this.add(dureeTotalLabel, gbL);
		this.add(dureeTotalField, gbR);
		gbL.gridy++;
		gbR.gridy++;

		gbL.anchor = GridBagConstraints.LINE_START;
		gbL.weightx = 0.5;

		gbL.gridx = 25;
		gbL.gridy++;
		this.add(createAlternant, gbL);
		gbL.gridx = 30;
		this.add(saveAlternant, gbL);
		gbL.gridx = 35;
		this.add(deleteAlternant, gbL);

		gbL.gridx = 25;
		gbL.gridy = 1;
		gbL.gridwidth = 10;
		gbL.gridheight =4;
		gbL.fill = GridBagConstraints.BOTH;
		gbL.weighty = 1;
		this.add(new JScrollPane(alternantTable), gbL);
	}

	private void setupListeners() {
		createAlternant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		saveAlternant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		deleteAlternant.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		alternantTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
					int row = lsm.getMinSelectionIndex();
					if (!lsm.isSelectionEmpty()) {
						Apprenant apprenant = promo.getApprenants().get(row);
						promoController.changeApprenant(apprenant);
					}
				}
			}
		});

	}

	public void changePromotion(Promotion promo) {
		namePromoField.setText(promo.getNomPromotion());
		dateDebutField.setText(promo.getDateDebutPromotion().toString());
		dureeActuelField.setText(promo.joursPasses().toString());
		dureeTotalField.setText(Integer.toString(promo.getDureeTotal()));
		
		tableModelAlternant = new ApprenantTableModel(promo.getApprenants());
		alternantTable = new JTable(tableModelAlternant);
	}
}
