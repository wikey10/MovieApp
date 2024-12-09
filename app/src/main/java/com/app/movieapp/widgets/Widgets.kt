package com.app.movieapp.widgets

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.app.movieapp.model.Movie
import com.app.movieapp.model.getMovies


@Preview
@Composable
fun  MovieRow(movie: Movie= getMovies()[0], onItemClick:(String)->Unit={}){
    var expanded by remember{
        mutableStateOf(false)
    }
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.padding(10.dp).fillMaxWidth().clickable {
            onItemClick(movie.title)
        },
        shape = RoundedCornerShape(
            corner = CornerSize(16.dp)
        )
    ) {

        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Start) {
            Surface(
                modifier = Modifier
                    .padding(15.dp)
                    .size(100.dp),
                shape = RectangleShape
            ) {
                Image(
                    painter = rememberImagePainter(movie.images.first(), builder = {
                        transformations(CircleCropTransformation())
                    }),
                    contentDescription = "My content description",
                )
            }

            Column(modifier = Modifier.padding(4.dp)){
                Text(text = movie.title, style = MaterialTheme.typography.titleLarge)
                Text(text = "Director:"+movie.director, style = MaterialTheme.typography.labelMedium)
                Text(text ="Released:"+ movie.year, style = MaterialTheme.typography.labelMedium)
               AnimatedVisibility(visible = expanded) {
                   Column() {
                       Text(buildAnnotatedString {
                           withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp)){
                               append("Plot:")
                           }
                           withStyle(style = SpanStyle(color = Color.DarkGray, fontSize = 13.sp, fontWeight = FontWeight.Bold)){
                               append(movie.plot)
                           }
                       })
                   }
               }
                Icon(imageVector = if(expanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown, contentDescription = "Down Arrow", modifier = Modifier.size(25.dp).clickable {
                    expanded=!expanded
                })
            }

        }

    }
}