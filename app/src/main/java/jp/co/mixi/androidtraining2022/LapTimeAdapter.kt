package jp.co.mixi.androidtraining2022

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import jp.co.mixi.androidtraining2022.databinding.LapTimeItemBinding

// 　Adapterはリストビューを描画する際に使用する。Viewとのデータの橋渡し役
class LapTimeAdapter : ListAdapter<LapTime, LapTimeAdapter.ViewHolder>(DiffCallback()) {

//   行目のViewHodlerをインスタンス化。
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LapTimeItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

//    ここでリストに表示するデータを決定。
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lapTime = getItem(position)

        holder.binding.lapNumber.text = lapTime.number.toString()
        holder.binding.lapTime.text =  "次章にて記載"
    }

//    リストに表示する数を決めたい場合は、getItemCount()を使う。
//    override fun getItemCount(): Int {
//    return 10
//  }

    class ViewHolder(
        val binding: LapTimeItemBinding
    ) : RecyclerView.ViewHolder(binding.root)

    class DiffCallback : DiffUtil.ItemCallback<LapTime>() {
        override fun areItemsTheSame(oldItem: LapTime, newItem: LapTime): Boolean {
            return oldItem.number == newItem.number
        }

        override fun areContentsTheSame(oldItem: LapTime, newItem: LapTime): Boolean {
            return oldItem == newItem
        }
    }
}