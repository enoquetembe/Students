package com.example.studets;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.studets.databinding.FragmentRegisterStudentBinding;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterStudentFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterStudentFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private FragmentRegisterStudentBinding binding;
    ArrayList<Student> students =  new ArrayList<>();


    public RegisterStudentFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment RegisterStudentFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RegisterStudentFragment newInstance(String param1, String param2) {
        RegisterStudentFragment fragment = new RegisterStudentFragment();
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
        // Inflate the layout for this fragment
        binding = FragmentRegisterStudentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
       binding.btnRegister.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               addStudent();

           }
       });

        return  view;
    }

    private void addStudent() {
        // Obtenha os detalhes do estudante do formulário


        String name = binding.txtName.getText().toString();
        String course = binding.txtCourse.getText().toString();
        String ageString = binding.txtAge.getText().toString();

        if (!name.isEmpty() && !course.isEmpty() && !ageString.isEmpty()) {
            int age = Integer.parseInt(ageString);
            // Crie um objeto Student com os detalhes
            Student student = new Student(name, course, age);

            // Adicione o estudante à lista de estudantes
            students.add(student);

            // Obtenha a referência do FragmentListStudents
            ListStudentsFragment listStudentsFragment = (ListStudentsFragment) getParentFragmentManager().findFragmentByTag("fragment_list_students");

            // Atualize a lista de estudantes no FragmentListStudents
            if (listStudentsFragment != null) {
                listStudentsFragment.updateStudentList(students);
            }

            Toast.makeText(getActivity(), "Estudante adicionado com sucesso", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(requireContext(), "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
        }




    }
}