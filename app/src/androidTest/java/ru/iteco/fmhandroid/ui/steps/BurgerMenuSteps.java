package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.matcher.RootMatchers;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Allure;

public class BurgerMenuSteps {

    public void selectingHomePageInBurgerMenu() {
        Allure.step("Выбор страницы 'Главная' на BurgerMenu");
        Espresso.onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup()).atPosition(0).perform(click());
    }

    public void selectingNewsPageInBurgerMenu() {
        Allure.step("Выбор страницы 'Новости' на BurgerMenu");
        Espresso.onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup()).atPosition(1).perform(click());
    }

    public void selectingAboutAppPageInBurgerMenu() {
        Allure.step("Выбор страницы 'О приложении' на BurgerMenu");
        Espresso.onData(Matchers.anything())
                .inRoot(RootMatchers.isPlatformPopup()).atPosition(2).perform(click());
    }
}
