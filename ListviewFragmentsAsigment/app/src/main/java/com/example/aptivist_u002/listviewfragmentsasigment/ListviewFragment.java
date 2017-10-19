package com.example.aptivist_u002.listviewfragmentsasigment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.aptivist_u002.listviewfragmentsasigment.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListviewFragment extends Fragment {

    private MethodsToImplement methodsToImplement;
    private ListView listView;
    private ArrayList<String> users;
    private ArrayAdapter<String> adapter;

    public ListviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_listview, container, false);
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        users = new ArrayList<>();
        users.add("Lorenzo Coleman");
        users.add("Tommy Blake");
        users.add("Wayne Ortiz");
        users.add("Julia Stone");
        users.add("Billy Bailey");
        users.add("Timmy Powell");
        users.add("Eddie Warner");
        users.add("Jody Johnson");
        users.add("Raul Walton");
        users.add("Steve Morgan");
        users.add("Elsie Chavez");
        users.add("Julia Stone");
        users.add("Billy Bailey");
        users.add("Timmy Powell");
        users.add("Eddie Warner");
        users.add("Jody Johnson");

        listView = (ListView) view.findViewById(R.id.fragment_list1);

        adapter = new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, users);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(view.getContext(), position +"", Toast.LENGTH_SHORT).show();
                String userClicked = users.get(position);
                methodsToImplement.showDetail(userClicked);
            }
        });





    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        methodsToImplement = (MethodsToImplement) context;
    }

    /***************************
    ************************Interface
     */

    public interface MethodsToImplement {
        void showDetail(String user);
    }
}
