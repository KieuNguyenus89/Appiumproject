package tests;

import base.BaseTest;
import base.ExcelReader;
import base.Util;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.LoginPage;
import pages.MenuPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    MenuPage menupage;
    LoginPage loginPage;
    ProductsPage prodPage;

    @Test
    public void ProductsValidateTest() throws Exception {
        menupage = new MenuPage();
        loginPage = new LoginPage();
        prodPage = new ProductsPage();

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(prodPage.getItemsCount(), 6);


        ExcelReader excelreader = new ExcelReader();
        excelreader.setExcelFile("./testData.xlsx", "prodsort");

        Object obj[][] = excelreader.to2DArray();        
        for(int i=0; i< obj.length; i++){
            prodPage.sortBy(obj[i][2].toString()); 

            softAssert.assertEquals(prodPage.getFirstProductPrice(), obj[i][1].toString());
            softAssert.assertEquals(prodPage.getFirstProductName(), obj[i][0].toString());
        }

        softAssert.assertAll();

        
    }
}
