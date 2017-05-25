package livesplitcore

open class PreviousSegmentComponentRef internal constructor(internal var ptr: Long) {
    fun stateAsJson(timer: TimerRef): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .PreviousSegmentComponent_stateAsJson(ptr, timer.ptr)
        return result
    }

    fun state(timer: TimerRef): PreviousSegmentComponentState? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = PreviousSegmentComponentState(
                LiveSplitCoreNative.PreviousSegmentComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}