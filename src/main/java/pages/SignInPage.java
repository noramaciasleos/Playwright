package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

public class SignInPage {
    private final Page signInPage;
    private static final String EMAIL= "input#fld-e";
    private static final String PASSWORD= "input#fld-p1";
    private static final String SIGN_IN_BUTTON = "//button[@data-track='Sign In']";

    public SignInPage(Page page){
        this.signInPage= page;
    }

    public void signIn(String email, String password) {
        System.out.println();
        signInPage.locator(EMAIL).fill(email);
        signInPage.locator(PASSWORD).fill(password);
        signInPage.locator(SIGN_IN_BUTTON).click();

        System.out.println();
    }


}
