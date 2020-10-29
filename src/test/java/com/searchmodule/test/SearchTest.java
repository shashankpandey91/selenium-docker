package com.searchmodule.test;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.searchmodule.pages.SearchPage;

import test.BaseTest;

public class SearchTest extends BaseTest {



@Parameters({"keyword"})
@Test
public void search(String keyword) 
{
	SearchPage searchPage= new SearchPage(driver);
	searchPage.goTo();
	searchPage.doSearch(keyword);
	//Thread.sleep(3000);
	searchPage.goToVideos();
	int size=searchPage.getResult();
	Assert.assertTrue(size>0);
	
}


}
