package com.nt;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import com.microsoft.appcenter.espresso.Factory;
import com.microsoft.appcenter.espresso.ReportHelper;

import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

    @Rule
    public ReportHelper reportHelper = Factory.getReportHelper();

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void checkAllComponentsExist() {

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onView(
                withContentDescription("testview")
        ).check(matches(isDisplayed()));

        ViewInteraction textField = onView(
                withContentDescription("text")
        );

        ViewInteraction button = onView(
                withContentDescription("button")
        );

        ViewInteraction nameField = onView(
                withContentDescription("name")
        );

        textField.check(matches(isDisplayed()));
        textField.check(matches(withText("1")));

        button.check(matches(isDisplayed()));

        button.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nameField.check(matches(isDisplayed()));

        nameField.check(matches(withText("Leanne Graham")));

        textField.perform(replaceText("2"));

        button.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        nameField.check(matches(withText("Ervin Howell")));
    }

    @After
    public void TearDown(){
        reportHelper.label("Stopping App");
    }
}
