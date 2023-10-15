package com;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class UnitTest extends BaseTest {
	@Test(groups = "smoke",priority = 1)
	public void login() {
		System.out.println("test1");
	}

	@Test(groups = "backend",priority = 2,dependsOnGroups = "login")
	public void logout() {
		System.out.println("test2");
	}
	public void softAssert() {
		SoftAssert softAssert=new SoftAssert();
		softAssert.assertTrue(3>5);
		System.out.println("continue");
		softAssert.assertAll();
		
	}

}
