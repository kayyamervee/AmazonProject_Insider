package runner;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;
public class Amazon extends GWD {
    @Test
    public void amazonTest() {
        DialogContent element =new DialogContent();

        // Go to https://www.amazon.com.tr/
        driver.get(ConfigReader.getProperty("URL"));

        // Close the popup if needed
        if (!element.rejectCookies.isEmpty()) {
            element.rejectCookies.get(0).click();
        }

        // Verify that you are on the home page
        Assert.assertTrue(driver.getCurrentUrl().equals(ConfigReader.getProperty("URL")));
        Assert.assertTrue(driver.getTitle().contains(ConfigReader.getProperty("Title")));

        // Type 'samsung' in the search field at the top of the screen and perform search.
        element.mySendKeys(element.searchBox,ConfigReader.getProperty("item"));
        element.myClick(element.searchSubmitBtn);

        // Verify that there are results for Samsung on the page that appears.
        if (element.searchItemControl.isDisplayed()){
            Assert.assertTrue(element.searchItemControl.getText().contains(ConfigReader.getProperty("item")));
        }

        for (int i = 0; i < element.items.size(); i++) {
            if (!element.items.get(i).getText().contains(ConfigReader.getProperty("item"))){
                continue;
            }
            Assert.assertTrue(element.items.get(i).getText().contains(ConfigReader.getProperty("item")));
            element.scrollToElement(element.items.get(i));
        }

        // Click on the 2nd page from the search results and verify that the 2nd page is currently displayed on the page that opens.
        element.scrollToElement(element.scrollToNavigation);
        wait.until(ExpectedConditions.visibilityOf(element.scrollToNavigation));
        element.myClick(element.pageTwoBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains("page=2"));
        element.wait.until(ExpectedConditions.visibilityOf(element.searchItemControl));
        if(element.searchItemControl.isDisplayed()){
            Assert.assertTrue(element.searchItemControl.getText().contains(ConfigReader.getProperty("item")));
        }

        // Go to the 3rd Product page from the top
        element.wait.until(ExpectedConditions.visibilityOf(element.productItem));
        String productName=element.productItem.getText();
        element.wait.until(ExpectedConditions.elementToBeClickable(element.productItem));
        element.myClick(element.productItem);

        // Verify that you are on the product page
        Assert.assertTrue(element.productName.getText().equals(productName));

        // Add the product to the cart
        element.wait.until(ExpectedConditions.elementToBeClickable(element.addToCartBtn));
        element.myClick(element.addToCartBtn);

        // Verify that the product has been added to the cart
        if (element.itemControl.isDisplayed()){
            Assert.assertTrue(element.addToCartControl.getText().contains("Sepete eklendi"));
        }

        // Go to the cart page
        element.wait.until(ExpectedConditions.elementToBeClickable(element.goToCartBtn));
        element.myClick(element.goToCartBtn);

        // Verify that you are on the cart page and that the correct product has been added to the cart
        if (element.toCartControl.isDisplayed()){
            Assert.assertTrue(element.toCartControl.getText().contains("Alışveriş Sepeti"));
        }

        // Delete the product from the cart and verify that it has been deleted
        element.wait.until(ExpectedConditions.elementToBeClickable(element.itemDeleteBtn));
        element.myClick(element.itemDeleteBtn);
        Assert.assertTrue(element.deleteControl.getText().contains("kaldırıldı"));

        // Return to the home page and verify that it is on the home page
        element.myClick(element.logo);
        Assert.assertTrue(driver.getCurrentUrl().contains(ConfigReader.getProperty("URL")));
    }
}