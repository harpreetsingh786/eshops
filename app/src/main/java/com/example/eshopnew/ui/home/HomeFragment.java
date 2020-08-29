package com.example.eshopnew.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.eshopnew.LoginActivity;
import com.example.eshopnew.MainActivity;
import com.example.eshopnew.R;

public class HomeFragment extends Fragment {
    ViewFlipper viewFlipper;
    public Button btn;
    public Button bt2;

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);


        viewFlipper=root.findViewById(R.id.VFLIPPER);

        int images []={R.drawable.laptopspics,R.drawable.deals,R.drawable.smartwatchesimages,R.drawable.pixel};

        for (int i=0;i<images.length;i++)
        {
            imagesFlipper(images[i]);

        }




        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        //final TextView textView = root.findViewById(R.id.text_home);
        btn=root.findViewById(R.id.button);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });
        return root;
    }

    public  void imagesFlipper(int image)
    {
        ImageView imageView=new ImageView(getActivity());
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(getActivity(),android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(getActivity(),android.R.anim.slide_out_right);

    }

}
