package models;

import static com.google.common.collect.Collections2.transform;
import static com.google.common.collect.Iterables.toArray;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Arrays.asList;

import java.util.Set;

import play.libs.WS;
import play.libs.WS.HttpResponse;
import play.libs.WS.WSRequest;

import com.google.common.base.Function;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class SocialTextService {

	private static final String BASE_URL = "http://cegeka.socialtext.net";

	public static Set<Group> findGroups(String user, String password) {
		HttpResponse response = createSocialTextRequest(BASE_URL + "/data/groups/", user, password)
				.setHeader("Accept", "application/json")
				.get();

		if (response.success()) {
			return jsonGroupsToDomainObjects(response.getString());
		}
		throw new SocialTextException();
	}

	private static Set<Group> jsonGroupsToDomainObjects(String jsonGroups) {
		JsonArray jsonGroupsArray = (JsonArray) new JsonParser().parse(jsonGroups);
		return newHashSet(transform(asList(toArray(jsonGroupsArray, JsonElement.class)), new Function<JsonElement, Group>() {

			@Override
			public Group apply(JsonElement jsonGroupAsElement) {
				JsonObject jsonGroup = (JsonObject) jsonGroupAsElement;
				return new Group(jsonGroup.get("group_id").getAsString(), jsonGroup.get("name").getAsString());
			}
		}));
	}

	private static WSRequest createSocialTextRequest(String url, String user, String pwd) {
		return WS.url(url).authenticate(user, pwd);
	}

}
