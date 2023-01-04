package com.ilhomsoliev.hikmatlar.presentation.quoteDetails

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilhomsoliev.hikmatlar.app.components.bottomnav.BottomSheetIcon
import com.ilhomsoliev.hikmatlar.core.Constants
import com.ilhomsoliev.hikmatlar.domain.model.Quote
import com.ilhomsoliev.hikmatlar.presentation.components.QuoteContent

@Composable
fun QuoteDetailsScreen(
    request:String,
    type:String,
    onHomeClick:()->Unit,
    viewModel: QuoteDetailsScreenViewModel = hiltViewModel()
) {
    LaunchedEffect(key1 = false){
        if(type == Constants.CATEGORY_TYPE){
            viewModel.getQuotesByCategory(category = request)
        }else{
            viewModel.getQuotesByAuthor(author = request)
        }
    }


    val quotes: List<Quote> = viewModel.quotes
    val currentQuoteIndex by viewModel.currentQuoteIndex


    if(currentQuoteIndex != -1 && quotes.size > currentQuoteIndex){
        quotes[currentQuoteIndex].let {
            QuoteContent(category = it.category?:"",
                content = it.citaty?:"", author = it.author?:"")
        }
    }
    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {

        Row(
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp, top = 8.dp, bottom = 8.dp)
                .clip(RoundedCornerShape(14.dp))
                .background(Color(0xFF3F3D3D))
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BottomSheetIcon(
                    icon = Icons.Filled.ArrowBack,
                    onClick = {
                        viewModel.prevQuote()
                    })

                BottomSheetIcon(
                    icon = Icons.Default.Home,
                    onClick = {
                        onHomeClick()

                    })
                Text(text = "${currentQuoteIndex + 1}/${quotes.size}", fontSize = 24.sp, color = Color.White)

                BottomSheetIcon(
                    icon = Icons.Default.Share,
                    onClick = {
                        /*val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "${quotes[currentQuoteIndex].citaty}\n${quotes[currentQuoteIndex].author}")
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)*/
                    })
                BottomSheetIcon(
                    icon = Icons.Default.ArrowForward,
                    onClick = {
                        viewModel.nextQuote()

                    })
            }
        }
    }
}