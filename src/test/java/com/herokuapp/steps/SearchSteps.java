package com.herokuapp.steps;

import io.cucumber.java8.En;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchSteps implements En {

    public SearchSteps(){

        Given("I open Search page", () -> {
            open("https://www.moemax.de/s/");
            if ($(By.xpath("//button[@data-purpose='cookieBar.button.accept']")).exists()) {
                $(By.xpath("//button[@data-purpose='cookieBar.button.accept']")).click();
            }
        });

        When("I apply value {} to the filter {}", (String value, String filter) -> {
            $(By.xpath("//span[contains(text(),'" + filter + "')]")).click();
            String xpath = "//span[contains(text(),'" + value +  "')]";
            $(By.xpath(xpath)).click();
        });

        Then("I see the value {} is applied", (String value) ->{
            $(By.xpath("//li/div/div/span")).shouldHave(text(value));
        });

        Then("I see the right filter {} results", (String filter) -> {
            if (filter.equals("Marke")){
                $(By.xpath("//*[@id=\"main\"]/section/div/div[3]/div/div[1]/div/div[3]/ul/li[2]/div[2]/div/div/div[2]/ul/li[1]/label/span[2]")).text().equals
                        ($(By.xpath("//*[@id=\"main\"]/section/div/div[4]/div/div")).text());
            }

        });
    }
}
