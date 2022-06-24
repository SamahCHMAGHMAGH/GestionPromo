package promo.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	public static final String filename = "promolist.ser";
	private MainView mainView;
	private PromotionList promoList;

	public void start() {
		restorePromoList();
		mainView = new MainView(this, promoList);
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

	// calls from the View pass onto the mainVeiw object
	public void newPromotionClicked() {
		mainView.newPromotionClicked();
	}

	public void updatePromotionClicked(Promotion promo, boolean isNewPromotion) {
		mainView.updatePromotionClicked(promo, isNewPromotion);
	}

	public void deletePromotionClicked(Promotion promo) {
		mainView.deletePromotionClicked(promo);
	}

	public void newApprenantClicked() {
		mainView.newApprenantClicked();
	}

	public void cancelApprenantClicked(Promotion promo) {
		mainView.cancelApprenantClicked(promo);
	}

	public void cancelPromotionClicked() {
		mainView.cancelPromotionClicked();
	}

	public void updateApprenantClicked(Apprenant selectedApprenant) {
		mainView.updateApprenantClicked(selectedApprenant);
	}

	public void saveApprenantClicked(Promotion promo, Apprenant apprenant, boolean isNewApprenant) {
		mainView.saveApprenantClicked(promo, apprenant, isNewApprenant);
	}

	public void updateNameClicked(String name) {
		mainView.updateNameClicked(name);
	}

	public void backupPromoList() {
		try {
			try (FileOutputStream fileOut = new FileOutputStream(filename);
					ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
				out.writeObject(promoList);
			}
			mainView.backupPromoListClicked();
		} catch (Exception e) {
			System.out.println("Problem backing up");
		}
	}

	@SuppressWarnings("unchecked")
	public void restorePromoList() {
		try {
			try (FileInputStream fileIn = new FileInputStream(filename);
					ObjectInputStream in = new ObjectInputStream(fileIn)) {
				promoList = (PromotionList) in.readObject();
			}
		} catch (Exception e) {
			System.out.println("Problem restoring");
			promoList = testData();
		}
	}

}
