package p009e.p028d.p030b.p054b.p055c;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.util.Log;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import androidx.collection.SimpleArrayMap;
import java.util.ArrayList;
import java.util.List;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: e.d.b.b.c.g */
public class C1540g {

    /* renamed from: a */
    private final SimpleArrayMap<String, C1541h> f1781a = new SimpleArrayMap<>();

    @Nullable
    /* renamed from: a */
    public static C1540g m2152a(Context context, @AnimatorRes int i) {
        try {
            Animator loadAnimator = AnimatorInflater.loadAnimator(context, i);
            if (loadAnimator instanceof AnimatorSet) {
                return m2153a((List<Animator>) ((AnimatorSet) loadAnimator).getChildAnimations());
            }
            if (loadAnimator == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(loadAnimator);
            return m2153a((List<Animator>) arrayList);
        } catch (Exception e) {
            StringBuilder a = C0681a.m330a("Can't load animation resource ID #0x");
            a.append(Integer.toHexString(i));
            Log.w("MotionSpec", a.toString(), e);
            return null;
        }
    }

    /* renamed from: a */
    private static C1540g m2153a(List<Animator> list) {
        C1540g gVar = new C1540g();
        int size = list.size();
        int i = 0;
        while (i < size) {
            Animator animator = list.get(i);
            if (animator instanceof ObjectAnimator) {
                ObjectAnimator objectAnimator = (ObjectAnimator) animator;
                gVar.f1781a.put(objectAnimator.getPropertyName(), C1541h.m2156a((ValueAnimator) objectAnimator));
                i++;
            } else {
                throw new IllegalArgumentException("Animator must be an ObjectAnimator: " + animator);
            }
        }
        return gVar;
    }

    /* renamed from: a */
    public long mo27298a() {
        int size = this.f1781a.size();
        long j = 0;
        for (int i = 0; i < size; i++) {
            C1541h valueAt = this.f1781a.valueAt(i);
            j = Math.max(j, valueAt.mo27305b() + valueAt.mo27303a());
        }
        return j;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C1540g.class != obj.getClass()) {
            return false;
        }
        return this.f1781a.equals(((C1540g) obj).f1781a);
    }

    public int hashCode() {
        return this.f1781a.hashCode();
    }

    public String toString() {
        StringBuilder a = C0681a.m329a(10);
        a.append(C1540g.class.getName());
        a.append('{');
        a.append(Integer.toHexString(System.identityHashCode(this)));
        a.append(" timings: ");
        a.append(this.f1781a);
        a.append("}\n");
        return a.toString();
    }

    /* renamed from: a */
    public C1541h mo27299a(String str) {
        if (this.f1781a.get(str) != null) {
            return this.f1781a.get(str);
        }
        throw new IllegalArgumentException();
    }
}
