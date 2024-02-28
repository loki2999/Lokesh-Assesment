package com.cap.testrunner99;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableTest {

    public static void main(String[] args) {
        // Set the path to your ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");

        // Create a new instance of the ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Navigate to the provided URL
        driver.get("https://testpages.herokuapp.com/styled/tag/dynamic-table.html");

        // Click on the "Table Data" link to open the data
     // Find the <summary> element by its text content using XPath
        WebElement summaryElement = driver.findElement(By.xpath("//summary[text()='Table Data']"));

        // Click on the <summary> element
        summaryElement.click();

        String inputData = "[{\"name\" : \"Bob\", \"age\" : 20, \"gender\": \"male\"}, " +
                "{\"name\": \"George\", \"age\" : 42, \"gender\": \"male\"}, " +
                "{\"name\": \"Sara\", \"age\" : 42, \"gender\": \"female\"}, " +
                "{\"name\": \"Conor\", \"age\" : 40, \"gender\": \"male\"}, " +
                "{\"name\": \"Jennifer\", \"age\" : 42, \"gender\": \"female\"}]";
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
WebElement jsonInput = driver.findElement(By.id("jsondata"));
jsonInput.sendKeys(Keys.CONTROL + "a");
jsonInput.sendKeys(Keys.DELETE);
jsonInput.sendKeys(inputData);
driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
// Click on the Refresh Table button
WebElement refreshButton = driver.findElement(By.id("refreshtable"));
refreshButton.click();

// Wait for the dynamic table to be updated
// Add explicit wait code here if needed

// Retrieve and assert the table data
List<String> expectedData = Arrays.asList(
    "Bob 20 male",
    "George 42 male",
    "Sara 42 female",
    "Conor 40 male",
    "Jennifer 42 female"
);

assertTableData(driver, expectedData);

// Close the browser
driver.quit();
}

private static void assertTableData(WebDriver driver, List<String> expectedData) {
// Retrieve the table rows
List<WebElement> rows = driver.findElements(By.xpath("//div[@id='tablehere']/p"));

// Assert the data
for (int i = 0; i < rows.size(); i++) {
String actualRow = rows.get(i).getText();
assert actualRow.equals(expectedData.get(i)) : "Assertion failed for row " + (i + 1);
}
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
// Print a success message if all assertions passed
System.out.println("Assertions passed successfully!");
}

        
       }
