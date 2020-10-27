package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;

final class zzeef {
    private final ArrayDeque<zzeaq> zzibg;

    private zzeef() {
        this.zzibg = new ArrayDeque<>();
    }

    /* synthetic */ zzeef(zzeeg zzeeg) {
        this();
    }

    private final void zzak(zzeaq zzeaq) {
        while (!zzeaq.zzbct()) {
            if (zzeaq instanceof zzeed) {
                zzeed zzeed = (zzeed) zzeaq;
                zzak(zzeed.zzibc);
                zzeaq = zzeed.zzibd;
            } else {
                String valueOf = String.valueOf(zzeaq.getClass());
                throw new IllegalArgumentException(C0681a.m312a(valueOf.length() + 49, "Has a new type of ByteString been created? Found ", valueOf));
            }
        }
        int zzhh = zzhh(zzeaq.size());
        int zzhg = zzeed.zzhg(zzhh + 1);
        if (this.zzibg.isEmpty() || this.zzibg.peek().size() >= zzhg) {
            this.zzibg.push(zzeaq);
            return;
        }
        int zzhg2 = zzeed.zzhg(zzhh);
        zzeaq pop = this.zzibg.pop();
        while (!this.zzibg.isEmpty() && this.zzibg.peek().size() < zzhg2) {
            pop = new zzeed(this.zzibg.pop(), pop, (zzeeg) null);
        }
        zzeed zzeed2 = new zzeed(pop, zzeaq, (zzeeg) null);
        while (!this.zzibg.isEmpty() && this.zzibg.peek().size() < zzeed.zzhg(zzhh(zzeed2.size()) + 1)) {
            zzeed2 = new zzeed(this.zzibg.pop(), zzeed2, (zzeeg) null);
        }
        this.zzibg.push(zzeed2);
    }

    /* access modifiers changed from: private */
    public final zzeaq zzc(zzeaq zzeaq, zzeaq zzeaq2) {
        zzak(zzeaq);
        zzak(zzeaq2);
        zzeaq pop = this.zzibg.pop();
        while (!this.zzibg.isEmpty()) {
            pop = new zzeed(this.zzibg.pop(), pop, (zzeeg) null);
        }
        return pop;
    }

    private static int zzhh(int i) {
        int binarySearch = Arrays.binarySearch(zzeed.zziba, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }
}
