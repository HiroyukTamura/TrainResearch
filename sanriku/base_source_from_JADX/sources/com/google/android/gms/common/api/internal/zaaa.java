package com.google.android.gms.common.api.internal;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.collection.ArrayMap;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.Collections;
import java.util.Map;

final class zaaa implements OnCompleteListener<Map<ApiKey<?>, String>> {
    private final /* synthetic */ zav zafl;
    private SignInConnectionListener zafo;

    zaaa(zav zav, SignInConnectionListener signInConnectionListener) {
        this.zafl = zav;
        this.zafo = signInConnectionListener;
    }

    /* access modifiers changed from: package-private */
    public final void cancel() {
        this.zafo.onComplete();
    }

    public final void onComplete(@NonNull Task<Map<ApiKey<?>, String>> task) {
        SignInConnectionListener signInConnectionListener;
        Map zag;
        this.zafl.zaer.lock();
        try {
            if (!this.zafl.zafe) {
                signInConnectionListener = this.zafo;
            } else {
                if (task.isSuccessful()) {
                    Map unused = this.zafl.zafg = new ArrayMap(this.zafl.zaev.size());
                    for (zaw apiKey : this.zafl.zaev.values()) {
                        this.zafl.zafg.put(apiKey.getApiKey(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else if (task.getException() instanceof AvailabilityException) {
                    AvailabilityException availabilityException = (AvailabilityException) task.getException();
                    if (this.zafl.zafc) {
                        Map unused2 = this.zafl.zafg = new ArrayMap(this.zafl.zaev.size());
                        for (zaw zaw : this.zafl.zaev.values()) {
                            ApiKey apiKey2 = zaw.getApiKey();
                            ConnectionResult connectionResult = availabilityException.getConnectionResult((GoogleApi<? extends Api.ApiOptions>) zaw);
                            if (this.zafl.zaa((zaw<?>) zaw, connectionResult)) {
                                zag = this.zafl.zafg;
                                connectionResult = new ConnectionResult(16);
                            } else {
                                zag = this.zafl.zafg;
                            }
                            zag.put(apiKey2, connectionResult);
                        }
                    } else {
                        Map unused3 = this.zafl.zafg = availabilityException.zaj();
                    }
                } else {
                    Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                    Map unused4 = this.zafl.zafg = Collections.emptyMap();
                }
                if (this.zafl.isConnected()) {
                    this.zafl.zaff.putAll(this.zafl.zafg);
                    if (this.zafl.zaac() == null) {
                        this.zafl.zaaa();
                        this.zafl.zaab();
                        this.zafl.zaez.signalAll();
                    }
                }
                signInConnectionListener = this.zafo;
            }
            signInConnectionListener.onComplete();
        } finally {
            this.zafl.zaer.unlock();
        }
    }
}
