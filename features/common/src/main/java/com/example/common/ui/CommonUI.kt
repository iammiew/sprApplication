package com.example.common.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.common.R
import com.example.common.state.AppBarUiState
import com.example.common.viewmodel.CommonViewModel
import com.example.common.viewmodel.HomeViewModel
import com.example.data.common.api.APIService
import com.example.data.home.model.LogoItem
import javax.inject.Inject


@Composable
fun appBarUI() {
//    val viewModel = hiltViewModel<CommonViewModel>()
//    HomeScreen(viewModel = viewModel)
//    testAPI()
//    headerBugabooTv()
    loadingAnimation()
}

@Composable
fun HomeScreen(
    viewModel: CommonViewModel,
) {
    val topAppBarUiState by viewModel.topAppBarUiState.collectAsState()
    TopAppBarUI(topAppBarUiState)
//    Text("asd")
}

@Composable
fun TopAppBarUI(
    topAppBarUiState: AppBarUiState,
) {
    var name by remember { mutableStateOf("News") }
//    var test by remember { mutableStateOf(listOf<ValuesTest>()) }

    if (topAppBarUiState.data != null) {
        name = topAppBarUiState.data.title
//        test = topAppBarUiState.data.test ?: listOf()
    }

//    val pagerState =
//        rememberPagerState(pageCount = { test.size })

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = name)
    }
//    HorizontalPager(state = pagerState) { page ->
//        AsyncImage(
//            model = test[page].price,
//            contentDescription = null,
//            contentScale = FillBounds,
//            modifier =
//            Modifier
//                .aspectRatio(16f / 9f),
//        )
//    }

}

@Composable
fun testAPI() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val homeBannerState = viewModel.homeBannerUiState.collectAsState()

    var status by remember { mutableStateOf("status") }
    var message by remember { mutableStateOf("message") }

    if (homeBannerState != null) {
        status = homeBannerState.value.data?.status ?: ""
        message = homeBannerState.value.data?.message ?: ""
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Text(text = status)
    }
}

@Composable
fun headerBugabooTv() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val commonViewModel = hiltViewModel<CommonViewModel>()

    val homeBannerState = viewModel.homeBannerUiState.collectAsState()
    val sizeAppbarState = commonViewModel.topAppBarUiState.collectAsState()

    var logo by remember { mutableStateOf(listOf<LogoItem>()) }
    var size by remember { mutableIntStateOf(0) }

    if (sizeAppbarState.value != null) {
        size = sizeAppbarState.value.data?.size ?: 0

        if (homeBannerState != null) {
            logo = homeBannerState.value.data?.data?.logo ?: listOf()
        }

        Row(
            modifier =
            Modifier
                .padding(top = 30.dp)
                .fillMaxWidth(),
        ) {
            logo.forEach {
                if (it.type == "square") {
                    coil.compose.AsyncImage(
                        model = it.image,
                        contentDescription = null,
                        modifier =
                        Modifier
                            .size(size.dp)
                            .aspectRatio(1f / 1f),
                    )
                } else if (it.type == "rectangle") {
                    coil.compose.AsyncImage(
                        model =
                        ImageRequest
                            .Builder(LocalContext.current)
                            .data(it.image)
                            .decoderFactory(SvgDecoder.Factory())
                            .build(),
                        contentDescription = null,
                        modifier =
                        Modifier
                            .padding(start = 8.dp)
                            .size(65.dp),
                    )
                }
            }
            Row(
                modifier =
                Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End,
            ) {
                Button(
                    onClick = {},
                ) {
                    Text("เข้าสู่ระบบ")
                }
            }
        }
    }
}

@Composable
fun loadingAnimation() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val loadingUiState = viewModel.loadingUiState.collectAsState()

    var loading by remember { mutableStateOf(false) }

    if (loading != null) {
        loading = loadingUiState.value
    }

    if (loading) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            lottieCloseExample(
                modifier = Modifier
                    .size(200.dp)
            )
        }
    } else {
        LayoutBugaboo()
    }
}

@Composable
fun lottieCloseExample(modifier: Modifier) {
    val preloaderLottieComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.animation_loading)
    )

    val preloaderProgress by animateLottieCompositionAsState(
        preloaderLottieComposition,
        iterations = 1,
        isPlaying = true,
    )

    LottieAnimation(
        composition = preloaderLottieComposition,
        progress = preloaderProgress,
        modifier = modifier,
        alignment = Alignment.Center
    )
}
