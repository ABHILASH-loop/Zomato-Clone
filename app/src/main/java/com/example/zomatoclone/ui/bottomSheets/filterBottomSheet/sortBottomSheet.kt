package com.example.zomatoclone.ui.bottomSheets.filterBottomSheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclone.screens.mainScreen.MainScreenViewModel
import com.example.zomatoclone.ui.theme.GreenPrimary

@Composable
fun SortBottomSheet(
    viewModel: MainScreenViewModel
) {

   val selectedButtonState = viewModel.selectedButtonState

    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = "Sort",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            modifier = Modifier.padding(16.dp)
        )
        Divider(Modifier.fillMaxWidth(), color = Color.LightGray)

        viewModel.SortFilters()

        Divider(
            Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp), color = Color.LightGray)
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
                enabled = selectedButtonState.value != 0,
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
                    color = if (selectedButtonState.value == 0) {
                        Color.Gray
                    } else {
                        Color.White
                    },
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SheetPreview() {
    SortBottomSheet(MainScreenViewModel())
}