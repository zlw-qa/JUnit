package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.openqa.selenium.support.PageFactory.initElements;

public class DetailsPage {

    @FindBy(css = "#wp-tabs-container div [data-attrid*='poslednyaya_versiya'] .LrzXr.kno-fv")
    private WebElement lastVersion;

    @FindBy(css = "#wp-tabs-container div [data-attrid*='licenziya'] .LrzXr.kno-fv")
    private WebElement license;

    @FindBy(css = "#wp-tabs-container h2[data-attrid*='title']")
    private WebElement title;

    public DetailsPage(WebDriver driver) {
        initElements(driver, this);
    }

    public String getTitle() {
        return title.getText();
    }

    public String getVersion() {
        return lastVersion.getText();
    }

    public String getlicense() {
        return license.getText();
    }


}
