package com.demoblaze.pages;

import com.demoblaze.utilities.BrowserUtils;
import com.demoblaze.utilities.Driver;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CartPage extends BasePage{

    public WebElement deleteBtn(String productName){
        String deletePath= "(//td[.='" + productName + "'])[1]/following-sibling::td[2]/a";
        return Driver.getDriver().findElement(By.xpath(deletePath));
    }
    public WebElement productPrice (String productName) {
        String pricePath = "(//td[.='" + productName + "'])[1]/following-sibling::td[1]";
        return Driver.getDriver().findElement(By.xpath(pricePath));
    }
    @FindBy(xpath = "//tbody/tr")
    public List<WebElement> productList;

    @FindBy(css = ".btn.btn-success")
    public WebElement orderBtn;
    @FindBy(id = "name")
    public WebElement nameInput;
    @FindBy(id = "country")
    public WebElement countryInput;
    @FindBy(id = "city")
    public WebElement cityInput;
    @FindBy(id = "card")
    public WebElement cartInput;
    @FindBy(id = "month")
    public WebElement monthInput;
    @FindBy(id = "year")
    public WebElement yearInput;
    @FindBy(xpath = "//button[.='Purchase']")
    public WebElement purchaseBtn;

    @FindBy(css = ".lead.text-muted ")
    public WebElement confirmationInfo;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement okBtn;

    public int removeProductFromCart(String productName){
        menu("Cart").click();
        int price = Integer.parseInt(productPrice(productName).getText());
        int firstSize = productList.size();
        deleteBtn(productName).click();
        BrowserUtils.waitFor(2);
        int lastSize = productList.size();
        Assert.assertEquals(firstSize-1,lastSize);
        return price;
    }

    public void fillOutForm (){
        Faker faker = new Faker();
        nameInput.sendKeys(faker.name().fullName());
        countryInput.sendKeys(faker.country().name());
        cityInput.sendKeys(faker.country().capital());
        cartInput.sendKeys(faker.finance().creditCard());
        monthInput.sendKeys(String.valueOf(faker.number().numberBetween(1,12)));
        yearInput.sendKeys(String.valueOf(faker.number().numberBetween(2024,2033)));
    }

    public int productPrice(){
        String amount = confirmationInfo.getText().split("\n")[1];
        int price = Integer.parseInt(amount.split(" ")[1]);
        return price;
    }

    public int placeOrderAndLogAmount (){
        orderBtn.click();
        fillOutForm();
        purchaseBtn.click();
        okBtn.click();
        return productPrice();
    }
}
