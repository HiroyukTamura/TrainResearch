package com.google.android.datatransport.cct.p006b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.datatransport.cct.p006b.C0586g;
import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* renamed from: com.google.android.datatransport.cct.b.m */
public abstract class C0597m {

    /* renamed from: com.google.android.datatransport.cct.b.m$a */
    public static abstract class C0598a {
        @NonNull
        /* renamed from: a */
        public C0598a mo9517a(int i) {
            mo9500a(Integer.valueOf(i));
            return this;
        }

        @NonNull
        /* renamed from: a */
        public abstract C0598a mo9497a(long j);

        @NonNull
        /* renamed from: a */
        public abstract C0598a mo9498a(@Nullable C0592k kVar);

        @NonNull
        /* renamed from: a */
        public abstract C0598a mo9499a(@Nullable C0604p pVar);

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public abstract C0598a mo9500a(@Nullable Integer num);

        /* access modifiers changed from: package-private */
        @NonNull
        /* renamed from: a */
        public abstract C0598a mo9501a(@Nullable String str);

        @NonNull
        /* renamed from: a */
        public abstract C0598a mo9502a(@Nullable List<C0595l> list);

        @NonNull
        /* renamed from: a */
        public abstract C0597m mo9503a();

        @NonNull
        /* renamed from: b */
        public abstract C0598a mo9504b(long j);

        @NonNull
        /* renamed from: b */
        public C0598a mo9518b(@NonNull String str) {
            mo9501a(str);
            return this;
        }
    }

    @NonNull
    /* renamed from: h */
    public static C0598a m161h() {
        return new C0586g.C0587a();
    }

    @Nullable
    /* renamed from: a */
    public abstract C0592k mo9487a();

    @Nullable
    @Encodable.Field(name = "logEvent")
    /* renamed from: b */
    public abstract List<C0595l> mo9488b();

    @Nullable
    /* renamed from: c */
    public abstract Integer mo9489c();

    @Nullable
    /* renamed from: d */
    public abstract String mo9490d();

    @Nullable
    /* renamed from: e */
    public abstract C0604p mo9491e();

    /* renamed from: f */
    public abstract long mo9493f();

    /* renamed from: g */
    public abstract long mo9494g();
}
