// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import android.annotation.SuppressLint;
import android.content.SharedPreferences$Editor;
import android.content.Context;

final class zzfu
{
    @SuppressLint({ "CommitPrefEdits" })
    static void zzd(final Context context, final String s, final String s2, final String s3) {
        final SharedPreferences$Editor edit = context.getSharedPreferences(s, 0).edit();
        edit.putString(s2, s3);
        edit.apply();
    }
}
