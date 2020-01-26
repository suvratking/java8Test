package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestMessage {
	public static void main(String... args) {
		sendMsg("http://ntse.scertodisha.nic.in/OPEPAService/api/sms?MobileNo=7008017438&Message=sample");
	}
	
	private static void sendMsg(String url) {
		System.out.println("Inside Send Get");
		try {
			//System.out.println(url.replace(" ", "%20")+"_"+new Date().toString());
			URL api = new URL(url);
			HttpURLConnection con = (HttpURLConnection) api.openConnection();
			con.setRequestProperty("Content-Length", "");
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			int responseCode = con.getResponseCode();
			System.out.println("GET Response Code :: " + responseCode);
			if (responseCode == HttpURLConnection.HTTP_OK) { // success
				BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				String inputLine;
				StringBuffer response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				System.out.println("Msg Send Successfully");
				System.out.println(response.toString());
			} else {
				System.out.println("GET request not worked");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
