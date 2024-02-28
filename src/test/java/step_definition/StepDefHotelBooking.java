package step_definition;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;


import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
//import pageBean.HotelBookingPageFactory;
import io.cucumber.datatable.DataTable;

public class StepDefHotelBooking {
	private WebDriver driver;
	private HotelBookingPageFactory objhbpg;
	
	@Before
	public void openBrowsser() {
	//driver = new FirefoxDriver();
		System.setProperty("webdriver.chrome.driver","C:\\driver\\chromedriver.exe");
		 driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objhbpg = new HotelBookingPageFactory(driver);
	objhbpg = PageFactory.initElements(driver,HotelBookingPageFactory.class );

	//driver.get("file:///C:/Users/rutkulka/Documents/BDD/hotelBooking/hotelbooking.html");
	}


@Given("^User is on hotel booking page$")
public void user_is_on_hotel_booking_page() throws Throwable {
	//driver = new FirefoxDriver();
	//driver.manage().timeouts()file:///C:/Users/ATTKUMAR/AppData/Local/Temp/7zOCE456BC5/hotelbooking.html.implicitlyWait(10, TimeUnit.SECONDS);
	//objhbpg = new HotelBookingPageFactory(driver);
	driver.get("file:///C:/Users/ATTKUMAR/AppData/Local/Temp/7zOCE456BC5/hotelbooking.html");
}

@Then("^check the title of the page$")
public void check_the_title_of_the_page() throws Throwable {
	String title=driver.getTitle();
	if(title.contentEquals("Hotel Booking")) System.out.println("****** Title Matched");
	else System.out.println("****** Title NOT Matched");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.close();
}

@When("^user enters all valid data$")
public void user_enters_all_valid_data() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(5);	Thread.sleep(1000);
	objhbpg.setPfcardholder("pravin singh");	Thread.sleep(1000);
	objhbpg.setPfdebit("5678567867897890");	Thread.sleep(1000);
	objhbpg.setPfcvv("067");	Thread.sleep(1000);
	objhbpg.setPfmonth("5");	Thread.sleep(1000);
	objhbpg.setPfyear("2020"); 
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objhbpg.setPfbutton();
	//driver.close();

}

@Then("^navigate to welcome page$")
public void navigate_to_welcome_page() throws Throwable {
	driver.navigate().to("file:///C:/Users/ATTKUMAR/AppData/Local/Temp/7zO40012FF4/success.html");
	String str1=driver.getTitle();
	System.out.println(str1);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.close();

}

@When("^user leaves first Name blank$")
public void user_leaves_first_Name_blank() throws Throwable {
	objhbpg.setPffname("");	Thread.sleep(1000);
}

@When("^clicks the button$")
public void clicks_the_button() throws Throwable {
	objhbpg.setPfbutton();
}

@Then("^display alert msg$")
public void display_alert_msg() throws Throwable {
	String alertMessage = driver.switchTo().alert().getText();
	Thread.sleep(1000);
	driver.switchTo().alert().accept();
    System.out.println("******" + alertMessage);
    driver.close();
}

@When("^user leaves last Name blank and clicks the button$")
public void user_leaves_last_Name_blank_and_clicks_the_button() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user enters all data$")
public void user_enters_all_data() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(5);	Thread.sleep(1000);
	objhbpg.setPfcardholder("pravin singh");	Thread.sleep(1000);
	objhbpg.setPfdebit("5671234567899876");	Thread.sleep(1000);
	objhbpg.setPfcvv("056");	Thread.sleep(1000);
	objhbpg.setPfmonth("9");	Thread.sleep(1000);
	objhbpg.setPfyear("2020");	Thread.sleep(1000);
}

@When("^user enters incorrect email format and clicks the button$")
public void user_enters_incorrect_email_format_and_clicks_the_button() throws Throwable {
	objhbpg.setPfemail("Rk2@.com");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user leaves MobileNo blank and clicks the button$")
public void user_leaves_MobileNo_blank_and_clicks_the_button() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user enters incorrect mobileNo format and clicks the button$")
public void user_enters_incorrect_mobileNo_format_and_clicks_the_button(DataTable arg1) throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
			
	List<String> objList = arg1.asList(String.class);
	//objhbpg.setPfmobile(objList);	Thread.sleep(1000);
	objhbpg.setPfbutton();
	
	for(int i=0; i<objList.size(); i++) {
		if(Pattern.matches("^[7-9]{1}[0-9]{9}$", objList.get(i))) {
		System.out.println("***** Matched" + objList.get(i) + "*****");
		}
		else {
			System.out.println("***** NOT Matched" + objList.get(i) + "*****");
		}
	}
}

@When("^user doesnot select city$")
public void user_doesnot_select_city() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Select City");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user doesnot select state$")
public void user_doesnot_select_state() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Select State");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user enters (\\d+)$")//d represents int datatype this got created because of the use of scenario outline
public void user_enters(int arg1) throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(arg1);	Thread.sleep(2000);
}

@Then("^allocate rooms such that (\\d+) room for minimum (\\d+) guests$")
public void allocate_rooms_such_that_room_for_minimum_guests(int arg1, int arg2) throws Throwable {
	if(arg2 <=3) {
    	System.out.println("***** 1 room");
    	assertEquals(1, arg1);
    }
    else if(arg2 <=6){
    	System.out.println("***** 2 rooms");
    	assertEquals(2, arg1); 	
    }	 
    else if(arg2 <=9){
    	System.out.println("***** 3 rooms");
    	assertEquals(3, arg1); 	
    }
}

@When("^user leaves CardHolderName blank and clicks the button$")
public void user_leaves_CardHolderName_blank_and_clicks_the_button() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(7);	Thread.sleep(1000);
	objhbpg.setPfcardholder("");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user leaves DebitCardNo blank and clicks the button$")
public void user_leaves_DebitCardNo_blank_and_clicks_the_button() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005480");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(7);	Thread.sleep(1000);
	objhbpg.setPfcardholder("pravin singh");	Thread.sleep(1000);
	objhbpg.setPfdebit("");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user leaves expirationMonth blank and clicks the button$")
public void user_leaves_expirationMonth_blank_and_clicks_the_button() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pravinsingh918@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005680");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(7);	Thread.sleep(1000);
	objhbpg.setPfcardholder("pravin singh");	Thread.sleep(1000);
	objhbpg.setPfdebit("8765431234567898");	Thread.sleep(1000);
	objhbpg.setPfcvv("098");	Thread.sleep(1000);
	objhbpg.setPfmonth("");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

@When("^user leaves expirationYr blank and clicks the button$")
public void user_leaves_expirationYr_blank_and_clicks_the_button() throws Throwable {
	objhbpg.setPffname("pravin");	Thread.sleep(1000);
	objhbpg.setPflname("singh");	Thread.sleep(1000);
	objhbpg.setPfemail("pk.k@gmail.com");	Thread.sleep(1000);
	objhbpg.setPfmobile("7722005680");	Thread.sleep(1000);
	objhbpg.setPfcity("Pune");	Thread.sleep(1000);
	objhbpg.setPfstate("Maharashtra");	Thread.sleep(1000);
	objhbpg.setPfpersons(7);	Thread.sleep(1000);
	objhbpg.setPfcardholder("pk singh");	Thread.sleep(1000);
	objhbpg.setPfdebit("7678567867897890");	Thread.sleep(1000);
	objhbpg.setPfcvv("056");	Thread.sleep(1000);
	objhbpg.setPfmonth("8");	Thread.sleep(1000);
	objhbpg.setPfyear("");	Thread.sleep(1000);
	objhbpg.setPfbutton();
}

}
