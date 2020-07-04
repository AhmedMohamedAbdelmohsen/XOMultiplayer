package com.ahmedabdelmohsen.xomultiplayer.main.destinations;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.ahmedabdelmohsen.xomultiplayer.PlayWithFriend;
import com.ahmedabdelmohsen.xomultiplayer.R;
import com.ahmedabdelmohsen.xomultiplayer.databinding.FragmentSelectYourSideBinding;

public class SelectYourSideFragment extends Fragment {

    private FragmentSelectYourSideBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSelectYourSideBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        openGame();
    }

    private void openGame() {
        binding.btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                /*Intent in = new Intent(SelectYourSide.this, PlayWithFriend.class);
                startActivity(in);*/

                String oNamePlayer, xNamePlayer;
                oNamePlayer = binding.etOPlayer.getText().toString().trim();
                xNamePlayer = binding.etXPlayer.getText().toString().trim();
                if (oNamePlayer.isEmpty()) {
                    binding.etOPlayer.setError("Please enter Name of O player");
                } else if (xNamePlayer.isEmpty()) {
                    binding.etXPlayer.setError("Please enter Name of X player");
                } else {
                    Intent in = new Intent(getActivity(), PlayWithFriend.class);
                    in.putExtra("oNamePlayer", oNamePlayer);
                    in.putExtra("xNamePlayer", xNamePlayer);
                    startActivity(in);
                    getActivity().finish();
                }
            }
        });
    }
}