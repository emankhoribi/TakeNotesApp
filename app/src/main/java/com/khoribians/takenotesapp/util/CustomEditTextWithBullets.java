package com.khoribians.takenotesapp.util;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;

/**
 * Created by aashish on 8/10/16.
 */
public class CustomEditTextWithBullets extends AppCompatEditText {

    Context mContext;
    Typeface mTypeface;

    public CustomEditTextWithBullets(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
    }

    public CustomEditTextWithBullets(Context context, AttributeSet attrs) {
        this(context, attrs, androidx.appcompat.R.attr.editTextStyle);
    }

    public CustomEditTextWithBullets(Context context) {
        this(context, null, androidx.appcompat.R.attr.editTextStyle);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        if (lengthAfter > lengthBefore) {
            if (text.toString().length() == 1) {
                text = "• " + text;
                setText(text);
                setSelection(getText().length());
            }
            if (text.toString().endsWith("\n")) {
                text = text.toString().replace("\n", "\n• ");
                text = text.toString().replace("• •", "•");
                setText(text);
                setSelection(getText().length());
            }
        }
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
    }

}