package controllers;

import play.libs.WS;
import play.mvc.Controller;

public class Application extends Controller {

    public static final String CEGEKA_SOCIALTEXT_ROOT_PATH = "http://cegeka.socialtext.net";

    public static void index() {
		render();
	}

	public static void signals() {
		render();
	}

}