/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.n;

import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, k=3, mv={1, 1, 11})
public final class l {
    public static final /* synthetic */ int[] a;

    static /* synthetic */ {
        a = new int[FareSettings.values().length];
        l.a[FareSettings.CASH.ordinal()] = 1;
        l.a[FareSettings.IC_CARD.ordinal()] = 2;
    }
}

