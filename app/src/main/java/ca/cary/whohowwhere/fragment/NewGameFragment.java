package ca.cary.whohowwhere.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import ca.cary.whohowwhere.R;
import ca.cary.whohowwhere.adapter.AddPlayerAdapter;
import ca.cary.whohowwhere.callback.OnNumCardsLeftChangedListener;
import ca.cary.whohowwhere.model.Candidate;
import ca.cary.whohowwhere.data.Deck;

/**
 * Created by jiayaohuang on 2017-11-26.
 */

public class NewGameFragment extends Fragment implements OnNumCardsLeftChangedListener, View.OnClickListener {

    public static final String TAG = NewGameFragment.class.getName();

    private static final int MIN_PLAYER = 2;

    private TextView numCardLeft;
    private ListView playerList;
    private Button removePlayer;
    private Button startGame;

    private Deck deck;
    private List<Candidate> candidates;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initialize();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_create_game, container, false);

        numCardLeft = view.findViewById(R.id.numCardLeft);
        playerList = view.findViewById(R.id.playerList);
        removePlayer = view.findViewById(R.id.removePlayer);
        startGame = view.findViewById(R.id.startGame);

        numCardLeft.setText(String.valueOf(Candidate.getNumCardsLeft()));

        if (candidates.size() <= MIN_PLAYER) {
            removePlayer.setEnabled(false);
        }

        AddPlayerAdapter adapter = new AddPlayerAdapter(getActivity(), getFragmentManager(), candidates, this);
        playerList.setAdapter(adapter);

        view.findViewById(R.id.addPlayer).setOnClickListener(this);
        removePlayer.setOnClickListener(this);
        startGame.setOnClickListener(this);

        return view;
    }

    @Override
    public void onNumCardsLeftChanged() {
        numCardLeft.setText(String.valueOf(Candidate.getNumCardsLeft()));

        if (Candidate.getNumCardsLeft() == 0) {
            startGame.setEnabled(true);
        } else {
            startGame.setEnabled(false);
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.addPlayer:
                candidates.add(new Candidate("", 0));
                recalculateNumCardsPerCandidate();

                numCardLeft.setText(String.valueOf(Candidate.getNumCardsLeft()));
                ((BaseAdapter) playerList.getAdapter()).notifyDataSetChanged();

                if (candidates.size() > MIN_PLAYER) {
                    removePlayer.setEnabled(true);
                }

                if (Candidate.getNumCardsLeft() == 0) {
                    startGame.setEnabled(true);
                } else {
                    startGame.setEnabled(false);
                }
                break;
            case R.id.removePlayer:
                candidates.remove(candidates.size() - 1);
                recalculateNumCardsPerCandidate();

                numCardLeft.setText(String.valueOf(Candidate.getNumCardsLeft()));
                ((BaseAdapter) playerList.getAdapter()).notifyDataSetChanged();

                if (candidates.size() <= MIN_PLAYER) {
                    removePlayer.setEnabled(false);
                }

                if (Candidate.getNumCardsLeft() == 0) {
                    startGame.setEnabled(true);
                } else {
                    startGame.setEnabled(false);
                }
                break;
            case R.id.startGame:
                break;
        }
    }

    private void initialize() {
        deck = Deck.getInstance();

        candidates = new ArrayList<>();

        Candidate.setNumCardsLeft(deck.getNumCardsInDeck() % MIN_PLAYER);

        int numCardsPerCandidate = deck.getNumCardsInDeck() / MIN_PLAYER;
        for (int i = 0; i < MIN_PLAYER; i++) {
            candidates.add(new Candidate("", numCardsPerCandidate));
        }
    }

    private void recalculateNumCardsPerCandidate() {
        Candidate.setNumCardsLeft(deck.getNumCardsInDeck() % candidates.size());

        int numCardsPerCandidate = deck.getNumCardsInDeck() / candidates.size();
        for (Candidate candidate : candidates) {
            candidate.setNumCardsAtStart(numCardsPerCandidate);
        }
    }

}
