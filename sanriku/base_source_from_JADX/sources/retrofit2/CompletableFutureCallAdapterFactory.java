package retrofit2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.concurrent.CompletableFuture;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import retrofit2.CallAdapter;

@IgnoreJRERequirement
final class CompletableFutureCallAdapterFactory extends CallAdapter.Factory {
    static final CallAdapter.Factory INSTANCE = new CompletableFutureCallAdapterFactory();

    @IgnoreJRERequirement
    private static final class BodyCallAdapter<R> implements CallAdapter<R, CompletableFuture<R>> {
        private final Type responseType;

        BodyCallAdapter(Type type) {
            this.responseType = type;
        }

        public CompletableFuture<R> adapt(Call<R> call) {
            final CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new Callback<R>() {
                public void onFailure(Call<R> call, Throwable th) {
                    callCancelCompletableFuture.completeExceptionally(th);
                }

                public void onResponse(Call<R> call, Response<R> response) {
                    if (response.isSuccessful()) {
                        callCancelCompletableFuture.complete(response.body());
                    } else {
                        callCancelCompletableFuture.completeExceptionally(new HttpException(response));
                    }
                }
            });
            return callCancelCompletableFuture;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    private static final class CallCancelCompletableFuture<T> extends CompletableFuture<T> {
        private final Call<?> call;

        CallCancelCompletableFuture(Call<?> call2) {
            this.call = call2;
        }

        public boolean cancel(boolean z) {
            if (z) {
                this.call.cancel();
            }
            return super.cancel(z);
        }
    }

    @IgnoreJRERequirement
    private static final class ResponseCallAdapter<R> implements CallAdapter<R, CompletableFuture<Response<R>>> {
        private final Type responseType;

        ResponseCallAdapter(Type type) {
            this.responseType = type;
        }

        public CompletableFuture<Response<R>> adapt(Call<R> call) {
            final CallCancelCompletableFuture callCancelCompletableFuture = new CallCancelCompletableFuture(call);
            call.enqueue(new Callback<R>() {
                public void onFailure(Call<R> call, Throwable th) {
                    callCancelCompletableFuture.completeExceptionally(th);
                }

                public void onResponse(Call<R> call, Response<R> response) {
                    callCancelCompletableFuture.complete(response);
                }
            });
            return callCancelCompletableFuture;
        }

        public Type responseType() {
            return this.responseType;
        }
    }

    CompletableFutureCallAdapterFactory() {
    }

    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        if (CallAdapter.Factory.getRawType(type) != CompletableFuture.class) {
            return null;
        }
        if (type instanceof ParameterizedType) {
            Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
            if (CallAdapter.Factory.getRawType(parameterUpperBound) != Response.class) {
                return new BodyCallAdapter(parameterUpperBound);
            }
            if (parameterUpperBound instanceof ParameterizedType) {
                return new ResponseCallAdapter(CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound));
            }
            throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
        }
        throw new IllegalStateException("CompletableFuture return type must be parameterized as CompletableFuture<Foo> or CompletableFuture<? extends Foo>");
    }
}
