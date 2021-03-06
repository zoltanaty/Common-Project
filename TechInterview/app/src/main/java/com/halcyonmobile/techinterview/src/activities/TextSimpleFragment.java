package com.halcyonmobile.techinterview.src.activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.halcyonmobile.techinterview.R;
import com.halcyonmobile.techinterview.src.networking.model.Answer;
import com.halcyonmobile.techinterview.src.networking.model.dto.QuestionCardDTO;
import com.halcyonmobile.techinterview.src.utils.MyTextWatcher;


public class TextSimpleFragment extends Fragment {
    private TextView textViewTitle;
    private EditText editTextAnswer;
    private ActivityCallbacks activityCallbacks;

    interface ActivityCallbacks {
        void onQuestionFreeTextAnswered(Answer answer);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate( R.layout.fragment_fragment_text_simple, container, false );
        textViewTitle = (TextView) rootView.findViewById( R.id.textview_q_title );
        editTextAnswer = (EditText) rootView.findViewById( R.id.editText_answer );
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated( savedInstanceState );
        QuestionCardDTO questionCard = (QuestionCardDTO) getArguments().getSerializable( "data" );
        activityCallbacks = (ActivityCallbacks) getActivity();
        textViewTitle.setText( questionCard.getQuestion().getQuestion() );

        editTextAnswer.addTextChangedListener( new MyTextWatcher() {
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                Answer answer = new Answer();
                if (!editTextAnswer.getText().toString().equals( "" )) {
                    answer.setAnswer( editTextAnswer.getText().toString() );
                    activityCallbacks.onQuestionFreeTextAnswered( answer );
                }
            }
        } );
    }
}
