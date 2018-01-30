package challenges.com.challengesfirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.firebase.ui.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import challenges.com.challengesfirebase.Adapter.ChallengesAdapter;
import challenges.com.challengesfirebase.Model.Challenges;

public class ChallengesActivity extends AppCompatActivity {

//    private RecyclerView mChallenges;
//    private DatabaseReference mRef;
//    private FirebaseDatabase database;
//    private Date date;
//    private DateTime dateTime;
//    private DatabaseReference challengesRef, datesRef;

    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private List<Challenges> challengesList;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenges);

        recyclerView = findViewById(R.id.challengeRecycleView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference().child("challenges");
        myRef.keepSynced(true);

        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                challengesList = new ArrayList<>();
                int counter = 1;
                for(DataSnapshot dataSnapshot1 :dataSnapshot.getChildren()){

                    Challenges value = dataSnapshot1.getValue(Challenges.class);
                    Challenges challenge = new Challenges();
                    String date = value.getDate();
                    String challengeOne = value.getChallengeOne();
                    String challengeTwo = value.getChallengeTwo();
                    challenge.setDate(date);
                    challenge.setChallengeOne(challengeOne);
                    challenge.setChallengeTwo(challengeTwo);
                    if(counter <=14) challengesList.add(challenge);
                    counter++;

                }
                adapter = new ChallengesAdapter(challengesList,ChallengesActivity.this);
                recyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("Hello", "Failed to read value.", error.toException());
            }
        });




    }
}





/*
database = FirebaseDatabase.getInstance();
        mRef = database.getReference().child("challenges");
        mRef.keepSynced(true);

        mChallenges = findViewById(R.id.challengeRecycleView);
        mChallenges.setHasFixedSize(true);
        mChallenges.setLayoutManager(new LinearLayoutManager(this));
 */









//        database = FirebaseDatabase.getInstance();
//        date = new Date();
//        dateTime = new DateTime(date);
//        challengesRef = database.getReference("challenges");
//
//        for (int i = 0; i < 365; i++) {
//            dateTime = dateTime.plusDays(1);
//            LocalDate localDate = dateTime.toLocalDate();
//            String challengeDate = localDate.toString("yyyy-MM-dd");
//            String formattedDate = localDate.toString("dd-MM-yyyy");
//
//
//            datesRef = challengesRef.child(challengeDate); //this value will be replaced with the actual date
//
//            datesRef.child("date").setValue(formattedDate);
//            datesRef.child("challengeOne").setValue("My First Challenge");
//            datesRef.child("challengeTwo").setValue("My Second Challenge");
//        }

//    }
//}