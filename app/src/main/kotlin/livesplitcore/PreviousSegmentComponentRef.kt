package livesplitcore

import livesplitcore.LiveSplitCoreNative.PreviousSegmentComponent_stateAsJson
import livesplitcore.util.stateAsJsonHelper

open class PreviousSegmentComponentRef internal constructor(internal var ptr: Long){
    fun stateAsJson(timer: TimerRef): String {
        return stateAsJsonHelper(timer, ptr, ::PreviousSegmentComponent_stateAsJson)
    }

    fun state(timer: TimerRef): PreviousSegmentComponentState? {
        if (ptr.equals(0) || timer.ptr.equals(0))
            throw RuntimeException()

        val result = PreviousSegmentComponentState(
                LiveSplitCoreNative.PreviousSegmentComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}