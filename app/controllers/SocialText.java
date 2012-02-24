package controllers;

import play.libs.WS;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class SocialText extends Controller {

	public static void signals() {
		String result = WS.url(Application.CEGEKA_SOCIALTEXT_ROOT_PATH+"/data/signals")
				.authenticate("matti.roloux@cegeka.be", "PW")
				.setHeader("Accept", "application/json")
				.get()
				.getString();
		renderJSON(result);
	}

}
