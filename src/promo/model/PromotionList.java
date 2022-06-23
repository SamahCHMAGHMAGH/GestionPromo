package promo.model;

import java.util.List;

public class PromotionList {
	private String name;
	private List<Promotion> promoList;

	public PromotionList(String name, List<Promotion> promoList) {
		this.setPromoList(promoList);
		this.name = name;
	}

	public List<Promotion> getPromoList() {
		return promoList;
	}

	public void setPromoList(List<Promotion> promoList) {
		this.promoList = promoList;
	}

	@Override
	public String toString() {
		String s = "PromoList: " + this.name + ", [";
		for (Promotion promotion : promoList) {
			s += "\n" + promotion;
		}
		s += "\n]";
		return s;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addPromotion(Promotion promo) {
		promoList.add(promo);		
	}
}
