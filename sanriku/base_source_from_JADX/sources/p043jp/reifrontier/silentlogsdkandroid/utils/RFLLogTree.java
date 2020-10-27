package p043jp.reifrontier.silentlogsdkandroid.utils;

import android.annotation.SuppressLint;
import android.util.Log;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p043jp.reifrontier.silentlogsdkandroid.p119di.RFLAppComponent;
import p048l.p049a.C1122a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0015R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0013"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogTree;", "Ltimber/log/Timber$DebugTree;", "()V", "rflLogger", "Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger;", "getRflLogger", "()Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger;", "setRflLogger", "(Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogger;)V", "log", "", "priority", "", "tag", "", "message", "t", "", "Companion", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree */
public final class RFLLogTree extends C1122a.C1124b {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public RFLLogger rflLogger;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/RFLLogTree$Companion;", "", "()V", "MAX_LOG_LENGTH", "", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.utils.RFLLogTree$Companion */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public RFLLogTree() {
        RFLAppComponent component$silentlogsdkandroid_release = RFLAppComponent.SdkComponent.INSTANCE.getComponent$silentlogsdkandroid_release();
        if (component$silentlogsdkandroid_release != null) {
            component$silentlogsdkandroid_release.inject(this);
        }
    }

    public final RFLLogger getRflLogger() {
        RFLLogger rFLLogger = this.rflLogger;
        if (rFLLogger == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rflLogger");
        }
        return rFLLogger;
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"LogNotTimber"})
    public void log(int i, String str, String str2, Throwable th) {
        int min;
        int i2 = i;
        String str3 = str;
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "message");
        if (i2 != 3) {
            if (!(str2.length() == 0)) {
                if (str2.length() >= 4000) {
                    int length = str2.length();
                    int i3 = 0;
                    int i4 = 0;
                    while (i3 < length) {
                        str4.charAt(i3);
                        int indexOf$default = StringsKt__StringsKt.indexOf$default((CharSequence) str2, 10, i4, false, 4, (Object) null);
                        if (indexOf$default == -1) {
                            indexOf$default = str2.length();
                        }
                        System.out.print(indexOf$default);
                        int i5 = i4;
                        while (true) {
                            min = Math.min(indexOf$default, i5 + 4000);
                            String substring = str4.substring(i5, min);
                            Intrinsics.checkExpressionValueIsNotNull(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                            if (i2 == 4) {
                                Log.println(i2, str3, substring);
                                RFLLogger rFLLogger = this.rflLogger;
                                if (rFLLogger == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("rflLogger");
                                }
                                rFLLogger.info(substring);
                            } else if (i2 == 6) {
                                Log.println(i2, str3, substring);
                                RFLLogger rFLLogger2 = this.rflLogger;
                                if (rFLLogger2 == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("rflLogger");
                                }
                                rFLLogger2.error(substring);
                            } else if (i2 != 7) {
                                Log.println(i2, str3, substring);
                            } else {
                                Log.wtf(str3, substring);
                            }
                            if (min >= indexOf$default) {
                                break;
                            }
                            i5 = min;
                        }
                        i3++;
                        i4 = min;
                    }
                } else if (i2 == 4) {
                    Log.println(i, str, str2);
                    RFLLogger rFLLogger3 = this.rflLogger;
                    if (rFLLogger3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rflLogger");
                    }
                    rFLLogger3.info(str4);
                } else if (i2 == 6) {
                    Log.println(i, str, str2);
                    RFLLogger rFLLogger4 = this.rflLogger;
                    if (rFLLogger4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("rflLogger");
                    }
                    rFLLogger4.error(str4);
                } else if (i2 != 7) {
                    Log.println(i, str, str2);
                } else {
                    Log.wtf(str, str2);
                }
            }
        }
    }

    public final void setRflLogger(RFLLogger rFLLogger) {
        Intrinsics.checkParameterIsNotNull(rFLLogger, "<set-?>");
        this.rflLogger = rFLLogger;
    }
}
