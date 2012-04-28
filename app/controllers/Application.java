package controllers;

import java.util.Set;

import models.Group;
import models.SocialTextService;
import play.mvc.Controller;

public class Application extends Controller {

	public static void index() {
		render();
	}

	public static void signals() {
		render();
	}

	public static void newSignal(String user, String pwd) {
		Set<Group> groups = SocialTextService.findGroups(user, pwd);
		render(groups);
	}

    public static void listview() {
		render();
	}

}