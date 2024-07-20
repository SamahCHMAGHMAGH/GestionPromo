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

//cette classe contient des m�thodes publiques appel�es aussi m�thodes d'actions,
//elle r�cup�re les donn�es du mod�le,et envoie les resultats appropri�s � la vue principale, 

//dans cette classe contr�leur, on a utilis� des m�thodes pour g�rer les fonctionnalit�s demand�es sur l'application 
//on a par la suite envoy� les r�ponses appropri�es � la vue principale
public class PromoAppController {
	//faire appel � la classe MainView et PromotionList
	public static final String filename = "promolist.ser";
	private MainView mainView;
	private PromotionList promoList;

	//une m�thode qui produit et demande le lancement de la vue principale avec la liste de promotion
	public void start() {
		restorePromoList();
		mainView = new MainView(this, promoList);
	}
	//une m�thode pour tester les donn�es avec la r�cup�ration de liste des apprenants
	public PromotionList testData() {

		Stagiaire s1 = new Stagiaire("blanc", "michael", LocalDate.of(2022, 03, 06), "michael@blanc", "0677777",
				"pole emploi", 1000);
		Alternant alt1 = new Alternant("pasquier", "sophie", LocalDate.of(2022, 03, 16), "sophie@pasquier", "076666",
				"IBM", 2000);
		Stagiaire s2 = new Stagiaire("blanc", "laurent", LocalDate.of(2022, 03, 05), "laurent@blanc", "0677�77",
				"pole emploi", 1000);
		Alternant alt2 = new Alternant("paul", "pogba", LocalDate.of(2022, 03, 10), "paul@pogba", "066666", "IBM",
				2000);
		Stagiaire s3 = new Stagiaire("romain", "perraud", LocalDate.of(2022, 02, 03), "romain@perraud", "0677�77",
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
	//la mise � jour de la promotion selectionn�e
	public void updatePromotionClicked(Promotion promo, boolean isNewPromotion) {
		mainView.updatePromotionClicked(promo, isNewPromotion);
	}
	//la suppression de la promotion selectionn�e
	public void deletePromotionClicked(Promotion promo) {
		mainView.deletePromotionClicked(promo);
	}
	//nouvel apprenant cliqu�
	public void newApprenantClicked() {
		mainView.newApprenantClicked();
	}
	//annuler l'apprenant cliqu� dans la promotion
	public void cancelApprenantClicked(Promotion promo) {
		mainView.cancelApprenantClicked(promo);
	}
	//annuler la promotion selectionn�e 
	public void cancelPromotionClicked() {
		mainView.cancelPromotionClicked();
	}
	//mise � jour de l'apprenant selectionn�
	public void updateApprenantClicked(Apprenant selectedApprenant) {
		mainView.updateApprenantClicked(selectedApprenant);
	}
	//l'enregistrement de l'apprenant apr�s avoir remplir le tableau avec tous ses coordonn�s
	public void saveApprenantClicked(Promotion promo, Apprenant apprenant, boolean isNewApprenant) {
		mainView.saveApprenantClicked(promo, apprenant, isNewApprenant);
	}
	//mise � jour du nom selectionn� 
	public void updateNameClicked(String name) {
		mainView.updateNameClicked(name);
	}
	//m�thode pour retourner � PromoList   
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
	//m�thode pour restorer la PromoList
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
