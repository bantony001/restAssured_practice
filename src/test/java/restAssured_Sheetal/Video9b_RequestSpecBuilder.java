package restAssured_Sheetal;


import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.http.Cookie;
import io.restassured.http.Cookies;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.matcher.ResponseAwareMatcher;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

/*
 * To define few mandatory check in ResponseSpecBuilder so that it can be used in multiple tests
 * 
 * @author bejoise
 */

public class Video9b_RequestSpecBuilder {
	
	RequestSpecification requestSpec;

	@BeforeClass
	public void setUp() {
		RequestSpecBuilder builder = new RequestSpecBuilder();
		builder.addParam("parameter1", "parameterValue");
		builder.addHeader("header1", "headerValue");
		requestSpec = builder.build();
	}	
	
	@Test
	public void testResponse1() {
		given().
			spec(requestSpec).
		when().			
			get("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(400).
			log().all();
	}
	
	@Test
	public void testResponse2() {
		given().
		spec(requestSpec).
	when().			
		get("http://api.fonts.com/rest/json/Accounts/").
	then().
		statusCode(400);
	}

}

