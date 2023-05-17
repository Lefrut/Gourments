package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.screens.catalog.model.FoodCatalog
import com.dashkevich.gourmets.ui.theme.GourmetsTheme
import com.dashkevich.gourmets.ui.theme.Theme
import com.dashkevich.gourmets.ui.util.ZeroCardElevation

@Composable
fun FoodCard(
    modifier: Modifier = Modifier,
    foodCatalog: FoodCatalog,
    //TODO("Переделать под логику")
    onClick: () -> Unit = {},
    onButtonClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .size(height = 290.dp, width = 167.5.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(Theme.shapes.default),
        colors = CardDefaults.cardColors(
            containerColor = Theme.colors.background,
        ),
        elevation = ZeroCardElevation()
    ) {
        val oldPrice = if (foodCatalog.oldPrice == null) "" else " ${foodCatalog.oldPrice}"
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Box() {
                Box(
                    modifier = Modifier
                        .align(Alignment.TopStart)
                        .padding(top = 8.dp, start = 8.dp)
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(color = Theme.colors.onSurfaceTernary),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.sale),
                        contentDescription = null,
                        modifier = Modifier.size(12.dp)
                    )
                }
                Image(
                    //TODO("Использовать картинку из интернета")
                    painter = painterResource(id = R.drawable.food),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                )
            }
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = foodCatalog.name,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.size(width = 143.5.dp, height = 20.dp),
                style = Theme.fonts.body2,
                color = Theme.colors.onSurfaceSecondary
            )
            Text(
                text = "${foodCatalog.weight} ${foodCatalog.weight_unit}",
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.size(width = 143.5.dp, height = 20.dp),
                style = Theme.fonts.body2,
                color = Theme.colors.onSurfaceTernary
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                modifier = Modifier
                    .background(
                        color = Theme.colors.surface,
                        shape = RoundedCornerShape(Theme.shapes.default)
                    )
                    .size(height = 40.dp, width = 143.5.dp),
                onClick = { onButtonClick() },
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Theme.colors.surface
                )
            ) {
                Text(
                    text = "${foodCatalog.currentPrice} ₽",
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = Theme.fonts.button,
                    color = Theme.colors.onSurfaceSecondary
                )
                if (oldPrice != "") {
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "$oldPrice ₽",
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        style = Theme.fonts.body2Secondary.copy(
                            textDecoration = TextDecoration.LineThrough
                        ),
                        color = Theme.colors.onSurfaceTernary
                    )
                }
            }
        }
    }
}


@Preview
@Composable
fun FoodCardPreview() {
    GourmetsTheme {
        FoodCard(
            foodCatalog = FoodCatalog(
                1,
                "Том ям",
                350,
                300,
                250,
                "г",
                "https:\\storage\\dog.jpg"
            )
        )
    }
}
