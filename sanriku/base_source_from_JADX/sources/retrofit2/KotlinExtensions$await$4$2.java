package retrofit2;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C2531f;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J \u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J(\u0010\b\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\nH\u0016¨\u0006\u000b"}, mo21739d2 = {"retrofit2/KotlinExtensions$await$4$2", "Lretrofit2/Callback;", "onFailure", "", "call", "Lretrofit2/Call;", "t", "", "onResponse", "response", "Lretrofit2/Response;", "retrofit"}, mo21740k = 1, mo21741mv = {1, 1, 15})
public final class KotlinExtensions$await$4$2 implements Callback<T> {
    final /* synthetic */ C2531f $continuation;

    KotlinExtensions$await$4$2(C2531f fVar) {
        this.$continuation = fVar;
    }

    public void onFailure(Call<T> call, Throwable th) {
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(th, "t");
        C2531f fVar = this.$continuation;
        Result.Companion companion = Result.Companion;
        fVar.resumeWith(Result.m4628constructorimpl(ResultKt.createFailure(th)));
    }

    public void onResponse(Call<T> call, Response<T> response) {
        T t;
        C2531f fVar;
        Intrinsics.checkParameterIsNotNull(call, NotificationCompat.CATEGORY_CALL);
        Intrinsics.checkParameterIsNotNull(response, "response");
        if (response.isSuccessful()) {
            fVar = this.$continuation;
            t = response.body();
            Result.Companion companion = Result.Companion;
        } else {
            fVar = this.$continuation;
            HttpException httpException = new HttpException(response);
            Result.Companion companion2 = Result.Companion;
            t = ResultKt.createFailure(httpException);
        }
        fVar.resumeWith(Result.m4628constructorimpl(t));
    }
}
