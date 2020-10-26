// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.location.places;

import com.google.android.gms.common.internal.safeparcel.zzd;
import android.os.Parcel;
import com.google.android.gms.common.internal.zzbg;
import java.util.Arrays;
import com.google.android.gms.common.internal.zzbe;
import com.google.android.gms.common.internal.zzbo;
import android.os.Parcelable$Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.zza;

public class PlaceReport extends zza implements ReflectedParcelable
{
    public static final Parcelable$Creator<PlaceReport> CREATOR;
    private final String mTag;
    private final String zzaeK;
    private int zzaku;
    private final String zzbjI;
    
    static {
        CREATOR = (Parcelable$Creator)new zzl();
    }
    
    PlaceReport(final int zzaku, final String zzbjI, final String mTag, final String zzaeK) {
        this.zzaku = zzaku;
        this.zzbjI = zzbjI;
        this.mTag = mTag;
        this.zzaeK = zzaeK;
    }
    
    public static PlaceReport create(final String s, final String s2) {
        boolean b = false;
        zzbo.zzu(s);
        zzbo.zzcF(s2);
        zzbo.zzcF("unknown");
        int n = -1;
        switch ("unknown".hashCode()) {
            case -284840886: {
                if ("unknown".equals("unknown")) {
                    n = 0;
                    break;
                }
                break;
            }
            case -1194968642: {
                if ("unknown".equals("userReported")) {
                    n = 1;
                    break;
                }
                break;
            }
            case -1436706272: {
                if ("unknown".equals("inferredGeofencing")) {
                    n = 2;
                    break;
                }
                break;
            }
            case 1287171955: {
                if ("unknown".equals("inferredRadioSignals")) {
                    n = 3;
                    break;
                }
                break;
            }
            case -262743844: {
                if ("unknown".equals("inferredReverseGeocoding")) {
                    n = 4;
                    break;
                }
                break;
            }
            case 1164924125: {
                if ("unknown".equals("inferredSnappedToRoad")) {
                    n = 5;
                    break;
                }
                break;
            }
        }
        switch (n) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                b = true;
                break;
            }
        }
        zzbo.zzb(b, (Object)"Invalid source");
        return new PlaceReport(1, s, s2, "unknown");
    }
    
    @Override
    public boolean equals(final Object o) {
        if (o instanceof PlaceReport) {
            final PlaceReport placeReport = (PlaceReport)o;
            if (zzbe.equal(this.zzbjI, placeReport.zzbjI) && zzbe.equal(this.mTag, placeReport.mTag) && zzbe.equal(this.zzaeK, placeReport.zzaeK)) {
                return true;
            }
        }
        return false;
    }
    
    public String getPlaceId() {
        return this.zzbjI;
    }
    
    public String getTag() {
        return this.mTag;
    }
    
    @Override
    public int hashCode() {
        return Arrays.hashCode(new Object[] { this.zzbjI, this.mTag, this.zzaeK });
    }
    
    @Override
    public String toString() {
        final zzbg zzt = zzbe.zzt(this);
        zzt.zzg("placeId", this.zzbjI);
        zzt.zzg("tag", this.mTag);
        if (!"unknown".equals(this.zzaeK)) {
            zzt.zzg("source", this.zzaeK);
        }
        return zzt.toString();
    }
    
    public void writeToParcel(final Parcel parcel, int zze) {
        zze = zzd.zze(parcel);
        zzd.zzc(parcel, 1, this.zzaku);
        zzd.zza(parcel, 2, this.getPlaceId(), false);
        zzd.zza(parcel, 3, this.getTag(), false);
        zzd.zza(parcel, 4, this.zzaeK, false);
        zzd.zzI(parcel, zze);
    }
}
