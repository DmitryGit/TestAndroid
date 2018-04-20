package com.nca;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.nca.data.sharedprefs.AppSharedPrefs;

import org.junit.Assert;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class Test {

    @org.junit.Test
    public void test() {

        Context appContext = InstrumentationRegistry.getTargetContext();

        AppSharedPrefs appSharedPrefs = new AppSharedPrefs(appContext);
        appSharedPrefs.saveTipsShow();

        boolean actual = appSharedPrefs.getTipsShow();

        assertEquals(true, actual);
    }

}
