/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.ColorDrawable
 *  android.graphics.drawable.Drawable
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.d;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import com.mixpanel.android.b.s;
import com.mixpanel.android.c.d;
import com.mixpanel.android.c.e;
import com.mixpanel.android.c.f;
import com.mixpanel.android.c.g;
import com.mixpanel.android.d.h;
import com.mixpanel.android.d.i;
import com.mixpanel.android.d.n;
import com.mixpanel.android.d.o;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class c {
    private static final Class<?>[] e = new Class[0];
    private static final List<h.c> f = Collections.emptyList();
    private final Context a;
    private final s b;
    private final com.mixpanel.android.c.d c;
    private final o.i d;

    public c(Context context, s s2, com.mixpanel.android.c.d d2, o.i i2) {
        this.a = context;
        this.b = s2;
        this.c = d2;
        this.d = i2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Drawable a(JSONObject jSONObject, List<String> list) {
        try {
            int n2;
            int n3;
            int n4;
            int n5;
            if (jSONObject.isNull("url")) throw new a("Can't construct a BitmapDrawable with a null url");
            String string2 = jSONObject.getString("url");
            boolean bl2 = jSONObject.isNull("dimensions");
            boolean bl3 = false;
            if (bl2) {
                n5 = 0;
                n4 = 0;
                n3 = 0;
                n2 = 0;
            } else {
                jSONObject = jSONObject.getJSONObject("dimensions");
                n5 = jSONObject.getInt("left");
                n4 = jSONObject.getInt("right");
                n3 = jSONObject.getInt("top");
                n2 = jSONObject.getInt("bottom");
                bl3 = true;
            }
            try {
                jSONObject = this.c.b(string2);
                list.add(string2);
            }
            catch (d.a a2) {
                throw new b(a2.getMessage(), a2.getCause());
            }
            jSONObject = new BitmapDrawable(Resources.getSystem(), (Bitmap)jSONObject);
            if (!bl3) return jSONObject;
            jSONObject.setBounds(n5, n3, n4, n2);
            return jSONObject;
        }
        catch (JSONException jSONException) {
            throw new a("Couldn't read drawable description", (Throwable)jSONException);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private i a(Class<?> object, JSONObject jSONObject) {
        try {
            Object object2;
            String string2 = jSONObject.getString("name");
            boolean bl2 = jSONObject.has("get");
            String string3 = null;
            if (bl2) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("get");
                object2 = jSONObject2.getString("selector");
                Class<?> class_ = Class.forName(jSONObject2.getJSONObject("result").getString("type"));
                object2 = new com.mixpanel.android.d.a((Class<?>)object, (String)object2, e, class_);
            } else {
                object2 = null;
            }
            if (!jSONObject.has("set")) return new i(string2, (Class<?>)object, (com.mixpanel.android.d.a)object2, string3);
            string3 = jSONObject.getJSONObject("set").getString("selector");
            return new i(string2, (Class<?>)object, (com.mixpanel.android.d.a)object2, string3);
        }
        catch (ClassNotFoundException classNotFoundException) {
            throw new a("Can't read property JSON, relevant arg/return class not found", classNotFoundException);
        }
        catch (JSONException jSONException) {
            throw new a("Can't read property JSON", (Throwable)jSONException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new a("Can't create property reader", noSuchMethodException);
        }
    }

    /*
     * Enabled aggressive block sorting
     */
    private Integer a(int n2, String string2, s object) {
        int n3;
        if (string2 != null) {
            if (!object.a(string2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Path element contains an id name not known to the system. No views will be matched.\nMake sure that you're not stripping your packages R class out with proguard.\nid name was \"");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("\"");
                f.d("MixpanelAPI.EProtocol", ((StringBuilder)object).toString());
                return null;
            }
            n3 = object.b(string2);
        } else {
            n3 = -1;
        }
        if (-1 != n3 && -1 != n2 && n3 != n2) {
            f.e("MixpanelAPI.EProtocol", "Path contains both a named and an explicit id, and they don't match. No views will be matched.");
            return null;
        }
        if (-1 != n3) {
            return n3;
        }
        return n2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private Object a(Object object, String string2, List<String> object2) {
        int n2;
        try {
            if ("java.lang.CharSequence".equals(string2)) {
                return object;
            }
            if ("boolean".equals(string2)) return object;
            if ("java.lang.Boolean".equals(string2)) {
                return object;
            }
            if (!"int".equals(string2) && !"java.lang.Integer".equals(string2)) {
                if ("float".equals(string2)) return Float.valueOf(((Number)object).floatValue());
                if ("java.lang.Float".equals(string2)) {
                    return Float.valueOf(((Number)object).floatValue());
                }
                if ("android.graphics.drawable.Drawable".equals(string2)) {
                    return this.a((JSONObject)object, (List<String>)object2);
                }
                if ("android.graphics.drawable.BitmapDrawable".equals(string2)) {
                    return this.a((JSONObject)object, (List<String>)object2);
                }
                if ("android.graphics.drawable.ColorDrawable".equals(string2)) {
                    return new ColorDrawable(((Number)object).intValue());
                }
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("Don't know how to interpret type ");
                ((StringBuilder)object2).append(string2);
                ((StringBuilder)object2).append(" (arg was ");
                ((StringBuilder)object2).append(object);
                ((StringBuilder)object2).append(")");
                throw new a(((StringBuilder)object2).toString());
            }
            n2 = ((Number)object).intValue();
        }
        catch (ClassCastException classCastException) {}
        return n2;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Couldn't interpret <");
        stringBuilder.append(object);
        stringBuilder.append("> as ");
        stringBuilder.append(string2);
        throw new a(stringBuilder.toString());
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c a(JSONObject object) {
        JSONArray jSONArray;
        List<h.c> list;
        int n2;
        int n3;
        ArrayList<o.f> arrayList;
        Serializable serializable = new ArrayList();
        try {
            list = this.a(object.getJSONArray("path"), this.b);
            if (list.size() == 0) throw new d("Edit will not be bound to any element in the UI.");
            if (object.getString("change_type").equals("property")) {
                Object[] arrobject;
                Object object2 = object.getJSONObject("property").getString("classname");
                if (object2 == null) throw new a("Can't bind an edit property without a target class");
                try {
                    arrobject = Class.forName((String)object2);
                    object2 = this.a((Class<?>)arrobject, object.getJSONObject("property"));
                }
                catch (ClassNotFoundException classNotFoundException) {
                    serializable = new StringBuilder();
                    ((StringBuilder)serializable).append("Can't find class for visit path: ");
                    ((StringBuilder)serializable).append((String)object2);
                    throw new a(((StringBuilder)serializable).toString(), classNotFoundException);
                }
                object = object.getJSONArray("args");
                arrobject = new Object[object.length()];
                for (int i2 = 0; i2 < object.length(); ++i2) {
                    JSONArray jSONArray2 = object.getJSONArray(i2);
                    arrobject[i2] = this.a(jSONArray2.get(0), jSONArray2.getString(1), (List<String>)((Object)serializable));
                }
                object = ((i)object2).a(arrobject);
                if (object != null) {
                    object = new o.j(list, (com.mixpanel.android.d.a)object, ((i)object2).c);
                    return new c((o)object, (List)((Object)serializable));
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Can't update a read-only property ");
                ((StringBuilder)object).append(((i)object2).a);
                ((StringBuilder)object).append(" (add a mutator to make this work)");
                throw new a(((StringBuilder)object).toString());
            }
            if (!object.getString("change_type").equals("layout")) {
                throw new a("Can't figure out the edit type");
            }
            jSONArray = object.getJSONArray("args");
            arrayList = new ArrayList<o.f>();
            n3 = jSONArray.length();
            n2 = 0;
        }
        catch (JSONException jSONException) {
            throw new a("Can't interpret instructions due to JSONException", (Throwable)jSONException);
        }
        catch (NoSuchMethodException noSuchMethodException) {
            throw new a("Can't create property mutator", noSuchMethodException);
        }
        do {
            Serializable serializable2;
            JSONObject jSONObject;
            Integer n4;
            String string2;
            String string3;
            if (n2 < n3) {
                jSONObject = jSONArray.optJSONObject(n2);
                string3 = jSONObject.getString("view_id_name");
                string2 = jSONObject.getString("anchor_id_name");
                n4 = this.a(-1, string3, this.b);
                serializable2 = string2.equals("0") ? Integer.valueOf(0) : (string2.equals("-1") ? Integer.valueOf(-1) : this.a(-1, string2, this.b));
            } else {
                object = new o.g(list, arrayList, object.getString("name"), this.d);
                return new c((o)object, (List)((Object)serializable));
            }
            if (n4 != null && serializable2 != null) {
                arrayList.add(new o.f(n4, jSONObject.getInt("verb"), (Integer)serializable2));
            } else {
                serializable2 = new StringBuilder();
                ((StringBuilder)serializable2).append("View (");
                ((StringBuilder)serializable2).append(string3);
                ((StringBuilder)serializable2).append(") or anchor (");
                ((StringBuilder)serializable2).append(string2);
                ((StringBuilder)serializable2).append(") not found.");
                f.d("MixpanelAPI.EProtocol", ((StringBuilder)serializable2).toString());
            }
            ++n2;
        } while (true);
    }

    public o a(JSONObject object, o.h h2) {
        try {
            String string2 = object.getString("event_name");
            String string3 = object.getString("event_type");
            object = this.a(object.getJSONArray("path"), this.b);
            if (object.size() != 0) {
                if ("click".equals(string3)) {
                    return new o.a((List<h.c>)object, 1, string2, h2);
                }
                if ("selected".equals(string3)) {
                    return new o.a((List<h.c>)object, 4, string2, h2);
                }
                if ("text_changed".equals(string3)) {
                    return new o.b((List<h.c>)object, string2, h2);
                }
                if ("detected".equals(string3)) {
                    return new o.k((List<h.c>)object, string2, h2);
                }
                object = new StringBuilder();
                ((StringBuilder)object).append("Mixpanel can't track event type \"");
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append("\"");
                throw new a(((StringBuilder)object).toString());
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("event '");
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append("' will not be bound to any element in the UI.");
            throw new d(((StringBuilder)object).toString());
        }
        catch (JSONException jSONException) {
            throw new a("Can't interpret instructions due to JSONException", (Throwable)jSONException);
        }
    }

    List<h.c> a(JSONArray object, s s2) {
        ArrayList<h.c> arrayList = new ArrayList<h.c>();
        for (int i2 = 0; i2 < object.length(); ++i2) {
            Object object2;
            block7 : {
                Object object3;
                int n2;
                String string2;
                String string3;
                int n3;
                int n4;
                String string4;
                block6 : {
                    block5 : {
                        object3 = object.getJSONObject(i2);
                        object2 = e.a(object3, "prefix");
                        string2 = e.a(object3, "view_class");
                        n4 = object3.optInt("index", -1);
                        string3 = e.a(object3, "contentDescription");
                        n3 = object3.optInt("id", -1);
                        string4 = e.a(object3, "mp_id_name");
                        object3 = e.a(object3, "tag");
                        if (!"shortest".equals(object2)) break block5;
                        n2 = 1;
                        break block6;
                    }
                    if (object2 != null) break block7;
                    n2 = 0;
                }
                object2 = this.a(n3, string4, s2);
                if (object2 == null) {
                    return f;
                }
                arrayList.add(new h.c(n2, string2, n4, (Integer)object2, string3, (String)object3));
                continue;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Unrecognized prefix type \"");
            ((StringBuilder)object).append((String)object2);
            ((StringBuilder)object).append("\". No views will be matched");
            f.d("MixpanelAPI.EProtocol", ((StringBuilder)object).toString());
            return f;
        }
        return arrayList;
    }

    public n b(JSONObject object) {
        ArrayList<i> arrayList = new ArrayList<i>();
        object = object.getJSONObject("config").getJSONArray("classes");
        int n2 = 0;
        do {
            block9 : {
                if (n2 >= object.length()) break block9;
                JSONObject jSONObject = object.getJSONObject(n2);
                Class<?> class_ = Class.forName(jSONObject.getString("name"));
                jSONObject = jSONObject.getJSONArray("properties");
                int n3 = 0;
                do {
                    if (n3 < jSONObject.length()) {
                        arrayList.add(this.a(class_, jSONObject.getJSONObject(n3)));
                        ++n3;
                        continue;
                    }
                    break;
                } while (true);
            }
            try {
                object = new n(this.a, arrayList, this.b);
                return object;
            }
            catch (ClassNotFoundException classNotFoundException) {
                throw new a("Can't resolve types for snapshot configuration", classNotFoundException);
            }
            catch (JSONException jSONException) {
                throw new a("Can't read snapshot configuration", (Throwable)jSONException);
            }
            ++n2;
        } while (true);
    }

    public g<String, Object> c(JSONObject object) {
        try {
            String string2;
            CharSequence charSequence;
            block9 : {
                block6 : {
                    block8 : {
                        block4 : {
                            block7 : {
                                block5 : {
                                    charSequence = object.getString("name");
                                    string2 = object.getString("type");
                                    if (!"number".equals(string2)) break block4;
                                    string2 = object.getString("encoding");
                                    if (!"d".equals(string2)) break block5;
                                    object = object.getDouble("value");
                                    break block6;
                                }
                                if (!"l".equals(string2)) break block7;
                                object = object.getLong("value");
                                break block6;
                            }
                            charSequence = new StringBuilder();
                            ((StringBuilder)charSequence).append("number must have encoding of type \"l\" for long or \"d\" for double in: ");
                            ((StringBuilder)charSequence).append(object);
                            throw new a(((StringBuilder)charSequence).toString());
                        }
                        if (!"boolean".equals(string2)) break block8;
                        object = object.getBoolean("value");
                        break block6;
                    }
                    if (!"string".equals(string2)) break block9;
                    object = object.getString("value");
                }
                return new g<String, JSONObject>((String)charSequence, (JSONObject)object);
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Unrecognized tweak type ");
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(" in: ");
            ((StringBuilder)charSequence).append(object);
            throw new a(((StringBuilder)charSequence).toString());
        }
        catch (JSONException jSONException) {
            throw new a("Can't read tweak update", (Throwable)jSONException);
        }
    }

    public static class a
    extends Exception {
        public a(String string2) {
            super(string2);
        }

        public a(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static class b
    extends Exception {
        public b(String string2, Throwable throwable) {
            super(string2, throwable);
        }
    }

    public static class c {
        public final o a;
        public final List<String> b;

        private c(o o2, List<String> list) {
            this.a = o2;
            this.b = list;
        }
    }

    public static class d
    extends a {
        public d(String string2) {
            super(string2);
        }
    }

}

