package promo.view;

import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.Apprenant;
import promo.model.Promotion;
import promo.model.PromotionList;

public class MainView extends JFrame {
	private PromoApprenant promoApprenant;
	private PromoDetail promoDetail;
	private PromoSelection promoSelection;

	private PromoAppController promoController;
	private PromotionList promoList;

	/** Getters and Setters ***/
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

//		Promotion promotion = promoList.getPromoList().get(0);
//		promoDetail = new PromoDetail(promoController, promotion);
//
//		Apprenant apprenant = promotion.getApprenants().get(0);
//		promoApprenant = new PromoApprenant(promoController, apprenant);

		setupFrame();
	}

	private void setupFrame() {
		this.setSize(600, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gestion Promotions");
		this.setContentPane(promoSelection);
//		this.pack();
		this.setVisible(true);
	}

	public PromoSelection getPromoSelection() {
		return promoSelection;
	}

	public void setPromoSelection(PromoSelection promoSelection) {
		this.promoSelection = promoSelection;
	}

	public void newPromotionClicked() {
		promoDetail = new PromoDetail(promoController);
		setComponent(promoDetail);
	}

	public void updatePromotionClicked(Promotion promo) {
		promoDetail = new PromoDetail(promoController, promo);
		setComponent(promoDetail);
	}

	public void updateApprenantClicked(Apprenant apprenant) {
		promoApprenant = new PromoApprenant(promoController, promoDetail.getPromotion(), apprenant);
		setComponent(promoApprenant);
	}

	public void deletePromotionClicked(Promotion promo) {
		System.out.println("Not implemented yet!!");
	}

	public void newApprenantClicked() {
		promoApprenant = new PromoApprenant(promoController, promoDetail.getPromotion());
		setComponent(promoApprenant);
	}

	public void cancelApprenantClicked(Promotion promo) {
		updatePromotionClicked(promo);
	}

	public void cancelPromotionClicked() {
		promoSelection = new PromoSelection(promoController, promoList);
		setComponent(promoSelection);
	}

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
}
