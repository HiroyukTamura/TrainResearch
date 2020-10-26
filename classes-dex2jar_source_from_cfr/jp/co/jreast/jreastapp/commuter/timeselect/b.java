/*
 * Decompiled with CFR 0.139.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.view.View
 *  android.view.ViewParent
 *  android.widget.DatePicker
 *  android.widget.TimePicker
 */
package jp.co.jreast.jreastapp.commuter.timeselect;

import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.view.View;
import android.view.ViewParent;
import android.widget.DatePicker;
import android.widget.TimePicker;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.n;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import androidx.lifecycle.v;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import jp.co.jreast.jreastapp.commuter.ak;
import jp.co.jreast.jreastapp.commuter.al;
import kotlin.Metadata;
import kotlin.e.b.j;
import kotlin.t;

/*
 * Exception performing whole class analysis.
 */
@Metadata(bv={1, 0, 2}, d1={"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000206J\u0018\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002J$\u0010=\u001a\u00020\u00132\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\b0?2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\b0?H\u0002J\u001e\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\u00132\u0006\u0010C\u001a\u00020\b2\u0006\u0010D\u001a\u00020EJ\u0010\u0010F\u001a\u0002042\u0006\u0010G\u001a\u00020EH\u0002J\b\u0010H\u001a\u000204H\u0002J\u0006\u0010I\u001a\u000204J\u0006\u0010J\u001a\u000204J\u000e\u0010K\u001a\u0002042\u0006\u00105\u001a\u000206R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\rR\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\rR\u0017\u0010$\u001a\b\u0012\u0004\u0012\u00020\b0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\rR\u0017\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b'\u0010\rR\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\rR\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u0018X\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00130.\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u00130\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\r\u00a8\u0006L"}, d2={"Ljp/co/jreast/jreastapp/commuter/timeselect/DepartureArrivalTimeSelectViewModel;", "Landroidx/lifecycle/ViewModel;", "dateTimeUtil", "Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "handler", "Landroid/os/Handler;", "(Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;Landroid/os/Handler;)V", "_buttonTapped", "", "_useCurrent", "arrivalButton", "Landroidx/lifecycle/MutableLiveData;", "getArrivalButton", "()Landroidx/lifecycle/MutableLiveData;", "getDateTimeUtil", "()Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;", "setDateTimeUtil", "(Ljp/co/jreast/jreastapp/commuter/datetime/CommuterDateTimeUtil;)V", "day", "", "getDay", "departureButton", "getDepartureButton", "dismissEvent", "Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "Ljava/lang/Void;", "getDismissEvent$app_productRelease", "()Ljp/co/jreast/jreastapp/commuter/SingleLiveEvent;", "firstTrainButton", "getFirstTrainButton", "getHandler", "()Landroid/os/Handler;", "setHandler", "(Landroid/os/Handler;)V", "hour", "getHour", "lastTrainButton", "getLastTrainButton", "min", "getMin", "month", "getMonth", "setButtonClickEvent", "Landroid/content/Intent;", "getSetButtonClickEvent$app_productRelease", "visibleTimePicker", "Landroidx/lifecycle/MediatorLiveData;", "getVisibleTimePicker", "()Landroidx/lifecycle/MediatorLiveData;", "year", "getYear", "changeDateTimeByUser", "", "view", "Landroid/view/View;", "getCalendarFromPickerValue", "Ljava/util/Calendar;", "datePicker", "Landroid/widget/DatePicker;", "timePicker", "Landroid/widget/TimePicker;", "getVisibilityForTimePicker", "firstTrain", "Landroidx/lifecycle/LiveData;", "lastTrain", "setDataConfig", "departureOrArrival", "useCurrentDateTime", "selectedDate", "Ljava/util/Date;", "setDateTime", "date", "slideDate", "tapCloseButton", "tapCurrentDateTimeButton", "tapSetButton", "app_productRelease"}, k=1, mv={1, 1, 11})
public final class b
extends v {
    private final p<Boolean> a;
    private final p<Boolean> b;
    private final p<Boolean> c;
    private final p<Boolean> d;
    private final n<Integer> e;
    private boolean f;
    private boolean g;
    private final p<Integer> h;
    private final p<Integer> i;
    private final p<Integer> j;
    private final p<Integer> k;
    private final p<Integer> l;
    private final al<Void> m;
    private final al<Intent> n;
    private jp.co.jreast.jreastapp.commuter.d.a o;
    private Handler p;

    public b(jp.co.jreast.jreastapp.commuter.d.a object, Handler handler) {
        j.b(object, "dateTimeUtil");
        j.b((Object)handler, "handler");
        this.o = object;
        this.p = handler;
        this.a = new p();
        this.b = new p();
        this.c = new p();
        this.d = new p();
        object = new n();
        ((n)object).a((LiveData)this.c, }
    java.lang.IllegalStateException: Inner class got unexpected class file - revert this change
    
    