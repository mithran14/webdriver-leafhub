package com.learnerhub.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import com.framework.testng.api.base.ProjectHooks;

public class WelcomePage extends ProjectHooks{

	
	 
	public WelcomePage verifyWelcomeMessage( ) throws MalformedURLException, InterruptedException {
		
		
		String text=getElementText(getDriver().findElement(By.xpath("//h1[text()='Welcome to Testleaf Learning Hub!']")));
		System.out.println(text);
		reportStep("Title match successfully", "pass");
		return new WelcomePage();
	}
	

}
