package com.google.android.gms.auth.api.accounttransfer;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.collection.ArraySet;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.internal.auth.zzaz;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "AuthenticatorTransferInfoCreator")
public class zzt extends zzaz {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaz;
    @SafeParcelable.Indicator
    private final Set<Integer> zzba;
    @SafeParcelable.Field(getter = "getAccountType", mo11969id = 2)
    private String zzbn;
    @SafeParcelable.Field(getter = "getStatus", mo11969id = 3)
    private int zzbo;
    @SafeParcelable.Field(getter = "getTransferBytes", mo11969id = 4)
    private byte[] zzbp;
    @SafeParcelable.Field(getter = "getPendingIntent", mo11969id = 5)
    private PendingIntent zzbq;
    @SafeParcelable.Field(getter = "getDeviceMetaData", mo11969id = 6)
    private DeviceMetaData zzbr;
    @SafeParcelable.VersionField(mo11975id = 1)
    private final int zzv;

    static {
        HashMap<String, FastJsonResponse.Field<?, ?>> hashMap = new HashMap<>();
        zzaz = hashMap;
        hashMap.put("accountType", FastJsonResponse.Field.forString("accountType", 2));
        zzaz.put(NotificationCompat.CATEGORY_STATUS, FastJsonResponse.Field.forInteger(NotificationCompat.CATEGORY_STATUS, 3));
        zzaz.put("transferBytes", FastJsonResponse.Field.forBase64("transferBytes", 4));
    }

    public zzt() {
        this.zzba = new ArraySet(3);
        this.zzv = 1;
    }

    @SafeParcelable.Constructor
    zzt(@SafeParcelable.Indicator Set<Integer> set, @SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) String str, @SafeParcelable.Param(mo11972id = 3) int i2, @SafeParcelable.Param(mo11972id = 4) byte[] bArr, @SafeParcelable.Param(mo11972id = 5) PendingIntent pendingIntent, @SafeParcelable.Param(mo11972id = 6) DeviceMetaData deviceMetaData) {
        this.zzba = set;
        this.zzv = i;
        this.zzbn = str;
        this.zzbo = i2;
        this.zzbp = bArr;
        this.zzbq = pendingIntent;
        this.zzbr = deviceMetaData;
    }

    public /* synthetic */ Map getFieldMappings() {
        return zzaz;
    }

    /* access modifiers changed from: protected */
    public Object getFieldValue(FastJsonResponse.Field field) {
        int i;
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 1) {
            i = this.zzv;
        } else if (safeParcelableFieldId == 2) {
            return this.zzbn;
        } else {
            if (safeParcelableFieldId == 3) {
                i = this.zzbo;
            } else if (safeParcelableFieldId == 4) {
                return this.zzbp;
            } else {
                throw new IllegalStateException(C0681a.m309a(37, "Unknown SafeParcelable id=", field.getSafeParcelableFieldId()));
            }
        }
        return Integer.valueOf(i);
    }

    /* access modifiers changed from: protected */
    public boolean isFieldSet(FastJsonResponse.Field field) {
        return this.zzba.contains(Integer.valueOf(field.getSafeParcelableFieldId()));
    }

    /* access modifiers changed from: protected */
    public void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> field, String str, byte[] bArr) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 4) {
            this.zzbp = bArr;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(C0681a.m310a(59, "Field with id=", safeParcelableFieldId, " is not known to be an byte array."));
    }

    /* access modifiers changed from: protected */
    public void setIntegerInternal(FastJsonResponse.Field<?, ?> field, String str, int i) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 3) {
            this.zzbo = i;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(C0681a.m310a(52, "Field with id=", safeParcelableFieldId, " is not known to be an int."));
    }

    /* access modifiers changed from: protected */
    public void setStringInternal(FastJsonResponse.Field<?, ?> field, String str, String str2) {
        int safeParcelableFieldId = field.getSafeParcelableFieldId();
        if (safeParcelableFieldId == 2) {
            this.zzbn = str2;
            this.zzba.add(Integer.valueOf(safeParcelableFieldId));
            return;
        }
        throw new IllegalArgumentException(String.format("Field with id=%d is not known to be a string.", new Object[]{Integer.valueOf(safeParcelableFieldId)}));
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        Set<Integer> set = this.zzba;
        if (set.contains(1)) {
            SafeParcelWriter.writeInt(parcel, 1, this.zzv);
        }
        if (set.contains(2)) {
            SafeParcelWriter.writeString(parcel, 2, this.zzbn, true);
        }
        if (set.contains(3)) {
            SafeParcelWriter.writeInt(parcel, 3, this.zzbo);
        }
        if (set.contains(4)) {
            SafeParcelWriter.writeByteArray(parcel, 4, this.zzbp, true);
        }
        if (set.contains(5)) {
            SafeParcelWriter.writeParcelable(parcel, 5, this.zzbq, i, true);
        }
        if (set.contains(6)) {
            SafeParcelWriter.writeParcelable(parcel, 6, this.zzbr, i, true);
        }
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
