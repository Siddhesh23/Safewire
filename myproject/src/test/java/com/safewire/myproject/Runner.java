package com.safewire.myproject;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
      features = {"src/test/resoures/feature/safewirefeature.feature"},
        glue = "com.safewire.definations")
public class Runner {

}
