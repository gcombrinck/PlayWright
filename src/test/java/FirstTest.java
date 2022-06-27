import com.microsoft.playwright.*;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {

    Playwright playwrite;
    Browser browser;
    Page page;
    String storesText;


    @BeforeMethod
    public void setUp(){
        playwrite = Playwright.create();
        BrowserType chromium = playwrite.chromium();
        browser = chromium.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        page = browser.newPage();
    }
    @Test
    public void Launch_Stores(){
            page.navigate("https://catalog.qa.sixty60.co.za/");
            page.click("input[name=\"email\"]");
            page.fill("input[name=\"email\"]","michael@zulzi.com");
            page.fill("body > div > form > div:nth-child(2) > input","6060");
            page.click("body > div > form > div:nth-child(3) > div:nth-child(1) > input");
            page.click("#app > div > div > ul:nth-child(1) > li:nth-child(2) > h3:nth-child(1) > a");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("storeList.png")));
            storesText = page.textContent("body > nav > div > a > small");
            System.out.println(storesText);
        }
    }

