package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.location.zzbh;
import java.util.ArrayList;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "GeofencingRequestCreator")
@SafeParcelable.Reserved({1000})
public class GeofencingRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GeofencingRequest> CREATOR = new zzq();
    public static final int INITIAL_TRIGGER_DWELL = 4;
    public static final int INITIAL_TRIGGER_ENTER = 1;
    public static final int INITIAL_TRIGGER_EXIT = 2;
    @SafeParcelable.Field(defaultValue = "", getter = "getTag", mo11969id = 3)
    private final String tag;
    @SafeParcelable.Field(getter = "getParcelableGeofences", mo11969id = 1)
    private final List<zzbh> zzap;
    @SafeParcelable.Field(getter = "getInitialTrigger", mo11969id = 2)
    private final int zzaq;

    public static final class Builder {
        private String tag = "";
        private final List<zzbh> zzap = new ArrayList();
        private int zzaq = 5;

        public final Builder addGeofence(Geofence geofence) {
            Preconditions.checkNotNull(geofence, "geofence can't be null.");
            Preconditions.checkArgument(geofence instanceof zzbh, "Geofence must be created using Geofence.Builder.");
            this.zzap.add((zzbh) geofence);
            return this;
        }

        public final Builder addGeofences(List<Geofence> list) {
            if (list != null && !list.isEmpty()) {
                for (Geofence next : list) {
                    if (next != null) {
                        addGeofence(next);
                    }
                }
            }
            return this;
        }

        public final GeofencingRequest build() {
            Preconditions.checkArgument(!this.zzap.isEmpty(), "No geofence has been added to this request.");
            return new GeofencingRequest(this.zzap, this.zzaq, this.tag);
        }

        public final Builder setInitialTrigger(int i) {
            this.zzaq = i & 7;
            return this;
        }
    }

    @SafeParcelable.Constructor
    GeofencingRequest(@SafeParcelable.Param(mo11972id = 1) List<zzbh> list, @SafeParcelable.Param(mo11972id = 2) int i, @SafeParcelable.Param(mo11972id = 3) String str) {
        this.zzap = list;
        this.zzaq = i;
        this.tag = str;
    }

    public List<Geofence> getGeofences() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.zzap);
        return arrayList;
    }

    public int getInitialTrigger() {
        return this.zzaq;
    }

    public String toString() {
        StringBuilder c = C0681a.m340c("GeofencingRequest[", "geofences=");
        c.append(this.zzap);
        int i = this.zzaq;
        StringBuilder sb = new StringBuilder(30);
        sb.append(", initialTrigger=");
        sb.append(i);
        sb.append(", ");
        c.append(sb.toString());
        String valueOf = String.valueOf(this.tag);
        return C0681a.m324a(c, valueOf.length() != 0 ? "tag=".concat(valueOf) : new String("tag="), "]");
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 1, this.zzap, false);
        SafeParcelWriter.writeInt(parcel, 2, getInitialTrigger());
        SafeParcelWriter.writeString(parcel, 3, this.tag, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
