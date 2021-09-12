// Based on the example code at http://www.seleniumhq.org/docs/03_webdriver.jsp
package edu.drexel.se320;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Test;

public class SeleniumTest {

    protected final String uiPath = "file:///C:/Users/Benny/Desktop/hw5/web/index.html";
    
    @Test
    public void testOneItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            // Find the + to click to display the form to add a todo
            // Looking up by the id, not the name attribute
            WebElement elt = driver.findElement(By.id("controls1plus"));

            // Click on the [+]
            elt.click();

            // Find the form field
            WebElement input = driver.findElement(By.id("itemtoadd"));

            // Make up a todo
            input.sendKeys("Something to do");

            // Find and click the "Add to list" button
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();

            /* The first element added to the list will have id "item1"
             * Subsequent list items will have IDs item2, item3, etc.
             * Arguably this is too brittle, but rather than forcing you
             * all to become experts on the DOM, you may assume this is done
             * correctly, and/or you're testing this functionality implicitly. */
            WebElement li = driver.findElement(By.id("item1"));
            // We use startsWith because getText includes the text of the Delete button
            assertTrue("Checking correct text for added element", 
                       li.getText().startsWith("Something to do"));
        } finally {
            driver.quit();
        }
    }
    
    @Test
    public void testTwoItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            WebElement elt = driver.findElement(By.id("controls1plus"));
            elt.click();
            WebElement input = driver.findElement(By.id("itemtoadd"));
            input.sendKeys("Something to do");
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();
            WebElement input2 = driver.findElement(By.id("itemtoadd"));
            input2.sendKeys("2");
            WebElement addButton2 = driver.findElement(By.id("addbutton"));
            addButton2.click();
            WebElement li = driver.findElement(By.id("item1"));
            WebElement li2 = driver.findElement(By.id("item2"));
            assertTrue("Checking correct text for added element", 
                       li.getText().startsWith("Something to do"));
            assertTrue("Checking correct text for second added element", 
                    li2.getText().startsWith("Something to do2"));
        } finally {
        	driver.quit();
        }
    }
    
    @Test
    public void DeleteOneItemFirst() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            WebElement elt = driver.findElement(By.id("controls1plus"));
            elt.click();
            WebElement input = driver.findElement(By.id("itemtoadd"));
            input.sendKeys("Something to do");
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();
            WebElement input2 = driver.findElement(By.id("itemtoadd"));
            input2.sendKeys("2");
            WebElement addButton2 = driver.findElement(By.id("addbutton"));
            addButton2.click();
            WebElement delete = driver.findElement(By.id("button1"));
            delete.click();
            List<WebElement> li = driver.findElements(By.id("item1"));
            WebElement li2 = driver.findElement(By.id("item2"));
            assertEquals(0, 
                       li.size());
            assertTrue("Checking correct text for second element", 
                    li2.getText().startsWith("Something to do2"));
        } finally {
        	driver.quit();
        }
    }
    
    @Test
    public void DeleteOneItemSecond() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            WebElement elt = driver.findElement(By.id("controls1plus"));
            elt.click();
            WebElement input = driver.findElement(By.id("itemtoadd"));
            input.sendKeys("Something to do");
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();
            WebElement input2 = driver.findElement(By.id("itemtoadd"));
            input2.sendKeys("2");
            WebElement addButton2 = driver.findElement(By.id("addbutton"));
            addButton2.click();
            WebElement delete = driver.findElement(By.id("button2"));
            delete.click();
            WebElement li = driver.findElement(By.id("item1"));
            List<WebElement> li2 = driver.findElements(By.id("item2"));
            assertTrue("Checking correct text for added element", 
                    li.getText().startsWith("Something to do"));
            assertEquals(0, 
                       li2.size());

        } finally {
        	driver.quit();
        }
    }
    
    @Test
    public void DeleteTwoItem() {
        WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            WebElement elt = driver.findElement(By.id("controls1plus"));
            elt.click();
            WebElement input = driver.findElement(By.id("itemtoadd"));
            input.sendKeys("Something to do");
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();
            WebElement input2 = driver.findElement(By.id("itemtoadd"));
            input2.sendKeys("2");
            WebElement addButton2 = driver.findElement(By.id("addbutton"));
            addButton2.click();
            WebElement delete = driver.findElement(By.id("button1"));
            delete.click();
            WebElement delete2 = driver.findElement(By.id("button2"));
            delete2.click();
            List<WebElement> li = driver.findElements(By.id("item1"));
            List<WebElement> li2 = driver.findElements(By.id("item2"));
            assertEquals(0, 
                       li.size());
            assertEquals(0, 
                    li2.size());
        } finally {
        	driver.quit();
        }
    }
    
    @Test
    public void AddItemAfterDelete() {
    	WebDriver driver = new FirefoxDriver();
        try {
            driver.get(uiPath);
            WebElement elt = driver.findElement(By.id("controls1plus"));
            elt.click();
            WebElement input = driver.findElement(By.id("itemtoadd"));
            input.sendKeys("Something to do");
            WebElement addButton = driver.findElement(By.id("addbutton"));
            addButton.click();
            WebElement input2 = driver.findElement(By.id("itemtoadd"));
            input2.sendKeys("2");
            WebElement addButton2 = driver.findElement(By.id("addbutton"));
            addButton2.click();
            WebElement delete = driver.findElement(By.id("button2"));
            delete.click();
            WebElement input3 = driver.findElement(By.id("itemtoadd"));
            input3.sendKeys(" again");
            WebElement addButton3 = driver.findElement(By.id("addbutton"));
            addButton3.click();
            WebElement li = driver.findElement(By.id("item1"));
            WebElement li2 = driver.findElement(By.id("item3"));
            assertTrue("Checking correct text for second added element", 
                    li.getText().startsWith("Something to do"));
            assertTrue("Checking correct text for second added element", 
                    li2.getText().startsWith("Something to do2 again"));

        } finally {
        	driver.quit();
        }
    }

}
