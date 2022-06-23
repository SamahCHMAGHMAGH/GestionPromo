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
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import promo.controller.PromoAppController;
import promo.model.Promotion;
import promo.model.PromotionList;

public class PromoSelection extends JPanel {
	private JTextField nameField;
	private JLabel nameLabel;

	private JButton updateName;
	private JButton createPromotion;
	private JButton savePromotion;
	private JButton deletePromotion;

	private JButton backupPromoList;
	private JButton restorePromoList;

	private JTable promoJTable;
	private PromoTableModel tableModel;
	private PromoAppController promoController;
	private PromotionList promoList;

	public PromoSelection(PromoAppController promoController, PromotionList promoList) {
		System.out.println("PromoSelection");
		System.out.println(promoList);
		this.setBackground(Color.cyan);
		this.promoController = promoController;
		this.promoList = promoList;

		nameLabel = new JLabel("Name");
		nameField = new JTextField(promoList.getName());
		updateName = new JButton("Update Name");

		createPromotion = new JButton("New Promo");
		savePromotion = new JButton("Update Promo");
		deletePromotion = new JButton("Delete Promo");

		tableModel = new PromoTableModel(promoList.getPromoList());
		promoJTable = new JTable(tableModel);

		backupPromoList = new JButton("Backup Database");
		restorePromoList = new JButton("Restore Database");

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

		gbL.gridx = 0;
		gbL.gridy++;
		this.add(backupPromoList, gbL);
		gbL.gridx += 2;
		this.add(restorePromoList, gbL);

	}

	private void setupListeners() {
		createPromotion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				promoController.createNewPromotion();
			}
		});

		savePromotion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		deletePromotion.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		backupPromoList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

		restorePromoList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});

//		promoJTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if (!e.getValueIsAdjusting()) {
//					ListSelectionModel lsm = (ListSelectionModel) e.getSource();
//					int row = lsm.getMinSelectionIndex();
//					if (!lsm.isSelectionEmpty()) {
//						Promotion promo = promoList.getPromoList().get(row);
//						promoController.changePromotion(promo);
//					}
//				}
//			}
//		});
	}
}
