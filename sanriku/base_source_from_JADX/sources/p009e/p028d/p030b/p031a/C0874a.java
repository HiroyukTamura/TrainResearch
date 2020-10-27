package p009e.p028d.p030b.p031a;

import androidx.annotation.Nullable;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.d.b.a.a */
final class C0874a<T> extends C0876c<T> {

    /* renamed from: a */
    private final Integer f525a;

    /* renamed from: b */
    private final T f526b;

    /* renamed from: c */
    private final C0877d f527c;

    C0874a(@Nullable Integer num, T t, C0877d dVar) {
        this.f525a = num;
        if (t != null) {
            this.f526b = t;
            if (dVar != null) {
                this.f527c = dVar;
                return;
            }
            throw new NullPointerException("Null priority");
        }
        throw new NullPointerException("Null payload");
    }

    @Nullable
    /* renamed from: a */
    public Integer mo20275a() {
        return this.f525a;
    }

    /* renamed from: b */
    public T mo20276b() {
        return this.f526b;
    }

    /* renamed from: c */
    public C0877d mo20277c() {
        return this.f527c;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C0876c)) {
            return false;
        }
        C0876c cVar = (C0876c) obj;
        Integer num = this.f525a;
        if (num != null ? num.equals(((C0874a) cVar).f525a) : ((C0874a) cVar).f525a == null) {
            if (!this.f526b.equals(((C0874a) cVar).f526b) || !this.f527c.equals(((C0874a) cVar).f527c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        Integer num = this.f525a;
        return (((((num == null ? 0 : num.hashCode()) ^ 1000003) * 1000003) ^ this.f526b.hashCode()) * 1000003) ^ this.f527c.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m330a("Event{code=");
        a.append(this.f525a);
        a.append(", payload=");
        a.append(this.f526b);
        a.append(", priority=");
        a.append(this.f527c);
        a.append("}");
        return a.toString();
    }
}
