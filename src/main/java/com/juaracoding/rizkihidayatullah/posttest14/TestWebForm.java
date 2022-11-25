package com.juaracoding.rizkihidayatullah.posttest14;

import net.bytebuddy.implementation.bytecode.Throw;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestWebForm {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "D:\\cv\\chromedriver_win32\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        String url = "https://formy-project.herokuapp.com/form";
        driver.get(url);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        int detik = 1;

        String titleName = driver.getTitle();
        System.out.println(titleName);

        delay(detik);
        driver.findElement(By.xpath("/html/body/div/form/div/div[8]/a")).click();
        System.out.println("Click Submit");

        delay(detik);
        WebElement titleFormName = driver.findElement(By.xpath("/html/body/div/h1"));
        System.out.println("Title menu : " +titleFormName.getText());

        delay(detik);
        driver.findElement(By.id("first-name")).sendKeys("Rizki ");
        System.out.println("Input First Name");

        delay(detik);
        driver.findElement(By.id("last-name")).sendKeys("Hidayatullah");
        System.out.println("Input Last Name");

        delay(detik);
        driver.findElement(By.id("job-title")).sendKeys("QA manual");
        System.out.println("Input Job Title");

        js.executeScript("window.scrollBy(0,500)");

        delay(detik);
        driver.findElement(By.id("checkbox-1")).click();
        System.out.println("Male Checkbox");

        WebElement elementSelect = driver.findElement(By.id("select-menu"));
        Select selectMenu = new Select(elementSelect);

        delay(detik);
        selectMenu.selectByValue("1");
        System.out.println("Select years of experience");

        delay(detik);
        driver.findElement(By.id("datepicker")).sendKeys("26/07/2000");
        System.out.println("Input Date Picker");


        delay(detik);
        WebElement collegeRadio = driver.findElement(By.id("radio-button-2"));
        js.executeScript("arguments[0].click();", collegeRadio);
        System.out.println("College Radio Clicked");





        delay(detik);
        driver.quit();

    }

    static void delay (int detik) {
        try {
            Thread.sleep(1000*detik);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
