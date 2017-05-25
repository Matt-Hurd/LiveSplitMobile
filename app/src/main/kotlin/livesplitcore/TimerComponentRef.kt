package livesplitcore

open class TimerComponentRef internal constructor(internal var ptr: Long) {
    fun stateAsJson(timer: TimerRef): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TimerComponent_stateAsJson(ptr, timer.ptr)
        return result
    }

    fun state(timer: TimerRef): TimerComponentState? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimerComponentState(
                LiveSplitCoreNative.TimerComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}