package com.altinsoy.springbootfirebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
public class SpringbootFirebaseApplication {

    public static void main(String[] args) throws IOException {

        FileInputStream serviceAccount =
                new FileInputStream("./serviceAccountKey.json");


        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .setDatabaseUrl("https://springboot-firebase-52114-default-rtdb.firebaseio.com")
                                .build();
        FirebaseApp.initializeApp(options);
        SpringApplication.run(SpringbootFirebaseApplication.class, args);
    }

}
