package p042j;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: j.p */
public final class C2080p {
    /* renamed from: a */
    public static final C2090x m3580a(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "$this$appendingSink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, true);
        Intrinsics.checkParameterIsNotNull(fileOutputStream, "$this$sink");
        return new C2083r(fileOutputStream, new C2057A());
    }

    /* renamed from: b */
    public static final C1016z m3585b(File file) throws FileNotFoundException {
        Intrinsics.checkParameterIsNotNull(file, "$this$source");
        FileInputStream fileInputStream = new FileInputStream(file);
        Intrinsics.checkParameterIsNotNull(fileInputStream, "$this$source");
        return new C2079o(fileInputStream, new C2057A());
    }

    @JvmName(name = "blackhole")
    /* renamed from: a */
    public static final C2090x m3579a() {
        return new C2067e();
    }

    /* renamed from: b */
    public static final C1016z m3586b(Socket socket) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "$this$source");
        C2091y yVar = new C2091y(socket);
        InputStream inputStream = socket.getInputStream();
        Intrinsics.checkExpressionValueIsNotNull(inputStream, "getInputStream()");
        C2079o oVar = new C2079o(inputStream, yVar);
        Intrinsics.checkParameterIsNotNull(oVar, FirebaseAnalytics.Param.SOURCE);
        return new C2066d(yVar, oVar);
    }

    /* renamed from: a */
    public static final C2071g m3577a(C2090x xVar) {
        Intrinsics.checkParameterIsNotNull(xVar, "$this$buffer");
        return new C2084s(xVar);
    }

    /* renamed from: a */
    public static final C2072h m3578a(C1016z zVar) {
        Intrinsics.checkParameterIsNotNull(zVar, "$this$buffer");
        return new C2085t(zVar);
    }

    /* renamed from: a */
    public static final boolean m3584a(AssertionError assertionError) {
        Intrinsics.checkParameterIsNotNull(assertionError, "$this$isAndroidGetsocknameError");
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        return message != null ? StringsKt__StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }

    /* renamed from: a */
    public static final C2090x m3582a(Socket socket) throws IOException {
        Intrinsics.checkParameterIsNotNull(socket, "$this$sink");
        C2091y yVar = new C2091y(socket);
        OutputStream outputStream = socket.getOutputStream();
        Intrinsics.checkExpressionValueIsNotNull(outputStream, "getOutputStream()");
        C2083r rVar = new C2083r(outputStream, yVar);
        Intrinsics.checkParameterIsNotNull(rVar, "sink");
        return new C2065c(yVar, rVar);
    }

    /* renamed from: a */
    public static /* synthetic */ C2090x m3581a(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        Intrinsics.checkParameterIsNotNull(file, "$this$sink");
        FileOutputStream fileOutputStream = new FileOutputStream(file, z);
        Intrinsics.checkParameterIsNotNull(fileOutputStream, "$this$sink");
        return new C2083r(fileOutputStream, new C2057A());
    }

    /* renamed from: a */
    public static final C1016z m3583a(InputStream inputStream) {
        Intrinsics.checkParameterIsNotNull(inputStream, "$this$source");
        return new C2079o(inputStream, new C2057A());
    }
}
