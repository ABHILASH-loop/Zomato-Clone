package com.example.zomatoclone.utils

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclone.R
import com.example.zomatoclone.ui.header.filterButton.FilterInfo

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterButton(
    filter: FilterInfo
){
    Surface(
        onClick = {
            filter.onClick.invoke()
                  },
        elevation = 2.dp,
        shape = RoundedCornerShape(30),
        modifier = Modifier.padding(4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 8.dp)) {
            filter.icon()

            Text(
                text = filter.text,
                fontWeight = FontWeight.SemiBold,
                fontSize = 12.sp
            )

            if(filter.dropDown){
                Icon(painter = painterResource(id = R.drawable.sort_down),
                    contentDescription = "DropDown",
                    tint = Color(0xFF2D2D2D),
                    modifier = Modifier.size(18.dp).padding(4.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun FilterButtonPreview(){

}