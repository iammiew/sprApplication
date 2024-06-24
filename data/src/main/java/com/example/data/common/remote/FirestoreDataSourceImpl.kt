package com.example.data.common.remote

import com.example.data.appbar.model.AppBarModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class FirestoreDatasourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : FirestoreDataSource {

    override suspend fun getTopAppBarUi(): Flow<resultResource<AppBarModel?>> = callbackFlow {
        val listener = EventListener<DocumentSnapshot> { snapshot, error ->
            if (error != null) {
                trySend(resultResource.Failure(error))
                // cancel() or cancel
                return@EventListener
            }

            if (snapshot != null && snapshot.exists()) {
                val data = snapshot.toObject<AppBarModel>()
                trySend(resultResource.Success(data))
            } else {
                trySend(resultResource.Failure(Exception("Snapshot is not exist")))
            }
        }
        val registration = firestore
            .collection("Appbar")
            .document("header")
            .addSnapshotListener(listener)

        awaitClose { registration.remove() }
    }
}
