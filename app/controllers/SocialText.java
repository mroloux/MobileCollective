package controllers;

import java.io.IOException;
import java.io.InputStream;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;
import play.mvc.Controller;

public class SocialText extends Controller {

	private static final String BASE_URL = "http://cegeka.socialtext.net";

	public static void signals(String user, String pwd) {
		HttpResponse response = createSocialTextRequest(BASE_URL + "/data/signals", user, pwd)
				.setHeader("Accept", "application/json")
				.get();

		if (response.success()) {
			renderJSON(response.getString());
		} else {
			error("An error occurred while speaking to SocialText");
		}
	}

	public static void photo(String userId, String user, String pwd) throws IOException {
		InputStream result = createSocialTextRequest(BASE_URL + "/data/people/" + userId + "/photo", user, pwd)
				.get()
				.getStream();
		response.cacheFor("1d");
		renderBinary(result);
	}

	private static WSRequest createSocialTextRequest(String url, String user, String pwd) {
		return WS.url(url).authenticate(user, pwd);
	}

}