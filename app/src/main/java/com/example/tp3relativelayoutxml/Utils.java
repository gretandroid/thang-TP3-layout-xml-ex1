package com.example.tp3relativelayoutxml;

import android.content.res.Resources;

public class Utils {

    static int dpToPx(int dp, Resources res) {
        final float scale = res.getDisplayMetrics().density;
        int padding_in_px = (int) (dp * scale + 0.5f);
        return padding_in_px;
    }
}
