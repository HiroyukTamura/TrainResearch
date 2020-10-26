/*
 * Decompiled with CFR 0.139.
 */
package kotlin.i;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.g;
import kotlin.a.m;
import kotlin.e.b.j;
import kotlin.e.b.k;
import kotlin.h.h;
import kotlin.h.i;
import kotlin.i.e;
import kotlin.i.n;
import kotlin.i.v;
import kotlin.o;
import kotlin.s;

@Metadata(bv={1, 0, 2}, d1={"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\f\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0086\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002\u00a2\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002\u00a2\u0006\u0002\b\"\u001a&\u0010 \u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010$\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010$\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010'\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010(\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0002H\u0087\b\u001a \u0010*\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u0010+\u001a\u00020\r*\u0004\u0018\u00010\u0002H\u0087\b\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u0010,\u001a\u00020-*\u00020\u0002H\u0086\u0002\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010.\u001a\u00020\u0006*\u00020\u00022\u0006\u0010#\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010/\u001a\u00020\u0006*\u00020\u00022\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010/\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00100\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u0002\u001a\u0010\u00102\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u0002\u001a\u0015\u00104\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0087\f\u001a\u000f\u00105\u001a\u00020\n*\u0004\u0018\u00010\nH\u0087\b\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00106\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001a\u001c\u00109\u001a\u00020\n*\u00020\n2\u0006\u00107\u001a\u00020\u00062\b\b\u0002\u00108\u001a\u00020\u0011\u001aG\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u000e\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002\u00a2\u0006\u0004\b>\u0010?\u001a=\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000101*\u00020\u00022\u0006\u0010;\u001a\u00020&2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\b>\u001a4\u0010@\u001a\u00020\r*\u00020\u00022\u0006\u0010A\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010B\u001a\u00020\u00062\u0006\u00107\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010C\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u0002\u001a\u0012\u0010C\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u0002\u001a\u001a\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006\u001a\u0012\u0010E\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u0006H\u0087\b\u001a\u0015\u0010E\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001H\u0087\b\u001a\u0012\u0010G\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010G\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\u0002*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u0002\u001a\u001a\u0010H\u001a\u00020\n*\u00020\n2\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010K\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020\u00020LH\u0087\b\u001a\u001d\u0010J\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\u0087\b\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010Q\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010R\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a$\u0010S\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\u0006\u0010N\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001d\u0010T\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010N\u001a\u00020\nH\u0087\b\u001a\"\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002\u001a\u001a\u0010U\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002\u001a%\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010N\u001a\u00020\u0002H\u0087\b\u001a\u001d\u0010U\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0002H\u0087\b\u001a=\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u00a2\u0006\u0002\u0010W\u001a0\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a/\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010I\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010=\u001a\u00020\u0006H\u0002\u00a2\u0006\u0002\bX\u001a%\u0010V\u001a\b\u0012\u0004\u0012\u00020\n03*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010=\u001a\u00020\u0006H\u0087\b\u001a=\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\u0012\u0010;\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0<\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u00a2\u0006\u0002\u0010Z\u001a0\u0010Y\u001a\b\u0012\u0004\u0012\u00020\n01*\u00020\u00022\n\u0010;\u001a\u00020&\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010=\u001a\u00020\u0006\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010[\u001a\u00020\r*\u00020\u00022\u0006\u0010D\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u001d\u0010\\\u001a\u00020\u0002*\u00020\n2\u0006\u0010]\u001a\u00020\u00062\u0006\u0010^\u001a\u00020\u0006H\u0087\b\u001a\u001f\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010!\u001a\u00020\u0006H\u0087\b\u001a\u0012\u0010_\u001a\u00020\n*\u00020\u00022\u0006\u0010F\u001a\u00020\u0001\u001a\u0012\u0010_\u001a\u00020\n*\u00020\n2\u0006\u0010F\u001a\u00020\u0001\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010`\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010a\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010b\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\u00112\b\b\u0002\u0010P\u001a\u00020\n\u001a\u001c\u0010c\u001a\u00020\n*\u00020\n2\u0006\u0010I\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020\n\u001a\n\u0010d\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010d\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010d\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010d\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010d\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010d\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010f\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010f\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010f\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010f\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010f\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010f\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\n\u0010g\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010g\u001a\u00020\u0002*\u00020\u00022\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010g\u001a\u00020\u0002*\u00020\u00022\n\u0010%\u001a\u00020&\"\u00020\u0011\u001a\r\u0010g\u001a\u00020\n*\u00020\nH\u0087\b\u001a!\u0010g\u001a\u00020\n*\u00020\n2\u0012\u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0LH\u0086\b\u001a\u0016\u0010g\u001a\u00020\n*\u00020\n2\n\u0010%\u001a\u00020&\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F\u00a2\u0006\u0006\u001a\u0004\b\u0007\u0010\b\u00a8\u0006h"}, d2={"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", "other", "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", "index", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, k=5, mv={1, 1, 11}, xi=1, xs="kotlin/text/StringsKt")
class w
extends v {
    public static final int a(CharSequence charSequence, char c2, int n2, boolean bl2) {
        j.b(charSequence, "$receiver");
        if (!bl2 && charSequence instanceof String) {
            return ((String)charSequence).indexOf(c2, n2);
        }
        return n.a(charSequence, new char[]{c2}, n2, bl2);
    }

    public static /* bridge */ /* synthetic */ int a(CharSequence charSequence, char c2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return n.a(charSequence, c2, n2, bl2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int n2, int n3, boolean bl2, boolean bl3) {
        kotlin.g.a a2 = !bl3 ? (kotlin.g.a)new kotlin.g.c(kotlin.g.d.c(n2, 0), kotlin.g.d.d(n3, charSequence.length())) : kotlin.g.d.a(kotlin.g.d.d(n2, n.c(charSequence)), kotlin.g.d.c(n3, 0));
        if (charSequence instanceof String && charSequence2 instanceof String) {
            n2 = a2.a();
            n3 = a2.b();
            int n4 = a2.c();
            if (n4 > 0 ? n2 <= n3 : n2 >= n3) {
                do {
                    if (n.a((String)charSequence2, 0, (String)charSequence, n2, charSequence2.length(), bl2)) {
                        return n2;
                    }
                    if (n2 != n3) {
                        n2 += n4;
                        continue;
                    }
                    break;
                } while (true);
            }
        } else {
            n2 = a2.a();
            n3 = a2.b();
            int n5 = a2.c();
            if (n5 > 0 ? n2 <= n3 : n2 >= n3) {
                do {
                    if (n.a(charSequence2, 0, charSequence, n2, charSequence2.length(), bl2)) {
                        return n2;
                    }
                    if (n2 == n3) break;
                    n2 += n5;
                } while (true);
            }
        }
        return -1;
    }

    static /* bridge */ /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int n2, int n3, boolean bl2, boolean bl3, int n4, Object object) {
        block0 : {
            if ((n4 & 16) == 0) break block0;
            bl3 = false;
        }
        return w.a(charSequence, charSequence2, n2, n3, bl2, bl3);
    }

    public static final int a(CharSequence charSequence, String string2, int n2, boolean bl2) {
        j.b(charSequence, "$receiver");
        j.b(string2, "string");
        if (!bl2 && charSequence instanceof String) {
            return ((String)charSequence).indexOf(string2, n2);
        }
        return w.a(charSequence, string2, n2, charSequence.length(), bl2, false, 16, null);
    }

    public static /* bridge */ /* synthetic */ int a(CharSequence charSequence, String string2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = 0;
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return n.a(charSequence, string2, n2, bl2);
    }

    public static final int a(CharSequence charSequence, char[] arrc, int n2, boolean bl2) {
        int n3;
        j.b(charSequence, "$receiver");
        j.b(arrc, "chars");
        if (!bl2 && arrc.length == 1 && charSequence instanceof String) {
            char c2 = g.a(arrc);
            return ((String)charSequence).indexOf(c2, n2);
        }
        if ((n2 = kotlin.g.d.c(n2, 0)) <= (n3 = n.c(charSequence))) {
            do {
                int n4;
                block5 : {
                    char c3 = charSequence.charAt(n2);
                    int n5 = arrc.length;
                    for (n4 = 0; n4 < n5; ++n4) {
                        if (!kotlin.i.a.a(arrc[n4], c3, bl2)) continue;
                        n4 = 1;
                        break block5;
                    }
                    n4 = 0;
                }
                if (n4 != 0) {
                    return n2;
                }
                if (n2 == n3) break;
                ++n2;
            } while (true);
        }
        return -1;
    }

    public static final String a(CharSequence charSequence, kotlin.g.c c2) {
        j.b(charSequence, "$receiver");
        j.b(c2, "range");
        return ((Object)charSequence.subSequence(c2.f(), c2.g() + 1)).toString();
    }

    public static final String a(String string2, char c2, String string3) {
        j.b(string2, "$receiver");
        j.b(string3, "missingDelimiterValue");
        int n2 = n.a((CharSequence)string2, c2, 0, false, 6, null);
        if (n2 == -1) {
            return string3;
        }
        string2 = string2.substring(0, n2);
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* bridge */ /* synthetic */ String a(String string2, char c2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string2;
        }
        return n.a(string2, c2, string3);
    }

    public static final String a(String string2, CharSequence charSequence) {
        j.b(string2, "$receiver");
        j.b(charSequence, "prefix");
        String string3 = string2;
        if (n.a((CharSequence)string2, charSequence, false, 2, null)) {
            string3 = string2.substring(charSequence.length());
            j.a((Object)string3, "(this as java.lang.String).substring(startIndex)");
        }
        return string3;
    }

    public static final String a(String string2, String string3, String string4) {
        j.b(string2, "$receiver");
        j.b(string3, "delimiter");
        j.b(string4, "missingDelimiterValue");
        int n2 = n.a((CharSequence)string2, string3, 0, false, 6, null);
        if (n2 == -1) {
            return string4;
        }
        string2 = string2.substring(0, n2);
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* bridge */ /* synthetic */ String a(String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string4 = string2;
        }
        return n.a(string2, string3, string4);
    }

    private static final List<String> a(CharSequence charSequence, String string2, boolean bl2, int n2) {
        int n3 = 0;
        boolean bl3 = n2 >= 0;
        if (bl3) {
            int n4 = n.a(charSequence, string2, 0, bl2);
            if (n4 != -1 && n2 != 1) {
                int n5;
                bl3 = n2 > 0;
                int n6 = 10;
                if (bl3) {
                    n6 = kotlin.g.d.d(n2, 10);
                }
                ArrayList<String> arrayList = new ArrayList<String>(n6);
                n6 = n4;
                do {
                    arrayList.add(((Object)charSequence.subSequence(n3, n6)).toString());
                    n4 = string2.length() + n6;
                    if (bl3 && arrayList.size() == n2 - 1) break;
                    n5 = n.a(charSequence, string2, n4, bl2);
                    n3 = n4;
                    n6 = n5;
                } while (n5 != -1);
                arrayList.add(((Object)charSequence.subSequence(n4, charSequence.length())).toString());
                return arrayList;
            }
            return m.a(((Object)charSequence).toString());
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n2);
        ((StringBuilder)charSequence).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)charSequence).toString().toString());
    }

    private static final h<kotlin.g.c> a(CharSequence charSequence, final char[] arrc, int n2, final boolean bl2, int n3) {
        boolean bl3 = n3 >= 0;
        if (bl3) {
            return new e(charSequence, n2, n3, (kotlin.e.a.m<? super CharSequence, ? super Integer, o<Integer, Integer>>)new kotlin.e.a.m<CharSequence, Integer, o<? extends Integer, ? extends Integer>>(){

                @Override
                public /* synthetic */ Object a(Object object, Object object2) {
                    return this.a((CharSequence)object, ((Number)object2).intValue());
                }

                @Override
                public final o<Integer, Integer> a(CharSequence charSequence, int n2) {
                    j.b(charSequence, "$receiver");
                    n2 = n.a(charSequence, arrc, n2, bl2);
                    if (n2 < 0) {
                        return null;
                    }
                    return s.a(n2, 1);
                }
            });
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n3);
        ((StringBuilder)charSequence).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)charSequence).toString().toString());
    }

    static /* bridge */ /* synthetic */ h a(CharSequence charSequence, char[] arrc, int n2, boolean bl2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) != 0) {
            bl2 = false;
        }
        if ((n4 & 8) != 0) {
            n3 = 0;
        }
        return w.a(charSequence, arrc, n2, bl2, n3);
    }

    public static final h<String> a(final CharSequence charSequence, char[] arrc, boolean bl2, int n2) {
        j.b(charSequence, "$receiver");
        j.b(arrc, "delimiters");
        return i.e(w.a(charSequence, arrc, 0, bl2, n2, 2, null), (kotlin.e.a.b)new kotlin.e.a.b<kotlin.g.c, String>(){

            @Override
            public final String a(kotlin.g.c c2) {
                j.b(c2, "it");
                return n.a(charSequence, c2);
            }
        });
    }

    public static /* bridge */ /* synthetic */ h a(CharSequence charSequence, char[] arrc, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return n.a(charSequence, arrc, bl2, n2);
    }

    private static final h<kotlin.g.c> a(CharSequence charSequence, String[] arrstring, int n2, boolean bl2, int n3) {
        boolean bl3 = n3 >= 0;
        if (bl3) {
            return new e(charSequence, n2, n3, (kotlin.e.a.m<? super CharSequence, ? super Integer, o<Integer, Integer>>)new kotlin.e.a.m<CharSequence, Integer, o<? extends Integer, ? extends Integer>>(g.a(arrstring), bl2){
                final /* synthetic */ List a;
                final /* synthetic */ boolean b;
                {
                    this.a = list;
                    this.b = bl2;
                    super(2);
                }

                @Override
                public /* synthetic */ Object a(Object object, Object object2) {
                    return this.a((CharSequence)object, ((Number)object2).intValue());
                }

                @Override
                public final o<Integer, Integer> a(CharSequence object, int n2) {
                    j.b(object, "$receiver");
                    object = w.b((CharSequence)object, this.a, n2, this.b, false);
                    if (object != null) {
                        return s.a(((o)object).a(), ((String)((o)object).b()).length());
                    }
                    return null;
                }
            });
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Limit must be non-negative, but was ");
        ((StringBuilder)charSequence).append(n3);
        ((StringBuilder)charSequence).append('.');
        throw (Throwable)new IllegalArgumentException(((StringBuilder)charSequence).toString().toString());
    }

    static /* bridge */ /* synthetic */ h a(CharSequence charSequence, String[] arrstring, int n2, boolean bl2, int n3, int n4, Object object) {
        if ((n4 & 2) != 0) {
            n2 = 0;
        }
        if ((n4 & 4) != 0) {
            bl2 = false;
        }
        if ((n4 & 8) != 0) {
            n3 = 0;
        }
        return w.a(charSequence, arrstring, n2, bl2, n3);
    }

    public static final h<String> a(final CharSequence charSequence, String[] arrstring, boolean bl2, int n2) {
        j.b(charSequence, "$receiver");
        j.b(arrstring, "delimiters");
        return i.e(w.a(charSequence, arrstring, 0, bl2, n2, 2, null), (kotlin.e.a.b)new kotlin.e.a.b<kotlin.g.c, String>(){

            @Override
            public final String a(kotlin.g.c c2) {
                j.b(c2, "it");
                return n.a(charSequence, c2);
            }
        });
    }

    public static /* bridge */ /* synthetic */ h a(CharSequence charSequence, String[] arrstring, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return n.a(charSequence, arrstring, bl2, n2);
    }

    public static final boolean a(CharSequence charSequence, char c2, boolean bl2) {
        boolean bl3;
        j.b(charSequence, "$receiver");
        int n2 = charSequence.length();
        boolean bl4 = bl3 = false;
        if (n2 > 0) {
            bl4 = bl3;
            if (kotlin.i.a.a(charSequence.charAt(0), c2, bl2)) {
                bl4 = true;
            }
        }
        return bl4;
    }

    public static /* bridge */ /* synthetic */ boolean a(CharSequence charSequence, char c2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return n.a(charSequence, c2, bl2);
    }

    public static final boolean a(CharSequence charSequence, int n2, CharSequence charSequence2, int n3, int n4, boolean bl2) {
        j.b(charSequence, "$receiver");
        j.b(charSequence2, "other");
        if (n3 >= 0 && n2 >= 0 && n2 <= charSequence.length() - n4) {
            if (n3 > charSequence2.length() - n4) {
                return false;
            }
            for (int i2 = 0; i2 < n4; ++i2) {
                if (kotlin.i.a.a(charSequence.charAt(n2 + i2), charSequence2.charAt(n3 + i2), bl2)) continue;
                return false;
            }
            return true;
        }
        return false;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        j.b(charSequence, "$receiver");
        j.b(charSequence2, "prefix");
        if (!bl2 && charSequence instanceof String && charSequence2 instanceof String) {
            return n.a((String)charSequence, (String)charSequence2, false, 2, null);
        }
        return n.a(charSequence, 0, charSequence2, 0, charSequence2.length(), bl2);
    }

    public static /* bridge */ /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return n.a(charSequence, charSequence2, bl2);
    }

    public static final int b(CharSequence charSequence, char c2, int n2, boolean bl2) {
        j.b(charSequence, "$receiver");
        if (!bl2 && charSequence instanceof String) {
            return ((String)charSequence).lastIndexOf(c2, n2);
        }
        return n.b(charSequence, new char[]{c2}, n2, bl2);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = n.c(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return n.b(charSequence, c2, n2, bl2);
    }

    public static final int b(CharSequence charSequence, String string2, int n2, boolean bl2) {
        j.b(charSequence, "$receiver");
        j.b(string2, "string");
        if (!bl2 && charSequence instanceof String) {
            return ((String)charSequence).lastIndexOf(string2, n2);
        }
        return w.a(charSequence, (CharSequence)string2, n2, 0, bl2, true);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String string2, int n2, boolean bl2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            n2 = n.c(charSequence);
        }
        if ((n3 & 4) != 0) {
            bl2 = false;
        }
        return n.b(charSequence, string2, n2, bl2);
    }

    public static final int b(CharSequence charSequence, char[] arrc, int n2, boolean bl2) {
        j.b(charSequence, "$receiver");
        j.b(arrc, "chars");
        if (!bl2 && arrc.length == 1 && charSequence instanceof String) {
            char c2 = g.a(arrc);
            return ((String)charSequence).lastIndexOf(c2, n2);
        }
        for (n2 = kotlin.g.d.d((int)n2, (int)n.c((CharSequence)charSequence)); n2 >= 0; --n2) {
            boolean bl3;
            char c3 = charSequence.charAt(n2);
            int n3 = arrc.length;
            boolean bl4 = false;
            int n4 = 0;
            do {
                bl3 = bl4;
                if (n4 >= n3) break;
                if (kotlin.i.a.a(arrc[n4], c3, bl2)) {
                    bl3 = true;
                    break;
                }
                ++n4;
            } while (true);
            if (!bl3) continue;
            return n2;
        }
        return -1;
    }

    public static final String b(String string2, char c2, String string3) {
        j.b(string2, "$receiver");
        j.b(string3, "missingDelimiterValue");
        int n2 = n.a((CharSequence)string2, c2, 0, false, 6, null);
        if (n2 == -1) {
            return string3;
        }
        string2 = string2.substring(n2 + 1, string2.length());
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* bridge */ /* synthetic */ String b(String string2, char c2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string2;
        }
        return n.b(string2, c2, string3);
    }

    public static final String b(String string2, String string3, String string4) {
        j.b(string2, "$receiver");
        j.b(string3, "delimiter");
        j.b(string4, "missingDelimiterValue");
        int n2 = n.a((CharSequence)string2, string3, 0, false, 6, null);
        if (n2 == -1) {
            return string4;
        }
        string2 = string2.substring(n2 + string3.length(), string2.length());
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* bridge */ /* synthetic */ String b(String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string4 = string2;
        }
        return n.b(string2, string3, string4);
    }

    public static final List<String> b(CharSequence charSequence, String[] object, boolean bl2, int n2) {
        Object object2;
        j.b(charSequence, "$receiver");
        j.b(object, "delimiters");
        if (((String[])object).length == 1) {
            boolean bl3 = false;
            object2 = object[0];
            if (((CharSequence)object2).length() == 0) {
                bl3 = true;
            }
            if (!bl3) {
                return w.a(charSequence, (String)object2, bl2, n2);
            }
        }
        object2 = i.h(w.a(charSequence, (String[])object, 0, bl2, n2, 2, null));
        object = new ArrayList(m.a(object2, 10));
        object2 = object2.iterator();
        while (object2.hasNext()) {
            object.add(n.a(charSequence, (kotlin.g.c)object2.next()));
        }
        return (List)object;
    }

    public static /* bridge */ /* synthetic */ List b(CharSequence charSequence, String[] arrstring, boolean bl2, int n2, int n3, Object object) {
        if ((n3 & 2) != 0) {
            bl2 = false;
        }
        if ((n3 & 4) != 0) {
            n2 = 0;
        }
        return n.b(charSequence, arrstring, bl2, n2);
    }

    public static final kotlin.g.c b(CharSequence charSequence) {
        j.b(charSequence, "$receiver");
        return new kotlin.g.c(0, charSequence.length() - 1);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static final o<Integer, String> b(CharSequence object, Collection<String> object2, int n2, boolean bl2, boolean bl3) {
        if (!bl2 && object2.size() == 1) {
            object2 = (String)m.f((Iterable)object2);
            n2 = !bl3 ? n.a((CharSequence)object, (String)object2, n2, false, 4, null) : n.b((CharSequence)object, (String)object2, n2, false, 4, null);
            if (n2 >= 0) return s.a(n2, object2);
            return null;
        }
        Object object32 = !bl3 ? (kotlin.g.a)new kotlin.g.c(kotlin.g.d.c(n2, 0), object.length()) : kotlin.g.d.a(kotlin.g.d.d(n2, n.c((CharSequence)object)), 0);
        if (object instanceof String) {
            n2 = ((kotlin.g.a)object32).a();
            int n3 = ((kotlin.g.a)object32).b();
            int n4 = ((kotlin.g.a)object32).c();
            if (!(n4 > 0 ? n2 <= n3 : n2 >= n3)) return null;
            do {
                block9 : {
                    for (Object object32 : (Iterable)object2) {
                        String string2 = (String)object32;
                        if (!n.a(string2, 0, (String)object, n2, string2.length(), bl2)) continue;
                        break block9;
                    }
                    object32 = null;
                }
                object32 = (String)object32;
                if (object32 != null) {
                    object = object32;
                    do {
                        return s.a(n2, object);
                        break;
                    } while (true);
                }
                if (n2 == n3) return null;
                n2 += n4;
            } while (true);
        }
        n2 = ((kotlin.g.a)object32).a();
        int n5 = ((kotlin.g.a)object32).b();
        int n6 = ((kotlin.g.a)object32).c();
        if (!(n6 > 0 ? n2 <= n5 : n2 >= n5)) return null;
        do {
            block10 : {
                for (Object object32 : (Iterable)object2) {
                    String string3 = (String)object32;
                    if (!n.a((CharSequence)string3, 0, (CharSequence)object, n2, string3.length(), bl2)) continue;
                    break block10;
                }
                object32 = null;
            }
            object32 = (String)object32;
            if (object32 != null) {
                object = object32;
                return s.a(n2, object);
            }
            if (n2 == n5) return null;
            n2 += n6;
        } while (true);
    }

    public static final boolean b(CharSequence charSequence, char c2, boolean bl2) {
        j.b(charSequence, "$receiver");
        return charSequence.length() > 0 && kotlin.i.a.a(charSequence.charAt(n.c(charSequence)), c2, bl2);
    }

    public static /* bridge */ /* synthetic */ boolean b(CharSequence charSequence, char c2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return n.b(charSequence, c2, bl2);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static final boolean b(CharSequence charSequence, CharSequence charSequence2, boolean bl2) {
        j.b(charSequence, "$receiver");
        j.b(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (n.a(charSequence, (String)charSequence2, 0, bl2, 2, null) < 0) return false;
            return true;
        }
        if (w.a(charSequence, charSequence2, 0, charSequence.length(), bl2, false, 16, null) < 0) return false;
        return true;
    }

    public static /* bridge */ /* synthetic */ boolean b(CharSequence charSequence, CharSequence charSequence2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return n.b(charSequence, charSequence2, bl2);
    }

    public static final int c(CharSequence charSequence) {
        j.b(charSequence, "$receiver");
        return charSequence.length() - 1;
    }

    public static final String c(String string2, char c2, String string3) {
        j.b(string2, "$receiver");
        j.b(string3, "missingDelimiterValue");
        int n2 = n.b((CharSequence)string2, c2, 0, false, 6, null);
        if (n2 == -1) {
            return string3;
        }
        string2 = string2.substring(0, n2);
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* synthetic */ String c(String string2, char c2, String string3, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string3 = string2;
        }
        return n.d(string2, c2, string3);
    }

    public static final String c(String string2, String string3, String string4) {
        j.b(string2, "$receiver");
        j.b(string3, "delimiter");
        j.b(string4, "missingDelimiterValue");
        int n2 = n.b((CharSequence)string2, string3, 0, false, 6, null);
        if (n2 == -1) {
            return string4;
        }
        string2 = string2.substring(0, n2);
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static /* synthetic */ String c(String string2, String string3, String string4, int n2, Object object) {
        if ((n2 & 2) != 0) {
            string4 = string2;
        }
        return n.d(string2, string3, string4);
    }

    public static final boolean c(CharSequence charSequence, char c2, boolean bl2) {
        j.b(charSequence, "$receiver");
        return n.a(charSequence, c2, 0, bl2, 2, null) >= 0;
    }

    public static /* bridge */ /* synthetic */ boolean c(CharSequence charSequence, char c2, boolean bl2, int n2, Object object) {
        if ((n2 & 2) != 0) {
            bl2 = false;
        }
        return n.c(charSequence, c2, bl2);
    }

    public static final String d(String string2, char c2, String string3) {
        j.b(string2, "$receiver");
        j.b(string3, "missingDelimiterValue");
        int n2 = n.b((CharSequence)string2, c2, 0, false, 6, null);
        if (n2 == -1) {
            return string3;
        }
        string2 = string2.substring(n2 + 1, string2.length());
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

    public static final String d(String string2, String string3, String string4) {
        j.b(string2, "$receiver");
        j.b(string3, "delimiter");
        j.b(string4, "missingDelimiterValue");
        int n2 = n.b((CharSequence)string2, string3, 0, false, 6, null);
        if (n2 == -1) {
            return string4;
        }
        string2 = string2.substring(n2 + string3.length(), string2.length());
        j.a((Object)string2, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
        return string2;
    }

}

