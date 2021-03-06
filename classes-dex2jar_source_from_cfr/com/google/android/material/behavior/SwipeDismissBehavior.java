/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.ViewGroup
 *  android.view.ViewParent
 */
package com.google.android.material.behavior;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.h.t;
import androidx.e.b.a;

public class SwipeDismissBehavior<V extends View>
extends CoordinatorLayout.b<V> {
    androidx.e.b.a a;
    a b;
    int c = 2;
    float d = 0.5f;
    float e = 0.0f;
    float f = 0.5f;
    private boolean g;
    private float h = 0.0f;
    private boolean i;
    private final a.a j = new a.a(){
        private int b;
        private int c = -1;

        /*
         * Enabled force condition propagation
         * Lifted jumps to return sites
         */
        private boolean a(View view, float f2) {
            boolean bl2 = false;
            float f3 = f2 FCMPL 0.0f;
            if (f3 != false) {
                boolean bl3 = t.f(view) == 1;
                if (SwipeDismissBehavior.this.c == 2) {
                    return true;
                }
                if (SwipeDismissBehavior.this.c == 0) {
                    if (bl3) {
                        if (!(f2 < 0.0f)) return false;
                        do {
                            return true;
                            break;
                        } while (true);
                    }
                    if (f3 <= 0) return false;
                    return true;
                }
                if (SwipeDismissBehavior.this.c != 1) return false;
                if (bl3) {
                    if (f3 <= 0) return false;
                    do {
                        return true;
                        break;
                    } while (true);
                }
                if (!(f2 < 0.0f)) return false;
                return true;
            }
            int n2 = view.getLeft();
            f3 = this.b;
            int n3 = Math.round((float)view.getWidth() * SwipeDismissBehavior.this.d);
            if (Math.abs(n2 - f3) < n3) return bl2;
            return true;
        }

        @Override
        public int a(View view) {
            return view.getWidth();
        }

        /*
         * Enabled aggressive block sorting
         */
        @Override
        public int a(View view, int n2, int n3) {
            int n4;
            block6 : {
                block5 : {
                    block3 : {
                        block4 : {
                            block2 : {
                                n3 = t.f(view) == 1 ? 1 : 0;
                                if (SwipeDismissBehavior.this.c != 0) break block2;
                                if (n3 == 0) break block3;
                                break block4;
                            }
                            if (SwipeDismissBehavior.this.c != 1) break block5;
                            if (n3 != 0) break block3;
                        }
                        n3 = this.b - view.getWidth();
                        n4 = this.b;
                        return SwipeDismissBehavior.a(n3, n2, n4);
                    }
                    n3 = this.b;
                    break block6;
                }
                n3 = this.b - view.getWidth();
            }
            n4 = this.b;
            n4 = view.getWidth() + n4;
            return SwipeDismissBehavior.a(n3, n2, n4);
        }

        @Override
        public void a(int n2) {
            if (SwipeDismissBehavior.this.b != null) {
                SwipeDismissBehavior.this.b.a(n2);
            }
        }

        @Override
        public void a(View view, float f2, float f3) {
            boolean bl2;
            this.c = -1;
            int n2 = view.getWidth();
            if (this.a(view, f2)) {
                n2 = view.getLeft() < this.b ? this.b - n2 : this.b + n2;
                bl2 = true;
            } else {
                n2 = this.b;
                bl2 = false;
            }
            if (SwipeDismissBehavior.this.a.a(n2, view.getTop())) {
                t.a(view, new b(view, bl2));
                return;
            }
            if (bl2 && SwipeDismissBehavior.this.b != null) {
                SwipeDismissBehavior.this.b.a(view);
            }
        }

        @Override
        public void a(View view, int n2) {
            this.c = n2;
            this.b = view.getLeft();
            if ((view = view.getParent()) != null) {
                view.requestDisallowInterceptTouchEvent(true);
            }
        }

        @Override
        public void a(View view, int n2, int n3, int n4, int n5) {
            float f2 = (float)this.b + (float)view.getWidth() * SwipeDismissBehavior.this.e;
            float f3 = (float)this.b + (float)view.getWidth() * SwipeDismissBehavior.this.f;
            float f4 = n2;
            if (f4 <= f2) {
                view.setAlpha(1.0f);
                return;
            }
            if (f4 >= f3) {
                view.setAlpha(0.0f);
                return;
            }
            view.setAlpha(SwipeDismissBehavior.a(0.0f, 1.0f - SwipeDismissBehavior.b(f2, f3, f4), 1.0f));
        }

        @Override
        public int b(View view, int n2, int n3) {
            return view.getTop();
        }

        @Override
        public boolean b(View view, int n2) {
            return this.c == -1 && SwipeDismissBehavior.this.a(view);
        }
    };

    static float a(float f2, float f3, float f4) {
        return Math.min(Math.max(f2, f3), f4);
    }

    static int a(int n2, int n3, int n4) {
        return Math.min(Math.max(n2, n3), n4);
    }

    private void a(ViewGroup object) {
        if (this.a == null) {
            object = this.i ? androidx.e.b.a.a(object, this.h, this.j) : androidx.e.b.a.a(object, this.j);
            this.a = object;
        }
    }

    static float b(float f2, float f3, float f4) {
        return (f4 - f2) / (f3 - f2);
    }

    public void a(float f2) {
        this.e = SwipeDismissBehavior.a(0.0f, f2, 1.0f);
    }

    public void a(int n2) {
        this.c = n2;
    }

    public void a(a a2) {
        this.b = a2;
    }

    public boolean a(View view) {
        return true;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Lifted jumps to return sites
     */
    @Override
    public boolean a(CoordinatorLayout var1_1, V var2_2, MotionEvent var3_3) {
        var5_4 = this.g;
        var4_5 = var3_3.getActionMasked();
        if (var4_5 != 3) {
            switch (var4_5) {
                default: {
                    ** break;
                }
                case 0: {
                    var5_4 = this.g = var1_1.a((View)var2_2, (int)var3_3.getX(), (int)var3_3.getY());
                    ** break;
                }
                case 1: 
            }
        }
        this.g = false;
lbl12: // 3 sources:
        if (var5_4 == false) return false;
        this.a(var1_1);
        return this.a.a(var3_3);
    }

    public void b(float f2) {
        this.f = SwipeDismissBehavior.a(0.0f, f2, 1.0f);
    }

    @Override
    public boolean b(CoordinatorLayout coordinatorLayout, V v2, MotionEvent motionEvent) {
        if (this.a != null) {
            this.a.b(motionEvent);
            return true;
        }
        return false;
    }

    public static interface a {
        public void a(int var1);

        public void a(View var1);
    }

    private class b
    implements Runnable {
        private final View b;
        private final boolean c;

        b(View view, boolean bl2) {
            this.b = view;
            this.c = bl2;
        }

        @Override
        public void run() {
            if (SwipeDismissBehavior.this.a != null && SwipeDismissBehavior.this.a.a(true)) {
                t.a(this.b, this);
                return;
            }
            if (this.c && SwipeDismissBehavior.this.b != null) {
                SwipeDismissBehavior.this.b.a(this.b);
            }
        }
    }

}

