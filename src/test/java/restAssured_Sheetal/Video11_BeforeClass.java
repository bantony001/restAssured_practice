package restAssured_Sheetal;

import org.testng.annotations.BeforeClass;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class Video11_BeforeClass {
	
	@BeforeClass
	public void testLogging1() {
		RestAssured.baseURI = "http://www.thomas-bayer.com/";
		RestAssured.basePath= "/sqlrest";		
		//RestAssured.port = 8080;
		//RestAssured.authentication = basic("username", "password");
		//RestAssured.rootPath = "x.y.z";
		//RestAssured.filters(.);
		//RestAssured.requestSpecification=..;
		//RestAssured.responseSpecification=..;
		//RestAssured.urlEncodingEnabled = .;
		//RestAssured.defaultParser = .;
		//RestAssured.registerParser = .;
		//RestAssured.unregisterParser = .;
		//RestAssured.useRelaxedHTTPSValidation;
		//RestAssured.trustStore(keystore);
		//RestAssured.reset();
	}	
	
	/*
	 * Here, we need to give only endpoint as baseuri and basepath will be taken from the @BeforeClass.
	 */
	//@Test
	public void test1() {
		given().get("/CUSTOMER/10").then().statusCode(200).log().all();
	}
	
	//@Test
	public void test2() {
		given().get("/CUSTOMERList").then().statusCode(200).log().headers();
	}
}

