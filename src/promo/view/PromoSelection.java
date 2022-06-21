package promo.view;

import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.PromotionList;

public class PromoSelection extends JPanel {
	public PromoSelection(PromoAppController promoController, PromotionList promoList) {
		System.out.println("PromoSelection");
		System.out.println(promoList);
	}
}
