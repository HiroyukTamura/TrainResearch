package p041io.realm.internal;

/* renamed from: io.realm.internal.Capabilities */
public interface Capabilities {
    boolean canDeliverNotification();

    void checkCanDeliverNotification(String str);

    boolean isMainThread();
}
