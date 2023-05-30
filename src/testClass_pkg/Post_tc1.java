package testClass_pkg;

import java.io.IOException;
import java.time.LocalDateTime;

import org.testng.Assert;

import commonFunctions_pkg.API_common;
import commonFunctions_pkg.Utility_common;
import io.restassured.path.json.JsonPath;
import req_Repo_pkg.Post_req_repo;
import testClass_pkg.Post_tc1;

public class Post_tc1 {
	public static void execute() throws IOException {
	
		 	for(int i=0; i<4; i++)
			{
			
			 int statusCode=API_common.res_statusCode(Post_req_repo.base_URI(),
	    		                     Post_req_repo.Post_req_tc1(),Post_req_repo.post_resource());
			 
			 System.out.println(statusCode);
	  
	           if(statusCode == 200)
	           {
	    	
	                String responsebody=API_common.response_body(Post_req_repo.base_URI(),
	        		                  Post_req_repo.Post_req_tc1(),Post_req_repo.post_resource());
	                
	                System.out.println(responsebody);
	                Post_tc1.validator(responsebody,statusCode);
	                Utility_common.evidencefilecreator("Post_tc1", Post_req_repo.Post_req_tc1(), responsebody);
	                break;
	        
	           }
	           else
	           {
	    	     System.out.println("correct status code is not found hence retrying the API");
	           }
		
		     }	
		}

             public static void validator(String responsebody,int statusCode) throws IOException {
        	//Parse response body and its parameters
	JsonPath jspres=new JsonPath(responsebody);
	String res_id=jspres.getString("bookingid");
	String res_fname=jspres.getString("booking.firstname");
	String res_lname=jspres.getString("booking.lastname");
	String res_price=jspres.getString("booking.totalprice");
	String res_deposit=jspres.getString("booking.depositpaid");
	String res_checkin=jspres.getString("booking.bookingdates.checkin");
	String res_checkout=jspres.getString("booking.bookingdates.checkout");
	String res_needs=jspres.getString("booking.additionalneeds");
	System.out.println(res_fname);
	System.out.println(res_lname);
	System.out.println(res_price);
	System.out.println(res_deposit);
	System.out.println(res_checkin);
	System.out.println(res_checkout);
	System.out.println(res_needs);
   
  //parse request body and its parameters
   JsonPath jspreq=new JsonPath (Post_req_repo.Post_req_tc1());
	String req_fname=jspreq.getString("firstname");
	String req_lname=jspreq.getString("lastname");
	String req_price=jspreq.getString("totalprice");
	String req_deposit=jspreq.getString("depositpaid");
	String req_checkin=jspreq.getString("bookingdates.checkin");
	String req_checkout=jspreq.getString("bookingdates.checkout");
	String req_needs=jspres.getString("booking.additionalneeds");
	//Validate the response
   
   Assert.assertEquals(statusCode,200);
   Assert.assertNotNull(res_id);
   Assert.assertEquals(req_fname,res_fname);
   Assert.assertEquals(req_lname,res_lname);
   Assert.assertEquals(req_price,res_price);
   Assert.assertEquals(req_deposit,res_deposit);
   Assert.assertEquals(req_checkin,res_checkin);
   Assert.assertEquals(req_checkout,res_checkout);
   Assert.assertEquals(req_needs,res_needs);

}

}


