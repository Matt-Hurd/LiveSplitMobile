package livesplitcore

open class TimerReadLockRef internal constructor(internal var ptr: Long) {
    fun timer(): TimerRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimerRef(LiveSplitCoreNative.TimerReadLock_timer(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}