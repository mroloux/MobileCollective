package controllers;

import java.io.IOException;
import java.io.InputStream;

import play.libs.WS;
import play.libs.WS.WSRequest;
import play.mvc.Controller;

public class SocialText extends Controller {

    private static final String HTTP_CEGEKA_SOCIALTEXT_NET = "http://cegeka.socialtext.net";

    public static void signals(String user, String pwd) {
		String result = createSocialTextRequest(HTTP_CEGEKA_SOCIALTEXT_NET + "/data/signals", user, pwd)
				.setHeader("Accept", "application/json")
				.get()
				.getString();
		renderJSON(result);
	}

	public static void photo(String userId,String user, String pwd) throws IOException {
		InputStream result = createSocialTextRequest(HTTP_CEGEKA_SOCIALTEXT_NET + "/data/people/" + userId + "/photo", user, pwd)
				.get()
				.getStream();
		renderBinary(result);
	}

	private static WSRequest createSocialTextRequest(String url, String user, String pwd) {
		return WS.url(url).authenticate(user, pwd);
	}

}
