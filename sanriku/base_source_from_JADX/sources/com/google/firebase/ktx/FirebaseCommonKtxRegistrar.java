package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.platforminfo.LibraryVersionComponent;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, mo21739d2 = {"Lcom/google/firebase/ktx/FirebaseCommonKtxRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", "", "Lcom/google/firebase/components/Component;", "com.google.firebase-firebase-common-ktx"}, mo21740k = 1, mo21741mv = {1, 1, 13})
@Keep
public final class FirebaseCommonKtxRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return CollectionsKt__CollectionsJVMKt.listOf(LibraryVersionComponent.create(FirebaseKt.LIBRARY_NAME, "19.3.0"));
    }
}
