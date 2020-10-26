/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.annotation.SuppressLint
 *  android.annotation.TargetApi
 *  android.app.Activity
 *  android.app.Fragment
 *  android.app.FragmentManager
 *  android.app.FragmentTransaction
 *  android.content.ActivityNotFoundException
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Resources
 *  android.graphics.Bitmap
 *  android.graphics.PorterDuff
 *  android.graphics.PorterDuff$Mode
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 *  android.graphics.drawable.GradientDrawable
 *  android.net.Uri
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.util.DisplayMetrics
 *  android.util.TypedValue
 *  android.view.GestureDetector
 *  android.view.GestureDetector$OnGestureListener
 *  android.view.LayoutInflater
 *  android.view.MotionEvent
 *  android.view.View
 *  android.view.View$OnTouchListener
 *  android.view.ViewGroup
 *  android.view.animation.Animation
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.ScaleAnimation
 *  android.view.animation.TranslateAnimation
 *  android.widget.ImageView
 *  android.widget.TextView
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.mixpanel.android.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import com.mixpanel.android.a;
import com.mixpanel.android.b.aa;
import com.mixpanel.android.b.j;
import com.mixpanel.android.b.m;
import com.mixpanel.android.b.n;
import com.mixpanel.android.c.f;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressLint(value={"ClickableViewAccessibility"})
@TargetApi(value=16)
public class i
extends Fragment {
    private n a;
    private Activity b;
    private GestureDetector c;
    private Handler d;
    private int e;
    private aa.a.a f;
    private Runnable g;
    private Runnable h;
    private View i;
    private AtomicBoolean j = new AtomicBoolean();

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a() {
        block3 : {
            if (!this.j.get()) {
                this.d.removeCallbacks(this.g);
                this.d.removeCallbacks(this.h);
                aa.a(this.e);
                FragmentManager fragmentManager = this.b.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                try {
                    fragmentTransaction.remove((Fragment)this).commit();
                    break block3;
                }
                catch (IllegalStateException illegalStateException) {}
                fragmentManager.beginTransaction().remove((Fragment)this).commitAllowingStateLoss();
            }
        }
        this.j.set(true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void b() {
        boolean bl2 = Build.VERSION.SDK_INT >= 17 ? this.b.isDestroyed() : false;
        if (!(this.b == null || this.b.isFinishing() || bl2 || this.j.get())) {
            block3 : {
                this.d.removeCallbacks(this.g);
                this.d.removeCallbacks(this.h);
                FragmentManager fragmentManager = this.b.getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                try {
                    fragmentTransaction.setCustomAnimations(0, a.b.com_mixpanel_android_slide_down).remove((Fragment)this).commit();
                    break block3;
                }
                catch (IllegalStateException illegalStateException) {}
                fragmentManager.beginTransaction().setCustomAnimations(0, a.b.com_mixpanel_android_slide_down).remove((Fragment)this).commitAllowingStateLoss();
            }
            aa.a(this.e);
            this.j.set(true);
        }
    }

    public void a(n n2, int n3, aa.a.a a2) {
        this.a = n2;
        this.e = n3;
        this.f = a2;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.b = activity;
        if (this.f == null) {
            this.a();
            return;
        }
        this.d = new Handler();
        this.g = new Runnable(){

            @Override
            public void run() {
                i.this.b();
            }
        };
        this.h = new Runnable(){

            @Override
            public void run() {
                i.this.i.setVisibility(0);
                i.this.i.setOnTouchListener(new View.OnTouchListener(){

                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        return i.this.c.onTouchEvent(motionEvent);
                    }
                });
                ImageView imageView = (ImageView)i.this.i.findViewById(a.c.com_mixpanel_android_notification_image);
                float f2 = TypedValue.applyDimension((int)1, (float)65.0f, (DisplayMetrics)i.this.b.getResources().getDisplayMetrics());
                TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, f2, 0.0f);
                translateAnimation.setInterpolator((Interpolator)new DecelerateInterpolator());
                translateAnimation.setDuration(200L);
                i.this.i.startAnimation((Animation)translateAnimation);
                translateAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, f2 /= 2.0f, f2);
                translateAnimation.setInterpolator((Interpolator)new a());
                translateAnimation.setDuration(400L);
                translateAnimation.setStartOffset(200L);
                imageView.startAnimation((Animation)translateAnimation);
            }

        };
        this.c = new GestureDetector((Context)activity, new GestureDetector.OnGestureListener(){

            public boolean onDown(MotionEvent motionEvent) {
                return true;
            }

            public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                if (f3 > 0.0f) {
                    i.this.b();
                }
                return true;
            }

            public void onLongPress(MotionEvent motionEvent) {
            }

            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
                return false;
            }

            public void onShowPress(MotionEvent motionEvent) {
            }

            /*
             * Loose catch block
             * Enabled aggressive block sorting
             * Enabled unnecessary exception pruning
             * Enabled aggressive exception aggregation
             * Lifted jumps to return sites
             */
            public boolean onSingleTapUp(MotionEvent motionEvent) {
                m m2;
                block11 : {
                    m2 = (m)i.this.f.a();
                    String string2 = m2.n();
                    Intent intent = null;
                    Object var2_9 = null;
                    motionEvent = intent;
                    if (string2 != null) {
                        motionEvent = intent;
                        if (string2.length() > 0) {
                            block10 : {
                                try {
                                    motionEvent = Uri.parse((String)string2);
                                }
                                catch (IllegalArgumentException illegalArgumentException) {
                                    f.c("MixpanelAPI.InAppFrag", "Can't parse notification URI, will not take any action", illegalArgumentException);
                                    return true;
                                }
                                try {
                                    intent = new Intent("android.intent.action.VIEW", (Uri)motionEvent);
                                    i.this.b.startActivity(intent);
                                    break block10;
                                }
                                catch (ActivityNotFoundException activityNotFoundException) {}
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append("User doesn't have an activity for notification URI ");
                                stringBuilder.append((Object)motionEvent);
                                f.c("MixpanelAPI.InAppFrag", stringBuilder.toString());
                            }
                            motionEvent = new JSONObject();
                            try {
                                motionEvent.put("url", (Object)string2);
                                break block11;
                            }
                            catch (JSONException jSONException) {}
                            catch (JSONException jSONException) {
                                motionEvent = var2_9;
                            }
                            f.e("MixpanelAPI.InAppFrag", "Can't put url into json properties");
                        }
                    }
                }
                i.this.a.c().a("$campaign_open", m2, (JSONObject)motionEvent);
                i.this.b();
                return true;
            }
        });
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.j.set(false);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup object, Bundle bundle) {
        super.onCreateView(layoutInflater, (ViewGroup)object, bundle);
        if (this.f == null) {
            this.a();
        } else {
            this.i = layoutInflater.inflate(a.d.com_mixpanel_android_activity_notification_mini, (ViewGroup)object, false);
            bundle = (TextView)this.i.findViewById(a.c.com_mixpanel_android_notification_title);
            layoutInflater = (ImageView)this.i.findViewById(a.c.com_mixpanel_android_notification_image);
            object = (m)this.f.a();
            bundle.setText((CharSequence)((j)object).g());
            bundle.setTextColor(((j)object).h());
            layoutInflater.setImageBitmap(((j)object).l());
            this.d.postDelayed(this.g, 10000L);
            bundle = new GradientDrawable();
            bundle.setColor(((j)object).e());
            bundle.setCornerRadius(com.mixpanel.android.c.j.a(7.0f, (Context)this.getActivity()));
            bundle.setStroke((int)com.mixpanel.android.c.j.a(2.0f, (Context)this.getActivity()), ((m)object).p());
            if (Build.VERSION.SDK_INT < 16) {
                this.i.setBackgroundDrawable((Drawable)bundle);
            } else {
                this.i.setBackground((Drawable)bundle);
            }
            bundle = new BitmapDrawable(this.getResources(), this.f.a().l());
            bundle.setColorFilter(((m)object).o(), PorterDuff.Mode.SRC_ATOP);
            layoutInflater.setImageDrawable((Drawable)bundle);
        }
        return this.i;
    }

    public void onPause() {
        super.onPause();
        this.a();
    }

    public void onResume() {
        super.onResume();
        this.d.postDelayed(this.h, 500L);
    }

    public void onStart() {
        super.onStart();
        if (this.j.get()) {
            this.b.getFragmentManager().beginTransaction().remove((Fragment)this).commit();
        }
    }

    private class a
    implements Interpolator {
        public float getInterpolation(float f2) {
            return (float)(-(Math.pow(2.718281828459045, -8.0f * f2) * Math.cos(f2 * 12.0f))) + 1.0f;
        }
    }

}

