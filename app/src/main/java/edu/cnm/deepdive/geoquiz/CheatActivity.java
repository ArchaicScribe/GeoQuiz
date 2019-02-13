package edu.cnm.deepdive.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

  private static final String EXTRA_ANSWER_IS_TRUE = "com.bignerdranch.android.geoquiz.answer_is_true";
  private static final String EXTRA_ANSWER_SHOWN = "com.bignerdranch.android.geoquiz.answer_shown";

  private boolean AnswerIsTrue;

  private TextView AnswerTextView;
  private Button ShowAnswerButton;

  public static Intent newIntent(Context packageContext, boolean answerIsTrue) {
    Intent intent = new Intent(packageContext, CheatActivity.class);
    intent.putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue);
    return intent;
  }

  public static boolean wasAnswerShown(Intent result) {
    return result.getBooleanExtra(EXTRA_ANSWER_SHOWN, false);
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cheat);

    AnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false);
    AnswerTextView = (TextView) findViewById(R.id.answer_text_view);

    ShowAnswerButton = (Button) findViewById(R.id.show_answer_button);
    ShowAnswerButton.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View view) {
        if (AnswerIsTrue) {
          AnswerTextView.setText(R.string.true_button);
        } else {
          AnswerTextView.setText(R.string.false_button);
        }
        setAnswerShownResult(true);
      }
    });
  }
  private void setAnswerShownResult(boolean isAnswerShown) {
    Intent data = new Intent();
    data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
    setResult(RESULT_OK, data);
  }
}
