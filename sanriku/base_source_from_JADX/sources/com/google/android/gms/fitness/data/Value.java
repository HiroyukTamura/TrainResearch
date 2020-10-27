package com.google.android.gms.fitness.data;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.HexDumpUtils;
import com.google.android.gms.internal.fitness.zzjn;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@SafeParcelable.Class(creator = "ValueCreator")
@SafeParcelable.Reserved({1000})
public final class Value extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Value> CREATOR = new zzal();
    @SafeParcelable.Field(getter = "getFormat", mo11969id = 1)
    private final int format;
    @SafeParcelable.Field(getter = "getValue", mo11969id = 3)
    private float value;
    @SafeParcelable.Field(getter = "isSet", mo11969id = 2)
    private boolean zzmo;
    @SafeParcelable.Field(getter = "getStringValue", mo11969id = 4)
    private String zzmp;
    @SafeParcelable.Field(getter = "getMapValue", mo11969id = 5, type = "android.os.Bundle")
    private Map<String, MapValue> zzmq;
    @SafeParcelable.Field(getter = "getIntArrayValue", mo11969id = 6)
    private int[] zzmr;
    @SafeParcelable.Field(getter = "getFloatArrayValue", mo11969id = 7)
    private float[] zzms;
    @SafeParcelable.Field(getter = "getBlob", mo11969id = 8)
    private byte[] zzmt;

    @ShowFirstParty
    public Value(int i) {
        this(i, false, 0.0f, (String) null, (Bundle) null, (int[]) null, (float[]) null, (byte[]) null);
    }

    @SafeParcelable.Constructor
    Value(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) boolean z, @SafeParcelable.Param(mo11972id = 3) float f, @SafeParcelable.Param(mo11972id = 4) String str, @SafeParcelable.Param(mo11972id = 5) Bundle bundle, @SafeParcelable.Param(mo11972id = 6) int[] iArr, @SafeParcelable.Param(mo11972id = 7) float[] fArr, @SafeParcelable.Param(mo11972id = 8) byte[] bArr) {
        ArrayMap arrayMap;
        this.format = i;
        this.zzmo = z;
        this.value = f;
        this.zzmp = str;
        if (bundle == null) {
            arrayMap = null;
        } else {
            bundle.setClassLoader(MapValue.class.getClassLoader());
            arrayMap = new ArrayMap(bundle.size());
            for (String str2 : bundle.keySet()) {
                arrayMap.put(str2, (MapValue) bundle.getParcelable(str2));
            }
        }
        this.zzmq = arrayMap;
        this.zzmr = iArr;
        this.zzms = fArr;
        this.zzmt = bArr;
    }

    public final String asActivity() {
        return zzjn.getName(asInt());
    }

    public final float asFloat() {
        Preconditions.checkState(this.format == 2, "Value is not in float format");
        return this.value;
    }

    public final int asInt() {
        boolean z = true;
        if (this.format != 1) {
            z = false;
        }
        Preconditions.checkState(z, "Value is not in int format");
        return Float.floatToRawIntBits(this.value);
    }

    public final String asString() {
        Preconditions.checkState(this.format == 3, "Value is not in string format");
        return this.zzmp;
    }

    @Deprecated
    public final void clearKey(String str) {
        Preconditions.checkState(this.format == 4, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        Map<String, MapValue> map = this.zzmq;
        if (map != null) {
            map.remove(str);
        }
    }

    public final boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Value)) {
            return false;
        }
        Value value2 = (Value) obj;
        int i = this.format;
        if (i == value2.format && this.zzmo == value2.zzmo) {
            switch (i) {
                case 1:
                    if (asInt() == value2.asInt()) {
                        return true;
                    }
                    break;
                case 2:
                    return this.value == value2.value;
                case 3:
                    return Objects.equal(this.zzmp, value2.zzmp);
                case 4:
                    return Objects.equal(this.zzmq, value2.zzmq);
                case 5:
                    return Arrays.equals(this.zzmr, value2.zzmr);
                case 6:
                    return Arrays.equals(this.zzms, value2.zzms);
                case 7:
                    return Arrays.equals(this.zzmt, value2.zzmt);
                default:
                    if (this.value == value2.value) {
                        return true;
                    }
                    break;
            }
        }
        return false;
    }

    public final int getFormat() {
        return this.format;
    }

    @Nullable
    public final Float getKeyValue(String str) {
        Preconditions.checkState(this.format == 4, "Value is not in float map format");
        Map<String, MapValue> map = this.zzmq;
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return Float.valueOf(this.zzmq.get(str).asFloat());
    }

    public final int hashCode() {
        return Objects.hashCode(Float.valueOf(this.value), this.zzmp, this.zzmq, this.zzmr, this.zzms, this.zzmt);
    }

    public final boolean isSet() {
        return this.zzmo;
    }

    @Deprecated
    public final void setActivity(String str) {
        setInt(zzjn.zzp(str));
    }

    @Deprecated
    public final void setFloat(float f) {
        Preconditions.checkState(this.format == 2, "Attempting to set an float value to a field that is not in FLOAT format.  Please check the data type definition and use the right format.");
        this.zzmo = true;
        this.value = f;
    }

    @Deprecated
    public final void setInt(int i) {
        Preconditions.checkState(this.format == 1, "Attempting to set an int value to a field that is not in INT32 format.  Please check the data type definition and use the right format.");
        this.zzmo = true;
        this.value = Float.intBitsToFloat(i);
    }

    @Deprecated
    public final void setKeyValue(String str, float f) {
        Preconditions.checkState(this.format == 4, "Attempting to set a key's value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzmo = true;
        if (this.zzmq == null) {
            this.zzmq = new HashMap();
        }
        this.zzmq.put(str, MapValue.zza(f));
    }

    @Deprecated
    public final void setString(String str) {
        Preconditions.checkState(this.format == 3, "Attempting to set a string value to a field that is not in STRING format.  Please check the data type definition and use the right format.");
        this.zzmo = true;
        this.zzmp = str;
    }

    public final String toString() {
        if (!this.zzmo) {
            return "unset";
        }
        switch (this.format) {
            case 1:
                return Integer.toString(asInt());
            case 2:
                return Float.toString(this.value);
            case 3:
                return this.zzmp;
            case 4:
                return new TreeMap(this.zzmq).toString();
            case 5:
                return Arrays.toString(this.zzmr);
            case 6:
                return Arrays.toString(this.zzms);
            case 7:
                byte[] bArr = this.zzmt;
                return HexDumpUtils.dump(bArr, 0, bArr.length, false);
            default:
                return "unknown";
        }
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Bundle bundle;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, getFormat());
        SafeParcelWriter.writeBoolean(parcel, 2, isSet());
        SafeParcelWriter.writeFloat(parcel, 3, this.value);
        SafeParcelWriter.writeString(parcel, 4, this.zzmp, false);
        if (this.zzmq == null) {
            bundle = null;
        } else {
            bundle = new Bundle(this.zzmq.size());
            for (Map.Entry next : this.zzmq.entrySet()) {
                bundle.putParcelable((String) next.getKey(), (Parcelable) next.getValue());
            }
        }
        SafeParcelWriter.writeBundle(parcel, 5, bundle, false);
        SafeParcelWriter.writeIntArray(parcel, 6, this.zzmr, false);
        SafeParcelWriter.writeFloatArray(parcel, 7, this.zzms, false);
        SafeParcelWriter.writeByteArray(parcel, 8, this.zzmt, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    @ShowFirstParty
    @Deprecated
    public final void zza(Map<String, Float> map) {
        Preconditions.checkState(this.format == 4, "Attempting to set a float map value to a field that is not in FLOAT_MAP format.  Please check the data type definition and use the right format.");
        this.zzmo = true;
        this.zzmq = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            this.zzmq.put((String) next.getKey(), MapValue.zza(((Float) next.getValue()).floatValue()));
        }
    }
}
