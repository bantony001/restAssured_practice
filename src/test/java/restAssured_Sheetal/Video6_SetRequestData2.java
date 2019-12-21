package restAssured_Sheetal;


import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * This class is to set different type of data in request call
 * 
 * @author: Bejoise
 * 
 */
public class Video6_SetRequestData2 {
	
	/*
	 * To set the path parameters
	 */
	//@Test
	public void testSetPathParameters() {
		given().
			pathParam("type","json").
			pathParam("section","Domains").
		when().
			post("http://api.fonts.com/rest/{type}/{section}/").
		then().
			statusCode(400);		
	}
	
	/*
	 * To set the single cookie in request
	 */
	//@Test
	public void testSetCookiesInRequest() {
		given().
			cookie("__utmt","1").
		when().
			get("http://www.webservicex.com/globalweather.asmx?op=GetCitiesByCountry").
		then().
			statusCode(404);		//The actual code was supposed to give status 200
	}
	
	/*
	 * Multiple cookies can be set in Request param
	 * Note: NOT WORKING
	 */
	//@Test
	public void testSetMultipleCookiesInRequest() {
		//to set multiple value
		given().cookie("key","val1","val2");//this will create two cookies with value "val1" and "val2"
		
		//to set detailed cookie with multiple values
		Cookie cookie = new Cookie.Builder("some_cookie_key", "some_value").setSecured(true).setComment("some comment").build();
		given().cookie(cookie).when().get("/cookie").then().assertThat().body(equalTo("x"));
		
		//to set multiple detailed cookies
		Cookie cookie1 = new Cookie.Builder("some_cookie_key", "some_value").setSecured(true).setComment("some comment").build();
		Cookie cookie2 = new Cookie.Builder("some_cookie_key", "some_value").setSecured(true).setComment("some comment").build();
		Cookies cookies = new Cookies(cookie1, cookie2);
		given().cookies(cookies).when().get("/cookie").then().assertThat().body(equalTo("x"));
	}
	
	/*
	 * To pass single header and headers with multiple values and multiple headers
	 */
	//@Test
	public void testSetHeaders() {
		given().
			header("k","v").               //Key - k1 and value - v1
			header("k1","v1","v2","v3").   //Keys - k1 and values - v1 and v2
			headers("k1","v1","k2","v2").  //Keys - k1 and k2; Values - v1 and v2
		when().
			get("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
	/*
	 * To set Content Type
	 */
	//@Test
	public void testSetContentType() {
		given().
			contentType(ContentType.JSON).
			contentType("application/JSON; charset=utf-8").
		when().
			get("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}
	
}

