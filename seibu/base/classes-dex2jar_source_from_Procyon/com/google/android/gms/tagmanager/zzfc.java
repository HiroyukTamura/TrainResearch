// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.eg;
import java.util.Iterator;
import com.google.android.gms.internal.zzbg;
import java.util.List;
import java.util.HashMap;
import java.util.Collection;
import java.util.HashSet;
import android.content.Context;
import com.google.android.gms.internal.em;
import java.util.Set;
import com.google.android.gms.internal.ei;
import java.util.Map;
import com.google.android.gms.internal.ek;
import com.google.android.gms.internal.zzbr;

final class zzfc
{
    private static final zzea<zzbr> zzbGe;
    private final DataLayer zzbDx;
    private final ek zzbGf;
    private final zzbo zzbGg;
    private final Map<String, com.google.android.gms.tagmanager.zzbr> zzbGh;
    private final Map<String, com.google.android.gms.tagmanager.zzbr> zzbGi;
    private final Map<String, com.google.android.gms.tagmanager.zzbr> zzbGj;
    private final zzp<ei, zzea<zzbr>> zzbGk;
    private final zzp<String, zzfi> zzbGl;
    private final Set<em> zzbGm;
    private final Map<String, zzfj> zzbGn;
    private volatile String zzbGo;
    private int zzbGp;
    
    static {
        zzbGe = new zzea<zzbr>(zzgk.zzCh(), true);
    }
    
    public zzfc(final Context context, final ek zzbGf, final DataLayer zzbDx, final zzan zzan, final zzan zzan2, final zzbo zzbGg) {
        if (zzbGf == null) {
            throw new NullPointerException("resource cannot be null");
        }
        this.zzbGf = zzbGf;
        this.zzbGm = new HashSet<em>(zzbGf.zzCX());
        this.zzbDx = zzbDx;
        this.zzbGg = zzbGg;
        final zzfd zzfd = new zzfd(this);
        new zzq();
        this.zzbGk = zzq.zza(1048576, zzfd);
        final zzfe zzfe = new zzfe(this);
        new zzq();
        this.zzbGl = zzq.zza(1048576, zzfe);
        this.zzbGh = new HashMap<String, com.google.android.gms.tagmanager.zzbr>();
        this.zzb(new zzm(context));
        this.zzb(new zzam(zzan2));
        this.zzb(new zzaz(zzbDx));
        this.zzb(new zzgl(context, zzbDx));
        this.zzbGi = new HashMap<String, com.google.android.gms.tagmanager.zzbr>();
        this.zzc(new zzak());
        this.zzc(new zzbl());
        this.zzc(new zzbm());
        this.zzc(new zzbt());
        this.zzc(new zzbu());
        this.zzc(new zzdf());
        this.zzc(new zzdg());
        this.zzc(new zzem());
        this.zzc(new zzfz());
        this.zzbGj = new HashMap<String, com.google.android.gms.tagmanager.zzbr>();
        this.zza(new zze(context));
        this.zza(new zzf(context));
        this.zza(new zzh(context));
        this.zza(new zzi(context));
        this.zza(new zzj(context));
        this.zza(new zzk(context));
        this.zza(new zzl(context));
        this.zza(new zzt());
        this.zza(new zzaj(this.zzbGf.getVersion()));
        this.zza(new zzam(zzan));
        this.zza(new zzas(zzbDx));
        this.zza(new zzbc(context));
        this.zza(new zzbd());
        this.zza(new zzbk());
        this.zza(new zzbp(this));
        this.zza(new zzbv());
        this.zza(new zzbw());
        this.zza(new zzcw(context));
        this.zza(new zzcy());
        this.zza(new zzde());
        this.zza(new zzdl());
        this.zza(new zzdn(context));
        this.zza(new zzeb());
        this.zza(new zzef());
        this.zza(new zzej());
        this.zza(new zzel());
        this.zza(new zzen(context));
        this.zza(new zzfk());
        this.zza(new zzfl());
        this.zza(new zzgf());
        this.zza(new zzgm());
        this.zzbGn = new HashMap<String, zzfj>();
        for (final em em : this.zzbGm) {
            for (int i = 0; i < em.zzDC().size(); ++i) {
                final ei ei = em.zzDC().get(i);
                final zzfj zzf = zzf(this.zzbGn, zza(ei));
                zzf.zza(em);
                zzf.zza(em, ei);
                zzf.zza(em, "Unknown");
            }
            for (int j = 0; j < em.zzDD().size(); ++j) {
                final ei ei2 = em.zzDD().get(j);
                final zzfj zzf2 = zzf(this.zzbGn, zza(ei2));
                zzf2.zza(em);
                zzf2.zzb(em, ei2);
                zzf2.zzb(em, "Unknown");
            }
        }
        for (final Map.Entry<String, List<ei>> entry : this.zzbGf.zzDA().entrySet()) {
            for (final ei ei3 : entry.getValue()) {
                if (!zzgk.zzf(ei3.zzCZ().get(zzbg.zzix.toString()))) {
                    zzf(this.zzbGn, entry.getKey()).zzb(ei3);
                }
            }
        }
    }
    
    private final String zzBL() {
        if (this.zzbGp <= 1) {
            return "";
        }
        final StringBuilder sb = new StringBuilder();
        sb.append(Integer.toString(this.zzbGp));
        for (int i = 2; i < this.zzbGp; ++i) {
            sb.append(' ');
        }
        sb.append(": ");
        return sb.toString();
    }
    
    private final zzea<Boolean> zza(final ei ei, final Set<String> set, final zzeo zzeo) {
        final zzea<zzbr> zza = this.zza(this.zzbGi, ei, set, zzeo);
        final Boolean zzf = zzgk.zzf(zza.getObject());
        zzgk.zzI(zzf);
        return new zzea<Boolean>(zzf, zza.zzBz());
    }
    
    private final zzea<Boolean> zza(final em em, final Set<String> set, final zzer zzer) {
        final Iterator<ei> iterator = em.zzDc().iterator();
        boolean b = true;
        while (iterator.hasNext()) {
            final zzea<Boolean> zza = this.zza(iterator.next(), set, zzer.zzBr());
            if (zza.getObject()) {
                zzgk.zzI(false);
                return new zzea<Boolean>(false, zza.zzBz());
            }
            b = (b && zza.zzBz());
        }
        final Iterator<ei> iterator2 = em.zzDb().iterator();
        while (iterator2.hasNext()) {
            final zzea<Boolean> zza2 = this.zza(iterator2.next(), set, zzer.zzBs());
            if (!zza2.getObject()) {
                zzgk.zzI(false);
                return new zzea<Boolean>(false, zza2.zzBz());
            }
            b = (b && zza2.zzBz());
        }
        zzgk.zzI(true);
        return new zzea<Boolean>(true, b);
    }
    
    private final zzea<zzbr> zza(final zzbr zzbr, final Set<String> set, final zzgn zzgn) {
        if (!zzbr.zzlN) {
            return new zzea<zzbr>(zzbr, true);
        }
        switch (zzbr.type) {
            default: {
                zzdj.e(new StringBuilder(25).append("Unknown type: ").append(zzbr.type).toString());
                return zzfc.zzbGe;
            }
            case 2: {
                final zzbr zzj = eg.zzj(zzbr);
                zzj.zzlE = new zzbr[zzbr.zzlE.length];
                for (int i = 0; i < zzbr.zzlE.length; ++i) {
                    final zzea<zzbr> zza = this.zza(zzbr.zzlE[i], set, zzgn.zzbz(i));
                    if (zza == zzfc.zzbGe) {
                        return zzfc.zzbGe;
                    }
                    zzj.zzlE[i] = zza.getObject();
                }
                return new zzea<zzbr>(zzj, false);
            }
            case 3: {
                final zzbr zzj2 = eg.zzj(zzbr);
                if (zzbr.zzlF.length != zzbr.zzlG.length) {
                    final String value = String.valueOf(zzbr.toString());
                    String concat;
                    if (value.length() != 0) {
                        concat = "Invalid serving value: ".concat(value);
                    }
                    else {
                        concat = new String("Invalid serving value: ");
                    }
                    zzdj.e(concat);
                    return zzfc.zzbGe;
                }
                zzj2.zzlF = new zzbr[zzbr.zzlF.length];
                zzj2.zzlG = new zzbr[zzbr.zzlF.length];
                for (int j = 0; j < zzbr.zzlF.length; ++j) {
                    final zzea<zzbr> zza2 = this.zza(zzbr.zzlF[j], set, zzgn.zzbA(j));
                    final zzea<zzbr> zza3 = this.zza(zzbr.zzlG[j], set, zzgn.zzbB(j));
                    if (zza2 == zzfc.zzbGe || zza3 == zzfc.zzbGe) {
                        return zzfc.zzbGe;
                    }
                    zzj2.zzlF[j] = zza2.getObject();
                    zzj2.zzlG[j] = zza3.getObject();
                }
                return new zzea<zzbr>(zzj2, false);
            }
            case 4: {
                if (set.contains(zzbr.zzlH)) {
                    final String value2 = String.valueOf(zzbr.zzlH);
                    final String value3 = String.valueOf(set.toString());
                    zzdj.e(new StringBuilder(String.valueOf(value2).length() + 79 + String.valueOf(value3).length()).append("Macro cycle detected.  Current macro reference: ").append(value2).append(".  Previous macro references: ").append(value3).append(".").toString());
                    return zzfc.zzbGe;
                }
                set.add(zzbr.zzlH);
                final zzea<zzbr> zza4 = zzgo.zza(this.zza(zzbr.zzlH, set, zzgn.zzBy()), zzbr.zzlM);
                set.remove(zzbr.zzlH);
                return zza4;
            }
            case 7: {
                final zzbr zzj3 = eg.zzj(zzbr);
                zzj3.zzlL = new zzbr[zzbr.zzlL.length];
                for (int k = 0; k < zzbr.zzlL.length; ++k) {
                    final zzea<zzbr> zza5 = this.zza(zzbr.zzlL[k], set, zzgn.zzbC(k));
                    if (zza5 == zzfc.zzbGe) {
                        return zzfc.zzbGe;
                    }
                    zzj3.zzlL[k] = zza5.getObject();
                }
                return new zzea<zzbr>(zzj3, false);
            }
        }
    }
    
    private final zzea<zzbr> zza(final String s, final Set<String> set, final zzdm zzdm) {
        ++this.zzbGp;
        final zzfi zzfi = this.zzbGl.get(s);
        if (zzfi != null) {
            this.zza(zzfi.zzBN(), set);
            --this.zzbGp;
            return zzfi.zzBM();
        }
        final zzfj zzfj = this.zzbGn.get(s);
        if (zzfj == null) {
            final String value = String.valueOf(this.zzBL());
            zzdj.e(new StringBuilder(String.valueOf(value).length() + 15 + String.valueOf(s).length()).append(value).append("Invalid macro: ").append(s).toString());
            --this.zzbGp;
            return zzfc.zzbGe;
        }
        final zzea<Set<ei>> zza = this.zza(s, zzfj.zzBO(), zzfj.zzBP(), zzfj.zzBQ(), zzfj.zzBS(), zzfj.zzBR(), set, zzdm.zzAZ());
        ei zzBT;
        if (zza.getObject().isEmpty()) {
            zzBT = zzfj.zzBT();
        }
        else {
            if (zza.getObject().size() > 1) {
                final String value2 = String.valueOf(this.zzBL());
                zzdj.zzaT(new StringBuilder(String.valueOf(value2).length() + 37 + String.valueOf(s).length()).append(value2).append("Multiple macros active for macroName ").append(s).toString());
            }
            zzBT = zza.getObject().iterator().next();
        }
        if (zzBT == null) {
            --this.zzbGp;
            return zzfc.zzbGe;
        }
        final zzea<zzbr> zza2 = this.zza(this.zzbGj, zzBT, set, zzdm.zzBq());
        final boolean b = zza.zzBz() && zza2.zzBz();
        zzea<zzbr> zzbGe;
        if (zza2 == zzfc.zzbGe) {
            zzbGe = zzfc.zzbGe;
        }
        else {
            zzbGe = new zzea<zzbr>(zza2.getObject(), b);
        }
        final zzbr zzBN = zzBT.zzBN();
        if (zzbGe.zzBz()) {
            this.zzbGl.zzf(s, new zzfi(zzbGe, zzBN));
        }
        this.zza(zzBN, set);
        --this.zzbGp;
        return zzbGe;
    }
    
    private final zzea<Set<ei>> zza(final String s, final Set<em> set, final Map<em, List<ei>> map, final Map<em, List<String>> map2, final Map<em, List<ei>> map3, final Map<em, List<String>> map4, final Set<String> set2, final zzfb zzfb) {
        return this.zza(set, set2, new zzff(this, map, map2, map3, map4), zzfb);
    }
    
    private final zzea<zzbr> zza(final Map<String, com.google.android.gms.tagmanager.zzbr> map, final ei ei, final Set<String> set, final zzeo zzeo) {
        boolean b = true;
        final zzbr zzbr = ei.zzCZ().get(zzbg.zzhG.toString());
        zzea<zzbr> zzbGe;
        if (zzbr == null) {
            zzdj.e("No function id in properties");
            zzbGe = zzfc.zzbGe;
        }
        else {
            final String zzlI = zzbr.zzlI;
            final com.google.android.gms.tagmanager.zzbr zzbr2 = map.get(zzlI);
            if (zzbr2 == null) {
                zzdj.e(String.valueOf(zzlI).concat(" has no backing implementation."));
                return zzfc.zzbGe;
            }
            if ((zzbGe = this.zzbGk.get(ei)) == null) {
                final HashMap<String, Object> hashMap = new HashMap<String, Object>();
                final Iterator<Map.Entry<String, zzbr>> iterator = ei.zzCZ().entrySet().iterator();
                boolean b2 = true;
                while (iterator.hasNext()) {
                    final Map.Entry<String, zzbr> entry = iterator.next();
                    final zzea<zzbr> zza = this.zza(entry.getValue(), set, zzeo.zzfp(entry.getKey()).zza(entry.getValue()));
                    if (zza == zzfc.zzbGe) {
                        return zzfc.zzbGe;
                    }
                    if (zza.zzBz()) {
                        ei.zza(entry.getKey(), zza.getObject());
                    }
                    else {
                        b2 = false;
                    }
                    hashMap.put(entry.getKey(), zza.getObject());
                }
                if (!zzbr2.zzd(hashMap.keySet())) {
                    final String value = String.valueOf(zzbr2.zzBl());
                    final String value2 = String.valueOf(hashMap.keySet());
                    zzdj.e(new StringBuilder(String.valueOf(zzlI).length() + 43 + String.valueOf(value).length() + String.valueOf(value2).length()).append("Incorrect keys for function ").append(zzlI).append(" required ").append(value).append(" had ").append(value2).toString());
                    return zzfc.zzbGe;
                }
                if (!b2 || !zzbr2.zzAE()) {
                    b = false;
                }
                final zzea<zzbr> zzea = zzbGe = new zzea<zzbr>(zzbr2.zzo((Map<String, zzbr>)hashMap), b);
                if (b) {
                    this.zzbGk.zzf(ei, zzea);
                    return zzea;
                }
            }
        }
        return zzbGe;
    }
    
    private final zzea<Set<ei>> zza(final Set<em> set, final Set<String> set2, final zzfh zzfh, final zzfb zzfb) {
        final HashSet<ei> set3 = new HashSet<ei>();
        final HashSet<ei> set4 = new HashSet<ei>();
        final Iterator<em> iterator = set.iterator();
        boolean b = true;
        while (iterator.hasNext()) {
            final em em = iterator.next();
            final zzer zzBx = zzfb.zzBx();
            final zzea<Boolean> zza = this.zza(em, set2, zzBx);
            if (zza.getObject()) {
                zzfh.zza(em, set3, set4, zzBx);
            }
            b = (b && zza.zzBz());
        }
        set3.removeAll(set4);
        return new zzea<Set<ei>>(set3, b);
    }
    
    private static String zza(final ei ei) {
        return zzgk.zzb(ei.zzCZ().get(zzbg.zzhS.toString()));
    }
    
    private final void zza(final zzbr zzbr, final Set<String> set) {
        if (zzbr != null) {
            final zzea<zzbr> zza = this.zza(zzbr, set, new zzdy());
            if (zza != zzfc.zzbGe) {
                final Object zzg = zzgk.zzg(zza.getObject());
                if (zzg instanceof Map) {
                    this.zzbDx.push((Map<String, Object>)zzg);
                    return;
                }
                if (!(zzg instanceof List)) {
                    zzdj.zzaT("pushAfterEvaluate: value not a Map or List");
                    return;
                }
                for (final Map<String, Object> next : (List<Object>)zzg) {
                    if (next instanceof Map) {
                        this.zzbDx.push(next);
                    }
                    else {
                        zzdj.zzaT("pushAfterEvaluate: value not a Map");
                    }
                }
            }
        }
    }
    
    private final void zza(final com.google.android.gms.tagmanager.zzbr zzbr) {
        zza(this.zzbGj, zzbr);
    }
    
    private static void zza(final Map<String, com.google.android.gms.tagmanager.zzbr> map, final com.google.android.gms.tagmanager.zzbr zzbr) {
        if (map.containsKey(zzbr.zzBk())) {
            final String value = String.valueOf(zzbr.zzBk());
            String concat;
            if (value.length() != 0) {
                concat = "Duplicate function type name: ".concat(value);
            }
            else {
                concat = new String("Duplicate function type name: ");
            }
            throw new IllegalArgumentException(concat);
        }
        map.put(zzbr.zzBk(), zzbr);
    }
    
    private final void zzb(final com.google.android.gms.tagmanager.zzbr zzbr) {
        zza(this.zzbGh, zzbr);
    }
    
    private final void zzc(final com.google.android.gms.tagmanager.zzbr zzbr) {
        zza(this.zzbGi, zzbr);
    }
    
    private static zzfj zzf(final Map<String, zzfj> map, final String s) {
        zzfj zzfj;
        if ((zzfj = map.get(s)) == null) {
            zzfj = new zzfj();
            map.put(s, zzfj);
        }
        return zzfj;
    }
    
    private final void zzft(final String zzbGo) {
        synchronized (this) {
            this.zzbGo = zzbGo;
        }
    }
    
    final String zzBK() {
        synchronized (this) {
            return this.zzbGo;
        }
    }
    
    public final void zzL(final List<com.google.android.gms.internal.zzbp> list) {
        while (true) {
            while (true) {
                Object value = null;
                Label_0094: {
                    synchronized (this) {
                        final Iterator<com.google.android.gms.internal.zzbp> iterator = list.iterator();
                        while (iterator.hasNext()) {
                            value = iterator.next();
                            if (((com.google.android.gms.internal.zzbp)value).name != null && ((com.google.android.gms.internal.zzbp)value).name.startsWith("gaExperiment:")) {
                                break Label_0094;
                            }
                            value = String.valueOf(value);
                            zzdj.v(new StringBuilder(String.valueOf(value).length() + 22).append("Ignored supplemental: ").append((String)value).toString());
                        }
                        break;
                    }
                }
                zzbq.zza(this.zzbDx, (com.google.android.gms.internal.zzbp)value);
                continue;
            }
        }
    }
    // monitorexit(this)
    
    public final void zzeZ(final String s) {
        synchronized (this) {
            this.zzft(s);
            final zzar zzBj = this.zzbGg.zzfj(s).zzBj();
            final Iterator<ei> iterator = this.zza(this.zzbGm, new HashSet<String>(), new zzfg(this), zzBj.zzAZ()).getObject().iterator();
            while (iterator.hasNext()) {
                this.zza(this.zzbGh, iterator.next(), new HashSet<String>(), zzBj.zzAY());
            }
        }
        this.zzft(null);
    }
    // monitorexit(this)
    
    public final zzea<zzbr> zzfs(final String s) {
        this.zzbGp = 0;
        return this.zza(s, new HashSet<String>(), this.zzbGg.zzfi(s).zzBi());
    }
}
