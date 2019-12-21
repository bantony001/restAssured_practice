package restAssured_Sheetal;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import io.restassured.http.ContentType;

public class Video3a_SchemaCheck {
	
	//@Test
	public void testContentType() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			statusCode(200).
			contentType(ContentType.JSON);
			//contentType(ContentType.HTML);
			//contentType(ContentType.XML);
	}
	
	@Test
	public void testSchema() {
		given().
			get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").
		then().
			assertThat().body(matchesJsonSchemaInClasspath("video3_schema.json")); //Reference video3.json available in same location.
			//Online app for creating json schema: https://techbrij.com/brijpad/#json
	}
}
