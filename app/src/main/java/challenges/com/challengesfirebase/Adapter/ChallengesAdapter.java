package challenges.com.challengesfirebase.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import challenges.com.challengesfirebase.Model.Challenges;
import challenges.com.challengesfirebase.R;

/**
 * Created by carlsaptarshi on 30/01/2018.
 */

public class ChallengesAdapter extends RecyclerView.Adapter<ChallengesAdapter.ChallengesViewHolder>{

    List<Challenges> challengesList;
    Context context;

    public ChallengesAdapter(List<Challenges> challengesList, Context context) {
        this.challengesList = challengesList;
        this.context = context;
    }

    @Override
    public ChallengesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //I have inflated the draw_card view within this onCreateViewHolder method.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.challenge_card, parent, false);
        return new ChallengesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ChallengesAdapter.ChallengesViewHolder holder, int position) {
        //get the current position of the list.
        Challenges challenge = challengesList.get(position);
        holder.date.setText(challenge.getDate());

        holder.challengeOne.setText(challenge.getChallengeOne());
        holder.challengeTwo.setText(challenge.getChallengeTwo());


    }

    @Override
    public int getItemCount() {
        return challengesList.size();
    }

    class ChallengesViewHolder extends RecyclerView.ViewHolder {
        TextView date, challengeOne,challengeTwo;


        public ChallengesViewHolder(View itemView) {
            super(itemView);
            date = itemView.findViewById(R.id.date);
            challengeOne = itemView.findViewById(R.id.challengeOne);
            challengeTwo = itemView.findViewById(R.id.challengeTwo);

        }
    }
}
