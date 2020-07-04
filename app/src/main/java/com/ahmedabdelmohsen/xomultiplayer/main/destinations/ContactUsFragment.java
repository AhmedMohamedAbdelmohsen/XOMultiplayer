package com.ahmedabdelmohsen.xomultiplayer.main.destinations;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.ahmedabdelmohsen.xomultiplayer.R;
import com.ahmedabdelmohsen.xomultiplayer.databinding.FragmentContactUsBinding;

public class ContactUsFragment extends Fragment {

    private FragmentContactUsBinding binding;
    private Uri facebookUri, PhoneUri;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentContactUsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //this line for hide statusBar
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        getFaceBookpage();
        getMail();
        getPhone();
        back();
    }

    private void getFaceBookpage() {
        binding.btnFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                facebookUri = Uri.parse("https://www.facebook.com/AhmedM.AbdElmohsen.pro");
                Intent in = new Intent(Intent.ACTION_VIEW, facebookUri);
                startActivity(in);
            }
        });
    }

    private void getPhone() {
        binding.btnPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PhoneUri = Uri.parse("tel:+201066507721");
                Intent Phone = new Intent(Intent.ACTION_DIAL);
                Phone.setData(PhoneUri);
                startActivity(Phone);
            }
        });
    }

    private void getMail() {
        binding.btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SENDTO,
                        Uri.fromParts("mailto", "ahmedmohamedabdelmohsen96@yahoo.com", null));
                startActivity(Intent.createChooser(intent, "Choose an Email client :"));
            }
        });
    }

    private void back() {
        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_contactUsFragment_to_homeFragment2);
            }
        });
    }
}