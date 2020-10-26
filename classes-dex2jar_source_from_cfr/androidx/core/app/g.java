/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Bundle
 *  android.util.Log
 */
package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import androidx.core.app.e;
import java.util.ArrayList;
import java.util.Iterator;

public final class g
implements Iterable<Intent> {
    private final ArrayList<Intent> a = new ArrayList();
    private final Context b;

    private g(Context context) {
        this.b = context;
    }

    public static g a(Context context) {
        return new g(context);
    }

    public g a(Activity activity) {
        Intent intent = activity instanceof a ? ((a)activity).d() : null;
        Intent intent2 = intent;
        if (intent == null) {
            intent2 = e.a(activity);
        }
        if (intent2 != null) {
            intent = intent2.getComponent();
            activity = intent;
            if (intent == null) {
                activity = intent2.resolveActivity(this.b.getPackageManager());
            }
            this.a((ComponentName)activity);
            this.a(intent2);
        }
        return this;
    }

    public g a(ComponentName componentName) {
        ComponentName componentName2;
        int n2 = this.a.size();
        try {
            Context context = this.b;
            componentName2 = componentName;
            componentName = context;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Log.e((String)"TaskStackBuilder", (String)"Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException((Throwable)nameNotFoundException);
        }
        do {
            componentName2 = e.a((Context)componentName, componentName2);
            if (componentName2 == null) break;
            this.a.add(n2, (Intent)componentName2);
            componentName = this.b;
            componentName2 = componentName2.getComponent();
            continue;
            break;
        } while (true);
        return this;
    }

    public g a(Intent intent) {
        this.a.add(intent);
        return this;
    }

    public void a() {
        this.a((Bundle)null);
    }

    public void a(Bundle bundle) {
        if (!this.a.isEmpty()) {
            Intent[] arrintent = this.a.toArray((T[])new Intent[this.a.size()]);
            arrintent[0] = new Intent(arrintent[0]).addFlags(268484608);
            if (!androidx.core.a.a.a(this.b, arrintent, bundle)) {
                bundle = new Intent(arrintent[arrintent.length - 1]);
                bundle.addFlags(268435456);
                this.b.startActivity((Intent)bundle);
            }
            return;
        }
        throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
    }

    @Deprecated
    @Override
    public Iterator<Intent> iterator() {
        return this.a.iterator();
    }

    public static interface a {
        public Intent d();
    }

}

