//package com.harish.testcases;
//
//import java.io.IOException;
//
//import org.testng.annotations.DataProvider;
//import org.testng.annotations.Test;
//
//
//public class ResolutionTest {
//
//	@Test
//    @DataProvider(name = "resolutions")
//    public Object[][] resolutions() {
//        return new Object[][] {
//            {"Desktop", 1920, 1080}, {"Desktop", 1366, 768}, {"Desktop", 1536, 864},
//            {"Mobile", 360, 640}, {"Mobile", 414, 896}, {"Mobile", 375, 667}
//        };
//    }
//
//    @DataProvider(name="resolutions")
//    @Test
//    public void testResolution() throws IOException {
//    	
//    	//Shutterbug.shootPage(driver, Capture.FULL, true).save(".//src//test//resources//screenshots//");
//    }
//}
//
//
//
package com.harish.testcases;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.harish.helper.Base;

public class ResolutionTest extends Base{

    @DataProvider(name = "resolutions")
    public static Object[][] resolutions() {
        return new Object[][] {
            {"Desktop", 1920, 1080},
            {"Desktop", 1366, 768},
            {"Desktop", 1536, 864},
            {"Mobile", 360, 640},
            {"Mobile", 414, 896},
            {"Mobile", 375, 667}
        };
    }

    @Test(dataProvider = "resolutions")
    public void testResolution(String deviceType, int width, int height) {
        // This method will dynamically run for each resolution and device type
        System.out.println("Running test for: " + deviceType + " - Resolution: " + width + "x" + height);
    }
}
