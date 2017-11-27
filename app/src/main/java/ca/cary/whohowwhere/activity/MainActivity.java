package ca.cary.whohowwhere.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ca.cary.whohowwhere.R;
import ca.cary.whohowwhere.fragment.NewGameFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getFragmentManager().beginTransaction()
                .add(R.id.main_content, new NewGameFragment())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        finish();
    }

}
