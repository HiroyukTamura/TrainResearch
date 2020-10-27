package com.google.firebase.installations;

final /* synthetic */ class FirebaseInstallations$$Lambda$1 implements Runnable {
    private final FirebaseInstallations arg$1;
    private final boolean arg$2;

    private FirebaseInstallations$$Lambda$1(FirebaseInstallations firebaseInstallations, boolean z) {
        this.arg$1 = firebaseInstallations;
        this.arg$2 = z;
    }

    public static Runnable lambdaFactory$(FirebaseInstallations firebaseInstallations, boolean z) {
        return new FirebaseInstallations$$Lambda$1(firebaseInstallations, z);
    }

    public void run() {
        this.arg$1.doGetAuthToken(this.arg$2);
    }
}
