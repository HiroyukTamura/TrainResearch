package p043jp.reifrontier.silentlogsdkandroid.daily;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import p009e.p010a.p011a.p012a.C0681a;
import p043jp.reifrontier.silentlogsdkandroid.daily.RFLDataLogger;
import p043jp.reifrontier.silentlogsdkandroid.domain.p121db.RFLEntityDailyTag;
import p043jp.reifrontier.silentlogsdkandroid.utils.RFLDailyUtilsKt;
import p048l.p049a.C1122a;
import p078g.p079a.C1696b;
import p078g.p079a.C1697c;
import p078g.p079a.C1699e;
import p078g.p079a.p094C.C1683a;
import p078g.p079a.p100z.C1738a;
import p078g.p079a.p100z.C1741d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004JC\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002J.\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H\u0007J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00152\u0006\u0010\u0007\u001a\u00020\bH\u0002JC\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002J.\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H\u0007JO\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00190\n2#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0002J:\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0018\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\u00190\n2\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0013H\u0007JC\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2#\u0010\f\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u0006\u0018\u00010\rH\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/daily/RFLDailyTagManager;", "", "dataLogger", "Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;", "(Ljp/reifrontier/silentlogsdkandroid/daily/RFLDataLogger;)V", "addDailyTag", "", "targetDate", "Ljava/util/Date;", "dailyTags", "", "", "listener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "success", "addDailyTagAsync", "Lkotlin/Function0;", "getDailyTagsFromEntity", "", "removeDailyTag", "removeDailyTagAsync", "replaceDailyTag", "Lkotlin/Pair;", "replaceDailyTagAsync", "save", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager */
public final class RFLDailyTagManager {

    /* renamed from: a */
    private final RFLDataLogger f3110a;

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$a */
    static final class C2149a implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDailyTagManager f3111a;

        /* renamed from: b */
        final /* synthetic */ Date f3112b;

        /* renamed from: c */
        final /* synthetic */ List f3113c;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$a$a */
        static final class C2150a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: a */
            final /* synthetic */ C1697c f3114a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2150a(C1697c cVar) {
                super(1);
                this.f3114a = cVar;
            }

            /* renamed from: a */
            public final void mo31278a(boolean z) {
                this.f3114a.onComplete();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo31278a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        C2149a(RFLDailyTagManager rFLDailyTagManager, Date date, List list) {
            this.f3111a = rFLDailyTagManager;
            this.f3112b = date;
            this.f3113c = list;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "emitter");
            this.f3111a.m3729a(this.f3112b, this.f3113c, new C2150a(cVar));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$b */
    static final class C2151b implements C1738a {

        /* renamed from: a */
        final /* synthetic */ Function0 f3115a;

        C2151b(Function0 function0) {
            this.f3115a = function0;
        }

        public final void run() {
            Function0 function0 = this.f3115a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$c */
    static final class C2152c implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDailyTagManager f3116a;

        /* renamed from: b */
        final /* synthetic */ Date f3117b;

        /* renamed from: c */
        final /* synthetic */ List f3118c;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$c$a */
        static final class C2153a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: a */
            final /* synthetic */ C1697c f3119a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2153a(C1697c cVar) {
                super(1);
                this.f3119a = cVar;
            }

            /* renamed from: a */
            public final void mo31279a(boolean z) {
                this.f3119a.onComplete();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo31279a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        C2152c(RFLDailyTagManager rFLDailyTagManager, Date date, List list) {
            this.f3116a = rFLDailyTagManager;
            this.f3117b = date;
            this.f3118c = list;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "emitter");
            this.f3116a.m3730b(this.f3117b, this.f3118c, new C2153a(cVar));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$d */
    static final class C2154d implements C1738a {

        /* renamed from: a */
        final /* synthetic */ Function0 f3120a;

        C2154d(Function0 function0) {
            this.f3120a = function0;
        }

        public final void run() {
            Function0 function0 = this.f3120a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    @Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo21739d2 = {"<anonymous>", "", "emitter", "Lio/reactivex/CompletableEmitter;", "subscribe"}, mo21740k = 3, mo21741mv = {1, 1, 16})
    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$e */
    static final class C2155e implements C1699e {

        /* renamed from: a */
        final /* synthetic */ RFLDailyTagManager f3121a;

        /* renamed from: b */
        final /* synthetic */ Date f3122b;

        /* renamed from: c */
        final /* synthetic */ List f3123c;

        /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$e$a */
        static final class C2156a extends Lambda implements Function1<Boolean, Unit> {

            /* renamed from: a */
            final /* synthetic */ C1697c f3124a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C2156a(C1697c cVar) {
                super(1);
                this.f3124a = cVar;
            }

            /* renamed from: a */
            public final void mo31280a(boolean z) {
                this.f3124a.onComplete();
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                mo31280a(((Boolean) obj).booleanValue());
                return Unit.INSTANCE;
            }
        }

        C2155e(RFLDailyTagManager rFLDailyTagManager, Date date, List list) {
            this.f3121a = rFLDailyTagManager;
            this.f3122b = date;
            this.f3123c = list;
        }

        public final void subscribe(C1697c cVar) {
            Intrinsics.checkParameterIsNotNull(cVar, "emitter");
            this.f3121a.m3731c(this.f3122b, this.f3123c, new C2156a(cVar));
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$f */
    static final class C2157f implements C1738a {

        /* renamed from: a */
        final /* synthetic */ Function0 f3125a;

        C2157f(Function0 function0) {
            this.f3125a = function0;
        }

        public final void run() {
            Function0 function0 = this.f3125a;
            if (function0 != null) {
                Unit unit = (Unit) function0.invoke();
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$g */
    static final class C2158g<T> implements C1741d<RFLDataLogger.Result> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3126a;

        C2158g(Function1 function1) {
            this.f3126a = function1;
        }

        /* renamed from: a */
        public final void accept(RFLDataLogger.Result result) {
            Function1 function1 = this.f3126a;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(true);
            }
        }
    }

    /* renamed from: jp.reifrontier.silentlogsdkandroid.daily.RFLDailyTagManager$h */
    static final class C2159h<T> implements C1741d<Throwable> {

        /* renamed from: a */
        final /* synthetic */ Function1 f3127a;

        C2159h(Function1 function1) {
            this.f3127a = function1;
        }

        /* renamed from: a */
        public final void accept(Throwable th) {
            C1122a.m1599b(C0681a.m326a(th, C0681a.m331a("[SilentLogSDK] Error::SaveDailyTag ", th, "it")), new Object[0]);
            Function1 function1 = this.f3127a;
            if (function1 != null) {
                Unit unit = (Unit) function1.invoke(false);
            }
        }
    }

    public RFLDailyTagManager(RFLDataLogger rFLDataLogger) {
        Intrinsics.checkParameterIsNotNull(rFLDataLogger, "dataLogger");
        this.f3110a = rFLDataLogger;
    }

    /* renamed from: a */
    private final List<String> m3728a(Date date) {
        String dailyTag;
        List split$default;
        List<String> list;
        ArrayList arrayList = new ArrayList();
        RFLEntityDailyTag findDailyTag = this.f3110a.findDailyTag(date);
        if (!(findDailyTag == null || (dailyTag = findDailyTag.getDailyTag()) == null || (split$default = StringsKt__StringsKt.split$default((CharSequence) dailyTag, new String[]{","}, false, 0, 6, (Object) null)) == null || (list = CollectionsKt___CollectionsKt.toList(split$default)) == null)) {
            for (String str : list) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m3729a(Date date, List<String> list, Function1<? super Boolean, Unit> function1) {
        List<String> a = m3728a(date);
        for (String str : list) {
            if (!a.contains(str)) {
                a.add(str);
            }
        }
        m3732d(date, a, function1);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m3730b(Date date, List<String> list, Function1<? super Boolean, Unit> function1) {
        List<String> a = m3728a(date);
        for (String str : list) {
            if (a.contains(str)) {
                a.remove(str);
            }
        }
        m3732d(date, a, function1);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m3731c(Date date, List<Pair<String, String>> list, Function1<? super Boolean, Unit> function1) {
        List<String> a = m3728a(date);
        for (Pair pair : list) {
            String str = (String) pair.component2();
            int indexOf = a.indexOf((String) pair.component1());
            if (indexOf >= 0) {
                a.remove(indexOf);
                a.add(indexOf, str);
            }
        }
        m3732d(date, a, function1);
    }

    @SuppressLint({"CheckResult"})
    /* renamed from: d */
    private final void m3732d(Date date, List<String> list, Function1<? super Boolean, Unit> function1) {
        this.f3110a.saveDailyTag(date, CollectionsKt___CollectionsKt.joinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null), RFLDailyUtilsKt.second(new Date())).mo27432a(new C2158g(function1), new C2159h(function1));
    }

    @SuppressLint({"CheckResult"})
    public final void addDailyTagAsync(Date date, List<String> list, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        C1696b.m2386a((C1699e) new C2149a(this, date, list)).mo27420a(C1683a.m2378b()).mo27422a((C1738a) new C2151b(function0));
    }

    @SuppressLint({"CheckResult"})
    public final void removeDailyTagAsync(Date date, List<String> list, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        C1696b.m2386a((C1699e) new C2152c(this, date, list)).mo27420a(C1683a.m2378b()).mo27422a((C1738a) new C2154d(function0));
    }

    @SuppressLint({"CheckResult"})
    public final void replaceDailyTagAsync(Date date, List<Pair<String, String>> list, Function0<Unit> function0) {
        Intrinsics.checkParameterIsNotNull(date, "targetDate");
        Intrinsics.checkParameterIsNotNull(list, "dailyTags");
        C1696b.m2386a((C1699e) new C2155e(this, date, list)).mo27420a(C1683a.m2378b()).mo27422a((C1738a) new C2157f(function0));
    }
}
