/*
 * Decompiled with CFR 0.139.
 */
package kotlin.reflect.jvm.internal.impl.f;

import java.io.IOException;
import java.io.InputStream;
import kotlin.reflect.jvm.internal.impl.f.a;
import kotlin.reflect.jvm.internal.impl.f.d;
import kotlin.reflect.jvm.internal.impl.f.e;
import kotlin.reflect.jvm.internal.impl.f.g;
import kotlin.reflect.jvm.internal.impl.f.k;
import kotlin.reflect.jvm.internal.impl.f.q;
import kotlin.reflect.jvm.internal.impl.f.s;
import kotlin.reflect.jvm.internal.impl.f.w;

public abstract class b<MessageType extends q>
implements s<MessageType> {
    private static final g a = g.b();

    private w a(MessageType MessageType) {
        if (MessageType instanceof a) {
            return ((a)MessageType).N();
        }
        return new w((q)MessageType);
    }

    private MessageType b(MessageType MessageType) {
        if (MessageType != null) {
            if (MessageType.h()) {
                return MessageType;
            }
            throw this.a(MessageType).a().a((q)MessageType);
        }
        return MessageType;
    }

    public MessageType a(InputStream inputStream) {
        return this.b(inputStream, a);
    }

    public MessageType a(InputStream object, g object2) {
        object = e.a((InputStream)object);
        object2 = (q)this.b((e)object, (g)object2);
        try {
            ((e)object).a(0);
        }
        catch (k k2) {
            throw k2.a((q)object2);
        }
        return (MessageType)object2;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Lifted jumps to return sites
     */
    public MessageType a(d object, g object2) {
        object = ((d)object).h();
        object2 = (q)this.b((e)object, (g)object2);
        {
            catch (k k2) {
                throw k2;
            }
        }
        try {
            ((e)object).a(0);
        }
        catch (k k3) {
            throw k3.a((q)object2);
        }
        return (MessageType)object2;
    }

    @Override
    public /* synthetic */ Object b(InputStream inputStream) {
        return this.a(inputStream);
    }

    public MessageType b(InputStream inputStream, g g2) {
        return this.b(this.a(inputStream, g2));
    }

    public MessageType b(d d2, g g2) {
        return this.b(this.a(d2, g2));
    }

    @Override
    public /* synthetic */ Object c(d d2, g g2) {
        return this.b(d2, g2);
    }

    public MessageType c(InputStream inputStream, g g2) {
        int n2;
        block3 : {
            try {
                n2 = inputStream.read();
                if (n2 != -1) break block3;
            }
            catch (IOException iOException) {
                throw new k(iOException.getMessage());
            }
            return null;
        }
        n2 = e.a(n2, inputStream);
        return this.a(new a.a.a(inputStream, n2), g2);
    }

    public MessageType d(InputStream inputStream, g g2) {
        return this.b(this.c(inputStream, g2));
    }

    @Override
    public /* synthetic */ Object e(InputStream inputStream, g g2) {
        return this.d(inputStream, g2);
    }

    @Override
    public /* synthetic */ Object f(InputStream inputStream, g g2) {
        return this.b(inputStream, g2);
    }
}

