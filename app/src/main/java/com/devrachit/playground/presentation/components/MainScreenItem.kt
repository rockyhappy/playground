package com.devrachit.playground.presentation.components

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.devrachit.playground.R
import com.devrachit.playground.ui.theme.GrayShade2
import com.devrachit.playground.ui.theme.Poppins

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BlogItem(
    imageUrl: String,
    title: String,
    date: String,
    onItemClick: (String) -> Unit = {}
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(GrayShade2)
            .padding(12.dp)

    ) {
        val (image, column) = createRefs()

        GlideImage(
            model = imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
                modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16.toFloat() / 9)
                .clip(RoundedCornerShape(8.dp))
                .constrainAs(image) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(column.top)
                },
        )
        Column(
            modifier = Modifier
                .constrainAs(column) {
                    top.linkTo(image.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(parent.bottom)
                    width = Dimension.fillToConstraints
                    height = Dimension.wrapContent
                }
                .padding(start=8.dp, end=8.dp, top= 8.dp)
        ) {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = Poppins,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = Color.White,
                modifier = Modifier
//                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(4.dp)
            )
            Text(
                text = date,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                fontFamily = Poppins,
                fontSize = 10.sp,
                color = Color.White,
                modifier = Modifier
//                    .background(Color.Black.copy(alpha = 0.5f))
                    .padding(4.dp)
            )
        }
    }
}