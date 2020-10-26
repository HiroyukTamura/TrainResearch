// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.common.util.zze;
import java.util.Iterator;
import android.os.Bundle;
import android.content.Context;
import android.support.annotation.Nullable;
import com.google.android.gms.common.internal.zzbo;
import com.google.android.gms.measurement.AppMeasurement;

public final class zzcfj extends zzchj
{
    private static String[] zzbqI;
    private static String[] zzbqJ;
    private static String[] zzbqK;
    
    static {
        zzcfj.zzbqI = new String[AppMeasurement.Event.zzbof.length];
        zzcfj.zzbqJ = new String[AppMeasurement.Param.zzboh.length];
        zzcfj.zzbqK = new String[AppMeasurement.UserProperty.zzbom.length];
    }
    
    zzcfj(final zzcgl zzcgl) {
        super(zzcgl);
    }
    
    @Nullable
    private static String zza(String s, final String[] array, final String[] array2, final String[] array3) {
        final boolean b = true;
        int i = 0;
        zzbo.zzu(array);
        zzbo.zzu(array2);
        zzbo.zzu(array3);
        zzbo.zzaf(array.length == array2.length);
        zzbo.zzaf(array.length == array3.length && b);
        while (i < array.length) {
            if (zzcjl.zzR(s, array[i])) {
                // monitorenter(array3)
                Label_0127: {
                    if (array3[i] != null) {
                        break Label_0127;
                    }
                    try {
                        final StringBuilder sb = new StringBuilder();
                        sb.append(array2[i]);
                        sb.append("(");
                        sb.append(array[i]);
                        sb.append(")");
                        array3[i] = sb.toString();
                        s = array3[i];
                        return s;
                    }
                    finally {
                    }
                    // monitorexit(array3)
                }
            }
            ++i;
        }
        return s;
    }
    
    private static void zza(final StringBuilder sb, final int n) {
        for (int i = 0; i < n; ++i) {
            sb.append("  ");
        }
    }
    
    private final void zza(final StringBuilder sb, final int n, final zzcjo zzcjo) {
        if (zzcjo == null) {
            return;
        }
        zza(sb, n);
        sb.append("filter {\n");
        zza(sb, n, "complement", zzcjo.zzbuU);
        zza(sb, n, "param_name", this.zzdX(zzcjo.zzbuV));
        final int n2 = n + 1;
        final zzcjr zzbuS = zzcjo.zzbuS;
        if (zzbuS != null) {
            zza(sb, n2);
            sb.append("string_filter");
            sb.append(" {\n");
            if (zzbuS.zzbve != null) {
                String s = "UNKNOWN_MATCH_TYPE";
                switch (zzbuS.zzbve) {
                    case 1: {
                        s = "REGEXP";
                        break;
                    }
                    case 2: {
                        s = "BEGINS_WITH";
                        break;
                    }
                    case 3: {
                        s = "ENDS_WITH";
                        break;
                    }
                    case 4: {
                        s = "PARTIAL";
                        break;
                    }
                    case 5: {
                        s = "EXACT";
                        break;
                    }
                    case 6: {
                        s = "IN_LIST";
                        break;
                    }
                }
                zza(sb, n2, "match_type", s);
            }
            zza(sb, n2, "expression", zzbuS.zzbvf);
            zza(sb, n2, "case_sensitive", zzbuS.zzbvg);
            if (zzbuS.zzbvh.length > 0) {
                zza(sb, n2 + 1);
                sb.append("expression_list {\n");
                final String[] zzbvh = zzbuS.zzbvh;
                for (int length = zzbvh.length, i = 0; i < length; ++i) {
                    final String str = zzbvh[i];
                    zza(sb, n2 + 2);
                    sb.append(str);
                    sb.append("\n");
                }
                sb.append("}\n");
            }
            zza(sb, n2);
            sb.append("}\n");
        }
        this.zza(sb, n + 1, "number_filter", zzcjo.zzbuT);
        zza(sb, n);
        sb.append("}\n");
    }
    
    private final void zza(final StringBuilder sb, final int n, String str, final zzcjp zzcjp) {
        if (zzcjp == null) {
            return;
        }
        zza(sb, n);
        sb.append(str);
        sb.append(" {\n");
        if (zzcjp.zzbuW != null) {
            str = "UNKNOWN_COMPARISON_TYPE";
            switch (zzcjp.zzbuW) {
                case 1: {
                    str = "LESS_THAN";
                    break;
                }
                case 2: {
                    str = "GREATER_THAN";
                    break;
                }
                case 3: {
                    str = "EQUAL";
                    break;
                }
                case 4: {
                    str = "BETWEEN";
                    break;
                }
            }
            zza(sb, n, "comparison_type", str);
        }
        zza(sb, n, "match_as_float", zzcjp.zzbuX);
        zza(sb, n, "comparison_value", zzcjp.zzbuY);
        zza(sb, n, "min_comparison_value", zzcjp.zzbuZ);
        zza(sb, n, "max_comparison_value", zzcjp.zzbva);
        zza(sb, n);
        sb.append("}\n");
    }
    
    private static void zza(final StringBuilder sb, int n, final String str, final zzcka zzcka) {
        final int n2 = 0;
        if (zzcka == null) {
            return;
        }
        final int n3 = n + 1;
        zza(sb, n3);
        sb.append(str);
        sb.append(" {\n");
        if (zzcka.zzbwf != null) {
            zza(sb, n3 + 1);
            sb.append("results: ");
            final long[] zzbwf = zzcka.zzbwf;
            int length;
            int i;
            long l;
            for (length = zzbwf.length, i = 0, n = 0; i < length; ++i, ++n) {
                l = zzbwf[i];
                if (n != 0) {
                    sb.append(", ");
                }
                sb.append((Object)l);
            }
            sb.append('\n');
        }
        if (zzcka.zzbwe != null) {
            zza(sb, n3 + 1);
            sb.append("status: ");
            final long[] zzbwe = zzcka.zzbwe;
            final int length2 = zzbwe.length;
            n = 0;
            for (int j = n2; j < length2; ++j, ++n) {
                final long k = zzbwe[j];
                if (n != 0) {
                    sb.append(", ");
                }
                sb.append((Object)k);
            }
            sb.append('\n');
        }
        zza(sb, n3);
        sb.append("}\n");
    }
    
    private static void zza(final StringBuilder sb, final int n, final String str, final Object obj) {
        if (obj == null) {
            return;
        }
        zza(sb, n + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }
    
    private final void zza(final StringBuilder sb, int i, final zzcjv[] array) {
        if (array != null) {
            int length;
            zzcjv zzcjv;
            for (length = array.length, i = 0; i < length; ++i) {
                zzcjv = array[i];
                if (zzcjv != null) {
                    zza(sb, 2);
                    sb.append("audience_membership {\n");
                    zza(sb, 2, "audience_id", zzcjv.zzbuI);
                    zza(sb, 2, "new_audience", zzcjv.zzbvu);
                    zza(sb, 2, "current_data", zzcjv.zzbvs);
                    zza(sb, 2, "previous_data", zzcjv.zzbvt);
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }
    
    private final void zza(final StringBuilder sb, int i, final zzcjw[] array) {
        if (array != null) {
            int length;
            zzcjw zzcjw;
            zzcjx[] zzbvw;
            int length2;
            int j;
            zzcjx zzcjx;
            for (length = array.length, i = 0; i < length; ++i) {
                zzcjw = array[i];
                if (zzcjw != null) {
                    zza(sb, 2);
                    sb.append("event {\n");
                    zza(sb, 2, "name", this.zzdW(zzcjw.name));
                    zza(sb, 2, "timestamp_millis", zzcjw.zzbvx);
                    zza(sb, 2, "previous_timestamp_millis", zzcjw.zzbvy);
                    zza(sb, 2, "count", zzcjw.count);
                    zzbvw = zzcjw.zzbvw;
                    if (zzbvw != null) {
                        for (length2 = zzbvw.length, j = 0; j < length2; ++j) {
                            zzcjx = zzbvw[j];
                            if (zzcjx != null) {
                                zza(sb, 3);
                                sb.append("param {\n");
                                zza(sb, 3, "name", this.zzdX(zzcjx.name));
                                zza(sb, 3, "string_value", zzcjx.zzaIF);
                                zza(sb, 3, "int_value", zzcjx.zzbvA);
                                zza(sb, 3, "double_value", zzcjx.zzbuB);
                                zza(sb, 3);
                                sb.append("}\n");
                            }
                        }
                    }
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }
    
    private final void zza(final StringBuilder sb, int i, final zzckb[] array) {
        if (array != null) {
            int length;
            zzckb zzckb;
            for (length = array.length, i = 0; i < length; ++i) {
                zzckb = array[i];
                if (zzckb != null) {
                    zza(sb, 2);
                    sb.append("user_property {\n");
                    zza(sb, 2, "set_timestamp_millis", zzckb.zzbwh);
                    zza(sb, 2, "name", this.zzdY(zzckb.name));
                    zza(sb, 2, "string_value", zzckb.zzaIF);
                    zza(sb, 2, "int_value", zzckb.zzbvA);
                    zza(sb, 2, "double_value", zzckb.zzbuB);
                    zza(sb, 2);
                    sb.append("}\n");
                }
            }
        }
    }
    
    @Nullable
    private final String zzb(final zzcew zzcew) {
        if (zzcew == null) {
            return null;
        }
        if (!this.zzyw()) {
            return zzcew.toString();
        }
        return this.zzA(zzcew.zzyt());
    }
    
    private final boolean zzyw() {
        return this.zzboe.zzwF().zzz(3);
    }
    
    @Nullable
    protected final String zzA(final Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        if (!this.zzyw()) {
            return bundle.toString();
        }
        final StringBuilder sb = new StringBuilder();
        for (final String s : bundle.keySet()) {
            if (sb.length() != 0) {
                sb.append(", ");
            }
            else {
                sb.append("Bundle[{");
            }
            sb.append(this.zzdX(s));
            sb.append("=");
            sb.append(bundle.get(s));
        }
        sb.append("}]");
        return sb.toString();
    }
    
    @Nullable
    protected final String zza(final zzceu zzceu) {
        if (zzceu == null) {
            return null;
        }
        if (!this.zzyw()) {
            return zzceu.toString();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("Event{appId='");
        sb.append(zzceu.mAppId);
        sb.append("', name='");
        sb.append(this.zzdW(zzceu.mName));
        sb.append("', params=");
        sb.append(this.zzb(zzceu.zzbpF));
        sb.append("}");
        return sb.toString();
    }
    
    protected final String zza(final zzcjn zzcjn) {
        int i = 0;
        if (zzcjn == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        zza(sb, 0, "filter_id", zzcjn.zzbuM);
        zza(sb, 0, "event_name", this.zzdW(zzcjn.zzbuN));
        this.zza(sb, 1, "event_count_filter", zzcjn.zzbuQ);
        sb.append("  filters {\n");
        for (zzcjo[] zzbuO = zzcjn.zzbuO; i < zzbuO.length; ++i) {
            this.zza(sb, 2, zzbuO[i]);
        }
        zza(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }
    
    protected final String zza(final zzcjq zzcjq) {
        if (zzcjq == null) {
            return "null";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        zza(sb, 0, "filter_id", zzcjq.zzbuM);
        zza(sb, 0, "property_name", this.zzdY(zzcjq.zzbvc));
        this.zza(sb, 1, zzcjq.zzbvd);
        sb.append("}\n");
        return sb.toString();
    }
    
    protected final String zza(final zzcjy zzcjy) {
        final StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (zzcjy.zzbvB != null) {
            final zzcjz[] zzbvB = zzcjy.zzbvB;
            for (int length = zzbvB.length, i = 0; i < length; ++i) {
                final zzcjz zzcjz = zzbvB[i];
                if (zzcjz != null && zzcjz != null) {
                    zza(sb, 1);
                    sb.append("bundle {\n");
                    zza(sb, 1, "protocol_version", zzcjz.zzbvD);
                    zza(sb, 1, "platform", zzcjz.zzbvL);
                    zza(sb, 1, "gmp_version", zzcjz.zzbvP);
                    zza(sb, 1, "uploading_gmp_version", zzcjz.zzbvQ);
                    zza(sb, 1, "config_version", zzcjz.zzbwb);
                    zza(sb, 1, "gmp_app_id", zzcjz.zzboQ);
                    zza(sb, 1, "app_id", zzcjz.zzaH);
                    zza(sb, 1, "app_version", zzcjz.zzbgW);
                    zza(sb, 1, "app_version_major", zzcjz.zzbvY);
                    zza(sb, 1, "firebase_instance_id", zzcjz.zzboY);
                    zza(sb, 1, "dev_cert_hash", zzcjz.zzbvU);
                    zza(sb, 1, "app_store", zzcjz.zzboR);
                    zza(sb, 1, "upload_timestamp_millis", zzcjz.zzbvG);
                    zza(sb, 1, "start_timestamp_millis", zzcjz.zzbvH);
                    zza(sb, 1, "end_timestamp_millis", zzcjz.zzbvI);
                    zza(sb, 1, "previous_bundle_start_timestamp_millis", zzcjz.zzbvJ);
                    zza(sb, 1, "previous_bundle_end_timestamp_millis", zzcjz.zzbvK);
                    zza(sb, 1, "app_instance_id", zzcjz.zzbvT);
                    zza(sb, 1, "resettable_device_id", zzcjz.zzbvR);
                    zza(sb, 1, "limited_ad_tracking", zzcjz.zzbvS);
                    zza(sb, 1, "os_version", zzcjz.zzaY);
                    zza(sb, 1, "device_model", zzcjz.zzbvM);
                    zza(sb, 1, "user_default_language", zzcjz.zzbvN);
                    zza(sb, 1, "time_zone_offset_minutes", zzcjz.zzbvO);
                    zza(sb, 1, "bundle_sequential_index", zzcjz.zzbvV);
                    zza(sb, 1, "service_upload", zzcjz.zzbvW);
                    zza(sb, 1, "health_monitor", zzcjz.zzboU);
                    if (zzcjz.zzbwc != 0L) {
                        zza(sb, 1, "android_id", zzcjz.zzbwc);
                    }
                    this.zza(sb, 1, zzcjz.zzbvF);
                    this.zza(sb, 1, zzcjz.zzbvX);
                    this.zza(sb, 1, zzcjz.zzbvE);
                    zza(sb, 1);
                    sb.append("}\n");
                }
            }
        }
        sb.append("}\n");
        return sb.toString();
    }
    
    @Nullable
    protected final String zzb(final zzcez zzcez) {
        if (zzcez == null) {
            return null;
        }
        if (!this.zzyw()) {
            return zzcez.toString();
        }
        final StringBuilder sb = new StringBuilder();
        sb.append("origin=");
        sb.append(zzcez.zzbpc);
        sb.append(",name=");
        sb.append(this.zzdW(zzcez.name));
        sb.append(",params=");
        sb.append(this.zzb(zzcez.zzbpM));
        return sb.toString();
    }
    
    @Nullable
    protected final String zzdW(final String s) {
        String s2;
        if (s == null) {
            s2 = null;
        }
        else {
            s2 = s;
            if (this.zzyw()) {
                return zza(s, AppMeasurement.Event.zzbog, AppMeasurement.Event.zzbof, zzcfj.zzbqI);
            }
        }
        return s2;
    }
    
    @Nullable
    protected final String zzdX(final String s) {
        String s2;
        if (s == null) {
            s2 = null;
        }
        else {
            s2 = s;
            if (this.zzyw()) {
                return zza(s, AppMeasurement.Param.zzboi, AppMeasurement.Param.zzboh, zzcfj.zzbqJ);
            }
        }
        return s2;
    }
    
    @Nullable
    protected final String zzdY(final String str) {
        String s;
        if (str == null) {
            s = null;
        }
        else {
            s = str;
            if (this.zzyw()) {
                if (str.startsWith("_exp_")) {
                    final StringBuilder sb = new StringBuilder();
                    sb.append("experiment_id");
                    sb.append("(");
                    sb.append(str);
                    sb.append(")");
                    return sb.toString();
                }
                return zza(str, AppMeasurement.UserProperty.zzbon, AppMeasurement.UserProperty.zzbom, zzcfj.zzbqK);
            }
        }
        return s;
    }
    
    @Override
    protected final void zzjD() {
    }
}
