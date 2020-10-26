/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.builtins;

import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.a.al;
import kotlin.reflect.jvm.internal.impl.a.a.e;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ab;
import kotlin.reflect.jvm.internal.impl.a.ac;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.aj;
import kotlin.reflect.jvm.internal.impl.a.ak;
import kotlin.reflect.jvm.internal.impl.a.b.a;
import kotlin.reflect.jvm.internal.impl.a.b.c;
import kotlin.reflect.jvm.internal.impl.a.c.m;
import kotlin.reflect.jvm.internal.impl.a.c.u;
import kotlin.reflect.jvm.internal.impl.a.c.w;
import kotlin.reflect.jvm.internal.impl.a.n;
import kotlin.reflect.jvm.internal.impl.a.r;
import kotlin.reflect.jvm.internal.impl.a.s;
import kotlin.reflect.jvm.internal.impl.a.y;
import kotlin.reflect.jvm.internal.impl.b.a.d;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsLoader;
import kotlin.reflect.jvm.internal.impl.builtins.BuiltInsPackageFragment;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypesKt;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedType;
import kotlin.reflect.jvm.internal.impl.builtins.UnsignedTypes;
import kotlin.reflect.jvm.internal.impl.builtins.a.b;
import kotlin.reflect.jvm.internal.impl.e.f;
import kotlin.reflect.jvm.internal.impl.h.g;
import kotlin.reflect.jvm.internal.impl.i.i;
import kotlin.reflect.jvm.internal.impl.j.ad;
import kotlin.reflect.jvm.internal.impl.j.an;
import kotlin.reflect.jvm.internal.impl.j.ap;
import kotlin.reflect.jvm.internal.impl.j.ar;
import kotlin.reflect.jvm.internal.impl.j.av;
import kotlin.reflect.jvm.internal.impl.j.ba;
import kotlin.reflect.jvm.internal.impl.j.x;

public abstract class KotlinBuiltIns {
    public static final f BUILTINS_MODULE_NAME;
    public static final kotlin.reflect.jvm.internal.impl.e.b BUILT_INS_PACKAGE_FQ_NAME;
    public static final Set<kotlin.reflect.jvm.internal.impl.e.b> BUILT_INS_PACKAGE_FQ_NAMES;
    public static final f BUILT_INS_PACKAGE_NAME;
    public static final kotlin.reflect.jvm.internal.impl.e.b COLLECTIONS_PACKAGE_FQ_NAME;
    public static final FqNames FQ_NAMES;
    public static final kotlin.reflect.jvm.internal.impl.e.b RANGES_PACKAGE_FQ_NAME;
    public static final kotlin.reflect.jvm.internal.impl.e.b TEXT_PACKAGE_FQ_NAME;
    static final /* synthetic */ boolean a;
    private static final kotlin.reflect.jvm.internal.impl.e.b b;
    private u c;
    private final kotlin.reflect.jvm.internal.impl.i.f<b> d;
    private final kotlin.reflect.jvm.internal.impl.i.c<y, c> e;
    private final kotlin.reflect.jvm.internal.impl.i.f<a> f;
    private final kotlin.reflect.jvm.internal.impl.i.c<Integer, kotlin.reflect.jvm.internal.impl.a.e> g;
    private final kotlin.reflect.jvm.internal.impl.i.c<f, kotlin.reflect.jvm.internal.impl.a.e> h;
    private final i i;

    static {
        a = KotlinBuiltIns.class.desiredAssertionStatus() ^ true;
        BUILT_INS_PACKAGE_NAME = f.a("kotlin");
        BUILT_INS_PACKAGE_FQ_NAME = kotlin.reflect.jvm.internal.impl.e.b.c(BUILT_INS_PACKAGE_NAME);
        b = BUILT_INS_PACKAGE_FQ_NAME.a(f.a("annotation"));
        COLLECTIONS_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.a(f.a("collections"));
        RANGES_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.a(f.a("ranges"));
        TEXT_PACKAGE_FQ_NAME = BUILT_INS_PACKAGE_FQ_NAME.a(f.a("text"));
        BUILT_INS_PACKAGE_FQ_NAMES = al.a(BUILT_INS_PACKAGE_FQ_NAME, COLLECTIONS_PACKAGE_FQ_NAME, RANGES_PACKAGE_FQ_NAME, b, ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME(), BUILT_INS_PACKAGE_FQ_NAME.a(f.a("internal")));
        FQ_NAMES = new FqNames();
        BUILTINS_MODULE_NAME = f.c("<built-ins module>");
    }

    protected KotlinBuiltIns(i i2) {
        this.i = i2;
        this.f = i2.a(new kotlin.e.a.a<a>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public a b() {
                ac ac2 = KotlinBuiltIns.this.c.g();
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                ab ab2 = KotlinBuiltIns.this.a(ac2, linkedHashMap, KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME);
                ab ab3 = KotlinBuiltIns.this.a(ac2, linkedHashMap, KotlinBuiltIns.COLLECTIONS_PACKAGE_FQ_NAME);
                KotlinBuiltIns.this.a(ac2, linkedHashMap, KotlinBuiltIns.RANGES_PACKAGE_FQ_NAME);
                return new a(ab2, ab3, KotlinBuiltIns.this.a(ac2, linkedHashMap, b), new LinkedHashSet(linkedHashMap.values()));
            }
        });
        this.d = i2.a(new kotlin.e.a.a<b>(){

            @Override
            public /* synthetic */ Object a() {
                return this.b();
            }

            public b b() {
                EnumMap<PrimitiveType, ad> enumMap = new EnumMap<PrimitiveType, ad>(PrimitiveType.class);
                HashMap<ad, ad> hashMap = new HashMap<ad, ad>();
                HashMap<ad, ad> hashMap2 = new HashMap<ad, ad>();
                for (PrimitiveType primitiveType : PrimitiveType.values()) {
                    ad ad2 = KotlinBuiltIns.this.c(primitiveType.getTypeName().a());
                    ad ad3 = KotlinBuiltIns.this.c(primitiveType.getArrayTypeName().a());
                    enumMap.put(primitiveType, ad3);
                    hashMap.put(ad2, ad3);
                    hashMap2.put(ad3, ad2);
                }
                return new b(enumMap, hashMap, hashMap2);
            }
        });
        this.e = i2.a(new kotlin.e.a.b<y, c>(){

            @Override
            public c a(y y2) {
                HashMap<kotlin.reflect.jvm.internal.impl.a.e, Object> hashMap = new HashMap<kotlin.reflect.jvm.internal.impl.a.e, Object>();
                HashMap<Object, kotlin.reflect.jvm.internal.impl.a.e> hashMap2 = new HashMap<Object, kotlin.reflect.jvm.internal.impl.a.e>();
                for (Object object : UnsignedType.values()) {
                    kotlin.reflect.jvm.internal.impl.a.a.a a2 = s.a(y2, object.getClassId());
                    if (a2 == null || (object = s.a(y2, object.getArrayClassId())) == null) continue;
                    a2 = a2.i_();
                    object = object.i_();
                    hashMap.put((kotlin.reflect.jvm.internal.impl.a.e)a2, object);
                    hashMap2.put(object, (kotlin.reflect.jvm.internal.impl.a.e)a2);
                }
                return new c(hashMap, hashMap2);
            }
        });
        this.g = i2.a(new kotlin.e.a.b<Integer, kotlin.reflect.jvm.internal.impl.a.e>(){

            @Override
            public kotlin.reflect.jvm.internal.impl.a.e a(Integer n2) {
                return new kotlin.reflect.jvm.internal.impl.builtins.a.b(KotlinBuiltIns.this.e(), ((a)KotlinBuiltIns.b((KotlinBuiltIns)KotlinBuiltIns.this).a()).a, b.b.b, n2);
            }
        });
        this.h = i2.a(new kotlin.e.a.b<f, kotlin.reflect.jvm.internal.impl.a.e>(){

            @Override
            public kotlin.reflect.jvm.internal.impl.a.e a(f f2) {
                return KotlinBuiltIns.b(f2, KotlinBuiltIns.this.getBuiltInsPackageFragment());
            }
        });
    }

    private ab a(ac object, Map<kotlin.reflect.jvm.internal.impl.e.b, ab> map, final kotlin.reflect.jvm.internal.impl.e.b b2) {
        object = (object = object.a(b2)).isEmpty() ? new m(this.c, b2) : (object.size() == 1 ? (ab)object.iterator().next() : new w(this.c, b2, (List)object){
            final /* synthetic */ List b;
            {
                this.b = list;
                super(y2, b22);
            }

            @Override
            public kotlin.reflect.jvm.internal.impl.h.e.h a() {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("built-in package ");
                stringBuilder.append(b2);
                return new kotlin.reflect.jvm.internal.impl.h.e.b(stringBuilder.toString(), kotlin.a.m.c(this.b, new kotlin.e.a.b<ab, kotlin.reflect.jvm.internal.impl.h.e.h>(){

                    @Override
                    public kotlin.reflect.jvm.internal.impl.h.e.h a(ab ab2) {
                        return ab2.a();
                    }
                }));
            }

        });
        if (map != null) {
            map.put(b2, (ab)object);
        }
        return object;
    }

    private kotlin.reflect.jvm.internal.impl.a.e a(String string2) {
        return this.getBuiltInClassByName(f.a(string2));
    }

    private static kotlin.reflect.jvm.internal.impl.a.e a(String string2, ab ab2) {
        return KotlinBuiltIns.b(f.a(string2), ab2);
    }

    private kotlin.reflect.jvm.internal.impl.a.e a(PrimitiveType primitiveType) {
        return this.a(primitiveType.getTypeName().a());
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.a.h h2, kotlin.reflect.jvm.internal.impl.e.c c2) {
        return h2.h_().equals(c2.f()) && c2.equals(kotlin.reflect.jvm.internal.impl.h.c.d(h2));
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.a.m object, kotlin.reflect.jvm.internal.impl.e.b b2) {
        h h2 = object.m_().x();
        if (h2.a(b2) != null) {
            return true;
        }
        return (object = e.j.a((kotlin.reflect.jvm.internal.impl.a.m)object)) != null && h.a.a(h2, (e)((Object)object), b2) != null;
    }

    private static boolean a(kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.e.c c2) {
        return !w2.c() && KotlinBuiltIns.isConstructedFromGivenClass(w2, c2);
    }

    private kotlin.reflect.jvm.internal.impl.a.e b(String string2) {
        return KotlinBuiltIns.a(string2, ((a)this.f.a()).b);
    }

    private static kotlin.reflect.jvm.internal.impl.a.e b(f f2, ab ab2) {
        Object object = KotlinBuiltIns.c(f2, ab2);
        if (object != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Built-in class ");
        ((StringBuilder)object).append(ab2.f().a(f2).a());
        ((StringBuilder)object).append(" is not found");
        throw new AssertionError((Object)((StringBuilder)object).toString());
    }

    static /* synthetic */ kotlin.reflect.jvm.internal.impl.i.f b(KotlinBuiltIns kotlinBuiltIns) {
        return kotlinBuiltIns.f;
    }

    private static boolean b(kotlin.reflect.jvm.internal.impl.j.w w2, kotlin.reflect.jvm.internal.impl.e.c c2) {
        return KotlinBuiltIns.isConstructedFromGivenClass(w2, c2) && !w2.c();
    }

    private static kotlin.reflect.jvm.internal.impl.a.e c(f f2, ab n2) {
        n2 = n2.a().c(f2, d.d);
        if (!a && n2 != null && !(n2 instanceof kotlin.reflect.jvm.internal.impl.a.e)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Must be a class descriptor ");
            stringBuilder.append(f2);
            stringBuilder.append(", but was ");
            stringBuilder.append(n2);
            throw new AssertionError((Object)stringBuilder.toString());
        }
        return (kotlin.reflect.jvm.internal.impl.a.e)n2;
    }

    private ad c(String string2) {
        return this.a(string2).i_();
    }

    public static kotlin.reflect.jvm.internal.impl.e.a getFunctionClassId(int n2) {
        return new kotlin.reflect.jvm.internal.impl.e.a(BUILT_INS_PACKAGE_FQ_NAME, f.a(KotlinBuiltIns.getFunctionName(n2)));
    }

    public static String getFunctionName(int n2) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Function");
        stringBuilder.append(n2);
        return stringBuilder.toString();
    }

    public static PrimitiveType getPrimitiveArrayType(kotlin.reflect.jvm.internal.impl.a.m m2) {
        if (KotlinBuiltIns.FQ_NAMES.primitiveArrayTypeShortNames.contains(m2.h_())) {
            return KotlinBuiltIns.FQ_NAMES.arrayClassFqNameToPrimitiveType.get(kotlin.reflect.jvm.internal.impl.h.c.d(m2));
        }
        return null;
    }

    public static kotlin.reflect.jvm.internal.impl.e.b getPrimitiveFqName(PrimitiveType primitiveType) {
        return BUILT_INS_PACKAGE_FQ_NAME.a(primitiveType.getTypeName());
    }

    public static PrimitiveType getPrimitiveType(kotlin.reflect.jvm.internal.impl.a.m m2) {
        if (KotlinBuiltIns.FQ_NAMES.primitiveTypeShortNames.contains(m2.h_())) {
            return KotlinBuiltIns.FQ_NAMES.fqNameToPrimitiveType.get(kotlin.reflect.jvm.internal.impl.h.c.d(m2));
        }
        return null;
    }

    public static boolean isAny(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return KotlinBuiltIns.a(e2, KotlinBuiltIns.FQ_NAMES.any);
    }

    public static boolean isAnyOrNullableAny(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isConstructedFromGivenClass(w2, KotlinBuiltIns.FQ_NAMES.any);
    }

    public static boolean isArray(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isConstructedFromGivenClass(w2, KotlinBuiltIns.FQ_NAMES.array);
    }

    public static boolean isArrayOrPrimitiveArray(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return KotlinBuiltIns.a(e2, KotlinBuiltIns.FQ_NAMES.array) || KotlinBuiltIns.getPrimitiveArrayType(e2) != null;
        {
        }
    }

    public static boolean isBoolean(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.b(w2, KotlinBuiltIns.FQ_NAMES._boolean);
    }

    public static boolean isBuiltIn(kotlin.reflect.jvm.internal.impl.a.m m2) {
        boolean bl2 = false;
        if (kotlin.reflect.jvm.internal.impl.h.c.a(m2, BuiltInsPackageFragment.class, false) != null) {
            bl2 = true;
        }
        return bl2;
    }

    public static boolean isByte(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.b(w2, KotlinBuiltIns.FQ_NAMES._byte);
    }

    public static boolean isChar(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.b(w2, KotlinBuiltIns.FQ_NAMES._char);
    }

    public static boolean isConstructedFromGivenClass(kotlin.reflect.jvm.internal.impl.j.w a2, kotlin.reflect.jvm.internal.impl.e.c c2) {
        return (a2 = a2.g().d()) instanceof kotlin.reflect.jvm.internal.impl.a.e && KotlinBuiltIns.a((kotlin.reflect.jvm.internal.impl.a.h)a2, c2);
    }

    public static boolean isDefaultBound(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isNullableAny(w2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean isDeprecated(kotlin.reflect.jvm.internal.impl.a.m m2) {
        boolean bl2 = KotlinBuiltIns.a(m2, KotlinBuiltIns.FQ_NAMES.deprecated);
        boolean bl3 = true;
        if (bl2) {
            return true;
        }
        if (!(m2 instanceof ai)) return false;
        ai ai2 = (ai)m2;
        bl2 = ai2.s();
        m2 = ai2.a();
        ak ak2 = ai2.c();
        if (m2 == null) return false;
        if (!KotlinBuiltIns.isDeprecated(m2)) return false;
        if (!bl2) return bl3;
        if (ak2 == null) return false;
        if (!KotlinBuiltIns.isDeprecated(ak2)) return false;
        return true;
    }

    public static boolean isDouble(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isDoubleOrNullableDouble(w2) && !w2.c();
    }

    public static boolean isDoubleOrNullableDouble(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isConstructedFromGivenClass(w2, KotlinBuiltIns.FQ_NAMES._double);
    }

    public static boolean isFloat(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isFloatOrNullableFloat(w2) && !w2.c();
    }

    public static boolean isFloatOrNullableFloat(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isConstructedFromGivenClass(w2, KotlinBuiltIns.FQ_NAMES._float);
    }

    public static boolean isInt(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.b(w2, KotlinBuiltIns.FQ_NAMES._int);
    }

    public static boolean isKClass(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return KotlinBuiltIns.a(e2, KotlinBuiltIns.FQ_NAMES.kClass);
    }

    public static boolean isLong(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.b(w2, KotlinBuiltIns.FQ_NAMES._long);
    }

    public static boolean isNothing(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isNothingOrNullableNothing(w2) && !av.f(w2);
    }

    public static boolean isNothingOrNullableNothing(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isConstructedFromGivenClass(w2, KotlinBuiltIns.FQ_NAMES.nothing);
    }

    public static boolean isNullableAny(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.isAnyOrNullableAny(w2) && w2.c();
    }

    public static boolean isPrimitiveArray(kotlin.reflect.jvm.internal.impl.e.c c2) {
        return KotlinBuiltIns.FQ_NAMES.arrayClassFqNameToPrimitiveType.get(c2) != null;
    }

    public static boolean isPrimitiveArray(kotlin.reflect.jvm.internal.impl.j.w a2) {
        return (a2 = a2.g().d()) != null && KotlinBuiltIns.getPrimitiveArrayType((kotlin.reflect.jvm.internal.impl.a.m)a2) != null;
    }

    public static boolean isPrimitiveClass(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return KotlinBuiltIns.getPrimitiveType(e2) != null;
    }

    public static boolean isPrimitiveType(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return !w2.c() && KotlinBuiltIns.isPrimitiveTypeOrNullablePrimitiveType(w2);
    }

    public static boolean isPrimitiveTypeOrNullablePrimitiveType(kotlin.reflect.jvm.internal.impl.j.w a2) {
        return (a2 = a2.g().d()) instanceof kotlin.reflect.jvm.internal.impl.a.e && KotlinBuiltIns.isPrimitiveClass((kotlin.reflect.jvm.internal.impl.a.e)a2);
    }

    public static boolean isShort(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.b(w2, KotlinBuiltIns.FQ_NAMES._short);
    }

    public static boolean isSpecialClassWithNoSupertypes(kotlin.reflect.jvm.internal.impl.a.e e2) {
        return KotlinBuiltIns.a(e2, KotlinBuiltIns.FQ_NAMES.any) || KotlinBuiltIns.a(e2, KotlinBuiltIns.FQ_NAMES.nothing);
        {
        }
    }

    public static boolean isString(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return w2 != null && KotlinBuiltIns.a(w2, KotlinBuiltIns.FQ_NAMES.string);
    }

    public static boolean isUnderKotlinPackage(kotlin.reflect.jvm.internal.impl.a.m m2) {
        while (m2 != null) {
            if (m2 instanceof ab) {
                return ((ab)m2).f().b(BUILT_INS_PACKAGE_NAME);
            }
            m2 = m2.b();
        }
        return false;
    }

    public static boolean isUnit(kotlin.reflect.jvm.internal.impl.j.w w2) {
        return KotlinBuiltIns.a(w2, KotlinBuiltIns.FQ_NAMES.unit);
    }

    protected void a() {
        this.c = new u(BUILTINS_MODULE_NAME, this.i, this, null);
        this.c.a(BuiltInsLoader.Companion.getInstance().createPackageFragmentProvider(this.i, this.c, this.d(), this.c(), this.b()));
        this.c.a(this.c);
    }

    protected kotlin.reflect.jvm.internal.impl.a.b.a b() {
        return a.a.a;
    }

    protected kotlin.reflect.jvm.internal.impl.a.b.c c() {
        return c.b.a;
    }

    protected Iterable<kotlin.reflect.jvm.internal.impl.a.b.b> d() {
        return Collections.singletonList(new kotlin.reflect.jvm.internal.impl.builtins.a.a(this.i, this.c));
    }

    protected i e() {
        return this.i;
    }

    public kotlin.reflect.jvm.internal.impl.a.e getAny() {
        return this.a("Any");
    }

    public ad getAnyType() {
        return this.getAny().i_();
    }

    public kotlin.reflect.jvm.internal.impl.a.e getArray() {
        return this.a("Array");
    }

    public kotlin.reflect.jvm.internal.impl.j.w getArrayElementType(kotlin.reflect.jvm.internal.impl.j.w w2) {
        if (KotlinBuiltIns.isArray(w2)) {
            if (w2.a().size() == 1) {
                return w2.a().get(0).c();
            }
            throw new IllegalStateException();
        }
        Object object = av.d(w2);
        kotlin.reflect.jvm.internal.impl.a.a.a a2 = ((b)this.d.a()).c.get(object);
        if (a2 != null) {
            return a2;
        }
        a2 = kotlin.reflect.jvm.internal.impl.h.c.a((kotlin.reflect.jvm.internal.impl.j.w)object);
        if (a2 != null && (object = ((c)this.e.a(a2)).b.get(object)) != null) {
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("not array: ");
        ((StringBuilder)object).append(w2);
        throw new IllegalStateException(((StringBuilder)object).toString());
    }

    public ad getArrayType(ba object, kotlin.reflect.jvm.internal.impl.j.w w2) {
        object = Collections.singletonList(new ar((ba)((Object)object), w2));
        return x.a(h.a.a(), this.getArray(), (List<? extends ap>)object);
    }

    public ad getBooleanType() {
        return this.getPrimitiveKotlinType(PrimitiveType.BOOLEAN);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getBuiltInClassByFqName(kotlin.reflect.jvm.internal.impl.e.b b2) {
        Object object = this.getBuiltInClassByFqNameNullable(b2);
        if (!a) {
            if (object != null) {
                return object;
            }
            object = new StringBuilder();
            ((StringBuilder)object).append("Can't find built-in class ");
            ((StringBuilder)object).append(b2);
            throw new AssertionError((Object)((StringBuilder)object).toString());
        }
        return object;
    }

    public kotlin.reflect.jvm.internal.impl.a.e getBuiltInClassByFqNameNullable(kotlin.reflect.jvm.internal.impl.e.b b2) {
        return r.a(this.c, b2, d.d);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getBuiltInClassByName(f f2) {
        return (kotlin.reflect.jvm.internal.impl.a.e)this.h.a(f2);
    }

    public u getBuiltInsModule() {
        return this.c;
    }

    public ab getBuiltInsPackageFragment() {
        return ((a)this.f.a()).a;
    }

    public ad getByteType() {
        return this.getPrimitiveKotlinType(PrimitiveType.BYTE);
    }

    public ad getCharType() {
        return this.getPrimitiveKotlinType(PrimitiveType.CHAR);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getCollection() {
        return this.b("Collection");
    }

    public ad getDefaultBound() {
        return this.getNullableAnyType();
    }

    public ad getDoubleType() {
        return this.getPrimitiveKotlinType(PrimitiveType.DOUBLE);
    }

    public ad getFloatType() {
        return this.getPrimitiveKotlinType(PrimitiveType.FLOAT);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getFunction(int n2) {
        return this.a(KotlinBuiltIns.getFunctionName(n2));
    }

    public ad getIntType() {
        return this.getPrimitiveKotlinType(PrimitiveType.INT);
    }

    public ad getLongType() {
        return this.getPrimitiveKotlinType(PrimitiveType.LONG);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getNothing() {
        return this.a("Nothing");
    }

    public ad getNothingType() {
        return this.getNothing().i_();
    }

    public ad getNullableAnyType() {
        return this.getAnyType().a(true);
    }

    public ad getNullableNothingType() {
        return this.getNothingType().a(true);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getNumber() {
        return this.a("Number");
    }

    public ad getPrimitiveArrayKotlinType(PrimitiveType primitiveType) {
        return ((b)this.d.a()).a.get((Object)primitiveType);
    }

    public ad getPrimitiveArrayKotlinTypeByPrimitiveKotlinType(kotlin.reflect.jvm.internal.impl.j.w w2) {
        kotlin.reflect.jvm.internal.impl.a.a.a a2 = ((b)this.d.a()).b.get(w2);
        if (a2 != null) {
            return a2;
        }
        if (UnsignedTypes.INSTANCE.isUnsignedType(w2)) {
            a2 = kotlin.reflect.jvm.internal.impl.h.c.a(w2);
            if (a2 == null) {
                return null;
            }
            return ((c)this.e.a(a2)).a.get(w2);
        }
        return null;
    }

    public ad getPrimitiveKotlinType(PrimitiveType primitiveType) {
        return this.a(primitiveType).i_();
    }

    public ad getShortType() {
        return this.getPrimitiveKotlinType(PrimitiveType.SHORT);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getString() {
        return this.a("String");
    }

    public ad getStringType() {
        return this.getString().i_();
    }

    public kotlin.reflect.jvm.internal.impl.a.e getSuspendFunction(int n2) {
        return (kotlin.reflect.jvm.internal.impl.a.e)this.g.a(n2);
    }

    public kotlin.reflect.jvm.internal.impl.a.e getUnit() {
        return this.a("Unit");
    }

    public ad getUnitType() {
        return this.getUnit().i_();
    }

    public static class FqNames {
        public final kotlin.reflect.jvm.internal.impl.e.c _boolean = FqNames.a("Boolean");
        public final kotlin.reflect.jvm.internal.impl.e.c _byte = FqNames.a("Byte");
        public final kotlin.reflect.jvm.internal.impl.e.c _char = FqNames.a("Char");
        public final kotlin.reflect.jvm.internal.impl.e.c _double = FqNames.a("Double");
        public final kotlin.reflect.jvm.internal.impl.e.c _enum = FqNames.a("Enum");
        public final kotlin.reflect.jvm.internal.impl.e.c _float = FqNames.a("Float");
        public final kotlin.reflect.jvm.internal.impl.e.c _int = FqNames.a("Int");
        public final kotlin.reflect.jvm.internal.impl.e.c _long = FqNames.a("Long");
        public final kotlin.reflect.jvm.internal.impl.e.c _short = FqNames.a("Short");
        public final kotlin.reflect.jvm.internal.impl.e.b annotation = FqNames.b("Annotation");
        public final kotlin.reflect.jvm.internal.impl.e.b annotationRetention = FqNames.f("AnnotationRetention");
        public final kotlin.reflect.jvm.internal.impl.e.b annotationTarget = FqNames.f("AnnotationTarget");
        public final kotlin.reflect.jvm.internal.impl.e.c any = FqNames.a("Any");
        public final kotlin.reflect.jvm.internal.impl.e.c array = FqNames.a("Array");
        public final Map<kotlin.reflect.jvm.internal.impl.e.c, PrimitiveType> arrayClassFqNameToPrimitiveType = kotlin.reflect.jvm.internal.impl.l.a.a(PrimitiveType.values().length);
        public final kotlin.reflect.jvm.internal.impl.e.c charRange = FqNames.d("CharRange");
        public final kotlin.reflect.jvm.internal.impl.e.c charSequence = FqNames.a("CharSequence");
        public final kotlin.reflect.jvm.internal.impl.e.c cloneable = FqNames.a("Cloneable");
        public final kotlin.reflect.jvm.internal.impl.e.b collection = FqNames.c("Collection");
        public final kotlin.reflect.jvm.internal.impl.e.b comparable = FqNames.b("Comparable");
        public final kotlin.reflect.jvm.internal.impl.e.b deprecated = FqNames.b("Deprecated");
        public final kotlin.reflect.jvm.internal.impl.e.b deprecationLevel = FqNames.b("DeprecationLevel");
        public final kotlin.reflect.jvm.internal.impl.e.b extensionFunctionType = FqNames.b("ExtensionFunctionType");
        public final Map<kotlin.reflect.jvm.internal.impl.e.c, PrimitiveType> fqNameToPrimitiveType = kotlin.reflect.jvm.internal.impl.l.a.a(PrimitiveType.values().length);
        public final kotlin.reflect.jvm.internal.impl.e.c functionSupertype = FqNames.a("Function");
        public final kotlin.reflect.jvm.internal.impl.e.c intRange = FqNames.d("IntRange");
        public final kotlin.reflect.jvm.internal.impl.e.b iterable = FqNames.c("Iterable");
        public final kotlin.reflect.jvm.internal.impl.e.b iterator = FqNames.c("Iterator");
        public final kotlin.reflect.jvm.internal.impl.e.c kCallable = FqNames.e("KCallable");
        public final kotlin.reflect.jvm.internal.impl.e.c kClass = FqNames.e("KClass");
        public final kotlin.reflect.jvm.internal.impl.e.c kMutableProperty0 = FqNames.e("KMutableProperty0");
        public final kotlin.reflect.jvm.internal.impl.e.c kMutableProperty1 = FqNames.e("KMutableProperty1");
        public final kotlin.reflect.jvm.internal.impl.e.c kMutableProperty2 = FqNames.e("KMutableProperty2");
        public final kotlin.reflect.jvm.internal.impl.e.a kProperty = kotlin.reflect.jvm.internal.impl.e.a.a(FqNames.e("KProperty").c());
        public final kotlin.reflect.jvm.internal.impl.e.c kProperty0 = FqNames.e("KProperty0");
        public final kotlin.reflect.jvm.internal.impl.e.c kProperty1 = FqNames.e("KProperty1");
        public final kotlin.reflect.jvm.internal.impl.e.c kProperty2 = FqNames.e("KProperty2");
        public final kotlin.reflect.jvm.internal.impl.e.b list = FqNames.c("List");
        public final kotlin.reflect.jvm.internal.impl.e.b listIterator = FqNames.c("ListIterator");
        public final kotlin.reflect.jvm.internal.impl.e.c longRange = FqNames.d("LongRange");
        public final kotlin.reflect.jvm.internal.impl.e.b map = FqNames.c("Map");
        public final kotlin.reflect.jvm.internal.impl.e.b mapEntry = this.map.a(f.a("Entry"));
        public final kotlin.reflect.jvm.internal.impl.e.b mustBeDocumented = FqNames.f("MustBeDocumented");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableCollection = FqNames.c("MutableCollection");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableIterable = FqNames.c("MutableIterable");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableIterator = FqNames.c("MutableIterator");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableList = FqNames.c("MutableList");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableListIterator = FqNames.c("MutableListIterator");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableMap = FqNames.c("MutableMap");
        public final kotlin.reflect.jvm.internal.impl.e.b mutableMapEntry = this.mutableMap.a(f.a("MutableEntry"));
        public final kotlin.reflect.jvm.internal.impl.e.b mutableSet = FqNames.c("MutableSet");
        public final kotlin.reflect.jvm.internal.impl.e.c nothing = FqNames.a("Nothing");
        public final kotlin.reflect.jvm.internal.impl.e.c number = FqNames.a("Number");
        public final kotlin.reflect.jvm.internal.impl.e.b parameterName = FqNames.b("ParameterName");
        public final Set<f> primitiveArrayTypeShortNames = kotlin.reflect.jvm.internal.impl.l.a.b(PrimitiveType.values().length);
        public final Set<f> primitiveTypeShortNames = kotlin.reflect.jvm.internal.impl.l.a.b(PrimitiveType.values().length);
        public final kotlin.reflect.jvm.internal.impl.e.b publishedApi = FqNames.b("PublishedApi");
        public final kotlin.reflect.jvm.internal.impl.e.b repeatable = FqNames.f("Repeatable");
        public final kotlin.reflect.jvm.internal.impl.e.b replaceWith = FqNames.b("ReplaceWith");
        public final kotlin.reflect.jvm.internal.impl.e.b retention = FqNames.f("Retention");
        public final kotlin.reflect.jvm.internal.impl.e.b set = FqNames.c("Set");
        public final kotlin.reflect.jvm.internal.impl.e.c string = FqNames.a("String");
        public final kotlin.reflect.jvm.internal.impl.e.b suppress = FqNames.b("Suppress");
        public final kotlin.reflect.jvm.internal.impl.e.b target = FqNames.f("Target");
        public final kotlin.reflect.jvm.internal.impl.e.b throwable = FqNames.b("Throwable");
        public final kotlin.reflect.jvm.internal.impl.e.a uByte = kotlin.reflect.jvm.internal.impl.e.a.a(this.uByteFqName);
        public final kotlin.reflect.jvm.internal.impl.e.b uByteFqName = FqNames.b("UByte");
        public final kotlin.reflect.jvm.internal.impl.e.a uInt = kotlin.reflect.jvm.internal.impl.e.a.a(this.uIntFqName);
        public final kotlin.reflect.jvm.internal.impl.e.b uIntFqName = FqNames.b("UInt");
        public final kotlin.reflect.jvm.internal.impl.e.a uLong = kotlin.reflect.jvm.internal.impl.e.a.a(this.uLongFqName);
        public final kotlin.reflect.jvm.internal.impl.e.b uLongFqName = FqNames.b("ULong");
        public final kotlin.reflect.jvm.internal.impl.e.a uShort = kotlin.reflect.jvm.internal.impl.e.a.a(this.uShortFqName);
        public final kotlin.reflect.jvm.internal.impl.e.b uShortFqName = FqNames.b("UShort");
        public final kotlin.reflect.jvm.internal.impl.e.c unit = FqNames.a("Unit");
        public final kotlin.reflect.jvm.internal.impl.e.b unsafeVariance = FqNames.b("UnsafeVariance");

        public FqNames() {
            for (PrimitiveType primitiveType : PrimitiveType.values()) {
                this.primitiveTypeShortNames.add(primitiveType.getTypeName());
                this.primitiveArrayTypeShortNames.add(primitiveType.getArrayTypeName());
                this.fqNameToPrimitiveType.put(FqNames.a(primitiveType.getTypeName().a()), primitiveType);
                this.arrayClassFqNameToPrimitiveType.put(FqNames.a(primitiveType.getArrayTypeName().a()), primitiveType);
            }
        }

        private static kotlin.reflect.jvm.internal.impl.e.c a(String string2) {
            return FqNames.b(string2).b();
        }

        private static kotlin.reflect.jvm.internal.impl.e.b b(String string2) {
            return KotlinBuiltIns.BUILT_INS_PACKAGE_FQ_NAME.a(f.a(string2));
        }

        private static kotlin.reflect.jvm.internal.impl.e.b c(String string2) {
            return KotlinBuiltIns.COLLECTIONS_PACKAGE_FQ_NAME.a(f.a(string2));
        }

        private static kotlin.reflect.jvm.internal.impl.e.c d(String string2) {
            return KotlinBuiltIns.RANGES_PACKAGE_FQ_NAME.a(f.a(string2)).b();
        }

        private static kotlin.reflect.jvm.internal.impl.e.c e(String string2) {
            return ReflectionTypesKt.getKOTLIN_REFLECT_FQ_NAME().a(f.a(string2)).b();
        }

        private static kotlin.reflect.jvm.internal.impl.e.b f(String string2) {
            return b.a(f.a(string2));
        }
    }

    private static class a {
        public final ab a;
        public final ab b;
        public final ab c;
        public final Set<ab> d;

        private a(ab ab2, ab ab3, ab ab4, Set<ab> set) {
            this.a = ab2;
            this.b = ab3;
            this.c = ab4;
            this.d = set;
        }
    }

    private static class b {
        public final Map<PrimitiveType, ad> a;
        public final Map<kotlin.reflect.jvm.internal.impl.j.w, ad> b;
        public final Map<ad, ad> c;

        private b(Map<PrimitiveType, ad> map, Map<kotlin.reflect.jvm.internal.impl.j.w, ad> map2, Map<ad, ad> map3) {
            this.a = map;
            this.b = map2;
            this.c = map3;
        }
    }

    private static class c {
        public final Map<kotlin.reflect.jvm.internal.impl.j.w, ad> a;
        public final Map<ad, ad> b;

        private c(Map<kotlin.reflect.jvm.internal.impl.j.w, ad> map, Map<ad, ad> map2) {
            this.a = map;
            this.b = map2;
        }
    }

}

