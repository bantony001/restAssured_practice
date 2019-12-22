package restAssured_Sheetal;

import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class Video13b_DeSerialization {
	
	/*
	 * contentType() based deserialization using .as()
	 * 
	 * Here even if response is JSON or XML, RestAssured will handle it automatically.
	 */

	@Test
	public void testDeSerializationUsingContentType() {
		
		ZebraRequestClassNew reqObj = new ZebraRequestClassNew();
		reqObj.setAge(10);
		reqObj.setWeight(100);
		reqObj.setHome("India");		
	
		ZebraRequestClass respObj = 
		given()
			.body(reqObj). 
		when()
			.post("http://www.thomas-bayer.com/restnames/countries.groovy")
			.as(ZebraRequestClass.class);
		
		respObj.setregId(1101);
		Assert.assertTrue(respObj.getregId() > 0);
	}

	
}

