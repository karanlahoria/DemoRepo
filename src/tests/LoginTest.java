package tests;
import org.testng.annotations.Test;
import data.DataFile;
import pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	LoginPage lp = new LoginPage();
	DataFile dp = new DataFile();
  @BeforeMethod
  public void beforeMethod() throws IOException{
	  lp.openBrowser();
	  lp.openLoginPage();
  }

  @AfterMethod
  public void afterMethod() {
	  lp.closeBrowser();
  }
  
  @Test (priority = 1)
  public void loginWithWrongEmailPasswordTest() throws InterruptedException {
		lp.login(dp.wrongEmail, dp.wrongPassword);
		Assert.assertEquals(lp.readGobalErr(), dp.globalErr);
  }
  
  @Test (priority = 2)
  public void loginWithspecialCharEmailTest() throws InterruptedException {
		lp.login(dp.emailWithSpecialChar, dp.wrongPassword);
		Assert.assertEquals(lp.readEmailErr(), dp.specialCharEmailErr);
  }
  @Test (priority = 3)
  public void loginEmptyEmailTest() throws InterruptedException {
		lp.login("", dp.wrongPassword);
		Assert.assertEquals(lp.readEmailErr(), dp.emptyEmailErr);
  }
  @Test (priority = 4)
  public void loginEmptyPasswordTest() throws InterruptedException {
		lp.login(dp.wrongEmail, "");
		Assert.assertEquals(lp.readPasswordErr(), dp.emptyPasswordErr);
  }
}
