package restAssured_Sheetal;


import java.util.Map;

import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.http.Cookie;
import io.restassured.http.Header;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;

public class Video4b_GetHeadersAndCookies {
	
	@Test
	public void testResponseHeaders() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");		
		String headerCFRay = response.getHeader("CF-RAY");
		System.out.println("CF Ray Header Value: "+ headerCFRay);
		System.out.println("");
		Headers headers = response.getHeaders();
		for(Header h: headers) {
			System.out.println(h.getName() + " " + h.getValue());
		}
	}
	
	/*
	 * To get Cookies
	 */
	//@Test
	public void testCookies() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		Map<String, String> cookies = response.getCookies();
		for(Map.Entry<String, String> cookie: cookies.entrySet()) {
			System.out.println(cookie.getKey() + "  " + cookie.getValue());
		}
	}
	
	/*
	 * To get Detailed Cookies
	 */
	//@Test
	public void testDetailedCookies() {
		Response response = get("http://jsonplaceholder.typicode.com/photos");
		
		Cookie a = response.getDetailedCookie("__cfduid");
		System.out.println("Detailed: "+a.hasExpiryDate());
		System.out.println("Detailed: "+a.getExpiryDate());	
		System.out.println("Detailed: "+a.hasValue());		
	}	
		
}
