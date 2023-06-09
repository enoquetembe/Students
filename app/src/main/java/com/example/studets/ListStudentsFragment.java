package com.example.studets;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.studets.databinding.FragmentListStudentsBinding;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ListStudentsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListStudentsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentListStudentsBinding binding;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> studentList;


    public ListStudentsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListStudentsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListStudentsFragment newInstance(String param1, String param2) {
        ListStudentsFragment fragment = new ListStudentsFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        studentList = new ArrayList<>();
        // Inflate the layout for this fragment
        binding = FragmentListStudentsBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        //shared preferences
        SharedPreferences preferences = getActivity().getSharedPreferences("Students-Xml", Context.MODE_PRIVATE );
        Gson gson = new Gson();
        String json = preferences.getString("studentsList","");

        if (!json.isEmpty()) {
            // Deserializar a string JSON de volta para a lista de estudantes
            Type type = new TypeToken<ArrayList<Student>>() {}.getType();
           studentList = gson.fromJson(json, type);

        }

        studentAdapter = new StudentAdapter(getContext(),studentList);
        binding.studentsLV.setAdapter(studentAdapter);


        System.out.println(studentList);

        return view;
    }

    public void updateStudentList(ArrayList<Student> students) {
        studentList.clear();
        studentList.addAll(students);
        studentAdapter.notifyDataSetChanged();

    }
}