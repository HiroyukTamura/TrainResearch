/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.main;

import android.content.Context;
import androidx.f.a.d;
import androidx.f.a.i;
import androidx.f.a.o;
import jp.co.jreast.jreastapp.commuter.main.u;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0012\u001a\u00020\u000fH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b0\nX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\r\u00a8\u0006\u0015"}, d2={"Ljp/co/jreast/jreastapp/commuter/main/MainPagerAdapter;", "Landroidx/fragment/app/FragmentStatePagerAdapter;", "fm", "Landroidx/fragment/app/FragmentManager;", "context", "Landroid/content/Context;", "(Landroidx/fragment/app/FragmentManager;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "tabs", "", "", "kotlin.jvm.PlatformType", "[Ljava/lang/String;", "getCount", "", "getItem", "Landroidx/fragment/app/Fragment;", "position", "getPageTitle", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class r
extends o {
    private final String[] a;
    private final Context b;

    public r(i i2, Context context) {
        j.b(i2, "fm");
        j.b((Object)context, "context");
        super(i2);
        this.b = context;
        this.a = new String[]{this.b.getString(2131558450), this.b.getString(2131558451), this.b.getString(2131558452)};
    }

    @Override
    public d a(int n2) {
        return u.a.a(n2);
    }

    @Override
    public int b() {
        return this.a.length;
    }

    @Override
    public CharSequence c(int n2) {
        return this.a[n2];
    }
}

