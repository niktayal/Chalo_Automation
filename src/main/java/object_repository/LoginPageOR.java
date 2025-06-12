package object_repository;


import lombok.Getter;

@Getter
public enum LoginPageOR {

    INP_USER_NAME_XP("//input[@id='mat-input-0']");
    //INP_PASSWORD_XP("//input[@id='mat-input-1']");
    //CLK_SIGN_IN_XP("//button[@class='cstm-button active']");
    /*inputPassword = //input[@id='mat-input-1']
    btnSingIn = //button[@class='cstm-button active']
    btnSelectCity = //input[@class='inputText margin--b10 ng-untouched ng-pristine ng-invalid']
    btnSelectCity1 = //span[text()= 'Select City']
    btnSelectDepo = //input[@class='inputText margin--b10 ng-untouched ng-pristine ng-invalid']
    btnConfirm = //button[@class='btn form-button']
    dashboardLogo = //div[contains(@class,'dashboard-logo')]
    inputSearch = //input[@id='search']
    btnEditService = //span[text() = 'Edit Service']*/

    private String locator;

    LoginPageOR(String locator){
        this.locator=locator;
    }
}

