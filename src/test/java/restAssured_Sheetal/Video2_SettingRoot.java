package restAssured_Sheetal;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Video2_SettingRoot {
	
	//@Test
	public void testWithoutRoot() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			body("main.pressure", is(1012));
	}
	
	//@Test
	public void testWithRoot() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			root("main").
			body("pressure", is(1012));
	}
	
	//@Test
	public void testDetachRoot() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			root("main").
			body("pressure", is(1012)).
			detachRoot("main").
			body("main.humidity", is(81));
			
	}
}
