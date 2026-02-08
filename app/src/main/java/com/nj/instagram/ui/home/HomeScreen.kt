package com.nj.instagram.ui.home

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Message
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.nj.instagram.R
import com.nj.instagram.ui.theme.Bold24

@Composable
fun HomeScreen()
{
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(stringResource(R.string.app_name), style = MaterialTheme.typography.Bold24)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    imageVector = Icons.Default.HeartBroken,
                    contentDescription = "like",
                    modifier = Modifier.size(28.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.Message,
                    contentDescription = "message",
                    modifier = Modifier.size(28.dp)
                )
            }
        }
        items(posts) { post ->
            PostCard(
                post = post,
                currentUserId = currentUserId ?: "",
                onLikeClick = {
                    if (post.isLiked) {
                        viewModel.unlikePost(post.id, currentUserId ?: "")
                    } else {
                        viewModel.likePost(post.id, currentUserId ?: "")
                    }
                },
                onProfileClick = { onProfileClick(post.userId) },
                onCommentClick = { onPostClick(post.id) }
            )
            Spacer(Modifier.height(12.dp))
        }
    }
}