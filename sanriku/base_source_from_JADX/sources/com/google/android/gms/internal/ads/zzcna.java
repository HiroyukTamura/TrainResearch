package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zztf;
import java.util.ArrayList;

final /* synthetic */ class zzcna implements zzdkb {
    private final boolean zzecc;
    private final zzcnb zzgdy;
    private final ArrayList zzgdz;
    private final zztf.zzm zzgea;
    private final zztf.zzo.zzc zzgeb;

    zzcna(zzcnb zzcnb, boolean z, ArrayList arrayList, zztf.zzm zzm, zztf.zzo.zzc zzc) {
        this.zzgdy = zzcnb;
        this.zzecc = z;
        this.zzgdz = arrayList;
        this.zzgea = zzm;
        this.zzgeb = zzc;
    }

    public final Object apply(Object obj) {
        zzcnb zzcnb = this.zzgdy;
        boolean z = this.zzecc;
        SQLiteDatabase sQLiteDatabase = (SQLiteDatabase) obj;
        byte[] zza = zzcnb.zzged.zza(z, this.zzgdz, this.zzgea, this.zzgeb);
        ContentValues contentValues = new ContentValues();
        contentValues.put("timestamp", Long.valueOf(zzq.zzld().currentTimeMillis()));
        contentValues.put("serialized_proto_data", zza);
        sQLiteDatabase.insert("offline_signal_contents", (String) null, contentValues);
        sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"total_requests"}));
        if (!z) {
            sQLiteDatabase.execSQL(String.format("UPDATE offline_signal_statistics SET value = value+1 WHERE statistic_name = '%s'", new Object[]{"failed_requests"}));
        }
        return null;
    }
}
