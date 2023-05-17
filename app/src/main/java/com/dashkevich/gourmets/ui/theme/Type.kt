package com.dashkevich.gourmets.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.dashkevich.gourmets.R
import com.dashkevich.gourmets.ui.theme.model.GourmetsTypography


val Roboto = FontFamily(
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold)
)

val SFProText = FontFamily(
    Font(R.font.sfprotext_regular, FontWeight.Normal),
    Font(R.font.sfprotext_semibold, FontWeight.SemiBold)

)

val GourmetsTypography = GourmetsTypography(
    button = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,
        fontSize = 16.sp,
        lineHeight = 16.sp,
    ),
    body2 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp
    ),
    body2Secondary = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        textAlign = TextAlign.Center
    ),
    h4 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 34.sp,
        lineHeight = 36.sp
    ),
    body1 = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    h18 = TextStyle(
        //Todo fix font
        fontFamily = Roboto,
        //Todo("Roboto - SemiBold по дизайну")
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 22.5.sp
    ),
    body1MediumSecondary = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        textAlign = TextAlign.Right
    ),
    body1Medium = TextStyle(
        fontFamily = Roboto,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    defaultRegularBody = TextStyle(
        fontFamily = SFProText,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        lineHeight = 22.sp,
        letterSpacing = (-0.41).sp
    ),
    defaultBoldCaption2 = TextStyle(
        fontFamily = SFProText,
        fontWeight = FontWeight.SemiBold,
        fontSize = 11.sp,
        lineHeight = 13.sp,
        letterSpacing = 0.06.sp,
        textAlign = TextAlign.Center
    )
)