import com.microsoft.playwright.*;
import com.microsoft.playwright.assertions.LocatorAssertions;
import org.junit.jupiter.api.Test;
import pages.AccountEntries;
import pages.AccountNavigation;
import services.EnvironmentReaderService;

import java.util.Arrays;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class SignupTest extends PlaywrightRunner {

   @Test
    public void signupTest(){

  // homePage.navigate();

      // page.navigate( "https://www.bestbuy.com/?intl=nosplash");
       page.navigate(getProperty("url"));
      // accountNavigation.NavigateTo("Create Account");
       accountNavigation.NavigateTo(AccountEntries.CREATE_ACCOUNT);
      // accountNavigation.NavigateTo("Sign In");
       createAccountPage.createAccount();
    //  accountNavigation.NavigateTo(AccountEntries.SIGN_IN);
    System.out.println();
    }



    @Test
    public void signupTest2(){

        // homePage.navigate();

        // page.navigate( "https://www.bestbuy.com/?intl=nosplash");
        page.navigate(getProperty("url"));
        // accountNavigation.NavigateTo("Create Account");
        accountNavigation.NavigateTo(AccountEntries.CREATE_ACCOUNT);
        // accountNavigation.NavigateTo("Sign In");
        createAccountPage.createAccount();
        //  accountNavigation.NavigateTo(AccountEntries.SIGN_IN);
        System.out.println();
    }
}
