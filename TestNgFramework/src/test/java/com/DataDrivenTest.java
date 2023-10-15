package com;

import org.testng.annotations.Test;

import dv.DataSource;

public class DataDrivenTest {
	 @Test(dataProviderClass=DataSource.class,dataProvider = "xldata")
	  public void f(Object n, Object s) {
		 System.out.println(n);//user1 user2
		 System.out.println(s);//pass2 pass2
	  }

}
