package com;

import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class BaseTest {
	WebDriver dr;
 @Parameters({"browsser","url"})
  @BeforeMethod(groups = "ui")
  public void beforeMethod(String b, String u) {
	 System.out.println("BeforeMethod");
	 if(b.equals("Chrome")) {
		 dr=new ChromeDriver();
	 }else if(b.equals("Firefox")) {
		 dr=new FirefoxDriver();
		 
	 }
	 
	  
  }

  @AfterMethod(alwaysRun = true)
  public void afterMethod(ITestResult r) {
	  switch(r.getStatus()) {
	  case ITestResult.SUCCESS:{
		  System.out.println(r.getName()+"is passed");
		  
	  }
	  case ITestResult.FAILURE:{
		  System.out.println(r.getName()+"is failed");
		  System.out.println("take Screenshot");
	  }
	  case ITestResult.SKIP:{
		  System.out.println(r.getName()+"will skip");
		  Reporter.log(r.getName()+"will skiped");
	  }
	  }
	  System.out.println("AfterMethod");

  }


  @BeforeClass
  public void beforeClass() {
	  System.out.println("BeforeClass");

  }

  @AfterClass
  public void afterClass() {
	  System.out.println("AfterClass");

  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("BeforeTest");

  }

  @AfterTest
  public void afterTest() {
	  System.out.println("AfterTest");

  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("BeforeSuite");

  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("AfterSuite");

  }

}
