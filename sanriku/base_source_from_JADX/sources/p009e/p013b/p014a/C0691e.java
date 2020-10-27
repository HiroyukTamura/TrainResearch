package p009e.p013b.p014a;

import java.io.File;
import java.io.FilenameFilter;

/* renamed from: e.b.a.e */
class C0691e implements FilenameFilter {

    /* renamed from: a */
    final /* synthetic */ String f374a;

    C0691e(C0689d dVar, String str) {
        this.f374a = str;
    }

    public boolean accept(File file, String str) {
        return str.startsWith(this.f374a);
    }
}
