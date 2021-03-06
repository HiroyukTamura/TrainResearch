/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.ContextWrapper
 *  android.content.res.AssetManager
 *  android.content.res.Configuration
 *  android.content.res.Resources
 *  android.content.res.Resources$Theme
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.LayoutInflater
 */
package androidx.appcompat.view;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.view.LayoutInflater;
import androidx.appcompat.a;

public class d
extends ContextWrapper {
    private int a;
    private Resources.Theme b;
    private LayoutInflater c;
    private Configuration d;
    private Resources e;

    public d() {
        super(null);
    }

    public d(Context context, int n2) {
        super(context);
        this.a = n2;
    }

    public d(Context context, Resources.Theme theme) {
        super(context);
        this.b = theme;
    }

    /*
     * Enabled aggressive block sorting
     */
    private Resources b() {
        Resources resources;
        if (this.e != null) return this.e;
        if (this.d == null) {
            resources = super.getResources();
        } else {
            if (Build.VERSION.SDK_INT < 17) return this.e;
            resources = this.createConfigurationContext(this.d).getResources();
        }
        this.e = resources;
        return this.e;
    }

    private void c() {
        boolean bl2 = this.b == null;
        if (bl2) {
            this.b = this.getResources().newTheme();
            Resources.Theme theme = this.getBaseContext().getTheme();
            if (theme != null) {
                this.b.setTo(theme);
            }
        }
        this.a(this.b, this.a, bl2);
    }

    public int a() {
        return this.a;
    }

    protected void a(Resources.Theme theme, int n2, boolean bl2) {
        theme.applyStyle(n2, true);
    }

    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public AssetManager getAssets() {
        return this.getResources().getAssets();
    }

    public Resources getResources() {
        return this.b();
    }

    public Object getSystemService(String string2) {
        if ("layout_inflater".equals(string2)) {
            if (this.c == null) {
                this.c = LayoutInflater.from((Context)this.getBaseContext()).cloneInContext((Context)this);
            }
            return this.c;
        }
        return this.getBaseContext().getSystemService(string2);
    }

    public Resources.Theme getTheme() {
        if (this.b != null) {
            return this.b;
        }
        if (this.a == 0) {
            this.a = a.i.Theme_AppCompat_Light;
        }
        this.c();
        return this.b;
    }

    public void setTheme(int n2) {
        if (this.a != n2) {
            this.a = n2;
            this.c();
        }
    }
}

