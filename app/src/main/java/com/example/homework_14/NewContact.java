package com.example.homework_14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homework_14.model.Contact;
import com.example.homework_14.model.ContactViewModel;

public class NewContact extends AppCompatActivity {
    public static final String NAME_REPLY = "name_reply";
    public static final String OCCUPATION = "occupation";
    private EditText enterName, enterOccupation;
private Button saveBtn;

private ContactViewModel contactViewModel;

    public NewContact() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_contact);
        enterName = findViewById(R.id.enter_name);
        enterOccupation = findViewById(R.id.enter_occupation);
        saveBtn = findViewById(R.id.button);

        contactViewModel = new ViewModelProvider.AndroidViewModelFactory(NewContact.this
                .getApplication()).create(ContactViewModel.class);


        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent replayIntent = new Intent();
                if (!TextUtils.isEmpty(enterName.getText()) && !TextUtils.isEmpty(enterOccupation.getText())){
                    String name = enterName.getText().toString();
                    String occupation = enterOccupation.getText().toString();

                    replayIntent.putExtra(NAME_REPLY,name);
                    replayIntent.putExtra(OCCUPATION,occupation);
                    setResult(RESULT_OK,replayIntent);
                  //  ContactViewModel.insert(contact);
                }else {
                   setResult(RESULT_CANCELED,replayIntent);
                }
                finish();

            }
        });
    }
}