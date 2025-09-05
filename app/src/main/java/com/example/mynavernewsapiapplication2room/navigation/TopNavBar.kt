package com.example.mynavernewsapiapplication2room.navigation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mynavernewsapiapplication2room.ui.theme.BabySharkTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopNavBar(
    navController: NavController
) {
    var isExpanded by remember { mutableStateOf(false) }
    var userQuery by remember { mutableStateOf("") }

    //테스트용
//    println("확장여부: $isExpanded")
//    println("userQuery: $userQuery")

    TopAppBar(
        title = { Text(
            text = "Search Naver News",
            style = BabySharkTheme.typography.topNavBarBold
        )
        },
        navigationIcon = {
            IconButton(onClick = { /* 메뉴 아이콘 클릭 시 동작 */ }) {
                Icon(Icons.Filled.Menu, contentDescription = "메뉴")
            }
        },
        windowInsets = WindowInsets.systemBars,
        actions = {
            if (isExpanded) {
                Row(
                    verticalAlignment = Alignment.CenterVertically, // 아이콘과 텍스트를 수직 중앙 정렬
                    horizontalArrangement = Arrangement.Start // 시작점부터 정렬
                ) {

                    TextField(
                        value = userQuery,
                        singleLine = true,
                        onValueChange = { userQuery = it }, // 텍스트가 변경될 때 호출되는 콜백
                        placeholder = { Text("검색어를 입력하세요.") }, // 입력 필드가 비어 있을 때 표시될 텍스트
                        trailingIcon = {
                            AnimatedVisibility(
                                visible = userQuery.isNotEmpty(), // 텍스트가 비어 있지 않을 때만 호출
                                enter = fadeIn(), // 표시될 때 애니메이션 효과를 추가합니다.
                                exit = fadeOut() // 사라질 때 애니메이션 효과를 추가합니다.
                            ) {
                                // 내용이 있을 때만 나타날 아이콘 정의
                                Icon(
                                    imageVector = Icons.Default.Clear, // 내장된 삭제 아이콘
                                    contentDescription = "검색어 삭제", // 접근성을 위한 설명
                                    modifier = Modifier.clickable { userQuery = "" } // 아이콘을 클릭시 텍스트 초기화
                                )
                            }
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    IconButton(onClick = {
                        isExpanded = !isExpanded
                        if (userQuery.isNotEmpty()) {
                            navController.navigate("news/${userQuery}")
                        }
                    }) {
                        Icon(Icons.Filled.Search, contentDescription = "검색")
                    }
                }
            } else {
                IconButton(onClick = {
                    isExpanded = !isExpanded
                    userQuery = ""
                }) {
                    Icon(Icons.Filled.Search, contentDescription = "검색창 확장")
                }
            }

            IconButton(onClick = { /* 더보기 아이콘 클릭 시 동작 */ }) {
                Icon(Icons.Filled.MoreVert, contentDescription = "더보기")
            }
        }

    )
}
