package livesplitcore

open class TimerWriteLockRefMut internal constructor(ptr: Long) : TimerWriteLockRef(ptr) {
    fun timer(): TimerRefMut? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimerRefMut(LiveSplitCoreNative.TimerWriteLock_timer(
                ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}