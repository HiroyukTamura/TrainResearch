/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.Window
 */
package com.mixpanel.android.d;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import com.mixpanel.android.b.n;

public class g {
    public g(n n2, Activity activity) {
        this.a(n2, activity);
    }

    private View.OnTouchListener a(final n n2) {
        return new View.OnTouchListener(){
            private long c = -1L;
            private long d = -1L;
            private int e = 0;
            private long f = -1L;
            private boolean g = false;
            private final int h = 100;
            private final int i = 1000;
            private final int j = 2500;

            private void a() {
                this.d = -1L;
                this.c = -1L;
                this.e = 0;
                this.f = -1L;
                this.g = false;
            }

            /*
             * Unable to fully structure code
             * Enabled aggressive block sorting
             * Lifted jumps to return sites
             */
            public boolean onTouch(View var1_1, MotionEvent var2_2) {
                if (var2_2.getPointerCount() > 2) {
                    this.a();
                    return false;
                }
                switch (var2_2.getActionMasked()) {
                    default: {
                        return false;
                    }
                    case 6: {
                        if (this.g) {
                            break;
                        }
                        ** GOTO lbl33
                    }
                    case 5: {
                        if (System.currentTimeMillis() - this.d < 100L) {
                            if (System.currentTimeMillis() - this.f > 1000L) {
                                this.a();
                            }
                            this.c = System.currentTimeMillis();
                            this.g = true;
                            return false;
                        }
                        ** GOTO lbl33
                    }
                    case 1: {
                        if (System.currentTimeMillis() - this.d >= 100L) return false;
                        if (System.currentTimeMillis() - this.c >= 2500L) {
                            if (this.e == 3) {
                                n2.b("$ab_gesture1");
                                this.a();
                            }
                            this.e = 0;
                            return false;
                        }
                        this.f = System.currentTimeMillis();
                        if (this.e < 4) {
                            ++this.e;
                            return false;
                        }
                        if (this.e == 4) {
                            n2.b("$ab_gesture2");
                        }
lbl33: // 5 sources:
                        this.a();
                        return false;
                    }
                    case 0: 
                }
                this.d = System.currentTimeMillis();
                return false;
            }
        };
    }

    private void a(n n2, Activity activity) {
        activity.getWindow().getDecorView().setOnTouchListener(this.a(n2));
    }

}

