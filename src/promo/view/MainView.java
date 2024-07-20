package promo.view;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.Alternant;
import promo.model.Apprenant;
import promo.model.Promotion;
import promo.model.PromotionList;
import promo.model.Stagiaire;

//d�finir la vue principale envoy�e par la classe contr�leur
//en utilisant  JFrame le composant de base de Java Swing 
public class MainView extends JFrame {
	
	//on a fait appel aux classes de vues pour afficher leurs contenus � partir de la classe main
	private PromoApprenant promoApprenant;
	private PromoDetail promoDetail;
	private PromoSelection promoSelection;
	
	//envoie des r�sultats de la classe PromoAppController et PromoList pour l'affichage principal
	private PromoAppController promoController;
	private PromotionList promoList;
	
	//getters et setters 
	public PromotionList getPromoList() {
		return promoList;
	}

	public void setPromoList(PromotionList promoList) {
		this.promoList = promoList;
	}
	
	public PromoApprenant getPromoApprenant() {
		return promoApprenant;
	}

	public void setPromoApprenant(PromoApprenant promoApprenant) {
		this.promoApprenant = promoApprenant;
	}

	public PromoDetail getPromoDetail() {
		return promoDetail;
	}

	public void setPromoDetail(PromoDetail promoDetail) {
		this.promoDetail = promoDetail;
	}
	//le constructeur prend le contr�leur et la liste de promo. 
	//nous rappelons le contr�leur lorsque l'utilisateur interagit avec l'interface graphique.
	/**
	 * Constructor takes the controller and a promolist. We make calls back into the
	 * controller when the user interacts with the GUI.
	 * 
	 * @param promoController
	 * @param promoList
	 */
	public MainView(PromoAppController promoController, PromotionList promoList) {
		this.promoController = promoController;
		this.setPromoList(promoList);

		promoSelection = new PromoSelection(promoController, promoList);
		//mettre en place le Frame ou le cadre 
		setupFrame();
	}
	//mettre en place le cadre de l'image
	private void setupFrame() {
		Image icon = Toolkit.getDefaultToolkit().getImage("src/icon.png");
		this.setIconImage(icon);

		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gestion Promotions");
		this.setContentPane(promoSelection);
//		this.pack();
		this.setVisible(true);
	}
	//getters et setters PromoSelection
	public PromoSelection getPromoSelection() {
		return promoSelection;
	}

	public void setPromoSelection(PromoSelection promoSelection) {
		this.promoSelection = promoSelection;
	}
	//m�thode qui d�finit la selection d'une nouvelle promotion (appel � la classe PromoDetail)
	public void newPromotionClicked() {
		promoDetail = new PromoDetail(promoController);
		setComponent(promoDetail);
	}
	// 
	public void updatePromotionClicked(Promotion promo, boolean isNewPromotion) {
		//si on clique sur NewPromotion on l'ajoute dans PomoList
		if (isNewPromotion) {
			promoList.addPromotion(promo);
		}
		promoDetail = new PromoDetail(promoController, promo);
		setComponent(promoDetail);
	}
	//quand on clique sur updateApprenant(appel � la classe PromoApprenant)
	public void updateApprenantClicked(Apprenant apprenant) {
		promoApprenant = new PromoApprenant(promoController, promoDetail.getPromotion(), apprenant);
		setComponent(promoApprenant);
	}
	//quand on clique sur deletePromotion
	public void deletePromotionClicked(Promotion promo) {
		System.out.println("Not implemented yet!!");
	}
	//m�thode pour d�finir le nouveau apprenant
	public void newApprenantClicked() {
		promoApprenant = new PromoApprenant(promoController, promoSelection.getSelectedPromotion());
		setComponent(promoApprenant);
	}
	//m�thode pour annuler l'apprenant s�lectionn�
	public void cancelApprenantClicked(Promotion promo) {
		updatePromotionClicked(promo, false);
	}
	//m�thode pour annuler la promotion s�lectionn�e
	public void cancelPromotionClicked() {
		promoSelection = new PromoSelection(promoController, promoList);
		setComponent(promoSelection);
	}
	//cela supprime le contenu pr�c�dent et ajoute le nouveau composant. 
	//il force alors un redessin
	/**
	 * This removes the previous Content and add the new component. it then forces a
	 * redraw
	 * 
	 * @param component
	 */
	public void setComponent(JPanel component) {
		this.getContentPane().removeAll();
		this.setContentPane(component);
		this.revalidate(); // revalidate all the frame components
		this.repaint(); // and repaint the frame
	}
	//en cas o� un nouveau apprenant s�lectionn�, le r�cup�rer et l'ajouter
	public void saveApprenantClicked(Promotion promo, Apprenant apprenant, boolean isNewApprenant) {
		if (isNewApprenant) {
			promo.getApprenants().add(apprenant);
		}
		updatePromotionClicked(promo, false);
	}
	//mise � jour du nom selectionn� 
	public void updateNameClicked(String name) {
		promoList.setName(name);
		promoSelection = new PromoSelection(promoController, promoList);
		setComponent(promoSelection);
	}
	//m�thode pour retour � la liste de promotion 
	public void backupPromoListClicked() {
		promoSelection = new PromoSelection(promoController, promoList);
		setComponent(promoSelection);
	}
}

