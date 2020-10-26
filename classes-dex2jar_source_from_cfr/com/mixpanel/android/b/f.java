/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.content.Context;
import com.mixpanel.android.b.j;
import com.mixpanel.android.b.k;
import com.mixpanel.android.b.l;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class f {
    private static final Set<Integer> h = new HashSet<Integer>();
    private String a;
    private final String b;
    private final Set<Integer> c;
    private final List<j> d;
    private final a e;
    private final com.mixpanel.android.d.l f;
    private JSONArray g;
    private Boolean i;
    private Context j;
    private Set<String> k;

    public f(Context context, String string2, a a2, com.mixpanel.android.d.l l2, HashSet<Integer> hashSet) {
        this.j = context;
        this.b = string2;
        this.e = a2;
        this.f = l2;
        this.a = null;
        this.d = new LinkedList<j>();
        this.c = new HashSet<Integer>(hashSet);
        this.g = null;
        this.k = new HashSet<String>();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public j a(boolean bl2) {
        synchronized (this) {
            if (this.d.isEmpty()) {
                com.mixpanel.android.c.f.a("MixpanelAPI.DecideUpdts", "No unseen notifications exist, none will be returned.");
                return null;
            }
            j j2 = this.d.remove(0);
            if (bl2) {
                this.d.add(j2);
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Recording notification ");
                stringBuilder.append(j2);
                stringBuilder.append(" as seen.");
                com.mixpanel.android.c.f.a("MixpanelAPI.DecideUpdts", stringBuilder.toString());
            }
            return j2;
        }
    }

    public String a() {
        return this.b;
    }

    public void a(j j2) {
        synchronized (this) {
            if (!k.a) {
                this.d.add(j2);
            }
            return;
        }
    }

    public void a(String string2) {
        synchronized (this) {
            if (this.a == null || !this.a.equals(string2)) {
                this.d.clear();
            }
            this.a = string2;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(List<j> list, JSONArray object4, JSONArray jSONArray, boolean bl2, JSONArray jSONArray2) {
        synchronized (this) {
            int n2;
            void var4_7;
            int n3;
            Object object2;
            Object object3;
            int n4;
            void var3_6;
            void var5_8;
            block19 : {
                n3 = var3_6.length();
                this.f.b((JSONArray)object2);
                object2 = list.iterator();
                int n5 = 0;
                n2 = 0;
                while (object2.hasNext()) {
                    object3 = object2.next();
                    n4 = ((j)object3).b();
                    if (this.c.contains(n4)) continue;
                    this.c.add(n4);
                    this.d.add((j)object3);
                    n2 = 1;
                }
                this.g = var3_6;
                for (n4 = 0; n4 < n3; ++n4) {
                    try {
                        object2 = var3_6.getJSONObject(n4);
                        boolean bl3 = h.contains(object2.getInt("id"));
                        if (bl3) continue;
                        n4 = 1;
                        n2 = 1;
                        break block19;
                    }
                    catch (JSONException object4) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Could not convert variants[");
                        ((StringBuilder)object3).append(n4);
                        ((StringBuilder)object3).append("] into a JSONObject while comparing the new variants");
                        com.mixpanel.android.c.f.e("MixpanelAPI.DecideUpdts", ((StringBuilder)object3).toString(), (Throwable)object4);
                    }
                }
                n4 = 0;
            }
            if (n4 != 0 && this.g != null) {
                h.clear();
                for (n4 = 0; n4 < n3; ++n4) {
                    try {
                        object2 = this.g.getJSONObject(n4);
                        h.add(object2.getInt("id"));
                        continue;
                    }
                    catch (JSONException jSONException) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("Could not convert variants[");
                        ((StringBuilder)object3).append(n4);
                        ((StringBuilder)object3).append("] into a JSONObject while updating the map");
                        com.mixpanel.android.c.f.e("MixpanelAPI.DecideUpdts", ((StringBuilder)object3).toString(), (Throwable)jSONException);
                    }
                }
            }
            n4 = n2;
            if (n3 == 0) {
                this.g = new JSONArray();
                n4 = n2;
                if (h.size() > 0) {
                    h.clear();
                    n4 = 1;
                }
            }
            this.f.a(this.g);
            if (this.i == null && var4_7 == false) {
                l.a(this.j).a(this.b);
            }
            this.i = (boolean)var4_7;
            if (var5_8 != null) {
                try {
                    object2 = new HashSet();
                    for (n2 = n5; n2 < var5_8.length(); ++n2) {
                        ((HashSet)object2).add(var5_8.getString(n2));
                    }
                    if (!this.k.equals(object2)) {
                        this.k = object2;
                        this.e.b();
                    }
                }
                catch (JSONException jSONException) {
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append("Got an integration id from ");
                    ((StringBuilder)object3).append(var5_8.toString());
                    ((StringBuilder)object3).append(" that wasn't an int");
                    com.mixpanel.android.c.f.e("MixpanelAPI.DecideUpdts", ((StringBuilder)object3).toString(), (Throwable)jSONException);
                }
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("New Decide content has become available. ");
            ((StringBuilder)object2).append(list.size());
            ((StringBuilder)object2).append(" notifications and ");
            ((StringBuilder)object2).append(var3_6.length());
            ((StringBuilder)object2).append(" experiments have been added.");
            com.mixpanel.android.c.f.a("MixpanelAPI.DecideUpdts", ((StringBuilder)object2).toString());
            if (n4 != 0 && this.e != null) {
                this.e.a();
            }
            return;
        }
    }

    public String b() {
        synchronized (this) {
            String string2 = this.a;
            return string2;
        }
    }

    public JSONArray c() {
        synchronized (this) {
            JSONArray jSONArray = this.g;
            return jSONArray;
        }
    }

    public Set<String> d() {
        synchronized (this) {
            Set<String> set = this.k;
            return set;
        }
    }

    public Boolean e() {
        return this.i;
    }

    public boolean f() {
        if (this.e() == null) {
            return true;
        }
        return this.e();
    }

    public static interface a {
        public void a();

        public void b();
    }

}

