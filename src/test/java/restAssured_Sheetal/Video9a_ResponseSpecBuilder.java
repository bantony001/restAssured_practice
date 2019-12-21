package restAssured_Sheetal;


import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.hamcrest.Matcher;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
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

public class Video9a_ResponseSpecBuilder {
	
	ResponseSpecification responseSpec;

	@BeforeClass
	public void setUp() {
		ResponseSpecBuilder builder = new ResponseSpecBuilder();
		builder.expectStatusCode(200);
		builder.expectHeader("Content-Type", "application/json; charset=utf-8");
		builder.expectHeader("Cache-Control", "max-age=14400");
		responseSpec = builder.build();
	}	
	
	@Test
	public void testResponse1() {
		given().
			get("http://jsonplaceholder.typicode.com/photos").
		then().
			spec(responseSpec).
			time(lessThan(1000L));
	}
	
	@Test
	public void testResponse2() {
		given().
			get("http://jsonplaceholder.typicode.com./albums").
		then().
			spec(responseSpec);
	}

}

