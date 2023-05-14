package com.example.studets;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new RegisterStudentFragment();
            case 1:
                return new ListStudentsFragment();
            case 2:
                return new SettingsFragment();
            default:
                throw new IllegalArgumentException("Posição inválida: " + position);
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
