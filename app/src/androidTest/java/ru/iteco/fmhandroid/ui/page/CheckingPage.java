package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.doesNotExist;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;

public class CheckingPage {
    CreateNewsPage createNewsPage = new CreateNewsPage();
    public String title = "Снова рады сообщить";
    public String titleHello = "Здравствуйте!";
    public String titleAMustRead = "Обязательно к прочтению";
    public String description = "Читайте, читайте и не говорите, что не читали!";
    public String descriptionTellEveryone = "Расскажите всем!";
    public String bigDescription = "Читайте, читайте и не говорите, что не читали!kvktlvjd85hgb&$" +
            ")Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcde" +
            "                kvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85" +
            "                vktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)" +
            "Hcdekvktvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd8";
    public String bigTitle = "Обязательно к прочтению85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvkt" +
            "lvjd85hgb&$)Hcdekvktlvjd85hgb&\" +\n" +
            "                    \"$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hg\" +\n" +
            "                    \"b&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd85hgb&$)Hcdekvktlvjd";


    public void checkTextBirthday() {
        ViewInteraction titleText = createNewsPage.headerFieldNews;
        titleText.check(matches(isDisplayed()));
        titleText.check(matches(withText("День рождения")));
    }

    public void checkDoesNotExist() {
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))).check(doesNotExist());
    }

    public void checkHelloDoesNotExist() {
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(titleHello))).check(doesNotExist());
    }

    public void checkingDescriptionTellEveryone() {
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText(descriptionTellEveryone)));
    }

    public void checkingDescriptionReadIt() {
        onView(withIndex(withId(R.id.news_item_description_text_view), 0))
                .check(matches(withText(description)));
    }

    public void checkingIsDisplayedHello() {
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(titleHello))).check(matches(isDisplayed()));
    }

    public void checkingIsDisplayed() {
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(title))).check(matches(isDisplayed()));
    }

    public void checkingIsDisplayedAMustRead() {
        onView(Matchers.allOf(withId(R.id.news_item_title_text_view), withText(titleAMustRead))).check(matches(isDisplayed()));
    }
}
