package com.example.expensemanagement;

import android.animation.Animator;
import android.app.AlertDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DashboardFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DashboardFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DashboardFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DashboardFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DashboardFragment newInstance(String param1, String param2) {
        DashboardFragment fragment = new DashboardFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private FloatingActionButton fab_main_btn, fab_income_btn, fab_expense_btn;
    private TextView fab_income_txt, fab_expense_txt;
    private boolean isOpen=false;
    private Animation FadOpen, FadeClose;

    private FirebaseAuth mAuth;
    private DatabaseReference mIncomeDatabase, mExpenseDatabase;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myview = inflater.inflate(R.layout.fragment_dashboard, container, false);

        fab_main_btn = myview.findViewById(R.id.fb_main_plus_btn);
        fab_expense_btn = myview.findViewById(R.id.expense_Ft_btn);
        fab_income_btn= myview.findViewById(R.id.income_Ft_btn);

        fab_expense_txt = myview.findViewById(R.id.expense_ft_text);
        fab_income_txt= myview.findViewById(R.id.income_ft_text);

        FadOpen = AnimationUtils.loadAnimation(getActivity(),R.anim.fade_open);
        FadeClose =AnimationUtils.loadAnimation(getActivity(),R.anim.fade_close);

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser mUser= mAuth.getCurrentUser();
        String uid=mUser.getUid();

        mIncomeDatabase = FirebaseDatabase.getInstance().getReference().child("IncomeData").child(uid);
        mExpenseDatabase = FirebaseDatabase.getInstance().getReference().child("ExpenseData").child(uid);

        fab_main_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                addData();

                if (isOpen){
                    fab_income_btn.startAnimation(FadeClose);
                    fab_expense_btn.startAnimation(FadeClose);
                    fab_income_btn.setClickable(false);
                    fab_expense_btn.setClickable(false);

                    fab_income_txt.startAnimation(FadeClose);
                    fab_expense_txt.startAnimation(FadeClose);
                    fab_expense_txt.setClickable(false);
                    fab_income_txt.setClickable(false);
                    isOpen=false;

                }
                else {

                    fab_income_btn.startAnimation(FadOpen);
                    fab_expense_txt.startAnimation(FadOpen);
                    fab_income_btn.setClickable(true);
                    fab_expense_btn.setClickable(true);

                    fab_income_txt.startAnimation(FadOpen);
                    fab_expense_txt.startAnimation(FadOpen);
                    fab_income_txt.setClickable(true);
                    fab_expense_txt.setClickable(true);
                    isOpen=true;
                }
            }
        });

        return myview;


    }
    private void addData(){

        fab_income_btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                incomeDataInsert();

            }
        });

        fab_expense_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    public void incomeDataInsert(){
        AlertDialog.Builder mydialog = new  AlertDialog.Builder(getActivity());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        View myviewm = inflater.inflate(R.layout.custom_layout_for_insertdata,null);
        mydialog.setView(myviewm);
        AlertDialog dialog= mydialog.create();

        EditText edtAmmount = myviewm.findViewById(R.id.amount_edt);
        EditText edtType = myviewm.findViewById(R.id.type_edt);
        EditText edtNote = myviewm.findViewById(R.id.note_edt);

        Button btnSave = myviewm.findViewById(R.id.btnSave);
        Button btnCansel= myviewm.findViewById(R.id.btnCancel);

       btnSave.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               String type =edtType.getText().toString().trim();
               String ammount =edtAmmount.getText().toString().trim();
               String note = edtNote.getText().toString().trim();

               if (TextUtils.isEmpty(type)){
                   edtType.setError("Required Field... ");
                   return;
               }

               if (TextUtils.isEmpty(ammount)){
                   edtAmmount.setError("Required Field... ");
                   return;
               }

               int ourammontint= Integer.parseInt(ammount);

               if (TextUtils.isEmpty(note)){
                   edtNote.setError("Required Field... ");
                   return;
               }
           }
       });

        btnCansel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                dialog.dismiss();
            }
        });
        dialog.show();

    }

}