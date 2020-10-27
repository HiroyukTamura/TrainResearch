package com.google.firebase.installations;

import java.util.concurrent.Callable;

final /* synthetic */ class FirebaseInstallations$$Lambda$2 implements Callable {
    private final FirebaseInstallations arg$1;

    private FirebaseInstallations$$Lambda$2(FirebaseInstallations firebaseInstallations) {
        this.arg$1 = firebaseInstallations;
    }

    public static Callable lambdaFactory$(FirebaseInstallations firebaseInstallations) {
        return new FirebaseInstallations$$Lambda$2(firebaseInstallations);
    }

    public Object call() {
        return this.arg$1.deleteFirebaseInstallationId();
    }
}
