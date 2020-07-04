package com.ahmedabdelmohsen.xomultiplayer.main.destinations;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.ahmedabdelmohsen.xomultiplayer.R;
import com.ahmedabdelmohsen.xomultiplayer.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //this line for hide statusBar
        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

//        setSupportActionBar(binding.toolbar);
//        getSupportActionBar().setTitle(null);
        setExit();
        startPlaying();
        openContactUs(view);
    }

    private void startPlaying() {
        binding.btnWithFriend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_selectYourSideFragment);
            }
        });
    }

    private void setExit() {
        binding.btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.AlertDialogStyle);
                builder.setMessage(R.string.do_you_want_close).setCancelable(false)
                        .setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
//                                getActivity().finish();
//                                System.exit(0);
                                ActivityCompat.finishAffinity(getActivity());
                            }
                        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog ExitDialog = builder.create();
                ExitDialog.setTitle(R.string.alert);
                ExitDialog.show();
            }
        });
    }

    private void openContactUs(final View view) {
        binding.btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(R.id.action_homeFragment2_to_contactUsFragment);
            }
        });
    }


}