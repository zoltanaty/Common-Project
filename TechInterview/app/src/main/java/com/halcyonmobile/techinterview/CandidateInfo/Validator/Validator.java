package com.halcyonmobile.techinterview.CandidateInfo.Validator;

import android.text.TextUtils;

import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.EMAIL;
import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.NAME;
import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.btnDone;
import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.inputEmail;
import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.inputLayoutEmail;
import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.inputLayoutName;
import static com.halcyonmobile.techinterview.CandidateInfo.CandidateInfo.inputName;

/**
 * Created by Szilard on 11/26/2016.
 */

public class Validator {

    public static boolean validateName() {
        if (inputName.getText().toString().trim().isEmpty()) {
            inputLayoutName.setError(NAME);
            inputName.requestFocus();
            return false;
        } else {
            inputLayoutName.setErrorEnabled(false);
            doneButton();
        }

        return true;
    }
    public static boolean validateEmail() {
        String email = inputEmail.getText().toString().trim();

        if (email.isEmpty() || !isValidEmail(email)) {
            inputLayoutEmail.setError(EMAIL);
            inputEmail.requestFocus();
            return false;
        } else {
            inputLayoutEmail.setErrorEnabled(false);
            doneButton();
        }

        return true;
    }
    public static void doneButton(){
        String email = inputEmail.getText().toString().trim();
        if(isValidEmail(email)&&!email.isEmpty()&&!(inputName.getText().toString().trim().isEmpty())){
            btnDone.setEnabled(true);
        }
        else{
            btnDone.setEnabled(false);
        }
    }
    private static boolean isValidEmail(String email) {
        return !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }




}
