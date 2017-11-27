package ca.cary.whohowwhere.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ca.cary.whohowwhere.R;
import ca.cary.whohowwhere.callback.OnNumCardsLeftChangedListener;
import ca.cary.whohowwhere.dao.Candidate;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class AddPlayerAdapter extends ArrayAdapter<Candidate> {

    private OnNumCardsLeftChangedListener listener;

    public AddPlayerAdapter(@NonNull Context context, List<Candidate> objects, OnNumCardsLeftChangedListener listener) {
        super(context, 0, objects);

        this.listener = listener;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, @NonNull ViewGroup parent) {
        final Candidate candidate = getItem(position);
        if (candidate == null) {
            return convertView;
        }

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.add_player_item, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.playerNum = convertView.findViewById(R.id.playerNum);
            viewHolder.playerName = convertView.findViewById(R.id.playerName);
            viewHolder.sub = convertView.findViewById(R.id.sub);
            viewHolder.cardNum = convertView.findViewById(R.id.cardNum);
            viewHolder.add = convertView.findViewById(R.id.add);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.playerNum.setText(String.valueOf(position + 1));
        viewHolder.playerName.setText(candidate.getName());
        viewHolder.cardNum.setText(String.valueOf(candidate.getNumCardsAtStart()));

        viewHolder.playerName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void afterTextChanged(Editable editable) {
                candidate.setName(editable.toString());
            }
        });

        viewHolder.sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (candidate.getNumCardsAtStart() > 0) {
                    int num = candidate.getNumCardsAtStart() - 1;
                    candidate.setNumCardsAtStart(num);

                    Candidate.setNumCardsLeft(Candidate.getNumCardsLeft() + 1);
                    listener.onNumCardsLeftChanged();

                    notifyDataSetChanged();
                }
            }
        });
        viewHolder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Candidate.getNumCardsLeft() > 0) {
                    int num = candidate.getNumCardsAtStart() + 1;
                    candidate.setNumCardsAtStart(num);

                    Candidate.setNumCardsLeft(Candidate.getNumCardsLeft() - 1);
                    listener.onNumCardsLeftChanged();

                    notifyDataSetChanged();
                }
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        TextView playerNum;
        EditText playerName;
        Button sub;
        TextView cardNum;
        Button add;
    }

}
