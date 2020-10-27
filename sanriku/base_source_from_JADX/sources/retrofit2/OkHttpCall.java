package retrofit2;

import java.io.IOException;
import java.util.Objects;
import kotlin.jvm.internal.Intrinsics;
import p040i.C0980J;
import p040i.C1746B;
import p040i.C1755F;
import p040i.C1758I;
import p040i.C1923f;
import p040i.C1925g;
import p042j.C1015k;
import p042j.C2057A;
import p042j.C2068f;
import p042j.C2072h;
import p042j.C2085t;

final class OkHttpCall<T> implements Call<T> {
    private final Object[] args;
    private final C1923f.C1924a callFactory;
    private volatile boolean canceled;
    private Throwable creationFailure;
    private boolean executed;
    private C1923f rawCall;
    private final RequestFactory requestFactory;
    private final Converter<C0980J, T> responseConverter;

    static final class ExceptionCatchingResponseBody extends C0980J {
        private final C0980J delegate;
        private final C2072h delegateSource;
        IOException thrownException;

        ExceptionCatchingResponseBody(C0980J j) {
            this.delegate = j;
            C26441 r0 = new C1015k(j.source()) {
                public long read(C2068f fVar, long j) throws IOException {
                    try {
                        return super.read(fVar, j);
                    } catch (IOException e) {
                        ExceptionCatchingResponseBody.this.thrownException = e;
                        throw e;
                    }
                }
            };
            Intrinsics.checkParameterIsNotNull(r0, "$this$buffer");
            this.delegateSource = new C2085t(r0);
        }

        public void close() {
            this.delegate.close();
        }

        public long contentLength() {
            return this.delegate.contentLength();
        }

        public C1746B contentType() {
            return this.delegate.contentType();
        }

        public C2072h source() {
            return this.delegateSource;
        }

        /* access modifiers changed from: package-private */
        public void throwIfCaught() throws IOException {
            IOException iOException = this.thrownException;
            if (iOException != null) {
                throw iOException;
            }
        }
    }

    static final class NoContentResponseBody extends C0980J {
        private final long contentLength;
        private final C1746B contentType;

        NoContentResponseBody(C1746B b, long j) {
            this.contentType = b;
            this.contentLength = j;
        }

        public long contentLength() {
            return this.contentLength;
        }

        public C1746B contentType() {
            return this.contentType;
        }

        public C2072h source() {
            throw new IllegalStateException("Cannot read raw response body of a converted body.");
        }
    }

    OkHttpCall(RequestFactory requestFactory2, Object[] objArr, C1923f.C1924a aVar, Converter<C0980J, T> converter) {
        this.requestFactory = requestFactory2;
        this.args = objArr;
        this.callFactory = aVar;
        this.responseConverter = converter;
    }

    private C1923f createRawCall() throws IOException {
        C1923f a = this.callFactory.mo27469a(this.requestFactory.create(this.args));
        if (a != null) {
            return a;
        }
        throw new NullPointerException("Call.Factory returned null.");
    }

    private C1923f getRawCall() throws IOException {
        C1923f fVar = this.rawCall;
        if (fVar != null) {
            return fVar;
        }
        Throwable th = this.creationFailure;
        if (th == null) {
            try {
                C1923f createRawCall = createRawCall();
                this.rawCall = createRawCall;
                return createRawCall;
            } catch (IOException | Error | RuntimeException e) {
                Utils.throwIfFatal(e);
                this.creationFailure = e;
                throw e;
            }
        } else if (th instanceof IOException) {
            throw ((IOException) th);
        } else if (th instanceof RuntimeException) {
            throw ((RuntimeException) th);
        } else {
            throw ((Error) th);
        }
    }

    public void cancel() {
        C1923f fVar;
        this.canceled = true;
        synchronized (this) {
            fVar = this.rawCall;
        }
        if (fVar != null) {
            fVar.cancel();
        }
    }

    public OkHttpCall<T> clone() {
        return new OkHttpCall<>(this.requestFactory, this.args, this.callFactory, this.responseConverter);
    }

    public void enqueue(final Callback<T> callback) {
        C1923f fVar;
        Throwable th;
        Objects.requireNonNull(callback, "callback == null");
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                fVar = this.rawCall;
                th = this.creationFailure;
                if (fVar == null && th == null) {
                    try {
                        C1923f createRawCall = createRawCall();
                        this.rawCall = createRawCall;
                        fVar = createRawCall;
                    } catch (Throwable th2) {
                        th = th2;
                        Utils.throwIfFatal(th);
                        this.creationFailure = th;
                    }
                }
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (th != null) {
            callback.onFailure(this, th);
            return;
        }
        if (this.canceled) {
            fVar.cancel();
        }
        fVar.mo27715a(new C1925g() {
            private void callFailure(Throwable th) {
                try {
                    callback.onFailure(OkHttpCall.this, th);
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    th2.printStackTrace();
                }
            }

            public void onFailure(C1923f fVar, IOException iOException) {
                callFailure(iOException);
            }

            public void onResponse(C1923f fVar, C1758I i) {
                try {
                    try {
                        callback.onResponse(OkHttpCall.this, OkHttpCall.this.parseResponse(i));
                    } catch (Throwable th) {
                        Utils.throwIfFatal(th);
                        th.printStackTrace();
                    }
                } catch (Throwable th2) {
                    Utils.throwIfFatal(th2);
                    callFailure(th2);
                }
            }
        });
    }

    public Response<T> execute() throws IOException {
        C1923f rawCall2;
        synchronized (this) {
            if (!this.executed) {
                this.executed = true;
                rawCall2 = getRawCall();
            } else {
                throw new IllegalStateException("Already executed.");
            }
        }
        if (this.canceled) {
            rawCall2.cancel();
        }
        return parseResponse(rawCall2.execute());
    }

    public boolean isCanceled() {
        boolean z = true;
        if (this.canceled) {
            return true;
        }
        synchronized (this) {
            if (this.rawCall == null || !this.rawCall.isCanceled()) {
                z = false;
            }
        }
        return z;
    }

    public synchronized boolean isExecuted() {
        return this.executed;
    }

    /* access modifiers changed from: package-private */
    public Response<T> parseResponse(C1758I i) throws IOException {
        C0980J d = i.mo27554d();
        C1758I.C1759a aVar = new C1758I.C1759a(i);
        aVar.mo27576a((C0980J) new NoContentResponseBody(d.contentType(), d.contentLength()));
        C1758I a = aVar.mo27581a();
        int o = a.mo27558o();
        if (o < 200 || o >= 300) {
            try {
                return Response.error(Utils.buffer(d), a);
            } finally {
                d.close();
            }
        } else if (o == 204 || o == 205) {
            d.close();
            return Response.success(null, a);
        } else {
            ExceptionCatchingResponseBody exceptionCatchingResponseBody = new ExceptionCatchingResponseBody(d);
            try {
                return Response.success(this.responseConverter.convert(exceptionCatchingResponseBody), a);
            } catch (RuntimeException e) {
                exceptionCatchingResponseBody.throwIfCaught();
                throw e;
            }
        }
    }

    public synchronized C1755F request() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create request.", e);
        }
        return getRawCall().request();
    }

    public synchronized C2057A timeout() {
        try {
        } catch (IOException e) {
            throw new RuntimeException("Unable to create call.", e);
        }
        return getRawCall().timeout();
    }
}
