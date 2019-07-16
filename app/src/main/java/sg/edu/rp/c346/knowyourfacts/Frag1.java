package sg.edu.rp.c346.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btnColor;
    LinearLayout linearLayout1;

    public Frag1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_1, container, false);

        btnColor = view.findViewById(R.id.btnColor);
        linearLayout1 = view.findViewById(R.id.linearlayout1);

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayout1.setBackgroundColor(Color.MAGENTA);
            }
        });

        return view;

    }


}
