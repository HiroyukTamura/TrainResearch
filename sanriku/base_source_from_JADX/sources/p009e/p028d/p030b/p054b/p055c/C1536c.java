package p009e.p028d.p030b.p054b.p055c;

import android.util.Property;
import android.view.ViewGroup;
import p043jp.reifrontier.sanriku.R;

/* renamed from: e.d.b.b.c.c */
public class C1536c extends Property<ViewGroup, Float> {

    /* renamed from: a */
    public static final Property<ViewGroup, Float> f1774a = new C1536c("childrenAlpha");

    private C1536c(String str) {
        super(Float.class, str);
    }

    public Object get(Object obj) {
        Float f = (Float) ((ViewGroup) obj).getTag(R.id.mtrl_internal_children_alpha_tag);
        return f != null ? f : Float.valueOf(1.0f);
    }

    public void set(Object obj, Object obj2) {
        ViewGroup viewGroup = (ViewGroup) obj;
        float floatValue = ((Float) obj2).floatValue();
        viewGroup.setTag(R.id.mtrl_internal_children_alpha_tag, Float.valueOf(floatValue));
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            viewGroup.getChildAt(i).setAlpha(floatValue);
        }
    }
}
