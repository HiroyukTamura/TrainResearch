package p043jp.reifrontier.silentlogsdkandroid.utils;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/utils/LocaleEx;", "", "()V", "ENGLISH_LANGUAGE", "", "JAPANESE_LANGUAGE", "getDefaultLang", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.utils.LocaleEx */
public final class LocaleEx {
    public static final String ENGLISH_LANGUAGE = "en";
    public static final LocaleEx INSTANCE = new LocaleEx();
    public static final String JAPANESE_LANGUAGE = "ja";

    private LocaleEx() {
    }

    public final String getDefaultLang() {
        Locale locale = Locale.getDefault();
        Intrinsics.checkExpressionValueIsNotNull(locale, "defaultLocale");
        String language = locale.getLanguage();
        Locale locale2 = Locale.JAPAN;
        Intrinsics.checkExpressionValueIsNotNull(locale2, "Locale.JAPAN");
        if (Intrinsics.areEqual((Object) language, (Object) locale2.getLanguage())) {
            return JAPANESE_LANGUAGE;
        }
        String language2 = locale.getLanguage();
        Locale locale3 = Locale.JAPANESE;
        Intrinsics.checkExpressionValueIsNotNull(locale3, "Locale.JAPANESE");
        if (Intrinsics.areEqual((Object) language2, (Object) locale3.getLanguage())) {
            return JAPANESE_LANGUAGE;
        }
        String displayLanguage = locale.getDisplayLanguage();
        Locale locale4 = Locale.JAPAN;
        Intrinsics.checkExpressionValueIsNotNull(locale4, "Locale.JAPAN");
        if (Intrinsics.areEqual((Object) displayLanguage, (Object) locale4.getDisplayLanguage())) {
            return JAPANESE_LANGUAGE;
        }
        String displayLanguage2 = locale.getDisplayLanguage();
        Locale locale5 = Locale.JAPANESE;
        Intrinsics.checkExpressionValueIsNotNull(locale5, "Locale.JAPANESE");
        return Intrinsics.areEqual((Object) displayLanguage2, (Object) locale5.getDisplayLanguage()) ? JAPANESE_LANGUAGE : ENGLISH_LANGUAGE;
    }
}
