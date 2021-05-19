package profileManagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthy.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;

import drawerMenuController.Profile;

public class EditProfile extends AppCompatActivity {

    ImageView profilePicture;
    TextView name, email;
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

    FirebaseUser fUser = FirebaseAuth.getInstance().getCurrentUser();

    String oldN;
    String oldM;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        profilePicture = findViewById(R.id.profileImageEdit);
        name = findViewById(R.id.nameEdit);
        email = findViewById(R.id.emailEdit);

        oldN = name.getText().toString().trim();
        oldM = email.getText().toString().trim();

        name.setText(user.getDisplayName());
        email.setText(user.getEmail());
        profilePicture.setImageURI(user.getPhotoUrl());

    }

    public void SaveEdit(View v){
        String newName = name.getText().toString().trim();
        String newMail = email.getText().toString().trim();

        if(newName.isEmpty()){name.setText(oldN);}
        if(newMail.isEmpty()){email.setText(oldM);}

        if(!newMail.equals(oldN)) {
            fUser.updateEmail(newMail).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(EditProfile.this, "Successful", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

        if(!newName.equals(oldM)) {
            UserProfileChangeRequest nameUpdates = new UserProfileChangeRequest.Builder().setDisplayName(newName).build();
            fUser.updateProfile(nameUpdates).addOnSuccessListener(new OnSuccessListener<Void>() {
                @Override
                public void onSuccess(Void aVoid) {
                    Toast.makeText(EditProfile.this, "Successful", Toast.LENGTH_SHORT).show();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(EditProfile.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }
        startActivity(new Intent(getApplicationContext(), Profile.class));
    }

}