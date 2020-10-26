/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import jp.co.jreast.jreastapp.commuter.model.Settings;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u0017\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0006R\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/ExpressSettings;", "", "Ljp/co/jreast/jreastapp/commuter/model/Settings;", "value", "", "label", "(Ljava/lang/String;III)V", "getLabel", "()I", "getValue", "USE", "DEFAULT", "UNUSE", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class ExpressSettings
extends Enum<ExpressSettings>
implements Settings {
    private static final /* synthetic */ ExpressSettings[] $VALUES;
    public static final /* enum */ ExpressSettings DEFAULT;
    public static final /* enum */ ExpressSettings UNUSE;
    public static final /* enum */ ExpressSettings USE;
    private final int label;
    private final int value;

    static {
        ExpressSettings expressSettings;
        ExpressSettings expressSettings2;
        ExpressSettings expressSettings3;
        USE = expressSettings2 = new ExpressSettings(0, 2131558503);
        DEFAULT = expressSettings = new ExpressSettings(1, 2131558500);
        UNUSE = expressSettings3 = new ExpressSettings(2, 2131558502);
        $VALUES = new ExpressSettings[]{expressSettings2, expressSettings, expressSettings3};
    }

    protected ExpressSettings(int n3, int n4) {
        this.value = n3;
        this.label = n4;
    }

    public static ExpressSettings valueOf(String string2) {
        return Enum.valueOf(ExpressSettings.class, string2);
    }

    public static ExpressSettings[] values() {
        return (ExpressSettings[])$VALUES.clone();
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

