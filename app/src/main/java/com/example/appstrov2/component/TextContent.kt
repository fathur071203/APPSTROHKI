package com.example.appstrov2.component

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.appstrov2.R

@Composable
fun TextContent(title: String){
    Text(text = title, fontSize = 14.sp, color = colorResource(id = R.color.brown))

}

@Composable
fun TitleContent(title: String){
    Text(text = title, fontSize = 12.sp, color = colorResource(id = R.color.teal_700), fontWeight = FontWeight.Medium)
}