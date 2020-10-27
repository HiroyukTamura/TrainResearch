package com.google.android.datatransport.cct.p006b;

import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import java.io.IOException;

/* renamed from: com.google.android.datatransport.cct.b.b */
public final class C0572b implements Configurator {

    /* renamed from: a */
    public static final Configurator f129a = new C0572b();

    /* renamed from: com.google.android.datatransport.cct.b.b$a */
    private static final class C0573a implements ObjectEncoder<C0570a> {

        /* renamed from: a */
        static final C0573a f130a = new C0573a();

        private C0573a() {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            C0570a aVar = (C0570a) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("sdkVersion", (Object) aVar.mo9442h());
            objectEncoderContext.add("model", (Object) aVar.mo9439e());
            objectEncoderContext.add("hardware", (Object) aVar.mo9437c());
            objectEncoderContext.add("device", (Object) aVar.mo9435a());
            objectEncoderContext.add("product", (Object) aVar.mo9441g());
            objectEncoderContext.add("osBuild", (Object) aVar.mo9440f());
            objectEncoderContext.add("manufacturer", (Object) aVar.mo9438d());
            objectEncoderContext.add("fingerprint", (Object) aVar.mo9436b());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.b$b */
    private static final class C0574b implements ObjectEncoder<C0591j> {

        /* renamed from: a */
        static final C0574b f131a = new C0574b();

        private C0574b() {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            ((ObjectEncoderContext) obj2).add("logRequest", (Object) ((C0591j) obj).mo9457a());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.b$c */
    private static final class C0575c implements ObjectEncoder<C0592k> {

        /* renamed from: a */
        static final C0575c f132a = new C0575c();

        private C0575c() {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            C0592k kVar = (C0592k) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("clientType", (Object) kVar.mo9462b());
            objectEncoderContext.add("androidClientInfo", (Object) kVar.mo9461a());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.b$d */
    private static final class C0576d implements ObjectEncoder<C0595l> {

        /* renamed from: a */
        static final C0576d f133a = new C0576d();

        private C0576d() {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            C0595l lVar = (C0595l) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("eventTimeMs", lVar.mo9470b());
            objectEncoderContext.add("eventCode", (Object) lVar.mo9469a());
            objectEncoderContext.add("eventUptimeMs", lVar.mo9471c());
            objectEncoderContext.add("sourceExtension", (Object) lVar.mo9473e());
            objectEncoderContext.add("sourceExtensionJsonProto3", (Object) lVar.mo9475f());
            objectEncoderContext.add("timezoneOffsetSeconds", lVar.mo9476g());
            objectEncoderContext.add("networkConnectionInfo", (Object) lVar.mo9472d());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.b$e */
    private static final class C0577e implements ObjectEncoder<C0597m> {

        /* renamed from: a */
        static final C0577e f134a = new C0577e();

        private C0577e() {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            C0597m mVar = (C0597m) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("requestTimeMs", mVar.mo9493f());
            objectEncoderContext.add("requestUptimeMs", mVar.mo9494g());
            objectEncoderContext.add("clientInfo", (Object) mVar.mo9487a());
            objectEncoderContext.add("logSource", (Object) mVar.mo9489c());
            objectEncoderContext.add("logSourceName", (Object) mVar.mo9490d());
            objectEncoderContext.add("logEvent", (Object) mVar.mo9488b());
            objectEncoderContext.add("qosTier", (Object) mVar.mo9491e());
        }
    }

    /* renamed from: com.google.android.datatransport.cct.b.b$f */
    private static final class C0578f implements ObjectEncoder<C0600o> {

        /* renamed from: a */
        static final C0578f f135a = new C0578f();

        private C0578f() {
        }

        public void encode(Object obj, Object obj2) throws IOException {
            C0600o oVar = (C0600o) obj;
            ObjectEncoderContext objectEncoderContext = (ObjectEncoderContext) obj2;
            objectEncoderContext.add("networkType", (Object) oVar.mo9510b());
            objectEncoderContext.add("mobileSubtype", (Object) oVar.mo9509a());
        }
    }

    private C0572b() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        encoderConfig.registerEncoder((Class<U>) C0591j.class, (ObjectEncoder<? super U>) C0574b.f131a);
        encoderConfig.registerEncoder((Class<U>) C0581d.class, (ObjectEncoder<? super U>) C0574b.f131a);
        encoderConfig.registerEncoder((Class<U>) C0597m.class, (ObjectEncoder<? super U>) C0577e.f134a);
        encoderConfig.registerEncoder((Class<U>) C0586g.class, (ObjectEncoder<? super U>) C0577e.f134a);
        encoderConfig.registerEncoder((Class<U>) C0592k.class, (ObjectEncoder<? super U>) C0575c.f132a);
        encoderConfig.registerEncoder((Class<U>) C0582e.class, (ObjectEncoder<? super U>) C0575c.f132a);
        encoderConfig.registerEncoder((Class<U>) C0570a.class, (ObjectEncoder<? super U>) C0573a.f130a);
        encoderConfig.registerEncoder((Class<U>) C0579c.class, (ObjectEncoder<? super U>) C0573a.f130a);
        encoderConfig.registerEncoder((Class<U>) C0595l.class, (ObjectEncoder<? super U>) C0576d.f133a);
        encoderConfig.registerEncoder((Class<U>) C0584f.class, (ObjectEncoder<? super U>) C0576d.f133a);
        encoderConfig.registerEncoder((Class<U>) C0600o.class, (ObjectEncoder<? super U>) C0578f.f135a);
        encoderConfig.registerEncoder((Class<U>) C0589i.class, (ObjectEncoder<? super U>) C0578f.f135a);
    }
}
