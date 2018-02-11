package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage  {
	
	WebDriver driver; 
    
    public static final String MAINPAGE_URI="https://www.tinkoff.ru/";  
    public static final String PAYMENTPAGE_URI="https://www.tinkoff.ru/payments/"; 
    public static final String ZhKKhPAGE_URI="https://www.tinkoff.ru/payments/categories/kommunalnie-platezhi/";

    
        // constructor
	public MainPage (WebDriver driver) {
		this.driver = driver;  
        // creating all WebElements
        PageFactory.initElements(driver, this); } 
	
	
	// Elements from Start Page
	    @FindBy(tagName = "title")
	    static WebElement pageTitle;
	    
	    @FindBy(xpath = "//span[contains(.,'Платежи')]")
	    static WebElement paymentsLinkGlobal;
	
	
	// Elements from Payment Page
	@FindBy(xpath = "//li[2]/span[2]/a/span")
	// @FindBy(xpath = "//div[1]/div/div/div/span/span/span")
	// @FindBy(xpath = "//span[contains(.,'ЖКХ')]")
	// @FindBy(xpath = "//path[@data-qa-file='Housing']")
	@CacheLookup
	static WebElement kommunalniePlatezhiLink;
	
	@FindBy(xpath = "//div[2]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div/div/div/span/span/span")
	@CacheLookup
	static WebElement regionLink;
	
	@FindBy(xpath = "//section")
	// @FindBy(xpath = "//li[1]/span[2]/a/span")
	// @FindBy(xpath = "//li[1]/span[2]/a/span/text()")
	// @FindBy(xpath = "//span[contains(.,'ЖКУ-Москва')]")
	@CacheLookup
	static WebElement housingMoscowLinkGlobal;
	
	@FindBy(xpath = "//label/input")
	@CacheLookup
	static WebElement searchFieldINN;
	
	@FindBy(xpath = "//div[1]/input")
	@CacheLookup
	static WebElement regionInputFieldGlobal;
	
	@FindBy(xpath = "//form/div[3]/div/div/div/div/div/div")
	@CacheLookup
	static WebElement regionInputSearchLink;
	
	
	@FindBy(xpath = "//div[2]/div[2]/div/span/a/span")
	static WebElement regionStPetersburg;
	 
	
	// Elements from HousingMoscow Page
	@FindBy(xpath = "//div[3]/div/ul/li[2]/div/a/span")
	static WebElement housingMoscowLink;
	
	@FindBy(xpath = "id('payerCode')")
	//@FindBy(id = "payerCode")
	static WebElement payerCodeField;
	
	@FindBy(xpath = "//form/div[2]/div/div[1]/label/div[1]/input")
	static WebElement emailField;
	
	@FindBy(xpath = "//form/div[1]/div[1]/div/div/div/label/div[1]/input")
	static WebElement loginOrPhoneField;
	
	@FindBy(xpath = "//div[4]/div[1]/div[1]/div/button")
	static WebElement knowDebtButton;
	
	@FindBy(xpath = "//form/div[1]/div/div[2]")
	static WebElement zhkuFieldEM;
	
	@FindBy(xpath = "//form/div[1]/div[1]/div/div/div[2]")
	static WebElement loginFieldEM;
	
	@FindBy(xpath = "//*[@id='mainMenu']/li[3]/span/a/span")
    static WebElement paymentsLinkHousingPage;
	 
	
      //methods
	
	 public String getPageTitle(){
        return    pageTitle.getText(); }
    
     public void navigateToMainPage() {
        driver.navigate().to(MAINPAGE_URI); }
     
     public void navigateToPaymentPage() {
         driver.navigate().to(PAYMENTPAGE_URI); }
     
     public void navigateToZhKKhPage() {
         driver.navigate().to(ZhKKhPAGE_URI); }
    
     public void paymentPageAction() {
         driver.navigate().to(PAYMENTPAGE_URI);
         new Actions(driver).moveToElement(kommunalniePlatezhiLink).click().perform();
     }
     
     
	 public void paymentLinkClick() {
		  paymentsLinkGlobal.click(); }
	 
	 public void paymentLinkClickActions() {
	 new Actions(driver).sendKeys(Keys.ESCAPE).build().perform();
	 paymentsLinkGlobal.click(); }

     public void clickPaymentsLink() {
       if(paymentsLinkGlobal.isDisplayed()) {
    	   paymentsLinkGlobal.click(); }
       getPageTitle();
        System.out.println(getPageTitle().toString());  }  
   
     public void kommunalniePlatezhiLinkClick() {
    	 kommunalniePlatezhiLink.click(); }
   
     public String getRegion() {
    	return regionLink.getText();
    }
     
     public void clickZhkuMoscowLink() {
        housingMoscowLinkGlobal.click();     }
     
     public void payerCodePresent() {
    	 payerCodeField.isDisplayed(); }

     public void changeRegionMscStPet() {
    	 regionLink.click();
    	 regionStPetersburg.click();   }
     
     
	  public void enterStPetersburgRegion(String regionStPetersburg) {
		  regionInputFieldGlobal.sendKeys(regionStPetersburg);
		 // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  regionInputSearchLink.click(); }
	  
	  public void enterInvalidDataEH(String payerCodeInvalid) {
		  payerCodeField.sendKeys(payerCodeInvalid);
		  knowDebtButton.click(); }

      public String getZhkuFieldErrorMessage() {
          return zhkuFieldEM.getText(); }
      
      public String getLoginFieldErrorMessage() {
          return loginFieldEM.getText(); }

//end of Class
	} 