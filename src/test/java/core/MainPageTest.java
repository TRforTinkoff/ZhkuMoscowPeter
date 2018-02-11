package core;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

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

	
//        	@BeforeMethod(alwaysRun = true)
//	    public void driverSetupGecko() {
//		 MainPage onMainPage = new MainPage(driver);
//	    onMainPage.setDriverGeco();
//        System.out.println("Gecko driver was setup"); }
//	
	@BeforeMethod(alwaysRun = true)
	public void driverSetUp() {
//	 	 
        //DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        //capabilities.setCapability("marionette", true);
	 	//WebDriver dr = new FirefoxDriver(capabilities);
//	 	 
	 	 System.setProperty("webdriver.gecko.driver", "/Users/tatianaryzhkova/Downloads/geckodriver2"); 	 
	 	WebDriver dr = new FirefoxDriver();
	 	dr.get("https://www.tinkoff.ru");	 }
	 
	
	@Test
	public void verifyStartPageTitle() {
		 MainPage onMainPage = new MainPage(driver);
		 onMainPage.navigateToMainPage();
		 onMainPage.getPageTitle().toString().contains(startPageTitle); }

 	//пункт 1-6
    @Test
    public void payZhkuMoscow() {
	    MainPage onMainPage = new MainPage(driver);
	    onMainPage.navigateToMainPage();
	    onMainPage.paymentLinkClick();
	    onMainPage.kommunalniePlatezhiLinkClick();
	    AssertJUnit.assertTrue(onMainPage.getRegion().toString().contains(cityMoscow));
	    onMainPage.clickZhkuMoscowLink();
	    onMainPage.payerCodePresent(); }
    
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