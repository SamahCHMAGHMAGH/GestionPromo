package promo.view;

import java.awt.Color;

import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.Apprenant;

public class PromoApprenant extends JPanel {
	public PromoApprenant(PromoAppController promoController, Apprenant apprenant) {
		System.out.println("PromoApprenant");
		System.out.println(apprenant);

		this.setBackground(Color.LIGHT_GRAY);
	}
}
