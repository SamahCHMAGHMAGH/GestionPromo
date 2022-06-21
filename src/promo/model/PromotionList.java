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
		return "PromotionList [promoList=" + promoList + "]";
	}
}
