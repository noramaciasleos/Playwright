package pages;

import com.microsoft.playwright.Page;

public class AccountNavigation {
    private final Page accountNavigationPage;
    private  static final String ACCOUNT_BUTTON = "button[data-lid='hdr_signin']";
    private static final String ACCOUNT_LINKS_TEMPLATE = "//div[@class='account-menu']//a[text()='%s']";

    public AccountNavigation(Page page){
        this.accountNavigationPage= page;
    }
        public void NavigateTo(AccountEntries accountEntries){
            accountNavigationPage.locator(ACCOUNT_BUTTON).click();
            accountNavigationPage.locator(String.format(ACCOUNT_LINKS_TEMPLATE, accountEntries.getDisplayName())).click();

    }


}
