package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaFormat;
import android.os.Parcel;
import android.os.Parcelable;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.LongCompanionObject;
import p009e.p010a.p011a.p012a.C0681a;

public final class zzhf implements Parcelable {
    public static final Parcelable.Creator<zzhf> CREATOR = new zzhe();
    public final int height;
    public final int width;
    private final String zzagd;
    public final int zzage;
    public final String zzagf;
    private final zzln zzagg;
    private final String zzagh;
    public final String zzagi;
    public final int zzagj;
    public final List<byte[]> zzagk;
    public final zzja zzagl;
    public final float zzagm;
    public final int zzagn;
    public final float zzago;
    private final int zzagp;
    private final byte[] zzagq;
    private final zzpa zzagr;
    public final int zzags;
    public final int zzagt;
    public final int zzagu;
    private final int zzagv;
    private final int zzagw;
    public final long zzagx;
    public final int zzagy;
    public final String zzagz;
    private final int zzaha;
    private int zzahb;

    zzhf(Parcel parcel) {
        this.zzagd = parcel.readString();
        this.zzagh = parcel.readString();
        this.zzagi = parcel.readString();
        this.zzagf = parcel.readString();
        this.zzage = parcel.readInt();
        this.zzagj = parcel.readInt();
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.zzagm = parcel.readFloat();
        this.zzagn = parcel.readInt();
        this.zzago = parcel.readFloat();
        this.zzagq = parcel.readInt() != 0 ? parcel.createByteArray() : null;
        this.zzagp = parcel.readInt();
        this.zzagr = (zzpa) parcel.readParcelable(zzpa.class.getClassLoader());
        this.zzags = parcel.readInt();
        this.zzagt = parcel.readInt();
        this.zzagu = parcel.readInt();
        this.zzagv = parcel.readInt();
        this.zzagw = parcel.readInt();
        this.zzagy = parcel.readInt();
        this.zzagz = parcel.readString();
        this.zzaha = parcel.readInt();
        this.zzagx = parcel.readLong();
        int readInt = parcel.readInt();
        this.zzagk = new ArrayList(readInt);
        for (int i = 0; i < readInt; i++) {
            this.zzagk.add(parcel.createByteArray());
        }
        this.zzagl = (zzja) parcel.readParcelable(zzja.class.getClassLoader());
        this.zzagg = (zzln) parcel.readParcelable(zzln.class.getClassLoader());
    }

    private zzhf(String str, String str2, String str3, String str4, int i, int i2, int i3, int i4, float f, int i5, float f2, byte[] bArr, int i6, zzpa zzpa, int i7, int i8, int i9, int i10, int i11, int i12, String str5, int i13, long j, List<byte[]> list, zzja zzja, zzln zzln) {
        this.zzagd = str;
        this.zzagh = str2;
        this.zzagi = str3;
        this.zzagf = str4;
        this.zzage = i;
        this.zzagj = i2;
        this.width = i3;
        this.height = i4;
        this.zzagm = f;
        this.zzagn = i5;
        this.zzago = f2;
        this.zzagq = bArr;
        this.zzagp = i6;
        this.zzagr = zzpa;
        this.zzags = i7;
        this.zzagt = i8;
        this.zzagu = i9;
        this.zzagv = i10;
        this.zzagw = i11;
        this.zzagy = i12;
        this.zzagz = str5;
        this.zzaha = i13;
        this.zzagx = j;
        this.zzagk = list == null ? Collections.emptyList() : list;
        this.zzagl = zzja;
        this.zzagg = zzln;
    }

    public static zzhf zza(String str, String str2, String str3, int i, int i2, int i3, int i4, float f, List<byte[]> list, int i5, float f2, byte[] bArr, int i6, zzpa zzpa, zzja zzja) {
        return new zzhf(str, (String) null, str2, (String) null, -1, i2, i3, i4, -1.0f, i5, f2, bArr, i6, zzpa, -1, -1, -1, -1, -1, 0, (String) null, -1, LongCompanionObject.MAX_VALUE, list, zzja, (zzln) null);
    }

    public static zzhf zza(String str, String str2, String str3, int i, int i2, int i3, int i4, int i5, List<byte[]> list, zzja zzja, int i6, String str4) {
        return new zzhf(str, (String) null, str2, (String) null, -1, i2, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpa) null, i3, i4, i5, -1, -1, i6, str4, -1, LongCompanionObject.MAX_VALUE, list, zzja, (zzln) null);
    }

    public static zzhf zza(String str, String str2, String str3, int i, int i2, int i3, int i4, List<byte[]> list, zzja zzja, int i5, String str4) {
        return zza(str, str2, (String) null, -1, -1, i3, i4, -1, (List<byte[]>) null, zzja, 0, str4);
    }

    public static zzhf zza(String str, String str2, String str3, int i, int i2, String str4, int i3, zzja zzja, long j, List<byte[]> list) {
        return new zzhf(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpa) null, -1, -1, -1, -1, -1, i2, str4, -1, j, list, zzja, (zzln) null);
    }

    public static zzhf zza(String str, String str2, String str3, int i, int i2, String str4, zzja zzja) {
        return zza(str, str2, (String) null, -1, i2, str4, -1, zzja, LongCompanionObject.MAX_VALUE, Collections.emptyList());
    }

    public static zzhf zza(String str, String str2, String str3, int i, zzja zzja) {
        return new zzhf(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpa) null, -1, -1, -1, -1, -1, 0, (String) null, -1, LongCompanionObject.MAX_VALUE, (List<byte[]>) null, (zzja) null, (zzln) null);
    }

    public static zzhf zza(String str, String str2, String str3, int i, List<byte[]> list, String str4, zzja zzja) {
        return new zzhf(str, (String) null, str2, (String) null, -1, -1, -1, -1, -1.0f, -1, -1.0f, (byte[]) null, -1, (zzpa) null, -1, -1, -1, -1, -1, 0, str4, -1, LongCompanionObject.MAX_VALUE, list, zzja, (zzln) null);
    }

    @TargetApi(16)
    private static void zza(MediaFormat mediaFormat, String str, int i) {
        if (i != -1) {
            mediaFormat.setInteger(str, i);
        }
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzhf.class == obj.getClass()) {
            zzhf zzhf = (zzhf) obj;
            if (this.zzage == zzhf.zzage && this.zzagj == zzhf.zzagj && this.width == zzhf.width && this.height == zzhf.height && this.zzagm == zzhf.zzagm && this.zzagn == zzhf.zzagn && this.zzago == zzhf.zzago && this.zzagp == zzhf.zzagp && this.zzags == zzhf.zzags && this.zzagt == zzhf.zzagt && this.zzagu == zzhf.zzagu && this.zzagv == zzhf.zzagv && this.zzagw == zzhf.zzagw && this.zzagx == zzhf.zzagx && this.zzagy == zzhf.zzagy && zzov.zza(this.zzagd, zzhf.zzagd) && zzov.zza(this.zzagz, zzhf.zzagz) && this.zzaha == zzhf.zzaha && zzov.zza(this.zzagh, zzhf.zzagh) && zzov.zza(this.zzagi, zzhf.zzagi) && zzov.zza(this.zzagf, zzhf.zzagf) && zzov.zza(this.zzagl, zzhf.zzagl) && zzov.zza(this.zzagg, zzhf.zzagg) && zzov.zza(this.zzagr, zzhf.zzagr) && Arrays.equals(this.zzagq, zzhf.zzagq) && this.zzagk.size() == zzhf.zzagk.size()) {
                for (int i = 0; i < this.zzagk.size(); i++) {
                    if (!Arrays.equals(this.zzagk.get(i), zzhf.zzagk.get(i))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.zzahb == 0) {
            String str = this.zzagd;
            int i = 0;
            int hashCode = ((str == null ? 0 : str.hashCode()) + 527) * 31;
            String str2 = this.zzagh;
            int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
            String str3 = this.zzagi;
            int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
            String str4 = this.zzagf;
            int hashCode4 = (((((((((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.zzage) * 31) + this.width) * 31) + this.height) * 31) + this.zzags) * 31) + this.zzagt) * 31;
            String str5 = this.zzagz;
            int hashCode5 = (((hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.zzaha) * 31;
            zzja zzja = this.zzagl;
            int hashCode6 = (hashCode5 + (zzja == null ? 0 : zzja.hashCode())) * 31;
            zzln zzln = this.zzagg;
            if (zzln != null) {
                i = zzln.hashCode();
            }
            this.zzahb = hashCode6 + i;
        }
        return this.zzahb;
    }

    public final String toString() {
        String str = this.zzagd;
        String str2 = this.zzagh;
        String str3 = this.zzagi;
        int i = this.zzage;
        String str4 = this.zzagz;
        int i2 = this.width;
        int i3 = this.height;
        float f = this.zzagm;
        int i4 = this.zzags;
        int i5 = this.zzagt;
        StringBuilder b = C0681a.m337b(C0681a.m336b(str4, C0681a.m336b(str3, C0681a.m336b(str2, C0681a.m336b(str, 100)))), "Format(", str, ", ", str2);
        b.append(", ");
        b.append(str3);
        b.append(", ");
        b.append(i);
        b.append(", ");
        b.append(str4);
        b.append(", [");
        b.append(i2);
        b.append(", ");
        b.append(i3);
        b.append(", ");
        b.append(f);
        b.append("], [");
        b.append(i4);
        b.append(", ");
        b.append(i5);
        b.append("])");
        return b.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.zzagd);
        parcel.writeString(this.zzagh);
        parcel.writeString(this.zzagi);
        parcel.writeString(this.zzagf);
        parcel.writeInt(this.zzage);
        parcel.writeInt(this.zzagj);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeFloat(this.zzagm);
        parcel.writeInt(this.zzagn);
        parcel.writeFloat(this.zzago);
        parcel.writeInt(this.zzagq != null ? 1 : 0);
        byte[] bArr = this.zzagq;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
        parcel.writeInt(this.zzagp);
        parcel.writeParcelable(this.zzagr, i);
        parcel.writeInt(this.zzags);
        parcel.writeInt(this.zzagt);
        parcel.writeInt(this.zzagu);
        parcel.writeInt(this.zzagv);
        parcel.writeInt(this.zzagw);
        parcel.writeInt(this.zzagy);
        parcel.writeString(this.zzagz);
        parcel.writeInt(this.zzaha);
        parcel.writeLong(this.zzagx);
        int size = this.zzagk.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            parcel.writeByteArray(this.zzagk.get(i2));
        }
        parcel.writeParcelable(this.zzagl, 0);
        parcel.writeParcelable(this.zzagg, 0);
    }

    public final zzhf zza(zzln zzln) {
        String str = this.zzagd;
        return new zzhf(str, this.zzagh, this.zzagi, this.zzagf, this.zzage, this.zzagj, this.width, this.height, this.zzagm, this.zzagn, this.zzago, this.zzagq, this.zzagp, this.zzagr, this.zzags, this.zzagt, this.zzagu, this.zzagv, this.zzagw, this.zzagy, this.zzagz, this.zzaha, this.zzagx, this.zzagk, this.zzagl, zzln);
    }

    public final zzhf zzb(int i, int i2) {
        String str = this.zzagd;
        return new zzhf(str, this.zzagh, this.zzagi, this.zzagf, this.zzage, this.zzagj, this.width, this.height, this.zzagm, this.zzagn, this.zzago, this.zzagq, this.zzagp, this.zzagr, this.zzags, this.zzagt, this.zzagu, i, i2, this.zzagy, this.zzagz, this.zzaha, this.zzagx, this.zzagk, this.zzagl, this.zzagg);
    }

    public final zzhf zzds(long j) {
        return new zzhf(this.zzagd, this.zzagh, this.zzagi, this.zzagf, this.zzage, this.zzagj, this.width, this.height, this.zzagm, this.zzagn, this.zzago, this.zzagq, this.zzagp, this.zzagr, this.zzags, this.zzagt, this.zzagu, this.zzagv, this.zzagw, this.zzagy, this.zzagz, this.zzaha, j, this.zzagk, this.zzagl, this.zzagg);
    }

    public final int zzey() {
        int i;
        int i2 = this.width;
        if (i2 == -1 || (i = this.height) == -1) {
            return -1;
        }
        return i2 * i;
    }

    @SuppressLint({"InlinedApi"})
    @TargetApi(16)
    public final MediaFormat zzez() {
        MediaFormat mediaFormat = new MediaFormat();
        mediaFormat.setString("mime", this.zzagi);
        String str = this.zzagz;
        if (str != null) {
            mediaFormat.setString("language", str);
        }
        zza(mediaFormat, "max-input-size", this.zzagj);
        zza(mediaFormat, "width", this.width);
        zza(mediaFormat, "height", this.height);
        float f = this.zzagm;
        if (f != -1.0f) {
            mediaFormat.setFloat("frame-rate", f);
        }
        zza(mediaFormat, "rotation-degrees", this.zzagn);
        zza(mediaFormat, "channel-count", this.zzags);
        zza(mediaFormat, "sample-rate", this.zzagt);
        zza(mediaFormat, "encoder-delay", this.zzagv);
        zza(mediaFormat, "encoder-padding", this.zzagw);
        for (int i = 0; i < this.zzagk.size(); i++) {
            mediaFormat.setByteBuffer(C0681a.m309a(15, "csd-", i), ByteBuffer.wrap(this.zzagk.get(i)));
        }
        zzpa zzpa = this.zzagr;
        if (zzpa != null) {
            zza(mediaFormat, "color-transfer", zzpa.zzaqz);
            zza(mediaFormat, "color-standard", zzpa.zzaqy);
            zza(mediaFormat, "color-range", zzpa.zzara);
            byte[] bArr = zzpa.zzbib;
            if (bArr != null) {
                mediaFormat.setByteBuffer("hdr-static-info", ByteBuffer.wrap(bArr));
            }
        }
        return mediaFormat;
    }

    public final zzhf zzr(int i) {
        String str = this.zzagd;
        return new zzhf(str, this.zzagh, this.zzagi, this.zzagf, this.zzage, i, this.width, this.height, this.zzagm, this.zzagn, this.zzago, this.zzagq, this.zzagp, this.zzagr, this.zzags, this.zzagt, this.zzagu, this.zzagv, this.zzagw, this.zzagy, this.zzagz, this.zzaha, this.zzagx, this.zzagk, this.zzagl, this.zzagg);
    }
}
