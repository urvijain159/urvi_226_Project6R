package req_Repo_pkg;

import java.io.IOException;


import java.util.ArrayList;

import commonFunctions_pkg.Utility_common;

public class Post_req_repo {
	
	public static String base_URI() {
		String baseURI="https://restful-booker.herokuapp.com/";
				return baseURI;
		}
		
		public static String post_resource() {
			String resource="booking";
			return resource;
		}
		public static String Post_req_tc1() throws IOException {
			ArrayList<String> data=Utility_common.readdataexcel("Post_test_data","Post_tc1");
			//System.out.println(data.get(0).toString());
			
			

	    Object req_fname=data.get(1);
		Object req_lname=data.get(2);
		Object req_price=data.get(3);
		Object req_deposit=data.get(4);
		Object req_checkin=data.get(5);
		Object req_checkout=data.get(6);
		Object req_needs=data.get(7);
			
			String requestbody="{\r\n"
					+ " \"firstname\" : \""+req_fname+"\",\r\n"
					+ "    \"lastname\" : \""+req_lname+"\",\r\n"
					+ "    \"totalprice\" : \""+req_price+"\",\r\n"
					+ "    \"depositpaid\" : \""+req_deposit+"\",\r\n"
					+ "    \"bookingdates\" : {\r\n"
					+ "        \"checkin\" : \""+req_checkin+"\",\r\n"
					+ "        \"checkout\" : \""+req_checkout+"\"\r\n"
					+ "    },\r\n"
					+ "    \"additionalneeds\" : \""+req_needs+"\"\r\n"
					+ "}";
			return requestbody;
		}
	}
