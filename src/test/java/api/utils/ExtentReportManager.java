package api.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReportManager implements ITestListener {
    public ExtentReports extentReports;
    public ExtentTest extentTest;
    public ExtentSparkReporter sparkReporter;
    String reportName;
    @Override
    public void onStart(ITestContext context) {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        reportName = "API Automation Report " + timeStamp + ".html";
        sparkReporter = new ExtentSparkReporter("reports/"+reportName);
        sparkReporter.config().setDocumentTitle("Rest Assured Automation");
        sparkReporter.config().setReportName("Pet Store API Automation Status");
        sparkReporter.config().setTheme(Theme.DARK);

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkReporter);
        extentReports.setSystemInfo("Environment","Staging");
        extentReports.setSystemInfo("User","Debasis");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.createNode(result.getName());
        extentTest.log(Status.PASS,"Test is Passed");
    }
    @Override
    public void onTestFailure(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.createNode(result.getName());
        extentTest.log(Status.FAIL,"Test is Failed");
        extentTest.log(Status.FAIL,result.getThrowable().getMessage());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extentTest = extentReports.createTest(result.getName());
        extentTest.assignCategory(result.getMethod().getGroups());
        extentTest.createNode(result.getName());
        extentTest.log(Status.SKIP,"Test is Skipped");
        extentTest.log(Status.SKIP,result.getThrowable().getMessage());
    }
    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }


}
