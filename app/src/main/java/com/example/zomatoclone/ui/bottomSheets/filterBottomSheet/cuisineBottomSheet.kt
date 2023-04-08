package com.example.zomatoclone.ui.bottomSheets.filterBottomSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Checkbox
import androidx.compose.material.CheckboxDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclone.R
import com.example.zomatoclone.screens.mainScreen.MainScreenViewModel
import com.example.zomatoclone.utils.SearchBar
import com.example.zomatoclone.ui.theme.GreenPrimary

@Composable
fun CuisineBottomSheet(
    viewModel: MainScreenViewModel
) {
    val search = remember { mutableStateOf("") }
    val checkBoxStates = viewModel.getCheckBoxValues()
    var filteredList: List<String>

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Cuisines",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp)
        )
        Divider(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp), color = Color.LightGray)

        SearchBar(icon = R.drawable.search, "Search your Cuisine...", search) {}

        LazyColumn(
            modifier = Modifier
                .height(450.dp)
                .padding(top = 2.dp)
        ) {

            filteredList = viewModel.getFilteredList(search)

            itemsIndexed(filteredList) { index, filter ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 0.dp)
                        .clickable {
                            checkBoxStates[index] = !checkBoxStates[index]
                        },
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = filter,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily.SansSerif
                    )
                    Checkbox(
                        checked = checkBoxStates[index],
                        onCheckedChange = { checkBoxStates[index] = it },
                        colors = CheckboxDefaults.colors(
                            checkedColor = GreenPrimary,
                            uncheckedColor = Color.Gray.copy(0.7f)
                        ),
                    )
                }
            }
        }

        Divider(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp), color = Color.LightGray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .heightIn(56.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(
                text = "Clear All", modifier = Modifier.clickable { /*TODO*/ },
                color = GreenPrimary,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
            Button(
                onClick = { /*TODO*/ },
                modifier = Modifier.width(250.dp),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreenPrimary,
                    disabledBackgroundColor = Color(0xFFcccccc),
                ),
                shape = RoundedCornerShape(8.dp),
                elevation = null
            ) {
                Text(
                    text = "Apply",
                    modifier = Modifier.padding(vertical = 4.dp),
                    color =
                    Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SheetPreview1() {
    CuisineBottomSheet(MainScreenViewModel())
}