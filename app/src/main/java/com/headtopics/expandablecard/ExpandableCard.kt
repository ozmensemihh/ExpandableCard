package com.headtopics.expandablecard

import android.text.style.ParagraphStyle
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExpandableCard(){

    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(targetValue = if (expandedState) 180f else 0f)

    Card (modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)
        .animateContentSize(
            animationSpec = tween(
                durationMillis = 200,
                easing = LinearOutSlowInEasing
            )
        ),
        shape = RoundedCornerShape(4.dp),
        onClick = {
            expandedState = !expandedState
        }
        ) {
            Column (modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)) {
                Row  (verticalAlignment = Alignment.CenterVertically){
                    Text(
                        modifier = Modifier.weight(6f),
                        text = "Title",
                        fontSize = MaterialTheme.typography.titleLarge.fontSize,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis)
                    IconButton(
                        modifier = Modifier
                            .alpha(3f)
                            .weight(1f)
                            .rotate(rotationState),
                        onClick = { expandedState = !expandedState }) {
                        Icon(imageVector = Icons.Default.ArrowDropDown , contentDescription ="" )
                    }
                }

                if (expandedState){
                    Text(
                        text = "Lorem Ipsum, dizgi ve baskı endüstrisinde kullanılan mıgır metinlerdir. " +
                                "Lorem Ipsum, adı bilinmeyen bir matbaacının bir hurufat numune kitabı " +
                                "oluşturmak üzere bir yazı galerisini alarak karıştırdığı " +
                                "1500'lerden beri endüstri standardı sahte metinler " +
                                "olarak kullanılmıştır. Beşyüz yıl boyunca varlığını sürdürmekle " +
                                "kalmamış, aynı zamanda pek değişmeden elektronik dizgiye de " +
                                "sıçramıştır. 1960'larda Lorem Ipsum pasajları da içeren " +
                                "Letraset yapraklarının yayınlanması ile ve yakın zamanda " +
                                "Aldus PageMaker gibi Lorem Ipsum sürümleri içeren masaüstü " +
                                "yayıncılık yazılımları ile popüler olmuştur.",
                        fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                        fontWeight = FontWeight.Normal
                    )
                }

            }
    }

}


@Composable
@Preview
fun ExpandablePre(){
    ExpandableCard()
}