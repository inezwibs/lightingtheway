package com.example.lightupapp2;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

public class Tab4Fragment extends Fragment{

    private static final String TAG= "Tab4Fragment";

    private Button btnTEST4a, btnTEST4b, btnTEST4c;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab4_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        btnTEST4a = (Button) view.findViewById(R.id.btnTEST4a);
        btnTEST4a.setOnClickListener(awesomeOnClickListener);

        btnTEST4b = (Button) view.findViewById(R.id.btnTEST4b);
        btnTEST4b.setOnClickListener(awesomeOnClickListener);

        btnTEST4c = (Button) view.findViewById(R.id.btnTEST4c);
        btnTEST4c.setOnClickListener(awesomeOnClickListener);
    }


    private View.OnClickListener awesomeOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            awesomeButtonClicked(v);
        }
    };
    private void awesomeButtonClicked(View v) {
        switch (v.getId()) {
            case R.id.btnTEST4a:
                Toast.makeText(getActivity(), "Testing Button 3 tested", Toast.LENGTH_SHORT).show();
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setData(Uri.parse("mailto:vpsaem@sfsu.edu"));
                try {
                    startActivity(emailIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case where no email app is available
                }
                break;

            case R.id.btnTEST4b:
                Toast.makeText(getActivity(), "Testing Button 4 tested ", Toast.LENGTH_SHORT).show();
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://titleix.sfsu.edu"));
                try {
                    startActivity(browserIntent);
                } catch (ActivityNotFoundException e) {
                    //TODO: Handle case when url is unreachable

                }
                break;

            case R.id.btnTEST4c:
                Toast.makeText(getActivity(), "Testing Button 5 tested ", Toast.LENGTH_SHORT).show();
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:+1-415-338-7313"));
                if (ActivityCompat.checkSelfPermission(this.getContext(),
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(phoneIntent);

                break;

            default:
                break;

        }
    }

}

