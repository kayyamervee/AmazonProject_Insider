package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GWD;
import utilities.ReusableMethods;

import java.util.List;

public class DialogContent extends ReusableMethods {

    public DialogContent() {
        PageFactory.initElements(GWD.driver, this);
    }

    @FindBy(css = "button[id='sp-cc-rejectall-link']")
    public List<WebElement> rejectCookies;

    @FindBy(css = "[id='twotabsearchtextbox']")
    public WebElement searchBox;

    @FindBy(css = "[id='nav-search-submit-button']")
    public WebElement searchSubmitBtn;

    @FindBy(xpath = "//div[@class='sg-col-inner']/h2")
    public WebElement searchItemControl;

    @FindBy(xpath = "//div[@data-cy='title-recipe']")
    public List<WebElement> items;

    @FindBy(css = "div[class='a-section a-text-center s-pagination-container']")
    public WebElement scrollToNavigation;

    @FindBy(xpath = "//a[@aria-label='2 sayfasına git']")
    public WebElement pageTwoBtn;

    @FindBy(xpath = "(//*[@class='a-link-normal s-line-clamp-4 s-link-style a-text-normal'])[3]")
    public WebElement productItem;

    @FindBy(xpath = "//span[@id='productTitle']")
    public WebElement productName;

    @FindBy(css = "[id='add-to-cart-button']")
    public WebElement addToCartBtn;

    @FindBy(xpath= "//div[@data-csa-c-type='widget']/h1")
    public WebElement addToCartControl;

    @FindBy(xpath = "//span[@class='a-list-item']")
    public WebElement itemControl;

    @FindBy(css = "[data-csa-c-slot-id='sw-gtc']")
    public WebElement goToCartBtn;

    @FindBy(css = "[id='sc-active-items-header']")
    public WebElement toCartControl;

    @FindBy(xpath ="//span[@class='a-truncate-cut']")
    public WebElement productNameToCart;

    @FindBy(css = "[data-feature-id='item-delete-button']")
    public WebElement itemDeleteBtn;

    @FindBy(css = "[data-feature-id='delete-success-message']")
    public WebElement deleteControl;

    @FindBy(css = "[id='nav-logo-sprites']")
    public WebElement logo;
}
