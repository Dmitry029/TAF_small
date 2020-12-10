package com.herokuapp.theinternet.tests.pageElementTests;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FileUploaderPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FileUploadTest extends TestUtilities {

    @Test(dataProvider = "filesFromDataProvider")
    public void fileUploadTest(int number, String fileName) {
        log.info("*** Starting fileUploadTest #" + number);

        // open File Uploader Page
        FileUploaderPage fileUploaderPage = new FileUploaderPage(driver, log);
        fileUploaderPage.openPage();

        // Select file
        fileUploaderPage.selectFile(fileName);

        // Push upload button
        fileUploaderPage.pushUploadButton();

        // Get uploaded files
        String fileNames = fileUploaderPage.getUploadedFilesNames();

        // Verify selected file uploaded
        Assert.assertTrue(fileNames.contains(fileName),
                "Our file (" + fileName + ") is not one of the uploaded (" + fileNames + ")");
        sleep(2000);
    }

    @DataProvider(name = "filesFromDataProvider")
    private Object[][] files(){
        return new Object[][]{
                {1, "index.html"},
                {2, "logo.png"},
                {3, "text.txt"}
        };
    }
}

