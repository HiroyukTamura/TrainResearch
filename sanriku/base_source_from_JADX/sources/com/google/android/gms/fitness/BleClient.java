package com.google.android.gms.fitness;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolders;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.internal.PendingResultUtil;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.fitness.data.BleDevice;
import com.google.android.gms.fitness.data.DataType;
import com.google.android.gms.fitness.request.BleScanCallback;
import com.google.android.gms.internal.fitness.zzcr;
import com.google.android.gms.internal.fitness.zzem;
import com.google.android.gms.internal.fitness.zzn;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.List;

@Deprecated
public class BleClient extends GoogleApi<Api.ApiOptions.HasGoogleSignInAccountOptions> {
    private static final BleApi zzhp = (PlatformVersion.isAtLeastJellyBeanMR2() ? new zzcr() : new zzem());

    BleClient(@NonNull Activity activity, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(activity, zzn.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    @ShowFirstParty
    protected BleClient(@NonNull Context context, @NonNull Api.ApiOptions.HasGoogleSignInAccountOptions hasGoogleSignInAccountOptions) {
        super(context, zzn.zzmx, hasGoogleSignInAccountOptions, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public Task<Void> claimBleDevice(BleDevice bleDevice) {
        return PendingResultUtil.toVoidTask(zzhp.claimBleDevice(asGoogleApiClient(), bleDevice));
    }

    public Task<Void> claimBleDevice(String str) {
        return PendingResultUtil.toVoidTask(zzhp.claimBleDevice(asGoogleApiClient(), str));
    }

    public Task<List<BleDevice>> listClaimedBleDevices() {
        return PendingResultUtil.toTask(zzhp.listClaimedBleDevices(asGoogleApiClient()), zza.zzho);
    }

    @RequiresPermission("android.permission.BLUETOOTH_ADMIN")
    public Task<Void> startBleScan(List<DataType> list, int i, BleScanCallback bleScanCallback) {
        if (!PlatformVersion.isAtLeastJellyBeanMR2()) {
            return Tasks.forException(new ApiException(zzem.zzoe));
        }
        ListenerHolder registerListener = registerListener(bleScanCallback, BleScanCallback.class.getSimpleName());
        return doRegisterEventListener(RegistrationMethods.builder().withHolder(registerListener).register(new zzb(this, registerListener, list, i)).unregister(new zzc(this, registerListener)).build());
    }

    public Task<Boolean> stopBleScan(BleScanCallback bleScanCallback) {
        return !PlatformVersion.isAtLeastJellyBeanMR2() ? Tasks.forException(new ApiException(zzem.zzoe)) : doUnregisterEventListener(ListenerHolders.createListenerKey(bleScanCallback, BleScanCallback.class.getSimpleName()));
    }

    public Task<Void> unclaimBleDevice(BleDevice bleDevice) {
        return PendingResultUtil.toVoidTask(zzhp.unclaimBleDevice(asGoogleApiClient(), bleDevice));
    }

    public Task<Void> unclaimBleDevice(String str) {
        return PendingResultUtil.toVoidTask(zzhp.unclaimBleDevice(asGoogleApiClient(), str));
    }
}
