package com.example.appstrov2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import coil.compose.AsyncImage
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.request.ImageRequest
import com.example.appstrov2.component.TextContent
import com.example.appstrov2.component.TitleContent
import com.example.appstrov2.data.DataItemProfile
import com.example.appstrov2.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityProfileBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.composeView.setContent {
            ProfileScreen(
                navController = NavController(LocalContext.current)
            )
        }

    }
}

@Composable
fun ProfileScreen(navController: NavController) {
    Box(
        modifier = Modifier.padding(25.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 10.dp),
            horizontalAlignment = Alignment.End) {
            IconButton(
                onClick = {},
                modifier = Modifier
                    .padding(start = 20.dp, top = 15.dp, bottom = 15.dp)
                    .clip(CircleShape)
                    .size(60.dp)
                    .testTag("logout")
                    .background(colorResource(id = R.color.yellow))

            ) {
                Icon(
                    painter = painterResource(id = R.drawable.logout),
                    contentDescription = null,
                    tint = colorResource(id = R.color.brown),
                    modifier = Modifier.size(24.dp)
                )
            }

        }
        Column( modifier = Modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            ProfileImage()
            Spacer(modifier = Modifier.height(20.dp))
            TextContent(title = "Cameron Williamson")
            TitleContent(title = "cameronwill")
            Spacer(modifier = Modifier.height(20.dp))
//            BodyProfile()
            Column(modifier = Modifier.padding(5.dp)) {
                Card(colors = CardDefaults.cardColors(containerColor = Color.White)) {
                    DataItemProfile.DataDummy.forEach { item ->
                        DetailProfile(icon = item.icon, title = item.title)
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileImage() {
    Column() {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current).data(
                "https://images.unsplash.com/photo-1507003211169-0a1dd7228f2d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80"
            ).crossfade(true).build(),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .border(1.dp, color = colorResource(id = R.color.teal_700), CircleShape)
                .clip(CircleShape)

        )
    }

}

@Composable
fun DetailProfile(title: String, icon: Int){
    val context = LocalContext.current

    Row (
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp, vertical = 5.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Row() {
            Box(modifier = Modifier
                .width(40.dp)
                .height(40.dp)
                .clip(CircleShape)
                .background(colorResource(id = R.color.yellow))) {
                Icon(painter = painterResource(id = icon), contentDescription =null,
                    tint = colorResource(id = R.color.teal_700),
                    modifier = Modifier
                        .size(25.dp)
                        .align(Alignment.Center))
            }
            Spacer(modifier = Modifier.width(5.dp))
            Text(
                text = title,
                color = colorResource(id = R.color.brown),
                fontSize = 16.sp,
                modifier = Modifier.padding(top =9.dp)

            )
        }
        IconButton(onClick = { /*TODO*/ }

        ) {
            Icon(painter = painterResource(id = R.drawable.chevron),
                contentDescription = null, tint = colorResource(R.color.teal_700),
                modifier = Modifier.size(24.dp))

        }
    }
}

@Preview
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = NavController(LocalContext.current))
}

