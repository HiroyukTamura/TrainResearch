package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzbu;
import com.google.android.gms.internal.measurement.zzcc;
import com.google.android.gms.internal.measurement.zzho;
import com.google.android.gms.internal.measurement.zzib;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.internal.measurement.zzjm;
import com.google.android.gms.internal.measurement.zzmo;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.gym.p044ui.dialog.RFGSheetDialog;

public final class zzks extends zzkl {
    zzks(zzkk zzkk) {
        super(zzkk);
    }

    static int zza(zzcc.zzg.zza zza, String str) {
        if (zza == null) {
            return -1;
        }
        for (int i = 0; i < zza.zze(); i++) {
            if (str.equals(zza.zzd(i).zzc())) {
                return i;
            }
        }
        return -1;
    }

    static zzcc.zze zza(zzcc.zzc zzc, String str) {
        for (zzcc.zze next : zzc.zza()) {
            if (next.zzb().equals(str)) {
                return next;
            }
        }
        return null;
    }

    static <Builder extends zzjm> Builder zza(Builder builder, byte[] bArr) throws zzij {
        zzho zzb = zzho.zzb();
        return zzb != null ? builder.zza(bArr, zzb) : builder.zza(bArr);
    }

    private static String zza(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    static List<Long> zza(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    private static List<zzcc.zze> zza(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                zzcc.zze.zza zzm = zzcc.zze.zzm();
                for (String str : bundle.keySet()) {
                    zzcc.zze.zza zza = zzcc.zze.zzm().zza(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        zza.zza(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        zza.zzb((String) obj);
                    } else if (obj instanceof Double) {
                        zza.zza(((Double) obj).doubleValue());
                    }
                    zzm.zza(zza);
                }
                if (zzm.zzd() > 0) {
                    arrayList.add((zzcc.zze) ((zzib) zzm.zzv()));
                }
            }
        }
        return arrayList;
    }

    private static void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    private final void zza(StringBuilder sb, int i, zzbu.zzc zzc) {
        if (zzc != null) {
            zza(sb, i);
            sb.append("filter {\n");
            if (zzc.zze()) {
                zza(sb, i, "complement", (Object) Boolean.valueOf(zzc.zzf()));
            }
            if (zzc.zzg()) {
                zza(sb, i, "param_name", (Object) zzo().zzb(zzc.zzh()));
            }
            if (zzc.zza()) {
                int i2 = i + 1;
                zzbu.zzf zzb = zzc.zzb();
                if (zzb != null) {
                    zza(sb, i2);
                    sb.append("string_filter");
                    sb.append(" {\n");
                    if (zzb.zza()) {
                        zza(sb, i2, "match_type", (Object) zzb.zzb().name());
                    }
                    if (zzb.zzc()) {
                        zza(sb, i2, "expression", (Object) zzb.zzd());
                    }
                    if (zzb.zze()) {
                        zza(sb, i2, "case_sensitive", (Object) Boolean.valueOf(zzb.zzf()));
                    }
                    if (zzb.zzh() > 0) {
                        zza(sb, i2 + 1);
                        sb.append("expression_list {\n");
                        for (String append : zzb.zzg()) {
                            zza(sb, i2 + 2);
                            sb.append(append);
                            sb.append("\n");
                        }
                        sb.append("}\n");
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
            if (zzc.zzc()) {
                zza(sb, i + 1, "number_filter", zzc.zzd());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private final void zza(StringBuilder sb, int i, String str, zzbu.zzd zzd) {
        if (zzd != null) {
            zza(sb, i);
            sb.append(str);
            sb.append(" {\n");
            if (zzd.zza()) {
                zza(sb, i, "comparison_type", (Object) zzd.zzb().name());
            }
            if (zzd.zzc()) {
                zza(sb, i, "match_as_float", (Object) Boolean.valueOf(zzd.zzd()));
            }
            if (zzd.zze()) {
                zza(sb, i, "comparison_value", (Object) zzd.zzf());
            }
            if (zzd.zzg()) {
                zza(sb, i, "min_comparison_value", (Object) zzd.zzh());
            }
            if (zzd.zzi()) {
                zza(sb, i, "max_comparison_value", (Object) zzd.zzj());
            }
            zza(sb, i);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, zzcc.zzi zzi, String str2) {
        if (zzi != null) {
            zza(sb, 3);
            sb.append(str);
            sb.append(" {\n");
            if (zzi.zzd() != 0) {
                zza(sb, 4);
                sb.append("results: ");
                int i2 = 0;
                for (Long next : zzi.zzc()) {
                    int i3 = i2 + 1;
                    if (i2 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next);
                    i2 = i3;
                }
                sb.append(10);
            }
            if (zzi.zzb() != 0) {
                zza(sb, 4);
                sb.append("status: ");
                int i4 = 0;
                for (Long next2 : zzi.zza()) {
                    int i5 = i4 + 1;
                    if (i4 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next2);
                    i4 = i5;
                }
                sb.append(10);
            }
            if (zzi.zzf() != 0) {
                zza(sb, 4);
                sb.append("dynamic_filter_timestamps: {");
                int i6 = 0;
                for (zzcc.zzb next3 : zzi.zze()) {
                    int i7 = i6 + 1;
                    if (i6 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next3.zza() ? Integer.valueOf(next3.zzb()) : null);
                    sb.append(":");
                    sb.append(next3.zzc() ? Long.valueOf(next3.zzd()) : null);
                    i6 = i7;
                }
                sb.append("}\n");
            }
            if (zzi.zzh() != 0) {
                zza(sb, 4);
                sb.append("sequence_filter_timestamps: {");
                int i8 = 0;
                for (zzcc.zzj next4 : zzi.zzg()) {
                    int i9 = i8 + 1;
                    if (i8 != 0) {
                        sb.append(", ");
                    }
                    sb.append(next4.zza() ? Integer.valueOf(next4.zzb()) : null);
                    sb.append(": [");
                    int i10 = 0;
                    for (Long longValue : next4.zzc()) {
                        long longValue2 = longValue.longValue();
                        int i11 = i10 + 1;
                        if (i10 != 0) {
                            sb.append(", ");
                        }
                        sb.append(longValue2);
                        i10 = i11;
                    }
                    sb.append("]");
                    i8 = i9;
                }
                sb.append("}\n");
            }
            zza(sb, 3);
            sb.append("}\n");
        }
    }

    private static void zza(StringBuilder sb, int i, String str, Object obj) {
        if (obj != null) {
            zza(sb, i + 1);
            sb.append(str);
            sb.append(": ");
            sb.append(obj);
            sb.append(10);
        }
    }

    private final void zza(StringBuilder sb, int i, List<zzcc.zze> list) {
        if (list != null) {
            int i2 = i + 1;
            for (zzcc.zze next : list) {
                if (next != null) {
                    zza(sb, i2);
                    sb.append("param {\n");
                    Double d = null;
                    if (!zzmo.zzb() || !zzt().zza(zzaq.zzcd)) {
                        zza(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zzb(next.zzb()));
                        zza(sb, i2, "string_value", (Object) next.zzd());
                        zza(sb, i2, "int_value", (Object) next.zze() ? Long.valueOf(next.zzf()) : null);
                        if (next.zzi()) {
                            d = Double.valueOf(next.zzj());
                        }
                        zza(sb, i2, "double_value", (Object) d);
                    } else {
                        zza(sb, i2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) next.zza() ? zzo().zzb(next.zzb()) : null);
                        zza(sb, i2, "string_value", (Object) next.zzc() ? next.zzd() : null);
                        zza(sb, i2, "int_value", (Object) next.zze() ? Long.valueOf(next.zzf()) : null);
                        if (next.zzi()) {
                            d = Double.valueOf(next.zzj());
                        }
                        zza(sb, i2, "double_value", (Object) d);
                        if (next.zzl() > 0) {
                            zza(sb, i2, next.zzk());
                        }
                    }
                    zza(sb, i2);
                    sb.append("}\n");
                }
            }
        }
    }

    @WorkerThread
    static boolean zza(zzao zzao, zzn zzn) {
        Preconditions.checkNotNull(zzao);
        Preconditions.checkNotNull(zzn);
        return !TextUtils.isEmpty(zzn.zzb) || !TextUtils.isEmpty(zzn.zzr);
    }

    static boolean zza(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    static boolean zza(List<Long> list, int i) {
        if (i >= (list.size() << 6)) {
            return false;
        }
        return ((1 << (i % 64)) & list.get(i / 64).longValue()) != 0;
    }

    /* renamed from: e_ */
    public final /* bridge */ /* synthetic */ zzo mo24432e_() {
        return super.mo24432e_();
    }

    /* access modifiers changed from: package-private */
    @WorkerThread
    public final long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        zzp().zzd();
        MessageDigest zzi = zzkw.zzi();
        if (zzi != null) {
            return zzkw.zza(zzi.digest(bArr));
        }
        zzr().zzf().zza("Failed to get MD5");
        return 0;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        zzr().zzf().zza("Failed to load parcelable from buffer");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002c, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002d, code lost:
        r1.recycle();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0030, code lost:
        throw r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T extends android.os.Parcelable> T zza(byte[] r5, android.os.Parcelable.Creator<T> r6) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            android.os.Parcel r1 = android.os.Parcel.obtain()
            int r2 = r5.length     // Catch:{ ParseException -> 0x001c }
            r3 = 0
            r1.unmarshall(r5, r3, r2)     // Catch:{ ParseException -> 0x001c }
            r1.setDataPosition(r3)     // Catch:{ ParseException -> 0x001c }
            java.lang.Object r5 = r6.createFromParcel(r1)     // Catch:{ ParseException -> 0x001c }
            android.os.Parcelable r5 = (android.os.Parcelable) r5     // Catch:{ ParseException -> 0x001c }
            r1.recycle()
            return r5
        L_0x001a:
            r5 = move-exception
            goto L_0x002d
        L_0x001c:
            com.google.android.gms.measurement.internal.zzez r5 = r4.zzr()     // Catch:{ all -> 0x001a }
            com.google.android.gms.measurement.internal.zzfb r5 = r5.zzf()     // Catch:{ all -> 0x001a }
            java.lang.String r6 = "Failed to load parcelable from buffer"
            r5.zza(r6)     // Catch:{ all -> 0x001a }
            r1.recycle()
            return r0
        L_0x002d:
            r1.recycle()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzks.zza(byte[], android.os.Parcelable$Creator):android.os.Parcelable");
    }

    /* access modifiers changed from: package-private */
    public final zzcc.zzc zza(zzal zzal) {
        zzcc.zzc.zza zzb = zzcc.zzc.zzj().zzb(zzal.zzd);
        Iterator<String> it = zzal.zze.iterator();
        while (it.hasNext()) {
            String next = it.next();
            zzcc.zze.zza zza = zzcc.zze.zzm().zza(next);
            zza(zza, zzal.zze.zza(next));
            zzb.zza(zza);
        }
        return (zzcc.zzc) ((zzib) zzb.zzv());
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbu.zzb zzb) {
        if (zzb == null) {
            return "null";
        }
        StringBuilder a = C0681a.m330a("\nevent_filter {\n");
        if (zzb.zza()) {
            zza(a, 0, "filter_id", (Object) Integer.valueOf(zzb.zzb()));
        }
        zza(a, 0, "event_name", (Object) zzo().zza(zzb.zzc()));
        String zza = zza(zzb.zzh(), zzb.zzi(), zzb.zzk());
        if (!zza.isEmpty()) {
            zza(a, 0, "filter_type", (Object) zza);
        }
        if (zzb.zzf()) {
            zza(a, 1, "event_count_filter", zzb.zzg());
        }
        if (zzb.zze() > 0) {
            a.append("  filters {\n");
            for (zzbu.zzc zza2 : zzb.zzd()) {
                zza(a, 2, zza2);
            }
        }
        zza(a, 1);
        a.append("}\n}\n");
        return a.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzbu.zze zze) {
        if (zze == null) {
            return "null";
        }
        StringBuilder a = C0681a.m330a("\nproperty_filter {\n");
        if (zze.zza()) {
            zza(a, 0, "filter_id", (Object) Integer.valueOf(zze.zzb()));
        }
        zza(a, 0, "property_name", (Object) zzo().zzc(zze.zzc()));
        String zza = zza(zze.zze(), zze.zzf(), zze.zzh());
        if (!zza.isEmpty()) {
            zza(a, 0, "filter_type", (Object) zza);
        }
        zza(a, 1, zze.zzd());
        a.append("}\n");
        return a.toString();
    }

    /* access modifiers changed from: package-private */
    public final String zza(zzcc.zzf zzf) {
        if (zzf == null) {
            return "";
        }
        StringBuilder a = C0681a.m330a("\nbatch {\n");
        for (zzcc.zzg next : zzf.zza()) {
            if (next != null) {
                zza(a, 1);
                a.append("bundle {\n");
                if (next.zza()) {
                    zza(a, 1, "protocol_version", (Object) Integer.valueOf(next.zzb()));
                }
                zza(a, 1, "platform", (Object) next.zzq());
                if (next.zzz()) {
                    zza(a, 1, "gmp_version", (Object) Long.valueOf(next.zzaa()));
                }
                if (next.zzab()) {
                    zza(a, 1, "uploading_gmp_version", (Object) Long.valueOf(next.zzac()));
                }
                if (next.zzbc()) {
                    zza(a, 1, "dynamite_version", (Object) Long.valueOf(next.zzbd()));
                }
                if (next.zzau()) {
                    zza(a, 1, "config_version", (Object) Long.valueOf(next.zzav()));
                }
                zza(a, 1, "gmp_app_id", (Object) next.zzam());
                zza(a, 1, "admob_app_id", (Object) next.zzbb());
                zza(a, 1, "app_id", (Object) next.zzx());
                zza(a, 1, "app_version", (Object) next.zzy());
                if (next.zzar()) {
                    zza(a, 1, "app_version_major", (Object) Integer.valueOf(next.zzas()));
                }
                zza(a, 1, "firebase_instance_id", (Object) next.zzaq());
                if (next.zzah()) {
                    zza(a, 1, "dev_cert_hash", (Object) Long.valueOf(next.zzai()));
                }
                zza(a, 1, "app_store", (Object) next.zzw());
                if (next.zzg()) {
                    zza(a, 1, "upload_timestamp_millis", (Object) Long.valueOf(next.zzh()));
                }
                if (next.zzi()) {
                    zza(a, 1, "start_timestamp_millis", (Object) Long.valueOf(next.zzj()));
                }
                if (next.zzk()) {
                    zza(a, 1, "end_timestamp_millis", (Object) Long.valueOf(next.zzl()));
                }
                if (next.zzm()) {
                    zza(a, 1, "previous_bundle_start_timestamp_millis", (Object) Long.valueOf(next.zzn()));
                }
                if (next.zzo()) {
                    zza(a, 1, "previous_bundle_end_timestamp_millis", (Object) Long.valueOf(next.zzp()));
                }
                zza(a, 1, "app_instance_id", (Object) next.zzag());
                zza(a, 1, "resettable_device_id", (Object) next.zzad());
                zza(a, 1, "device_id", (Object) next.zzat());
                zza(a, 1, "ds_id", (Object) next.zzay());
                if (next.zzae()) {
                    zza(a, 1, "limited_ad_tracking", (Object) Boolean.valueOf(next.zzaf()));
                }
                zza(a, 1, "os_version", (Object) next.zzr());
                zza(a, 1, "device_model", (Object) next.zzs());
                zza(a, 1, "user_default_language", (Object) next.zzt());
                if (next.zzu()) {
                    zza(a, 1, "time_zone_offset_minutes", (Object) Integer.valueOf(next.zzv()));
                }
                if (next.zzaj()) {
                    zza(a, 1, "bundle_sequential_index", (Object) Integer.valueOf(next.zzak()));
                }
                if (next.zzan()) {
                    zza(a, 1, "service_upload", (Object) Boolean.valueOf(next.zzao()));
                }
                zza(a, 1, "health_monitor", (Object) next.zzal());
                if (!zzt().zza(zzaq.zzcl) && next.zzaw() && next.zzax() != 0) {
                    zza(a, 1, "android_id", (Object) Long.valueOf(next.zzax()));
                }
                if (next.zzaz()) {
                    zza(a, 1, "retry_counter", (Object) Integer.valueOf(next.zzba()));
                }
                List<zzcc.zzk> zze = next.zze();
                if (zze != null) {
                    for (zzcc.zzk next2 : zze) {
                        if (next2 != null) {
                            zza(a, 2);
                            a.append("user_property {\n");
                            Double d = null;
                            zza(a, 2, "set_timestamp_millis", (Object) next2.zza() ? Long.valueOf(next2.zzb()) : null);
                            zza(a, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zzc(next2.zzc()));
                            zza(a, 2, "string_value", (Object) next2.zze());
                            zza(a, 2, "int_value", (Object) next2.zzf() ? Long.valueOf(next2.zzg()) : null);
                            if (next2.zzh()) {
                                d = Double.valueOf(next2.zzi());
                            }
                            zza(a, 2, "double_value", (Object) d);
                            zza(a, 2);
                            a.append("}\n");
                        }
                    }
                }
                List<zzcc.zza> zzap = next.zzap();
                String zzx = next.zzx();
                if (zzap != null) {
                    for (zzcc.zza next3 : zzap) {
                        if (next3 != null) {
                            zza(a, 2);
                            a.append("audience_membership {\n");
                            if (next3.zza()) {
                                zza(a, 2, "audience_id", (Object) Integer.valueOf(next3.zzb()));
                            }
                            if (next3.zzf()) {
                                zza(a, 2, "new_audience", (Object) Boolean.valueOf(next3.zzg()));
                            }
                            zza(a, 2, "current_data", next3.zzc(), zzx);
                            if (next3.zzd()) {
                                zza(a, 2, "previous_data", next3.zze(), zzx);
                            }
                            zza(a, 2);
                            a.append("}\n");
                        }
                    }
                }
                List<zzcc.zzc> zzc = next.zzc();
                if (zzc != null) {
                    for (zzcc.zzc next4 : zzc) {
                        if (next4 != null) {
                            zza(a, 2);
                            a.append("event {\n");
                            zza(a, 2, AppMeasurementSdk.ConditionalUserProperty.NAME, (Object) zzo().zza(next4.zzc()));
                            if (next4.zzd()) {
                                zza(a, 2, "timestamp_millis", (Object) Long.valueOf(next4.zze()));
                            }
                            if (next4.zzf()) {
                                zza(a, 2, "previous_timestamp_millis", (Object) Long.valueOf(next4.zzg()));
                            }
                            if (next4.zzh()) {
                                zza(a, 2, RFGSheetDialog.ARG_COUNT, (Object) Integer.valueOf(next4.zzi()));
                            }
                            if (next4.zzb() != 0) {
                                zza(a, 2, next4.zza());
                            }
                            zza(a, 2);
                            a.append("}\n");
                        }
                    }
                }
                zza(a, 1);
                a.append("}\n");
            }
        }
        a.append("}\n");
        return a.toString();
    }

    /* access modifiers changed from: package-private */
    public final List<Long> zza(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer next : list2) {
            if (next.intValue() < 0) {
                zzr().zzi().zza("Ignoring negative bit index to be cleared", next);
            } else {
                int intValue = next.intValue() / 64;
                if (intValue >= arrayList.size()) {
                    zzr().zzi().zza("Ignoring bit index greater than bitSet size", next, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(intValue, Long.valueOf(((Long) arrayList.get(intValue)).longValue() & ((1 << (next.intValue() % 64)) ^ -1)));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size >= 0 && ((Long) arrayList.get(size)).longValue() == 0) {
                size2 = size - 1;
            }
        }
        return arrayList.subList(0, i);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcc.zzc.zza zza, String str, Object obj) {
        List<zzcc.zze> zza2 = zza.zza();
        int i = 0;
        while (true) {
            if (i >= zza2.size()) {
                i = -1;
                break;
            } else if (str.equals(zza2.get(i).zzb())) {
                break;
            } else {
                i++;
            }
        }
        zzcc.zze.zza zza3 = zzcc.zze.zzm().zza(str);
        if (obj instanceof Long) {
            zza3.zza(((Long) obj).longValue());
        } else if (obj instanceof String) {
            zza3.zzb((String) obj);
        } else if (obj instanceof Double) {
            zza3.zza(((Double) obj).doubleValue());
        } else if (zzmo.zzb() && zzt().zza(zzaq.zzcf) && (obj instanceof Bundle[])) {
            zza3.zza((Iterable<? extends zzcc.zze>) zza((Bundle[]) obj));
        }
        if (i >= 0) {
            zza.zza(i, zza3);
        } else {
            zza.zza(zza3);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcc.zze.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc().zze();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zza(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else if (!zzmo.zzb() || !zzt().zza(zzaq.zzcf) || !(obj instanceof Bundle[])) {
            zzr().zzf().zza("Ignoring invalid (type) event param value", obj);
        } else {
            zza.zza((Iterable<? extends zzcc.zze>) zza((Bundle[]) obj));
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzcc.zzk.zza zza, Object obj) {
        Preconditions.checkNotNull(obj);
        zza.zza().zzb().zzc();
        if (obj instanceof String) {
            zza.zzb((String) obj);
        } else if (obj instanceof Long) {
            zza.zzb(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            zza.zza(((Double) obj).doubleValue());
        } else {
            zzr().zzf().zza("Ignoring invalid (type) user attribute value", obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(zzm().currentTimeMillis() - j) > j2;
    }

    /* access modifiers changed from: package-private */
    public final Object zzb(zzcc.zzc zzc, String str) {
        zzcc.zze zza = zza(zzc, str);
        if (zza == null) {
            return null;
        }
        if (zza.zzc()) {
            return zza.zzd();
        }
        if (zza.zze()) {
            return Long.valueOf(zza.zzf());
        }
        if (zza.zzi()) {
            return Double.valueOf(zza.zzj());
        }
        if (!zzmo.zzb() || !zzt().zza(zzaq.zzcf) || zza.zzl() <= 0) {
            return null;
        }
        List<zzcc.zze> zzk = zza.zzk();
        ArrayList arrayList = new ArrayList();
        for (zzcc.zze next : zzk) {
            if (next != null) {
                Bundle bundle = new Bundle();
                for (zzcc.zze next2 : next.zzk()) {
                    if (next2.zzc()) {
                        bundle.putString(next2.zzb(), next2.zzd());
                    } else if (next2.zze()) {
                        bundle.putLong(next2.zzb(), next2.zzf());
                    } else if (next2.zzi()) {
                        bundle.putDouble(next2.zzb(), next2.zzj());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzb(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = gZIPInputStream.read(bArr2);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr2, 0, read);
                } else {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
            }
        } catch (IOException e) {
            zzr().zzf().zza("Failed to ungzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    /* access modifiers changed from: package-private */
    public final byte[] zzc(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            zzr().zzf().zza("Failed to gzip content", e);
            throw e;
        }
    }

    public final /* bridge */ /* synthetic */ void zzd() {
        super.zzd();
    }

    /* access modifiers changed from: protected */
    public final boolean zze() {
        return false;
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public final List<Integer> zzf() {
        Map<String, String> zza = zzaq.zza(this.zza.zzn());
        if (zza == null || zza.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int intValue = zzaq.zzao.zza(null).intValue();
        Iterator<Map.Entry<String, String>> it = zza.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry next = it.next();
            if (((String) next.getKey()).startsWith("measurement.id.")) {
                try {
                    int parseInt = Integer.parseInt((String) next.getValue());
                    if (parseInt != 0) {
                        arrayList.add(Integer.valueOf(parseInt));
                        if (arrayList.size() >= intValue) {
                            zzr().zzi().zza("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    zzr().zzi().zza("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    public final /* bridge */ /* synthetic */ zzks zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzad zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzfx zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzai zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Clock zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ Context zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzex zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzkw zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzfw zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzez zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzfl zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzy zzt() {
        return super.zzt();
    }

    public final /* bridge */ /* synthetic */ zzx zzu() {
        return super.zzu();
    }
}
