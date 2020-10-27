package org.greenrobot.eventbus;

import java.io.PrintStream;
import java.util.logging.Level;

/* renamed from: org.greenrobot.eventbus.g */
public interface C2617g {

    /* renamed from: org.greenrobot.eventbus.g$a */
    public static class C2618a implements C2617g {
        /* renamed from: a */
        public void mo35643a(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }

        /* renamed from: a */
        public void mo35644a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }
    }

    /* renamed from: a */
    void mo35643a(Level level, String str);

    /* renamed from: a */
    void mo35644a(Level level, String str, Throwable th);
}
