package com.google.android.gms.fitness.data;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.internal.fitness.zzjn;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.TimeUnit;
import p009e.p010a.p011a.p012a.C0681a;

@SafeParcelable.Class(creator = "SessionCreator")
@SafeParcelable.Reserved({1000})
public class Session extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Session> CREATOR = new zzae();
    public static final String EXTRA_SESSION = "vnd.google.fitness.session";
    public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.session/";
    @SafeParcelable.Field(getter = "getDescription", mo11969id = 5)
    private final String description;
    @SafeParcelable.Field(getter = "getName", mo11969id = 3)
    @Nullable
    private final String name;
    @SafeParcelable.Field(getter = "getStartTimeMillis", mo11969id = 1)
    private final long zzib;
    @SafeParcelable.Field(getter = "getEndTimeMillis", mo11969id = 2)
    private final long zzic;
    @SafeParcelable.Field(getter = "getActivityType", mo11969id = 7)
    private final int zzip;
    @SafeParcelable.Field(getter = "getApplication", mo11969id = 8)
    private final zzc zzjg;
    @SafeParcelable.Field(getter = "getIdentifier", mo11969id = 4)
    private final String zzma;
    @SafeParcelable.Field(getter = "getActiveTimeMillis", mo11969id = 9)
    @Nullable
    private final Long zzmb;

    public static class Builder {
        /* access modifiers changed from: private */
        public String description = "";
        /* access modifiers changed from: private */
        @Nullable
        public String name = null;
        /* access modifiers changed from: private */
        public long zzib = 0;
        /* access modifiers changed from: private */
        public long zzic = 0;
        /* access modifiers changed from: private */
        public int zzip = 4;
        /* access modifiers changed from: private */
        @Nullable
        public String zzma = null;
        /* access modifiers changed from: private */
        @Nullable
        public Long zzmb;

        public Session build() {
            boolean z = true;
            Preconditions.checkState(this.zzib > 0, "Start time should be specified.");
            long j = this.zzic;
            if (j != 0 && j <= this.zzib) {
                z = false;
            }
            Preconditions.checkState(z, "End time should be later than start time.");
            if (this.zzma == null) {
                String str = this.name;
                if (str == null) {
                    str = "";
                }
                long j2 = this.zzib;
                StringBuilder sb = new StringBuilder(C0681a.m336b(str, 20));
                sb.append(str);
                sb.append(j2);
                this.zzma = sb.toString();
            }
            return new Session(this);
        }

        public Builder setActiveTime(long j, TimeUnit timeUnit) {
            this.zzmb = Long.valueOf(timeUnit.toMillis(j));
            return this;
        }

        public Builder setActivity(String str) {
            this.zzip = zzjn.zzp(str);
            return this;
        }

        public Builder setDescription(String str) {
            Preconditions.checkArgument(str.length() <= 1000, "Session description cannot exceed %d characters", 1000);
            this.description = str;
            return this;
        }

        public Builder setEndTime(long j, TimeUnit timeUnit) {
            Preconditions.checkState(j >= 0, "End time should be positive.");
            this.zzic = timeUnit.toMillis(j);
            return this;
        }

        public Builder setIdentifier(String str) {
            Preconditions.checkArgument(str != null && TextUtils.getTrimmedLength(str) > 0);
            this.zzma = str;
            return this;
        }

        public Builder setName(String str) {
            Preconditions.checkArgument(str.length() <= 100, "Session name cannot exceed %d characters", 100);
            this.name = str;
            return this;
        }

        public Builder setStartTime(long j, TimeUnit timeUnit) {
            Preconditions.checkState(j > 0, "Start time should be positive.");
            this.zzib = timeUnit.toMillis(j);
            return this;
        }
    }

    @SafeParcelable.Constructor
    public Session(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) @Nullable String str, @SafeParcelable.Param(mo11972id = 4) String str2, @SafeParcelable.Param(mo11972id = 5) String str3, @SafeParcelable.Param(mo11972id = 7) int i, @SafeParcelable.Param(mo11972id = 8) zzc zzc, @SafeParcelable.Param(mo11972id = 9) @Nullable Long l) {
        this.zzib = j;
        this.zzic = j2;
        this.name = str;
        this.zzma = str2;
        this.description = str3;
        this.zzip = i;
        this.zzjg = zzc;
        this.zzmb = l;
    }

    private Session(Builder builder) {
        this(builder.zzib, builder.zzic, builder.name, builder.zzma, builder.description, builder.zzip, (zzc) null, builder.zzmb);
    }

    @Nullable
    public static Session extract(Intent intent) {
        if (intent == null) {
            return null;
        }
        return (Session) SafeParcelableSerializer.deserializeFromIntentExtra(intent, EXTRA_SESSION, CREATOR);
    }

    public static String getMimeType(String str) {
        String valueOf = String.valueOf(str);
        return valueOf.length() != 0 ? MIME_TYPE_PREFIX.concat(valueOf) : new String(MIME_TYPE_PREFIX);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Session)) {
            return false;
        }
        Session session = (Session) obj;
        return this.zzib == session.zzib && this.zzic == session.zzic && Objects.equal(this.name, session.name) && Objects.equal(this.zzma, session.zzma) && Objects.equal(this.description, session.description) && Objects.equal(this.zzjg, session.zzjg) && this.zzip == session.zzip;
    }

    public long getActiveTime(TimeUnit timeUnit) {
        Preconditions.checkState(this.zzmb != null, "Active time is not set");
        return timeUnit.convert(this.zzmb.longValue(), TimeUnit.MILLISECONDS);
    }

    public String getActivity() {
        return zzjn.getName(this.zzip);
    }

    @Nullable
    public String getAppPackageName() {
        zzc zzc = this.zzjg;
        if (zzc == null) {
            return null;
        }
        return zzc.getPackageName();
    }

    public String getDescription() {
        return this.description;
    }

    public long getEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzic, TimeUnit.MILLISECONDS);
    }

    public String getIdentifier() {
        return this.zzma;
    }

    @Nullable
    public String getName() {
        return this.name;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzib, TimeUnit.MILLISECONDS);
    }

    public boolean hasActiveTime() {
        return this.zzmb != null;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zzib), Long.valueOf(this.zzic), this.zzma);
    }

    public boolean isOngoing() {
        return this.zzic == 0;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("startTime", Long.valueOf(this.zzib)).add("endTime", Long.valueOf(this.zzic)).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("identifier", this.zzma).add("description", this.description).add("activity", Integer.valueOf(this.zzip)).add("application", this.zzjg).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzib);
        SafeParcelWriter.writeLong(parcel, 2, this.zzic);
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getIdentifier(), false);
        SafeParcelWriter.writeString(parcel, 5, getDescription(), false);
        SafeParcelWriter.writeInt(parcel, 7, this.zzip);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzjg, i, false);
        SafeParcelWriter.writeLongObject(parcel, 9, this.zzmb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
