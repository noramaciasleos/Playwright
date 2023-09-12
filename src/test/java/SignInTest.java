import org.junit.jupiter.api.Test;
import pages.AccountEntries;


public class SignInTest extends PlaywrightRunner {

    @Test
    public void signInExistingUser(){
        page.navigate( "https://www.bestbuy.com/?intl=nosplash");
        accountNavigation.NavigateTo(AccountEntries.SIGN_IN);
       signInPage.signIn(getProperty("email"),
               getProperty("password"));
      // homePage.checkWeAreOnTheHomePage();

    }

    @Test
    public void signInExistingUser2(){
        page.navigate( "https://www.bestbuy.com/?intl=nosplash");
        accountNavigation.NavigateTo(AccountEntries.SIGN_IN);
        signInPage.signIn(getProperty("email"),
                getProperty("password"));
        // homePage.checkWeAreOnTheHomePage();

    }

}
