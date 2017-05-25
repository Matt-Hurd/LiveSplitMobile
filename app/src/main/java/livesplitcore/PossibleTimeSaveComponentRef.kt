package livesplitcore

open class PossibleTimeSaveComponentRef internal constructor(internal var ptr: Long) {
    fun stateAsJson(timer: TimerRef): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .PossibleTimeSaveComponent_stateAsJson(ptr, timer.ptr)
        return result
    }

    fun state(timer: TimerRef): PossibleTimeSaveComponentState? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = PossibleTimeSaveComponentState(
                LiveSplitCoreNative.PossibleTimeSaveComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}