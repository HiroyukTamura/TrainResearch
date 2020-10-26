/*
 * Decompiled with CFR 0.139.
 */
package jp.co.jreast.jreastapp.commuter.model;

import jp.co.jreast.jreastapp.commuter.r.c;
import kotlin.Metadata;

@Metadata(bv={1, 0, 2}, d1={"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2={"Ljp/co/jreast/jreastapp/commuter/model/SettingTypes;", "", "requestCode", "", "(Ljava/lang/String;II)V", "getRequestCode", "()I", "EXPRESS", "FARE", "TRANSFER_TIME", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class SettingTypes
extends Enum<SettingTypes> {
    private static final /* synthetic */ SettingTypes[] $VALUES;
    public static final /* enum */ SettingTypes EXPRESS;
    public static final /* enum */ SettingTypes FARE;
    public static final /* enum */ SettingTypes TRANSFER_TIME;
    private final int requestCode;

    static {
        SettingTypes settingTypes;
        SettingTypes settingTypes2;
        SettingTypes settingTypes3;
        EXPRESS = settingTypes = new SettingTypes(c.n.a());
        FARE = settingTypes3 = new SettingTypes(c.o.a());
        TRANSFER_TIME = settingTypes2 = new SettingTypes(c.p.a());
        $VALUES = new SettingTypes[]{settingTypes, settingTypes3, settingTypes2};
    }

    protected SettingTypes(int n3) {
        this.requestCode = n3;
    }

    public static SettingTypes valueOf(String string2) {
        return Enum.valueOf(SettingTypes.class, string2);
    }

    public static SettingTypes[] values() {
        return (SettingTypes[])$VALUES.clone();
    }

    public final int getRequestCode() {
        return this.requestCode;
    }
}

