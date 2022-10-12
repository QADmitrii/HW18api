package test;

import base.TestBase;
import data.UserData;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import page.DemoWebShopPage;

public class DemoWebShopTests extends TestBase {
    static UserData userData = new UserData();
    static UserData userDataChange = new UserData();
    static DemoWebShopPage demowebshopPage = new DemoWebShopPage();

    @Test
    @DisplayName("Регистрация нового пользователя")
    public void registrationTest() {
        demowebshopPage.registration(userData);
    }

    @Test
    @DisplayName("Авторизация пользователя")
    public void login() {
        demowebshopPage.login(userData);
        demowebshopPage.openUserAccount(userData);
    }

    @Test
    @DisplayName("Редактирование профиля UI")
    public void changeProfile() {
        demowebshopPage.registration(userData);
        demowebshopPage.login(userData);
        demowebshopPage.openUserAccount(userData);
        demowebshopPage.changeProfile(userDataChange);
    }
}
