package livesplitcore

open class TimeSpanRef internal constructor(internal var ptr: Long) {
    fun copy(): TimeSpan? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeSpan(LiveSplitCoreNative.TimeSpan_clone(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun totalSeconds(): Double {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TimeSpan_totalSeconds(ptr)
        return result
    }
}