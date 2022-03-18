package com.example.tp3relativelayoutxml;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;
import static com.example.tp3relativelayoutxml.Utils.dpToPx;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {
    public static final RelativeLayout.LayoutParams PARAMS_MATCH_ALL= new RelativeLayout.LayoutParams(MATCH_PARENT, MATCH_PARENT);

    public static final RelativeLayout.LayoutParams PARAMS_MATCH_HORIZONTAL = new RelativeLayout.LayoutParams(MATCH_PARENT, WRAP_CONTENT);
    public static final RelativeLayout.LayoutParams PARAMS_WRAP = new RelativeLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT);

    private RelativeLayout layout;
    private TextView surnameLabel;
    private EditText surnameText;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = new RelativeLayout(this);
        layout.setLayoutParams(PARAMS_MATCH_ALL);

        Resources resources = getResources();
        layout.setPaddingRelative(dpToPx(10, resources), dpToPx(10, resources), dpToPx(10, resources), dpToPx(10, resources));
        // Surname
        RelativeLayout.LayoutParams surnameParam = new RelativeLayout.LayoutParams(PARAMS_WRAP);
        surnameParam.addRule(RelativeLayout.ALIGN_PARENT_START);
        surnameParam.addRule(RelativeLayout.ALIGN_PARENT_TOP);
        surnameParam.setMargins(0, dpToPx(40, resources),0, 0);
        surnameParam.setMarginStart(dpToPx(16, resources));

        surnameLabel = new TextView(this);
        surnameLabel.setId(View.generateViewId());
        surnameLabel.setLayoutParams(surnameParam);
        surnameLabel.setText(R.string.surname);
        layout.addView(surnameLabel);

        // Surname
        RelativeLayout.LayoutParams surnameTextParam = new RelativeLayout.LayoutParams(PARAMS_MATCH_HORIZONTAL);
        surnameTextParam.addRule(RelativeLayout.END_OF, surnameLabel.getId());
        surnameTextParam.addRule(RelativeLayout.ALIGN_BASELINE, surnameLabel.getId());
        surnameTextParam.setMarginStart(dpToPx(37, resources));

        surnameText = new EditText(this);
        surnameText.setLayoutParams(surnameTextParam);
        surnameText.setHint(R.string.pls_fill_yours_surname);
        surnameText.setEms(10);
        layout.addView(surnameText);
        setContentView(layout);
    }
}
