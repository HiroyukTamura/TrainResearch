package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.internal.fitness.zzjn;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSheetDialog;

@SafeParcelable.Class(creator = "GoalCreator")
@SafeParcelable.Reserved({1000})
public class Goal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Goal> CREATOR = new zzs();
    public static final int OBJECTIVE_TYPE_DURATION = 2;
    public static final int OBJECTIVE_TYPE_FREQUENCY = 3;
    public static final int OBJECTIVE_TYPE_METRIC = 1;
    @SafeParcelable.Field(getter = "getCreateTimeNanos", mo11969id = 1)
    private final long zzlj;
    @SafeParcelable.Field(getter = "getExpireTimeNanos", mo11969id = 2)
    private final long zzlk;
    @SafeParcelable.Field(getter = "getActivities", mo11969id = 3, type = "java.util.List")
    private final List<Integer> zzll;
    @SafeParcelable.Field(getter = "getRecurrence", mo11969id = 4)
    private final Recurrence zzlm;
    @SafeParcelable.Field(getter = "getObjectiveType", mo11969id = 5)
    private final int zzln;
    @SafeParcelable.Field(getter = "getMetricObjectiveWithOutChecking", mo11969id = 6)
    private final MetricObjective zzlo;
    @SafeParcelable.Field(getter = "getDurationObjectiveWithOutChecking", mo11969id = 7)
    private final DurationObjective zzlp;
    @SafeParcelable.Field(getter = "getFrequencyObjectiveWithOutChecking", mo11969id = 8)
    private final FrequencyObjective zzlq;

    @SafeParcelable.Class(creator = "DurationObjectiveCreator")
    @SafeParcelable.Reserved({1000})
    public static class DurationObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<DurationObjective> CREATOR = new zzp();
        @SafeParcelable.Field(getter = "getDuration", mo11969id = 1)
        private final long zzlr;

        @SafeParcelable.Constructor
        DurationObjective(@SafeParcelable.Param(mo11972id = 1) long j) {
            this.zzlr = j;
        }

        public DurationObjective(long j, TimeUnit timeUnit) {
            this(timeUnit.toNanos(j));
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof DurationObjective) && this.zzlr == ((DurationObjective) obj).zzlr;
        }

        public long getDuration(TimeUnit timeUnit) {
            return timeUnit.convert(this.zzlr, TimeUnit.NANOSECONDS);
        }

        public int hashCode() {
            return (int) this.zzlr;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("duration", Long.valueOf(this.zzlr)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeLong(parcel, 1, this.zzlr);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "FrequencyObjectiveCreator")
    @SafeParcelable.Reserved({1000})
    public static class FrequencyObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<FrequencyObjective> CREATOR = new zzr();
        @SafeParcelable.Field(getter = "getFrequency", mo11969id = 1)
        private final int frequency;

        @SafeParcelable.Constructor
        public FrequencyObjective(@SafeParcelable.Param(mo11972id = 1) int i) {
            this.frequency = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            return (obj instanceof FrequencyObjective) && this.frequency == ((FrequencyObjective) obj).frequency;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public int hashCode() {
            return this.frequency;
        }

        public String toString() {
            return Objects.toStringHelper(this).add("frequency", Integer.valueOf(this.frequency)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getFrequency());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Class(creator = "MetricObjectiveCreator")
    @SafeParcelable.Reserved({1000})
    public static class MetricObjective extends AbstractSafeParcelable {
        public static final Parcelable.Creator<MetricObjective> CREATOR = new zzw();
        @SafeParcelable.Field(getter = "getValue", mo11969id = 2)
        private final double value;
        @SafeParcelable.Field(getter = "getDataTypeName", mo11969id = 1)
        private final String zzls;
        @SafeParcelable.Field(getter = "getInitialValue", mo11969id = 3)
        private final double zzlt;

        public MetricObjective(String str, double d) {
            this(str, d, 0.0d);
        }

        @ShowFirstParty
        @SafeParcelable.Constructor
        public MetricObjective(@SafeParcelable.Param(mo11972id = 1) String str, @SafeParcelable.Param(mo11972id = 2) double d, @SafeParcelable.Param(mo11972id = 3) double d2) {
            this.zzls = str;
            this.value = d;
            this.zzlt = d2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof MetricObjective)) {
                return false;
            }
            MetricObjective metricObjective = (MetricObjective) obj;
            return Objects.equal(this.zzls, metricObjective.zzls) && this.value == metricObjective.value && this.zzlt == metricObjective.zzlt;
        }

        public String getDataTypeName() {
            return this.zzls;
        }

        public double getValue() {
            return this.value;
        }

        public int hashCode() {
            return this.zzls.hashCode();
        }

        public String toString() {
            return Objects.toStringHelper(this).add("dataTypeName", this.zzls).add("value", Double.valueOf(this.value)).add("initialValue", Double.valueOf(this.zzlt)).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 1, getDataTypeName(), false);
            SafeParcelWriter.writeDouble(parcel, 2, getValue());
            SafeParcelWriter.writeDouble(parcel, 3, this.zzlt);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    public static class MismatchedGoalException extends IllegalStateException {
        public MismatchedGoalException(String str) {
            super(str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ObjectiveType {
    }

    @SafeParcelable.Class(creator = "RecurrenceCreator")
    @SafeParcelable.Reserved({1000})
    public static class Recurrence extends AbstractSafeParcelable {
        public static final Parcelable.Creator<Recurrence> CREATOR = new zzab();
        public static final int UNIT_DAY = 1;
        public static final int UNIT_MONTH = 3;
        public static final int UNIT_WEEK = 2;
        @SafeParcelable.Field(getter = "getCount", mo11969id = 1)
        private final int count;
        /* access modifiers changed from: private */
        @SafeParcelable.Field(getter = "getUnit", mo11969id = 2)
        public final int zzlu;

        @Retention(RetentionPolicy.SOURCE)
        public @interface RecurrenceUnit {
        }

        @SafeParcelable.Constructor
        public Recurrence(@SafeParcelable.Param(mo11972id = 1) int i, @SafeParcelable.Param(mo11972id = 2) int i2) {
            this.count = i;
            Preconditions.checkState(i2 > 0 && i2 <= 3);
            this.zzlu = i2;
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Recurrence)) {
                return false;
            }
            Recurrence recurrence = (Recurrence) obj;
            return this.count == recurrence.count && this.zzlu == recurrence.zzlu;
        }

        public int getCount() {
            return this.count;
        }

        public int getUnit() {
            return this.zzlu;
        }

        public int hashCode() {
            return this.zzlu;
        }

        public String toString() {
            String str;
            Objects.ToStringHelper add = Objects.toStringHelper(this).add(RFGSheetDialog.ARG_COUNT, Integer.valueOf(this.count));
            int i = this.zzlu;
            if (i == 1) {
                str = "day";
            } else if (i == 2) {
                str = "week";
            } else if (i == 3) {
                str = "month";
            } else {
                throw new IllegalArgumentException("invalid unit value");
            }
            return add.add("unit", str).toString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, getCount());
            SafeParcelWriter.writeInt(parcel, 2, getUnit());
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @SafeParcelable.Constructor
    Goal(@SafeParcelable.Param(mo11972id = 1) long j, @SafeParcelable.Param(mo11972id = 2) long j2, @SafeParcelable.Param(mo11972id = 3) List<Integer> list, @SafeParcelable.Param(mo11972id = 4) Recurrence recurrence, @SafeParcelable.Param(mo11972id = 5) int i, @SafeParcelable.Param(mo11972id = 6) MetricObjective metricObjective, @SafeParcelable.Param(mo11972id = 7) DurationObjective durationObjective, @SafeParcelable.Param(mo11972id = 8) FrequencyObjective frequencyObjective) {
        this.zzlj = j;
        this.zzlk = j2;
        this.zzll = list;
        this.zzlm = recurrence;
        this.zzln = i;
        this.zzlo = metricObjective;
        this.zzlp = durationObjective;
        this.zzlq = frequencyObjective;
    }

    private static String zze(int i) {
        if (i == 0) {
            return "unknown";
        }
        if (i == 1) {
            return "metric";
        }
        if (i == 2) {
            return "duration";
        }
        if (i == 3) {
            return "frequency";
        }
        throw new IllegalArgumentException("invalid objective type value");
    }

    private final void zzf(int i) throws MismatchedGoalException {
        if (i != this.zzln) {
            throw new MismatchedGoalException(String.format("%s goal does not have %s objective", new Object[]{zze(this.zzln), zze(i)}));
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Goal)) {
            return false;
        }
        Goal goal = (Goal) obj;
        return this.zzlj == goal.zzlj && this.zzlk == goal.zzlk && Objects.equal(this.zzll, goal.zzll) && Objects.equal(this.zzlm, goal.zzlm) && this.zzln == goal.zzln && Objects.equal(this.zzlo, goal.zzlo) && Objects.equal(this.zzlp, goal.zzlp) && Objects.equal(this.zzlq, goal.zzlq);
    }

    @Nullable
    public String getActivityName() {
        if (this.zzll.isEmpty() || this.zzll.size() > 1) {
            return null;
        }
        return zzjn.getName(this.zzll.get(0).intValue());
    }

    public long getCreateTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.zzlj, TimeUnit.NANOSECONDS);
    }

    public DurationObjective getDurationObjective() {
        zzf(2);
        return this.zzlp;
    }

    public long getEndTime(Calendar calendar, TimeUnit timeUnit) {
        TimeUnit timeUnit2;
        long j;
        if (this.zzlm != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(calendar.getTime());
            int zza = this.zzlm.zzlu;
            if (zza == 1) {
                instance.add(5, 1);
            } else if (zza == 2) {
                instance.add(4, 1);
                instance.set(7, 2);
            } else if (zza == 3) {
                instance.add(2, 1);
                instance.set(5, 1);
            } else {
                throw new IllegalArgumentException(C0681a.m309a(24, "Invalid unit ", this.zzlm.zzlu));
            }
            instance.set(11, 0);
            j = instance.getTimeInMillis();
            timeUnit2 = TimeUnit.MILLISECONDS;
        } else {
            j = this.zzlk;
            timeUnit2 = TimeUnit.NANOSECONDS;
        }
        return timeUnit.convert(j, timeUnit2);
    }

    public FrequencyObjective getFrequencyObjective() {
        zzf(3);
        return this.zzlq;
    }

    public MetricObjective getMetricObjective() {
        zzf(1);
        return this.zzlo;
    }

    public int getObjectiveType() {
        return this.zzln;
    }

    @Nullable
    public Recurrence getRecurrence() {
        return this.zzlm;
    }

    public long getStartTime(Calendar calendar, TimeUnit timeUnit) {
        TimeUnit timeUnit2;
        long j;
        if (this.zzlm != null) {
            Calendar instance = Calendar.getInstance();
            instance.setTime(calendar.getTime());
            int zza = this.zzlm.zzlu;
            if (zza != 1) {
                if (zza == 2) {
                    instance.set(7, 2);
                } else if (zza == 3) {
                    instance.set(5, 1);
                } else {
                    throw new IllegalArgumentException(C0681a.m309a(24, "Invalid unit ", this.zzlm.zzlu));
                }
            }
            instance.set(11, 0);
            j = instance.getTimeInMillis();
            timeUnit2 = TimeUnit.MILLISECONDS;
        } else {
            j = this.zzlj;
            timeUnit2 = TimeUnit.NANOSECONDS;
        }
        return timeUnit.convert(j, timeUnit2);
    }

    public int hashCode() {
        return this.zzln;
    }

    public String toString() {
        return Objects.toStringHelper(this).add("activity", getActivityName()).add("recurrence", this.zzlm).add("metricObjective", this.zzlo).add("durationObjective", this.zzlp).add("frequencyObjective", this.zzlq).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, this.zzlj);
        SafeParcelWriter.writeLong(parcel, 2, this.zzlk);
        SafeParcelWriter.writeList(parcel, 3, this.zzll, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getRecurrence(), i, false);
        SafeParcelWriter.writeInt(parcel, 5, getObjectiveType());
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzlo, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzlp, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.zzlq, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
