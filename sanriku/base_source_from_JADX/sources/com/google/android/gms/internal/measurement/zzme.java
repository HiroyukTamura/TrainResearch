package com.google.android.gms.internal.measurement;

import android.support.p001v4.media.session.PlaybackStateCompat;

public final class zzme implements zzmb {
    private static final zzcw<Long> zza;
    private static final zzcw<Long> zzaa;
    private static final zzcw<Long> zzab;
    private static final zzcw<Long> zzac;
    private static final zzcw<Long> zzad;
    private static final zzcw<Long> zzae;
    private static final zzcw<Long> zzaf;
    private static final zzcw<Long> zzag;
    private static final zzcw<Long> zzah;
    private static final zzcw<String> zzai;
    private static final zzcw<Long> zzaj;
    private static final zzcw<Long> zzb;
    private static final zzcw<String> zzc;
    private static final zzcw<String> zzd;
    private static final zzcw<String> zze;
    private static final zzcw<Long> zzf;
    private static final zzcw<Long> zzg;
    private static final zzcw<Long> zzh;
    private static final zzcw<Long> zzi;
    private static final zzcw<Long> zzj;
    private static final zzcw<Long> zzk;
    private static final zzcw<Long> zzl;
    private static final zzcw<Long> zzm;
    private static final zzcw<Long> zzn;
    private static final zzcw<Long> zzo;
    private static final zzcw<Long> zzp;
    private static final zzcw<Long> zzq;
    private static final zzcw<String> zzr;
    private static final zzcw<Long> zzs;
    private static final zzcw<Long> zzt;
    private static final zzcw<Long> zzu;
    private static final zzcw<Long> zzv;
    private static final zzcw<Long> zzw;
    private static final zzcw<Long> zzx;
    private static final zzcw<Long> zzy;
    private static final zzcw<Long> zzz;

    static {
        zzdf zzdf = new zzdf(zzcx.zza("com.google.android.gms.measurement"));
        zza = zzdf.zza("measurement.ad_id_cache_time", 10000);
        zzb = zzdf.zza("measurement.config.cache_time", 86400000);
        zzc = zzdf.zza("measurement.log_tag", "FA");
        zzd = zzdf.zza("measurement.config.url_authority", "app-measurement.com");
        zze = zzdf.zza("measurement.config.url_scheme", "https");
        zzf = zzdf.zza("measurement.upload.debug_upload_interval", 1000);
        zzg = zzdf.zza("measurement.lifetimevalue.max_currency_tracked", 4);
        zzh = zzdf.zza("measurement.store.max_stored_events_per_app", 100000);
        zzi = zzdf.zza("measurement.experiment.max_ids", 50);
        zzj = zzdf.zza("measurement.audience.filter_result_max_count", 200);
        zzk = zzdf.zza("measurement.alarm_manager.minimum_interval", 60000);
        zzl = zzdf.zza("measurement.upload.minimum_delay", 500);
        zzm = zzdf.zza("measurement.monitoring.sample_period_millis", 86400000);
        zzn = zzdf.zza("measurement.upload.realtime_upload_interval", 10000);
        zzo = zzdf.zza("measurement.upload.refresh_blacklisted_config_interval", 604800000);
        zzp = zzdf.zza("measurement.config.cache_time.service", 3600000);
        zzq = zzdf.zza("measurement.service_client.idle_disconnect_millis", 5000);
        zzr = zzdf.zza("measurement.log_tag.service", "FA-SVC");
        zzs = zzdf.zza("measurement.upload.stale_data_deletion_interval", 86400000);
        zzt = zzdf.zza("measurement.upload.backoff_period", 43200000);
        zzu = zzdf.zza("measurement.upload.initial_upload_delay_time", 15000);
        zzv = zzdf.zza("measurement.upload.interval", 3600000);
        zzw = zzdf.zza("measurement.upload.max_bundle_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzx = zzdf.zza("measurement.upload.max_bundles", 100);
        zzy = zzdf.zza("measurement.upload.max_conversions_per_day", 500);
        zzz = zzdf.zza("measurement.upload.max_error_events_per_day", 1000);
        zzaa = zzdf.zza("measurement.upload.max_events_per_bundle", 1000);
        zzab = zzdf.zza("measurement.upload.max_events_per_day", 100000);
        zzac = zzdf.zza("measurement.upload.max_public_events_per_day", 50000);
        zzad = zzdf.zza("measurement.upload.max_queue_time", 2419200000L);
        zzae = zzdf.zza("measurement.upload.max_realtime_events_per_day", 10);
        zzaf = zzdf.zza("measurement.upload.max_batch_size", (long) PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH);
        zzag = zzdf.zza("measurement.upload.retry_count", 6);
        zzah = zzdf.zza("measurement.upload.retry_time", 1800000);
        zzai = zzdf.zza("measurement.upload.url", "https://app-measurement.com/a");
        zzaj = zzdf.zza("measurement.upload.window_interval", 3600000);
    }

    public final long zza() {
        return zza.zzc().longValue();
    }

    public final long zzaa() {
        return zzad.zzc().longValue();
    }

    public final long zzab() {
        return zzae.zzc().longValue();
    }

    public final long zzac() {
        return zzaf.zzc().longValue();
    }

    public final long zzad() {
        return zzag.zzc().longValue();
    }

    public final long zzae() {
        return zzah.zzc().longValue();
    }

    public final String zzaf() {
        return zzai.zzc();
    }

    public final long zzag() {
        return zzaj.zzc().longValue();
    }

    public final long zzb() {
        return zzb.zzc().longValue();
    }

    public final String zzc() {
        return zzd.zzc();
    }

    public final String zzd() {
        return zze.zzc();
    }

    public final long zze() {
        return zzf.zzc().longValue();
    }

    public final long zzf() {
        return zzg.zzc().longValue();
    }

    public final long zzg() {
        return zzh.zzc().longValue();
    }

    public final long zzh() {
        return zzi.zzc().longValue();
    }

    public final long zzi() {
        return zzj.zzc().longValue();
    }

    public final long zzj() {
        return zzk.zzc().longValue();
    }

    public final long zzk() {
        return zzl.zzc().longValue();
    }

    public final long zzl() {
        return zzm.zzc().longValue();
    }

    public final long zzm() {
        return zzn.zzc().longValue();
    }

    public final long zzn() {
        return zzo.zzc().longValue();
    }

    public final long zzo() {
        return zzq.zzc().longValue();
    }

    public final long zzp() {
        return zzs.zzc().longValue();
    }

    public final long zzq() {
        return zzt.zzc().longValue();
    }

    public final long zzr() {
        return zzu.zzc().longValue();
    }

    public final long zzs() {
        return zzv.zzc().longValue();
    }

    public final long zzt() {
        return zzw.zzc().longValue();
    }

    public final long zzu() {
        return zzx.zzc().longValue();
    }

    public final long zzv() {
        return zzy.zzc().longValue();
    }

    public final long zzw() {
        return zzz.zzc().longValue();
    }

    public final long zzx() {
        return zzaa.zzc().longValue();
    }

    public final long zzy() {
        return zzab.zzc().longValue();
    }

    public final long zzz() {
        return zzac.zzc().longValue();
    }
}
