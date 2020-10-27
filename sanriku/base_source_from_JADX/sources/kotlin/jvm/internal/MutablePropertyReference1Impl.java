package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference1Impl extends MutablePropertyReference1 {
    private final String name;
    private final KDeclarationContainer owner;
    private final String signature;

    public MutablePropertyReference1Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        this.owner = kDeclarationContainer;
        this.name = str;
        this.signature = str2;
    }

    public Object get(Object obj) {
        return getGetter().call(obj);
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

    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }
}
