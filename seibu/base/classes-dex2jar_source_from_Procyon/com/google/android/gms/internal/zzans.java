// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

public final class zzans
{
    public static zzant<String> zzahA;
    private static zzant<Integer> zzahB;
    public static zzant<Integer> zzahC;
    public static zzant<Integer> zzahD;
    public static zzant<Integer> zzahE;
    public static zzant<String> zzahF;
    public static zzant<Integer> zzahG;
    private static zzant<Long> zzahH;
    public static zzant<Integer> zzahI;
    public static zzant<Integer> zzahJ;
    public static zzant<Long> zzahK;
    private static zzant<String> zzahL;
    private static zzant<Integer> zzahM;
    public static zzant<Boolean> zzahN;
    public static zzant<Long> zzahO;
    public static zzant<Long> zzahP;
    private static zzant<Long> zzahQ;
    private static zzant<Long> zzahR;
    public static zzant<Long> zzahS;
    public static zzant<Long> zzahT;
    public static zzant<Long> zzahU;
    private static zzant<Boolean> zzahe;
    public static zzant<Boolean> zzahf;
    public static zzant<String> zzahg;
    private static zzant<Long> zzahh;
    private static zzant<Float> zzahi;
    public static zzant<Integer> zzahj;
    private static zzant<Integer> zzahk;
    public static zzant<Integer> zzahl;
    public static zzant<Long> zzahm;
    public static zzant<Long> zzahn;
    private static zzant<Long> zzaho;
    private static zzant<Long> zzahp;
    public static zzant<Long> zzahq;
    public static zzant<Long> zzahr;
    public static zzant<Integer> zzahs;
    public static zzant<Integer> zzaht;
    public static zzant<String> zzahu;
    public static zzant<String> zzahv;
    public static zzant<String> zzahw;
    public static zzant<String> zzahx;
    public static zzant<Integer> zzahy;
    public static zzant<String> zzahz;
    
    static {
        zzans.zzahe = zzant.zza("analytics.service_enabled", false, false);
        zzans.zzahf = zzant.zza("analytics.service_client_enabled", true, true);
        zzans.zzahg = zzant.zzc("analytics.log_tag", "GAv4", "GAv4-SVC");
        zzans.zzahh = zzant.zza("analytics.max_tokens", 60L, 60L);
        zzans.zzahi = zzant.zza("analytics.tokens_per_sec", 0.5f, 0.5f);
        zzans.zzahj = zzant.zza("analytics.max_stored_hits", 2000, 20000);
        zzans.zzahk = zzant.zza("analytics.max_stored_hits_per_app", 2000, 2000);
        zzans.zzahl = zzant.zza("analytics.max_stored_properties_per_app", 100, 100);
        zzans.zzahm = zzant.zza("analytics.local_dispatch_millis", 1800000L, 120000L);
        zzans.zzahn = zzant.zza("analytics.initial_local_dispatch_millis", 5000L, 5000L);
        zzans.zzaho = zzant.zza("analytics.min_local_dispatch_millis", 120000L, 120000L);
        zzans.zzahp = zzant.zza("analytics.max_local_dispatch_millis", 7200000L, 7200000L);
        zzans.zzahq = zzant.zza("analytics.dispatch_alarm_millis", 7200000L, 7200000L);
        zzans.zzahr = zzant.zza("analytics.max_dispatch_alarm_millis", 32400000L, 32400000L);
        zzans.zzahs = zzant.zza("analytics.max_hits_per_dispatch", 20, 20);
        zzans.zzaht = zzant.zza("analytics.max_hits_per_batch", 20, 20);
        zzans.zzahu = zzant.zzc("analytics.insecure_host", "http://www.google-analytics.com", "http://www.google-analytics.com");
        zzans.zzahv = zzant.zzc("analytics.secure_host", "https://ssl.google-analytics.com", "https://ssl.google-analytics.com");
        zzans.zzahw = zzant.zzc("analytics.simple_endpoint", "/collect", "/collect");
        zzans.zzahx = zzant.zzc("analytics.batching_endpoint", "/batch", "/batch");
        zzans.zzahy = zzant.zza("analytics.max_get_length", 2036, 2036);
        zzans.zzahz = zzant.zzc("analytics.batching_strategy.k", zzana.zzagK.name(), zzana.zzagK.name());
        final String name = zzang.zzagR.name();
        zzans.zzahA = zzant.zzc("analytics.compression_strategy.k", name, name);
        zzans.zzahB = zzant.zza("analytics.max_hits_per_request.k", 20, 20);
        zzans.zzahC = zzant.zza("analytics.max_hit_length.k", 8192, 8192);
        zzans.zzahD = zzant.zza("analytics.max_post_length.k", 8192, 8192);
        zzans.zzahE = zzant.zza("analytics.max_batch_post_length", 8192, 8192);
        zzans.zzahF = zzant.zzc("analytics.fallback_responses.k", "404,502", "404,502");
        zzans.zzahG = zzant.zza("analytics.batch_retry_interval.seconds.k", 3600, 3600);
        zzans.zzahH = zzant.zza("analytics.service_monitor_interval", 86400000L, 86400000L);
        zzans.zzahI = zzant.zza("analytics.http_connection.connect_timeout_millis", 60000, 60000);
        zzans.zzahJ = zzant.zza("analytics.http_connection.read_timeout_millis", 61000, 61000);
        zzans.zzahK = zzant.zza("analytics.campaigns.time_limit", 86400000L, 86400000L);
        zzans.zzahL = zzant.zzc("analytics.first_party_experiment_id", "", "");
        zzans.zzahM = zzant.zza("analytics.first_party_experiment_variant", 0, 0);
        zzans.zzahN = zzant.zza("analytics.test.disable_receiver", false, false);
        zzans.zzahO = zzant.zza("analytics.service_client.idle_disconnect_millis", 10000L, 10000L);
        zzans.zzahP = zzant.zza("analytics.service_client.connect_timeout_millis", 5000L, 5000L);
        zzans.zzahQ = zzant.zza("analytics.service_client.second_connect_delay_millis", 5000L, 5000L);
        zzans.zzahR = zzant.zza("analytics.service_client.unexpected_reconnect_millis", 60000L, 60000L);
        zzans.zzahS = zzant.zza("analytics.service_client.reconnect_throttle_millis", 1800000L, 1800000L);
        zzans.zzahT = zzant.zza("analytics.monitoring.sample_period_millis", 86400000L, 86400000L);
        zzans.zzahU = zzant.zza("analytics.initialization_warning_threshold", 5000L, 5000L);
    }
}
