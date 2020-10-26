/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$Config
 *  android.os.Parcel
 *  android.os.Parcelable
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.b.b;
import com.mixpanel.android.c.e;
import com.mixpanel.android.c.f;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class j
implements Parcelable {
    private static final Pattern e = Pattern.compile("(\\.[^./]+$)");
    protected final JSONObject a;
    protected final JSONObject b;
    protected final int c;
    protected final int d;
    private final int f;
    private final String g;
    private final int h;
    private final String i;
    private Bitmap j;

    public j() {
        this.a = null;
        this.b = null;
        this.c = 0;
        this.d = 0;
        this.f = 0;
        this.g = null;
        this.h = 0;
        this.i = null;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public j(Parcel parcel) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        block4 : {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject = new JSONObject();
            try {
                jSONObject2 = new JSONObject(parcel.readString());
            }
            catch (JSONException jSONException) {}
            try {
                jSONObject = jSONObject3 = new JSONObject(parcel.readString());
                break block4;
            }
            catch (JSONException jSONException) {}
            jSONObject2 = jSONObject3;
            f.e("MixpanelAPI.InAppNotif", "Error reading JSON when creating InAppNotification from Parcel");
        }
        this.a = jSONObject2;
        this.b = jSONObject;
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        this.i = parcel.readString();
        this.j = (Bitmap)parcel.readParcelable(Bitmap.class.getClassLoader());
    }

    j(JSONObject jSONObject) {
        try {
            this.a = jSONObject;
            this.b = jSONObject.getJSONObject("extras");
            this.c = jSONObject.getInt("id");
            this.d = jSONObject.getInt("message_id");
            this.f = jSONObject.getInt("bg_color");
            this.g = e.a(jSONObject, "body");
            this.h = jSONObject.optInt("body_color");
            this.i = jSONObject.getString("image_url");
            this.j = Bitmap.createBitmap((int)500, (int)500, (Bitmap.Config)Bitmap.Config.ARGB_8888);
            return;
        }
        catch (JSONException jSONException) {
            throw new b("Notification JSON was unexpected or bad", (Throwable)jSONException);
        }
    }

    static String a(String charSequence, String string2) {
        Matcher matcher = e.matcher(charSequence);
        if (matcher.find()) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append("$1");
            charSequence = matcher.replaceFirst(((StringBuilder)charSequence).toString());
        }
        return charSequence;
    }

    JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("campaign_id", this.b());
            jSONObject.put("message_id", this.c());
            jSONObject.put("message_type", (Object)"inapp");
            jSONObject.put("message_subtype", (Object)this.d().toString());
            return jSONObject;
        }
        catch (JSONException jSONException) {
            f.e("MixpanelAPI.InAppNotif", "Impossible JSON Exception", (Throwable)jSONException);
            return jSONObject;
        }
    }

    void a(Bitmap bitmap) {
        this.j = bitmap;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public abstract a d();

    public int describeContents() {
        return 0;
    }

    public int e() {
        return this.f;
    }

    public boolean f() {
        return this.g != null;
    }

    public String g() {
        return this.g;
    }

    public int h() {
        return this.h;
    }

    public String i() {
        return this.i;
    }

    public String j() {
        return j.a(this.i, "@2x");
    }

    public String k() {
        return j.a(this.i, "@4x");
    }

    public Bitmap l() {
        return this.j;
    }

    protected JSONObject m() {
        return this.b;
    }

    public String toString() {
        return this.a.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a.toString());
        parcel.writeString(this.b.toString());
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeString(this.i);
        parcel.writeParcelable((Parcelable)this.j, n2);
    }

    public static enum a {
        a{

            public String toString() {
                return "*unknown_type*";
            }
        }
        ,
        b{

            public String toString() {
                return "mini";
            }
        }
        ,
        c{

            public String toString() {
                return "takeover";
            }
        };
        

        private a() {
        }

    }

}

