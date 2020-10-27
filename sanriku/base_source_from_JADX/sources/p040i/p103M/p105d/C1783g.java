package p040i.p103M.p105d;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p042j.C2068f;
import p042j.C2075j;
import p042j.C2090x;

/* renamed from: i.M.d.g */
public class C1783g extends C2075j {

    /* renamed from: b */
    private boolean f2295b;

    /* renamed from: c */
    private final Function1<IOException, Unit> f2296c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1783g(C2090x xVar, Function1<? super IOException, Unit> function1) {
        super(xVar);
        Intrinsics.checkParameterIsNotNull(xVar, "delegate");
        Intrinsics.checkParameterIsNotNull(function1, "onException");
        this.f2296c = function1;
    }

    /* renamed from: a */
    public void mo27647a(C2068f fVar, long j) {
        Intrinsics.checkParameterIsNotNull(fVar, FirebaseAnalytics.Param.SOURCE);
        if (this.f2295b) {
            fVar.skip(j);
            return;
        }
        try {
            super.mo27647a(fVar, j);
        } catch (IOException e) {
            this.f2295b = true;
            this.f2296c.invoke(e);
        }
    }

    public void close() {
        if (!this.f2295b) {
            try {
                super.close();
            } catch (IOException e) {
                this.f2295b = true;
                this.f2296c.invoke(e);
            }
        }
    }

    public void flush() {
        if (!this.f2295b) {
            try {
                super.flush();
            } catch (IOException e) {
                this.f2295b = true;
                this.f2296c.invoke(e);
            }
        }
    }
}
