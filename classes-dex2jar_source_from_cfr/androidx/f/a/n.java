/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.util.Log
 */
package androidx.f.a;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.f.a.d;
import androidx.f.a.f;
import androidx.f.a.h;
import androidx.f.a.j;
import androidx.f.a.k;
import androidx.lifecycle.y;

final class n
implements Parcelable {
    public static final Parcelable.Creator<n> CREATOR = new Parcelable.Creator<n>(){

        public n a(Parcel parcel) {
            return new n(parcel);
        }

        public n[] a(int n2) {
            return new n[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    final String a;
    final int b;
    final boolean c;
    final int d;
    final int e;
    final String f;
    final boolean g;
    final boolean h;
    final Bundle i;
    final boolean j;
    Bundle k;
    d l;

    n(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        int n2 = parcel.readInt();
        boolean bl2 = false;
        boolean bl3 = n2 != 0;
        this.c = bl3;
        this.d = parcel.readInt();
        this.e = parcel.readInt();
        this.f = parcel.readString();
        bl3 = parcel.readInt() != 0;
        this.g = bl3;
        bl3 = parcel.readInt() != 0;
        this.h = bl3;
        this.i = parcel.readBundle();
        bl3 = bl2;
        if (parcel.readInt() != 0) {
            bl3 = true;
        }
        this.j = bl3;
        this.k = parcel.readBundle();
    }

    n(d d2) {
        this.a = d2.getClass().getName();
        this.b = d2.o;
        this.c = d2.w;
        this.d = d2.H;
        this.e = d2.I;
        this.f = d2.J;
        this.g = d2.M;
        this.h = d2.L;
        this.i = d2.q;
        this.j = d2.K;
    }

    /*
     * Enabled aggressive block sorting
     */
    public d a(h object, f object2, d d2, k k2, y y2) {
        if (this.l == null) {
            Context context = ((h)object).g();
            if (this.i != null) {
                this.i.setClassLoader(context.getClassLoader());
            }
            object2 = object2 != null ? ((f)object2).a(context, this.a, this.i) : d.a(context, this.a, this.i);
            this.l = object2;
            if (this.k != null) {
                this.k.setClassLoader(context.getClassLoader());
                this.l.l = this.k;
            }
            this.l.a(this.b, d2);
            this.l.w = this.c;
            this.l.y = true;
            this.l.H = this.d;
            this.l.I = this.e;
            this.l.J = this.f;
            this.l.M = this.g;
            this.l.L = this.h;
            this.l.K = this.j;
            this.l.B = ((h)object).b;
            if (j.a) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Instantiated fragment ");
                ((StringBuilder)object).append(this.l);
                Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
            }
        }
        this.l.E = k2;
        this.l.F = y2;
        return this.l;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int n2) {
        RuntimeException runtimeException;
        super("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e1expr(TypeTransformer.java:496)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:713)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:698)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
        throw runtimeException;
    }

}

