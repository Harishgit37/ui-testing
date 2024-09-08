//package com.harish.helper;

//
//import java.util.Arrays;
//
//
//import java.util.List;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.BeforeMethod;
//
//import com.assertthat.selenium_shutterbug.core.Capture;
//import com.assertthat.selenium_shutterbug.core.Shutterbug;
//import com.harish.utilities.ScreenRecorderUtil;
//
//
//public class Base {
//   
//    public String browser;
//
//	public WebDriver driver;
//	
//	@BeforeMethod
//	public void setUp() throws Exception {
//		
//		  ScreenRecorderUtil.startRecord("setUp");
//
//		  List<String> urls = Arrays.asList(
//	                "https://www.getcalley.com/",
//	                "https://www.getcalley.com/calley-lifetime-offer/",
//	                "https://www.getcalley.com/see-a-demo/",
//	                "https://www.getcalley.com/calley-teams-features/",
//	                "https://www.getcalley.com/calley-pro-features/"
//	        );
//
//	        List<String> browsers = Arrays.asList("Chrome", "Firefox", "Edge");
//
//	        for (String browser : browsers) {
//	            WebDriver driver = null;
//	            
//	            
//	            if ("Chrome".equals(browser)) {
//	                driver = new ChromeDriver();
//	            } else if ("Firefox".equals(browser)) {
//	                driver = new FirefoxDriver();
//	            } else if ("Edge".equals(browser)) {
//	                driver = new EdgeDriver();
//	            }
//
//	            if (driver != null) {
//	                System.out.println("Opening URLs in " + browser + "...");
//	                for (String url : urls) {
//	                    driver.get(url);
//	                    System.out.println("Title of the current page: " + driver.getTitle());
//	                    Shutterbug.shootPage(driver, Capture.FULL, true).save(".//src//test//resources//screenshots//");
//	                }
//	                ScreenRecorderUtil.stopRecord();
//	                driver.quit();
//	                System.out.println("Closed " + browser);
//	            }
//	        }
//	}
//	
//	
//}
//package com.harish.helper;
//
//import java.io.File;
//
//import java.text.SimpleDateFormat;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//import org.openqa.selenium.Dimension;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.annotations.BeforeMethod;
//
//import com.assertthat.selenium_shutterbug.core.Capture;
//import com.assertthat.selenium_shutterbug.core.Shutterbug;
//import com.harish.testcases.ResolutionTest;
//import com.harish.utilities.ScreenRecorderUtil;
//
//public class Base {
//	
//	public String browser;
//	public WebDriver driver;
//
//    @BeforeMethod
//    public void setUp() throws Exception {
//        // Start recording the session
//        ScreenRecorderUtil.startRecord("ResolutionTest");
//
//        List<String> urls = Arrays.asList(
//                "https://www.getcalley.com/",
//                "https://www.getcalley.com/calley-lifetime-offer/",
//                "https://www.getcalley.com/see-a-demo/",
//                "https://www.getcalley.com/calley-teams-features/",
//                "https://www.getcalley.com/calley-pro-features/"
//        );
//
//        List<String> browsers = Arrays.asList("Chrome", "Firefox", "Edge");
//
//        for (String browser : browsers) {
//        	WebDriver driver = null;
//            for (Object[] resolution : ResolutionTest.resolutions()) {
//                String deviceType = (String) resolution[0];
//                int width = (Integer) resolution[1];
//                int height = (Integer) resolution[2];
//
//                if ("Chrome".equals(browser)) {
//                    driver = new ChromeDriver();
//                } else if ("Firefox".equals(browser)) {
//                    driver = new FirefoxDriver();
//                } else if ("Edge".equals(browser)) {
//                    driver = new EdgeDriver();
//                }
//
//                if (driver != null) {
//                    System.out.println("Opening URLs in " + browser + " with resolution " + width + "x" + height);
//                    driver.manage().window().setSize(new Dimension(width, height));
//
//                    for (String url : urls) {
//                        driver.get(url);
//                        System.out.println("Title of the current page: " + driver.getTitle());
//
//                        // Create folder structure for saving screenshots
//                        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
//                        String screenshotDir = String.format(".//screenshots//%s//%dx%d//", deviceType, width, height);
//                        new File(screenshotDir).mkdirs();
//
//                        Shutterbug.shootPage(driver, Capture.FULL, true).save(screenshotDir + "Screenshot-" + timeStamp + ".png");
//                    }
//
//                    driver.quit();
//                    System.out.println("Closed " + browser);
//                }
//            }
//        }
//
//        // Stop recording after all tests
//        ScreenRecorderUtil.stopRecord();
//    }
//}
package com.harish.helper;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.harish.testcases.ResolutionTest;
import com.harish.utilities.ScreenRecorderUtil;

public class Base {

    public WebDriver driver;
    public String browser;
    
    @BeforeSuite
    public void setUpSuite() throws Exception {
        // Start recording the session
        ScreenRecorderUtil.startRecord("setUpSuite");

        List<String> urls = Arrays.asList(
                "https://www.getcalley.com/",
                "https://www.getcalley.com/calley-lifetime-offer/",
                "https://www.getcalley.com/see-a-demo/",
                "https://www.getcalley.com/calley-teams-features/",
                "https://www.getcalley.com/calley-pro-features/"
        );

        List<String> browsers = Arrays.asList("Chrome", "Firefox", "Edge");

        for (String browser : browsers) {
            initializeDriver(browser);  // Initialize the driver based on the browser
            
            if (driver != null) {
                System.out.println("Opening URLs in " + browser);

                // Iterate over different resolutions
                for (Object[] resolution : ResolutionTest.resolutions()) {
                    String deviceType = (String) resolution[0];
                    int width = (Integer) resolution[1];
                    int height = (Integer) resolution[2];

                    // Set browser window size
                    driver.manage().window().setSize(new Dimension(width, height));
                    System.out.println("Running test on resolution: " + width + "x" + height);

                    // Iterate through all URLs and capture screenshots
                    for (String url : urls) {
                        driver.get(url);
                        System.out.println("Title of the current page: " + driver.getTitle());

                        // Create folder structure for saving screenshots
                        String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss").format(new Date());
                        String screenshotDir = String.format(".//screenshots//%s//%dx%d//", deviceType, width, height);
                        new File(screenshotDir).mkdirs();

                        Shutterbug.shootPage(driver, Capture.FULL, true).save(screenshotDir + "Screenshot-" + timeStamp + ".png");
                    }
                }

                driver.quit();  // Quit the browser after all URLs are processed
                System.out.println("Closed " + browser);
            }
        }

        // Stop recording after all tests
        ScreenRecorderUtil.stopRecord();
    }

    private void initializeDriver(String browser) {
        switch (browser) {
            case "Chrome":
                driver = new ChromeDriver();
                break;
            case "Firefox":
                driver = new FirefoxDriver();
                break;
            case "Edge":
                driver = new EdgeDriver();
                break;
            default:
                System.out.println("Unsupported browser: " + browser);
                break;
        }
    }

    @AfterSuite
    public void tearDownSuite() throws Exception {
        // Cleanup actions if any, after the test suite has completed
        if (driver != null) {
            driver.quit();
        }
    }
}
