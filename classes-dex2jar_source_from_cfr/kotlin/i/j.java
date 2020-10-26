/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import kotlin.Metadata;
import kotlin.a.m;
import kotlin.e.b.k;
import kotlin.g.c;
import kotlin.i.f;
import kotlin.i.g;
import kotlin.i.h;
import kotlin.i.i;
import kotlin.i.l;

@Metadata(bv={1, 0, 2}, d1={"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0001H\u0016R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001c"}, d2={"Lkotlin/text/MatcherMatchResult;", "Lkotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "groupValues", "", "", "getGroupValues", "()Ljava/util/List;", "groupValues_", "groups", "Lkotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "matchResult", "Ljava/util/regex/MatchResult;", "kotlin.jvm.PlatformType", "range", "Lkotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "getValue", "()Ljava/lang/String;", "next", "kotlin-stdlib"}, k=1, mv={1, 1, 11})
final class j
implements i {
    private final MatchResult a;
    private final g b;
    private List<String> c;
    private final Matcher d;
    private final CharSequence e;

    public j(Matcher matcher, CharSequence charSequence) {
        kotlin.e.b.j.b(matcher, "matcher");
        kotlin.e.b.j.b(charSequence, "input");
        this.d = matcher;
        this.e = charSequence;
        this.a = this.d.toMatchResult();
        this.b = new h(){

            @Override
            public int a() {
                return this.a.groupCount() + 1;
            }

            public f a(int n2) {
                Object object = this.a;
                kotlin.e.b.j.a(object, "matchResult");
                object = l.a((MatchResult)object, n2);
                if (((c)object).f() >= 0) {
                    String string2 = this.a.group(n2);
                    kotlin.e.b.j.a((Object)string2, "matchResult.group(index)");
                    return new f(string2, (c)object);
                }
                return null;
            }

            public boolean a(f f2) {
                return super.contains(f2);
            }

            @Override
            public final boolean contains(Object object) {
                boolean bl2 = object != null ? object instanceof f : true;
                if (bl2) {
                    return this.a((f)object);
                }
                return false;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public Iterator<f> iterator() {
                return kotlin.h.i.e(m.q(m.a(this)), (kotlin.e.a.b)new kotlin.e.a.b<Integer, f>(){

                    @Override
                    public /* synthetic */ Object a(Object object) {
                        return this.a(((Number)object).intValue());
                    }

                    @Override
                    public final f a(int n2) {
                        return this.a(n2);
                    }
                }).a();
            }

        };
    }

    @Override
    public List<String> a() {
        List<String> list;
        if (this.c == null) {
            this.c = new kotlin.a.b<String>(){

                @Override
                public int a() {
                    return this.a.groupCount() + 1;
                }

                public int a(String string2) {
                    return super.indexOf(string2);
                }

                public String a(int n2) {
                    String string2 = this.a.group(n2);
                    if (string2 != null) {
                        return string2;
                    }
                    return "";
                }

                public int b(String string2) {
                    return super.lastIndexOf(string2);
                }

                public boolean c(String string2) {
                    return super.contains(string2);
                }

                @Override
                public final boolean contains(Object object) {
                    if (object instanceof String) {
                        return this.c((String)object);
                    }
                    return false;
                }

                @Override
                public /* synthetic */ Object get(int n2) {
                    return this.a(n2);
                }

                @Override
                public final int indexOf(Object object) {
                    if (object instanceof String) {
                        return this.a((String)object);
                    }
                    return -1;
                }

                @Override
                public final int lastIndexOf(Object object) {
                    if (object instanceof String) {
                        return this.b((String)object);
                    }
                    return -1;
                }
            };
        }
        if ((list = this.c) == null) {
            kotlin.e.b.j.a();
        }
        return list;
    }

    @Override
    public i.b b() {
        return i.a.a(this);
    }

}

