package com.bizzclick.website.ui.Signup;

import com.bizzclick.website.ui.TestGroupWithoutDeletingData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import static org.junit.Assert.assertTrue;

public class SignupWithIncorrectValuesTest extends TestGroupWithoutDeletingData {

    @Test (dataProvider = "incorrectValuesForSignUp")
    public void checkIncorrectEmailOnClientSide(String name, String company, String email, String password1, String password2, String alert) throws Exception {

        super.signUp(driver, name, company, email, password1, password2);
        alert = SIGNUP_BUTTON_ID;

        try {
            assertTrue(isElementPresent(driver, By.id(alert)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test (dataProvider = "incorrectValuesForSignUp")
    public void checkIncorrectDataOnServerSide(String name, String company, String email, String password1, String password2, String alert) throws Exception {

        signUp(driver, name, company, email, password1, password2);

        try {
            assertTrue(isElementPresent(driver, By.xpath(alert)));
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Override
    public void signUp(WebDriver driver, String name, String company, String email, String password, String confirmPassword) {

        driver.findElement(By.xpath(SIGNUP_LINK_XPATH)).click();
        ((JavascriptExecutor) driver).executeScript("document.getElementById('name').removeAttribute('required'); document.getElementById('company').removeAttribute('required'); document.getElementById('email').removeAttribute('required'); document.getElementById('email').removeAttribute('type');");
        driver.findElement(By.id(NAME_ID)).clear();
        driver.findElement(By.id(NAME_ID)).sendKeys(name);
        driver.findElement(By.id(COMPANY_ID)).clear();
        driver.findElement(By.id(COMPANY_ID)).sendKeys(company);
        driver.findElement(By.id(EMAIL_ID)).clear();
        driver.findElement(By.id(EMAIL_ID)).sendKeys(email);
        driver.findElement(By.id(PASSWORD_ID)).clear();
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(password);
        driver.findElement(By.id(CONFIRM_PASSWORD_ID)).clear();
        driver.findElement(By.id(CONFIRM_PASSWORD_ID)).sendKeys(confirmPassword);
        driver.findElement(By.id(SIGNUP_BUTTON_ID)).click();
    }
}