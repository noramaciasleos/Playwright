import annotation.PlayWrightPage;
import com.microsoft.playwright.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import pages.AccountNavigation;
import pages.CreateAccountPage;
import pages.HomePage;
import pages.SignInPage;
import services.EnvironmentReaderService;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Paths;
import java.util.Arrays;


@ExtendWith(TestWatcherExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PlaywrightRunner {
    protected Page page;
    protected BrowserContext browserContext;
    protected Browser browser;
    protected  Playwright playwright;

    @PlayWrightPage
    protected CreateAccountPage createAccountPage;

    @PlayWrightPage
    protected AccountNavigation accountNavigation;

    @PlayWrightPage
    protected HomePage homePage;

    @PlayWrightPage
    protected SignInPage signInPage;


    @BeforeAll
    public  void init() {
        playwright = Playwright.create();
    }

    @BeforeEach
    public void setUp() {

        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        browserContext = browser.newContext(new Browser.NewContextOptions()
                .setPermissions(Arrays.asList("geolocation"))
                .setRecordVideoDir(Paths.get("videos/"))
                        .setRecordVideoSize(1920,1680)
                );
        page = browserContext.newPage();
        browserContext.tracing().start(new Tracing.StartOptions()
                .setScreenshots(true)
                .setSnapshots(true)
                .setSources(false));

        initPage(this, page);
    }

    private void   initPage(Object object,Page page){
        Class<?> clazz = this.getClass().getSuperclass();
        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(PlayWrightPage.class)) {
                Class<?>[] type = {Page.class};
                try {
                    field.set(this, field.getType().getConstructor(type).newInstance(page));
                } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException |
                         InstantiationException e) {
                    throw new RuntimeException(e);
                }
            }

            //  createAccountPage = new CreateAccountPage(page);
            // accountNavigation = new AccountNavigation(page);
        }

    }
        @AfterEach
        public void tearDown (TestInfo testInfo) {
            browserContext.tracing().stop(new Tracing.StopOptions()
                    .setPath(Paths.get("traces/"+ testInfo.getDisplayName().replace("()", "")+ ".zip" )));
            browserContext.close();
            browser.close();
        }


       protected String getProperty(String key){
           return  EnvironmentReaderService.getProperty(key);
        }


    }


