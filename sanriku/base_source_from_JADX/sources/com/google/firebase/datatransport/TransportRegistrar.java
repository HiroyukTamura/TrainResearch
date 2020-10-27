package com.google.firebase.datatransport;

import android.content.Context;
import androidx.annotation.Keep;
import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.Dependency;
import java.util.Collections;
import java.util.List;
import p009e.p028d.p030b.p031a.C0880g;

@Keep
public class TransportRegistrar implements ComponentRegistrar {
    public List<Component<?>> getComponents() {
        return Collections.singletonList(Component.builder(C0880g.class).add(Dependency.required(Context.class)).factory(TransportRegistrar$$Lambda$1.lambdaFactory$()).build());
    }
}
