package restAssured_Sheetal;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;

public class Video12_HandlingSSL_TLS {
	
	@BeforeClass
	public void setUp() {
		RestAssured.useRelaxedHTTPSValidation(); //This is required when the exception is not handled in other Tests.
	}	
	
	/*
	 * Suppose server has invalid certificate and throwing SSLPeerUnverifiedException exception
	 * So to handle this case we can relax certificate condition and now SSL Exception will not come
	 * 
	 * Don't have any proper url to this feature
	 */
	//@Test
	public void test1() {
		given().get("https://teamtreehouse.com/matthew.json").then().statusCode(200);
		given().relaxedHTTPSValidation().when().get("https://teamtreehouse.com/matthew.json").then().statusCode(200);
	}
	
	/*
	 * We can also handle TLS protocol using an overload method.
	 */
	@Test
	public void test2() {
		given().relaxedHTTPSValidation("TLS").when().get("https://teamtreehouse.com/matthew.json");
		//Similar to TLS, we can also handle other certificates using the above command.
	}
}

