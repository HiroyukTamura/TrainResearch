package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.C1111a0;
import kotlinx.coroutines.C2492B;
import kotlinx.coroutines.C2502K;
import kotlinx.coroutines.C2527d;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u0015\u0010\u0002\u001a\u00020\u0003*\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo21739d2 = {"JOB_KEY", "", "viewModelScope", "Lkotlinx/coroutines/CoroutineScope;", "Landroidx/lifecycle/ViewModel;", "getViewModelScope", "(Landroidx/lifecycle/ViewModel;)Lkotlinx/coroutines/CoroutineScope;", "lifecycle-viewmodel-ktx_release"}, mo21740k = 2, mo21741mv = {1, 1, 15})
public final class ViewModelKt {
    private static final String JOB_KEY = "androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY";

    public static final C2492B getViewModelScope(ViewModel viewModel) {
        Intrinsics.checkParameterIsNotNull(viewModel, "$this$viewModelScope");
        C2492B b = (C2492B) viewModel.getTag(JOB_KEY);
        if (b != null) {
            return b;
        }
        Object tagIfAbsent = viewModel.setTagIfAbsent(JOB_KEY, new CloseableCoroutineScope(C2527d.m4381a((C1111a0) null, 1).plus(C2502K.m4331b().mo35536o())));
        Intrinsics.checkExpressionValueIsNotNull(tagIfAbsent, "setTagIfAbsent(JOB_KEY,\n…patchers.Main.immediate))");
        return (C2492B) tagIfAbsent;
    }
}
