/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package jp.co.jreast.jreastapp.commuter.m;

import android.graphics.drawable.Drawable;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0007\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u0005J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0001R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/repository/LocalCacheRepository;", "", "()V", "cacheMap", "", "", "getAndRemoveDrawable", "Landroid/graphics/drawable/Drawable;", "key", "put", "", "value", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class e {
    private final Map<String, Object> a = new LinkedHashMap();

    public final Drawable a(String string2) {
        j.b(string2, "key");
        Object object = this.a.get(string2);
        if (object != null) {
            if (object != null) {
                object = (Drawable)object;
                this.a.remove(string2);
                return object;
            }
            throw new t("null cannot be cast to non-null type android.graphics.drawable.Drawable");
        }
        return null;
    }

    public final void a(String string2, Object object) {
        j.b(string2, "key");
        j.b(object, "value");
        this.a.put(string2, object);
    }
}

