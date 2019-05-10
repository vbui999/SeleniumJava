/*
* (C) Copyright 2019 VanToan Bui
* 
*	@author toanb
*	@date 8 kwi 2019
*	@version 1.0
*/
package edu.sele;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrapeData {
	public static void main( String[] args ) throws InterruptedException
    {
        //
        // Set the path of the driver to driver executable. For Chrome, set the properties as following:
        //
        File file = new File("C:\\Personal docs\\chromedriver_win32\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        // Create a Chrome Web Driver
        //
        WebDriver driver = new ChromeDriver();
        //
        // Open the Indeed.com homepage
        //
        driver.get("https://www.indeed.co.in");
        //
        // Enter the keyword "Java" in the field, What
        //
        driver.findElement(By.id("text-input-what")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("text-input-what")).sendKeys("Java");
        //
        // Enter the keyword, "Hyderabad" in the field, Where
        //
        driver.findElement(By.id("text-input-where")).clear();
        Thread.sleep(2000);
        driver.findElement(By.id("text-input-where")).sendKeys("Hyderabad");
        //
        // Click the FindJobs button for searching
        //
        WebElement parentElement = driver.findElement(By.className("icl-WhatWhere-buttonWrapper"));
        WebElement childElement = parentElement.findElement(By.tagName("button"));  
        childElement.submit();
        //
        // Print the information from the new page
        //
        System.out.println("Page Title:" + driver.getTitle());
        System.out.println("Jobs Count: " + driver.findElement(By.id("searchCount")).getText());
        Thread.sleep(2000);
        //
        // Close the browser
        //
        driver.close();
    }

}
