/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import com.mixpanel.android.c.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONException;
import org.json.JSONObject;

public class z {
    private final ConcurrentMap<String, b> a = new ConcurrentHashMap<String, b>();
    private final ConcurrentMap<String, b> b = new ConcurrentHashMap<String, b>();
    private final ConcurrentMap<String, b> c = new ConcurrentHashMap<String, b>();
    private final List<a> d = new ArrayList<a>();

    z() {
    }

    public Map<String, b> a() {
        synchronized (this) {
            HashMap<String, b> hashMap = new HashMap<String, b>(this.a);
            return hashMap;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(a a2) {
        synchronized (this) {
            if (a2 == null) throw new NullPointerException("listener cannot be null");
            this.d.add(a2);
            return;
        }
    }

    public void a(String string2, b b2) {
        if (string2 != null) {
            if (b2 == null) {
                return;
            }
            this.c.put(string2, b2);
        }
    }

    public void a(String string2, Object object) {
        synchronized (this) {
            if (!this.a.containsKey(string2)) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Attempt to set a tweak \"");
                ((StringBuilder)object).append(string2);
                ((StringBuilder)object).append("\" which has never been defined.");
                f.d("MixpanelAPI.Tweaks", ((StringBuilder)object).toString());
                return;
            }
            object = ((b)this.a.get(string2)).a(object);
            this.a.put(string2, (b)object);
            return;
        }
    }

    public Map<String, b> b() {
        synchronized (this) {
            HashMap<String, b> hashMap = new HashMap<String, b>(this.b);
            return hashMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(String string2, Object object) {
        synchronized (this) {
            void var2_2;
            boolean bl2 = this.a.containsKey(string2);
            if (!bl2) {
                return false;
            }
            bl2 = ((b)this.a.get(string2)).b.equals(var2_2);
            bl2 ^= true;
            return bl2;
        }
    }

    public static interface a {
    }

    public static class b {
        public final int a;
        private final Object b;
        private final Object c;
        private final Number d;
        private final Number e;
        private final String f;

        private b(int n2, Object object, Number object2, Number object3, Object object4, String object5) {
            this.a = n2;
            this.f = object5;
            this.d = object2;
            this.e = object3;
            object3 = object;
            object5 = object4;
            if (this.d != null) {
                object3 = object;
                object5 = object4;
                if (this.e != null) {
                    object2 = object;
                    if (!this.b(object)) {
                        object2 = Math.min(Math.max(((Number)object).longValue(), this.d.longValue()), this.e.longValue());
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Attempt to define a tweak \"");
                        ((StringBuilder)object).append(this.f);
                        ((StringBuilder)object).append("\" with default value ");
                        ((StringBuilder)object).append(object2);
                        ((StringBuilder)object).append(" out of its bounds [");
                        ((StringBuilder)object).append(this.d);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(this.e);
                        ((StringBuilder)object).append("]Tweak \"");
                        ((StringBuilder)object).append(this.f);
                        ((StringBuilder)object).append("\" new default value: ");
                        ((StringBuilder)object).append(object2);
                        ((StringBuilder)object).append(".");
                        f.d("MixpanelAPI.Tweaks", ((StringBuilder)object).toString());
                    }
                    object3 = object2;
                    object5 = object4;
                    if (!this.b(object4)) {
                        object5 = Math.min(Math.max(((Number)object4).longValue(), this.d.longValue()), this.e.longValue());
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Attempt to define a tweak \"");
                        ((StringBuilder)object).append(this.f);
                        ((StringBuilder)object).append("\" with value ");
                        ((StringBuilder)object).append(object2);
                        ((StringBuilder)object).append(" out of its bounds [");
                        ((StringBuilder)object).append(this.d);
                        ((StringBuilder)object).append(", ");
                        ((StringBuilder)object).append(this.e);
                        ((StringBuilder)object).append("]Tweak \"");
                        ((StringBuilder)object).append(this.f);
                        ((StringBuilder)object).append("\" new value: ");
                        ((StringBuilder)object).append(object5);
                        ((StringBuilder)object).append(".");
                        f.d("MixpanelAPI.Tweaks", ((StringBuilder)object).toString());
                        object3 = object2;
                    }
                }
            }
            this.c = object3;
            this.b = object5;
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public static b a(JSONObject object) {
            Object object2;
            void var0_9;
            String string2;
            Object object3;
            void var0_5;
            int n2;
            Object object4;
            block8 : {
                void var7_25;
                block7 : {
                    try {
                        string2 = object.getString("name");
                        object2 = object.getString("type");
                        if ("number".equals(object2)) {
                            object2 = object.getString("encoding");
                            if ("d".equals(object2)) {
                                int n3 = 2;
                                Double d2 = object.getDouble("value");
                                Double d3 = object.getDouble("default");
                                object4 = !object.isNull("minimum") ? Double.valueOf(object.getDouble("minimum")) : null;
                                n2 = n3;
                                Double d4 = d2;
                                object2 = d3;
                                object3 = object4;
                                if (object.isNull("maximum")) break block7;
                                object3 = object.getDouble("maximum");
                                n2 = n3;
                                Double d5 = d2;
                                object2 = d3;
                                break block8;
                            }
                            if (!"l".equals(object2)) return null;
                            Long l2 = object.getLong("value");
                            int n4 = 3;
                            Long l3 = object.getLong("default");
                            object4 = !object.isNull("minimum") ? Long.valueOf(object.getLong("minimum")) : null;
                            n2 = n4;
                            Long l4 = l2;
                            object2 = l3;
                            object3 = object4;
                            if (object.isNull("maximum")) break block7;
                            object3 = object.getLong("maximum");
                            n2 = n4;
                            Long l5 = l2;
                            object2 = l3;
                            break block8;
                        }
                        if ("boolean".equals(object2)) {
                            boolean bl2 = object.getBoolean("value");
                            Boolean bl3 = object.getBoolean("default");
                            object4 = object2 = null;
                            object3 = bl2;
                            n2 = 1;
                            return new b(n2, var0_5, (Number)object2, (Number)object4, object3, string2);
                        } else {
                            if (!"string".equals(object2)) {
                                return null;
                            }
                            object3 = object.getString("value");
                            String string3 = object.getString("default");
                            object4 = object2 = null;
                            n2 = 4;
                        }
                        return new b(n2, var0_5, (Number)object2, (Number)object4, object3, string2);
                    }
                    catch (JSONException jSONException) {
                        return null;
                    }
                }
                Object var8_20 = null;
                void var0_8 = var7_25;
                object4 = object3;
                object3 = var8_20;
            }
            void var7_26 = var0_9;
            Object object5 = object2;
            object2 = object4;
            object4 = object3;
            object3 = var7_26;
            return new b(n2, var0_5, (Number)object2, (Number)object4, object3, string2);
        }

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean b(Object object) {
            block3 : {
                try {
                    long l2;
                    long l3;
                    object = (Number)object;
                    if (Math.min(Math.max(((Number)object).longValue(), this.d.longValue()), this.e.longValue()) != this.d.longValue() && (l2 = Math.min(Math.max(((Number)object).longValue(), this.d.longValue()), this.e.longValue())) != (l3 = this.e.longValue())) break block3;
                    return false;
                }
                catch (ClassCastException classCastException) {
                    return true;
                }
            }
            do {
                return true;
                break;
            } while (true);
        }

        public b a(Object object) {
            return new b(this.a, this.c, this.d, this.e, object, this.f);
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public String a() {
            String string2;
            block4 : {
                try {
                    string2 = (String)this.c;
                    break block4;
                }
                catch (ClassCastException classCastException) {}
                string2 = null;
            }
            try {
                return (String)this.b;
            }
            catch (ClassCastException classCastException) {
                return string2;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         * Lifted jumps to return sites
         */
        public Number b() {
            void var2_4;
            Integer n2;
            void var1_8;
            Integer n3 = n2 = Integer.valueOf(0);
            if (this.c != null) {
                try {
                    Number number = (Number)this.c;
                }
                catch (ClassCastException classCastException) {
                    Integer n4 = n2;
                }
            }
            void var2_2 = var1_8;
            if (this.b == null) return var2_4;
            try {
                Number number = (Number)this.b;
                return var2_4;
            }
            catch (ClassCastException classCastException) {
                return var1_8;
            }
        }

        /*
         * Enabled aggressive block sorting
         * Enabled unnecessary exception pruning
         * Enabled aggressive exception aggregation
         */
        public Boolean c() {
            Boolean bl2;
            Boolean bl3 = bl2 = Boolean.valueOf(false);
            if (this.c != null) {
                try {
                    bl3 = (Boolean)this.c;
                }
                catch (ClassCastException classCastException) {
                    bl3 = bl2;
                }
            }
            bl2 = bl3;
            if (this.b == null) return bl2;
            try {
                return (Boolean)this.b;
            }
            catch (ClassCastException classCastException) {
                return bl3;
            }
        }

        public Number d() {
            return this.d;
        }

        public Number e() {
            return this.e;
        }

        public Object f() {
            return this.c;
        }

        public Object g() {
            return this.b;
        }
    }

}

