package restAssured_Sheetal;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class Video2_PostRequest {
	
	//@Test
	public void testPostReq() {
		given().
			headers("AppKey","Key-value").
			param("wfsfirst_name","first").
			param("wfslast_name","last").
			param("wfsemail","test@test.com").
		when().
			post("http://api.fonts.com/rest/json/Accounts/").
		then().
			statusCode(401).log().all();
	}
	

}
