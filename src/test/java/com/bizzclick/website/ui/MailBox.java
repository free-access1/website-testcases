package com.bizzclick.website.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;

public class MailBox implements Constants{

    public MailBox() {}

   /* Login to mail.ru mailbox
    *
    * @param WebDriver driver       needs to pass current web-driver
    *        String mailboxLogin    name of mailbox like account@mailbox.org
    *        String mailboxPassword password of the mailbox
    * @return void                  driver will open "inbox" folder of the mailbox
    * */
    public void login(WebDriver driver, String mailboxLogin, String mailboxPassword){

        driver.get(MAILBOX_URL);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id(MAILBOX_LOGIN_ID)).clear();
        driver.findElement(By.id(MAILBOX_LOGIN_ID)).sendKeys(mailboxLogin);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id(MAILBOX_PASSWORD_ID)).clear();
        driver.findElement(By.id(MAILBOX_PASSWORD_ID)).sendKeys(mailboxPassword);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id(MAILBOX_LOGIN_BUTTON_ID)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void loginLogout(WebDriver driver) {
        driver.get(MAILBOX_URL);
        driver.findElement(By.xpath(MAILBOX_MAIN_PAGE_LOGOUT_LINK_XPATH)).click();
    }

   /* Logout from mail.ru mailbox
    * It is assumed that the start position of the method is inside of mailbox
    *
    * @params WebDriver driver  needs to pass current web-driver
    * @ return void             driver's end position is on mailbox main page
    * */
    public void logout(WebDriver driver) {
        driver.findElement(By.xpath(MAILBOX_LOGOUT_LINK_XPATH)).click();
    }


   /* Navigate to page via link in email message
    *
    * @params WebDriver driver  needs to pass current web-driver
    *         String email      xpath of email
    *         String link       xpath of link
    * @return void              driver's end position is on url pointed parameter "href" of the link
    **/
    public void getLinkFromEmail(WebDriver driver, String email, String link){
        driver.findElement(By.xpath(email)).click();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(driver.findElement(By.xpath(link)).getAttribute("href"));
    }


   /* Delete concrete email message in mailbox
    * It is assumed that the start position of the method is inside of "inbox" folder of mailbox
    *
    * @param WebDriver driver       needs to pass current web-driver
    *        String email           xpath of email
    *        String deleteCheckbox  xpath of the checkbox of the email
    * @return void                  driver's end position is on "inbox" folder of mailbox
    * */
    public void deleteEmail(WebDriver driver, String email, String emailCheckbox) {
        if(isElementPresent(driver, By.xpath(email))) {
            driver.findElement(By.xpath(emailCheckbox)).click();
            driver.findElement(By.xpath(MAILBOX_DELETE_BUTTON)).click();
        }
    }


    /* Delete all email messages in mailbox
     * It is assumed that the start position of the method is inside of "inbox" folder of mailbox
     *
     * @param WebDriver driver      needs to pass current web-driver
     * @return void                 driver's end position is on "inbox" folder of mailbox
     * */
    public void deleteAllEmails(WebDriver driver) {
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.xpath(MAILBOX_SELET_ALL_EMAILS_CHECKBOX_XPATH)).click();
        driver.findElement(By.xpath(MAILBOX_DELETE_BUTTON)).click();
    }

   /* Check whether the web-element is present on current page
    *
    * @param WebDriver driver   needs to pass current web-driver
    *        By by              class to define the web-element
    * @return boolean
    * */
    public boolean isElementPresent(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}