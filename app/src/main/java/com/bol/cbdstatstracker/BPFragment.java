package com.bol.cbdstatstracker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class BPFragment extends Fragment {
    DatabaseHelper mDatabaseHelper;
    private Button enterButton;
    private EditText date;
    private EditText time;
    private EditText diastolic;
    private EditText systolic;
    private String eDate;
    private String eTime;
    private String eDiastolic;
    private String eSystolic;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View bpView = inflater.inflate(R.layout.fragment_b, container,false);
        enterButton = bpView.findViewById(R.id.bp_enter);
        date = bpView.findViewById(R.id.bp_date) ;
        time = bpView.findViewById(R.id.bp_time);
        diastolic = bpView.findViewById(R.id.bp_dia);
        systolic = bpView.findViewById(R.id.bp_sys);
        initDBHelper();
        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                eDate = date.getText().toString();
                eTime = time.getText().toString();
                eDiastolic = diastolic.getText().toString();
                eSystolic = systolic.getText().toString();
                if (eDate.length()== 0 || eTime.length() == 0 || eDiastolic.length() ==0 || eSystolic.length()==0){
                    toastMessage("Please enter all fields");
                } else {
                    int iDiastolic = Integer.parseInt(eDiastolic);
                    int iSystolic = Integer.parseInt(eSystolic);
                   addData(eDate, eTime, iDiastolic, iSystolic);
                    //toastMessage("yay!");
                }

            }
        });

        return bpView ;
    }

    public void addData(String nDate, String nTime, int nDia, int nSys){
        toastMessage("starting add");

        boolean insertSuccess = mDatabaseHelper.addBPData(nDate, nTime, nDia, nSys);
        toastMessage("insert complete");
        /*if (insertSuccess){
            toastMessage("Success!");
        }else{
            toastMessage("Something Went Wrong!");
        }*/
    }

    private void initDBHelper(){
        if (mDatabaseHelper == null){
            mDatabaseHelper = new DatabaseHelper(getActivity());

        }
    }
    private void toastMessage(String message){
        Toast.makeText(getActivity(),message, Toast.LENGTH_SHORT).show();
    }
}
