/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.AssetManager
 *  android.content.res.Resources
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.d.a;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/FileRepository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "resources", "Landroid/content/res/Resources;", "kotlin.jvm.PlatformType", "readFile", "", "filename", "", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class d {
    private final Resources a;

    public d(Context context) {
        j.b((Object)context, "context");
        this.a = context.getResources();
    }

    public final byte[] a(String object) {
        j.b(object, "filename");
        Resources resources = this.a;
        j.a((Object)resources, "resources");
        object = resources.getAssets().open((String)object);
        j.a(object, "resources.assets\n                .open(filename)");
        return a.a((InputStream)object, 0, 1, null);
    }
}

