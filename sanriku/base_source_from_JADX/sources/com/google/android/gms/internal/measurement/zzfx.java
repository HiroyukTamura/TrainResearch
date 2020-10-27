package com.google.android.gms.internal.measurement;

import java.util.Comparator;

interface zzfx<T> extends Iterable<T> {
    Comparator<? super T> comparator();
}
