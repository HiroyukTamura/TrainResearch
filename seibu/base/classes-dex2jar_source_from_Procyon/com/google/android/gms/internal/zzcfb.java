// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzcfb
{
    private static zzcfc<Boolean> zzbpO;
    private static zzcfc<Boolean> zzbpP;
    private static zzcfc<Boolean> zzbpQ;
    private static zzcfc<Boolean> zzbpR;
    private static zzcfc<Boolean> zzbpS;
    private static zzcfc<Boolean> zzbpT;
    public static zzcfc<Boolean> zzbpU;
    public static zzcfc<String> zzbpV;
    public static zzcfc<Long> zzbpW;
    public static zzcfc<Long> zzbpX;
    public static zzcfc<Long> zzbpY;
    public static zzcfc<String> zzbpZ;
    public static zzcfc<Integer> zzbqA;
    public static zzcfc<Long> zzbqB;
    public static zzcfc<String> zzbqa;
    public static zzcfc<Integer> zzbqb;
    public static zzcfc<Integer> zzbqc;
    public static zzcfc<Integer> zzbqd;
    public static zzcfc<Integer> zzbqe;
    public static zzcfc<Integer> zzbqf;
    public static zzcfc<Integer> zzbqg;
    public static zzcfc<Integer> zzbqh;
    public static zzcfc<Integer> zzbqi;
    public static zzcfc<Integer> zzbqj;
    public static zzcfc<Integer> zzbqk;
    public static zzcfc<String> zzbql;
    public static zzcfc<Long> zzbqm;
    public static zzcfc<Long> zzbqn;
    public static zzcfc<Long> zzbqo;
    public static zzcfc<Long> zzbqp;
    public static zzcfc<Long> zzbqq;
    public static zzcfc<Long> zzbqr;
    public static zzcfc<Long> zzbqs;
    public static zzcfc<Long> zzbqt;
    public static zzcfc<Long> zzbqu;
    public static zzcfc<Long> zzbqv;
    public static zzcfc<Long> zzbqw;
    public static zzcfc<Integer> zzbqx;
    public static zzcfc<Long> zzbqy;
    public static zzcfc<Integer> zzbqz;
    
    static {
        zzcfb.zzbpO = zzcfc.zzb("measurement.service_enabled", true, true);
        zzcfb.zzbpP = zzcfc.zzb("measurement.service_client_enabled", true, true);
        zzcfb.zzbpQ = zzcfc.zzb("measurement.log_third_party_store_events_enabled", false, false);
        zzcfb.zzbpR = zzcfc.zzb("measurement.log_installs_enabled", false, false);
        zzcfb.zzbpS = zzcfc.zzb("measurement.log_upgrades_enabled", false, false);
        zzcfb.zzbpT = zzcfc.zzb("measurement.log_androidId_enabled", false, false);
        zzcfb.zzbpU = zzcfc.zzb("measurement.upload_dsid_enabled", false, false);
        zzcfb.zzbpV = zzcfc.zzj("measurement.log_tag", "FA", "FA-SVC");
        zzcfb.zzbpW = zzcfc.zzb("measurement.ad_id_cache_time", 10000L, 10000L);
        zzcfb.zzbpX = zzcfc.zzb("measurement.monitoring.sample_period_millis", 86400000L, 86400000L);
        zzcfb.zzbpY = zzcfc.zzb("measurement.config.cache_time", 86400000L, 3600000L);
        zzcfb.zzbpZ = zzcfc.zzj("measurement.config.url_scheme", "https", "https");
        zzcfb.zzbqa = zzcfc.zzj("measurement.config.url_authority", "app-measurement.com", "app-measurement.com");
        zzcfb.zzbqb = zzcfc.zzm("measurement.upload.max_bundles", 100, 100);
        zzcfb.zzbqc = zzcfc.zzm("measurement.upload.max_batch_size", 65536, 65536);
        zzcfb.zzbqd = zzcfc.zzm("measurement.upload.max_bundle_size", 65536, 65536);
        zzcfb.zzbqe = zzcfc.zzm("measurement.upload.max_events_per_bundle", 1000, 1000);
        zzcfb.zzbqf = zzcfc.zzm("measurement.upload.max_events_per_day", 100000, 100000);
        zzcfb.zzbqg = zzcfc.zzm("measurement.upload.max_error_events_per_day", 1000, 1000);
        zzcfb.zzbqh = zzcfc.zzm("measurement.upload.max_public_events_per_day", 50000, 50000);
        zzcfb.zzbqi = zzcfc.zzm("measurement.upload.max_conversions_per_day", 500, 500);
        zzcfb.zzbqj = zzcfc.zzm("measurement.upload.max_realtime_events_per_day", 10, 10);
        zzcfb.zzbqk = zzcfc.zzm("measurement.store.max_stored_events_per_app", 100000, 100000);
        zzcfb.zzbql = zzcfc.zzj("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a");
        zzcfb.zzbqm = zzcfc.zzb("measurement.upload.backoff_period", 43200000L, 43200000L);
        zzcfb.zzbqn = zzcfc.zzb("measurement.upload.window_interval", 3600000L, 3600000L);
        zzcfb.zzbqo = zzcfc.zzb("measurement.upload.interval", 3600000L, 3600000L);
        zzcfb.zzbqp = zzcfc.zzb("measurement.upload.realtime_upload_interval", 10000L, 10000L);
        zzcfb.zzbqq = zzcfc.zzb("measurement.upload.debug_upload_interval", 1000L, 1000L);
        zzcfb.zzbqr = zzcfc.zzb("measurement.upload.minimum_delay", 500L, 500L);
        zzcfb.zzbqs = zzcfc.zzb("measurement.alarm_manager.minimum_interval", 60000L, 60000L);
        zzcfb.zzbqt = zzcfc.zzb("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L);
        zzcfb.zzbqu = zzcfc.zzb("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L);
        zzcfb.zzbqv = zzcfc.zzb("measurement.upload.initial_upload_delay_time", 15000L, 15000L);
        zzcfb.zzbqw = zzcfc.zzb("measurement.upload.retry_time", 1800000L, 1800000L);
        zzcfb.zzbqx = zzcfc.zzm("measurement.upload.retry_count", 6, 6);
        zzcfb.zzbqy = zzcfc.zzb("measurement.upload.max_queue_time", 2419200000L, 2419200000L);
        zzcfb.zzbqz = zzcfc.zzm("measurement.lifetimevalue.max_currency_tracked", 4, 4);
        zzcfb.zzbqA = zzcfc.zzm("measurement.audience.filter_result_max_count", 200, 200);
        zzcfb.zzbqB = zzcfc.zzb("measurement.service_client.idle_disconnect_millis", 5000L, 5000L);
    }
}
