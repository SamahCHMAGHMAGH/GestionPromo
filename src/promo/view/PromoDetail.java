package promo.view;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import promo.controller.PromoAppController;
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
	private DefaultTableModel tableModelAlternant;
	private PromoAppController promoController;
	
	
	public PromoDetail(PromoAppController promoController, Promotion promo) {
		System.out.println("PromoDetail");
		System.out.println(promo);
		this.promoController = promoController;

		this.setBackground(Color.GRAY);
		
		namePromoLabel = new JLabel("Formations : ");
		namePromoField = new JTextField(promo.getNomPromotion());
		
		dateDebutLabel = new JLabel("Debut de la formation");
		dateDebutField = new JTextField(promo.getDateDebutPromotion().toString());
		
		dureeActuelLabel = new JLabel("Temps passee");
		dureeActuelField = new JTextField(promo.joursPasses().toString());
		
		dureeTotalLabel = new JLabel("Duree totale");
		dureeTotalField = new JTextField(promo.getDureeTotal());
		
	
	

		createAlternant = new JButton("New");
		saveAlternant = new JButton("Save");
		deleteAlternant = new JButton("Delete");
		
		setupLayout();
		setupListeners();
		
	}
	
	private void setupLayout() {
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

		gbL.gridx = 0;
		gbL.gridy++;
		this.add(createAlternant, gbL);
		gbL.gridx++;
		this.add(saveAlternant, gbL);
		gbL.gridx++;
		this.add(deleteAlternant, gbL);

		

		gbL.gridx = 0;
		gbL.gridy++;
		gbL.gridwidth = 3;
		gbL.fill = GridBagConstraints.HORIZONTAL;
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
	}
}
