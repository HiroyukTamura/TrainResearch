/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import jp.co.jreast.jreastapp.commuter.model.Settings;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r\u00a8\u0006\u000e"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/TransferTimeSettings;", "", "Ljp/co/jreast/jreastapp/commuter/model/Settings;", "value", "", "label", "(Ljava/lang/String;III)V", "getLabel", "()I", "getValue", "FAST", "NORMAL", "SLOW", "MORE_SLOW", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class TransferTimeSettings
extends Enum<TransferTimeSettings>
implements Settings {
    private static final /* synthetic */ TransferTimeSettings[] $VALUES;
    public static final /* enum */ TransferTimeSettings FAST;
    public static final /* enum */ TransferTimeSettings MORE_SLOW;
    public static final /* enum */ TransferTimeSettings NORMAL;
    public static final /* enum */ TransferTimeSettings SLOW;
    private final int label;
    private final int value;

    static {
        TransferTimeSettings transferTimeSettings;
        TransferTimeSettings transferTimeSettings2;
        TransferTimeSettings transferTimeSettings3;
        TransferTimeSettings transferTimeSettings4;
        FAST = transferTimeSettings2 = new TransferTimeSettings(2, 2131558607);
        NORMAL = transferTimeSettings = new TransferTimeSettings(0, 2131558609);
        SLOW = transferTimeSettings4 = new TransferTimeSettings(1, 2131558611);
        MORE_SLOW = transferTimeSettings3 = new TransferTimeSettings(4, 2131558608);
        $VALUES = new TransferTimeSettings[]{transferTimeSettings2, transferTimeSettings, transferTimeSettings4, transferTimeSettings3};
    }

    protected TransferTimeSettings(int n3, int n4) {
        this.value = n3;
        this.label = n4;
    }

    public static TransferTimeSettings valueOf(String string2) {
        return Enum.valueOf(TransferTimeSettings.class, string2);
    }

    public static TransferTimeSettings[] values() {
        return (TransferTimeSettings[])$VALUES.clone();
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

