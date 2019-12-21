package restAssured_Sheetal;

import static org.hamcrest.Matchers.*;

import java.util.List;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

import static io.restassured.path.json.JsonPath.*;

public class Video4a_JsonPath {
	
	/*
	 * Extract details as String and fetching further details w/o using json path
	 */
	//@Test
	public void testJsonPath() {
		String response = 
		given().
			get("http://jsonplaceholder.typicode.com/photos").
		then().
			extract().asString();
		List<Integer> albumIds = from(response).get("id");
		System.out.println(albumIds.size());
	}
	
	/*
	 * Extract details as String and fetching further details using json path
	 */
	//@Test
	public void testJsonPath2() {
		String jsonValue = 
		given().
			get("http://jsonplaceholder.typicode.com/photos").
		then().
			extract().asString();
		
		JsonPath jsonPath = new JsonPath(jsonValue);
		//JsonPath jsonPath = new JsonPath(jsonValue).setRoot("RestResponse.result"); //Setting the root also possible in this way. 
		List<Integer> albumIds = jsonPath.get("id");
		System.out.println(albumIds.size());
	}

		
}
