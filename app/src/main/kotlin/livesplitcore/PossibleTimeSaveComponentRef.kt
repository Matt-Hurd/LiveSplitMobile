package livesplitcore

import livesplitcore.util.stateAsJsonHelper

open class PossibleTimeSaveComponentRef internal constructor(internal var ptr: Long) {
    fun stateAsJson(timer: TimerRef): String {
        return stateAsJsonHelper(timer, ptr, LiveSplitCoreNative::PossibleTimeSaveComponent_stateAsJson)
    }

    fun state(timer: TimerRef): PossibleTimeSaveComponentState? {
        if (ptr.equals(0) || timer.ptr.equals(0))
            throw RuntimeException()

        val result = PossibleTimeSaveComponentState(
                LiveSplitCoreNative.PossibleTimeSaveComponent_state(ptr, timer.ptr))
        return if (result.ptr.equals(0)) null else result
    }
}