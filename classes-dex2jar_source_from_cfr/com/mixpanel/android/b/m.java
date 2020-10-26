/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.b.b;
import com.mixpanel.android.b.j;
import com.mixpanel.android.c.e;
import org.json.JSONException;
import org.json.JSONObject;

public class m
extends j {
    public static final Parcelable.Creator<m> CREATOR = new Parcelable.Creator<m>(){

        public m a(Parcel parcel) {
            return new m(parcel);
        }

        public m[] a(int n2) {
            return new m[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final String e;
    private final int f;
    private final int g;

    public m(Parcel parcel) {
        super(parcel);
        this.e = parcel.readString();
        this.f = parcel.readInt();
        this.g = parcel.readInt();
    }

    m(JSONObject jSONObject) {
        super(jSONObject);
        try {
            this.e = e.a(jSONObject, "cta_url");
            this.f = jSONObject.getInt("image_tint_color");
            this.g = jSONObject.getInt("border_color");
            return;
        }
        catch (JSONException jSONException) {
            throw new b("Notification JSON was unexpected or bad", (Throwable)jSONException);
        }
    }

    @Override
    public j.a d() {
        return j.a.b;
    }

    public String n() {
        return this.e;
    }

    public int o() {
        return this.f;
    }

    public int p() {
        return this.g;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeString(this.e);
        parcel.writeInt(this.f);
        parcel.writeInt(this.g);
    }

}

