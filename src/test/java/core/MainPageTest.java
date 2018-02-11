package core;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class MainPageTest {
	
	WebDriver driver;
	
	//to be transferred to csv file
	private static String startPageTitle = "Лучший интернет-банк. Кредит наличными и кредитные карты онлайн";
	private static String paymentPageTitle = "Tinkoff.ru: платежи и переводы денег";
	private static String providersPageTitle = "Оплата ЖКХ без комиссии. Коммунальные платежи онлайн";
	private static String zhkuMoscowPageTitle = "ЖКУ-Москва | Онлайн-проверка задолженностей ЖКУ-Москва";
	private static String cityMoscow = "Москве";
	private static String cityStPetersburg = "Санкт-Петербурге";
	private static String payerCodeInvalid = "123";
	private static String regionStPetersburg = "Санкт-Петербург";
	private static String payerCodeErrorMessage = "Поле неправильно заполнено";

	

	
	@BeforeTest(alwaysRun = true)
	public void driverSetUp() {	
  System.setProperty("webdriver.gecko.driver", "/Users/tatianaryzhkova/Downloads/geckodriver2");
//  DesiredCapabilities dc = DesiredCapabilities.firefox();
//  FirefoxProfile profile = new FirefoxProfile();
//  dc.setCapability(FirefoxDriver.PROFILE, profile);
//  profile.setPreference("dom.webnotifications.enabled", false);
  driver = new FirefoxDriver(); }
	
	
	 	
	
	@Test
	public void verifyStartPageTitle() {
		 MainPage onMainPage = new MainPage(driver);
		 onMainPage.navigateToMainPage();
		 onMainPage.getPageTitle().toString().contains(startPageTitle); }
	
	@Test
	public void verifyPaymentPageTitle() {
		 MainPage onMainPage = new MainPage(driver);
		 onMainPage.navigateToPaymentPage();
		 onMainPage.getPageTitle().toString().contains(paymentPageTitle); }
	
	@Test
	public void verifyZhKKhPageTitle() {
		 MainPage onMainPage = new MainPage(driver);
		 onMainPage.navigateToPaymentPage();
		 onMainPage.getPageTitle().toString().contains(providersPageTitle); }
	

	
	
 	//пункт 1-6
    @Test
    public void payZhkuMoscow() {
	    MainPage onMainPage = new MainPage(driver);
	    onMainPage.navigateToMainPage();
//	    onMainPage.paymentLinkClick();
//	    onMainPage.kommunalniePlatezhiLinkClick();
	    onMainPage.paymentPageAction();
	    AssertJUnit.assertTrue(onMainPage.getRegion().toString().contains(cityMoscow));
	    onMainPage.clickZhkuMoscowLink();
	    onMainPage.payerCodePresent(); }
    
    
    //working around WebPush Notifications
    @Test
    public void payZhkuMoscowActions() {
	    MainPage onMainPage = new MainPage(driver);
	    onMainPage.navigateToMainPage();
	    onMainPage.paymentLinkClickActions();
	    AssertJUnit.assertTrue(onMainPage.getRegion().toString().contains(cityMoscow)); }
    
  //пункт 7
    @Test
    public void payerCodeEH() {
	    MainPage onMainPage = new MainPage(driver);
	    onMainPage.navigateToMainPage();
	    onMainPage.paymentLinkClick();
	    onMainPage.kommunalniePlatezhiLinkClick();
	    onMainPage.clickZhkuMoscowLink();
	    onMainPage.enterInvalidDataEH(payerCodeInvalid);
	    AssertJUnit.assertTrue(onMainPage.getZhkuFieldErrorMessage().toString().contains(payerCodeErrorMessage)); }
    
  //пункт 13
    @Test
    public void changeRegionStPetersburg() {
	    MainPage onMainPage = new MainPage(driver);
	    onMainPage.navigateToMainPage();
	    onMainPage.paymentLinkClick();
	    onMainPage.changeRegionMscStPet(); }
	    // onMainPage.enterStPetersburgRegion(regionStPetersburg);    }

 
    @AfterTest(alwaysRun = true)
    public void closeWebdriver() {
 	   if(driver != null) {
 	   driver.quit(); } }
    
    //end of Class
     }