package promo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

//c'est une classe main pour le d�marrage dont on a cr�e la variable promoAppController
public class PromoAppRunner {

	/**
	 * Main starter or entry port
	 * 
	 * @param args unused
	 */
	public static void main(String[] args) {
		PromoAppController app = new PromoAppController();
		app.start();
		 
	}
}