package sg.edu.rp.c346.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag1 extends Fragment {

    Button btnColor;
    ImageView iv;
    LinearLayout linearLayout1;
    Integer i = 0;

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
        iv = view.findViewById(R.id.iv);

        String imageURL = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQV4t002yQboQAUcFodz7Ek8pqOMQyg5ArvMiwBlFJ9dmy6fg4I";

        Picasso.with(getActivity()).load(imageURL).into(iv);

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if ( i == 0){
                    linearLayout1.setBackgroundColor(Color.MAGENTA);
                    i = 1;
                } else {

                    linearLayout1.setBackgroundColor(Color.parseColor("#33B5E5"));
                    i = 0;
                }
            }
        });

        return view;

    }


}
