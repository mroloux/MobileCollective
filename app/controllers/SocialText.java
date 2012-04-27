package controllers;

import static play.mvc.Http.StatusCode.INTERNAL_ERROR;

import java.io.IOException;
import java.io.InputStream;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;
import play.mvc.Controller;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

public class SocialText extends Controller {

	private static final String BASE_URL = "http://cegeka.socialtext.net";

	public static void signals(String user, String pwd) {
		HttpResponse response = createSocialTextRequest(BASE_URL + "/data/signals", user, pwd)
				.setHeader("Accept", "application/json")
				.get();

		if (response.success()) {
			renderJSON(response.getString());
		} else {
			respondWithSocialtextError();
		}
	}

	public static void photo(String userId, String user, String pwd) throws IOException {
		InputStream result = createSocialTextRequest(BASE_URL + "/data/people/" + userId + "/photo", user, pwd)
				.get()
				.getStream();
		response.cacheFor("1d");
		renderBinary(result);
	}

	public static void signal(int signalId, String user, String pwd) {
		HttpResponse response = createSocialTextRequest(BASE_URL + "/data/signals/" + signalId, user, pwd)
				.setHeader("Accept", "application/json")
				.get();

		if (response.success()) {
			renderJSON(response.getString());
		} else {
			respondWithSocialtextError();
		}
	}

	public static void replies(int signalId, String user, String pwd) {
		HttpResponse response = createSocialTextRequest(BASE_URL + "/data/signals/" + signalId + "/replies", user, pwd)
				.setHeader("Accept", "application/json")
				.get();

		if (response.success()) {
			renderJSON(response.getString());
		} else {
			respondWithSocialtextError();
		}
	}

	public static void postSignal(String signal, String user, String pwd) {
		HttpResponse response = createSocialTextRequest(BASE_URL + "/data/signals/", user, pwd)
				.setHeader("content-type", "application/json")
				.setHeader("Accept", "application/json")
				.body(createPostSignalRequestBody(signal))
				.post();

		if (response.success()) {
			redirect("/");
		} else {
			respondWithSocialtextError();
		}
	}

	private static String createPostSignalRequestBody(String signal) {
		JsonObject requestBody = new JsonObject();
		requestBody.addProperty("signal", signal);
		JsonArray groups = new JsonArray();
		groups.add(new JsonPrimitive(14));
		requestBody.add("group_ids", groups);
		return requestBody.toString();
	}

	private static WSRequest createSocialTextRequest(String url, String user, String pwd) {
		return WS.url(url).authenticate(user, pwd);
	}

	private static void respondWithSocialtextError() {
		error(INTERNAL_ERROR, "An error occurred while speaking to SocialText");
	}

}