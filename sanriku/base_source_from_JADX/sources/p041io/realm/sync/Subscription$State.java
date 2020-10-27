package p041io.realm.sync;

/* renamed from: io.realm.sync.Subscription$State */
public enum Subscription$State {
    ERROR((byte) -1),
    PENDING((byte) 0),
    ACTIVE((byte) 1),
    INVALIDATED((String) null);
    
    private final Byte nativeValue;

    private Subscription$State(Byte b) {
        this.nativeValue = b;
    }

    public Byte getValue() {
        return this.nativeValue;
    }
}
