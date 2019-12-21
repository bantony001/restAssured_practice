package restAssured_Sheetal;


import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

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
public class Video8_TimeMeasurement {
	
	/*
	 * Response Time Measurement
	 * 
	 * Note: Time includes HTTP Round Trip + Rest Assured Processing Time
	 */
	//@Test
	public void testResponseTime() {
		long t = given().get("http://jsonplaceholder.typicode.com/photos/1").time();
		System.out.println(t);
	}	
	
	//@Test
	public void testResponseTimeInUnit() {
		long t = given().get("http://jsonplaceholder.typicode.com/photos/1").timeIn(TimeUnit.MILLISECONDS);
		System.out.println(t);
	}	
	
	//@Test
	public void testResponseTimeAssertion() {
		given().get("http://jsonplaceholder.typicode.com/photos/1").then().time(lessThan(1000L));
	}	
}

