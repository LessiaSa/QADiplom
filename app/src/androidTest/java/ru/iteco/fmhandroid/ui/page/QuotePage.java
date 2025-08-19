package ru.iteco.fmhandroid.ui.page;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matchers;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;

public class QuotePage {
    DataHelper dataHelper = new DataHelper();
    public String quote = "Хоспис для меня - это то, каким должен быть мир";
    public String descriptionQuote = "\"Ну, идеальное устройство мира в моих глазах. Где никто не оценивает," +
            " никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку," +
            " а если холодно тебя согреют.” Юля Капис, волонтер";
    public static ViewInteraction buttonQuotes = onView(withId(R.id.our_mission_image_button));
    public static int quoteBlockAllQuotes = R.id.our_mission_item_list_recycler_view; //Блок со всеми цитатами
    public static int quoteBlock = R.id.our_mission_item_material_card_view;
    public static ViewInteraction buttonUnwrapRollUpQuotes = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    public static int descriptionQuoteBlock = R.id.our_mission_item_description_text_view;
    public void checkingIsDisplayedDescriptionQuite() {
        onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0))
                .check(matches(withText(descriptionQuote)));
    }
    public void checkingNotIsDisplayedDescriptionQuote() {
        onView(Matchers.allOf(withId(R.id.our_mission_item_description_text_view), withText(descriptionQuote)))
                .check(matches(not(isDisplayed())));
    }
}
