package uem.dam.mynicestart;

/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * The Two Activities app provides a text entry field and a Send button (the
 * button_main id). Clicking Send launches the Second activity with the entered
 * text shown in the text_header view of the Second activity.
 *
 * The first Espresso test performs a click on the main activity's button, and
 * checks to see if the text_header matches what is displayed. If it passes, it
 * means that the second activity was started. The test then clicks the second
 * activity's button, and checks to see if the text_header_reply matches what is
 * displayed. If it passes, it means that the main activity was started from the
 * second activity.
 *
 * The second test locates the view containing the editText_main view, enters
 * the text "This is a test." and clicks the main button. It then compares the
 * text_message with the assertion "This is a test." If it passes, it means that
 * the entered text was successfully passed to the text_message field.
 */

@RunWith(AndroidJUnit4.class)
public class ActivityInputOutputTest {

    @Rule
    public ActivityTestRule mActivityRule = new ActivityTestRule<>(
            LoginActivity.class);

    /*
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.();

        assertEquals("com.example.android.twoactivities",
                appContext.getPackageName());
    }
     */

    @Test
    public void activityLaunch() {
        //Este código se usa para ejecutar las órdenes al abrir la app
//        onView(withId(R.id.materialButton)).perform(click());
//        onView(withId(R.id.registro)).perform(click());
        onView(withId(R.id.registro)).check(matches(isDisplayed()));
        onView(withId(R.id.password)).check(matches(isDisplayed()));
    }


    @Test
    public void textInputOutput() {

        onView(withId(R.id.etUsername)).perform(
                typeText("This is a test."));

        onView(withId(R.id.etUsername)).check(
                matches(withText("This is a test.")));

        onView(withId(R.id.etPassword)).perform(
                typeText("This is a test."));

        onView(withId(R.id.etPassword)).check(
                matches(withText("This is a test.")));

        onView(withId(R.id.materialButton)).perform(click());

    }

}