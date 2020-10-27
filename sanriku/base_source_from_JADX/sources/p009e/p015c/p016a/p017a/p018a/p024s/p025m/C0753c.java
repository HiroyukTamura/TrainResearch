package p009e.p015c.p016a.p017a.p018a.p024s.p025m;

import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p009e.p015c.p016a.p017a.p018a.p024s.C0744k;

/* renamed from: e.c.a.a.a.s.m.c */
public class C0753c {

    /* renamed from: a */
    protected final List<CharSequence> f462a = new ArrayList();

    /* renamed from: e.c.a.a.a.s.m.c$a */
    public static class C0754a implements CharSequence {
        @NonNull

        /* renamed from: a */
        final String f463a;

        public C0754a(@NonNull String str) {
            this.f463a = str;
        }

        public char charAt(int i) {
            return this.f463a.charAt(i);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof C0754a)) {
                return false;
            }
            return this.f463a.equalsIgnoreCase(((C0754a) obj).f463a);
        }

        public int hashCode() {
            return this.f463a.toLowerCase(Locale.US).hashCode();
        }

        public int length() {
            return this.f463a.length();
        }

        public CharSequence subSequence(int i, int i2) {
            return this.f463a.subSequence(i, i2);
        }

        @NonNull
        public String toString() {
            return this.f463a;
        }
    }

    /* renamed from: e.c.a.a.a.s.m.c$b */
    public static class C0755b extends C0754a {
        public C0755b(@NonNull String str) {
            super(str);
        }
    }

    /* renamed from: e.c.a.a.a.s.m.c$c */
    public static class C0756c extends C0754a {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public C0756c(@androidx.annotation.NonNull java.lang.String r3) {
            /*
                r2 = this;
                r0 = 96
                java.lang.StringBuilder r1 = p009e.p010a.p011a.p012a.C0681a.m329a((char) r0)
                java.lang.String r3 = p009e.p015c.p016a.p017a.p018a.p024s.C0744k.m437a(r3)
                r1.append(r3)
                r1.append(r0)
                java.lang.String r3 = r1.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: p009e.p015c.p016a.p017a.p018a.p024s.p025m.C0753c.C0756c.<init>(java.lang.String):void");
        }

        @NonNull
        /* renamed from: a */
        public String mo19986a() {
            return C0744k.m437a(this.f463a);
        }

        @NonNull
        public String toString() {
            return this.f463a;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0753c)) {
            return false;
        }
        return this.f462a.equals(((C0753c) obj).f462a);
    }

    public int hashCode() {
        return this.f462a.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (CharSequence next : this.f462a) {
            if (sb.length() != 0) {
                sb.append(' ');
            }
            sb.append(next);
        }
        return sb.toString();
    }
}
