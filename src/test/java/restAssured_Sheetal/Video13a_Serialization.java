package restAssured_Sheetal;

import org.testng.annotations.Test;
import io.restassured.mapper.ObjectMapperType;
import static io.restassured.RestAssured.*;
import java.util.HashMap;
import java.util.Map;

/*
 * The process of Serialization in java is a process in which the object's state is converted into a byte stream
 * Object is saved in Byte Stream and Byte Stream is saved in File or memory or in database.
 * 
 * Serialization can be done in different ways in RestAssured
 * 
 * 	Given: A post service expect input data in JSON format.
 * 
 * 	Problem Statement: We need a way to send input data as JSON in POST request.
 *  {"firstName": "A", "LastName": "B", "Age": "30"}
 *  
 *  Content Type is set to JSON in request, so RestAssured will use following library to Serialize Java Object(Map) into JSON
 *  #Library Priority Order
 *  1. JSON using Jackson 2 (Faster Jackson (databind))		| used if found in classpath / selected by default in RestAssured
 *  2. JSON using Jackson (databind)						| used if above lib is not found in classpath
 *  3. JSON using Gson										| same as above
 *  
 *  #In case of XML
 *  1. XML using JAXB
 *  
 */
public class Video13a_Serialization {
	
	/*
	 * contentType() is converting HashMap object into JSON
	 */
	//@Test
	public void testSerializationUsingHashMap() {
		
		//Java Object as Map
		Map<String, String> inputJson = new HashMap<>();
		inputJson.put("firstName", "A");
		inputJson.put("lastName", "B");
		inputJson.put("Age", "30");
		
		given()
			.contentType("application/json")
			.body(inputJson).
		when()
			.post("http://jsonplaceholder.typicode.com/posts/").
			//.post("http://www.thomas-bayer.com/restnames/countries.groovy").
		then()
			.statusCode(200);
	}
	
	//@Test
	public void testSerializationUsingContentType() {
		
		ZebraRequestClassNew obj = new ZebraRequestClassNew();
		obj.setAge(10);
		obj.setWeight(100);
		obj.setHome("India");		
	
		given()
			.contentType("application/json")
			.body(obj).
		when()
			.post("http://www.thomas-bayer.com/restnames/countries.groovy").
		then()
			.statusCode(200)
			.contentType("application/xml").log().all();
	}
	
	/* 
	 * Serialization can also be done using explicit serializer
	 * Here we are converting java object into json using jackson 2
	 */
	//@Test
	public void testSerializationUsingExplicitSerializer() {
		
		ZebraRequestClassNew obj = new ZebraRequestClassNew();
		obj.setAge(10);
		obj.setWeight(100);
		obj.setHome("India");		
	
		given()
			.contentType("application/json")
			.body(obj, ObjectMapperType.JACKSON_2). //Other Object Mappers like JACKSON1, JOHNZON can also be used here.
		when()
			.post("http://www.thomas-bayer.com/restnames/countries.groovy").
		then()
			.statusCode(200)
			.contentType("application/xml").log().all();
	}

	
}

