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
public class Video10_LoggingInRestAssured {
	
	/*
	 * Logging
	 */
	//@Test
	public void testLogging1() {
		given().get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			//log().headers();
			//log().body();
			//log().cookies();
			log().all();
	}	
	
	/*
	 * Logs only in case of errors
	 */
	@Test
	public void testLogging2() {
		given().
			//get("http://jsonplaceholder.typicode.com/photos/1").
			get("http://api.fonts.com/rest/json/Domains/").
		then().
			log().ifError();
	}
	
	/*
	 * Conditional Logging
	 */
	//@Test
	public void testLogging3() {
		given().get("http://jsonplaceholder.typicode.com/photos/1").
		then().
			log().ifStatusCodeIsEqualTo(200);
	}	
}

