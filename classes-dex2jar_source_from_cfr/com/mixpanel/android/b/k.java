/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.res.Resources
 *  android.os.Bundle
 */
package com.mixpanel.android.b;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Bundle;
import com.mixpanel.android.b.x;
import com.mixpanel.android.c.f;
import com.mixpanel.android.c.h;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;

public class k {
    private static k D;
    private static final Object E;
    public static boolean a = false;
    private final String A;
    private SSLSocketFactory B;
    private h C;
    private final int b;
    private final int c;
    private final long d;
    private final int e;
    private final boolean f;
    private final boolean g;
    private final boolean h;
    private final boolean i;
    private final boolean j;
    private final String[] k;
    private String l;
    private String m;
    private String n;
    private final boolean o;
    private final String p;
    private final String q;
    private final boolean r;
    private final int s;
    private final boolean t;
    private final int u;
    private final int v;
    private final int w;
    private final boolean x;
    private final int y;
    private final String z;

    static {
        E = new Object();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    k(Bundle arrstring, Context context) {
        long l2;
        Object object;
        Object object2 = null;
        try {
            object = SSLContext.getInstance("TLS");
            ((SSLContext)object).init(null, null, null);
            object2 = object = ((SSLContext)object).getSocketFactory();
        }
        catch (GeneralSecurityException generalSecurityException) {
            f.c("MixpanelAPI.Conf", "System has no SSL support. Built-in events editor will not be available", generalSecurityException);
        }
        this.B = object2;
        a = arrstring.getBoolean("com.mixpanel.android.MPConfig.EnableDebugLogging", false);
        if (a) {
            f.a(2);
        }
        if (arrstring.containsKey("com.mixpanel.android.MPConfig.DebugFlushInterval")) {
            f.d("MixpanelAPI.Conf", "We do not support com.mixpanel.android.MPConfig.DebugFlushInterval anymore. There will only be one flush interval. Please, update your AndroidManifest.xml.");
        }
        this.b = arrstring.getInt("com.mixpanel.android.MPConfig.BulkUploadLimit", 40);
        this.c = arrstring.getInt("com.mixpanel.android.MPConfig.FlushInterval", 60000);
        this.e = arrstring.getInt("com.mixpanel.android.MPConfig.MinimumDatabaseLimit", 20971520);
        this.q = arrstring.getString("com.mixpanel.android.MPConfig.ResourcePackageName");
        this.g = arrstring.getBoolean("com.mixpanel.android.MPConfig.DisableGestureBindingUI", false);
        this.h = arrstring.getBoolean("com.mixpanel.android.MPConfig.DisableEmulatorBindingUI", false);
        this.i = arrstring.getBoolean("com.mixpanel.android.MPConfig.DisableAppOpenEvent", true);
        this.j = arrstring.getBoolean("com.mixpanel.android.MPConfig.DisableViewCrawler", false);
        this.r = arrstring.getBoolean("com.mixpanel.android.MPConfig.DisableDecideChecker", false);
        this.s = arrstring.getInt("com.mixpanel.android.MPConfig.ImageCacheMaxMemoryFactor", 10);
        this.t = arrstring.getBoolean("com.mixpanel.android.MPConfig.IgnoreInvisibleViewsVisualEditor", false);
        this.o = arrstring.getBoolean("com.mixpanel.android.MPConfig.AutoShowMixpanelUpdates", true);
        this.u = arrstring.getInt("com.mixpanel.android.MPConfig.NotificationDefaults", 0);
        this.v = arrstring.getInt("com.mixpanel.android.MPConfig.MinimumSessionDuration", 10000);
        this.w = arrstring.getInt("com.mixpanel.android.MPConfig.SessionTimeoutDuration", Integer.MAX_VALUE);
        this.x = arrstring.getBoolean("com.mixpanel.android.MPConfig.UseIpAddressForGeolocation", true);
        this.f = arrstring.getBoolean("com.mixpanel.android.MPConfig.TestMode", false);
        this.y = arrstring.getInt("com.mixpanel.android.MPConfig.NotificationChannelImportance", 3);
        object2 = arrstring.get("com.mixpanel.android.MPConfig.DataExpiration");
        long l3 = l2 = 432000000L;
        if (object2 != null) {
            try {
                if (object2 instanceof Integer) {
                    l3 = ((Integer)object2).intValue();
                } else {
                    if (!(object2 instanceof Float)) {
                        object = new StringBuilder();
                        ((StringBuilder)object).append(object2.toString());
                        ((StringBuilder)object).append(" is not a number.");
                        throw new NumberFormatException(((StringBuilder)object).toString());
                    }
                    l3 = (long)((Float)object2).floatValue();
                }
            }
            catch (Exception exception) {
                f.e("MixpanelAPI.Conf", "Error parsing com.mixpanel.android.MPConfig.DataExpiration meta-data value", exception);
                l3 = l2;
            }
        }
        this.d = l3;
        object2 = object = arrstring.getString("com.mixpanel.android.MPConfig.NotificationChannelId");
        if (object == null) {
            object2 = "mp";
        }
        this.z = object2;
        object2 = object = arrstring.getString("com.mixpanel.android.MPConfig.NotificationChannelName");
        if (object == null) {
            object2 = x.a(context).c();
        }
        this.A = object2;
        object2 = arrstring.getString("com.mixpanel.android.MPConfig.EventsEndpoint");
        if (object2 != null) {
            this.a((String)object2);
        } else {
            this.l();
        }
        object2 = arrstring.getString("com.mixpanel.android.MPConfig.PeopleEndpoint");
        if (object2 != null) {
            this.b((String)object2);
        } else {
            this.n();
        }
        object2 = arrstring.getString("com.mixpanel.android.MPConfig.DecideEndpoint");
        if (object2 != null) {
            this.c((String)object2);
        } else {
            this.p();
        }
        object2 = object = arrstring.getString("com.mixpanel.android.MPConfig.EditorUrl");
        if (object == null) {
            object2 = "wss://switchboard.mixpanel.com/connect/";
        }
        this.p = object2;
        int n2 = arrstring.getInt("com.mixpanel.android.MPConfig.DisableViewCrawlerForProjects", -1);
        arrstring = n2 != -1 ? context.getResources().getStringArray(n2) : new String[0];
        this.k = arrstring;
        f.a("MixpanelAPI.Conf", this.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static k a(Context context) {
        Object object = E;
        synchronized (object) {
            if (D == null) {
                D = k.b(context.getApplicationContext());
            }
            return D;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    static k b(Context object) {
        StringBuilder stringBuilder;
        String string2 = object.getPackageName();
        try {
            Bundle bundle = object.getPackageManager().getApplicationInfo((String)string2, (int)128).metaData;
            stringBuilder = bundle;
            if (bundle != null) return new k((Bundle)stringBuilder, (Context)object);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Can't configure Mixpanel with package name ");
            stringBuilder.append(string2);
            throw new RuntimeException(stringBuilder.toString(), (Throwable)nameNotFoundException);
        }
        stringBuilder = new Bundle();
        return new k((Bundle)stringBuilder, (Context)object);
    }

    public boolean A() {
        return this.x;
    }

    public String B() {
        return this.q;
    }

    public SSLSocketFactory C() {
        synchronized (this) {
            SSLSocketFactory sSLSocketFactory = this.B;
            return sSLSocketFactory;
        }
    }

    public h D() {
        synchronized (this) {
            h h2 = this.C;
            return h2;
        }
    }

    public int E() {
        return this.s;
    }

    public int a() {
        return this.b;
    }

    public void a(String string2) {
        this.l = string2;
    }

    public int b() {
        return this.c;
    }

    public void b(String string2) {
        this.m = string2;
    }

    public long c() {
        return this.d;
    }

    public void c(String string2) {
        this.n = string2;
    }

    public int d() {
        return this.e;
    }

    public boolean e() {
        return this.g;
    }

    public boolean f() {
        return this.h;
    }

    public boolean g() {
        return this.i;
    }

    public boolean h() {
        return this.j;
    }

    public String[] i() {
        return this.k;
    }

    public boolean j() {
        return this.f;
    }

    public String k() {
        return this.l;
    }

    public void l() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("https://api.mixpanel.com/track?ip=");
        String string2 = this.A() ? "1" : "0";
        stringBuilder.append(string2);
        this.a(stringBuilder.toString());
    }

    public String m() {
        return this.m;
    }

    public void n() {
        this.b("https://api.mixpanel.com/engage");
    }

    public String o() {
        return this.n;
    }

    public void p() {
        this.c("https://decide.mixpanel.com/decide");
    }

    public boolean q() {
        return this.o;
    }

    public String r() {
        return this.p;
    }

    public boolean s() {
        return this.r;
    }

    public boolean t() {
        return this.t;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mixpanel (5.4.0) configured with:\n    AutoShowMixpanelUpdates ");
        stringBuilder.append(this.q());
        stringBuilder.append("\n    BulkUploadLimit ");
        stringBuilder.append(this.a());
        stringBuilder.append("\n    FlushInterval ");
        stringBuilder.append(this.b());
        stringBuilder.append("\n    DataExpiration ");
        stringBuilder.append(this.c());
        stringBuilder.append("\n    MinimumDatabaseLimit ");
        stringBuilder.append(this.d());
        stringBuilder.append("\n    DisableAppOpenEvent ");
        stringBuilder.append(this.g());
        stringBuilder.append("\n    DisableViewCrawler ");
        stringBuilder.append(this.h());
        stringBuilder.append("\n    DisableGestureBindingUI ");
        stringBuilder.append(this.e());
        stringBuilder.append("\n    DisableEmulatorBindingUI ");
        stringBuilder.append(this.f());
        stringBuilder.append("\n    EnableDebugLogging ");
        stringBuilder.append(a);
        stringBuilder.append("\n    TestMode ");
        stringBuilder.append(this.j());
        stringBuilder.append("\n    EventsEndpoint ");
        stringBuilder.append(this.k());
        stringBuilder.append("\n    PeopleEndpoint ");
        stringBuilder.append(this.m());
        stringBuilder.append("\n    DecideEndpoint ");
        stringBuilder.append(this.o());
        stringBuilder.append("\n    EditorUrl ");
        stringBuilder.append(this.r());
        stringBuilder.append("\n    ImageCacheMaxMemoryFactor ");
        stringBuilder.append(this.E());
        stringBuilder.append("\n    DisableDecideChecker ");
        stringBuilder.append(this.s());
        stringBuilder.append("\n    IgnoreInvisibleViewsEditor ");
        stringBuilder.append(this.t());
        stringBuilder.append("\n    NotificationDefaults ");
        stringBuilder.append(this.u());
        stringBuilder.append("\n    MinimumSessionDuration: ");
        stringBuilder.append(this.v());
        stringBuilder.append("\n    SessionTimeoutDuration: ");
        stringBuilder.append(this.w());
        stringBuilder.append("\n    NotificationChannelId: ");
        stringBuilder.append(this.x());
        stringBuilder.append("\n    NotificationChannelName: ");
        stringBuilder.append(this.y());
        stringBuilder.append("\n    NotificationChannelImportance: ");
        stringBuilder.append(this.z());
        return stringBuilder.toString();
    }

    public int u() {
        return this.u;
    }

    public int v() {
        return this.v;
    }

    public int w() {
        return this.w;
    }

    public String x() {
        return this.z;
    }

    public String y() {
        return this.A;
    }

    public int z() {
        return this.y;
    }
}

