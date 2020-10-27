package p009e.p028d.p029a;

/* renamed from: e.d.a.a */
public enum C0871a {
    INVALID_REQUEST("Invalid Ad request."),
    NO_FILL("Ad request successful, but no ad returned due to lack of ad inventory."),
    NETWORK_ERROR("A network error occurred."),
    INTERNAL_ERROR("There was an internal error.");
    

    /* renamed from: a */
    private final String f513a;

    private C0871a(String str) {
        this.f513a = str;
    }

    /* renamed from: a */
    public static C0871a[] m1142a() {
        return (C0871a[]) f512f.clone();
    }

    public final String toString() {
        return this.f513a;
    }
}
