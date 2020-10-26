/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 *  android.util.Log
 *  android.util.SparseArray
 */
package androidx.f.a;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.f.a.a;
import androidx.f.a.d;
import androidx.f.a.j;
import java.util.ArrayList;

final class b
implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>(){

        public b a(Parcel parcel) {
            return new b(parcel);
        }

        public b[] a(int n2) {
            return new b[n2];
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return this.a(parcel);
        }

        public /* synthetic */ Object[] newArray(int n2) {
            return this.a(n2);
        }
    };
    final int[] a;
    final int b;
    final int c;
    final String d;
    final int e;
    final int f;
    final CharSequence g;
    final int h;
    final CharSequence i;
    final ArrayList<String> j;
    final ArrayList<String> k;
    final boolean l;

    public b(Parcel parcel) {
        this.a = parcel.createIntArray();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readString();
        this.e = parcel.readInt();
        this.f = parcel.readInt();
        this.g = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.h = parcel.readInt();
        this.i = (CharSequence)TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.j = parcel.createStringArrayList();
        this.k = parcel.createStringArrayList();
        boolean bl2 = parcel.readInt() != 0;
        this.l = bl2;
    }

    public b(a a2) {
        int n2 = a2.b.size();
        this.a = new int[n2 * 6];
        if (a2.i) {
            int n3 = 0;
            int n4 = 0;
            while (n3 < n2) {
                a.a a3 = a2.b.get(n3);
                int[] arrn = this.a;
                int n5 = n4 + 1;
                arrn[n4] = a3.a;
                arrn = this.a;
                int n6 = n5 + 1;
                n4 = a3.b != null ? a3.b.o : -1;
                arrn[n5] = n4;
                arrn = this.a;
                n4 = n6 + 1;
                arrn[n6] = a3.c;
                arrn = this.a;
                n5 = n4 + 1;
                arrn[n4] = a3.d;
                arrn = this.a;
                n4 = n5 + 1;
                arrn[n5] = a3.e;
                this.a[n4] = a3.f;
                ++n3;
                ++n4;
            }
            this.b = a2.g;
            this.c = a2.h;
            this.d = a2.k;
            this.e = a2.m;
            this.f = a2.n;
            this.g = a2.o;
            this.h = a2.p;
            this.i = a2.q;
            this.j = a2.r;
            this.k = a2.s;
            this.l = a2.t;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    /*
     * Enabled aggressive block sorting
     */
    public a a(j j2) {
        a a2 = new a(j2);
        int n2 = 0;
        int n3 = 0;
        do {
            if (n2 >= this.a.length) {
                a2.g = this.b;
                a2.h = this.c;
                a2.k = this.d;
                a2.m = this.e;
                a2.i = true;
                a2.n = this.f;
                a2.o = this.g;
                a2.p = this.h;
                a2.q = this.i;
                a2.r = this.j;
                a2.s = this.k;
                a2.t = this.l;
                a2.a(1);
                return a2;
            }
            a.a a3 = new a.a();
            Object object = this.a;
            Object object2 = n2 + 1;
            a3.a = object[n2];
            if (j.a) {
                object = new StringBuilder();
                ((StringBuilder)object).append("Instantiate ");
                ((StringBuilder)object).append(a2);
                ((StringBuilder)object).append(" op #");
                ((StringBuilder)object).append(n3);
                ((StringBuilder)object).append(" base fragment #");
                ((StringBuilder)object).append(this.a[object2]);
                Log.v((String)"FragmentManager", (String)((StringBuilder)object).toString());
            }
            object = this.a;
            n2 = object2 + 1;
            object = (object2 = (Object)object[object2]) >= 0 ? (d)j2.f.get(object2) : null;
            a3.b = object;
            object = this.a;
            object2 = n2 + 1;
            a3.c = (int)object[n2];
            object = this.a;
            n2 = object2 + 1;
            a3.d = (int)object[object2];
            object = this.a;
            object2 = n2 + 1;
            a3.e = (int)object[n2];
            a3.f = this.a[object2];
            a2.c = a3.c;
            a2.d = a3.d;
            a2.e = a3.e;
            a2.f = a3.f;
            a2.a(a3);
            ++n3;
            n2 = object2 + 1;
        } while (true);
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

