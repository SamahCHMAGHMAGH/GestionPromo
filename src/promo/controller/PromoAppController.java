package promo.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import promo.model.Alternant;
import promo.model.Apprenant;
import promo.model.Promotion;
import promo.model.PromotionList;
import promo.model.Stagiaire;
import promo.view.MainView;

public class PromoAppController {
	private MainView mainFrame;

	public void start() {
		mainFrame = new MainView(this, testData());
	}

	public PromotionList testData() {

		Stagiaire s1 = new Stagiaire("blanc", "michael", LocalDate.of(2022, 03, 06), "michael@blanc", "0677777",
				"pole emploi", 1000);
		Alternant alt1 = new Alternant("pasquier", "sophie", LocalDate.of(2022, 03, 16), "sophie@pasquier", "076666",
				"IBM", 2000);

		List<Apprenant> apprenants = new ArrayList<>();
		apprenants.add(s1);
		apprenants.add(alt1);
	

		Promotion p1 = new Promotion("JAVA", LocalDate.of(2022, 05, 02), 180, apprenants);

		List<Promotion> promos = new ArrayList<>();
		promos.add(p1);
		PromotionList test = new PromotionList("ICS Formation", promos);

		return test;
	}
	
}
