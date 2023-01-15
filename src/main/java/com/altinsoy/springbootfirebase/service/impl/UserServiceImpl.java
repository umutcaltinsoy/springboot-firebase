package com.altinsoy.springbootfirebase.service.impl;

import com.altinsoy.springbootfirebase.model.Order;
import com.altinsoy.springbootfirebase.model.User;
import com.altinsoy.springbootfirebase.service.UserService;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.protobuf.Api;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<User> getAllUser() throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();

        Iterable<DocumentReference> documentReferences = firestore.collection("users").listDocuments();
        Iterator<DocumentReference> iterator = documentReferences.iterator();

        List<User> userList = new ArrayList<>();
        User user = null;

        while (iterator.hasNext()) {
            DocumentReference documentReference = iterator.next();
            ApiFuture<DocumentSnapshot> future = documentReference.get();
            DocumentSnapshot documentSnapshot = future.get();

            user = documentSnapshot.toObject(User.class);
            userList.add(user);
        }

        if (userList.isEmpty()) {
            return Collections.emptyList();
        }

        return userList;
    }

    @Override
    public String saveUser(User user) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("users").document().create(user);
        return collectionApiFuture.get().getUpdateTime().toString();
    }

    @Override
    public User getUserDetails(String name) throws ExecutionException, InterruptedException {

        Firestore firestore = FirestoreClient.getFirestore();

        DocumentReference documentReference = firestore.collection("users").document(name);
        ApiFuture<DocumentSnapshot> future = documentReference.get();
        DocumentSnapshot documentSnapshot = future.get();

        User user = null;
        if (documentSnapshot.exists()) {
            user = documentSnapshot.toObject(User.class);
            return user;
        }

        return null;
    }

    @Override
    public String saveOrder(Order order) throws ExecutionException, InterruptedException {
        Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> collectionApiFuture = firestore.collection("orders").document().create(order);
        return collectionApiFuture.get().getUpdateTime().toString();
    }
}
