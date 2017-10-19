package com.example.aptivist_u002.loginfragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private EditText nameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private MethodsToImplement methodsToImplement;
    public LoginFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        nameEditText = (EditText) view.findViewById(R.id.fragment_et1);
        passwordEditText = (EditText) view.findViewById(R.id.fragment_et2);
        loginButton = (Button) view.findViewById(R.id.fragment_btn1);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                methodsToImplement.checkData(nameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });


    }

    public interface MethodsToImplement {
        void checkData(String user, String password);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        methodsToImplement = (MethodsToImplement) context;
    }
}
