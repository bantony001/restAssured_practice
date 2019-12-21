package restAssured_Sheetal;


import java.util.ArrayList;
import java.util.Map;

import org.hamcrest.Matcher;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.matcher.ResponseAwareMatcher;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * This class is to set different type of data in request call
 * 
 * @author: Bejoise
 * 
 */
public class Video7_VerifyResponse {
	
	/*
	 * Status Code Verification
	 */
	//@Test
	public void testStatusInResponse() {
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().statusCode(200).log().all();
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().statusLine("HTTP/1.1 200 OK");
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().statusLine(containsString("OK"));	
	}
	
	/*
	 * Headers Verification
	 */
	//@Test
	public void testHeadersInResponse() {
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().header("X-Powered-By", "Express");
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().headers("Vary", "Origin, Accept-Encoding","Content-Type",containsString("json"));
	}
	
	/*
	 * Content Type Verification
	 */
	//@Test
	public void testContentType() {
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().contentType(ContentType.JSON);
	}
	
	/*
	 * Body Text Verification
	 */
	//@Test
	public void testBodyInResponse() {
		String responseString = get("http://jsonplaceholder.typicode.com/photos").asString();
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().body(equalTo(responseString));
	}
	
	/*
	 * Body Text Verification
	 */
	//@Test
	public void testBodyParametersInResponse() {
		/*given().
			get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			body("thumbnailurl", new ResponseAwareMatcher<Response>()  {
				public Matcher<?> matcher(Response response) {
					return equalTo("https://via.placeholder.com/150/92c952");
				}
		});*/
		
		//With Java 8 lambda expression
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl", response -> equalTo("https://via.placeholder.com/150/92c952"));

		given().get("http://jsonplaceholder.typicode.com/photos/1").then().body("thumbnailUrl", endsWith("92c952"));		
	}
	
	/*
	 * Cookies Verification
	 */
	//@Test
	public void testCookiesInResponse() {
		given().get("http://jsonplaceholder.typicode.com/photos").then().assertThat().cookie("__cfduid","de381ea059e4da009d234c3b742f0083c1576300311");
		//The Cookie keeps changing. Hence, its not working
	}
}

