package init;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class InitializePlaywright {
    private final String browserName;

    public InitializePlaywright(String browserName) {
        this.browserName = browserName;
    }

    public Page init() {
        Playwright playwrite = Playwright.create();
        BrowserType browserType = null;
        if (browserName.equals("chrome")){
            browserType = playwrite.chromium();
        }

        assert browserType != null;
        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(50));
        return browser.newPage();
    }
}
