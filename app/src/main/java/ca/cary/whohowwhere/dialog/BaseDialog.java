package ca.cary.whohowwhere.dialog;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;

/**
 * Created by jiayaohuang on 2017-11-27.
 */

public class BaseDialog extends DialogFragment {

    @Override
    public void show(FragmentManager fragmentManager, String tag) {
        try {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(this, tag);
            fragmentTransaction.commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }

}
