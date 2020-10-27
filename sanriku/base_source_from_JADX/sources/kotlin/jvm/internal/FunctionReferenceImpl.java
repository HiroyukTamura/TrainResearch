package kotlin.jvm.internal;

import kotlin.reflect.KDeclarationContainer;

public class FunctionReferenceImpl extends FunctionReference {
    private final String name;
    private final KDeclarationContainer owner;
    private final String signature;

    public FunctionReferenceImpl(int i, KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(i);
        this.owner = kDeclarationContainer;
        this.name = str;
        this.signature = str2;
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
}
