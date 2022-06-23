package promo.view;

import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.Apprenant;
import promo.model.Promotion;
import promo.model.PromotionList;

public class MainView extends JFrame {
	private JPanel mainPanel;
	private PromoApprenant promoApprenant;
	private PromoDetail promoDetail;
	private PromoSelection promoSelection;

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

	public PromoSelection getPromoSelection() {
		return promoSelection;
	}

	public void setPromoSelection(PromoSelection promoSelection) {
		this.promoSelection = promoSelection;
	}

	public MainView(PromoAppController promoController, PromotionList promoList) {
		promoSelection = new PromoSelection(promoController, promoList);

		Promotion promotion = promoList.getPromoList().get(0);
		promoDetail = new PromoDetail(promoController, promotion);

		Apprenant apprenant = promotion.getApprenants().get(0);
		promoApprenant = new PromoApprenant(promoController, apprenant);
		
		setupPanel();
		setupFrame();
	}

	private void setupFrame() {
		this.setContentPane(mainPanel);
	    Image icon = Toolkit.getDefaultToolkit().getImage("src/icon.png");  
	    this.setIconImage(icon);  
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gestion Promotions");
//		this.pack();
		this.setVisible(true);
	}

	private void setupPanel() {
		mainPanel = new JPanel();
		mainPanel.add(promoSelection);
		mainPanel.add(promoDetail);
		mainPanel.add(promoApprenant);
		mainPanel.setLayout(new GridLayout(3, 1));
	}

	public void promoSelectionWindow() {
		promoSelection.setVisible(true);
		promoDetail.setVisible(false);
		promoApprenant.setVisible(false);
	}

	public void promoDetailWindow() {
		promoSelection.setVisible(false);
		promoDetail.setVisible(true);
		promoApprenant.setVisible(false);
	}

	public void promoApprenantWindow() {
		promoSelection.setVisible(false);
		promoDetail.setVisible(false);
		promoApprenant.setVisible(true);
	}
}
