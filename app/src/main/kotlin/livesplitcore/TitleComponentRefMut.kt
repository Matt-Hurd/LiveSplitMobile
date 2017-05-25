package livesplitcore

import livesplitcore.util.stateAsJsonHelper

open class TitleComponentRefMut internal constructor(ptr: Long) : TitleComponentRef(ptr) {
    fun stateAsJson(timer: TimerRef): String {
        return stateAsJsonHelper(timer, ptr, LiveSplitCoreNative::TitleComponent_stateAsJson)
    }

    fun state(timer: TimerRef): TitleComponentState? {
        if (ptr.equals(0) || timer.ptr.equals(0))
            throw RuntimeException()

        val result = TitleComponentState(
                LiveSplitCoreNative.TitleComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}