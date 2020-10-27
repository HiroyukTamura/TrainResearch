package kotlinx.coroutines;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.C2550h;
import kotlinx.coroutines.internal.C2551i;
import kotlinx.coroutines.internal.C2559n;
import kotlinx.coroutines.internal.C2562q;
import p009e.p010a.p011a.p012a.C0681a;
import p009e.p028d.p030b.p054b.C1532a;

@Metadata(mo21737bv = {1, 0, 3}, mo21738d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00030\u00012\u00030Å\u0001:\u0006Ô\u0001Õ\u0001Ö\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010\\\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0004\bZ\u0010[JF\u0010e\u001a\u00020d2\u0006\u0010]\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\u00012'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b¢\u0006\u0004\be\u0010fJ6\u0010e\u001a\u00020d2'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b¢\u0006\u0004\be\u0010gJ\u0013\u0010h\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bh\u0010\u001dJ\u000f\u0010i\u001a\u00020\u0001H\u0002¢\u0006\u0004\bi\u0010jJ\u0013\u0010k\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bk\u0010\u001dJ&\u0010n\u001a\u00020m2\u0014\u0010l\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110_H\b¢\u0006\u0004\bn\u0010oJ\u001b\u0010p\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bp\u0010-J\u0019\u0010r\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bq\u0010(J\u001b\u0010t\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bs\u0010-JD\u0010u\u001a\u0006\u0012\u0002\b\u00030\t2'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b2\u0006\u0010]\u001a\u00020\u0001H\u0002¢\u0006\u0004\bu\u0010vJ\u000f\u0010x\u001a\u00020/H\u0010¢\u0006\u0004\bw\u00101J\u001f\u0010y\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\by\u0010zJ2\u0010|\u001a\u00020\u0011\"\u000e\b\u0000\u0010{\u0018\u0001*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\b|\u0010zJ\u0019\u0010]\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b]\u0010+J\u0019\u0010}\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b}\u0010\u0016J\u0010\u0010\u0001\u001a\u00020\u0011H\u0010¢\u0006\u0004\b~\u0010J\u001a\u0010\u0001\u001a\u00020\u00112\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00112\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0006\b\u0001\u0010\u0001JI\u0010\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010l\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050_ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012$\u0010l\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00112\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012$\u0010l\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0001\u0010jJ\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u0001\u00101J\u0011\u0010\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u0001\u00101J$\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\"\u0010¢\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J(\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J&\u0010¦\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J-\u0010¨\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0010¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0019\u0010«\u0001\u001a\u0004\u0018\u000108*\u00030ª\u0001H\u0002¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001f\u0010­\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b­\u0001\u0010zJ&\u0010®\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b®\u0001\u0010¯\u0001R\u001d\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020X0°\u00018F@\u0006¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u001a\u0010µ\u0001\u001a\u0004\u0018\u00010\r8D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010OR\u0018\u0010·\u0001\u001a\u00020\u00018D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010jR\u0018\u0010¹\u0001\u001a\u00020\u00018P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010jR\u0018\u0010º\u0001\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\bº\u0001\u0010jR\u0015\u0010»\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b»\u0001\u0010jR\u0015\u0010¼\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010jR\u0015\u0010½\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b½\u0001\u0010jR\u0018\u0010¾\u0001\u001a\u00020\u00018T@\u0014X\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010jR\u001b\u0010Â\u0001\u001a\u0007\u0012\u0002\b\u00030¿\u00018F@\u0006¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010Ä\u0001\u001a\u00020\u00018P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010jR\u0017\u0010È\u0001\u001a\u00030Å\u00018F@\u0006¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R.\u0010Î\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010É\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u000e¢\u0006\u0010\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00058@@\u0000X\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010LR \u0010Ñ\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058B@\u0002X\u0004¢\u0006\u0007\u001a\u0005\bÐ\u0001\u0010>R\u001d\u0010Ò\u0001\u001a\u00020\u0001*\u0002038B@\u0002X\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006×\u0001"}, mo21739d2 = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"}, mo21740k = 1, mo21741mv = {1, 1, 16})
@Deprecated(level = DeprecationLevel.ERROR, message = "This is internal API and may be removed in the future releases")
/* renamed from: kotlinx.coroutines.f0 */
public class C1113f0 implements C1111a0, C1118l, C1119m0 {

    /* renamed from: a */
    private static final AtomicReferenceFieldUpdater f918a = AtomicReferenceFieldUpdater.newUpdater(C1113f0.class, Object.class, "_state");
    private volatile Object _parentHandle;
    private volatile Object _state;

    /* renamed from: kotlinx.coroutines.f0$a */
    private static final class C1114a extends C2530e0<C1111a0> {

        /* renamed from: e */
        private final C1113f0 f919e;

        /* renamed from: f */
        private final C1115b f920f;

        /* renamed from: g */
        private final C2570k f921g;

        /* renamed from: h */
        private final Object f922h;

        public C1114a(C1113f0 f0Var, C1115b bVar, C2570k kVar, Object obj) {
            super(kVar.f4211e);
            this.f919e = f0Var;
            this.f920f = bVar;
            this.f921g = kVar;
            this.f922h = obj;
        }

        /* renamed from: b */
        public void mo21857b(Throwable th) {
            C1113f0.m1548a(this.f919e, this.f920f, this.f921g, this.f922h);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            mo21857b((Throwable) obj);
            return Unit.INSTANCE;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("ChildCompletion[");
            a.append(this.f921g);
            a.append(", ");
            a.append(this.f922h);
            a.append(']');
            return a.toString();
        }
    }

    /* renamed from: kotlinx.coroutines.f0$b */
    private static final class C1115b implements C2514V {
        private volatile Object _exceptionsHolder = null;
        private volatile int _isCompleting;
        private volatile Object _rootCause;

        /* renamed from: a */
        private final C2569j0 f923a;

        public C1115b(C2569j0 j0Var, boolean z, Throwable th) {
            this.f923a = j0Var;
            this._isCompleting = z ? 1 : 0;
            this._rootCause = th;
        }

        /* renamed from: f */
        private final ArrayList<Throwable> m1582f() {
            return new ArrayList<>(4);
        }

        /* renamed from: a */
        public C2569j0 mo21859a() {
            return this.f923a;
        }

        /* renamed from: a */
        public final void mo21860a(Throwable th) {
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 == null) {
                this._rootCause = th;
            } else if (th != th2) {
                Object obj = this._exceptionsHolder;
                if (obj == null) {
                    this._exceptionsHolder = th;
                } else if (obj instanceof Throwable) {
                    if (th != obj) {
                        ArrayList<Throwable> f = m1582f();
                        f.add(obj);
                        f.add(th);
                        this._exceptionsHolder = f;
                    }
                } else if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                } else {
                    throw new IllegalStateException(("State is " + obj).toString());
                }
            }
        }

        /* renamed from: a */
        public final void mo21861a(boolean z) {
            this._isCompleting = z ? 1 : 0;
        }

        /* renamed from: b */
        public final Throwable mo21862b() {
            return (Throwable) this._rootCause;
        }

        /* renamed from: b */
        public final List<Throwable> mo21863b(Throwable th) {
            ArrayList<Throwable> arrayList;
            Object obj = this._exceptionsHolder;
            if (obj == null) {
                arrayList = m1582f();
            } else if (obj instanceof Throwable) {
                ArrayList<Throwable> f = m1582f();
                f.add(obj);
                arrayList = f;
            } else if (obj instanceof ArrayList) {
                arrayList = (ArrayList) obj;
            } else {
                throw new IllegalStateException(("State is " + obj).toString());
            }
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 != null) {
                arrayList.add(0, th2);
            }
            if (th != null && (!Intrinsics.areEqual((Object) th, (Object) th2))) {
                arrayList.add(th);
            }
            this._exceptionsHolder = C2533g0.f4153e;
            return arrayList;
        }

        /* renamed from: c */
        public final boolean mo21864c() {
            return ((Throwable) this._rootCause) != null;
        }

        /* JADX WARNING: type inference failed for: r0v0, types: [int, boolean] */
        /* renamed from: d */
        public final boolean mo21865d() {
            return this._isCompleting;
        }

        /* renamed from: e */
        public final boolean mo21866e() {
            return this._exceptionsHolder == C2533g0.f4153e;
        }

        public boolean isActive() {
            return ((Throwable) this._rootCause) == null;
        }

        public String toString() {
            StringBuilder a = C0681a.m330a("Finishing[cancelling=");
            a.append(mo21864c());
            a.append(", completing=");
            a.append(mo21865d());
            a.append(", rootCause=");
            a.append((Throwable) this._rootCause);
            a.append(", exceptions=");
            a.append(this._exceptionsHolder);
            a.append(", list=");
            a.append(this.f923a);
            a.append(']');
            return a.toString();
        }
    }

    /* renamed from: kotlinx.coroutines.f0$c */
    public static final class C1116c extends C2551i.C2552a {

        /* renamed from: d */
        final /* synthetic */ C1113f0 f924d;

        /* renamed from: e */
        final /* synthetic */ Object f925e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C1116c(C2551i iVar, C2551i iVar2, C1113f0 f0Var, Object obj) {
            super(iVar2);
            this.f924d = f0Var;
            this.f925e = obj;
        }

        /* renamed from: b */
        public Object mo21869b(Object obj) {
            C2551i iVar = (C2551i) obj;
            if (this.f924d.mo21851e() == this.f925e) {
                return null;
            }
            return C2550h.m4432a();
        }
    }

    public C1113f0(boolean z) {
        this._state = z ? C2533g0.f4155g : C2533g0.f4154f;
        this._parentHandle = null;
    }

    /* renamed from: a */
    private final C2530e0<?> m1543a(Function1<? super Throwable, Unit> function1, boolean z) {
        boolean z2 = true;
        C2526c0 c0Var = null;
        if (z) {
            if (function1 instanceof C2526c0) {
                c0Var = function1;
            }
            C2526c0 c0Var2 = c0Var;
            if (c0Var2 == null) {
                return new C2517Y(this, function1);
            }
            if (!C2496E.m4305a()) {
                return c0Var2;
            }
            if (c0Var2.f4144d != this) {
                z2 = false;
            }
            if (z2) {
                return c0Var2;
            }
            throw new AssertionError();
        }
        if (function1 instanceof C2530e0) {
            c0Var = function1;
        }
        C2530e0<?> e0Var = c0Var;
        if (e0Var == null) {
            return new C2518Z(this, function1);
        }
        if (!C2496E.m4305a()) {
            return e0Var;
        }
        if (e0Var.f4144d != this || (e0Var instanceof C2526c0)) {
            z2 = false;
        }
        if (z2) {
            return e0Var;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    private final C2570k m1545a(C2551i iVar) {
        while (iVar.mo35555f()) {
            iVar = iVar.mo35561e();
        }
        while (true) {
            iVar = iVar.mo35560d();
            if (!iVar.mo35555f()) {
                if (iVar instanceof C2570k) {
                    return (C2570k) iVar;
                }
                if (iVar instanceof C2569j0) {
                    return null;
                }
            }
        }
    }

    /* renamed from: a */
    private final void m1546a(Throwable th, List<? extends Throwable> list) {
        if (list.size() > 1) {
            Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
            Throwable a = !C2496E.m4308d() ? th : C2562q.m4461a(th);
            for (Throwable th2 : list) {
                if (C2496E.m4308d()) {
                    th2 = C2562q.m4461a(th2);
                }
                if (th2 != th && th2 != a && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th, th2);
                }
            }
        }
    }

    /* renamed from: a */
    public static final /* synthetic */ void m1548a(C1113f0 f0Var, C1115b bVar, C2570k kVar, Object obj) {
        if (f0Var != null) {
            if (C2496E.m4305a()) {
                if (!(f0Var.mo21851e() == bVar)) {
                    throw new AssertionError();
                }
            }
            C2570k a = f0Var.m1545a((C2551i) kVar);
            if (a == null || !f0Var.m1551a(bVar, a, obj)) {
                f0Var.mo21838a(f0Var.m1542a(bVar, obj));
                return;
            }
            return;
        }
        throw null;
    }

    /* renamed from: a */
    private final void m1549a(C2569j0 j0Var, Throwable th) {
        C2587t tVar = null;
        Object c = j0Var.mo35559c();
        if (c != null) {
            for (C2551i iVar = (C2551i) c; !Intrinsics.areEqual((Object) iVar, (Object) j0Var); iVar = iVar.mo35560d()) {
                if (iVar instanceof C2526c0) {
                    C2530e0 e0Var = (C2530e0) iVar;
                    try {
                        e0Var.mo21857b(th);
                    } catch (Throwable th2) {
                        if (tVar != null) {
                            ExceptionsKt__ExceptionsKt.addSuppressed(tVar, th2);
                        } else {
                            tVar = new C2587t("Exception in completion handler " + e0Var + " for " + this, th2);
                            Unit unit = Unit.INSTANCE;
                        }
                    }
                }
            }
            if (tVar != null) {
                mo21847c((Throwable) tVar);
            }
            m1553d(th);
            return;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
    }

    /* renamed from: a */
    private final boolean m1550a(Object obj, C2569j0 j0Var, C2530e0<?> e0Var) {
        int a;
        C1116c cVar = new C1116c(e0Var, e0Var, this, obj);
        do {
            a = j0Var.mo35561e().mo35557a(e0Var, j0Var, cVar);
            if (a == 1) {
                return true;
            }
        } while (a != 2);
        return false;
    }

    /* renamed from: a */
    private final boolean m1551a(C1115b bVar, C2570k kVar, Object obj) {
        while (C1532a.m2133a(kVar.f4211e, false, false, new C1114a(this, bVar, kVar, obj), 1, (Object) null) == C2571k0.f4212a) {
            kVar = m1545a((C2551i) kVar);
            if (kVar == null) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: d */
    private final boolean m1553d(Throwable th) {
        if (mo21852f()) {
            return true;
        }
        boolean z = th instanceof CancellationException;
        C1117j jVar = (C1117j) this._parentHandle;
        if (jVar == null || jVar == C2571k0.f4212a) {
            return z;
        }
        if (jVar.mo21870a(th) || z) {
            return true;
        }
        return false;
    }

    /* renamed from: e */
    private final Throwable mo35496e(Object obj) {
        if (obj != null ? obj instanceof Throwable : true) {
            if (obj != null) {
                return (Throwable) obj;
            }
            return new C2524b0(mo21836a(), (Throwable) null, this);
        } else if (obj != null) {
            return ((C1119m0) obj).mo21855l();
        } else {
            throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0040, code lost:
        if (r0 == null) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0042, code lost:
        m1549a(((kotlinx.coroutines.C1113f0.C1115b) r2).mo21859a(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x004f, code lost:
        return kotlinx.coroutines.C2533g0.m4405a();
     */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x00a8 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0002 A[SYNTHETIC] */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m1555f(java.lang.Object r9) {
        /*
            r8 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r8.mo21851e()
            boolean r3 = r2 instanceof kotlinx.coroutines.C1113f0.C1115b
            r4 = 1
            if (r3 == 0) goto L_0x0053
            monitor-enter(r2)
            r3 = r2
            kotlinx.coroutines.f0$b r3 = (kotlinx.coroutines.C1113f0.C1115b) r3     // Catch:{ all -> 0x0050 }
            boolean r3 = r3.mo21866e()     // Catch:{ all -> 0x0050 }
            if (r3 == 0) goto L_0x001b
            kotlinx.coroutines.internal.r r9 = kotlinx.coroutines.C2533g0.f4152d     // Catch:{ all -> 0x0050 }
            monitor-exit(r2)
            return r9
        L_0x001b:
            r3 = r2
            kotlinx.coroutines.f0$b r3 = (kotlinx.coroutines.C1113f0.C1115b) r3     // Catch:{ all -> 0x0050 }
            boolean r3 = r3.mo21864c()     // Catch:{ all -> 0x0050 }
            if (r9 != 0) goto L_0x0026
            if (r3 != 0) goto L_0x0033
        L_0x0026:
            if (r1 == 0) goto L_0x0029
            goto L_0x002d
        L_0x0029:
            java.lang.Throwable r1 = r8.mo35496e(r9)     // Catch:{ all -> 0x0050 }
        L_0x002d:
            r9 = r2
            kotlinx.coroutines.f0$b r9 = (kotlinx.coroutines.C1113f0.C1115b) r9     // Catch:{ all -> 0x0050 }
            r9.mo21860a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0050 }
        L_0x0033:
            r9 = r2
            kotlinx.coroutines.f0$b r9 = (kotlinx.coroutines.C1113f0.C1115b) r9     // Catch:{ all -> 0x0050 }
            java.lang.Throwable r9 = r9.mo21862b()     // Catch:{ all -> 0x0050 }
            r1 = r3 ^ 1
            if (r1 == 0) goto L_0x003f
            r0 = r9
        L_0x003f:
            monitor-exit(r2)
            if (r0 == 0) goto L_0x004b
            kotlinx.coroutines.f0$b r2 = (kotlinx.coroutines.C1113f0.C1115b) r2
            kotlinx.coroutines.j0 r9 = r2.mo21859a()
            r8.m1549a((kotlinx.coroutines.C2569j0) r9, (java.lang.Throwable) r0)
        L_0x004b:
            kotlinx.coroutines.internal.r r9 = kotlinx.coroutines.C2533g0.f4149a
            return r9
        L_0x0050:
            r9 = move-exception
            monitor-exit(r2)
            throw r9
        L_0x0053:
            boolean r3 = r2 instanceof kotlinx.coroutines.C2514V
            if (r3 == 0) goto L_0x00e1
            if (r1 == 0) goto L_0x005a
            goto L_0x005e
        L_0x005a:
            java.lang.Throwable r1 = r8.mo35496e(r9)
        L_0x005e:
            r3 = r2
            kotlinx.coroutines.V r3 = (kotlinx.coroutines.C2514V) r3
            boolean r5 = r3.isActive()
            r6 = 0
            if (r5 == 0) goto L_0x00ad
            boolean r2 = kotlinx.coroutines.C2496E.m4305a()
            if (r2 == 0) goto L_0x007a
            boolean r2 = r3 instanceof kotlinx.coroutines.C1113f0.C1115b
            r2 = r2 ^ r4
            if (r2 == 0) goto L_0x0074
            goto L_0x007a
        L_0x0074:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x007a:
            boolean r2 = kotlinx.coroutines.C2496E.m4305a()
            if (r2 == 0) goto L_0x008d
            boolean r2 = r3.isActive()
            if (r2 == 0) goto L_0x0087
            goto L_0x008d
        L_0x0087:
            java.lang.AssertionError r9 = new java.lang.AssertionError
            r9.<init>()
            throw r9
        L_0x008d:
            kotlinx.coroutines.j0 r2 = r8.m1544a((kotlinx.coroutines.C2514V) r3)
            if (r2 == 0) goto L_0x00a5
            kotlinx.coroutines.f0$b r5 = new kotlinx.coroutines.f0$b
            r5.<init>(r2, r6, r1)
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r7 = f918a
            boolean r3 = r7.compareAndSet(r8, r3, r5)
            if (r3 != 0) goto L_0x00a1
            goto L_0x00a5
        L_0x00a1:
            r8.m1549a((kotlinx.coroutines.C2569j0) r2, (java.lang.Throwable) r1)
            goto L_0x00a6
        L_0x00a5:
            r4 = 0
        L_0x00a6:
            if (r4 == 0) goto L_0x0002
            kotlinx.coroutines.internal.r r9 = kotlinx.coroutines.C2533g0.f4149a
            return r9
        L_0x00ad:
            kotlinx.coroutines.p r3 = new kotlinx.coroutines.p
            r4 = 2
            r3.<init>(r1, r6, r4)
            java.lang.Object r3 = r8.m1541a((java.lang.Object) r2, (java.lang.Object) r3)
            kotlinx.coroutines.internal.r r4 = kotlinx.coroutines.C2533g0.f4149a
            if (r3 == r4) goto L_0x00c6
            kotlinx.coroutines.internal.r r2 = kotlinx.coroutines.C2533g0.f4151c
            if (r3 != r2) goto L_0x00c5
            goto L_0x0002
        L_0x00c5:
            return r3
        L_0x00c6:
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r0 = "Cannot happen in "
            r9.append(r0)
            r9.append(r2)
            java.lang.String r9 = r9.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r9 = r9.toString()
            r0.<init>(r9)
            throw r0
        L_0x00e1:
            kotlinx.coroutines.internal.r r9 = kotlinx.coroutines.C2533g0.f4152d
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C1113f0.m1555f(java.lang.Object):java.lang.Object");
    }

    /* renamed from: g */
    private final String m1556g(Object obj) {
        if (!(obj instanceof C1115b)) {
            return obj instanceof C2514V ? ((C2514V) obj).isActive() ? "Active" : "New" : obj instanceof C2579p ? "Cancelled" : "Completed";
        }
        C1115b bVar = (C1115b) obj;
        return bVar.mo21864c() ? "Cancelling" : bVar.mo21865d() ? "Completing" : "Active";
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String mo21836a() {
        return "Job was cancelled";
    }

    /* renamed from: a */
    public final C1117j mo21831a(C1118l lVar) {
        C1110L a = C1532a.m2133a(this, true, false, new C2570k(this, lVar), 2, (Object) null);
        if (a != null) {
            return (C1117j) a;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo21838a(Object obj) {
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void mo21840a(kotlinx.coroutines.C2530e0<?> r4) {
        /*
            r3 = this;
        L_0x0000:
            java.lang.Object r0 = r3.mo21851e()
            boolean r1 = r0 instanceof kotlinx.coroutines.C2530e0
            if (r1 == 0) goto L_0x0018
            if (r0 == r4) goto L_0x000b
            return
        L_0x000b:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f918a
            kotlinx.coroutines.M r2 = kotlinx.coroutines.C2533g0.f4155g
            boolean r0 = r1.compareAndSet(r3, r0, r2)
            if (r0 == 0) goto L_0x0000
            return
        L_0x0018:
            boolean r1 = r0 instanceof kotlinx.coroutines.C2514V
            if (r1 == 0) goto L_0x0027
            kotlinx.coroutines.V r0 = (kotlinx.coroutines.C2514V) r0
            kotlinx.coroutines.j0 r0 = r0.mo21859a()
            if (r0 == 0) goto L_0x0027
            r4.mo35556g()
        L_0x0027:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C1113f0.mo21840a(kotlinx.coroutines.e0):void");
    }

    /* renamed from: a */
    public final void mo21841a(C1119m0 m0Var) {
        mo21844b((Object) m0Var);
    }

    /* renamed from: a */
    public boolean mo21842a(Throwable th) {
        if (th instanceof CancellationException) {
            return true;
        }
        return mo21844b((Object) th) && mo21843b();
    }

    /* renamed from: b */
    public boolean mo21843b() {
        return true;
    }

    /* renamed from: b */
    public final boolean mo21844b(Object obj) {
        Object a = C2533g0.f4149a;
        if (mo21848c()) {
            while (true) {
                Object e = mo21851e();
                if ((e instanceof C2514V) && (!(e instanceof C1115b) || !((C1115b) e).mo21865d())) {
                    a = m1541a(e, (Object) new C2579p(mo35496e(obj), false, 2));
                    if (a != C2533g0.f4151c) {
                        break;
                    }
                } else {
                    a = C2533g0.f4149a;
                }
            }
            a = C2533g0.f4149a;
            if (a == C2533g0.f4150b) {
                return true;
            }
        }
        if (a == C2533g0.f4149a) {
            a = m1555f(obj);
        }
        if (!(a == C2533g0.f4149a || a == C2533g0.f4150b)) {
            if (a == C2533g0.f4152d) {
                return false;
            }
            mo21838a(a);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo21845b(Throwable th) {
        return false;
    }

    /* renamed from: c */
    public final Object mo21846c(Object obj) {
        Object a;
        do {
            a = m1541a(mo21851e(), obj);
            if (a == C2533g0.f4149a) {
                String str = "Job " + this + " is already complete or completing, " + "but is being completed with " + obj;
                Throwable th = null;
                if (!(obj instanceof C2579p)) {
                    obj = null;
                }
                C2579p pVar = (C2579p) obj;
                if (pVar != null) {
                    th = pVar.f4218a;
                }
                throw new IllegalStateException(str, th);
            }
        } while (a == C2533g0.f4151c);
        return a;
    }

    /* renamed from: c */
    public void mo21847c(Throwable th) {
        throw th;
    }

    /* renamed from: c */
    public boolean mo21848c() {
        return false;
    }

    /* renamed from: d */
    public final C1117j mo21849d() {
        return (C1117j) this._parentHandle;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo21850d(Object obj) {
    }

    /* renamed from: e */
    public final Object mo21851e() {
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof C2559n)) {
                return obj;
            }
            ((C2559n) obj).mo35554a(this);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public boolean mo21852f() {
        return false;
    }

    public <R> R fold(R r, Function2<? super R, ? super CoroutineContext.Element, ? extends R> function2) {
        return CoroutineContext.Element.DefaultImpls.fold(this, r, function2);
    }

    /* renamed from: g */
    public String mo21853g() {
        return getClass().getSimpleName();
    }

    public <E extends CoroutineContext.Element> E get(CoroutineContext.Key<E> key) {
        return CoroutineContext.Element.DefaultImpls.get(this, key);
    }

    public final CoroutineContext.Key<?> getKey() {
        return C1111a0.f916k;
    }

    /* renamed from: h */
    public final CancellationException mo21833h() {
        Object e = mo21851e();
        if (e instanceof C1115b) {
            Throwable b = ((C1115b) e).mo21862b();
            if (b != null) {
                CancellationException a = mo21837a(b, getClass().getSimpleName() + " is cancelling");
                if (a != null) {
                    return a;
                }
            }
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (e instanceof C2514V) {
            throw new IllegalStateException(("Job is still new or active: " + this).toString());
        } else if (e instanceof C2579p) {
            return mo21837a(((C2579p) e).f4218a, (String) null);
        } else {
            return new C2524b0(getClass().getSimpleName() + " has completed normally", (Throwable) null, this);
        }
    }

    /* renamed from: i */
    public void mo21854i() {
    }

    public boolean isActive() {
        Object e = mo21851e();
        return (e instanceof C2514V) && ((C2514V) e).isActive();
    }

    /* renamed from: l */
    public CancellationException mo21855l() {
        Throwable th;
        Object e = mo21851e();
        CancellationException cancellationException = null;
        if (e instanceof C1115b) {
            th = ((C1115b) e).mo21862b();
        } else if (e instanceof C2579p) {
            th = ((C2579p) e).f4218a;
        } else if (!(e instanceof C2514V)) {
            th = null;
        } else {
            throw new IllegalStateException(("Cannot be cancelling child in this state: " + e).toString());
        }
        if (th instanceof CancellationException) {
            cancellationException = th;
        }
        CancellationException cancellationException2 = cancellationException;
        if (cancellationException2 != null) {
            return cancellationException2;
        }
        StringBuilder a = C0681a.m330a("Parent job is ");
        a.append(m1556g(e));
        return new C2524b0(a.toString(), th, this);
    }

    public CoroutineContext minusKey(CoroutineContext.Key<?> key) {
        return CoroutineContext.Element.DefaultImpls.minusKey(this, key);
    }

    public CoroutineContext plus(CoroutineContext coroutineContext) {
        return CoroutineContext.Element.DefaultImpls.plus(this, coroutineContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x001f, code lost:
        if (f918a.compareAndSet(r6, r0, kotlinx.coroutines.C2533g0.m4408c()) == false) goto L_0x003c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0033, code lost:
        if (f918a.compareAndSet(r6, r0, ((kotlinx.coroutines.C2513U) r0).mo21859a()) == false) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003e A[ADDED_TO_REGION, LOOP:0: B:0:0x0000->B:13:0x003e, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0042 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean start() {
        /*
            r6 = this;
        L_0x0000:
            java.lang.Object r0 = r6.mo21851e()
            boolean r1 = r0 instanceof kotlinx.coroutines.C2503M
            r2 = -1
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0022
            r1 = r0
            kotlinx.coroutines.M r1 = (kotlinx.coroutines.C2503M) r1
            boolean r1 = r1.isActive()
            if (r1 == 0) goto L_0x0015
            goto L_0x003b
        L_0x0015:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f918a
            kotlinx.coroutines.M r5 = kotlinx.coroutines.C2533g0.f4155g
            boolean r0 = r1.compareAndSet(r6, r0, r5)
            if (r0 != 0) goto L_0x0036
            goto L_0x003c
        L_0x0022:
            boolean r1 = r0 instanceof kotlinx.coroutines.C2513U
            if (r1 == 0) goto L_0x003b
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r1 = f918a
            r5 = r0
            kotlinx.coroutines.U r5 = (kotlinx.coroutines.C2513U) r5
            kotlinx.coroutines.j0 r5 = r5.mo21859a()
            boolean r0 = r1.compareAndSet(r6, r0, r5)
            if (r0 != 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            r6.mo21854i()
            r2 = 1
            goto L_0x003c
        L_0x003b:
            r2 = 0
        L_0x003c:
            if (r2 == 0) goto L_0x0042
            if (r2 == r4) goto L_0x0041
            goto L_0x0000
        L_0x0041:
            return r4
        L_0x0042:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C1113f0.start():boolean");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(mo21853g() + '{' + m1556g(mo21851e()) + '}');
        sb.append('@');
        sb.append(C1532a.m2147b(this));
        return sb.toString();
    }

    /* renamed from: a */
    public void mo21832a(CancellationException cancellationException) {
        if (cancellationException == null) {
            cancellationException = new C2524b0(mo21836a(), (Throwable) null, this);
        }
        mo21844b((Object) cancellationException);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:46:0x006e, code lost:
        if (r5 == null) goto L_0x0073;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0070, code lost:
        m1549a(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0075, code lost:
        if ((r7 instanceof kotlinx.coroutines.C2570k) != false) goto L_0x0079;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0077, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0079, code lost:
        r0 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x007a, code lost:
        r0 = (kotlinx.coroutines.C2570k) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x007c, code lost:
        if (r0 == null) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007e, code lost:
        r2 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x0080, code lost:
        r7 = r7.mo21859a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x0084, code lost:
        if (r7 == null) goto L_0x008a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0086, code lost:
        r2 = m1545a((kotlinx.coroutines.internal.C2551i) r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x008a, code lost:
        if (r2 == null) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0090, code lost:
        if (m1551a(r1, r2, r8) == false) goto L_0x0095;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0094, code lost:
        return kotlinx.coroutines.C2533g0.f4150b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x0099, code lost:
        return m1542a(r1, r8);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object m1552b(kotlinx.coroutines.C2514V r7, java.lang.Object r8) {
        /*
            r6 = this;
            kotlinx.coroutines.j0 r0 = r6.m1544a((kotlinx.coroutines.C2514V) r7)
            if (r0 == 0) goto L_0x009d
            boolean r1 = r7 instanceof kotlinx.coroutines.C1113f0.C1115b
            r2 = 0
            if (r1 != 0) goto L_0x000d
            r1 = r2
            goto L_0x000e
        L_0x000d:
            r1 = r7
        L_0x000e:
            kotlinx.coroutines.f0$b r1 = (kotlinx.coroutines.C1113f0.C1115b) r1
            if (r1 == 0) goto L_0x0013
            goto L_0x0019
        L_0x0013:
            kotlinx.coroutines.f0$b r1 = new kotlinx.coroutines.f0$b
            r3 = 0
            r1.<init>(r0, r3, r2)
        L_0x0019:
            monitor-enter(r1)
            boolean r3 = r1.mo21865d()     // Catch:{ all -> 0x009a }
            if (r3 == 0) goto L_0x0026
            kotlinx.coroutines.internal.r r7 = kotlinx.coroutines.C2533g0.f4149a     // Catch:{ all -> 0x009a }
            monitor-exit(r1)
            return r7
        L_0x0026:
            r3 = 1
            r1.mo21861a((boolean) r3)     // Catch:{ all -> 0x009a }
            if (r1 == r7) goto L_0x003a
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f918a     // Catch:{ all -> 0x009a }
            boolean r4 = r4.compareAndSet(r6, r7, r1)     // Catch:{ all -> 0x009a }
            if (r4 != 0) goto L_0x003a
            kotlinx.coroutines.internal.r r7 = kotlinx.coroutines.C2533g0.f4151c     // Catch:{ all -> 0x009a }
            monitor-exit(r1)
            return r7
        L_0x003a:
            boolean r4 = kotlinx.coroutines.C2496E.m4305a()     // Catch:{ all -> 0x009a }
            if (r4 == 0) goto L_0x004e
            boolean r4 = r1.mo21866e()     // Catch:{ all -> 0x009a }
            r4 = r4 ^ r3
            if (r4 == 0) goto L_0x0048
            goto L_0x004e
        L_0x0048:
            java.lang.AssertionError r7 = new java.lang.AssertionError     // Catch:{ all -> 0x009a }
            r7.<init>()     // Catch:{ all -> 0x009a }
            throw r7     // Catch:{ all -> 0x009a }
        L_0x004e:
            boolean r4 = r1.mo21864c()     // Catch:{ all -> 0x009a }
            boolean r5 = r8 instanceof kotlinx.coroutines.C2579p     // Catch:{ all -> 0x009a }
            if (r5 != 0) goto L_0x0058
            r5 = r2
            goto L_0x0059
        L_0x0058:
            r5 = r8
        L_0x0059:
            kotlinx.coroutines.p r5 = (kotlinx.coroutines.C2579p) r5     // Catch:{ all -> 0x009a }
            if (r5 == 0) goto L_0x0062
            java.lang.Throwable r5 = r5.f4218a     // Catch:{ all -> 0x009a }
            r1.mo21860a((java.lang.Throwable) r5)     // Catch:{ all -> 0x009a }
        L_0x0062:
            java.lang.Throwable r5 = r1.mo21862b()     // Catch:{ all -> 0x009a }
            r3 = r3 ^ r4
            if (r3 == 0) goto L_0x006a
            goto L_0x006b
        L_0x006a:
            r5 = r2
        L_0x006b:
            kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009a }
            monitor-exit(r1)
            if (r5 == 0) goto L_0x0073
            r6.m1549a((kotlinx.coroutines.C2569j0) r0, (java.lang.Throwable) r5)
        L_0x0073:
            boolean r0 = r7 instanceof kotlinx.coroutines.C2570k
            if (r0 != 0) goto L_0x0079
            r0 = r2
            goto L_0x007a
        L_0x0079:
            r0 = r7
        L_0x007a:
            kotlinx.coroutines.k r0 = (kotlinx.coroutines.C2570k) r0
            if (r0 == 0) goto L_0x0080
            r2 = r0
            goto L_0x008a
        L_0x0080:
            kotlinx.coroutines.j0 r7 = r7.mo21859a()
            if (r7 == 0) goto L_0x008a
            kotlinx.coroutines.k r2 = r6.m1545a((kotlinx.coroutines.internal.C2551i) r7)
        L_0x008a:
            if (r2 == 0) goto L_0x0095
            boolean r7 = r6.m1551a((kotlinx.coroutines.C1113f0.C1115b) r1, (kotlinx.coroutines.C2570k) r2, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x0095
            kotlinx.coroutines.internal.r r7 = kotlinx.coroutines.C2533g0.f4150b
            return r7
        L_0x0095:
            java.lang.Object r7 = r6.m1542a((kotlinx.coroutines.C1113f0.C1115b) r1, (java.lang.Object) r8)
            return r7
        L_0x009a:
            r7 = move-exception
            monitor-exit(r1)
            throw r7
        L_0x009d:
            kotlinx.coroutines.internal.r r7 = kotlinx.coroutines.C2533g0.f4151c
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C1113f0.m1552b(kotlinx.coroutines.V, java.lang.Object):java.lang.Object");
    }

    /* renamed from: a */
    private final void m1547a(C2514V v, Object obj) {
        C1117j jVar = (C1117j) this._parentHandle;
        if (jVar != null) {
            jVar.mo21829b();
            this._parentHandle = C2571k0.f4212a;
        }
        C2587t tVar = null;
        if (!(obj instanceof C2579p)) {
            obj = null;
        }
        C2579p pVar = (C2579p) obj;
        Throwable th = pVar != null ? pVar.f4218a : null;
        if (v instanceof C2530e0) {
            try {
                ((C2530e0) v).mo21857b(th);
            } catch (Throwable th2) {
                mo21847c((Throwable) new C2587t("Exception in completion handler " + v + " for " + this, th2));
            }
        } else {
            C2569j0 a = v.mo21859a();
            if (a != null) {
                Object c = a.mo35559c();
                if (c != null) {
                    for (C2551i iVar = (C2551i) c; !Intrinsics.areEqual((Object) iVar, (Object) a); iVar = iVar.mo35560d()) {
                        if (iVar instanceof C2530e0) {
                            C2530e0 e0Var = (C2530e0) iVar;
                            try {
                                e0Var.mo21857b(th);
                            } catch (Throwable th3) {
                                if (tVar != null) {
                                    ExceptionsKt__ExceptionsKt.addSuppressed(tVar, th3);
                                } else {
                                    tVar = new C2587t("Exception in completion handler " + e0Var + " for " + this, th3);
                                    Unit unit = Unit.INSTANCE;
                                }
                            }
                        }
                    }
                    if (tVar != null) {
                        mo21847c((Throwable) tVar);
                        return;
                    }
                    return;
                }
                throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
            }
        }
    }

    /* renamed from: a */
    private final Object m1542a(C1115b bVar, Object obj) {
        boolean z = true;
        if (C2496E.m4305a()) {
            if (!(mo21851e() == bVar)) {
                throw new AssertionError();
            }
        }
        if (C2496E.m4305a() && !(!bVar.mo21866e())) {
            throw new AssertionError();
        } else if (!C2496E.m4305a() || bVar.mo21865d()) {
            T t = null;
            C2579p pVar = (C2579p) (!(obj instanceof C2579p) ? null : obj);
            T t2 = pVar != null ? pVar.f4218a : null;
            synchronized (bVar) {
                boolean c = bVar.mo21864c();
                List<Throwable> b = bVar.mo21863b(t2);
                if (!b.isEmpty()) {
                    Iterator<T> it = b.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        T next = it.next();
                        if (!(((Throwable) next) instanceof CancellationException)) {
                            t = next;
                            break;
                        }
                    }
                    t = (Throwable) t;
                    if (t == null) {
                        t = (Throwable) b.get(0);
                    }
                } else if (bVar.mo21864c()) {
                    t = new C2524b0(mo21836a(), (Throwable) null, this);
                }
                if (t != null) {
                    m1546a((Throwable) t, (List<? extends Throwable>) b);
                }
            }
            if (!(t == null || t == t2)) {
                obj = new C2579p(t, false, 2);
            }
            if (t != null) {
                if (!m1553d((Throwable) t) && !mo21845b((Throwable) t)) {
                    z = false;
                }
                if (z) {
                    if (obj != null) {
                        ((C2579p) obj).mo35593b();
                    } else {
                        throw new TypeCastException("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                    }
                }
            }
            mo21850d(obj);
            boolean compareAndSet = f918a.compareAndSet(this, bVar, obj instanceof C2514V ? new C2515W((C2514V) obj) : obj);
            if (!C2496E.m4305a() || compareAndSet) {
                m1547a((C2514V) bVar, obj);
                return obj;
            }
            throw new AssertionError();
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private final C2569j0 m1544a(C2514V v) {
        C2569j0 a = v.mo21859a();
        if (a != null) {
            return a;
        }
        if (v instanceof C2503M) {
            return new C2569j0();
        }
        if (v instanceof C2530e0) {
            C2530e0 e0Var = (C2530e0) v;
            e0Var.mo35558a((C2551i) new C2569j0());
            f918a.compareAndSet(this, e0Var, e0Var.mo35560d());
            return null;
        }
        throw new IllegalStateException(("State should have list: " + v).toString());
    }

    /* renamed from: a */
    public final void mo21839a(C1111a0 a0Var) {
        if (C2496E.m4305a()) {
            if (!(((C1117j) this._parentHandle) == null)) {
                throw new AssertionError();
            }
        }
        if (a0Var == null) {
            this._parentHandle = C2571k0.f4212a;
            return;
        }
        a0Var.start();
        C1117j a = a0Var.mo21831a((C1118l) this);
        this._parentHandle = a;
        if (!(mo21851e() instanceof C2514V)) {
            a.mo21829b();
            this._parentHandle = C2571k0.f4212a;
        }
    }

    /* JADX WARNING: type inference failed for: r4v9, types: [kotlinx.coroutines.U] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.C1110L mo21830a(boolean r8, boolean r9, kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit> r10) {
        /*
            r7 = this;
            r0 = 0
            r1 = r0
        L_0x0002:
            java.lang.Object r2 = r7.mo21851e()
            boolean r3 = r2 instanceof kotlinx.coroutines.C2503M
            if (r3 == 0) goto L_0x003b
            r3 = r2
            kotlinx.coroutines.M r3 = (kotlinx.coroutines.C2503M) r3
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x0023
            if (r1 == 0) goto L_0x0016
            goto L_0x001a
        L_0x0016:
            kotlinx.coroutines.e0 r1 = r7.m1543a((kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>) r10, (boolean) r8)
        L_0x001a:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r3 = f918a
            boolean r2 = r3.compareAndSet(r7, r2, r1)
            if (r2 == 0) goto L_0x0002
            return r1
        L_0x0023:
            kotlinx.coroutines.j0 r2 = new kotlinx.coroutines.j0
            r2.<init>()
            boolean r4 = r3.isActive()
            if (r4 == 0) goto L_0x002f
            goto L_0x0035
        L_0x002f:
            kotlinx.coroutines.U r4 = new kotlinx.coroutines.U
            r4.<init>(r2)
            r2 = r4
        L_0x0035:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f918a
            r4.compareAndSet(r7, r3, r2)
            goto L_0x0002
        L_0x003b:
            boolean r3 = r2 instanceof kotlinx.coroutines.C2514V
            if (r3 == 0) goto L_0x00b8
            r3 = r2
            kotlinx.coroutines.V r3 = (kotlinx.coroutines.C2514V) r3
            kotlinx.coroutines.j0 r3 = r3.mo21859a()
            if (r3 != 0) goto L_0x0066
            if (r2 == 0) goto L_0x005e
            kotlinx.coroutines.e0 r2 = (kotlinx.coroutines.C2530e0) r2
            kotlinx.coroutines.j0 r3 = new kotlinx.coroutines.j0
            r3.<init>()
            r2.mo35558a((kotlinx.coroutines.internal.C2551i) r3)
            kotlinx.coroutines.internal.i r3 = r2.mo35560d()
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = f918a
            r4.compareAndSet(r7, r2, r3)
            goto L_0x0002
        L_0x005e:
            kotlin.TypeCastException r8 = new kotlin.TypeCastException
            java.lang.String r9 = "null cannot be cast to non-null type kotlinx.coroutines.JobNode<*>"
            r8.<init>(r9)
            throw r8
        L_0x0066:
            kotlinx.coroutines.k0 r4 = kotlinx.coroutines.C2571k0.f4212a
            if (r8 == 0) goto L_0x00a1
            boolean r5 = r2 instanceof kotlinx.coroutines.C1113f0.C1115b
            if (r5 == 0) goto L_0x00a1
            monitor-enter(r2)
            r5 = r2
            kotlinx.coroutines.f0$b r5 = (kotlinx.coroutines.C1113f0.C1115b) r5     // Catch:{ all -> 0x009e }
            java.lang.Throwable r5 = r5.mo21862b()     // Catch:{ all -> 0x009e }
            if (r5 == 0) goto L_0x0085
            boolean r6 = r10 instanceof kotlinx.coroutines.C2570k     // Catch:{ all -> 0x009e }
            if (r6 == 0) goto L_0x009a
            r6 = r2
            kotlinx.coroutines.f0$b r6 = (kotlinx.coroutines.C1113f0.C1115b) r6     // Catch:{ all -> 0x009e }
            boolean r6 = r6.mo21865d()     // Catch:{ all -> 0x009e }
            if (r6 != 0) goto L_0x009a
        L_0x0085:
            if (r1 == 0) goto L_0x0088
            goto L_0x008c
        L_0x0088:
            kotlinx.coroutines.e0 r1 = r7.m1543a((kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>) r10, (boolean) r8)     // Catch:{ all -> 0x009e }
        L_0x008c:
            boolean r4 = r7.m1550a((java.lang.Object) r2, (kotlinx.coroutines.C2569j0) r3, (kotlinx.coroutines.C2530e0<?>) r1)     // Catch:{ all -> 0x009e }
            if (r4 != 0) goto L_0x0095
            monitor-exit(r2)
            goto L_0x0002
        L_0x0095:
            if (r5 != 0) goto L_0x0099
            monitor-exit(r2)
            return r1
        L_0x0099:
            r4 = r1
        L_0x009a:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x009e }
            monitor-exit(r2)
            goto L_0x00a2
        L_0x009e:
            r8 = move-exception
            monitor-exit(r2)
            throw r8
        L_0x00a1:
            r5 = r0
        L_0x00a2:
            if (r5 == 0) goto L_0x00aa
            if (r9 == 0) goto L_0x00a9
            r10.invoke(r5)
        L_0x00a9:
            return r4
        L_0x00aa:
            if (r1 == 0) goto L_0x00ad
            goto L_0x00b1
        L_0x00ad:
            kotlinx.coroutines.e0 r1 = r7.m1543a((kotlin.jvm.functions.Function1<? super java.lang.Throwable, kotlin.Unit>) r10, (boolean) r8)
        L_0x00b1:
            boolean r2 = r7.m1550a((java.lang.Object) r2, (kotlinx.coroutines.C2569j0) r3, (kotlinx.coroutines.C2530e0<?>) r1)
            if (r2 == 0) goto L_0x0002
            return r1
        L_0x00b8:
            if (r9 == 0) goto L_0x00c8
            boolean r8 = r2 instanceof kotlinx.coroutines.C2579p
            if (r8 != 0) goto L_0x00bf
            r2 = r0
        L_0x00bf:
            kotlinx.coroutines.p r2 = (kotlinx.coroutines.C2579p) r2
            if (r2 == 0) goto L_0x00c5
            java.lang.Throwable r0 = r2.f4218a
        L_0x00c5:
            r10.invoke(r0)
        L_0x00c8:
            kotlinx.coroutines.k0 r8 = kotlinx.coroutines.C2571k0.f4212a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.C1113f0.mo21830a(boolean, boolean, kotlin.jvm.functions.Function1):kotlinx.coroutines.L");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final CancellationException mo21837a(Throwable th, String str) {
        CancellationException cancellationException = (CancellationException) (!(th instanceof CancellationException) ? null : th);
        if (cancellationException == null) {
            if (str == null) {
                str = mo21836a();
            }
            cancellationException = new C2524b0(str, th, this);
        }
        return cancellationException;
    }

    /* renamed from: a */
    private final Object m1541a(Object obj, Object obj2) {
        boolean z;
        if (!(obj instanceof C2514V)) {
            return C2533g0.f4149a;
        }
        if ((!(obj instanceof C2503M) && !(obj instanceof C2530e0)) || (obj instanceof C2570k) || ((z = obj2 instanceof C2579p))) {
            return m1552b((C2514V) obj, obj2);
        }
        C2514V v = (C2514V) obj;
        boolean z2 = true;
        if (C2496E.m4305a()) {
            if (!((v instanceof C2503M) || (v instanceof C2530e0))) {
                throw new AssertionError();
            }
        }
        if (!C2496E.m4305a() || (!z)) {
            if (!f918a.compareAndSet(this, v, C2533g0.m4404a(obj2))) {
                z2 = false;
            } else {
                mo21850d(obj2);
                m1547a(v, obj2);
            }
            if (z2) {
                return obj2;
            }
            return C2533g0.f4151c;
        }
        throw new AssertionError();
    }
}
