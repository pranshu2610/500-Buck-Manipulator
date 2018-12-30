package com.unity3d.player;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

/* renamed from: com.unity3d.player.k */
public final class C0050k extends Dialog implements TextWatcher, OnClickListener {
    /* renamed from: c */
    private static int f152c = 1627389952;
    /* renamed from: d */
    private static int f153d = -1;
    /* renamed from: e */
    private static int f154e = 134217728;
    /* renamed from: f */
    private static int f155f = 67108864;
    /* renamed from: a */
    private Context f156a = null;
    /* renamed from: b */
    private UnityPlayer f157b = null;

    /* renamed from: com.unity3d.player.k$1 */
    class C00471 implements OnFocusChangeListener {
        /* renamed from: a */
        final /* synthetic */ C0050k f149a;

        C00471(C0050k c0050k) {
            this.f149a = c0050k;
        }

        public final void onFocusChange(View view, boolean z) {
            if (z) {
                this.f149a.getWindow().setSoftInputMode(5);
            }
        }
    }

    /* renamed from: com.unity3d.player.k$3 */
    class C00493 implements OnEditorActionListener {
        /* renamed from: a */
        final /* synthetic */ C0050k f151a;

        C00493(C0050k c0050k) {
            this.f151a = c0050k;
        }

        public final boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i == 6) {
                this.f151a.m66a(this.f151a.m62a(), false);
            }
            return false;
        }
    }

    public C0050k(Context context, UnityPlayer unityPlayer, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        super(context);
        this.f156a = context;
        this.f157b = unityPlayer;
        getWindow().setGravity(80);
        getWindow().requestFeature(1);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        setContentView(createSoftInputView());
        getWindow().setLayout(-1, -2);
        getWindow().clearFlags(2);
        if (C0046j.f145a) {
            getWindow().clearFlags(f154e);
            getWindow().clearFlags(f155f);
        }
        EditText editText = (EditText) findViewById(1057292289);
        Button button = (Button) findViewById(1057292290);
        m64a(editText, str, i, z, z2, z3, str2, i2);
        button.setOnClickListener(this);
        editText.setOnFocusChangeListener(new C00471(this));
    }

    /* renamed from: a */
    private static int m61a(int i, boolean z, boolean z2, boolean z3) {
        int i2 = 0;
        int i3 = (z2 ? 131072 : 0) | (z ? 32768 : 524288);
        if (z3) {
            i2 = 128;
        }
        i2 |= i3;
        if (i < 0 || i > 10) {
            return i2;
        }
        int[] iArr = new int[]{1, 16385, 12290, 17, 2, 3, 8289, 33, 1, 16417, 17};
        return (iArr[i] & 2) != 0 ? iArr[i] : i2 | iArr[i];
    }

    /* renamed from: a */
    private String m62a() {
        EditText editText = (EditText) findViewById(1057292289);
        return editText == null ? null : editText.getText().toString().trim();
    }

    /* renamed from: a */
    private void m64a(EditText editText, String str, int i, boolean z, boolean z2, boolean z3, String str2, int i2) {
        editText.setImeOptions(6);
        editText.setText(str);
        editText.setHint(str2);
        editText.setHintTextColor(f152c);
        editText.setInputType(C0050k.m61a(i, z, z2, z3));
        editText.setImeOptions(33554432);
        if (i2 > 0) {
            editText.setFilters(new InputFilter[]{new LengthFilter(i2)});
        }
        editText.addTextChangedListener(this);
        editText.setSelection(editText.getText().length());
        editText.setClickable(true);
    }

    /* renamed from: a */
    private void m66a(String str, boolean z) {
        ((EditText) findViewById(1057292289)).setSelection(0, 0);
        this.f157b.reportSoftInputStr(str, 1, z);
    }

    /* renamed from: a */
    public final void m68a(int i) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText == null) {
            return;
        }
        if (i > 0) {
            editText.setFilters(new InputFilter[]{new LengthFilter(i)});
            return;
        }
        editText.setFilters(new InputFilter[0]);
    }

    /* renamed from: a */
    public final void m69a(String str) {
        EditText editText = (EditText) findViewById(1057292289);
        if (editText != null) {
            editText.setText(str);
            editText.setSelection(str.length());
        }
    }

    public final void afterTextChanged(Editable editable) {
        this.f157b.reportSoftInputStr(editable.toString(), 0, false);
    }

    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    protected final View createSoftInputView() {
        View relativeLayout = new RelativeLayout(this.f156a);
        relativeLayout.setLayoutParams(new LayoutParams(-1, -1));
        relativeLayout.setBackgroundColor(f153d);
        View c00482 = new EditText(this, this.f156a) {
            /* renamed from: a */
            final /* synthetic */ C0050k f150a;

            public final boolean onKeyPreIme(int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return i != 84 ? super.onKeyPreIme(i, keyEvent) : true;
                } else {
                    this.f150a.m66a(this.f150a.m62a(), true);
                    return true;
                }
            }

            public final void onWindowFocusChanged(boolean z) {
                super.onWindowFocusChanged(z);
                if (z) {
                    ((InputMethodManager) this.f150a.f156a.getSystemService("input_method")).showSoftInput(this, 0);
                }
            }
        };
        LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(0, 1057292290);
        c00482.setLayoutParams(layoutParams);
        c00482.setId(1057292289);
        relativeLayout.addView(c00482);
        c00482 = new Button(this.f156a);
        c00482.setText(this.f156a.getResources().getIdentifier("ok", "string", "android"));
        layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(15);
        layoutParams.addRule(11);
        c00482.setLayoutParams(layoutParams);
        c00482.setId(1057292290);
        c00482.setBackgroundColor(0);
        relativeLayout.addView(c00482);
        ((EditText) relativeLayout.findViewById(1057292289)).setOnEditorActionListener(new C00493(this));
        relativeLayout.setPadding(16, 16, 16, 16);
        return relativeLayout;
    }

    public final void onBackPressed() {
        m66a(m62a(), true);
    }

    public final void onClick(View view) {
        m66a(m62a(), false);
    }

    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
