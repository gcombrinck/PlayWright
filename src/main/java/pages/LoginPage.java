package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class LoginPage {
    private final Page page;
    private final Locator email;
    private final Locator password;
    private final Locator submit;

    public LoginPage(Page page) {
        this.page = page;
        this.email = page.locator("input[name=\"email\"]");
        this.password = page.locator("body > div > form > div:nth-child(2) > input");
        this.submit = page.locator("body > div > form > div:nth-child(3) > div:nth-child(1) > input");
    }

    public void navigate() {
        page.navigate("https://catalog.qa.sixty60.co.za/");
    }

    public void login(String email, String password){
        this.email.click();
        this.email.fill(email);
        this.password.fill(password);
        this.submit.click();
    }
}
