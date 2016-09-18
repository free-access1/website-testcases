package com.bizzclick.website.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.concurrent.TimeUnit;


public class TestSuite extends ConstantsProviders {
    public WebDriver driver;
    public StringBuffer verificationErrors = new StringBuffer();

    public void startTest(String browser, String url) {

        driver = setWebDriver(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.navigate().to(url);
    }

    public WebDriver setWebDriver(String browser) {
        WebDriver driver;
        String key = browser.toLowerCase();

        if (key.equals(IE)) driver = new InternetExplorerDriver();
        else if (key.equals(OPERA)) driver = new OperaDriver();
        else if (key.equals(SAFARI)) driver = new SafariDriver();
        else if (key.equals(CHROME)) driver = new ChromeDriver();
        else driver = new FirefoxDriver();
        return driver;
    }

    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void getLinkFromEmail(WebDriver driver, String emailboxLogin, String emailboxPassword, String email, String link) throws InterruptedException {
        MailBox mailBox = new MailBox();
        mailBox.login(driver, emailboxLogin, emailboxPassword);
        Thread.sleep(10000);
        driver.navigate().refresh();
        mailBox.getLinkFromEmail(driver, email, link);
    }

    public void deleteEmailFromMailbox(WebDriver driver, String emailboxLogin, String emailboxPassword, String email, String emailCheckbox) {
        MailBox mailBox = new MailBox();
        mailBox.login(driver, emailboxLogin, emailboxPassword);
        mailBox.deleteEmail(driver, email, emailCheckbox);
        mailBox.logout(driver);
    }

    public void signUp(WebDriver driver, String name, String company, String email, String password, String confirmPassword) {

        driver.findElement(By.xpath(SIGNUP_LINK_XPATH)).click();
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

    public void login(WebDriver driver, String emailValue, String passwordValue) throws Exception {

        driver.findElement(By.xpath(LOGIN_LINK_XPATH)).click();
        driver.findElement(By.id(EMAIL_ID)).clear();
        driver.findElement(By.id(EMAIL_ID)).sendKeys(emailValue);
        driver.findElement(By.id(PASSWORD_ID)).clear();
        driver.findElement(By.id(PASSWORD_ID)).sendKeys(passwordValue);
        driver.findElement(By.xpath(LOGIN_BUTTON_XPATH)).click();
    }

    public void sendForgotPasswordToken(WebDriver driver, String email) {

        driver.findElement(By.xpath(LOGIN_LINK_XPATH)).click();
        driver.findElement(By.xpath(FORGOT_PASSWORD_LINK_XPATH)).click();
        driver.findElement(By.id(FORGOT_PASSWORD__EMAIL_ID)).clear();
        driver.findElement(By.id(FORGOT_PASSWORD__EMAIL_ID)).sendKeys(email);
        driver.findElement(By.xpath(FORGOT_PASSWORD__RESET_PASSWORD_BUTTON_XPATH)).click();
    }

    public void addApplication (WebDriver driver, boolean serverCheck, String title, String packageName, String url, String category, String platform, String ageLimit, boolean paidApp, boolean virtualCurrency, String currencyName, String exchangeRate, boolean backExchange) throws InterruptedException {

        driver.findElement(By.xpath(APPLICATIONS_TAB_XPATH)).click();
        driver.findElement(By.xpath(ADD_APPLICATION_BUTTON)).click();

        if (serverCheck) {
            ((JavascriptExecutor) driver).executeScript(
                "document.getElementById('title').removeAttribute('required'); " +
                "document.getElementById('package_name').removeAttribute('required'); " +
                "document.getElementById('url').removeAttribute('type');" +
                "document.getElementById('category').removeAttribute('required');" +
                "document.getElementById('platform').removeAttribute('required');" +
                "document.getElementById('age_limits').removeAttribute('required');" +
                "document.getElementById('currency_name').removeAttribute('required');" +
                "document.getElementById('exchange_rate').removeAttribute('required');" +
                "document.getElementById('exchange_rate').removeAttribute('type');");
        }

        driver.findElement(By.xpath(INPUT_TITLE_XPATH)).clear();
        driver.findElement(By.xpath(INPUT_TITLE_XPATH)).sendKeys(title);
        driver.findElement(By.xpath(INPUT_PACKAGE_NAME_XPATH)).clear();
        driver.findElement(By.xpath(INPUT_PACKAGE_NAME_XPATH)).sendKeys(packageName);
        driver.findElement(By.xpath(INPUT_APP_URL_XPATH)).clear();
        driver.findElement(By.xpath(INPUT_APP_URL_XPATH)).sendKeys(url);
        driver.findElement(By.xpath(MULTI_SELECT_CATEGORY_BUTTON_XPATH)).click();
        driver.findElement(By.xpath(category)).click();

        Select platformSelect = new Select(driver.findElement(By.xpath(SELECT_PLATFORM_XPATH)));
        platformSelect.selectByValue(platform);

        Select ageLimitSelect = new Select(driver.findElement(By.xpath(SELECT_AGE_LIMITS_XPATH)));
        ageLimitSelect.selectByValue(ageLimit);

        if (paidApp) {
            driver.findElement(By.xpath(CHECKBOX_PAID_APPLICATION_XPATH)).click();
        }
        if (virtualCurrency) {
            driver.findElement(By.xpath(CHECKBOX_VIRTUAL_CURRENCY_XPATH)).click();
            driver.findElement(By.xpath(INPUT_CURRENCY_NAME_XPATH)).clear();
            driver.findElement(By.xpath(INPUT_CURRENCY_NAME_XPATH)).sendKeys(currencyName);
            driver.findElement(By.xpath(INPUT_EXCHANGE_RATE_XPATH)).clear();
            driver.findElement(By.xpath(INPUT_EXCHANGE_RATE_XPATH)).sendKeys(exchangeRate);
            if (backExchange) {
                driver.findElement(By.xpath(CHECKBOX_EXCHANGE_INTO_REAL_CURRENCY_XPATH)).click();
            }
        }
        driver.findElement(By.xpath(BUTTON_ADD_NEW_APPLICATION_XPATH)).click();
    }
}