package promo.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import promo.controller.PromoAppController;
import promo.model.PromotionList;

public class PromoSelection extends JPanel {
	private JTextField nameField;
	private JLabel nameLabel;
	
	public PromoSelection(PromoAppController promoController, PromotionList promoList) {
		System.out.println("PromoSelection");
		System.out.println(promoList);
		this.setBackground(Color.cyan);

		nameLabel = new JLabel("Name");
		nameField = new JTextField(promoList.getName());

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
		gbR.gridwidth = 2;
		gbR.fill = GridBagConstraints.HORIZONTAL;
	
		this.add(nameLabel, gbL);
		this.add(nameField, gbR);
	}

	private void setupListeners() {
		// TODO Auto-generated method stub
		
	}
}
