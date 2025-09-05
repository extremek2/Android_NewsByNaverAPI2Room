package com.example.myloginapplication.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.mynavernewsapiapplication.R

private val pinkpongBabySharkFontStyle = FontFamily(
    Font(R.font.pinkfong_baby_shark_font_regular, weight = FontWeight.Normal),
    Font(R.font.pinkfong_baby_shark_font_bold, weight = FontWeight.Bold),
    Font(R.font.pinkfong_baby_shark_font_light, weight = FontWeight.Light)
)

internal val Typography: BabySharkTypography = BabySharkTypography(
    topNavBarBold = TextStyle(
        fontFamily = pinkpongBabySharkFontStyle,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 36.sp
    ),
    bottomNavBarRegular = TextStyle(
        fontFamily = pinkpongBabySharkFontStyle,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 20.sp
    ),
    h1Regular = TextStyle(
        fontFamily = pinkpongBabySharkFontStyle,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    h1Bold = TextStyle(
        fontFamily = pinkpongBabySharkFontStyle,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp

    ),
    h1Light = TextStyle(
        fontFamily = pinkpongBabySharkFontStyle,
        fontWeight = FontWeight.Light,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )
)

@Immutable
data class BabySharkTypography(
    val topNavBarBold: TextStyle,
    val bottomNavBarRegular: TextStyle,
    val h1Regular: TextStyle,
    val h1Bold: TextStyle,
    val h1Light: TextStyle

)

val LocalBabySharkTypography = staticCompositionLocalOf {
    BabySharkTypography(
        topNavBarBold = TextStyle.Default,
        bottomNavBarRegular = TextStyle.Default,
        h1Regular = TextStyle.Default,
        h1Bold = TextStyle.Default,
        h1Light = TextStyle.Default
    )
}



// Set of Material typography styles to start with

/*
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
*/
