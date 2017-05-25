package livesplitcore

open class SumOfBestComponentRef internal constructor(internal var ptr: Long) {
    fun stateAsJson(timer: TimerRef): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SumOfBestComponent_stateAsJson(ptr, timer.ptr)
        return result
    }

    fun state(timer: TimerRef): SumOfBestComponentState? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SumOfBestComponentState(
                LiveSplitCoreNative.SumOfBestComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}