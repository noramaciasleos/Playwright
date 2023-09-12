import com.microsoft.playwright.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import java.util.Arrays;

public class FirstTest extends PlaywrightRunner{

        @Test
        @Disabled
        public void firsTest(){

            page.navigate(getProperty("url"));
          //  BrowserContext browserContext2 = browser.newContext();
         //   Page page2 = browserContext.newPage();

          //  page2.navigate( " https://hs-ar-viewer-git-feature-upload-video-dvl-magic-vision.vercel.app/?sku=AFHS-7650588&customer_id=2026734628");
        //    page.locator("//a[@data-lid='hdr_dotd']").click();
          //  page.locator("[data-lid='hdr_dotd']").click();   CSS selector
          //  Locator locator = page.locator("a:has-text(\"Deal of the Day\")");
          //  locator.click();
           // locator.hover();
                Locator menuItems = page.locator("ul.bottom-nav-left li a");
                System.out.println(menuItems.allTextContents());
                for (int i=1; i< menuItems.count(); i++)
                    System.out.println(menuItems.nth(i).textContent());
                page.locator("ul.bottom-nav-left li a", new Page.LocatorOptions().setHasText("Deal of the Day")).click();

            System.out.println();


    }

}
