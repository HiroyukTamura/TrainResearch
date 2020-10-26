/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.selectsetting;

import jp.co.jreast.jreastapp.commuter.model.SettingTypes;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, k=3, mv={1, 1, 11})
public final class e {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;

    static /* synthetic */ {
        a = new int[SettingTypes.values().length];
        e.a[SettingTypes.EXPRESS.ordinal()] = 1;
        e.a[SettingTypes.FARE.ordinal()] = 2;
        e.a[SettingTypes.TRANSFER_TIME.ordinal()] = 3;
        b = new int[SettingTypes.values().length];
        e.b[SettingTypes.EXPRESS.ordinal()] = 1;
        e.b[SettingTypes.FARE.ordinal()] = 2;
        e.b[SettingTypes.TRANSFER_TIME.ordinal()] = 3;
        c = new int[SettingTypes.values().length];
        e.c[SettingTypes.EXPRESS.ordinal()] = 1;
        e.c[SettingTypes.FARE.ordinal()] = 2;
        e.c[SettingTypes.TRANSFER_TIME.ordinal()] = 3;
    }
}

