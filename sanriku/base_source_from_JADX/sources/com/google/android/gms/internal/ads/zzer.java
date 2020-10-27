package com.google.android.gms.internal.ads;

final class zzer {
    static zzdsi zzza;

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0020, code lost:
        r9 = r9.zza("M2qSAa8M0FWknYOLhqt+/Fg7hndA+iGyFQHluQ13JM7VYcVOxfDpnSG4HdwfsR6f", "z17NkROhoKeGkbS2tgYHIJsoqSFhSwk9HYPzNbT9RcI=");
     */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean zzb(com.google.android.gms.internal.ads.zzeo r9) throws java.lang.IllegalAccessException, java.lang.reflect.InvocationTargetException {
        /*
            com.google.android.gms.internal.ads.zzdsi r0 = zzza
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            com.google.android.gms.internal.ads.zzzk<java.lang.String> r0 = com.google.android.gms.internal.ads.zzzz.zzcnz
            com.google.android.gms.internal.ads.zzzv r2 = com.google.android.gms.internal.ads.zzvj.zzpv()
            java.lang.Object r0 = r2.zzd(r0)
            java.lang.String r0 = (java.lang.String) r0
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L_0x001c
            int r4 = r0.length()
            if (r4 != 0) goto L_0x0037
        L_0x001c:
            if (r9 != 0) goto L_0x0020
        L_0x001e:
            r0 = r2
            goto L_0x0034
        L_0x0020:
            java.lang.String r0 = "M2qSAa8M0FWknYOLhqt+/Fg7hndA+iGyFQHluQ13JM7VYcVOxfDpnSG4HdwfsR6f"
            java.lang.String r4 = "z17NkROhoKeGkbS2tgYHIJsoqSFhSwk9HYPzNbT9RcI="
            java.lang.reflect.Method r9 = r9.zza((java.lang.String) r0, (java.lang.String) r4)
            if (r9 != 0) goto L_0x002b
            goto L_0x001e
        L_0x002b:
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.Object r9 = r9.invoke(r2, r0)
            java.lang.String r9 = (java.lang.String) r9
            r0 = r9
        L_0x0034:
            if (r0 != 0) goto L_0x0037
            return r3
        L_0x0037:
            byte[] r9 = com.google.android.gms.internal.ads.zzcl.zza((java.lang.String) r0, (boolean) r1)     // Catch:{ IllegalArgumentException -> 0x011e }
            com.google.android.gms.internal.ads.zzdsn r9 = com.google.android.gms.internal.ads.zzdsr.zzl(r9)     // Catch:{  }
            com.google.android.gms.internal.ads.zzdyd r0 = com.google.android.gms.internal.ads.zzduk.zzhke     // Catch:{  }
            java.util.List r0 = r0.zzbbp()     // Catch:{  }
            java.util.Iterator r0 = r0.iterator()     // Catch:{  }
        L_0x0049:
            boolean r4 = r0.hasNext()     // Catch:{  }
            if (r4 == 0) goto L_0x0115
            java.lang.Object r4 = r0.next()     // Catch:{  }
            com.google.android.gms.internal.ads.zzdxm r4 = (com.google.android.gms.internal.ads.zzdxm) r4     // Catch:{  }
            java.lang.String r5 = r4.zzbad()     // Catch:{  }
            boolean r5 = r5.isEmpty()     // Catch:{  }
            if (r5 != 0) goto L_0x010d
            java.lang.String r5 = r4.zzbal()     // Catch:{  }
            boolean r5 = r5.isEmpty()     // Catch:{  }
            if (r5 != 0) goto L_0x0105
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            boolean r5 = r5.isEmpty()     // Catch:{  }
            if (r5 != 0) goto L_0x00fd
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkAead"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkMac"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkHybridDecrypt"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkHybridEncrypt"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkPublicKeySign"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkPublicKeyVerify"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkStreamingAead"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 != 0) goto L_0x0049
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            java.lang.String r6 = "TinkDeterministicAead"
            boolean r5 = r5.equals(r6)     // Catch:{  }
            if (r5 == 0) goto L_0x00d5
            goto L_0x0049
        L_0x00d5:
            java.lang.String r5 = r4.zzbao()     // Catch:{  }
            com.google.android.gms.internal.ads.zzdse r5 = com.google.android.gms.internal.ads.zzdsx.zzhj(r5)     // Catch:{  }
            com.google.android.gms.internal.ads.zzdsw r6 = r5.zzawt()     // Catch:{  }
            com.google.android.gms.internal.ads.zzdsx.zza(r6)     // Catch:{  }
            java.lang.String r6 = r4.zzbad()     // Catch:{  }
            java.lang.String r7 = r4.zzbal()     // Catch:{  }
            int r8 = r4.zzbam()     // Catch:{  }
            com.google.android.gms.internal.ads.zzdsh r5 = r5.zzb(r6, r7, r8)     // Catch:{  }
            boolean r4 = r4.zzban()     // Catch:{  }
            com.google.android.gms.internal.ads.zzdsx.zza(r5, (boolean) r4)     // Catch:{  }
            goto L_0x0049
        L_0x00fd:
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing catalogue_name."
            r9.<init>(r0)     // Catch:{  }
            throw r9     // Catch:{  }
        L_0x0105:
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing primitive_name."
            r9.<init>(r0)     // Catch:{  }
            throw r9     // Catch:{  }
        L_0x010d:
            java.security.GeneralSecurityException r9 = new java.security.GeneralSecurityException     // Catch:{  }
            java.lang.String r0 = "Missing type_url."
            r9.<init>(r0)     // Catch:{  }
            throw r9     // Catch:{  }
        L_0x0115:
            com.google.android.gms.internal.ads.zzdsi r9 = com.google.android.gms.internal.ads.zzduo.zza(r9, r2)     // Catch:{  }
            zzza = r9     // Catch:{  }
            if (r9 == 0) goto L_0x011e
            return r1
        L_0x011e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzer.zzb(com.google.android.gms.internal.ads.zzeo):boolean");
    }
}
