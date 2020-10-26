// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.common.images;

import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import java.util.Locale;
import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import org.json.JSONException;
import org.json.JSONObject;
import android.net.Uri;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public final class WebImage extends zza
{
    public static final Parcelable$Creator<WebImage> CREATOR;
    private int zzaku;
    private final Uri zzauQ;
    private final int zzrW;
    private final int zzrX;
    
    static {
        CREATOR = (Parcelable$Creator)new zze();
    }
    
    WebImage(final int zzaku, final Uri zzauQ, final int zzrW, final int zzrX) {
        this.zzaku = zzaku;
        this.zzauQ = zzauQ;
        this.zzrW = zzrW;
        this.zzrX = zzrX;
    }
    
    public WebImage(final Uri uri) throws IllegalArgumentException {
        this(uri, 0, 0);
    }
    
    public WebImage(final Uri uri, final int n, final int n2) throws IllegalArgumentException {
        this(1, uri, n, n2);
        if (uri == null) {
            throw new IllegalArgumentException("url cannot be null");
        }
        if (n < 0 || n2 < 0) {
            throw new IllegalArgumentException("width and height must not be negative");
        }
    }
    
    public WebImage(final JSONObject jsonObject) throws IllegalArgumentException {
        this(zzp(jsonObject), jsonObject.optInt("width", 0), jsonObject.optInt("height", 0));
    }
    
    private static Uri zzp(final JSONObject jsonObject) {
        Uri parse = null;
        if (!jsonObject.has("url")) {
            return parse;
        }
        try {
            parse = Uri.parse(jsonObject.getString("url"));
            return parse;
        }
        catch (JSONException ex) {
            return null;
        }
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this != o) {
            if (o == null || !(o instanceof WebImage)) {
                return false;
            }
            final WebImage webImage = (WebImage)o;
            if (!zzbe.equal(this.zzauQ, webImage.zzauQ) || this.zzrW != webImage.zzrW || this.zzrX != webImage.zzrX) {
                return false;
            }
        }
        return true;
    }
    
    public final int getHeight() {
        return this.zzrX;
    }
    
    public final Uri getUrl() {
        return this.zzauQ;
    }
    
    public final int getWidth() {
        return this.zzrW;
    }
    
    @Override
    public final int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzauQ, this.zzrW, this.zzrX });
    }
    
    public final JSONObject toJson() {
        final JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("url", (Object)this.zzauQ.toString());
            jsonObject.put("width", this.zzrW);
            jsonObject.put("height", this.zzrX);
            return jsonObject;
        }
        catch (JSONException ex) {
            return jsonObject;
        }
    }
    
    @Override
    public final String toString() {
        return String.format(Locale.US, "Image %dx%d %s", this.zzrW, this.zzrX, this.zzauQ.toString());
    }
    
    public final void writeToParcel(final Parcel parcel, final int n) {
        final int zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, (Parcelable)this.getUrl(), n, false);
        zzd.zzc(parcel, 3, this.getWidth());
        zzd.zzc(parcel, 4, this.getHeight());
        zzd.zzI(parcel, zze);
    }
}
