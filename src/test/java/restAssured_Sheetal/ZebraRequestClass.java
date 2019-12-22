package restAssured_Sheetal;

/*
 *  
 * This class contains json elements for response calls
 * regid will be unique and city depends on where slots are free for more zebra accomodations.
 * 
 * {
 * 		"regId": "1101",
 * 		"city": "Delhi",
 * }
 */
public class ZebraRequestClass {
	
	int regId;
	String city;
	
	public int getregId() {
		return regId;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setregId(int regId) {
		this.regId = regId;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
}

