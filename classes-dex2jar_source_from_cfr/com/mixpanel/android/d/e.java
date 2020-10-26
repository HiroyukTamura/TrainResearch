/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.d;

import com.mixpanel.android.a.c.g;
import com.mixpanel.android.a.d.d;
import com.mixpanel.android.a.e.h;
import com.mixpanel.android.c.f;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class e {
    private static final ByteBuffer d = ByteBuffer.allocate(0);
    private final a a;
    private final b b;
    private final URI c;

    public e(URI uRI, a a2, Socket socket) {
        this.a = a2;
        this.c = uRI;
        try {
            this.b = new b(uRI, 5000, socket);
            this.b.c();
            return;
        }
        catch (InterruptedException interruptedException) {
            throw new c(interruptedException);
        }
    }

    public boolean a() {
        return !this.b.f() && !this.b.g() && !this.b.e();
    }

    public boolean b() {
        return this.b.d();
    }

    public BufferedOutputStream c() {
        return new BufferedOutputStream(new d());
    }

    public static interface a {
        public void a();

        public void a(JSONObject var1);

        public void b();

        public void b(JSONObject var1);

        public void c(JSONObject var1);

        public void d(JSONObject var1);

        public void e(JSONObject var1);
    }

    private class b
    extends com.mixpanel.android.a.a.a {
        public b(URI uRI, int n2, Socket socket) {
            super(uRI, new com.mixpanel.android.a.b.c(), null, n2);
            this.a(socket);
        }

        @Override
        public void a(h h2) {
            f.a("MixpanelAPI.EditorCnctn", "Websocket connected");
        }

        @Override
        public void a(Exception exception) {
            if (exception != null && exception.getMessage() != null) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Websocket Error: ");
                stringBuilder.append(exception.getMessage());
                f.e("MixpanelAPI.EditorCnctn", stringBuilder.toString());
                return;
            }
            f.e("MixpanelAPI.EditorCnctn", "Unknown websocket error occurred");
        }

        @Override
        public void a(String string2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Received message from editor:\n");
            stringBuilder.append(string2);
            f.a("MixpanelAPI.EditorCnctn", stringBuilder.toString());
            try {
                stringBuilder = new JSONObject(string2);
                String string3 = stringBuilder.getString("type");
                if (string3.equals("device_info_request")) {
                    e.this.a.a();
                    return;
                }
                if (string3.equals("snapshot_request")) {
                    e.this.a.a((JSONObject)stringBuilder);
                    return;
                }
                if (string3.equals("change_request")) {
                    e.this.a.b((JSONObject)stringBuilder);
                    return;
                }
                if (string3.equals("event_binding_request")) {
                    e.this.a.d((JSONObject)stringBuilder);
                    return;
                }
                if (string3.equals("clear_request")) {
                    e.this.a.c((JSONObject)stringBuilder);
                    return;
                }
                if (string3.equals("tweak_request")) {
                    e.this.a.e((JSONObject)stringBuilder);
                    return;
                }
            }
            catch (JSONException jSONException) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append("Bad JSON received:");
                stringBuilder2.append(string2);
                f.e("MixpanelAPI.EditorCnctn", stringBuilder2.toString(), (Throwable)jSONException);
            }
        }

        @Override
        public void b(int n2, String string2, boolean bl2) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("WebSocket closed. Code: ");
            stringBuilder.append(n2);
            stringBuilder.append(", reason: ");
            stringBuilder.append(string2);
            stringBuilder.append("\nURI: ");
            stringBuilder.append(e.this.c);
            f.a("MixpanelAPI.EditorCnctn", stringBuilder.toString());
            e.this.a.b();
        }
    }

    public class c
    extends IOException {
        public c(Throwable throwable) {
            super(throwable.getMessage());
        }
    }

    private class d
    extends OutputStream {
        private d() {
        }

        @Override
        public void close() {
            try {
                e.this.b.a(d.a.b, d, true);
                return;
            }
            catch (com.mixpanel.android.a.c.f f2) {
                throw new c(f2);
            }
            catch (g g2) {
                throw new c(g2);
            }
        }

        @Override
        public void write(int n2) {
            this.write(new byte[]{(byte)n2}, 0, 1);
        }

        @Override
        public void write(byte[] arrby) {
            this.write(arrby, 0, arrby.length);
        }

        @Override
        public void write(byte[] object, int n2, int n3) {
            object = ByteBuffer.wrap(object, n2, n3);
            try {
                e.this.b.a(d.a.b, (ByteBuffer)object, false);
                return;
            }
            catch (com.mixpanel.android.a.c.f f2) {
                throw new c(f2);
            }
            catch (g g2) {
                throw new c(g2);
            }
        }
    }

}

