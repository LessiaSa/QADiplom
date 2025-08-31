package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitDisplayed;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.R;

public class MainPage {
    AuthorizationPage authorizationPage = new AuthorizationPage();
    public String allNews = "ВСЕ НОВОСТИ";

    public void loadingTheMainPage() {
        Allure.step("Загрузка главной страницы приложения");
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
    }

    public void buttonLogOutProfile() {
        Allure.step("Кнопка с абстрактным изображением человека для выхода из профиля");
        onView(isRoot()).perform(waitDisplayed(R.id.authorization_image_button, 5000));
        authorizationPage.buttonLogOut.perform(click());
    }
}
