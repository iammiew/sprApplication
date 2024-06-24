package com.example.data.common.di

//import com.example.data.appbar.repository.AppBarCommonRepository
//import com.example.data.appbar.repository.AppBarCommonRepositoryImpl
//import com.example.common.viewmodel.CommonViewModel
//import org.koin.androidx.viewmodel.dsl.viewModel
//import org.koin.core.module.dsl.singleOf
//import org.koin.dsl.module
//import org.koin.core.module.dsl.bind

//val appModule = module {
//    singleOf(::AppBarCommonRepositoryImpl) { bind<AppBarCommonRepository>() }
//    viewModel {
//        CommonViewModel(get())
//    }
//}

//// Classical DSL version
////val appModule = module {
////    single<AppBarCommonRepository> { AppBarCommonRepositoryImpl() }
//////    factory { MyPresenter(get()) }
//////    viewModel { MyViewModel(get()) }
////}