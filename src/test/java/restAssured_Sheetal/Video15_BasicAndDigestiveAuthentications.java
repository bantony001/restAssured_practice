package restAssured_Sheetal;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;

public class Video15_BasicAndDigestiveAuthentications {
	
	/*
	 * Type 1: Challenged Basic Authentication
	 * (minimum two req-resp pair required to process a call)
	 * 
	 * Rest Assured will not send credential to server initially. 
	 * When server explicitly asks for it, only then the credentials are passed to server in headers along with rest of the details.
	 */
	//@Test
	public void testBasicChallengedAuthentication() {
		given().auth().basic("userName", "password").when().get("http://jsonplaceholder.typicode.com/posts/").then().statusCode(200);
	}
	
	/*
	 * Type 2: Preemptive Basic Authentication: Credentials will be passed to server before asks for it.
	 */
	//@Test
	public void testBasicPreemptiveAuthentication() {
		given().auth().preemptive().basic("userName", "password").when().get("http://jsonplaceholder.typicode.com/posts/").then().statusCode(200);
	}

	/*
	 * Authentication can be set for all calls
	 * The credentials are passed to server before being asked.
	 */
	@Test
	public void testBasicAuthentication() {
		RestAssured.authentication = basic("userName", "password"); 
		given().get("http://jsonplaceholder.typicode.com/posts/").then().statusCode(200);
	}
	
	/*
	 * Type 3: Challenged digest authentication i.e. min two req response combination required
	 * 
	 * Digest Authentication is more secure than Basic Authentication as it involve a new Digestive Key
	 */
	//@Test
	public void testDigestiveAuthentication() {
		given().auth().digest("userName", "password").when().get("http://jsonplaceholder.typicode.com/posts/").then().statusCode(200);
	}

}

