package sg.edu.np.mad.madpractical4;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Get the random integer passed from ListActivity
        int randomInteger = getIntent().getIntExtra("randomInteger", 0);

        // Initialize a new User object
        User user = new User("MAD", "MAD Developer",1, false);

        // Get the TextViews and Button from the layout
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDescription = findViewById(R.id.tvDescription);
        TextView tvRandomInteger = findViewById(R.id.tvRandomInteger);
        Button btnFollow = findViewById(R.id.btnFollow);
        Button btnMessage = findViewById(R.id.btnMessage);

        // Set the TextViews with the User's name, description and default button message
        tvName.setText(user.name);
        tvDescription.setText(user.description);
        // btnFollow.setText("Follow");
        btnMessage.setText("Message");

        // Challenge 5.1 | Making the Follow/Unfollow toggle button
        btnFollow.setText(user.followed ? "Unfollow" : "Follow");

        // Set OnClickListener for button
        btnFollow.setOnClickListener((view -> {
            // Toggling 'followed' status
            Log.d("MADPRAC2", "Follow Button Clicked");
            user.followed = !user.followed;

            // Update button text accordingly
            btnFollow.setText(user.followed ? "Unfollow" : "Follow");

            // Show the toast message
            String toastMessage = user.followed ? "Followed" : "Unfollowed";
            Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_SHORT).show();

        }));

        // Display random int w the name
        tvRandomInteger.setText("" + randomInteger);
    }
}