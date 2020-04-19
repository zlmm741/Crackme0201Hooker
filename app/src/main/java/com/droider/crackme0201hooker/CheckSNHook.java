package com.droider.crackme0201hooker;

import android.util.Log;

import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;

public class CheckSNHook {
    static final String TAG = "Crackme0201Hooker";
    public CheckSNHook(ClassLoader classLoader) {
        super();

        XposedBridge.log("hooking checkSN.");
        try {
            Class clz = (Class<?>) XposedHelpers.findClass(
                    "com.droider.crackme0201.MainActivity", classLoader);
            XposedHelpers.findAndHookMethod(clz,
                    "checkSN",
                    String.class,
                    String.class,
                    new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                    XposedBridge.log("CheckSN afterHookedMethod called.");
                    String s1 = (String)param.args[0];
                    String s2 = (String)param.args[1];

                    Log.d(TAG, "s1: " + s1);
                    Log.d(TAG, "s2: " + s2);
                    param.setResult(true);
                    super.afterHookedMethod(param);
                }
            });
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        XposedBridge.log("hook checkSN done.");
    }
}
