package restAssured_Sheetal;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Video1_BasicFeatures {
	//@Test
	public void testStatusCode() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			statusCode(200);
	}
	
	//@Test
	public void testLogging() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			statusCode(200).
			log().all();
	}
	
	//@Test
	public void testEqualToFunction() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			body("main.pressure", equalTo(1012));
	}
	
	//@Test
	public void testHasItemFunction() {
		given().
			get("http://jsonplaceholder.typicode.com/posts/").
		then().
			body("title", hasItems("qui est esse", "eum et est occaecati"));
	}
	
	//@Test
	public void testParametersAndHeaders() {
		given().
			param("key1","value1").
			header("headA","valueA").
		when().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			statusCode(200).
			log().all();
	}
	
	@Test
	public void testAndFeatureForReadability() {
		given().get("http://jsonplaceholder.typicode.com/posts/").then().body("title", hasItems("qui est esse", "eum et est occaecati"));
	}
}
