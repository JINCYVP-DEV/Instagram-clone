package com.nj.instagram.domain

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
    private val firebaseFirestore: FirebaseFirestore ) {

    suspend fun signUp(userName:String,password: String,email:String): Result<String> {
       return try {
           val authResult = firebaseAuth.createUserWithEmailAndPassword(email,password).await()
           val userId = authResult.user?.uid ?: throw Exception("User creation failed")
           val userMap = mapOf(
               "id" to userId,
               "userName" to userName,
               "email" to email,
               "profilePictureUrl" to "",
               "bio" to "",
               "followerCount" to 0,
               "followingCount" to 0,
               "postCount" to 0,
               "createdAt" to System.currentTimeMillis()
           )
           firebaseFirestore.collection("users").document(userId).set(userMap).await()
           Result.success(userId)
       } catch (e: Exception) {
           Result.failure(e)
       }
    }
}