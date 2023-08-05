package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashBoardPage extends CommonMethods {
    @FindBy(id="menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id="menu_pim_viewEmployeeList")
    public WebElement empListOption;

    @FindBy(id="menu_pim_addEmployee")
    public WebElement addEmployeeButton;

    @FindBy (id="menu_admin_viewAdminModule")
    public WebElement adminButton;

    @FindBy (id="menu_admin_Job")
    public WebElement adminJobButton;

    @FindBy(id="menu_admin_viewJobTitleList")
    public WebElement adminJobJobTitleButton;



    public DashBoardPage(){
        PageFactory.initElements(driver,this);
    }
}
