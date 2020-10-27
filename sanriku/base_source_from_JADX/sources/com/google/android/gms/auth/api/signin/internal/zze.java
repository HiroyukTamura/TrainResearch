package com.google.android.gms.auth.api.signin.internal;

import android.content.Intent;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInApi;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.OptionalPendingResult;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public final class zze implements GoogleSignInApi {
    private static GoogleSignInOptions zzc(GoogleApiClient googleApiClient) {
        return ((zzh) googleApiClient.getClient(Auth.zzh)).zzj();
    }

    public final Intent getSignInIntent(GoogleApiClient googleApiClient) {
        return zzg.zzc(googleApiClient.getContext(), zzc(googleApiClient));
    }

    @Nullable
    public final GoogleSignInResult getSignInResultFromIntent(Intent intent) {
        return zzg.getSignInResultFromIntent(intent);
    }

    public final PendingResult<Status> revokeAccess(GoogleApiClient googleApiClient) {
        return zzg.zzd(googleApiClient, googleApiClient.getContext(), false);
    }

    public final PendingResult<Status> signOut(GoogleApiClient googleApiClient) {
        return zzg.zzc(googleApiClient, googleApiClient.getContext(), false);
    }

    public final OptionalPendingResult<GoogleSignInResult> silentSignIn(GoogleApiClient googleApiClient) {
        return zzg.zzc(googleApiClient, googleApiClient.getContext(), zzc(googleApiClient), false);
    }
}
