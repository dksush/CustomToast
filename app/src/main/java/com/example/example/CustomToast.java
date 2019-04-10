package com.example.example;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CustomToast {



    public static void showToast(Context context, String msg) {
        if (null == context)
            return;

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.custom_toast, null); // 인플레이터로 어디서나 쓸수 있게 뷰를 받아온다.
        TextView textView = view.findViewById(R.id.txt_toast);
        textView.setText(msg);
        Toast toast = new Toast(context);

        if (context instanceof MainActivity) { // 해당 컨텍스트(현재 위치한 액티비티가) 메인 엑티비티라면
            toast.setGravity(Gravity.BOTTOM, 0, convertDpToPx(context, 59));
        }else {
            toast.setGravity(Gravity.BOTTOM, 0, convertDpToPx(context, 3));
        }

        toast.setDuration(Toast.LENGTH_SHORT); // 토스트 지속시간 2초.
        toast.setView(view);
        toast.show();
    }


    // 디비를 픽셀값으로 변환
    // 자바단에서 ui 크기를 변경할 경우 사용. 자바단에선 dp를 사용하지 못하기에 픽셀값으로 바꾸어 주어야 한다.
    public static int convertDpToPx(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return (int) Math.round(dp * density + 0.5);
    }

}

