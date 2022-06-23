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
	private MainView mainView;

	public void start() {
		mainView = new MainView(this, testData());
	}

	public PromotionList testData() {

		Stagiaire s1 = new Stagiaire("blanc", "michael", LocalDate.of(2022, 03, 06), "michael@blanc", "0677777",
				"pole emploi", 1000);
		Alternant alt1 = new Alternant("pasquier", "sophie", LocalDate.of(2022, 03, 16), "sophie@pasquier", "076666",
				"IBM", 2000);
		Stagiaire s2 = new Stagiaire("blanc", "laurent", LocalDate.of(2022, 03, 05), "laurent@blanc", "0677é77",
				"pole emploi", 1000);
		Alternant alt2 = new Alternant("paul", "pogba", LocalDate.of(2022, 03, 10), "paul@pogba", "066666", "IBM",
				2000);
		Stagiaire s3 = new Stagiaire("romain", "perraud", LocalDate.of(2022, 02, 03), "romain@perraud", "0677é77",
				"pole emploi", 1000);

		List<Apprenant> apprenants1 = new ArrayList<>();
		apprenants1.add(s1);
		apprenants1.add(alt1);
		apprenants1.add(s2);
		List<Apprenant> apprenants2 = new ArrayList<>();
		apprenants2.add(alt2);
		apprenants2.add(s3);

		Promotion p1 = new Promotion("JAVA", LocalDate.of(2022, 05, 02), 180, apprenants1);
		Promotion p2 = new Promotion("PHP", LocalDate.of(2022, 06, 01), 140, apprenants2);

		List<Promotion> promos = new ArrayList<>();
		promos.add(p1);
		promos.add(p2);
		PromotionList test = new PromotionList("ICS Formation", promos);

		return test;
	}

	public void createNewPromotion() {
		mainView.createNewPromotion();
	}

	public void updatePromotion(Promotion promo) {
		mainView.updatePromotion(promo);
	}

	public void deletePromotion(Promotion promo) {
		mainView.deletePromotion(promo);
	}

	public void createNewApprenant() {
		mainView.createNewApprenant();
	}
}
