package promo.view;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import promo.controller.PromoAppController;
import promo.model.Apprenant;
import promo.model.PromotionList;

public class MainFrame extends JFrame {
	private JPanel mainPanel;
	private PromoApprenant promoApprenant;
	private PromoDetail promoDetail;
	private PromoSelection promoSelection;

	public MainFrame(PromoAppController promoController) {
		promoSelection = new PromoSelection(promoController);
		promoDetail = new PromoDetail(promoController);
		promoApprenant = new PromoApprenant(promoController);

		setupPanel();
		setupFrame();
	}

	public void selectionView() {

	}

	private void setupFrame() {
		this.setContentPane(mainPanel);
		this.setSize(500, 500);
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
		mainPanel.setLayout(new GridLayout(2, 1));
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
