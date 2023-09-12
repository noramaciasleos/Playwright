package pages;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.assertions.LocatorAssertions;

import java.security.PrivateKey;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CreateAccountPage {

    private final Page createAccountPage;
    private static final String FIRST_NAME = "input#firstName";
    private static final String LAST_NAME = "input#lastName";
    private static final String EMAIL = "input#email";
    private static final String PASSWORD1 = "input#fld-p1";
    private static final String PASSWORD2 = "input#reenterPassword";
    private static final String PHONE = "input#phone";
    private static final String RECOVERY_PHONE = "input#is-recovery-phone";
    private static final String VALIDATION_MESSAGE = "span.c-input-error-message";
    private static final String SUBMIT_BUTTON = "button.cia-form__controls__submit";

    public CreateAccountPage(Page page) {
        this.createAccountPage = page;

    }

    public void createAccount() {

        createAccountPage.locator(FIRST_NAME).fill("nora");
        createAccountPage.locator(LAST_NAME).fill("macias");
        createAccountPage.locator(EMAIL).fill("noragml_17@hotmail.com");
        createAccountPage.locator(PASSWORD1).fill("Zeus123456$");
        createAccountPage.locator(PASSWORD2).fill("Zeus123456$");
        assertThat(createAccountPage.locator(VALIDATION_MESSAGE)).containsText(
                "Your passwords match!", new LocatorAssertions.ContainsTextOptions().setTimeout(30000));
        createAccountPage.locator(PHONE).fill("980‑980‑9809");
        createAccountPage.locator(RECOVERY_PHONE).check();
        assertThat(createAccountPage.locator(SUBMIT_BUTTON)).isEnabled(new LocatorAssertions.IsEnabledOptions().setTimeout(10000));

    }


}
