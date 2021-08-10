package com.internship.tvseries.data.repository;

import androidx.lifecycle.MutableLiveData;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginRepository {
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private FirebaseAuth auth;

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public LoginRepository(){
        firebaseUserMutableLiveData=new MutableLiveData<>();
        auth=FirebaseAuth.getInstance();

        if(auth.getCurrentUser()!=null){
            firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
        }
    }

    public Task<AuthResult> login(String username, String password){
        return auth.signInWithEmailAndPassword(username,password);

    }
    public boolean loggedin(){
        if(auth.getCurrentUser()!=null){
            return true;
        }else{
            return false;
        }
    }
}
