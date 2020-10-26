/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.R
 *  android.R$id
 *  android.content.Context
 *  android.util.SparseArray
 */
package com.mixpanel.android.b;

import android.R;
import android.content.Context;
import android.util.SparseArray;
import com.mixpanel.android.b.s;
import com.mixpanel.android.c.f;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class t
implements s {
    private final Context a;
    private final Map<String, Integer> b;
    private final SparseArray<String> c;

    protected t(Context context) {
        this.a = context;
        this.b = new HashMap<String, Integer>();
        this.c = new SparseArray();
    }

    /*
     * WARNING - combined exceptions agressively - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void a(Class<?> class_, String string2, Map<String, Integer> object) {
        try {
            Field[] arrfield = class_.getFields();
            for (int i2 = 0; i2 < arrfield.length; ++i2) {
                Object object2 = arrfield[i2];
                if (!Modifier.isStatic(((Field)object2).getModifiers()) || ((Field)object2).getType() != Integer.TYPE) continue;
                String string3 = ((Field)object2).getName();
                int n2 = ((Field)object2).getInt(null);
                if (string2 != null) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(":");
                    ((StringBuilder)object2).append(string3);
                    string3 = ((StringBuilder)object2).toString();
                }
                object.put(string3, n2);
            }
            return;
        }
        catch (IllegalAccessException illegalAccessException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Can't read built-in id names from ");
            ((StringBuilder)object).append(class_.getName());
            f.e("MixpanelAPI.RsrcReader", ((StringBuilder)object).toString(), illegalAccessException);
        }
    }

    protected abstract Class<?> a();

    @Override
    public String a(int n2) {
        return (String)this.c.get(n2);
    }

    protected abstract String a(Context var1);

    @Override
    public boolean a(String string2) {
        return this.b.containsKey(string2);
    }

    @Override
    public int b(String string2) {
        return this.b.get(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    protected void b() {
        Object object;
        block4 : {
            this.b.clear();
            this.c.clear();
            t.a(this.a(), "android", this.b);
            object = this.a(this.a);
            try {
                t.a(Class.forName((String)object), null, this.b);
                break block4;
            }
            catch (ClassNotFoundException classNotFoundException) {}
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Can't load names for Android view ids from '");
            stringBuilder.append((String)object);
            stringBuilder.append("', ids by name will not be available in the events editor.");
            f.d("MixpanelAPI.RsrcReader", stringBuilder.toString());
            f.c("MixpanelAPI.RsrcReader", "You may be missing a Resources class for your package due to your proguard configuration, or you may be using an applicationId in your build that isn't the same as the package declared in your AndroidManifest.xml file.\nIf you're using proguard, you can fix this issue by adding the following to your proguard configuration:\n\n-keep class **.R$* {\n    <fields>;\n}\n\nIf you're not using proguard, or if your proguard configuration already contains the directive above, you can add the following to your AndroidManifest.xml file to explicitly point the Mixpanel library to the appropriate library for your resources class:\n\n<meta-data android:name=\"com.mixpanel.android.MPConfig.ResourcePackageName\" android:value=\"YOUR_PACKAGE_NAME\" />\n\nwhere YOUR_PACKAGE_NAME is the same string you use for the \"package\" attribute in your <manifest> tag.");
        }
        object = this.b.entrySet().iterator();
        while (object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            this.c.put(((Integer)entry.getValue()).intValue(), entry.getKey());
        }
        return;
    }

    public static class a
    extends t {
        private final String a;

        public a(String string2, Context context) {
            super(context);
            this.a = string2;
            this.b();
        }

        @Override
        protected Class<?> a() {
            return R.id.class;
        }

        @Override
        protected String a(Context object) {
            object = new StringBuilder();
            ((StringBuilder)object).append(this.a);
            ((StringBuilder)object).append(".R$id");
            return ((StringBuilder)object).toString();
        }
    }

}

