package com.google.android.datatransport.cct.p006b;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

@Encodable
/* renamed from: com.google.android.datatransport.cct.b.j */
public abstract class C0591j {
    @NonNull
    /* renamed from: a */
    public static C0591j m138a(@NonNull List<C0597m> list) {
        return new C0581d(list);
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    /* renamed from: a */
    public abstract List<C0597m> mo9457a();
}
