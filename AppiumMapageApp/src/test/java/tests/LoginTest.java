package tests;

import java.io.BufferedReader;
import java.io.FileReader;

import org.json.JSONObject;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest<MobileElement> extends BaseClass {

	@Test(enabled = false)
	public void Test1() {
		try {

			for (int i = 1; i <= 4; i++) {
				driver.findElement(By.xpath("//*[@class='android.view.ViewGroup' and ./*[@text='次へ']]")).click();
			}
		}

		catch (Exception e) {
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Problem is: " + e.getMessage());
			e.printStackTrace();
		}
	}

	
	
	@Test(description= "Verify the login")
	public void Test2() {
		try {

			driver.findElement(By.xpath("//*[@text='ログイン']")).click();

			// Email & Password Fill
			String filePath = "src/test/resources/Data/login.json";

			BufferedReader reader = new BufferedReader(new FileReader(filePath));
			StringBuilder jsonContent = new StringBuilder();
			String line;
			while ((line = reader.readLine()) != null) {
				jsonContent.append(line);
			}
			reader.close();

			// Parse the JSON content
			JSONObject jsonObject = new JSONObject(jsonContent.toString());

			// Access the JSON data
			String email = jsonObject.getString("email");
			String password = jsonObject.getString("password");

			driver.findElement(By.xpath("//*[@text='mailaddress@xxxxxxxx.com']")).sendKeys(email);
			driver.findElement(By.xpath("//*[@text='パスワードを入力する']")).sendKeys(password);

			driver.findElement(By.xpath(
					"//*[@text='ログイン' and ./parent::*[./parent::*[./parent::*[(./preceding-sibling::* | ./following-sibling::*)[@class='android.view.ViewGroup']]]]]"))
					.click();
		}

		catch (Exception e) {
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Problem is: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	
	@Test(description= "Verify the forgot password")
	public void Test3() {
		try {

		}

		catch (Exception e) {
			System.out.println("Cause is: " + e.getCause());
			System.out.println("Problem is: " + e.getMessage());
			e.printStackTrace();
		}
	}
}
