package com.google.android.gms.fitness.data;

import android.content.Context;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "DataSourceCreator")
@SafeParcelable.Reserved({7, 1000})
public class DataSource extends AbstractSafeParcelable {
    @ShowFirstParty
    public static final Parcelable.Creator<DataSource> CREATOR = new zzk();
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_GLUCOSE_ISO151972003 = 8;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_GLUCOSE_ISO151972013 = 9;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_AAMI = 3;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_A_A = 4;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_A_B = 5;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_B_A = 6;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_BHS_B_B = 7;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_ESH2002 = 1;
    @Deprecated
    public static final int DATA_QUALITY_BLOOD_PRESSURE_ESH2010 = 2;
    public static final String EXTRA_DATA_SOURCE = "vnd.google.fitness.data_source";
    public static final int TYPE_DERIVED = 1;
    public static final int TYPE_RAW = 0;
    private static final int[] zzje = new int[0];
    @SafeParcelable.Field(getter = "getName", mo11969id = 2)
    @Nullable
    private final String name;
    @SafeParcelable.Field(getter = "getType", mo11969id = 3)
    private final int type;
    @SafeParcelable.Field(getter = "getDataType", mo11969id = 1)
    private final DataType zzhz;
    @SafeParcelable.Field(getter = "getDevice", mo11969id = 4)
    @Nullable
    private final Device zzjf;
    @SafeParcelable.Field(getter = "getApplication", mo11969id = 5)
    @Nullable
    private final zzc zzjg;
    @SafeParcelable.Field(getter = "getStreamName", mo11969id = 6)
    private final String zzjh;
    @SafeParcelable.Field(getter = "getDataQualityStandards", mo11969id = 8)
    private final int[] zzji;
    private final String zzjj;

    public static final class Builder {
        /* access modifiers changed from: private */
        @Nullable
        public String name;
        /* access modifiers changed from: private */
        public int type = -1;
        /* access modifiers changed from: private */
        public DataType zzhz;
        /* access modifiers changed from: private */
        public Device zzjf;
        /* access modifiers changed from: private */
        public zzc zzjg;
        /* access modifiers changed from: private */
        public String zzjh = "";
        /* access modifiers changed from: private */
        public int[] zzji;

        public final DataSource build() {
            boolean z = true;
            Preconditions.checkState(this.zzhz != null, "Must set data type");
            if (this.type < 0) {
                z = false;
            }
            Preconditions.checkState(z, "Must set data source type");
            return new DataSource(this);
        }

        public final Builder setAppPackageName(Context context) {
            return setAppPackageName(context.getPackageName());
        }

        public final Builder setAppPackageName(String str) {
            this.zzjg = zzc.zza(str);
            return this;
        }

        @Deprecated
        public final Builder setDataQualityStandards(int... iArr) {
            this.zzji = iArr;
            return this;
        }

        public final Builder setDataType(DataType dataType) {
            this.zzhz = dataType;
            return this;
        }

        public final Builder setDevice(Device device) {
            this.zzjf = device;
            return this;
        }

        @Deprecated
        public final Builder setName(@Nullable String str) {
            this.name = str;
            return this;
        }

        public final Builder setStreamName(String str) {
            Preconditions.checkArgument(str != null, "Must specify a valid stream name");
            this.zzjh = str;
            return this;
        }

        public final Builder setType(int i) {
            this.type = i;
            return this;
        }
    }

    private DataSource(Builder builder) {
        this.zzhz = builder.zzhz;
        this.type = builder.type;
        this.name = builder.name;
        this.zzjf = builder.zzjf;
        this.zzjg = builder.zzjg;
        this.zzjh = builder.zzjh;
        this.zzjj = zzm();
        this.zzji = builder.zzji;
    }

    @SafeParcelable.Constructor
    public DataSource(@SafeParcelable.Param(mo11972id = 1) DataType dataType, @SafeParcelable.Param(mo11972id = 2) @Nullable String str, @SafeParcelable.Param(mo11972id = 3) int i, @SafeParcelable.Param(mo11972id = 4) @Nullable Device device, @SafeParcelable.Param(mo11972id = 5) @Nullable zzc zzc, @SafeParcelable.Param(mo11972id = 6) String str2, @SafeParcelable.Param(mo11972id = 8) @Nullable int[] iArr) {
        this.zzhz = dataType;
        this.type = i;
        this.name = str;
        this.zzjf = device;
        this.zzjg = zzc;
        this.zzjh = str2;
        this.zzjj = zzm();
        this.zzji = iArr == null ? zzje : iArr;
    }

    @Nullable
    public static DataSource extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (DataSource) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_DATA_SOURCE, CREATOR);
    }

    private final String getTypeString() {
        return this.type != 0 ? "derived" : "raw";
    }

    public static String zzd(int i) {
        switch (i) {
            case 1:
                return "blood_pressure_esh2002";
            case 2:
                return "blood_pressure_esh2010";
            case 3:
                return "blood_pressure_aami";
            case 4:
                return "blood_pressure_bhs_a_a";
            case 5:
                return "blood_pressure_bhs_a_b";
            case 6:
                return "blood_pressure_bhs_b_a";
            case 7:
                return "blood_pressure_bhs_b_b";
            case 8:
                return "blood_glucose_iso151972003";
            case 9:
                return "blood_glucose_iso151972013";
            default:
                return "unknown";
        }
    }

    private final String zzm() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTypeString());
        sb.append(":");
        sb.append(this.zzhz.getName());
        if (this.zzjg != null) {
            sb.append(":");
            sb.append(this.zzjg.getPackageName());
        }
        if (this.zzjf != null) {
            sb.append(":");
            sb.append(this.zzjf.getStreamIdentifier());
        }
        if (this.zzjh != null) {
            sb.append(":");
            sb.append(this.zzjh);
        }
        return sb.toString();
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DataSource)) {
            return false;
        }
        return this.zzjj.equals(((DataSource) obj).zzjj);
    }

    @Nullable
    public String getAppPackageName() {
        zzc zzc = this.zzjg;
        if (zzc == null) {
            return null;
        }
        return zzc.getPackageName();
    }

    @Deprecated
    public int[] getDataQualityStandards() {
        return this.zzji;
    }

    public DataType getDataType() {
        return this.zzhz;
    }

    @Nullable
    public Device getDevice() {
        return this.zzjf;
    }

    @Deprecated
    @Nullable
    public String getName() {
        return this.name;
    }

    public String getStreamIdentifier() {
        return this.zzjj;
    }

    public String getStreamName() {
        return this.zzjh;
    }

    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.zzjj.hashCode();
    }

    @ShowFirstParty
    public final String toDebugString() {
        String str;
        String str2;
        int i = this.type;
        String str3 = i != 0 ? i != 1 ? "?" : "d" : "r";
        String zzp = this.zzhz.zzp();
        zzc zzc = this.zzjg;
        String str4 = "";
        if (zzc == null) {
            str = str4;
        } else if (zzc.equals(zzc.zzil)) {
            str = ":gms";
        } else {
            String valueOf = String.valueOf(this.zzjg.getPackageName());
            str = valueOf.length() != 0 ? ":".concat(valueOf) : new String(":");
        }
        Device device = this.zzjf;
        if (device != null) {
            String model = device.getModel();
            String uid = this.zzjf.getUid();
            str2 = C0681a.m314a(C0681a.m336b(uid, C0681a.m336b(model, 2)), ":", model, ":", uid);
        } else {
            str2 = str4;
        }
        String str5 = this.zzjh;
        if (str5 != null) {
            String valueOf2 = String.valueOf(str5);
            str4 = valueOf2.length() != 0 ? ":".concat(valueOf2) : new String(":");
        }
        return C0681a.m324a(C0681a.m337b(C0681a.m336b(str4, C0681a.m336b(str2, C0681a.m336b(str, C0681a.m336b(zzp, str3.length() + 1)))), str3, ":", zzp, str), str2, str4);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("DataSource{");
        sb.append(getTypeString());
        if (this.name != null) {
            sb.append(":");
            sb.append(this.name);
        }
        if (this.zzjg != null) {
            sb.append(":");
            sb.append(this.zzjg);
        }
        if (this.zzjf != null) {
            sb.append(":");
            sb.append(this.zzjf);
        }
        if (this.zzjh != null) {
            sb.append(":");
            sb.append(this.zzjh);
        }
        sb.append(":");
        sb.append(this.zzhz);
        sb.append("}");
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, getDataType(), i, false);
        SafeParcelWriter.writeString(parcel, 2, getName(), false);
        SafeParcelWriter.writeInt(parcel, 3, getType());
        SafeParcelWriter.writeParcelable(parcel, 4, getDevice(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzjg, i, false);
        SafeParcelWriter.writeString(parcel, 6, getStreamName(), false);
        SafeParcelWriter.writeIntArray(parcel, 8, getDataQualityStandards(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    @Nullable
    public final zzc zzl() {
        return this.zzjg;
    }
}
