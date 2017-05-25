package livesplitcore

open class TitleComponentRefMut internal constructor(ptr: Long) : TitleComponentRef(ptr) {
    fun stateAsJson(timer: TimerRef): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TitleComponent_stateAsJson(ptr,
                timer.ptr)
        return result
    }

    fun state(timer: TimerRef): TitleComponentState? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TitleComponentState(
                LiveSplitCoreNative.TitleComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}