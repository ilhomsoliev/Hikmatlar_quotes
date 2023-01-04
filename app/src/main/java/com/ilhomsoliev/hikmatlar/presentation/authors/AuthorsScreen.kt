package com.ilhomsoliev.hikmatlar.presentation.authors

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.ilhomsoliev.hikmatlar.core.Helper
import com.ilhomsoliev.hikmatlar.presentation.categories.CategoriesScreenViewModel
import com.ilhomsoliev.hikmatlar.presentation.components.ColoredItem
import com.ilhomsoliev.hikmatlar.presentation.components.Title

@Composable
fun AuthorsScreen(openQuoteDetails:(String)->Unit,viewModel: AuthorsScreenViewModel = hiltViewModel()) {
    val authors: List<String> = viewModel.authors
    LazyColumn() {
        item {
            Title(
                modifier = Modifier.padding(vertical = 32.dp),
                text = "Mualliflar",
            )
        }
        itemsIndexed(authors) { id: Int, author: String ->
            ColoredItem(color = Helper.getColorByIndex(id), onClick = {
                openQuoteDetails(author)
            }, text = author)
        }
        item{
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}