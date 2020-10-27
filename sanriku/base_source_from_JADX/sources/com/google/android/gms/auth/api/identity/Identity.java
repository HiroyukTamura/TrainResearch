package com.google.android.gms.auth.api.identity;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.p008authapi.zzaf;

public final class Identity {
    private Identity() {
    }

    public static SignInClient getSignInClient(@NonNull Activity activity) {
        return new zzaf((Activity) Preconditions.checkNotNull(activity), SignInOptions.builder().build());
    }

    public static SignInClient getSignInClient(@NonNull Context context) {
        return new zzaf((Context) Preconditions.checkNotNull(context), SignInOptions.builder().build());
    }
}
