package restAssured_Sheetal;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import static io.restassured.RestAssured.*;

public class Video14_Parser {
	
	/*
	 * The different parsers provided by Rest Assured are HTML, JSON, TEXT and XML.
	 * Sometimes team develop their own Content Type (found in Headers), so in those cases normal Rest Assured Code will not work.
	 * 
	 */

	//@Test
	public void testDefaultParser1() {
		//Anyone can be used
		RestAssured.defaultParser = Parser.JSON;
		RestAssured.defaultParser = Parser.XML;
		RestAssured.defaultParser = Parser.HTML;
	}

	//@Test
	public void testDefaultParser2() {
		//For e.g. The below command can be used if we know that the developer has made a mistake by updating the wrong format of JSON, then we can use it.
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then().using().defaultParser(Parser.JSON);
		//If for ex, the Content-Type is not clear, then in such case the default Parser is considered.
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then().using().defaultParser(Parser.XML);
	}
	
	//@Test
	public void testCustomParser1() {
		//If the application is not registered to be processed by XML parser, the below command can be used.
		RestAssured.registerParser("application/vnd.uoml+xml", Parser.XML);
		RestAssured.unregisterParser("application/vnd.uoml+xml");
	}
	
	/*
	 * CustomParser - Type2
	 * We are explicitly telling that the Rest Assured needs to use this parser before making this request since the application/custom is not registered.
	 * The application/custom will be provided by Dev.
	 */
	//@Test
	public void testCustomParser2() {
		given().get("http://www.thomas-bayer.com/sqlrest/CUSTOMER/10").then().using().parser("application/vnd.uoml+xml", Parser.XML);
		//Note: Content Type is in general application/xml
	}
}

