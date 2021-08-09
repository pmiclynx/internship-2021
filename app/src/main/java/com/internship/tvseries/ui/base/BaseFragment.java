package com.internship.tvseries.ui.base;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

public abstract class BaseFragment<VM extends BaseViewModel> extends Fragment implements ViewModelComponent<VM> {

    protected VM viewModel;

    @Override
    public void onViewCreated(@NonNull @NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        viewModel = createViewModel();
        super.onViewCreated(view, savedInstanceState);
    }
}
