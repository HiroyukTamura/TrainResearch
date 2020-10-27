package p040i;

import java.io.IOException;
import kotlin.Metadata;
import p042j.C2057A;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001:\u0001\u0011J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0000H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u000bH&J\b\u0010\r\u001a\u00020\u000eH&J\b\u0010\u000f\u001a\u00020\u0010H&¨\u0006\u0012"}, mo21739d2 = {"Lokhttp3/Call;", "", "cancel", "", "clone", "enqueue", "responseCallback", "Lokhttp3/Callback;", "execute", "Lokhttp3/Response;", "isCanceled", "", "isExecuted", "request", "Lokhttp3/Request;", "timeout", "Lokio/Timeout;", "Factory", "okhttp"}, mo21740k = 1, mo21741mv = {1, 1, 16})
/* renamed from: i.f */
public interface C1923f extends Cloneable {

    /* renamed from: i.f$a */
    public interface C1924a {
        /* renamed from: a */
        C1923f mo27469a(C1755F f);
    }

    /* renamed from: a */
    void mo27715a(C1925g gVar);

    void cancel();

    C1758I execute() throws IOException;

    boolean isCanceled();

    C1755F request();

    C2057A timeout();
}
