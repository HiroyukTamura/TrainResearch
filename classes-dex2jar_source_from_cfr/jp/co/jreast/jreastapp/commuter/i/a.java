/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package jp.co.jreast.jreastapp.commuter.i;

import android.content.Context;
import androidx.core.app.g;
import kotlin.Metadata;
import kotlin.e.b.j;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/generator/TaskStackBuilderGenerator;", "", "()V", "latestStackBuilder", "Landroidx/core/app/TaskStackBuilder;", "getLatestStackBuilder", "()Landroidx/core/app/TaskStackBuilder;", "setLatestStackBuilder", "(Landroidx/core/app/TaskStackBuilder;)V", "create", "context", "Landroid/content/Context;", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class a {
    public g a;

    public final g a(Context object) {
        j.b(object, "context");
        object = g.a(object);
        j.a(object, "TaskStackBuilder.create(context)");
        this.a = object;
        object = this.a;
        if (object == null) {
            j.b("latestStackBuilder");
        }
        return object;
    }
}

