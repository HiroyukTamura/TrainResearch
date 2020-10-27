package retrofit2;

import java.io.IOException;
import p040i.C1755F;
import p042j.C2057A;

public interface Call<T> extends Cloneable {
    void cancel();

    Call<T> clone();

    void enqueue(Callback<T> callback);

    Response<T> execute() throws IOException;

    boolean isCanceled();

    boolean isExecuted();

    C1755F request();

    C2057A timeout();
}
