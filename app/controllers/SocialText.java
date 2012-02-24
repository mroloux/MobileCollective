package controllers;

import play.libs.WS;
import play.mvc.Controller;

public class SocialText extends Controller {

	public static void signals() {
		String result = WS.url("http://cegeka.socialtext.net/data/signals")
				.authenticate("jan.oris@cegeka.be", "UKA8TD8A")
				.setHeader("Accept", "application/json")
				.get()
				.getString();
		renderJSON(result);
	}

}
