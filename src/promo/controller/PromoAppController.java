package promo.controller;

import promo.view.MainFrame;

public class PromoAppController {
	private MainFrame mainFrame;

	public void start() {
		mainFrame = new MainFrame(this);
	}

}
