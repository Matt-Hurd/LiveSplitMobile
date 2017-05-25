package livesplitcore

import livesplitcore.util.stateAsJsonHelper

open class SumOfBestComponentRef internal constructor(internal var ptr: Long) {
    fun stateAsJson(timer: TimerRef): String {
        return stateAsJsonHelper(timer, ptr, LiveSplitCoreNative::SumOfBestComponent_stateAsJson)
    }

    fun state(timer: TimerRef): SumOfBestComponentState? {
        if (ptr.equals(0) || timer.ptr.equals(0))
            throw RuntimeException()

        val result = SumOfBestComponentState(
                LiveSplitCoreNative.SumOfBestComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}