/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.Point
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.view.Display
 *  android.view.WindowManager
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Build;
import android.view.Display;
import android.view.WindowManager;
import com.mixpanel.android.b.f;
import com.mixpanel.android.b.j;
import com.mixpanel.android.b.k;
import com.mixpanel.android.b.m;
import com.mixpanel.android.b.x;
import com.mixpanel.android.b.y;
import com.mixpanel.android.c.d;
import com.mixpanel.android.c.h;
import com.mixpanel.android.c.i;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.net.ssl.SSLSocketFactory;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class e {
    private static final JSONArray f = new JSONArray();
    private final k a;
    private final Context b;
    private final Map<String, f> c;
    private final d d;
    private final x e;

    public e(Context context, k k2) {
        this.b = context;
        this.a = k2;
        this.c = new HashMap<String, f>();
        this.d = this.a(context);
        this.e = x.a(context);
    }

    @SuppressLint(value={"NewApi"})
    private static int a(Display display) {
        if (Build.VERSION.SDK_INT < 13) {
            return display.getWidth();
        }
        Point point = new Point();
        display.getSize(point);
        return point.x;
    }

    private Bitmap a(j object, Context arrstring) {
        String[] arrstring2 = new String[2];
        CharSequence charSequence = ((j)object).j();
        int n2 = 0;
        arrstring2[0] = charSequence;
        arrstring2[1] = ((j)object).i();
        int n3 = e.a(((WindowManager)arrstring.getSystemService("window")).getDefaultDisplay());
        arrstring = arrstring2;
        if (((j)object).d() == j.a.c) {
            arrstring = arrstring2;
            if (n3 >= 720) {
                arrstring = new String[]{((j)object).k(), ((j)object).j(), ((j)object).i()};
            }
        }
        n3 = arrstring.length;
        while (n2 < n3) {
            object = arrstring[n2];
            try {
                arrstring2 = this.d.b((String)object);
                return arrstring2;
            }
            catch (d.a a2) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("Can't load image ");
                ((StringBuilder)charSequence).append((String)object);
                ((StringBuilder)charSequence).append(" for a notification");
                com.mixpanel.android.c.f.a("MixpanelAPI.DChecker", ((StringBuilder)charSequence).toString(), a2);
                ++n2;
            }
        }
        return null;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    static a a(String list) {
        JSONObject jSONObject;
        a a2;
        block27 : {
            block26 : {
                block25 : {
                    Object object;
                    void var4_14;
                    block28 : {
                        a2 = new a();
                        try {
                            jSONObject = new JSONObject(list);
                            List<j> list2 = list = null;
                        }
                        catch (JSONException jSONException) {
                            StringBuilder stringBuilder = new StringBuilder();
                            stringBuilder.append("Mixpanel endpoint returned unparsable result:\n");
                            stringBuilder.append((String)((Object)list));
                            throw new b(stringBuilder.toString(), jSONException);
                        }
                        if (jSONObject.has("notifications")) {
                            JSONArray jSONArray = jSONObject.getJSONArray("notifications");
                        }
                        break block28;
                        catch (JSONException jSONException) {}
                        object = new StringBuilder();
                        ((StringBuilder)object).append("Mixpanel endpoint returned non-array JSON for notifications: ");
                        ((StringBuilder)object).append((Object)jSONObject);
                        com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", ((StringBuilder)object).toString());
                        List<j> list3 = list;
                    }
                    if (var4_14 != null) {
                        int n2 = Math.min(var4_14.length(), 2);
                        for (int i2 = 0; i2 < n2; ++i2) {
                            String string2;
                            block24 : {
                                try {
                                    list = var4_14.getJSONObject(i2);
                                    object = list.getString("type");
                                    if (((String)object).equalsIgnoreCase("takeover")) {
                                        object = new y((JSONObject)list);
                                        list = a2.a;
                                    } else {
                                        if (!((String)object).equalsIgnoreCase("mini")) continue;
                                        object = new m((JSONObject)list);
                                        list = a2.a;
                                    }
                                    list.add((j)object);
                                    continue;
                                }
                                catch (OutOfMemoryError outOfMemoryError) {
                                    object = new StringBuilder();
                                    string2 = "Not enough memory to show load notification from package: ";
                                    break block24;
                                }
                                catch (com.mixpanel.android.b.b b2) {
                                    object = new StringBuilder();
                                }
                                catch (JSONException jSONException) {
                                    object = new StringBuilder();
                                }
                                string2 = "Received a strange response from notifications service: ";
                            }
                            ((StringBuilder)object).append(string2);
                            ((StringBuilder)object).append(var4_14.toString());
                            com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", ((StringBuilder)object).toString(), list);
                        }
                    }
                    if (jSONObject.has("event_bindings")) {
                        try {
                            a2.b = jSONObject.getJSONArray("event_bindings");
                            break block25;
                        }
                        catch (JSONException jSONException) {}
                        list = new StringBuilder();
                        ((StringBuilder)((Object)list)).append("Mixpanel endpoint returned non-array JSON for event bindings: ");
                        ((StringBuilder)((Object)list)).append((Object)jSONObject);
                        com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", ((StringBuilder)((Object)list)).toString());
                    }
                }
                if (jSONObject.has("variants")) {
                    try {
                        a2.c = jSONObject.getJSONArray("variants");
                        break block26;
                    }
                    catch (JSONException jSONException) {}
                    list = new StringBuilder();
                    ((StringBuilder)((Object)list)).append("Mixpanel endpoint returned non-array JSON for variants: ");
                    ((StringBuilder)((Object)list)).append((Object)jSONObject);
                    com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", ((StringBuilder)((Object)list)).toString());
                }
            }
            if (jSONObject.has("automatic_events")) {
                try {
                    a2.d = jSONObject.getBoolean("automatic_events");
                    break block27;
                }
                catch (JSONException jSONException) {}
                list = new StringBuilder();
                ((StringBuilder)((Object)list)).append("Mixpanel endpoint returned a non boolean value for automatic events: ");
                ((StringBuilder)((Object)list)).append((Object)jSONObject);
                com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", ((StringBuilder)((Object)list)).toString());
            }
        }
        if (!jSONObject.has("integrations")) return a2;
        try {
            a2.e = jSONObject.getJSONArray("integrations");
            return a2;
        }
        catch (JSONException jSONException) {}
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Mixpanel endpoint returned a non-array JSON for integrations: ");
        stringBuilder.append((Object)jSONObject);
        com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", stringBuilder.toString());
        return a2;
    }

    private a a(String object, String object2, i object3) {
        object = this.b((String)object, (String)object2, (i)object3);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Mixpanel decide server response was:\n");
        ((StringBuilder)object2).append((String)object);
        com.mixpanel.android.c.f.a("MixpanelAPI.DChecker", ((StringBuilder)object2).toString());
        if (object != null) {
            object2 = e.a((String)object);
            object3 = ((a)object2).a.iterator();
            do {
                object = object2;
                if (object3.hasNext()) {
                    object = (j)object3.next();
                    Object object4 = this.a((j)object, this.b);
                    if (object4 == null) {
                        object4 = new StringBuilder();
                        ((StringBuilder)object4).append("Could not retrieve image for notification ");
                        ((StringBuilder)object4).append(((j)object).b());
                        ((StringBuilder)object4).append(", will not show the notification.");
                        com.mixpanel.android.c.f.c("MixpanelAPI.DChecker", ((StringBuilder)object4).toString());
                        object3.remove();
                        continue;
                    }
                    ((j)object).a((Bitmap)object4);
                    continue;
                }
                break;
            } while (true);
        } else {
            object = null;
        }
        return object;
    }

    static /* synthetic */ JSONArray a() {
        return f;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    private static byte[] a(i arrby, Context context, String string2) {
        void var1_7;
        void var1_5;
        k k2 = k.a(context);
        if (!arrby.a(context, k2.D())) {
            return null;
        }
        try {
            return arrby.a(string2, null, k2.C());
        }
        catch (OutOfMemoryError outOfMemoryError) {
            arrby = new StringBuilder();
            ((StringBuilder)arrby).append("Out of memory when getting to ");
            ((StringBuilder)arrby).append(string2);
            string2 = ".";
        }
        catch (IOException iOException) {
            arrby = new StringBuilder();
            ((StringBuilder)arrby).append("Cannot get ");
            ((StringBuilder)arrby).append(string2);
            string2 = ".";
        }
        catch (FileNotFoundException fileNotFoundException) {
            arrby = new StringBuilder();
            ((StringBuilder)arrby).append("Cannot get ");
            ((StringBuilder)arrby).append(string2);
            string2 = ", file not found.";
        }
        ((StringBuilder)arrby).append(string2);
        com.mixpanel.android.c.f.a("MixpanelAPI.DChecker", ((StringBuilder)arrby).toString(), (Throwable)var1_5);
        return null;
        catch (MalformedURLException malformedURLException) {
            arrby = new StringBuilder();
            ((StringBuilder)arrby).append("Cannot interpret ");
            ((StringBuilder)arrby).append(string2);
            string2 = " as a URL.";
        }
        ((StringBuilder)arrby).append(string2);
        com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", ((StringBuilder)arrby).toString(), (Throwable)var1_7);
        return null;
    }

    private String b(String object, String charSequence, i i2) {
        String string2;
        block10 : {
            block9 : {
                try {
                    string2 = URLEncoder.encode((String)object, "utf-8");
                    if (charSequence == null) break block9;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    throw new RuntimeException("Mixpanel library requires utf-8 string encoding to be available", unsupportedEncodingException);
                }
                object = URLEncoder.encode((String)charSequence, "utf-8");
                break block10;
            }
            object = null;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("?version=1&lib=android&token=");
        ((StringBuilder)charSequence).append(string2);
        if (object != null) {
            ((StringBuilder)charSequence).append("&distinct_id=");
            ((StringBuilder)charSequence).append((String)object);
        }
        ((StringBuilder)charSequence).append("&properties=");
        object = new JSONObject();
        try {
            object.putOpt("$android_lib_version", (Object)"5.4.0");
            object.putOpt("$android_app_version", (Object)this.e.a());
            object.putOpt("$android_version", (Object)Build.VERSION.RELEASE);
            object.putOpt("$android_app_release", (Object)this.e.b());
            object.putOpt("$android_device_model", (Object)Build.MODEL);
            ((StringBuilder)charSequence).append(URLEncoder.encode(object.toString(), "utf-8"));
        }
        catch (Exception exception) {
            com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", "Exception constructing properties JSON", exception.getCause());
        }
        object = ((StringBuilder)charSequence).toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append(this.a.o());
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Querying decide server, url: ");
        ((StringBuilder)charSequence).append((String)object);
        com.mixpanel.android.c.f.a("MixpanelAPI.DChecker", ((StringBuilder)charSequence).toString());
        object = e.a(i2, this.b, (String)object);
        if (object == null) {
            return null;
        }
        try {
            object = new String((byte[])object, "UTF-8");
            return object;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            throw new RuntimeException("UTF not supported on this platform?", unsupportedEncodingException);
        }
    }

    protected d a(Context context) {
        return new d(context, "DecideChecker");
    }

    public void a(f f2) {
        this.c.put(f2.a(), f2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public void a(String object, i object2) {
        if ((object = this.c.get(object)) == null) return;
        String string2 = ((f)object).b();
        object2 = this.a(((f)object).a(), string2, (i)object2);
        if (object2 == null) return;
        try {
            ((f)object).a(((a)object2).a, ((a)object2).b, ((a)object2).c, ((a)object2).d, ((a)object2).e);
            return;
        }
        catch (b b2) {
            com.mixpanel.android.c.f.e("MixpanelAPI.DChecker", b2.getMessage(), b2);
        }
    }

    public f b(String string2) {
        return this.c.get(string2);
    }

    static class a {
        public final List<j> a = new ArrayList<j>();
        public JSONArray b = e.a();
        public JSONArray c = e.a();
        public boolean d = false;
        public JSONArray e;
    }

    static class b
    extends Exception {
        public b(String string2, JSONException jSONException) {
            super(string2, (Throwable)jSONException);
        }
    }

}

