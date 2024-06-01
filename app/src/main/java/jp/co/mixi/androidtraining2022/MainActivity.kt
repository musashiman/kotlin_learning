package jp.co.mixi.androidtraining2022

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import jp.co.mixi.androidtraining2022.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = LapTimeAdapter()
        binding.recyclerView.adapter = adapter
//        mutableと付くものは、途中で値の変更を行いたい箇所に使用することが多い。
        val lapTimeList = mutableListOf<LapTime>()

        binding.primaryButton.setOnClickListener {
            val lapTime = LapTime(lapTimeList.size +1,0)
            lapTimeList.add(lapTime)
//            adapterに値を入れるため、submitListをする。
//            mutableListを操作するが、代入前の値も保持しておきたい場合はtoList()してあげる。
            adapter.submitList(lapTimeList.toList())
        }
    }
}