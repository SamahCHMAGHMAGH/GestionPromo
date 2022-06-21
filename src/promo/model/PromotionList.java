package promo.model;

import java.util.List;

public class PromotionList {
	private List<Promotion> promoList;

	public PromotionList(List<Promotion> promoList) {
		this.setPromoList(promoList);
	}

	public List<Promotion> getPromoList() {
		return promoList;
	}

	public void setPromoList(List<Promotion> promoList) {
		this.promoList = promoList;
	}

	@Override
	public String toString() {
		String s = "PromoList:[";
		for (Promotion promotion : promoList) {
			s += "\n" + promotion;
		}
		s += "\n]";
		return s;
	}
}
