package restAssured_Sheetal;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Video2_ReadResponseInDiffWays {
	
	//@Test
	public void testGetResponseAsString() {
		String responseAsString = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		System.out.println("My Response: \n\n\n"+responseAsString);
	}
	
	//@Test
	public void testGetResponseAsInputStream() throws IOException {
		InputStream inputStream = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asInputStream();
		System.out.println("Stream Length is "+inputStream.toString().length());
		inputStream.close();
	}
	
	//@Test
	public void testGetResponseAsByteArray() throws IOException {
		byte[] byteArr = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asByteArray();
		System.out.println("Byte Array Length is "+ byteArr.length);
	}
	
	//@Test
	public void testExtractDetailsUsingPath() {
		String href=
		when().
			get("https://teamtreehouse.com/matthew.json").
		then().
			contentType(ContentType.JSON).
			body("name", is("Matthew Kosloski")).
		extract().
			path("profile_url");
		
		System.out.println(href);
		
		when().get(href).then().statusCode(200);
	}
	
	//@Test
	public void testExtractPathInOneLine() {
		//type1
		String href1= get("https://teamtreehouse.com/matthew.json").path("gravatar_url");		
		System.out.println(href1);		
		when().get(href1).then().statusCode(200);
		
		//type1
		String href2= get("https://teamtreehouse.com/matthew.json").andReturn().jsonPath().getString("gravatar_url");
		System.out.println(href2);		
		when().get(href2).then().statusCode(200);	
	}
	
	@Test
	public void testExtractDetailsUsingResponse() {
		Response response = 
		when().
			get("https://teamtreehouse.com/matthew.json").
		then().
		extract().
			response();
		
		System.out.println("Content Type: " +response.contentType());
		System.out.println("Href: " + response.path("gravatar_url"));
		System.out.println("Status Code: " + response.statusCode());		
	}

}
