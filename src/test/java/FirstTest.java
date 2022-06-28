import com.microsoft.playwright.*;
import init.InitializePlaywright;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
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
    @Parameters({"email", "password"})
    public void Launch_Stores(String email, String password){
            loginPage.navigate();
            loginPage.login(email, password);
            storesPage.navigate();
            storesText = String.valueOf(storesPage.getStoresHeader().innerText());
            System.out.println(storesText);
            assertEquals("The Header text did not match!", "Stores", storesText);
        }
    }

