package com.google.android.gms.fitness;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInOptionsExtension;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.fitness.data.DataType;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class FitnessOptions implements GoogleSignInOptionsExtension {
    public static final int ACCESS_READ = 0;
    public static final int ACCESS_WRITE = 1;
    private final Set<Scope> zzhu;

    public static final class Builder {
        /* access modifiers changed from: private */
        public final Set<Scope> zzhu;

        private Builder() {
            this.zzhu = new HashSet();
        }

        public final Builder addDataType(@NonNull DataType dataType) {
            return addDataType(dataType, 0);
        }

        public final Builder addDataType(@NonNull DataType dataType, int i) {
            Set<Scope> set;
            Scope scope;
            Preconditions.checkArgument(i == 0 || i == 1, "valid access types are FitnessOptions.ACCESS_READ or FitnessOptions.ACCESS_WRITE");
            if (i != 0 || dataType.zzn() == null) {
                if (i == 1 && dataType.zzo() != null) {
                    set = this.zzhu;
                    scope = new Scope(dataType.zzo());
                }
                return this;
            }
            set = this.zzhu;
            scope = new Scope(dataType.zzn());
            set.add(scope);
            return this;
        }

        public final FitnessOptions build() {
            return new FitnessOptions(this);
        }
    }

    private FitnessOptions(Builder builder) {
        this.zzhu = zzh.zza(builder.zzhu);
    }

    public static Builder builder() {
        return new Builder();
    }

    public final boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FitnessOptions)) {
            return false;
        }
        return this.zzhu.equals(((FitnessOptions) obj).zzhu);
    }

    public final int getExtensionType() {
        return 3;
    }

    public final List<Scope> getImpliedScopes() {
        return new ArrayList(this.zzhu);
    }

    public final int hashCode() {
        return Objects.hashCode(this.zzhu);
    }

    public final Bundle toBundle() {
        return new Bundle();
    }
}
