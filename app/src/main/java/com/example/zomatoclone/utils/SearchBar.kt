package com.example.zomatoclone.utils

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.zomatoclone.R
import com.example.zomatoclone.ui.header.HeaderViewModel
import com.example.zomatoclone.ui.theme.GreenPrimary


@Composable
fun SearchBar(icon: Int, placeholder: String, search: MutableState<String>, onclick: () -> Unit) {
    val viewModel: HeaderViewModel = viewModel()
    val focusRequester = remember { FocusRequester() }

    Surface(modifier = Modifier.fillMaxWidth()) {
        Card(
            Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth()
                .height(42.dp)
                .shadow(
                    elevation = 6.dp,
                    shape = RoundedCornerShape(13.dp),
                    clip = true
                )
            ,
            shape = RoundedCornerShape(25)
        ) {
            ConstraintLayout(
                searchBarConstrains(),
                modifier = Modifier.fillMaxWidth()
            ) {
                Icon(
                    painterResource(id = icon),
                    contentDescription = "Search", tint = GreenPrimary,
                    modifier = Modifier
                        .size(18.dp)
                        .layoutId("searchIcon")
                )


                BasicTextField(
                    value = search.value,
                    onValueChange = { search.value = it },
                    modifier = Modifier
                        .layoutId("searchField")
                        .fillMaxWidth()
                        .onFocusChanged {
                            if (it.isFocused && icon != R.drawable.back) {
                                onclick.invoke()
                            }
                        },
                    maxLines = 1,
                    textStyle = TextStyle.Default.copy(fontSize = 13.sp),
                    decorationBox = { innerTextField ->
                        if (search.value.isEmpty()) {
                            Text(
                                text = placeholder,
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Medium,
                                color = Color.Gray,
                            )
                        }
                        innerTextField()
                    }
                )


                Divider(
                    color = Color.LightGray,
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(1.dp)
                        .padding(vertical = 8.dp)
                        .layoutId("divider")
                )
                IconButton(
                    onClick = { /*TODO*/ },
                    Modifier.layoutId("mic")
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.microphone),
                        contentDescription = "Mic", tint = GreenPrimary,
                        modifier = Modifier
                            .size(16.dp)
                    )
                }
            }

        }
    }
}

@Composable
fun searchBarConstrains(): ConstraintSet {
    return ConstraintSet {
        val searchIcon = createRefFor("searchIcon")
        val searchField = createRefFor("searchField")
        val divider = createRefFor("divider")
        val mic = createRefFor("mic")

        constrain(searchIcon) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start, 16.dp)
            end.linkTo(searchField.start)
        }

        constrain(searchField) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(searchIcon.end, 8.dp)
        }

        constrain(mic) {
            end.linkTo(parent.end)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
        constrain(divider) {
            end.linkTo(mic.start)
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SearchbarPreview() {
    //SearchBar()
}
