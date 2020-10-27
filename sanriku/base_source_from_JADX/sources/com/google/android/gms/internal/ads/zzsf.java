package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

@SafeParcelable.Class(creator = "CacheOfferingCreator")
@SafeParcelable.Reserved({1})
public final class zzsf extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzsf> CREATOR = new zzsi();
    @SafeParcelable.Field(mo11969id = 2)
    @Nullable
    public final String url;
    @SafeParcelable.Field(mo11969id = 3)
    private final long zzbsm;
    @SafeParcelable.Field(mo11969id = 4)
    private final String zzbsn;
    @SafeParcelable.Field(mo11969id = 5)
    private final String zzbso;
    @SafeParcelable.Field(mo11969id = 6)
    private final String zzbsp;
    @SafeParcelable.Field(mo11969id = 7)
    private final Bundle zzbsq;
    @SafeParcelable.Field(mo11969id = 8)
    public final boolean zzbsr;
    @SafeParcelable.Field(mo11969id = 9)
    public long zzbss;

    @SafeParcelable.Constructor
    zzsf(@SafeParcelable.Param(mo11972id = 2) @Nullable String str, @SafeParcelable.Param(mo11972id = 3) long j, @SafeParcelable.Param(mo11972id = 4) String str2, @SafeParcelable.Param(mo11972id = 5) String str3, @SafeParcelable.Param(mo11972id = 6) String str4, @SafeParcelable.Param(mo11972id = 7) Bundle bundle, @SafeParcelable.Param(mo11972id = 8) boolean z, @SafeParcelable.Param(mo11972id = 9) long j2) {
        this.url = str;
        this.zzbsm = j;
        this.zzbsn = str2 == null ? "" : str2;
        this.zzbso = str3 == null ? "" : str3;
        this.zzbsp = str4 == null ? "" : str4;
        this.zzbsq = bundle == null ? new Bundle() : bundle;
        this.zzbsr = z;
        this.zzbss = j2;
    }

    @Nullable
    public static zzsf zzbu(String str) {
        return zzd(Uri.parse(str));
    }

    @Nullable
    public static zzsf zzd(Uri uri) {
        try {
            if (!"gcache".equals(uri.getScheme())) {
                return null;
            }
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments.size() != 2) {
                int size = pathSegments.size();
                StringBuilder sb = new StringBuilder(62);
                sb.append("Expected 2 path parts for namespace and id, found :");
                sb.append(size);
                zzazw.zzfc(sb.toString());
                return null;
            }
            String str = pathSegments.get(0);
            String str2 = pathSegments.get(1);
            String host = uri.getHost();
            String queryParameter = uri.getQueryParameter(ImagesContract.URL);
            boolean equals = "1".equals(uri.getQueryParameter("read_only"));
            String queryParameter2 = uri.getQueryParameter("expiration");
            long parseLong = queryParameter2 == null ? 0 : Long.parseLong(queryParameter2);
            Bundle bundle = new Bundle();
            zzq.zzky();
            for (String next : uri.getQueryParameterNames()) {
                if (next.startsWith("tag.")) {
                    bundle.putString(next.substring(4), uri.getQueryParameter(next));
                }
            }
            return new zzsf(queryParameter, parseLong, host, str, str2, bundle, equals, 0);
        } catch (NullPointerException | NumberFormatException e) {
            zzazw.zzd("Unable to parse Uri into cache offering.", e);
            return null;
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.url, false);
        SafeParcelWriter.writeLong(parcel, 3, this.zzbsm);
        SafeParcelWriter.writeString(parcel, 4, this.zzbsn, false);
        SafeParcelWriter.writeString(parcel, 5, this.zzbso, false);
        SafeParcelWriter.writeString(parcel, 6, this.zzbsp, false);
        SafeParcelWriter.writeBundle(parcel, 7, this.zzbsq, false);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzbsr);
        SafeParcelWriter.writeLong(parcel, 9, this.zzbss);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
