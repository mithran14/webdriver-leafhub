package com.learnerhub.testcases;



import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.framework.testng.api.base.ProjectHooks;
import com.learnerhub.pages.LoginPage;

public class TC003_VerifyLoginDetail extends ProjectHooks{
	@BeforeTest
	public void setValues() {
		testcaseName = "Login";
		testDescription ="Login to Learner Hub";
		authors="Babu";
		category ="Smoke";
	}

	@Test
	public void runLogin() throws MalformedURLException, InterruptedException {
		new LoginPage()
		.enterUsername()
		.enterPassword()
		.clickLogintoWelcomePage()
		.verifyWelcomeMessage();

	}

}
