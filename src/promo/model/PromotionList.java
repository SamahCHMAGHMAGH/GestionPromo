package promo.model;

import java.io.Serializable;
import java.util.List;

//méthode pour gérer le nom du centre et la liste de promotion
public class PromotionList implements Serializable {
	private String name;
	private List<Promotion> promoList;

	public PromotionList(String name, List<Promotion> promoList) {
		this.setPromoList(promoList);
		this.name = name;
	}
	//méthode avec retour pour la liste de promotion
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
	//récupérer le nom du centre
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
