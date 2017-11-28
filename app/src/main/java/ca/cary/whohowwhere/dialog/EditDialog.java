package ca.cary.whohowwhere.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import ca.cary.whohowwhere.R;

/**
 * Created by jiayaohuang on 2017-11-27.
 */

public class EditDialog extends BaseDialog {

    private String text;
    private TextWatcher editTextWatcher;
    private View.OnClickListener okOnClick;

    public void setContent(String text, TextWatcher editTextWatcher, View.OnClickListener okOnClick) {
        this.text = text;
        this.editTextWatcher = editTextWatcher;
        this.okOnClick = okOnClick;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        setCancelable(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_edit, container, false);

        final EditText edit = view.findViewById(R.id.edit);

        edit.setText(text);

        edit.addTextChangedListener(editTextWatcher);

        view.findViewById(R.id.ok).setOnClickListener(okOnClick);

        return view;
    }

}
