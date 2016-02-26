package test.testespresso;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import test.testespresso.ui.activities.Main;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainTest
{
    public static final String STRING_TO_BE_TYPED = "Espresso test &&&& ........................ android ui test БЕЗНОГNМ";

    @Rule
    public ActivityTestRule<Main> mActivityRule = new ActivityTestRule<>(Main.class);

    @Test
    public void changeText_sameActivity()
    {
        Espresso.onView(ViewMatchers.withId(R.id.main_test_edit))
                .perform(ViewActions.typeText(STRING_TO_BE_TYPED), ViewActions.closeSoftKeyboard());
        Espresso.onView(ViewMatchers.withId(R.id.main_test_button))
                .perform(ViewActions.click());
        Espresso.onView(ViewMatchers.withId(R.id.main_test_text))
                .check(ViewAssertions.matches(ViewMatchers.withText(STRING_TO_BE_TYPED)));
    }

//    @Test
//    public void changeText_newActivity()
//    {
//        // Type text and then press the button.
//        onView(withId(R.id.editTextUserInput)).perform(typeText(STRING_TO_BE_TYPED), closeSoftKeyboard());
//        onView(withId(R.id.activityChangeTextBtn)).perform(click());
//
//        // This view is in a different Activity, no need to tell Espresso.
//        onView(withId(R.id.show_text_view)).check(matches(withText(STRING_TO_BE_TYPED)));
//    }
}