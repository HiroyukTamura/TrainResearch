/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.IBinder$DeathRecipient
 *  android.os.Message
 *  android.os.RemoteException
 *  android.os.ResultReceiver
 *  android.util.Log
 */
package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.a;
import android.support.v4.media.session.b;
import android.support.v4.media.session.c;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public final class MediaControllerCompat {

    static class MediaControllerImplApi21 {
        final Object a;
        final MediaSessionCompat.Token b;
        private final List<android.support.v4.media.session.MediaControllerCompat$a> c;
        private HashMap<android.support.v4.media.session.MediaControllerCompat$a, a> d;

        void a() {
            if (this.b.a() == null) {
                return;
            }
            for (android.support.v4.media.session.MediaControllerCompat$a a2 : this.c) {
                a a3 = new a(a2);
                this.d.put(a2, a3);
                a2.c = a3;
                try {
                    this.b.a().a(a3);
                }
                catch (RemoteException remoteException) {
                    Log.e((String)"MediaControllerCompat", (String)"Dead object in registerCallback.", (Throwable)remoteException);
                    break;
                }
                a2.a(13, null, null);
            }
            this.c.clear();
        }

        private static class ExtraBinderRequestResultReceiver
        extends ResultReceiver {
            private WeakReference<MediaControllerImplApi21> a;

            /*
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             */
            protected void onReceiveResult(int n2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = (MediaControllerImplApi21)this.a.get();
                if (mediaControllerImplApi21 == null) {
                    return;
                }
                if (bundle == null) {
                    return;
                }
                Object object = mediaControllerImplApi21.a;
                synchronized (object) {
                    mediaControllerImplApi21.b.a(b.a.a(androidx.core.app.c.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                    mediaControllerImplApi21.b.a(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                    mediaControllerImplApi21.a();
                    return;
                }
            }
        }

        private static class a
        extends a.c {
            a(android.support.v4.media.session.MediaControllerCompat$a a2) {
                super(a2);
            }

            @Override
            public void a() {
                throw new AssertionError();
            }

            @Override
            public void a(Bundle bundle) {
                throw new AssertionError();
            }

            @Override
            public void a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }

            @Override
            public void a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }

            @Override
            public void a(CharSequence charSequence) {
                throw new AssertionError();
            }

            @Override
            public void a(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }
        }

    }

    public static abstract class android.support.v4.media.session.MediaControllerCompat$a
    implements IBinder.DeathRecipient {
        final Object a;
        a b;
        android.support.v4.media.session.a c;

        /*
         * Enabled aggressive block sorting
         */
        public android.support.v4.media.session.MediaControllerCompat$a() {
            Object object;
            if (Build.VERSION.SDK_INT >= 21) {
                object = android.support.v4.media.session.c.a(new b(this));
            } else {
                this.c = object = new c(this);
            }
            this.a = object;
        }

        public void a() {
        }

        public void a(int n2) {
        }

        void a(int n2, Object object, Bundle bundle) {
            if (this.b != null) {
                object = this.b.obtainMessage(n2, object);
                object.setData(bundle);
                object.sendToTarget();
            }
        }

        public void a(Bundle bundle) {
        }

        public void a(MediaMetadataCompat mediaMetadataCompat) {
        }

        public void a(android.support.v4.media.session.MediaControllerCompat$b b2) {
        }

        public void a(PlaybackStateCompat playbackStateCompat) {
        }

        public void a(CharSequence charSequence) {
        }

        public void a(String string2, Bundle bundle) {
        }

        public void a(List<MediaSessionCompat.QueueItem> list) {
        }

        public void a(boolean bl2) {
        }

        public void b() {
        }

        public void b(int n2) {
        }

        private class a
        extends Handler {
            boolean a;
            final /* synthetic */ android.support.v4.media.session.MediaControllerCompat$a b;

            public void handleMessage(Message message) {
                if (!this.a) {
                    return;
                }
                switch (message.what) {
                    default: {
                        return;
                    }
                    case 13: {
                        this.b.a();
                        return;
                    }
                    case 12: {
                        this.b.b((Integer)message.obj);
                        return;
                    }
                    case 11: {
                        this.b.a((Boolean)message.obj);
                        return;
                    }
                    case 9: {
                        this.b.a((Integer)message.obj);
                        return;
                    }
                    case 8: {
                        this.b.b();
                        return;
                    }
                    case 7: {
                        message = (Bundle)message.obj;
                        MediaSessionCompat.a((Bundle)message);
                        this.b.a((Bundle)message);
                        return;
                    }
                    case 6: {
                        this.b.a((CharSequence)message.obj);
                        return;
                    }
                    case 5: {
                        this.b.a((List)message.obj);
                        return;
                    }
                    case 4: {
                        this.b.a((android.support.v4.media.session.MediaControllerCompat$b)message.obj);
                        return;
                    }
                    case 3: {
                        this.b.a((MediaMetadataCompat)message.obj);
                        return;
                    }
                    case 2: {
                        this.b.a((PlaybackStateCompat)message.obj);
                        return;
                    }
                    case 1: 
                }
                Bundle bundle = message.getData();
                MediaSessionCompat.a(bundle);
                this.b.a((String)message.obj, bundle);
            }
        }

        private static class b
        implements c.a {
            private final WeakReference<android.support.v4.media.session.MediaControllerCompat$a> a;

            b(android.support.v4.media.session.MediaControllerCompat$a a2) {
                this.a = new WeakReference<android.support.v4.media.session.MediaControllerCompat$a>(a2);
            }

            @Override
            public void a() {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.b();
                }
            }

            @Override
            public void a(int n2, int n3, int n4, int n5, int n6) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(new android.support.v4.media.session.MediaControllerCompat$b(n2, n3, n4, n5, n6));
                }
            }

            @Override
            public void a(Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(bundle);
                }
            }

            @Override
            public void a(CharSequence charSequence) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(charSequence);
                }
            }

            @Override
            public void a(Object object) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    if (a2.c != null) {
                        return;
                    }
                    a2.a(PlaybackStateCompat.a(object));
                }
            }

            @Override
            public void a(String string2, Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    if (a2.c != null && Build.VERSION.SDK_INT < 23) {
                        return;
                    }
                    a2.a(string2, bundle);
                }
            }

            @Override
            public void a(List<?> list) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(MediaSessionCompat.QueueItem.a(list));
                }
            }

            @Override
            public void b(Object object) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(MediaMetadataCompat.a(object));
                }
            }
        }

        private static class c
        extends a.a {
            private final WeakReference<android.support.v4.media.session.MediaControllerCompat$a> a;

            c(android.support.v4.media.session.MediaControllerCompat$a a2) {
                this.a = new WeakReference<android.support.v4.media.session.MediaControllerCompat$a>(a2);
            }

            @Override
            public void a() {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(8, null, null);
                }
            }

            @Override
            public void a(int n2) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(9, n2, null);
                }
            }

            @Override
            public void a(Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(7, (Object)bundle, null);
                }
            }

            @Override
            public void a(MediaMetadataCompat mediaMetadataCompat) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(3, mediaMetadataCompat, null);
                }
            }

            @Override
            public void a(ParcelableVolumeInfo object) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    object = object != null ? new android.support.v4.media.session.MediaControllerCompat$b(((ParcelableVolumeInfo)object).a, ((ParcelableVolumeInfo)object).b, ((ParcelableVolumeInfo)object).c, ((ParcelableVolumeInfo)object).d, ((ParcelableVolumeInfo)object).e) : null;
                    a2.a(4, object, null);
                }
            }

            @Override
            public void a(PlaybackStateCompat playbackStateCompat) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(2, playbackStateCompat, null);
                }
            }

            @Override
            public void a(CharSequence charSequence) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(6, charSequence, null);
                }
            }

            @Override
            public void a(String string2, Bundle bundle) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(1, string2, bundle);
                }
            }

            @Override
            public void a(List<MediaSessionCompat.QueueItem> list) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(5, list, null);
                }
            }

            @Override
            public void a(boolean bl2) {
            }

            @Override
            public void b() {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(13, null, null);
                }
            }

            @Override
            public void b(int n2) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(12, n2, null);
                }
            }

            @Override
            public void b(boolean bl2) {
                android.support.v4.media.session.MediaControllerCompat$a a2 = (android.support.v4.media.session.MediaControllerCompat$a)this.a.get();
                if (a2 != null) {
                    a2.a(11, bl2, null);
                }
            }
        }

    }

    public static final class b {
        private final int a;
        private final int b;
        private final int c;
        private final int d;
        private final int e;

        b(int n2, int n3, int n4, int n5, int n6) {
            this.a = n2;
            this.b = n3;
            this.c = n4;
            this.d = n5;
            this.e = n6;
        }
    }

}

