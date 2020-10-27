package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

public final class zzazv {
    public static <T> T zza(Context context, String str, zzazy<IBinder, T> zzazy) throws zzazx {
        try {
            return zzazy.apply(zzbs(context).instantiate(str));
        } catch (Exception e) {
            throw new zzazx(e);
        }
    }

    public static Context zzbr(Context context) throws zzazx {
        return zzbs(context).getModuleContext();
    }

    private static DynamiteModule zzbs(Context context) throws zzazx {
        try {
            return DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID);
        } catch (Exception e) {
            throw new zzazx(e);
        }
    }
}
