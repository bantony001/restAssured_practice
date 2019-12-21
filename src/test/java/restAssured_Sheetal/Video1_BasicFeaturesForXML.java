package restAssured_Sheetal;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Video1_BasicFeaturesForXML {
	//@Test
	public void testSingleContent() {
		given().
			get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
		then().
			body("CUSTOMER.ID", equalTo("10")).
			log().all();
	}
	
	//@Test
	public void testMultipleContent() {
		given().
		get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
	then().
		body("CUSTOMER.ID", equalTo("10")).
		body("CUSTOMER.FIRSTNAME", equalTo("Sue")).body("CUSTOMER.LASTNAME", equalTo("Fuller")).
		body("CUSTOMER.STREET", equalTo("135 Upland Pl.")).body("CUSTOMER.CITY", equalTo("Dallas"));
	}
	
	//@Test
	public void testCompleteTextInOneGo() {
		given().
		get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
	then().
		body("CUSTOMER.text()", equalTo("10SueFuller135 Upland Pl.Dallas")).
		log().all();
	}
	
	//@Test
	public void testUsingXpath1() {
	given().
		get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").
	then().
		body(hasXPath("/CUSTOMER/FIRSTNAME"), containsString("Sue"));
	}
	
	//@Test
	public void testUsingXpath2() {
	given().
		get("http://www.thomas-bayer.com/sqlrest/INVOICE/").
	then().
		body(hasXPath("/INVOICEList/INVOICE[text()='40']")).
		log().all();
	}

}
