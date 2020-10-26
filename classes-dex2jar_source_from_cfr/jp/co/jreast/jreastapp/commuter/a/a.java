/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 */
package jp.co.jreast.jreastapp.commuter.a;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\u000b"}, d2={"Ljp/co/jreast/jreastapp/commuter/application/SharedPreferencesGenerator;", "", "()V", "getCryptoSharedPreferences", "Ljp/co/jreast/jreastapp/commuter/v2legacy/CryptoSharedPreferences;", "context", "Landroid/content/Context;", "name", "", "mode", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    public final jp.co.jreast.jreastapp.commuter.s.a a(Context context, String string2, int n2) {
        j.b((Object)context, "context");
        j.b(string2, "name");
        return new jp.co.jreast.jreastapp.commuter.s.a(context.getSharedPreferences(string2, n2));
    }
}

