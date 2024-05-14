package stepdefinitions;


import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.HelperClass;

public class Hooks {
	
	 @BeforeClass
	 public static void setup() {
	        System.out.println("Ran the before");
	 }
	
	@Before
    // Hooks berjalan sebelum langkah pertama dari setiap skenario
	public static void setUp() {
       HelperClass.setUpDriver();
    }
 
    @After
    // Hooks berjalan setelah langkah terakhir dari setiap skenario, bahkan ketika hasil langkah tersebut gagal, tidak terdefinisi, tertunda, atau dilewati.
    // Parameter skenario bersifat opsional. Jika Anda menggunakannya, Anda dapat memeriksa status dari skenario tersebut.
    public static void tearDown(Scenario scenario) {
 
        // Validate jika scenario failed
        if(scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName()); 
        }   
         
        HelperClass.tearDown();
    }
	
}
