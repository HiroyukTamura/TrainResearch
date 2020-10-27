package com.google.android.datatransport.cct.p006b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0582e;

/* renamed from: com.google.android.datatransport.cct.b.k */
public abstract class C0592k {

    /* renamed from: com.google.android.datatransport.cct.b.k$a */
    public static abstract class C0593a {
        @NonNull
        /* renamed from: a */
        public abstract C0593a mo9466a(@Nullable C0570a aVar);

        @NonNull
        /* renamed from: a */
        public abstract C0593a mo9467a(@Nullable C0594b bVar);

        @NonNull
        /* renamed from: a */
        public abstract C0592k mo9468a();
    }

    /* renamed from: com.google.android.datatransport.cct.b.k$b */
    public enum C0594b {
        UNKNOWN,
        ANDROID_FIREBASE;

        static {
            UNKNOWN = new C0594b("UNKNOWN", 0);
            ANDROID_FIREBASE = new C0594b("ANDROID_FIREBASE", 1);
        }
    }

    @NonNull
    /* renamed from: c */
    public static C0593a m140c() {
        return new C0582e.C0583a();
    }

    @Nullable
    /* renamed from: a */
    public abstract C0570a mo9461a();

    @Nullable
    /* renamed from: b */
    public abstract C0594b mo9462b();
}
