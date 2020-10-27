package retrofit2;

import androidx.recyclerview.widget.ItemTouchHelper;
import java.util.Objects;
import p009e.p010a.p011a.p012a.C0681a;
import p040i.C0974E;
import p040i.C0980J;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1952y;
import retrofit2.OkHttpCall;

public final class Response<T> {
    private final T body;
    private final C0980J errorBody;
    private final C1758I rawResponse;

    private Response(C1758I i, T t, C0980J j) {
        this.rawResponse = i;
        this.body = t;
        this.errorBody = j;
    }

    public static <T> Response<T> error(int i, C0980J j) {
        Objects.requireNonNull(j, "body == null");
        if (i >= 400) {
            C1758I.C1759a aVar = new C1758I.C1759a();
            aVar.mo27576a((C0980J) new OkHttpCall.NoContentResponseBody(j.contentType(), j.contentLength()));
            aVar.mo27571a(i);
            aVar.mo27579a("Response.error()");
            aVar.mo27573a(C0974E.HTTP_1_1);
            C1755F.C1756a aVar2 = new C1755F.C1756a();
            aVar2.mo27552b("http://localhost/");
            aVar.mo27574a(aVar2.mo27551a());
            return error(j, aVar.mo27581a());
        }
        throw new IllegalArgumentException(C0681a.m316a("code < 400: ", i));
    }

    public static <T> Response<T> error(C0980J j, C1758I i) {
        Objects.requireNonNull(j, "body == null");
        Objects.requireNonNull(i, "rawResponse == null");
        if (!i.mo27562s()) {
            return new Response<>(i, (Object) null, j);
        }
        throw new IllegalArgumentException("rawResponse should not be successful response");
    }

    public static <T> Response<T> success(int i, T t) {
        if (i < 200 || i >= 300) {
            throw new IllegalArgumentException(C0681a.m316a("code < 200 or >= 300: ", i));
        }
        C1758I.C1759a aVar = new C1758I.C1759a();
        aVar.mo27571a(i);
        aVar.mo27579a("Response.success()");
        aVar.mo27573a(C0974E.HTTP_1_1);
        C1755F.C1756a aVar2 = new C1755F.C1756a();
        aVar2.mo27552b("http://localhost/");
        aVar.mo27574a(aVar2.mo27551a());
        return success(t, aVar.mo27581a());
    }

    public static <T> Response<T> success(T t) {
        C1758I.C1759a aVar = new C1758I.C1759a();
        aVar.mo27571a((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        aVar.mo27579a("OK");
        aVar.mo27573a(C0974E.HTTP_1_1);
        C1755F.C1756a aVar2 = new C1755F.C1756a();
        aVar2.mo27552b("http://localhost/");
        aVar.mo27574a(aVar2.mo27551a());
        return success(t, aVar.mo27581a());
    }

    public static <T> Response<T> success(T t, C1758I i) {
        Objects.requireNonNull(i, "rawResponse == null");
        if (i.mo27562s()) {
            return new Response<>(i, t, (C0980J) null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public static <T> Response<T> success(T t, C1952y yVar) {
        Objects.requireNonNull(yVar, "headers == null");
        C1758I.C1759a aVar = new C1758I.C1759a();
        aVar.mo27571a((int) ItemTouchHelper.Callback.DEFAULT_DRAG_ANIMATION_DURATION);
        aVar.mo27579a("OK");
        aVar.mo27573a(C0974E.HTTP_1_1);
        aVar.mo27578a(yVar);
        C1755F.C1756a aVar2 = new C1755F.C1756a();
        aVar2.mo27552b("http://localhost/");
        aVar.mo27574a(aVar2.mo27551a());
        return success(t, aVar.mo27581a());
    }

    public T body() {
        return this.body;
    }

    public int code() {
        return this.rawResponse.mo27558o();
    }

    public C0980J errorBody() {
        return this.errorBody;
    }

    public C1952y headers() {
        return this.rawResponse.mo27561r();
    }

    public boolean isSuccessful() {
        return this.rawResponse.mo27562s();
    }

    public String message() {
        return this.rawResponse.mo27563t();
    }

    public C1758I raw() {
        return this.rawResponse;
    }

    public String toString() {
        return this.rawResponse.toString();
    }
}
