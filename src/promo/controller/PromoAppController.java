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

//cette classe contient des méthodes publiques appelées aussi méthodes d'actions,
//elle récupère les données du modèle,et envoie les resultats appropriés à la vue principale, 

//dans cette classe contrôleur, on a utilisé des méthodes pour gérer les fonctionnalités demandées sur l'application 
//on a par la suite envoyé les réponses appropriées à la vue principale
public class PromoAppController {
	//faire appel à la classe MainView et PromotionList
	public static final String filename = "promolist.ser";
	private MainView mainView;
	private PromotionList promoList;

	//une méthode qui produit et demande le lancement de la vue principale avec la liste de promotion
	public void start() {
		restorePromoList();
		mainView = new MainView(this, promoList);
	}
	//une méthode pour tester les données avec la récupération de liste des apprenants
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
		
		//l'instanciation du nom du centre de formation et les de deux types de promotions 
		Promotion p1 = new Promotion("JAVA", LocalDate.of(2022, 05, 02), 180, apprenants1);
		Promotion p2 = new Promotion("PHP", LocalDate.of(2022, 06, 01), 140, apprenants2);

		List<Promotion> promos = new ArrayList<>();
		promos.add(p1);
		promos.add(p2);
		PromotionList test = new PromotionList("ICS Formation", promos);

		return test;
	}
	
	//les appels de la vue passent sur l'objet de la vue principale  
	// calls from the View pass onto the mainVeiw object
	public void newPromotionClicked() {
		mainView.newPromotionClicked();
	}
	//la mise à jour de la promotion selectionnée
	public void updatePromotionClicked(Promotion promo, boolean isNewPromotion) {
		mainView.updatePromotionClicked(promo, isNewPromotion);
	}
	//la suppression de la promotion selectionnée
	public void deletePromotionClicked(Promotion promo) {
		mainView.deletePromotionClicked(promo);
	}
	//nouvel apprenant cliqué
	public void newApprenantClicked() {
		mainView.newApprenantClicked();
	}
	//annuler l'apprenant cliqué dans la promotion
	public void cancelApprenantClicked(Promotion promo) {
		mainView.cancelApprenantClicked(promo);
	}
	//annuler la promotion selectionnée 
	public void cancelPromotionClicked() {
		mainView.cancelPromotionClicked();
	}
	//mise à jour de l'apprenant selectionné
	public void updateApprenantClicked(Apprenant selectedApprenant) {
		mainView.updateApprenantClicked(selectedApprenant);
	}
	//l'enregistrement de l'apprenant après avoir remplir le tableau avec tous ses coordonnés
	public void saveApprenantClicked(Promotion promo, Apprenant apprenant, boolean isNewApprenant) {
		mainView.saveApprenantClicked(promo, apprenant, isNewApprenant);
	}
	//mise à jour du nom selectionné 
	public void updateNameClicked(String name) {
		mainView.updateNameClicked(name);
	}
	//méthode pour retourner à PromoList   
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
	//méthode pour restorer la PromoList
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
