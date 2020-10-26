/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.View
 */
package androidx.databinding;

import android.util.Log;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.databinding.c;
import androidx.databinding.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class h
extends c {
    private Set<Class<? extends c>> a = new HashSet<Class<? extends c>>();
    private List<c> b = new CopyOnWriteArrayList<c>();
    private List<String> c = new CopyOnWriteArrayList<String>();

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private boolean b() {
        Iterator<String> iterator = this.c.iterator();
        boolean bl2 = false;
        while (iterator.hasNext()) {
            StringBuilder stringBuilder;
            Class<?> class_;
            String string2 = iterator.next();
            try {
                class_ = Class.forName(string2);
                if (!c.class.isAssignableFrom(class_)) continue;
                this.a((c)class_.newInstance());
                this.c.remove(string2);
                bl2 = true;
                continue;
            }
            catch (InstantiationException instantiationException) {
                stringBuilder = new StringBuilder();
            }
            catch (IllegalAccessException illegalAccessException) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append("unable to add feature mapper for ");
            stringBuilder.append(string2);
            Log.e((String)"MergedDataBinderMapper", (String)stringBuilder.toString(), class_);
            continue;
            catch (ClassNotFoundException classNotFoundException) {
            }
        }
        return bl2;
    }

    @Override
    public ViewDataBinding a(e e2, View view, int n2) {
        Iterator<c> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ViewDataBinding viewDataBinding = iterator.next().a(e2, view, n2);
            if (viewDataBinding == null) continue;
            return viewDataBinding;
        }
        if (this.b()) {
            return this.a(e2, view, n2);
        }
        return null;
    }

    @Override
    public ViewDataBinding a(e e2, View[] arrview, int n2) {
        Iterator<c> iterator = this.b.iterator();
        while (iterator.hasNext()) {
            ViewDataBinding viewDataBinding = iterator.next().a(e2, arrview, n2);
            if (viewDataBinding == null) continue;
            return viewDataBinding;
        }
        if (this.b()) {
            return this.a(e2, arrview, n2);
        }
        return null;
    }

    public void a(c object) {
        Class<?> class_ = object.getClass();
        if (this.a.add(class_)) {
            this.b.add((c)object);
            object = ((c)object).a().iterator();
            while (object.hasNext()) {
                this.a((c)object.next());
            }
        }
    }
}

