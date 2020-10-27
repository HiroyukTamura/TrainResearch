package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference0Impl extends MutablePropertyReference0 {
    private final String name;
    private final KDeclarationContainer owner;
    private final String signature;

    public MutablePropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.owner = kDeclarationContainer;
        this.name = str;
        this.signature = str2;
    }

    public Object get() {
        return getGetter().call(new Object[0]);
    }

    public String getName() {
        return this.name;
    }

    public KDeclarationContainer getOwner() {
        return this.owner;
    }

    public String getSignature() {
        return this.signature;
    }

    public void set(Object obj) {
        getSetter().call(obj);
    }
}
