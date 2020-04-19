package com.droider.crackme0201hooker;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Hooks implements IXposedHookLoadPackage {
    final String packageName = "com.droider.crackme0201";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if (!loadPackageParam.packageName.equals(packageName)) {
            return;
        }
        new CheckSNHook(loadPackageParam.classLoader);
    }
}
