package com.demoblaze.step_definitions;

import com.demoblaze.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

   @Before()
   public void setUp(){

   }
   @After()
    public void tearDown(Scenario scenario){
       if (scenario.isFailed()){
           final byte[] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
           scenario.attach(screenshot,"image/png", "screenshot");
       }
       Driver.closeDriver();
   }
}
