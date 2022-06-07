package pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	/*WebElement email = driver.findElement(By.id("usernameInput-input"));
	WebElement password = driver.findElement(By.id("password-input"));
	WebElement signIn = driver.findElement(By.id("signIn"));
	WebElement globalError = driver.findElement(By.id("globalError"));
	WebElement userNameError = driver.findElement(By.id("UsernameTextField__errors-usernameInput"));
	WebElement passwordError = driver.findElement(By.id("PasswordTextField__errors-password"));*/
	@FindBy (id = "usernameInput-input")
	public WebElement email; 
	@FindBy (id = "password-input")
	public WebElement password; 
	@FindBy (id = "signIn")
	public WebElement signIn; 
	@FindBy (id = "globalError")
	public WebElement globalError; 
	@FindBy (id = "UsernameTextField__errors-usernameInput")
	public WebElement userNameError; 
	@FindBy (id = "PasswordTextField__errors-password")
	public WebElement passwordError; 
	
	public void openBrowser() throws IOException {
		FileInputStream f = new FileInputStream("/Users/Kay/Desktop/Testing/prop.properties");
		Properties prop = new Properties();
		prop.load(f);
		
		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "/Users/Kay/Desktop/SeleniumJars/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/Kay/Desktop/SeleniumJars/chromedriver");
		    driver = new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.safari.driver", "/Users/Kay/Desktop/SeleniumJars/safariDriver");
			driver = new SafariDriver();
			
		}
		PageFactory.initElements(driver, this);
	}
	
	public void openLoginPage() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=Df-IEjYkUqI&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJvYXV0aF9rZXkiOiJEZi1JRWpZa1VxSSIsImNvbnNlbnRfcmVxdWlyZWQiOmZhbHNlLCJyZWRpcmVjdF91cmkiOiJodHRwczpcL1wvd3d3LnNjb3RpYW9ubGluZS5zY290aWFiYW5rLmNvbVwvb25saW5lXC9sYW5kaW5nXC9vYXV0aGxhbmRpbmcuYm5zIiwiZXhwIjoxNjQ5MDE1Mjk2LCJpYXQiOjE2NDkwMTQwOTYsImp0aSI6ImYxNTIyMjc2LWUwN2QtNGM3OS1iYjY2LTcwMmM0MTFjMTU4NiIsImNsaWVudF9pZCI6IjhlZTkwYzM5LTFjNTItNGZmNC04YWU2LWE3YjU0YzUzOTkzMyIsImNsaWVudF9tZXRhZGF0YSI6eyJDaGFubmVsSUQiOiJTT0wiLCJBcHBsaWNhdGlvbkNvZGUiOiJINyJ9LCJpc3N1ZXIiOiJodHRwczpcL1wvcGFzc3BvcnQuc2NvdGlhYmFuay5jb20ifQ.F13eJ9r7yI4ejJV3Pwy7SAO19CQREdOc6-AK9dEpmJ6HVkbl2t5WusB33hYyPJSJuG1KMe1Bi_I-DpHo9r_yVQVWV_WPfn95uqP0telobJQFX3QOd51bi0WQDaTetvQt2QrhWfiGIKmGTjOX-RNZNoyb4Ll5wZMeW8Twv1XEwvY7b0rlCzy6ZWhChHCjiQyFgzUXjNei6iX03Olza_QT4UUh2DIDZkOljgA3wlnKvJM7QCfVgo2S-5K-pfK0-xBNQdOMvjUcBsVyAw3hignko-lU5tZlSAJX8j0RaRtr9uv948naWdBMb3gb1tLkUgeJ8sMDmKy4YxlWr-2e8mgPAA&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	public void closeBrowser() {
		driver.quit();
	}
	
	public void login(String a, String b) throws InterruptedException {
		email.sendKeys(a);
		password.sendKeys(b);
		signIn.click();
		Thread.sleep(3000);
	}
	
	public String readGobalErr() {
		String actualErr = globalError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	public String readEmailErr() {
		String actualErr = userNameError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
	public String readPasswordErr() {
		String actualErr = passwordError.getText();
		System.out.println(actualErr);
		return actualErr;
	}
}
