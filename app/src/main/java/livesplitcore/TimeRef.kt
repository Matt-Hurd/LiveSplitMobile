package livesplitcore

open class TimeRef internal constructor(internal var ptr: Long) {
    fun copy(): Time? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = Time(LiveSplitCoreNative.Time_clone(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun realTime(): TimeSpanRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeSpanRef(LiveSplitCoreNative.Time_realTime(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun gameTime(): TimeSpanRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeSpanRef(LiveSplitCoreNative.Time_gameTime(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun index(timingMethod: Byte): TimeSpanRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeSpanRef(
                LiveSplitCoreNative.Time_index(ptr, timingMethod))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}