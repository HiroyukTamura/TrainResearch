package com.google.firebase.datatransport;

import android.content.Context;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import p009e.p028d.p030b.p031a.p032i.C0909p;

final /* synthetic */ class TransportRegistrar$$Lambda$1 implements ComponentFactory {
    private static final TransportRegistrar$$Lambda$1 instance = new TransportRegistrar$$Lambda$1();

    private TransportRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return C0909p.m1240a((Context) componentContainer.get(Context.class));
    }
}
