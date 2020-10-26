/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.e.a.m;
import kotlin.e.b.j;
import kotlin.g.c;
import kotlin.g.d;
import kotlin.h.h;
import kotlin.i.n;
import kotlin.o;
import kotlin.t;

@Metadata(bv={1, 0, 2}, d1={"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010(\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BJ\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012+\u0010\b\u001a'\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n0\t\u00a2\u0006\u0002\b\u000b\u00a2\u0006\u0002\u0010\fJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00020\u000eH\u0096\u0002R3\u0010\b\u001a'\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0006\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n0\t\u00a2\u0006\u0002\b\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2={"Lkotlin/text/DelimitedRangesSequence;", "Lkotlin/sequences/Sequence;", "Lkotlin/ranges/IntRange;", "input", "", "startIndex", "", "limit", "getNextMatch", "Lkotlin/Function2;", "Lkotlin/Pair;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/CharSequence;IILkotlin/jvm/functions/Function2;)V", "iterator", "", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
final class e
implements h<c> {
    private final CharSequence a;
    private final int b;
    private final int c;
    private final m<CharSequence, Integer, o<Integer, Integer>> d;

    public e(CharSequence charSequence, int n2, int n3, m<? super CharSequence, ? super Integer, o<Integer, Integer>> m2) {
        j.b(charSequence, "input");
        j.b(m2, "getNextMatch");
        this.a = charSequence;
        this.b = n2;
        this.c = n3;
        this.d = m2;
    }

    public static final /* synthetic */ int a(e e2) {
        return e2.c;
    }

    public static final /* synthetic */ m c(e e2) {
        return e2.d;
    }

    @Override
    public Iterator<c> a() {
        return new Iterator<c>(){
            private int b = -1;
            private int c;
            private int d;
            private c e;
            private int f;
            {
                this.d = this.c = d.a(e2.b, 0, e2.a.length());
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            private final void b() {
                block6 : {
                    block5 : {
                        block4 : {
                            var2_1 = this.d;
                            var1_2 = 0;
                            if (var2_1 < 0) {
                                this.b = 0;
                                this.e = null;
                                return;
                            }
                            var3_3 = e.a(this);
                            var2_1 = -1;
                            if (var3_3 <= 0) break block4;
                            ++this.f;
                            if (this.f >= e.a(this)) break block5;
                        }
                        if (this.d <= e.b(this).length()) break block6;
                    }
                    var4_4 = new c(this.c, n.c(e.b(this)));
                    ** GOTO lbl21
                }
                var4_4 = (o)e.c(this).a(e.b(this), this.d);
                if (var4_4 == null) {
                    var4_4 = new c(this.c, n.c(e.b(this)));
lbl21: // 2 sources:
                    this.e = var4_4;
                    var1_2 = var2_1;
                } else {
                    var3_3 = ((Number)var4_4.c()).intValue();
                    var2_1 = ((Number)var4_4.d()).intValue();
                    this.e = d.b(this.c, var3_3);
                    var3_3 = this.c = var3_3 + var2_1;
                    if (var2_1 == 0) {
                        var1_2 = 1;
                    }
                    var1_2 = var3_3 + var1_2;
                }
                this.d = var1_2;
                this.b = 1;
            }

            public c a() {
                if (this.b == -1) {
                    this.b();
                }
                if (this.b != 0) {
                    c c2 = this.e;
                    if (c2 != null) {
                        this.e = null;
                        this.b = -1;
                        return c2;
                    }
                    throw new t("null cannot be cast to non-null type kotlin.ranges.IntRange");
                }
                throw (Throwable)new NoSuchElementException();
            }

            @Override
            public boolean hasNext() {
                if (this.b == -1) {
                    this.b();
                }
                return this.b == 1;
            }

            @Override
            public /* synthetic */ Object next() {
                return this.a();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Operation is not supported for read-only collection");
            }
        };
    }

}

