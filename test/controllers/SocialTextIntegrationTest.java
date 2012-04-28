package controllers;

import static play.mvc.Http.StatusCode.INTERNAL_ERROR;
import static play.mvc.Http.StatusCode.OK;

import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

import play.mvc.Http.Response;
import play.test.FunctionalTest;

public class SocialTextIntegrationTest extends FunctionalTest {

	@Test
	public void postSignal_Returnt200WanneerAllesOk() {
		Response response = POST("/SocialText/postSignal", maakGeldigePostSignalParameters());
		assertStatus(OK, response);
	}

	@Test
	public void postSignal_ReturntErrorWanneerSocialtextErrorGeeft() {
		Response response = POST("/SocialText/postSignal", maakPostSignalParametersMetOngeldigPaswoord());
		assertStatus(INTERNAL_ERROR, response);
	}

	private Map<String, String> maakGeldigePostSignalParameters() {
		return createPostSignalParameters("dit is een testje", "matti.roloux@cegeka.be", "Car+m3ta");
	}

	private Map<String, String> maakPostSignalParametersMetOngeldigPaswoord() {
		return createPostSignalParameters("dit is een testje", "matti.roloux@cegeka.be", "blah");
	}

	private Map<String, String> createPostSignalParameters(String signal, String email, String password) {
		Map<String, String> parameters = new LinkedHashMap<String, String>();
		parameters.put("signal", signal);
		parameters.put("user", email);
		parameters.put("pwd", password);
		return parameters;
	}

}
