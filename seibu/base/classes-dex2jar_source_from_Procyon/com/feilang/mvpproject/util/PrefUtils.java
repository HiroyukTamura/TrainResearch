// 
// Decompiled by Procyon v0.5.36
// 

package com.feilang.mvpproject.util;

import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.Context;

public final class PrefUtils
{
    private PrefUtils() {
    }
    
    public static boolean contains(final Context context, final String str) {
        try {
            LogUtils.outputLog("PrefUtils : contains : key = " + str);
            outputAllData(context);
            return pref(context).contains(str);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : contains : Exception.", ex);
            return false;
        }
    }
    
    public static boolean getBoolean(final Context context, final String str, final boolean b) {
        try {
            LogUtils.outputLog("PrefUtils : getBoolean : key = " + str);
            outputAllData(context);
            return pref(context).getBoolean(str, b);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : getBoolean : Exception.", ex);
            return b;
        }
    }
    
    public static float getFloat(final Context context, final String str, final float n) {
        try {
            LogUtils.outputLog("PrefUtils : getFloat : key = " + str);
            outputAllData(context);
            return pref(context).getFloat(str, n);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : getFloat : Exception.", ex);
            return n;
        }
    }
    
    public static int getInt(final Context context, final String str, final int n) {
        try {
            LogUtils.outputLog("PrefUtils : getInt : key = " + str);
            outputAllData(context);
            return pref(context).getInt(str, n);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : getInt : Exception.", ex);
            return n;
        }
    }
    
    public static long getLong(final Context context, final String str, final long n) {
        try {
            LogUtils.outputLog("PrefUtils : getLong : key = " + str);
            outputAllData(context);
            return pref(context).getLong(str, n);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : getLong : Exception.", ex);
            return n;
        }
    }
    
    public static String getString(final Context context, final String str, final String s) {
        try {
            LogUtils.v("PrefUtils : getString : key = " + str);
            outputAllData(context);
            return pref(context).getString(str, s);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : getString : Exception.", ex);
            return s;
        }
    }
    
    private static void outputAllData(final Context context) {
    }
    
    private static SharedPreferences pref(final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }
    
    public static void remove(final Context context, final String str) {
        try {
            LogUtils.outputLog("PrefUtils : remove : key = " + str);
            pref(context).edit().remove(str).commit();
            outputAllData(context);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : remove : Exception.", ex);
        }
    }
    
    public static void writeBoolean(final Context context, final String str, final boolean b) {
        LogUtils.outputLog("PrefUtils : writeBoolean : key = " + str + ", value = " + b);
        if (str == null) {
            return;
        }
        try {
            pref(context).edit().putBoolean(str, b).commit();
            outputAllData(context);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : writeBoolean : Exception.", ex);
        }
    }
    
    public static void writeFloat(final Context context, final String str, final float f) {
        LogUtils.outputLog("PrefUtils : writeFloat : key = " + str + ", value = " + f);
        if (str == null) {
            return;
        }
        try {
            pref(context).edit().putFloat(str, f).commit();
            outputAllData(context);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : writeFloat : Exception.", ex);
        }
    }
    
    public static void writeInt(final Context context, final String str, final int i) {
        LogUtils.outputLog("PrefUtils : writeInt : key = " + str + ", value = " + i);
        if (str == null) {
            return;
        }
        try {
            pref(context).edit().putInt(str, i).commit();
            outputAllData(context);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : writeInt : Exception.", ex);
        }
    }
    
    public static void writeLong(final Context context, final String str, final long lng) {
        LogUtils.outputLog("PrefUtils : writeLong : key = " + str + ", value = " + lng);
        if (str == null) {
            return;
        }
        try {
            pref(context).edit().putLong(str, lng).commit();
            outputAllData(context);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : writeLong : Exception.", ex);
        }
    }
    
    public static void writeString(final Context context, final String str, final String str2) {
        LogUtils.outputLog("PrefUtils : writeString : key = " + str + ", value = " + str2);
        if (str == null) {
            return;
        }
        try {
            pref(context).edit().putString(str, str2).commit();
            outputAllData(context);
        }
        catch (Exception ex) {
            LogUtils.e("PrefUtils : writeString : Exception.", ex);
        }
    }
}
