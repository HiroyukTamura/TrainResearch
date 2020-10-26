// 
// Decompiled by Procyon v0.5.36
// 

package com.google.android.gms.internal;

import com.google.android.gms.tagmanager.zzdj;
import java.io.IOException;
import java.io.OutputStream;
import java.io.InputStream;
import com.google.android.gms.tagmanager.zzgk;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;

public final class eg
{
    private static ei zza(final zzbj zzbj, final zzbn zzbn, final zzbr[] array, int i) throws eo {
        final ej zzDx = ei.zzDx();
        final int[] zzkA = zzbj.zzkA;
        int length;
        zzbm zzbm;
        String anObject;
        zzbr zzbr;
        for (length = zzkA.length, i = 0; i < length; ++i) {
            zzbm = zza(zzbn.zzkQ, zzkA[i], "properties");
            anObject = zza(zzbn.zzkO, zzbm.key, "keys");
            zzbr = zza(array, zzbm.value, "values");
            if (zzbg.zziZ.toString().equals(anObject)) {
                zzDx.zzl(zzbr);
            }
            else {
                zzDx.zzb(anObject, zzbr);
            }
        }
        return zzDx.zzDy();
    }
    
    public static ek zza(final zzbn zzbn) throws eo {
        final int n = 0;
        final zzbr[] array = new zzbr[zzbn.zzkP.length];
        for (int i = 0; i < zzbn.zzkP.length; ++i) {
            zza(i, zzbn, array, new HashSet<Integer>(0));
        }
        final el zzDz = ek.zzDz();
        final ArrayList<ei> list = new ArrayList<ei>();
        for (int j = 0; j < zzbn.zzkS.length; ++j) {
            list.add(zza(zzbn.zzkS[j], zzbn, array, j));
        }
        final ArrayList<ei> list2 = new ArrayList<ei>();
        for (int k = 0; k < zzbn.zzkT.length; ++k) {
            list2.add(zza(zzbn.zzkT[k], zzbn, array, k));
        }
        final ArrayList<ei> list3 = new ArrayList<ei>();
        for (int l = 0; l < zzbn.zzkR.length; ++l) {
            final ei zza = zza(zzbn.zzkR[l], zzbn, array, l);
            zzDz.zzc(zza);
            list3.add(zza);
        }
        final zzbo[] zzkU = zzbn.zzkU;
        for (int length = zzkU.length, n2 = n; n2 < length; ++n2) {
            zzDz.zzb(zza(zzkU[n2], list, list3, list2, zzbn));
        }
        zzDz.zzgd(zzbn.version);
        zzDz.zzbJ(zzbn.zzlc);
        return zzDz.zzDB();
    }
    
    private static em zza(final zzbo zzbo, final List<ei> list, final List<ei> list2, final List<ei> list3, final zzbn zzbn) {
        final en en = new en(null);
        final int[] zzle = zzbo.zzle;
        for (int length = zzle.length, i = 0; i < length; ++i) {
            en.zzd(list3.get(zzle[i]));
        }
        final int[] zzlf = zzbo.zzlf;
        for (int length2 = zzlf.length, j = 0; j < length2; ++j) {
            en.zze(list3.get(zzlf[j]));
        }
        final int[] zzlg = zzbo.zzlg;
        for (int length3 = zzlg.length, k = 0; k < length3; ++k) {
            en.zzf(list.get(zzlg[k]));
        }
        final int[] zzli = zzbo.zzli;
        for (int length4 = zzli.length, l = 0; l < length4; ++l) {
            en.zzge(zzbn.zzkP[zzli[l]].string);
        }
        final int[] zzlh = zzbo.zzlh;
        for (int length5 = zzlh.length, n = 0; n < length5; ++n) {
            en.zzg(list.get(zzlh[n]));
        }
        final int[] zzlj = zzbo.zzlj;
        for (int length6 = zzlj.length, n2 = 0; n2 < length6; ++n2) {
            en.zzgf(zzbn.zzkP[zzlj[n2]].string);
        }
        final int[] zzlk = zzbo.zzlk;
        for (int length7 = zzlk.length, n3 = 0; n3 < length7; ++n3) {
            en.zzh(list2.get(zzlk[n3]));
        }
        final int[] zzlm = zzbo.zzlm;
        for (int length8 = zzlm.length, n4 = 0; n4 < length8; ++n4) {
            en.zzgg(zzbn.zzkP[zzlm[n4]].string);
        }
        final int[] zzll = zzbo.zzll;
        for (int length9 = zzll.length, n5 = 0; n5 < length9; ++n5) {
            en.zzi(list2.get(zzll[n5]));
        }
        final int[] zzln = zzbo.zzln;
        for (int length10 = zzln.length, n6 = 0; n6 < length10; ++n6) {
            en.zzgh(zzbn.zzkP[zzln[n6]].string);
        }
        return en.zzDE();
    }
    
    private static zzbr zza(final int n, final zzbn zzbn, final zzbr[] array, final Set<Integer> obj) throws eo {
        final int n2 = 0;
        final int n3 = 0;
        int n4 = 0;
        if (obj.contains(n)) {
            final String value = String.valueOf(obj);
            zzfQ(new StringBuilder(String.valueOf(value).length() + 90).append("Value cycle detected.  Current value reference: ").append(n).append(".  Previous value references: ").append(value).append(".").toString());
        }
        final zzbr obj2 = zza(zzbn.zzkP, n, "values");
        if (array[n] != null) {
            return array[n];
        }
        zzbr zzj = null;
        obj.add(n);
        Label_0168: {
            switch (obj2.type) {
                case 2: {
                    final zzbh.zza zzk = zzk(obj2);
                    final zzbr zzj2 = zzj(obj2);
                    zzj2.zzlE = new zzbr[zzk.zzlq.length];
                    final int[] zzlq = zzk.zzlq;
                    final int length = zzlq.length;
                    int n5 = 0;
                    while (true) {
                        zzj = zzj2;
                        if (n4 >= length) {
                            break Label_0168;
                        }
                        zzj2.zzlE[n5] = zza(zzlq[n4], zzbn, array, obj);
                        ++n4;
                        ++n5;
                    }
                    break;
                }
                case 3: {
                    final zzbr zzj3 = zzj(obj2);
                    final zzbh.zza zzk2 = zzk(obj2);
                    if (zzk2.zzlr.length != zzk2.zzls.length) {
                        zzfQ(new StringBuilder(58).append("Uneven map keys (").append(zzk2.zzlr.length).append(") and map values (").append(zzk2.zzls.length).append(")").toString());
                    }
                    zzj3.zzlF = new zzbr[zzk2.zzlr.length];
                    zzj3.zzlG = new zzbr[zzk2.zzlr.length];
                    final int[] zzlr = zzk2.zzlr;
                    for (int length2 = zzlr.length, i = 0, n6 = 0; i < length2; ++i, ++n6) {
                        zzj3.zzlF[n6] = zza(zzlr[i], zzbn, array, obj);
                    }
                    final int[] zzls = zzk2.zzls;
                    final int length3 = zzls.length;
                    int n7 = 0;
                    int n8 = n2;
                    while (true) {
                        zzj = zzj3;
                        if (n8 >= length3) {
                            break Label_0168;
                        }
                        zzj3.zzlG[n7] = zza(zzls[n8], zzbn, array, obj);
                        ++n8;
                        ++n7;
                    }
                    break;
                }
                case 4: {
                    zzj = zzj(obj2);
                    zzj.zzlH = zzgk.zzb(zza(zzk(obj2).zzlv, zzbn, array, obj));
                    break;
                }
                case 7: {
                    final zzbr zzj4 = zzj(obj2);
                    final zzbh.zza zzk3 = zzk(obj2);
                    zzj4.zzlL = new zzbr[zzk3.zzlu.length];
                    final int[] zzlu = zzk3.zzlu;
                    final int length4 = zzlu.length;
                    int n9 = 0;
                    int n10 = n3;
                    while (true) {
                        zzj = zzj4;
                        if (n10 >= length4) {
                            break Label_0168;
                        }
                        zzj4.zzlL[n9] = zza(zzlu[n10], zzbn, array, obj);
                        ++n10;
                        ++n9;
                    }
                    break;
                }
                case 1:
                case 5:
                case 6:
                case 8: {
                    zzj = obj2;
                    break;
                }
            }
        }
        if (zzj == null) {
            final String value2 = String.valueOf(obj2);
            zzfQ(new StringBuilder(String.valueOf(value2).length() + 15).append("Invalid value: ").append(value2).toString());
        }
        array[n] = zzj;
        obj.remove(n);
        return zzj;
    }
    
    private static <T> T zza(final T[] array, final int i, final String s) throws eo {
        if (i < 0 || i >= array.length) {
            zzfQ(new StringBuilder(String.valueOf(s).length() + 45).append("Index out of bounds detected: ").append(i).append(" in ").append(s).toString());
        }
        return array[i];
    }
    
    public static void zzb(final InputStream inputStream, final OutputStream outputStream) throws IOException {
        final byte[] array = new byte[1024];
        while (true) {
            final int read = inputStream.read(array);
            if (read == -1) {
                break;
            }
            outputStream.write(array, 0, read);
        }
    }
    
    private static void zzfQ(final String s) throws eo {
        zzdj.e(s);
        throw new eo(s);
    }
    
    public static zzbr zzj(final zzbr zzbr) {
        final zzbr zzbr2 = new zzbr();
        zzbr2.type = zzbr.type;
        zzbr2.zzlM = zzbr.zzlM.clone();
        if (zzbr.zzlN) {
            zzbr2.zzlN = zzbr.zzlN;
        }
        return zzbr2;
    }
    
    private static zzbh.zza zzk(final zzbr obj) throws eo {
        if (obj.zza(zzbh.zza.zzlo) == null) {
            final String value = String.valueOf(obj);
            zzfQ(new StringBuilder(String.valueOf(value).length() + 54).append("Expected a ServingValue and didn't get one. Value is: ").append(value).toString());
        }
        return obj.zza(zzbh.zza.zzlo);
    }
}
