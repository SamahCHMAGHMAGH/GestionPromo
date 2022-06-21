package promo.view;

import java.awt.Color;

import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.Promotion;

public class PromoDetail extends JPanel {
	public PromoDetail(PromoAppController promoController, Promotion promo) {
		System.out.println("PromoDetail");
		System.out.println(promo);

		this.setBackground(Color.GRAY);
	}
}
