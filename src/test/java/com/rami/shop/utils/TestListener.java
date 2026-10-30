package com.rami.shop.utils;

import com.rami.shop.base.BasePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            File shot = ((TakesScreenshot) BasePage.getDriver()).getScreenshotAs(OutputType.FILE);
            String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            Path target = Paths.get("target", "screenshots", result.getName() + "_" + time + ".png");
            Files.createDirectories(target.getParent());
            Files.copy(shot.toPath(), target);
            System.out.println("Screenshot saved: " + target);
        } catch (Exception e) {
            System.out.println("Could not take a screenshot: " + e.getMessage());
        }
    }
}