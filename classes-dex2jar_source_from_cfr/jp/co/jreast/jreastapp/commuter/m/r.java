/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.content.Context;
import jp.co.jreast.jreastapp.commuter.a.a;
import kotlin.Metadata;
import kotlin.e.b.g;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0011"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/UserInformationRepository;", "", "context", "Landroid/content/Context;", "sharedPreferencesGenerator", "Ljp/co/jreast/jreastapp/commuter/application/SharedPreferencesGenerator;", "(Landroid/content/Context;Ljp/co/jreast/jreastapp/commuter/application/SharedPreferencesGenerator;)V", "cryptoSharedPreferences", "Ljp/co/jreast/jreastapp/commuter/v2legacy/CryptoSharedPreferences;", "getUserId", "", "isRegistered", "", "save", "", "user", "Ljp/co/jreast/jreastapp/commuter/model/RegisteredUserId;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class r {
    private final jp.co.jreast.jreastapp.commuter.s.a a;

    public r(Context context, a a2) {
        j.b((Object)context, "context");
        j.b(a2, "sharedPreferencesGenerator");
        this.a = a2.a(context, "TrainNetSharedPrefs", 0);
    }

    public /* synthetic */ r(Context context, a a2, int n2, g g2) {
        if ((n2 & 2) != 0) {
            a2 = new a();
        }
        this(context, a2);
    }

    public final String a() {
        String string2 = this.a.getString("uid", "");
        j.a((Object)string2, "cryptoSharedPreferences.\u2026ng(ConstValue.UIDPRF, \"\")");
        return string2;
    }
}

