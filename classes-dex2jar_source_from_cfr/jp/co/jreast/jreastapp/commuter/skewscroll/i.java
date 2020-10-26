/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.skewscroll;

import jp.co.jreast.jreastapp.commuter.model.FareSettings;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, k=3, mv={1, 1, 11})
public final class i {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static /* synthetic */ {
        a = new int[FareSettings.values().length];
        i.a[FareSettings.CASH.ordinal()] = 1;
        i.a[FareSettings.IC_CARD.ordinal()] = 2;
        b = new int[FareSettings.values().length];
        i.b[FareSettings.CASH.ordinal()] = 1;
        i.b[FareSettings.IC_CARD.ordinal()] = 2;
    }
}

