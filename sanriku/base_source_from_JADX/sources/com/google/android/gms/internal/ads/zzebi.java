package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.List;

final class zzebi implements zzeee {
    private int tag;
    private final zzebf zzhuf;
    private int zzhug;
    private int zzhuh = 0;

    private zzebi(zzebf zzebf) {
        zzebf zzebf2 = (zzebf) zzecg.zza(zzebf, "input");
        this.zzhuf = zzebf2;
        zzebf2.zzhtv = this;
    }

    public static zzebi zza(zzebf zzebf) {
        zzebi zzebi = zzebf.zzhtv;
        return zzebi != null ? zzebi : new zzebi(zzebf);
    }

    private final Object zza(zzefp zzefp, Class<?> cls, zzebq zzebq) throws IOException {
        switch (zzebl.zzhuk[zzefp.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzbde());
            case 2:
                return zzbdg();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzbdi());
            case 5:
                return Integer.valueOf(zzbdd());
            case 6:
                return Long.valueOf(zzbdc());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzbdb());
            case 9:
                return Long.valueOf(zzbda());
            case 10:
                zzgc(2);
                return zzc(zzedz.zzbgk().zzh(cls), zzebq);
            case 11:
                return Integer.valueOf(zzbdj());
            case 12:
                return Long.valueOf(zzbdk());
            case 13:
                return Integer.valueOf(zzbdl());
            case 14:
                return Long.valueOf(zzbdm());
            case 15:
                return zzbdf();
            case 16:
                return Integer.valueOf(zzbdh());
            case 17:
                return Long.valueOf(zzbcz());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int zzbcy;
        int zzbcy2;
        if ((this.tag & 7) != 2) {
            throw zzeco.zzbfl();
        } else if (!(list instanceof zzecv) || z) {
            do {
                list.add(z ? zzbdf() : readString());
                if (!this.zzhuf.zzbdo()) {
                    zzbcy = this.zzhuf.zzbcy();
                } else {
                    return;
                }
            } while (zzbcy == this.tag);
            this.zzhuh = zzbcy;
        } else {
            zzecv zzecv = (zzecv) list;
            do {
                zzecv.zzaj(zzbdg());
                if (!this.zzhuf.zzbdo()) {
                    zzbcy2 = this.zzhuf.zzbcy();
                } else {
                    return;
                }
            } while (zzbcy2 == this.tag);
            this.zzhuh = zzbcy2;
        }
    }

    private final <T> T zzc(zzeek<T> zzeek, zzebq zzebq) throws IOException {
        int zzbdh = this.zzhuf.zzbdh();
        zzebf zzebf = this.zzhuf;
        if (zzebf.zzhts < zzebf.zzhtt) {
            int zzfu = zzebf.zzfu(zzbdh);
            T newInstance = zzeek.newInstance();
            this.zzhuf.zzhts++;
            zzeek.zza(newInstance, this, zzebq);
            zzeek.zzak(newInstance);
            this.zzhuf.zzfs(0);
            zzebf zzebf2 = this.zzhuf;
            zzebf2.zzhts--;
            zzebf2.zzfv(zzfu);
            return newInstance;
        }
        throw new zzeco("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    private final <T> T zzd(zzeek<T> zzeek, zzebq zzebq) throws IOException {
        int i = this.zzhug;
        this.zzhug = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzeek.newInstance();
            zzeek.zza(newInstance, this, zzebq);
            zzeek.zzak(newInstance);
            if (this.tag == this.zzhug) {
                return newInstance;
            }
            throw zzeco.zzbfn();
        } finally {
            this.zzhug = i;
        }
    }

    private final void zzgc(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzeco.zzbfl();
        }
    }

    private static void zzgd(int i) throws IOException {
        if ((i & 7) != 0) {
            throw zzeco.zzbfn();
        }
    }

    private static void zzge(int i) throws IOException {
        if ((i & 3) != 0) {
            throw zzeco.zzbfn();
        }
    }

    private final void zzgf(int i) throws IOException {
        if (this.zzhuf.zzbdp() != i) {
            throw zzeco.zzbfg();
        }
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() throws IOException {
        zzgc(1);
        return this.zzhuf.readDouble();
    }

    public final float readFloat() throws IOException {
        zzgc(5);
        return this.zzhuf.readFloat();
    }

    public final String readString() throws IOException {
        zzgc(2);
        return this.zzhuf.readString();
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final <T> T zza(zzeek<T> zzeek, zzebq zzebq) throws IOException {
        zzgc(2);
        return zzc(zzeek, zzebq);
    }

    public final <T> void zza(List<T> list, zzeek<T> zzeek, zzebq zzebq) throws IOException {
        int zzbcy;
        int i = this.tag;
        if ((i & 7) == 2) {
            do {
                list.add(zzc(zzeek, zzebq));
                if (!this.zzhuf.zzbdo() && this.zzhuh == 0) {
                    zzbcy = this.zzhuf.zzbcy();
                } else {
                    return;
                }
            } while (zzbcy == i);
            this.zzhuh = zzbcy;
            return;
        }
        throw zzeco.zzbfl();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0052, code lost:
        if (zzbdx() != false) goto L_0x0054;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005a, code lost:
        throw new com.google.android.gms.internal.ads.zzeco("Unable to parse map entry.");
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.ads.zzedf<K, V> r9, com.google.android.gms.internal.ads.zzebq r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzgc(r0)
            com.google.android.gms.internal.ads.zzebf r1 = r7.zzhuf
            int r1 = r1.zzbdh()
            com.google.android.gms.internal.ads.zzebf r2 = r7.zzhuf
            int r1 = r2.zzfu(r1)
            K r2 = r9.zzhzx
            V r3 = r9.zzcif
        L_0x0014:
            int r4 = r7.zzbdw()     // Catch:{ all -> 0x0064 }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x005b
            com.google.android.gms.internal.ads.zzebf r5 = r7.zzhuf     // Catch:{ all -> 0x0064 }
            boolean r5 = r5.zzbdo()     // Catch:{ all -> 0x0064 }
            if (r5 != 0) goto L_0x005b
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0046
            if (r4 == r0) goto L_0x0039
            boolean r4 = r7.zzbdx()     // Catch:{ zzecn -> 0x004e }
            if (r4 == 0) goto L_0x0033
            goto L_0x0014
        L_0x0033:
            com.google.android.gms.internal.ads.zzeco r4 = new com.google.android.gms.internal.ads.zzeco     // Catch:{ zzecn -> 0x004e }
            r4.<init>(r6)     // Catch:{ zzecn -> 0x004e }
            throw r4     // Catch:{ zzecn -> 0x004e }
        L_0x0039:
            com.google.android.gms.internal.ads.zzefp r4 = r9.zzhzy     // Catch:{ zzecn -> 0x004e }
            V r5 = r9.zzcif     // Catch:{ zzecn -> 0x004e }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzecn -> 0x004e }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.ads.zzefp) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzebq) r10)     // Catch:{ zzecn -> 0x004e }
            goto L_0x0014
        L_0x0046:
            com.google.android.gms.internal.ads.zzefp r4 = r9.zzhzw     // Catch:{ zzecn -> 0x004e }
            r5 = 0
            java.lang.Object r2 = r7.zza((com.google.android.gms.internal.ads.zzefp) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.ads.zzebq) r5)     // Catch:{ zzecn -> 0x004e }
            goto L_0x0014
        L_0x004e:
            boolean r4 = r7.zzbdx()     // Catch:{ all -> 0x0064 }
            if (r4 == 0) goto L_0x0055
            goto L_0x0014
        L_0x0055:
            com.google.android.gms.internal.ads.zzeco r8 = new com.google.android.gms.internal.ads.zzeco     // Catch:{ all -> 0x0064 }
            r8.<init>(r6)     // Catch:{ all -> 0x0064 }
            throw r8     // Catch:{ all -> 0x0064 }
        L_0x005b:
            r8.put(r2, r3)     // Catch:{ all -> 0x0064 }
            com.google.android.gms.internal.ads.zzebf r8 = r7.zzhuf
            r8.zzfv(r1)
            return
        L_0x0064:
            r8 = move-exception
            com.google.android.gms.internal.ads.zzebf r9 = r7.zzhuf
            r9.zzfv(r1)
            goto L_0x006c
        L_0x006b:
            throw r8
        L_0x006c:
            goto L_0x006b
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzebi.zza(java.util.Map, com.google.android.gms.internal.ads.zzedf, com.google.android.gms.internal.ads.zzebq):void");
    }

    public final <T> T zzb(zzeek<T> zzeek, zzebq zzebq) throws IOException {
        zzgc(3);
        return zzd(zzeek, zzebq);
    }

    public final <T> void zzb(List<T> list, zzeek<T> zzeek, zzebq zzebq) throws IOException {
        int zzbcy;
        int i = this.tag;
        if ((i & 7) == 3) {
            do {
                list.add(zzd(zzeek, zzebq));
                if (!this.zzhuf.zzbdo() && this.zzhuh == 0) {
                    zzbcy = this.zzhuf.zzbcy();
                } else {
                    return;
                }
            } while (zzbcy == i);
            this.zzhuh = zzbcy;
            return;
        }
        throw zzeco.zzbfl();
    }

    public final long zzbcz() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbcz();
    }

    public final long zzbda() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbda();
    }

    public final int zzbdb() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbdb();
    }

    public final long zzbdc() throws IOException {
        zzgc(1);
        return this.zzhuf.zzbdc();
    }

    public final int zzbdd() throws IOException {
        zzgc(5);
        return this.zzhuf.zzbdd();
    }

    public final boolean zzbde() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbde();
    }

    public final String zzbdf() throws IOException {
        zzgc(2);
        return this.zzhuf.zzbdf();
    }

    public final zzeaq zzbdg() throws IOException {
        zzgc(2);
        return this.zzhuf.zzbdg();
    }

    public final int zzbdh() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbdh();
    }

    public final int zzbdi() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbdi();
    }

    public final int zzbdj() throws IOException {
        zzgc(5);
        return this.zzhuf.zzbdj();
    }

    public final long zzbdk() throws IOException {
        zzgc(1);
        return this.zzhuf.zzbdk();
    }

    public final int zzbdl() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbdl();
    }

    public final long zzbdm() throws IOException {
        zzgc(0);
        return this.zzhuf.zzbdm();
    }

    public final int zzbdw() throws IOException {
        int i = this.zzhuh;
        if (i != 0) {
            this.tag = i;
            this.zzhuh = 0;
        } else {
            this.tag = this.zzhuf.zzbcy();
        }
        int i2 = this.tag;
        if (i2 == 0 || i2 == this.zzhug) {
            return Integer.MAX_VALUE;
        }
        return i2 >>> 3;
    }

    public final boolean zzbdx() throws IOException {
        int i;
        if (this.zzhuf.zzbdo() || (i = this.tag) == this.zzhug) {
            return false;
        }
        return this.zzhuf.zzft(i);
    }

    public final void zzj(List<Double> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzebp) {
            zzebp zzebp = (zzebp) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzebp.zzd(this.zzhuf.readDouble());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdh = this.zzhuf.zzbdh();
                zzgd(zzbdh);
                int zzbdp = this.zzhuf.zzbdp() + zzbdh;
                do {
                    zzebp.zzd(this.zzhuf.readDouble());
                } while (this.zzhuf.zzbdp() < zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Double.valueOf(this.zzhuf.readDouble()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdh2 = this.zzhuf.zzbdh();
                zzgd(zzbdh2);
                int zzbdp2 = this.zzhuf.zzbdp() + zzbdh2;
                do {
                    list.add(Double.valueOf(this.zzhuf.readDouble()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzk(List<Float> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzebz) {
            zzebz zzebz = (zzebz) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbdh = this.zzhuf.zzbdh();
                zzge(zzbdh);
                int zzbdp = this.zzhuf.zzbdp() + zzbdh;
                do {
                    zzebz.zzh(this.zzhuf.readFloat());
                } while (this.zzhuf.zzbdp() < zzbdp);
            } else if (i == 5) {
                do {
                    zzebz.zzh(this.zzhuf.readFloat());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbdh2 = this.zzhuf.zzbdh();
                zzge(zzbdh2);
                int zzbdp2 = this.zzhuf.zzbdp() + zzbdh2;
                do {
                    list.add(Float.valueOf(this.zzhuf.readFloat()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
            } else if (i2 == 5) {
                do {
                    list.add(Float.valueOf(this.zzhuf.readFloat()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzl(List<Long> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzedc) {
            zzedc zzedc = (zzedc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzedc.zzfs(this.zzhuf.zzbcz());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzedc.zzfs(this.zzhuf.zzbcz());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbcz()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbcz()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzm(List<Long> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzedc) {
            zzedc zzedc = (zzedc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzedc.zzfs(this.zzhuf.zzbda());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzedc.zzfs(this.zzhuf.zzbda());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbda()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbda()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzn(List<Integer> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzece) {
            zzece zzece = (zzece) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzece.zzgw(this.zzhuf.zzbdb());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzece.zzgw(this.zzhuf.zzbdb());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdb()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdb()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzo(List<Long> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzedc) {
            zzedc zzedc = (zzedc) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzedc.zzfs(this.zzhuf.zzbdc());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdh = this.zzhuf.zzbdh();
                zzgd(zzbdh);
                int zzbdp = this.zzhuf.zzbdp() + zzbdh;
                do {
                    zzedc.zzfs(this.zzhuf.zzbdc());
                } while (this.zzhuf.zzbdp() < zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbdc()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdh2 = this.zzhuf.zzbdh();
                zzgd(zzbdh2);
                int zzbdp2 = this.zzhuf.zzbdp() + zzbdh2;
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbdc()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzp(List<Integer> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzece) {
            zzece zzece = (zzece) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbdh = this.zzhuf.zzbdh();
                zzge(zzbdh);
                int zzbdp = this.zzhuf.zzbdp() + zzbdh;
                do {
                    zzece.zzgw(this.zzhuf.zzbdd());
                } while (this.zzhuf.zzbdp() < zzbdp);
            } else if (i == 5) {
                do {
                    zzece.zzgw(this.zzhuf.zzbdd());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbdh2 = this.zzhuf.zzbdh();
                zzge(zzbdh2);
                int zzbdp2 = this.zzhuf.zzbdp() + zzbdh2;
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdd()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdd()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzq(List<Boolean> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzeao) {
            zzeao zzeao = (zzeao) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzeao.addBoolean(this.zzhuf.zzbde());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzeao.addBoolean(this.zzhuf.zzbde());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Boolean.valueOf(this.zzhuf.zzbde()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Boolean.valueOf(this.zzhuf.zzbde()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzr(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzs(List<zzeaq> list) throws IOException {
        int zzbcy;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzbdg());
                if (!this.zzhuf.zzbdo()) {
                    zzbcy = this.zzhuf.zzbcy();
                } else {
                    return;
                }
            } while (zzbcy == this.tag);
            this.zzhuh = zzbcy;
            return;
        }
        throw zzeco.zzbfl();
    }

    public final void zzt(List<Integer> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzece) {
            zzece zzece = (zzece) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzece.zzgw(this.zzhuf.zzbdh());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzece.zzgw(this.zzhuf.zzbdh());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdh()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdh()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzu(List<Integer> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzece) {
            zzece zzece = (zzece) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzece.zzgw(this.zzhuf.zzbdi());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzece.zzgw(this.zzhuf.zzbdi());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdi()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdi()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzv(List<Integer> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzece) {
            zzece zzece = (zzece) list;
            int i = this.tag & 7;
            if (i == 2) {
                int zzbdh = this.zzhuf.zzbdh();
                zzge(zzbdh);
                int zzbdp = this.zzhuf.zzbdp() + zzbdh;
                do {
                    zzece.zzgw(this.zzhuf.zzbdj());
                } while (this.zzhuf.zzbdp() < zzbdp);
            } else if (i == 5) {
                do {
                    zzece.zzgw(this.zzhuf.zzbdj());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 2) {
                int zzbdh2 = this.zzhuf.zzbdh();
                zzge(zzbdh2);
                int zzbdp2 = this.zzhuf.zzbdp() + zzbdh2;
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdj()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
            } else if (i2 == 5) {
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdj()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzw(List<Long> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzedc) {
            zzedc zzedc = (zzedc) list;
            int i = this.tag & 7;
            if (i == 1) {
                do {
                    zzedc.zzfs(this.zzhuf.zzbdk());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdh = this.zzhuf.zzbdh();
                zzgd(zzbdh);
                int zzbdp = this.zzhuf.zzbdp() + zzbdh;
                do {
                    zzedc.zzfs(this.zzhuf.zzbdk());
                } while (this.zzhuf.zzbdp() < zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 1) {
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbdk()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdh2 = this.zzhuf.zzbdh();
                zzgd(zzbdh2);
                int zzbdp2 = this.zzhuf.zzbdp() + zzbdh2;
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbdk()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzx(List<Integer> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzece) {
            zzece zzece = (zzece) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzece.zzgw(this.zzhuf.zzbdl());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzece.zzgw(this.zzhuf.zzbdl());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdl()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Integer.valueOf(this.zzhuf.zzbdl()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }

    public final void zzy(List<Long> list) throws IOException {
        int zzbcy;
        int zzbcy2;
        if (list instanceof zzedc) {
            zzedc zzedc = (zzedc) list;
            int i = this.tag & 7;
            if (i == 0) {
                do {
                    zzedc.zzfs(this.zzhuf.zzbdm());
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy2 = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy2 == this.tag);
                this.zzhuh = zzbcy2;
            } else if (i == 2) {
                int zzbdp = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    zzedc.zzfs(this.zzhuf.zzbdm());
                } while (this.zzhuf.zzbdp() < zzbdp);
                zzgf(zzbdp);
            } else {
                throw zzeco.zzbfl();
            }
        } else {
            int i2 = this.tag & 7;
            if (i2 == 0) {
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbdm()));
                    if (!this.zzhuf.zzbdo()) {
                        zzbcy = this.zzhuf.zzbcy();
                    } else {
                        return;
                    }
                } while (zzbcy == this.tag);
                this.zzhuh = zzbcy;
            } else if (i2 == 2) {
                int zzbdp2 = this.zzhuf.zzbdp() + this.zzhuf.zzbdh();
                do {
                    list.add(Long.valueOf(this.zzhuf.zzbdm()));
                } while (this.zzhuf.zzbdp() < zzbdp2);
                zzgf(zzbdp2);
            } else {
                throw zzeco.zzbfl();
            }
        }
    }
}
