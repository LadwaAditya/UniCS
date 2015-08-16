package com.example.adityaladwa.unics;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by AdityaLadwa on 20-Apr-15.
 */
public class NoInternetFragment extends Fragment implements View.OnClickListener {
    public NoInternetFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_no_internet, container, false);

        Button mybuButton = (Button) rootView.findViewById(R.id.refresh_button);
        mybuButton.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View v) {

        CheckInternet ci = new CheckInternet(getActivity());
        boolean online = ci.isConnected();
        if (online) {
            getFragmentManager().beginTransaction().replace(R.id.my_frame, new WebFragment()).commit();
            Toast.makeText(getActivity(), "Retrying...", Toast.LENGTH_SHORT).show();
        }
        Toast.makeText(getActivity(), "Retrying...", Toast.LENGTH_SHORT).show();
    }
}
