package com.google.android.datatransport.runtime.backends;

import androidx.annotation.Nullable;
import com.google.android.datatransport.runtime.backends.C0618f;
import java.util.Arrays;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p031a.p032i.C0896g;

/* renamed from: com.google.android.datatransport.runtime.backends.a */
final class C0611a extends C0618f {

    /* renamed from: a */
    private final Iterable<C0896g> f257a;

    /* renamed from: b */
    private final byte[] f258b;

    /* renamed from: com.google.android.datatransport.runtime.backends.a$b */
    static final class C0613b extends C0618f.C0619a {

        /* renamed from: a */
        private Iterable<C0896g> f259a;

        /* renamed from: b */
        private byte[] f260b;

        C0613b() {
        }

        /* renamed from: a */
        public C0618f.C0619a mo9531a(Iterable<C0896g> iterable) {
            if (iterable != null) {
                this.f259a = iterable;
                return this;
            }
            throw new NullPointerException("Null events");
        }

        /* renamed from: a */
        public C0618f.C0619a mo9532a(@Nullable byte[] bArr) {
            this.f260b = bArr;
            return this;
        }

        /* renamed from: a */
        public C0618f mo9533a() {
            String str = this.f259a == null ? " events" : "";
            if (str.isEmpty()) {
                return new C0611a(this.f259a, this.f260b, (C0612a) null);
            }
            throw new IllegalStateException(C0681a.m320a("Missing required properties:", str));
        }
    }

    /* synthetic */ C0611a(Iterable iterable, byte[] bArr, C0612a aVar) {
        this.f257a = iterable;
        this.f258b = bArr;
    }

    /* renamed from: a */
    public Iterable<C0896g> mo9526a() {
        return this.f257a;
    }

    @Nullable
    /* renamed from: b */
    public byte[] mo9527b() {
        return this.f258b;
    }

    public boolean equals(Object obj) {
        byte[] bArr;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0618f)) {
            return false;
        }
        C0618f fVar = (C0618f) obj;
        if (this.f257a.equals(((C0611a) fVar).f257a)) {
            byte[] bArr2 = this.f258b;
            boolean z = fVar instanceof C0611a;
            C0611a aVar = (C0611a) fVar;
            if (z) {
                bArr = aVar.f258b;
            } else {
                bArr = aVar.f258b;
            }
            if (Arrays.equals(bArr2, bArr)) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((this.f257a.hashCode() ^ 1000003) * 1000003) ^ Arrays.hashCode(this.f258b);
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("BackendRequest{events=");
        a.append(this.f257a);
        a.append(", extras=");
        a.append(Arrays.toString(this.f258b));
        a.append("}");
        return a.toString();
    }
}
