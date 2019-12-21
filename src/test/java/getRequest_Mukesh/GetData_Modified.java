package getRequest_Mukesh;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class GetData_Modified {
	//@Test
	public void testResponseCode() {
		//Response resp = RestAssured.get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22");
		int code = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getStatusCode();
		long time = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").getTime();
		System.out.println(code + " " + time);		
	}
	
	//@Test
	public void testResponseString() {
		String respValue = get("https://samples.openweathermap.org/data/2.5/weather?q=London,uk&appid=b6907d289e10d714a6e88b30761fae22").asString();
		System.out.println(respValue);
	}
}
