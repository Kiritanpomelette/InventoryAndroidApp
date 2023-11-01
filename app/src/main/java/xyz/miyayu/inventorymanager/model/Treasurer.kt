package xyz.miyayu.inventorymanager.model

import java.util.Date

data class Treasurer(
    val id:Int,
    val productId: Int,
    val managerId: Int,
    val modifyDate:Date,
    val count: Int
)

object TreasurerExt {
    fun List<Treasurer>.getCurrentCount(): Int{
        var sum = 0           //これいん
        this.forEach{ treasurer -> sum += treasurer.count
        }
        return sum
    }
    fun List<Treasurer>.getTodayCount():Int {
        var sum = 0
        val calendar = java.util.Calendar.getInstance()
        val todayYear = calendar.get(java.util.Calendar.YEAR)
        val todayMonth = calendar.get(java.util.Calendar.MONTH)
        val todayDay = calendar.get(java.util.Calendar.DAY_OF_MONTH)
        forEach { treasurer -> calendar.time = treasurer.modifyDate
            if (calendar.get(java.util.Calendar.YEAR) == todayYear &&
                calendar.get(java.util.Calendar.MONTH) == todayMonth &&
                calendar.get(java.util.Calendar.DAY_OF_MONTH) == todayDay){
                sum += treasurer.count
            }
        }
        return sum
    }
}