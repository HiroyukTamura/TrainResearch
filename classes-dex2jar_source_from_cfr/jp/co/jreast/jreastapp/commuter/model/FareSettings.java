/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import jp.co.jreast.jreastapp.commuter.model.Settings;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000b\u00a8\u0006\f"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/FareSettings;", "", "Ljp/co/jreast/jreastapp/commuter/model/Settings;", "value", "", "label", "(Ljava/lang/String;III)V", "getLabel", "()I", "getValue", "IC_CARD", "CASH", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class FareSettings
extends Enum<FareSettings>
implements Settings {
    private static final /* synthetic */ FareSettings[] $VALUES;
    public static final /* enum */ FareSettings CASH;
    public static final /* enum */ FareSettings IC_CARD;
    private final int label;
    private final int value;

    static {
        FareSettings fareSettings;
        FareSettings fareSettings2;
        IC_CARD = fareSettings2 = new FareSettings(0, 2131558515);
        CASH = fareSettings = new FareSettings(1, 2131558461);
        $VALUES = new FareSettings[]{fareSettings2, fareSettings};
    }

    protected FareSettings(int n3, int n4) {
        this.value = n3;
        this.label = n4;
    }

    public static FareSettings valueOf(String string2) {
        return Enum.valueOf(FareSettings.class, string2);
    }

    public static FareSettings[] values() {
        return (FareSettings[])$VALUES.clone();
    }

    @Override
    public int getLabel() {
        return this.label;
    }

    @Override
    public int getValue() {
        return this.value;
    }
}

