package getRequest_Mukesh;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetData {
	//@Test
	public void testResponseCode() { 
		//Test Code from https://openweathermap.org/current (api.openweathermap.org/data/2.5/weather?q=London)
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int code = resp.getStatusCode();
		System.out.println(code + "  " + resp.getTime());		
	}
	
	//@Test
	public void testResponseString() {
		Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		String respValue = resp.asString();
		System.out.println(respValue);
	}
}
