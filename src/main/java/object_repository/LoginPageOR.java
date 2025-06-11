package object_repository;


import lombok.Getter;

@Getter
public enum LoginPageOR {

    INP_USER_NAME_XP("//input[@id='mat-input-0']");

    private String locator;

    LoginPageOR(String locator){
        this.locator=locator;
    }
}
