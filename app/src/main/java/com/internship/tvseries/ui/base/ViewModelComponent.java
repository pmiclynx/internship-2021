package com.internship.tvseries.ui.base;

import androidx.annotation.NonNull;

public interface ViewModelComponent<VM extends BaseViewModel> {

    @NonNull
    VM createViewModel();
}
