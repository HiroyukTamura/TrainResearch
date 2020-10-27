package p048l.p049a;

import android.os.Build;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p009e.p010a.p011a.p012a.C0681a;

/* renamed from: l.a.a */
public final class C1122a {

    /* renamed from: a */
    private static final C1125c[] f926a = new C1125c[0];

    /* renamed from: b */
    private static final List<C1125c> f927b = new ArrayList();

    /* renamed from: c */
    static volatile C1125c[] f928c = f926a;

    /* renamed from: d */
    private static final C1125c f929d = new C1123a();

    /* renamed from: l.a.a$a */
    static class C1123a extends C1125c {
        C1123a() {
        }

        /* renamed from: d */
        public void mo21875d(String str, Object... objArr) {
            for (C1125c d : C1122a.f928c) {
                d.mo21875d(str, objArr);
            }
        }

        /* renamed from: d */
        public void mo21876d(Throwable th) {
            for (C1125c d : C1122a.f928c) {
                d.mo21876d(th);
            }
        }

        /* renamed from: d */
        public void mo21877d(Throwable th, String str, Object... objArr) {
            for (C1125c d : C1122a.f928c) {
                d.mo21877d(th, str, objArr);
            }
        }

        /* renamed from: e */
        public void mo21878e(String str, Object... objArr) {
            for (C1125c e : C1122a.f928c) {
                e.mo21878e(str, objArr);
            }
        }

        /* renamed from: e */
        public void mo21879e(Throwable th) {
            for (C1125c e : C1122a.f928c) {
                e.mo21879e(th);
            }
        }

        /* renamed from: e */
        public void mo21880e(Throwable th, String str, Object... objArr) {
            for (C1125c e : C1122a.f928c) {
                e.mo21880e(th, str, objArr);
            }
        }

        /* renamed from: i */
        public void mo21881i(String str, Object... objArr) {
            for (C1125c i : C1122a.f928c) {
                i.mo21881i(str, objArr);
            }
        }

        /* renamed from: i */
        public void mo21882i(Throwable th) {
            for (C1125c i : C1122a.f928c) {
                i.mo21882i(th);
            }
        }

        /* renamed from: i */
        public void mo21883i(Throwable th, String str, Object... objArr) {
            for (C1125c i : C1122a.f928c) {
                i.mo21883i(th, str, objArr);
            }
        }

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            throw new AssertionError("Missing override for log method.");
        }

        public void log(int i, String str, Object... objArr) {
            for (C1125c log : C1122a.f928c) {
                log.log(i, str, objArr);
            }
        }

        public void log(int i, Throwable th) {
            for (C1125c log : C1122a.f928c) {
                log.log(i, th);
            }
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            for (C1125c log : C1122a.f928c) {
                log.log(i, th, str, objArr);
            }
        }

        /* renamed from: v */
        public void mo21888v(String str, Object... objArr) {
            for (C1125c v : C1122a.f928c) {
                v.mo21888v(str, objArr);
            }
        }

        /* renamed from: v */
        public void mo21889v(Throwable th) {
            for (C1125c v : C1122a.f928c) {
                v.mo21889v(th);
            }
        }

        /* renamed from: v */
        public void mo21890v(Throwable th, String str, Object... objArr) {
            for (C1125c v : C1122a.f928c) {
                v.mo21890v(th, str, objArr);
            }
        }

        /* renamed from: w */
        public void mo21891w(String str, Object... objArr) {
            for (C1125c w : C1122a.f928c) {
                w.mo21891w(str, objArr);
            }
        }

        /* renamed from: w */
        public void mo21892w(Throwable th) {
            for (C1125c w : C1122a.f928c) {
                w.mo21892w(th);
            }
        }

        /* renamed from: w */
        public void mo21893w(Throwable th, String str, Object... objArr) {
            for (C1125c w : C1122a.f928c) {
                w.mo21893w(th, str, objArr);
            }
        }

        public void wtf(String str, Object... objArr) {
            for (C1125c wtf : C1122a.f928c) {
                wtf.wtf(str, objArr);
            }
        }

        public void wtf(Throwable th) {
            for (C1125c wtf : C1122a.f928c) {
                wtf.wtf(th);
            }
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            for (C1125c wtf : C1122a.f928c) {
                wtf.wtf(th, str, objArr);
            }
        }
    }

    /* renamed from: l.a.a$b */
    public static class C1124b extends C1125c {
        private static final Pattern ANONYMOUS_CLASS = Pattern.compile("(\\$\\d+)+$");
        private static final int CALL_STACK_INDEX = 5;
        private static final int MAX_LOG_LENGTH = 4000;
        private static final int MAX_TAG_LENGTH = 23;

        /* access modifiers changed from: protected */
        public String createStackElementTag(StackTraceElement stackTraceElement) {
            String className = stackTraceElement.getClassName();
            Matcher matcher = ANONYMOUS_CLASS.matcher(className);
            if (matcher.find()) {
                className = matcher.replaceAll("");
            }
            String substring = className.substring(className.lastIndexOf(46) + 1);
            return (substring.length() <= 23 || Build.VERSION.SDK_INT >= 24) ? substring : substring.substring(0, 23);
        }

        /* access modifiers changed from: package-private */
        public final String getTag() {
            String tag = super.getTag();
            if (tag != null) {
                return tag;
            }
            StackTraceElement[] stackTrace = new Throwable().getStackTrace();
            if (stackTrace.length > 5) {
                return createStackElementTag(stackTrace[5]);
            }
            throw new IllegalStateException("Synthetic stacktrace didn't have enough elements: are you using proguard?");
        }

        /* access modifiers changed from: protected */
        public void log(int i, String str, String str2, Throwable th) {
            throw null;
        }
    }

    /* renamed from: l.a.a$c */
    public static abstract class C1125c {
        final ThreadLocal<String> explicitTag = new ThreadLocal<>();

        private String getStackTraceString(Throwable th) {
            StringWriter stringWriter = new StringWriter(256);
            PrintWriter printWriter = new PrintWriter(stringWriter, false);
            th.printStackTrace(printWriter);
            printWriter.flush();
            return stringWriter.toString();
        }

        private void prepareLog(int i, Throwable th, String str, Object... objArr) {
            String tag = getTag();
            if (isLoggable(tag, i)) {
                if (str != null && str.length() == 0) {
                    str = null;
                }
                if (str != null) {
                    if (objArr != null && objArr.length > 0) {
                        str = formatMessage(str, objArr);
                    }
                    if (th != null) {
                        StringBuilder c = C0681a.m340c(str, "\n");
                        c.append(getStackTraceString(th));
                        str = c.toString();
                    }
                } else if (th != null) {
                    str = getStackTraceString(th);
                } else {
                    return;
                }
                log(i, tag, str, th);
            }
        }

        /* renamed from: d */
        public void mo21875d(String str, Object... objArr) {
            prepareLog(3, (Throwable) null, str, objArr);
        }

        /* renamed from: d */
        public void mo21876d(Throwable th) {
            prepareLog(3, th, (String) null, new Object[0]);
        }

        /* renamed from: d */
        public void mo21877d(Throwable th, String str, Object... objArr) {
            prepareLog(3, th, str, objArr);
        }

        /* renamed from: e */
        public void mo21878e(String str, Object... objArr) {
            prepareLog(6, (Throwable) null, str, objArr);
        }

        /* renamed from: e */
        public void mo21879e(Throwable th) {
            prepareLog(6, th, (String) null, new Object[0]);
        }

        /* renamed from: e */
        public void mo21880e(Throwable th, String str, Object... objArr) {
            prepareLog(6, th, str, objArr);
        }

        /* access modifiers changed from: protected */
        public String formatMessage(String str, Object[] objArr) {
            return String.format(str, objArr);
        }

        /* access modifiers changed from: package-private */
        public String getTag() {
            String str = this.explicitTag.get();
            if (str != null) {
                this.explicitTag.remove();
            }
            return str;
        }

        /* renamed from: i */
        public void mo21881i(String str, Object... objArr) {
            prepareLog(4, (Throwable) null, str, objArr);
        }

        /* renamed from: i */
        public void mo21882i(Throwable th) {
            prepareLog(4, th, (String) null, new Object[0]);
        }

        /* renamed from: i */
        public void mo21883i(Throwable th, String str, Object... objArr) {
            prepareLog(4, th, str, objArr);
        }

        /* access modifiers changed from: protected */
        @Deprecated
        public boolean isLoggable(int i) {
            return true;
        }

        /* access modifiers changed from: protected */
        public boolean isLoggable(String str, int i) {
            return isLoggable(i);
        }

        /* access modifiers changed from: protected */
        public abstract void log(int i, String str, String str2, Throwable th);

        public void log(int i, String str, Object... objArr) {
            prepareLog(i, (Throwable) null, str, objArr);
        }

        public void log(int i, Throwable th) {
            prepareLog(i, th, (String) null, new Object[0]);
        }

        public void log(int i, Throwable th, String str, Object... objArr) {
            prepareLog(i, th, str, objArr);
        }

        /* renamed from: v */
        public void mo21888v(String str, Object... objArr) {
            prepareLog(2, (Throwable) null, str, objArr);
        }

        /* renamed from: v */
        public void mo21889v(Throwable th) {
            prepareLog(2, th, (String) null, new Object[0]);
        }

        /* renamed from: v */
        public void mo21890v(Throwable th, String str, Object... objArr) {
            prepareLog(2, th, str, objArr);
        }

        /* renamed from: w */
        public void mo21891w(String str, Object... objArr) {
            prepareLog(5, (Throwable) null, str, objArr);
        }

        /* renamed from: w */
        public void mo21892w(Throwable th) {
            prepareLog(5, th, (String) null, new Object[0]);
        }

        /* renamed from: w */
        public void mo21893w(Throwable th, String str, Object... objArr) {
            prepareLog(5, th, str, objArr);
        }

        public void wtf(String str, Object... objArr) {
            prepareLog(7, (Throwable) null, str, objArr);
        }

        public void wtf(Throwable th) {
            prepareLog(7, th, (String) null, new Object[0]);
        }

        public void wtf(Throwable th, String str, Object... objArr) {
            prepareLog(7, th, str, objArr);
        }
    }

    /* renamed from: a */
    public static C1125c m1595a(String str) {
        for (C1125c cVar : f928c) {
            cVar.explicitTag.set(str);
        }
        return f929d;
    }

    /* renamed from: a */
    public static void m1596a(String str, Object... objArr) {
        f929d.mo21875d(str, objArr);
    }

    /* renamed from: a */
    public static void m1597a(Throwable th) {
        f929d.mo21879e(th);
    }

    /* renamed from: a */
    public static void m1598a(C1125c cVar) {
        if (cVar == null) {
            throw new NullPointerException("tree == null");
        } else if (cVar != f929d) {
            synchronized (f927b) {
                f927b.add(cVar);
                f928c = (C1125c[]) f927b.toArray(new C1125c[f927b.size()]);
            }
        } else {
            throw new IllegalArgumentException("Cannot plant Timber into itself.");
        }
    }

    /* renamed from: b */
    public static void m1599b(String str, Object... objArr) {
        f929d.mo21878e(str, objArr);
    }

    /* renamed from: c */
    public static void m1600c(String str, Object... objArr) {
        f929d.mo21881i(str, objArr);
    }

    /* renamed from: d */
    public static void m1601d(String str, Object... objArr) {
        f929d.mo21891w(str, objArr);
    }
}
