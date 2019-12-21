package restAssured_Sheetal;


import java.util.ArrayList;
import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

public class Video5_SetRequestData1 {
	
	/*
	 * Generally CONNECT used with HTTPS Request.
	 */
	//Test Failed with CONNECT. Not sure of the reason.
	//@Test
	public void testConnectRequest() {
		when().
			request("CONNECT","https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		//get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			statusCode(200);		
	}
	
	/*
	 * In GET Request, we can set query parameters.
	 */
	//@Test
	public void testQueryParameters() {
		given().
			queryParam("A", "A val").
			queryParam("B", "B val").
		when().
			get("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}	
		
	/*
	 * In POST Request, we can set form parameters.
	 */
	//@Test
	public void testFormParameters() {
		given().
			formParam("A", "A val").
			formParam("B", "B val").
		when().
			post("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}	
	
	/*
	 * To set parameters - recommended way
	 * If request is GET then param will be treated as getParam
	 * If request is POST then param will be treated as formParam
	 */
	//@Test
	public void testSetParameters() {
		given().
			param("A", "A val").
			param("B", "B val").
		when().
			get("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}	
	
	/*
	 * To set multiple value parameters
	 * 
	 * We can pass list, either multiple values or no values in param.
	 */
	//@Test
	public void testSetMultipleValueParameters() {
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("Apple");
		list.add("Orange");		
		
		given().
			param("A", "val1", "val2", "val3").
			param("B").
			param("C", list).
		when().
			get("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400);
	}	
	
}
