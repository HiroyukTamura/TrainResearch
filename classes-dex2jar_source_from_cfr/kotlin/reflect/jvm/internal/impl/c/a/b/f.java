/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.c.a.b;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.a.a.h;
import kotlin.reflect.jvm.internal.impl.a.ai;
import kotlin.reflect.jvm.internal.impl.a.an;
import kotlin.reflect.jvm.internal.impl.a.b;
import kotlin.reflect.jvm.internal.impl.a.ba;
import kotlin.reflect.jvm.internal.impl.a.c.y;
import kotlin.reflect.jvm.internal.impl.a.m;
import kotlin.reflect.jvm.internal.impl.a.w;
import kotlin.reflect.jvm.internal.impl.builtins.KotlinBuiltIns;
import kotlin.reflect.jvm.internal.impl.c.a.b.b;
import kotlin.reflect.jvm.internal.impl.c.a.b.j;
import kotlin.reflect.jvm.internal.impl.c.a.f.s;

public class f
extends y
implements b {
    private final boolean e;

    private f(m m2, h h2, w w2, ba ba2, boolean bl2, kotlin.reflect.jvm.internal.impl.e.f f2, an an2, ai ai2, b.a a2, boolean bl3) {
        super(m2, ai2, h2, w2, ba2, bl2, f2, a2, an2, false, false, false, false, false, false);
        this.e = bl3;
    }

    public static f a(m m2, h h2, w w2, ba ba2, boolean bl2, kotlin.reflect.jvm.internal.impl.e.f f2, an an2, boolean bl3) {
        return new f(m2, h2, w2, ba2, bl2, f2, an2, null, b.a.a, bl3);
    }

    @Override
    protected y a(m m2, w w2, ba ba2, ai ai2, b.a a2, kotlin.reflect.jvm.internal.impl.e.f f2) {
        return new f(m2, this.x(), w2, ba2, this.s(), f2, an.a, ai2, a2, this.e);
    }

    @Override
    public b a(kotlin.reflect.jvm.internal.impl.j.w w2, List<j> list, kotlin.reflect.jvm.internal.impl.j.w w3) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: fail exe a15 = a6\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:92)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.dfs(Cfg.java:255)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze0(BaseAnalyze.java:75)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.analyze(BaseAnalyze.java:69)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer.transform(UnSSATransformer.java:274)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:163)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\nCaused by: java.lang.NullPointerException\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:552)\r\n\tat com.googlecode.dex2jar.ir.ts.UnSSATransformer$LiveA.onUseLocal(UnSSATransformer.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:166)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.onUse(BaseAnalyze.java:1)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:331)\r\n\tat com.googlecode.dex2jar.ir.ts.Cfg.travel(Cfg.java:387)\r\n\tat com.googlecode.dex2jar.ir.ts.an.BaseAnalyze.exec(BaseAnalyze.java:90)\r\n\t... 17 more\r\n");
        throw runtimeException;
    }

    @Override
    public boolean j() {
        return false;
    }

    @Override
    public boolean z() {
        kotlin.reflect.jvm.internal.impl.j.w w2 = this.r();
        return this.e && kotlin.reflect.jvm.internal.impl.a.j.a(w2) && (!s.a(w2) || KotlinBuiltIns.isString(w2));
    }
}

