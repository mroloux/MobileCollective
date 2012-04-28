package models;

import org.fest.assertions.Assertions;
import org.junit.Test;

import play.test.UnitTest;

public class SocialTextServiceIntegrationTest extends UnitTest {

	@Test
	public void findGroups_ReturntLegeLijstAlsCredentialsFout() {
		Assertions.assertThat(new SocialTextService().findGroups("matti.roloux@cegeka.be", "fout")).isEmpty();
	}

	@Test
	public void findGroups_ReturntLijstVanGroups() {
		Assertions.assertThat(new SocialTextService().findGroups("matti.roloux@cegeka.be", "Car+m3ta")).contains(new Group("30", "Agile Software Engineering"), new Group("14", "Enterprise Mobile"));
	}
}
