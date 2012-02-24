package controllers;

import java.io.IOException;
import java.io.InputStream;

import play.libs.WS;
import play.libs.WS.WSRequest;
import play.mvc.Controller;

public class SocialText extends Controller {

	public static void signals() {
		String result = createSocialTextRequest("http://cegeka.socialtext.net/data/signals")
				.setHeader("Accept", "application/json")
				.get()
				.getString();
		renderJSON(result);
	}

	public static void photo(String userId) throws IOException {
		InputStream result = createSocialTextRequest("http://cegeka.socialtext.net/data/people/" + userId + "/photo")
				.get()
				.getStream();
		renderBinary(result);
	}

	private static WSRequest createSocialTextRequest(String url) {
		return WS.url(url).authenticate("jan.oris@cegeka.be", "UKA8TD8A");
	}

}
