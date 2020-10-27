package com.google.android.gms.measurement.internal;

import android.content.Context;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzci;
import com.google.android.gms.internal.measurement.zzcx;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@VisibleForTesting
public final class zzaq {
    public static zzeo<Long> zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzat.zza);
    public static zzeo<Long> zzaa = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbk.zza);
    public static zzeo<Integer> zzab = zza("measurement.upload.retry_count", 6, 6, zzbn.zza);
    public static zzeo<Long> zzac = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbm.zza);
    public static zzeo<Integer> zzad = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbp.zza);
    public static zzeo<Integer> zzae;
    public static zzeo<Integer> zzaf = zza("measurement.upload.max_public_user_properties", 25, 25, (zzem) null);
    public static zzeo<Integer> zzag = zza("measurement.upload.max_event_name_cardinality", 500, 500, (zzem) null);
    public static zzeo<Integer> zzah = zza("measurement.upload.max_public_event_params", 25, 25, (zzem) null);
    public static zzeo<Long> zzai = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzbq.zza);
    public static zzeo<Boolean> zzaj = zza("measurement.test.boolean_flag", false, false, zzbt.zza);
    public static zzeo<String> zzak = zza("measurement.test.string_flag", "---", "---", zzbs.zza);
    public static zzeo<Long> zzal = zza("measurement.test.long_flag", -1L, -1L, zzbv.zza);
    public static zzeo<Integer> zzam = zza("measurement.test.int_flag", -2, -2, zzbu.zza);
    public static zzeo<Double> zzan;
    public static zzeo<Integer> zzao = zza("measurement.experiment.max_ids", 50, 50, zzbw.zza);
    public static zzeo<Integer> zzap = zza("measurement.max_bundles_per_iteration", 2, 2, zzbz.zza);
    public static zzeo<Boolean> zzaq = zza("measurement.validation.internal_limits_internal_event_params", false, false, zzby.zza);
    public static zzeo<Boolean> zzar = zza("measurement.referrer.enable_logging_install_referrer_cmp_from_apk", true, true, zzca.zza);
    public static zzeo<Boolean> zzas = zza("measurement.collection.firebase_global_collection_flag_enabled", true, true, zzcd.zza);
    public static zzeo<Boolean> zzat = zza("measurement.collection.efficient_engagement_reporting_enabled_2", true, true, zzcc.zza);
    public static zzeo<Boolean> zzau = zza("measurement.collection.redundant_engagement_removal_enabled", false, false, zzcf.zza);
    public static zzeo<Boolean> zzav = zza("measurement.client.freeride_engagement_fix", true, true, zzce.zza);
    public static zzeo<Boolean> zzaw = zza("measurement.experiment.enable_experiment_reporting", true, true, zzch.zza);
    public static zzeo<Boolean> zzax = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcg.zza);
    public static zzeo<Boolean> zzay = zza("measurement.quality.checksum", false, false, (zzem) null);
    public static zzeo<Boolean> zzaz = zza("measurement.sdk.dynamite.allow_remote_dynamite2", false, false, zzcj.zza);
    public static zzeo<Long> zzb = zza("measurement.monitoring.sample_period_millis", 86400000L, 86400000L, zzas.zza);
    public static zzeo<Boolean> zzba = zza("measurement.sdk.collection.validate_param_names_alphabetical", true, true, zzci.zza);
    public static zzeo<Boolean> zzbb = zza("measurement.collection.event_safelist", true, true, zzcl.zza);
    public static zzeo<Boolean> zzbc = zza("measurement.service.audience.fix_skip_audience_with_failed_filters", true, true, zzcm.zza);
    public static zzeo<Boolean> zzbd = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzcp.zza);
    public static zzeo<Boolean> zzbe = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzco.zza);
    public static zzeo<Boolean> zzbf = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzcr.zza);
    public static zzeo<Boolean> zzbg = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzcq.zza);
    public static zzeo<Boolean> zzbh = zza("measurement.sdk.collection.last_deep_link_referrer2", true, true, zzct.zza);
    public static zzeo<Boolean> zzbi = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzcs.zza);
    public static zzeo<Boolean> zzbj = zza("measurement.sdk.collection.last_gclid_from_referrer2", false, false, zzcv.zza);
    public static zzeo<Boolean> zzbk = zza("measurement.sdk.collection.enable_extend_user_property_size", true, true, zzcu.zza);
    public static zzeo<Boolean> zzbl = zza("measurement.upload.file_lock_state_check", false, false, zzcw.zza);
    public static zzeo<Boolean> zzbm = zza("measurement.sampling.calculate_bundle_timestamp_before_sampling", true, true, zzcz.zza);
    public static zzeo<Boolean> zzbn = zza("measurement.ga.ga_app_id", false, false, zzcy.zza);
    public static zzeo<Boolean> zzbo = zza("measurement.lifecycle.app_backgrounded_tracking", true, true, zzdb.zza);
    public static zzeo<Boolean> zzbp = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzda.zza);
    public static zzeo<Boolean> zzbq = zza("measurement.integration.disable_firebase_instance_id", false, false, zzdd.zza);
    public static zzeo<Boolean> zzbr = zza("measurement.lifecycle.app_backgrounded_engagement", false, false, zzdc.zza);
    public static zzeo<Boolean> zzbs = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzdf.zza);
    public static zzeo<Boolean> zzbt = zza("measurement.service.use_appinfo_modified", false, false, zzde.zza);
    public static zzeo<Boolean> zzbu = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzdh.zza);
    public static zzeo<Boolean> zzbv = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzdj.zza);
    public static zzeo<Boolean> zzbw = zza("measurement.config.string.always_update_disk_on_set", true, true, zzdi.zza);
    public static zzeo<Boolean> zzbx = zza("measurement.scheduler.task_thread.cleanup_on_exit", false, false, zzdl.zza);
    public static zzeo<Boolean> zzby = zza("measurement.upload.file_truncate_fix", false, false, zzdk.zza);
    public static zzeo<Boolean> zzbz = zza("measurement.engagement_time_main_thread", true, true, zzdn.zza);
    public static zzeo<Long> zzc = zza("measurement.config.cache_time", 86400000L, 3600000L, zzbf.zza);
    public static zzeo<Boolean> zzca = zza("measurement.sdk.referrer.delayed_install_referrer_api", false, false, zzdm.zza);
    public static zzeo<Boolean> zzcb = zza("measurement.sdk.screen.disabling_automatic_reporting", false, false, zzdp.zza);
    public static zzeo<Boolean> zzcc = zza("measurement.sdk.screen.manual_screen_view_logging", false, false, zzdo.zza);
    public static zzeo<Boolean> zzcd = zza("measurement.gold.enhanced_ecommerce.format_logs", true, true, zzdr.zza);
    public static zzeo<Boolean> zzce = zza("measurement.gold.enhanced_ecommerce.nested_param_daily_event_count", true, true, zzdq.zza);
    public static zzeo<Boolean> zzcf = zza("measurement.gold.enhanced_ecommerce.upload_nested_complex_events", true, true, zzds.zza);
    public static zzeo<Boolean> zzcg = zza("measurement.gold.enhanced_ecommerce.log_nested_complex_events", true, true, zzdv.zza);
    public static zzeo<Boolean> zzch = zza("measurement.gold.enhanced_ecommerce.updated_schema.client", true, true, zzdu.zza);
    public static zzeo<Boolean> zzci = zza("measurement.gold.enhanced_ecommerce.updated_schema.service", true, true, zzdx.zza);
    public static zzeo<Boolean> zzcj = zza("measurement.service.configurable_service_limits", true, true, zzdz.zza);
    public static zzeo<Boolean> zzck = zza("measurement.client.configurable_service_limits", false, false, zzdy.zza);
    public static zzeo<Boolean> zzcl = zza("measurement.androidId.delete_feature", true, true, zzeb.zza);
    public static zzeo<Boolean> zzcm = zza("measurement.client.global_params.dev", false, false, zzea.zza);
    public static zzeo<Boolean> zzcn = zza("measurement.service.global_params", false, false, zzed.zza);
    public static zzeo<Boolean> zzco = zza("measurement.service.global_params_in_payload", true, true, zzef.zza);
    public static zzeo<Boolean> zzcp = zza("measurement.client.string_reader", true, true, zzee.zza);
    public static zzeo<Boolean> zzcq = zza("measurement.sdk.attribution.cache", true, true, zzeh.zza);
    public static zzeo<Long> zzcr = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzeg.zza);
    public static zzeo<Boolean> zzcs = zza("measurement.service.database_return_empty_collection", true, true, zzej.zza);
    /* access modifiers changed from: private */
    public static List<zzeo<?>> zzct = Collections.synchronizedList(new ArrayList());
    private static Set<zzeo<?>> zzcu = Collections.synchronizedSet(new HashSet());
    private static zzeo<Boolean> zzcv = zza("measurement.service.audience.invalidate_config_cache_after_app_unisntall", true, true, zzcn.zza);
    private static zzeo<Boolean> zzcw = zza("measurement.collection.synthetic_data_mitigation", false, false, zzdw.zza);
    private static zzeo<Boolean> zzcx = zza("measurement.service.ssaid_removal", true, true, zzei.zza);
    private static zzeo<Boolean> zzcy = zza("measurement.client.consent_state_v1.dev", false, false, zzel.zza);
    private static zzeo<Boolean> zzcz = zza("measurement.service.consent_state_v1", false, false, zzek.zza);
    public static zzeo<String> zzd = zza("measurement.config.url_scheme", "https", "https", zzbo.zza);
    public static zzeo<String> zze = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzcb.zza);
    public static zzeo<Integer> zzf = zza("measurement.upload.max_bundles", 100, 100, zzck.zza);
    public static zzeo<Integer> zzg = zza("measurement.upload.max_batch_size", 65536, 65536, zzcx.zza);
    public static zzeo<Integer> zzh = zza("measurement.upload.max_bundle_size", 65536, 65536, zzdg.zza);
    public static zzeo<Integer> zzi = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzdt.zza);
    public static zzeo<Integer> zzj = zza("measurement.upload.max_events_per_day", 100000, 100000, zzec.zza);
    public static zzeo<Integer> zzk = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzav.zza);
    public static zzeo<Integer> zzl = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzau.zza);
    public static zzeo<Integer> zzm = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzax.zza);
    public static zzeo<Integer> zzn = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzaw.zza);
    public static zzeo<Integer> zzo = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzaz.zza);
    public static zzeo<String> zzp = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzay.zza);
    public static zzeo<Long> zzq = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzbb.zza);
    public static zzeo<Long> zzr = zza("measurement.upload.window_interval", 3600000L, 3600000L, zzba.zza);
    public static zzeo<Long> zzs = zza("measurement.upload.interval", 3600000L, 3600000L, zzbd.zza);
    public static zzeo<Long> zzt = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbc.zza);
    public static zzeo<Long> zzu = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbe.zza);
    public static zzeo<Long> zzv = zza("measurement.upload.minimum_delay", 500L, 500L, zzbh.zza);
    public static zzeo<Long> zzw = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbg.zza);
    public static zzeo<Long> zzx = zza("measurement.upload.stale_data_deletion_interval", 86400000L, 86400000L, zzbj.zza);
    public static zzeo<Long> zzy = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbi.zza);
    public static zzeo<Long> zzz = zza("measurement.upload.initial_upload_delay_time", 15000L, 15000L, zzbl.zza);

    static {
        Integer valueOf = Integer.valueOf(ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        zzae = zza("measurement.audience.filter_result_max_count", valueOf, valueOf, zzbr.zza);
        Double valueOf2 = Double.valueOf(-3.0d);
        zzan = zza("measurement.test.double_flag", valueOf2, valueOf2, zzbx.zza);
    }

    @VisibleForTesting
    private static <V> zzeo<V> zza(@Nullable String str, @Nullable V v, @Nullable V v2, @Nullable zzem<V> zzem) {
        zzeo zzeo = new zzeo(str, v, v2, zzem);
        zzct.add(zzeo);
        return zzeo;
    }

    public static Map<String, String> zza(Context context) {
        zzci zza2 = zzci.zza(context.getContentResolver(), zzcx.zza("com.google.android.gms.measurement"));
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }
}
