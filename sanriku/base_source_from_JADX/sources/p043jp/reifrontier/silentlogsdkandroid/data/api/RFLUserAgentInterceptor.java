package p043jp.reifrontier.silentlogsdkandroid.data.api;

import android.content.Context;
import android.os.Build;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C1744A;
import p040i.C1755F;
import p040i.C1758I;
import p043jp.reifrontier.silentlogsdkandroid.BuildConfig;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo21739d2 = {"Ljp/reifrontier/silentlogsdkandroid/data/api/RFLUserAgentInterceptor;", "Lokhttp3/Interceptor;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "silentlogsdkandroid_release"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: jp.reifrontier.silentlogsdkandroid.data.api.RFLUserAgentInterceptor */
public final class RFLUserAgentInterceptor implements C1744A {

    /* renamed from: a */
    private final Context f3328a;

    public RFLUserAgentInterceptor(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.f3328a = context;
    }

    public C1758I intercept(C1744A.C1745a aVar) {
        Intrinsics.checkParameterIsNotNull(aVar, "chain");
        String packageName = this.f3328a.getPackageName();
        Intrinsics.checkExpressionValueIsNotNull(packageName, "context.packageName");
        String a = C0681a.m328a(new Object[]{(String) CollectionsKt___CollectionsKt.last(StringsKt__StringsKt.split$default((CharSequence) packageName, new String[]{"."}, false, 0, 6, (Object) null)), this.f3328a.getPackageManager().getPackageInfo(this.f3328a.getPackageName(), 0).versionName, BuildConfig.VERSION_NAME, Build.DEVICE, Build.VERSION.RELEASE}, 5, "%s/%s (SDK %s; %s; Android %s )", "java.lang.String.format(this, *args)");
        C1755F request = aVar.request();
        if (request != null) {
            C1755F.C1756a aVar2 = new C1755F.C1756a(request);
            aVar2.mo27550a(AbstractSpiCall.HEADER_USER_AGENT, a);
            return aVar.mo27450a(aVar2.mo27551a());
        }
        throw null;
    }
}
