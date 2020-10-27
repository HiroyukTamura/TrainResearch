package org.greenrobot.eventbus.p131r;

import android.util.Log;
import java.util.logging.Level;
import org.greenrobot.eventbus.C2617g;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: org.greenrobot.eventbus.r.a */
public class C2630a implements C2617g {

    /* renamed from: b */
    private static final boolean f4343b;

    /* renamed from: a */
    private final String f4344a;

    static {
        boolean z;
        try {
            Class.forName("android.util.Log");
            z = true;
        } catch (ClassNotFoundException unused) {
            z = false;
        }
        f4343b = z;
    }

    public C2630a(String str) {
        this.f4344a = str;
    }

    /* renamed from: a */
    private int m4585a(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        }
        if (intValue < 900) {
            return 4;
        }
        return intValue < 1000 ? 5 : 6;
    }

    /* renamed from: a */
    public static boolean m4586a() {
        return f4343b;
    }

    /* renamed from: a */
    public void mo35643a(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(m4585a(level), this.f4344a, str);
        }
    }

    /* renamed from: a */
    public void mo35644a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int a = m4585a(level);
            String str2 = this.f4344a;
            StringBuilder c = C0681a.m340c(str, "\n");
            c.append(Log.getStackTraceString(th));
            Log.println(a, str2, c.toString());
        }
    }
}
