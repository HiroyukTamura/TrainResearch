package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzam implements Comparator<byte[]> {
    zzam() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        return ((byte[]) obj).length - ((byte[]) obj2).length;
    }
}
