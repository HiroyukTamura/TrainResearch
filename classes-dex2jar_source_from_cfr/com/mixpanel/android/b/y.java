/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  org.json.JSONArray
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.mixpanel.android.b.b;
import com.mixpanel.android.b.h;
import com.mixpanel.android.b.j;
import com.mixpanel.android.c.e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class y
extends j {
    public static final Parcelable.Creator<y> CREATOR = new Parcelable.Creator<y>(){

        public y a(Parcel parcel) {
            return new y(parcel);
        }

        public y[] a(int n2) {
            return new y[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    private final ArrayList<h> e;
    private final int f;
    private final String g;
    private final int h;
    private final boolean i;

    public y(Parcel parcel) {
        super(parcel);
        this.e = parcel.createTypedArrayList(h.CREATOR);
        this.f = parcel.readInt();
        this.g = parcel.readString();
        this.h = parcel.readInt();
        boolean bl2 = parcel.readByte() != 0;
        this.i = bl2;
    }

    y(JSONObject jSONObject) {
        super(jSONObject);
        JSONArray jSONArray = jSONObject.getJSONArray("buttons");
        this.e = new ArrayList();
        int n2 = 0;
        do {
            if (n2 >= jSONArray.length()) break;
            JSONObject jSONObject2 = (JSONObject)jSONArray.get(n2);
            this.e.add(new h(jSONObject2));
            ++n2;
            continue;
            break;
        } while (true);
        try {
            this.f = jSONObject.getInt("close_color");
            this.g = e.a(jSONObject, "title");
            this.h = jSONObject.optInt("title_color");
            this.i = this.m().getBoolean("image_fade");
            return;
        }
        catch (JSONException jSONException) {
            throw new b("Notification JSON was unexpected or bad", (Throwable)jSONException);
        }
    }

    public h a(int n2) {
        if (this.e.size() > n2) {
            return this.e.get(n2);
        }
        return null;
    }

    @Override
    public j.a d() {
        return j.a.c;
    }

    public boolean n() {
        return this.g != null;
    }

    public String o() {
        return this.g;
    }

    public int p() {
        return this.h;
    }

    public int q() {
        return this.f;
    }

    public int r() {
        return this.e.size();
    }

    public boolean s() {
        return this.i;
    }

    @Override
    public void writeToParcel(Parcel parcel, int n2) {
        super.writeToParcel(parcel, n2);
        parcel.writeTypedList(this.e);
        parcel.writeInt(this.f);
        parcel.writeString(this.g);
        parcel.writeInt(this.h);
        parcel.writeByte((byte)(this.i ? 1 : 0));
    }

}

