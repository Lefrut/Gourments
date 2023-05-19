package com.dashkevich.gourmets.ui.screens.catalog.companents

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.data.api.model.TagX
import com.dashkevich.gourmets.ui.components.PrimaryButton
import com.dashkevich.gourmets.ui.theme.Theme
import com.dashkevich.gourmets.ui.util.shadow
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogBottomSheet(
    filters: List<Pair<TagX, Boolean>>,
    onCheckedClick: (Int, Boolean) -> Unit,
    onButtonClick: () -> Unit,
    onCloseBottomSheet: (Boolean) -> Unit,
    sheetState: SheetState
) {
    ModalBottomSheet(
        sheetState = sheetState,
        modifier = Modifier
            .height(312.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp),
        containerColor = Theme.colors.surface,
        onDismissRequest = {
            onCloseBottomSheet(false)
        },
        dragHandle = null
    ) {
        Text(
            text = stringResource(R.string.Подобрать_блюда),
            style = Theme.fonts.h6,
            color = Theme.colors.onSurfaceSecondary,
            modifier = Modifier
                .padding(start = 24.dp, end = 24.dp, top = 32.dp, bottom = 16.dp)
                .fillMaxWidth()
        )
        LazyColumn() {
            items(filters.size) { index ->
                val filter = filters[index]
                CatalogFilterItem(
                    name = filter.first.name,
                    isChecked = filter.second,
                    onCheckedClick = { onCheckedClick(index, !filter.second) }
                )
            }
            item() {
                Column(modifier = Modifier.fillMaxWidth()) {
                    val scope = rememberCoroutineScope()
                    Spacer(modifier = Modifier.height(16.dp))
                    PrimaryButton(
                        onClick = {
                            onButtonClick()
                        },
                        modifier = Modifier
                            .align(Alignment.CenterHorizontally)
                            .size(width = 327.dp, height = 48.dp),
                        content = {
                            Text(
                                text = stringResource(R.string.готово),
                                color = Theme.colors.surface,
                                style = Theme.fonts.button,
                                maxLines = 1
                            )
                        }
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                }
            }
        }
    }

}
