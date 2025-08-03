package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;

import io.qameta.allure.kotlin.Allure;
import ru.iteco.fmhandroid.ui.data.FieldIDs;

public class PageQuotesSteps {
    public void buttonUnwrapRollUpQuotesOnPageQuotes() {
        Allure.step("Кнопка для разворачивания и сворачивания пояснения к цитате");
        FieldIDs.buttonUnwrapRollUpQuotes.perform(click());
    }
}
