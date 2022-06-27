package pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class StoresPage {
    private final Locator storesLink;

    private final Locator storesHeader;

    public StoresPage(Page page) {
        this.storesLink = page.locator("#app > div > div > ul:nth-child(1) > li:nth-child(2) > h3:nth-child(1) > a");
        this.storesHeader = page.locator("body > nav > div > a > small");
    }

    public void navigate() {
        storesLink.click();
    }
    public Locator getStoresHeader() {
        return storesHeader;
    }
}
