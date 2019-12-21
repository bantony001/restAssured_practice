package restAssured_Sheetal;

import static org.hamcrest.Matchers.*;

import java.util.List;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import static io.restassured.path.json.JsonPath.*;

public class Video3b_GroovyFeatures {
	
	//@Test
	public void testPresenceOfElements() {
		given().
			get("http://jsonplaceholder.typicode.com/posts/").
		then().
			body("title", hasItems("qui est esse", "eum et est occaecati"));
	}
	
	/*
	 * Here we are adding length of all "sys.country" code coming in response. Since there is only one value, it takes up that. Otherwise would sum up.
	 */
	//@Test
	public void testLengthOfResponse2() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			body("sys.country*.length().sum()", greaterThan(1));
	}
	
	/*
	 * To get list of all attributes
	 */
	//@Test
	public void testGetResponseAsList() {
		String response = get("http://jsonplaceholder.typicode.com/posts/").asString();
		List<String> ls = from(response).getList("title"); //NOT WORKING
		System.out.println(ls.size());
		for(String title: ls) {
			if(title.equals("qui est esse")){
				System.out.println("Found my title.");
			}
		}
	}
	
	/*
	 * To get response as list and apply some conditions on it
	 * 
	 * The groovy has an implicit variable called 'it' which represents the current variable in the list
	 */
	//@Test
	public void testConditionsOnList() {
		String response = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		List<String> ls = from(response).getList("weather.findAll {it.description.length()>0}.description");
		System.out.println(ls);
	}
		
}
