package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.PriorityQueue;

public final class zzqy {
    private final int zzbrj;
    private final int zzbrk;
    private final int zzbrl;
    private final zzqv zzbrm = new zzrc();

    public zzqy(int i) {
        this.zzbrk = i;
        this.zzbrj = 6;
        this.zzbrl = 0;
    }

    @VisibleForTesting
    private final String zzbs(String str) {
        String[] split = str.split("\n");
        if (split.length == 0) {
            return "";
        }
        zzra zzra = new zzra();
        PriorityQueue priorityQueue = new PriorityQueue(this.zzbrk, new zzqx(this));
        for (String zzd : split) {
            String[] zzd2 = zzqz.zzd(zzd, false);
            if (zzd2.length != 0) {
                zzre.zza(zzd2, this.zzbrk, this.zzbrj, priorityQueue);
            }
        }
        Iterator it = priorityQueue.iterator();
        while (it.hasNext()) {
            try {
                zzra.write(this.zzbrm.zzbr(((zzrd) it.next()).zzbrq));
            } catch (IOException e) {
                zzazw.zzc("Error while writing hash to byteStream", e);
            }
        }
        return zzra.toString();
    }

    public final String zza(ArrayList<String> arrayList) {
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            String str = arrayList.get(i);
            i++;
            sb.append(str.toLowerCase(Locale.US));
            sb.append(10);
        }
        return zzbs(sb.toString());
    }
}
