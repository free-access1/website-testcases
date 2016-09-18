package com.bizzclick.website.ui.Footer;

import com.bizzclick.website.ui.TestGroupWithoutDeletingData;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import static org.junit.Assert.assertEquals;


public class FooterNavigationTest extends TestGroupWithoutDeletingData{

    // URL# - заглушка
    // Тест не сработает, когда футер будет готов.
    // Несрабатывание теста будет сигналом для того, что тест нужно доработать по действующим ссылкам

    @Test (dataProvider = "footerItems")
    public void navigateTo(String footerItem) throws Exception {
        driver.findElement(By.xpath(footerItem)).click();
        try {
            assertEquals(BASE_URL+"#", driver.getCurrentUrl()); // URL# - проверка на заглушку
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }
}