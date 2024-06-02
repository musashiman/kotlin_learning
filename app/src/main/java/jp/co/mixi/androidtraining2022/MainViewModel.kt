package jp.co.mixi.androidtraining2022

import android.app.Application
import androidx.lifecycle.*
import kotlinx.coroutines.delay

class MainViewModel(application: Application) : AndroidViewModel(application) {

    // 現在のタイマーの状態
    val state = MutableLiveData<State>(State.CLEAR)

    // 右側のボタンのアクションタイプ。タイマーの状態によって変化させる
    val primaryButtonType = state.map { state ->
        TODO()
    }

//    lifecycleScopeを追加すれば、非同期にて処理を行うことが可能になる。
//    仮にid:timeTextというビューのtextを使用し、1秒ごとにカウントする場合は、下記のようになる。
//    lifecycleScope.launch {
//        binding.timeText.text = "0秒"
//        launch {
//            delay(1000)
//            binding.timeText.text  = "1秒経過"
//        }
//        launch {
//            delay(2000)
//            binding.timeText. = "2秒経過"
//        }
//        launch {
//            delay(3000)
//            binding.timeText.text = "3秒経過"
//        }
//    }

    // タイマーの開始時刻(ミリ秒)
    private var timerStartedAt: Long = 0L

    // 現在のタイマー経過時間(ミリ秒)
    val currentTime = state.switchMap { state ->
        liveData {
            when (state) {
                State.CLEAR -> {
                    timerStartedAt = 0L
                    emit(0L)
                }
                State.START -> {
                    if (timerStartedAt == 0L) {
                        timerStartedAt = System.currentTimeMillis()
                    }
                    while (true) {
                        emit(System.currentTimeMillis() - timerStartedAt)
                        delay(10L)
                    }
                }
                State.STOP -> {
                    // do nothing
                }
            }
        }
    }
}