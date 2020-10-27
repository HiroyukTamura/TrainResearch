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

final class zax implements OnCompleteListener<Map<ApiKey<?>, String>> {
    private final /* synthetic */ zav zafl;

    private zax(zav zav) {
        this.zafl = zav;
    }

    public final void onComplete(@NonNull Task<Map<ApiKey<?>, String>> task) {
        zav zav;
        ConnectionResult connectionResult;
        Map zad;
        this.zafl.zaer.lock();
        try {
            if (this.zafl.zafe) {
                if (task.isSuccessful()) {
                    Map unused = this.zafl.zaff = new ArrayMap(this.zafl.zaeu.size());
                    for (zaw apiKey : this.zafl.zaeu.values()) {
                        this.zafl.zaff.put(apiKey.getApiKey(), ConnectionResult.RESULT_SUCCESS);
                    }
                } else {
                    if (task.getException() instanceof AvailabilityException) {
                        AvailabilityException availabilityException = (AvailabilityException) task.getException();
                        if (this.zafl.zafc) {
                            Map unused2 = this.zafl.zaff = new ArrayMap(this.zafl.zaeu.size());
                            for (zaw zaw : this.zafl.zaeu.values()) {
                                ApiKey apiKey2 = zaw.getApiKey();
                                ConnectionResult connectionResult2 = availabilityException.getConnectionResult((GoogleApi<? extends Api.ApiOptions>) zaw);
                                if (this.zafl.zaa((zaw<?>) zaw, connectionResult2)) {
                                    zad = this.zafl.zaff;
                                    connectionResult2 = new ConnectionResult(16);
                                } else {
                                    zad = this.zafl.zaff;
                                }
                                zad.put(apiKey2, connectionResult2);
                            }
                        } else {
                            Map unused3 = this.zafl.zaff = availabilityException.zaj();
                        }
                        zav = this.zafl;
                        connectionResult = this.zafl.zaac();
                    } else {
                        Log.e("ConnectionlessGAC", "Unexpected availability exception", task.getException());
                        Map unused4 = this.zafl.zaff = Collections.emptyMap();
                        zav = this.zafl;
                        connectionResult = new ConnectionResult(8);
                    }
                    ConnectionResult unused5 = zav.zafi = connectionResult;
                }
                if (this.zafl.zafg != null) {
                    this.zafl.zaff.putAll(this.zafl.zafg);
                    ConnectionResult unused6 = this.zafl.zafi = this.zafl.zaac();
                }
                if (this.zafl.zafi == null) {
                    this.zafl.zaaa();
                    this.zafl.zaab();
                } else {
                    boolean unused7 = this.zafl.zafe = false;
                    this.zafl.zaex.zac(this.zafl.zafi);
                }
                this.zafl.zaez.signalAll();
            }
        } finally {
            this.zafl.zaer.unlock();
        }
    }
}
