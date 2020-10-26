/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public class h
implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>(){

        public h a(Parcel parcel) {
            return new h(parcel);
        }

        public h[] a(int n2) {
            return new h[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private JSONObject a;
    private String b;
    private int c;
    private int d;
    private int e;
    private String f;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public h(Parcel parcel) {
        JSONObject jSONObject;
        block2 : {
            jSONObject = new JSONObject();
            try {
                JSONObject jSONObject2;
                jSONObject = jSONObject2 = new JSONObject(parcel.readString());
                break block2;
            }
            catch (JSONException jSONException) {}
            Log.e((String)"MixpanelAPI.InAppButton", (String)"Error reading JSON when creating InAppButton from Parcel");
        }
        this.a = jSONObject;
        this.b = parcel.readString();
        this.c = parcel.readInt();
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
    }

    h(JSONObject jSONObject) {
        this.a = jSONObject;
        this.b = jSONObject.getString("text");
        this.c = jSONObject.getInt("text_color");
        this.d = jSONObject.getInt("bg_color");
        this.e = jSONObject.getInt("border_color");
        this.f = jSONObject.getString("cta_url");
    }

    public String a() {
        return this.b;
    }

    public int b() {
        return this.c;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.e;
    }

    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f;
    }

    public String toString() {
        return this.a.toString();
    }

    public void writeToParcel(Parcel parcel, int n2) {
        parcel.writeString(this.a.toString());
        parcel.writeString(this.b);
        parcel.writeInt(this.c);
        parcel.writeInt(this.d);
        parcel.writeInt(this.e);
        parcel.writeString(this.f);
    }

}

