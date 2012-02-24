package controllers;

import play.libs.WS;
import play.mvc.Controller;

public class SocialText extends Controller {

	public static void signals() {
		String result = WS.url("http://cegeka.socialtext.net/data/signals")
				.authenticate("matti.roloux@cegeka.be", "PW")
				.setHeader("Accept", "application/json")
				.get()
				.getString();
		renderJSON(result);
	}

}
