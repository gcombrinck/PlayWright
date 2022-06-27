import com.microsoft.playwright.*;
import init.InitializePlaywright;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.file.Paths;

import pages.LoginPage;
import pages.StoresPage;

import static org.testng.AssertJUnit.assertEquals;

public class FirstTest {
    Browser browser;
    String storesText;
    StoresPage storesPage;
    LoginPage loginPage;
    InitializePlaywright initialize = new InitializePlaywright("chrome");

    @BeforeMethod
    public void setUp(){
        Page page  = initialize.init();
        loginPage = new LoginPage(page);
        storesPage = new StoresPage(page);
    }
    @Test
    public void Launch_Stores(){
            loginPage.navigate();
            loginPage.login("michael@zulzi.com", "6060");
            storesPage.navigate();
            storesText = String.valueOf(storesPage.getStoresHeader());
            System.out.println(storesText);
        }
    }

