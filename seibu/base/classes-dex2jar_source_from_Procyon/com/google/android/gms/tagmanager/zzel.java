// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import java.util.regex.Matcher;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Pattern;
import java.util.Map;
import com.google.android.gms.internal.zzbg;
import com.google.android.gms.internal.zzbf;

final class zzel extends zzbr
{
    private static final String ID;
    private static final String zzbFP;
    private static final String zzbFQ;
    private static final String zzbFR;
    private static final String zzbFS;
    
    static {
        ID = zzbf.zzeb.toString();
        zzbFP = zzbg.zzfR.toString();
        zzbFQ = zzbg.zzfS.toString();
        zzbFR = zzbg.zzhP.toString();
        zzbFS = zzbg.zzhI.toString();
    }
    
    public zzel() {
        super(zzel.ID, new String[] { zzel.zzbFP, zzel.zzbFQ });
    }
    
    @Override
    public final boolean zzAE() {
        return true;
    }
    
    @Override
    public final com.google.android.gms.internal.zzbr zzo(final Map<String, com.google.android.gms.internal.zzbr> map) {
        final com.google.android.gms.internal.zzbr zzbr = map.get(zzel.zzbFP);
        final com.google.android.gms.internal.zzbr zzbr2 = map.get(zzel.zzbFQ);
        if (zzbr == null || zzbr == zzgk.zzCh() || zzbr2 == null || zzbr2 == zzgk.zzCh()) {
            return zzgk.zzCh();
        }
        int flags = 64;
        if (zzgk.zzf(map.get(zzel.zzbFR))) {
            flags = 66;
        }
        final com.google.android.gms.internal.zzbr zzbr3 = map.get(zzel.zzbFS);
        int intValue;
        if (zzbr3 != null) {
            final Long zzd = zzgk.zzd(zzbr3);
            if (zzd == zzgk.zzCc()) {
                return zzgk.zzCh();
            }
            if ((intValue = zzd.intValue()) < 0) {
                return zzgk.zzCh();
            }
        }
        else {
            intValue = 1;
        }
        try {
            final String zzb = zzgk.zzb(zzbr);
            final String zzb2 = zzgk.zzb(zzbr2);
            final Object o = null;
            final Matcher matcher = Pattern.compile(zzb2, flags).matcher(zzb);
            Object group = o;
            if (matcher.find()) {
                group = o;
                if (matcher.groupCount() >= intValue) {
                    group = matcher.group(intValue);
                }
            }
            if (group == null) {
                return zzgk.zzCh();
            }
            return zzgk.zzI(group);
        }
        catch (PatternSyntaxException ex) {
            return zzgk.zzCh();
        }
    }
}
