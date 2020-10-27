package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.fitness.data.Field;
import com.google.android.gms.internal.fitness.zzbk;
import com.google.android.gms.internal.fitness.zzbl;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SafeParcelable.Class(creator = "DataTypeCreateRequestCreator")
@SafeParcelable.Reserved({4, 1000})
public class DataTypeCreateRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DataTypeCreateRequest> CREATOR = new zzr();
    @SafeParcelable.Field(getter = "getName", mo11969id = 1)
    private final String name;
    @SafeParcelable.Field(getter = "getFields", mo11969id = 2)
    private final List<Field> zzjv;
    @SafeParcelable.Field(getter = "getCallbackBinder", mo11969id = 3, type = "android.os.IBinder")
    @Nullable
    private final zzbl zzpj;

    public static class Builder {
        /* access modifiers changed from: private */
        public String name;
        /* access modifiers changed from: private */
        public List<Field> zzjv = new ArrayList();

        public Builder addField(Field field) {
            if (!this.zzjv.contains(field)) {
                this.zzjv.add(field);
            }
            return this;
        }

        public Builder addField(String str, int i) {
            Preconditions.checkArgument(str != null && !str.isEmpty(), "Invalid name specified");
            return addField(Field.zza(str, i));
        }

        public DataTypeCreateRequest build() {
            Preconditions.checkState(this.name != null, "Must set the name");
            Preconditions.checkState(!this.zzjv.isEmpty(), "Must specify the data fields");
            return new DataTypeCreateRequest(this);
        }

        public Builder setName(String str) {
            this.name = str;
            return this;
        }
    }

    private DataTypeCreateRequest(Builder builder) {
        this(builder.name, (List<Field>) builder.zzjv, (zzbl) null);
    }

    public DataTypeCreateRequest(DataTypeCreateRequest dataTypeCreateRequest, zzbl zzbl) {
        this(dataTypeCreateRequest.name, dataTypeCreateRequest.zzjv, zzbl);
    }

    @SafeParcelable.Constructor
    DataTypeCreateRequest(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) List<Field> list, @SafeParcelable.Param(mo11972id = 3) IBinder iBinder) {
        this.name = str;
        this.zzjv = Collections.unmodifiableList(list);
        this.zzpj = zzbk.zze(iBinder);
    }

    private DataTypeCreateRequest(String str, List<Field> list, @Nullable zzbl zzbl) {
        this.name = str;
        this.zzjv = Collections.unmodifiableList(list);
        this.zzpj = zzbl;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj != this) {
            if (obj instanceof DataTypeCreateRequest) {
                DataTypeCreateRequest dataTypeCreateRequest = (DataTypeCreateRequest) obj;
                if (Objects.equal(this.name, dataTypeCreateRequest.name) && Objects.equal(this.zzjv, dataTypeCreateRequest.zzjv)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }

    public List<Field> getFields() {
        return this.zzjv;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Objects.hashCode(this.name, this.zzjv);
    }

    public String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("fields", this.zzjv).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getName(), false);
        SafeParcelWriter.writeTypedList(parcel, 2, getFields(), false);
        zzbl zzbl = this.zzpj;
        SafeParcelWriter.writeIBinder(parcel, 3, zzbl == null ? null : zzbl.asBinder(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
