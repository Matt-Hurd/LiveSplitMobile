package livesplitcore

open class SplitsComponentRefMut internal constructor(ptr: Long) : SplitsComponentRef(ptr) {
    fun stateAsJson(timer: TimerRef): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SplitsComponent_stateAsJson(ptr, timer.ptr)
        return result
    }

    fun state(timer: TimerRef): SplitsComponentState? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (timer.ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SplitsComponentState(
                LiveSplitCoreNative.SplitsComponent_state(ptr, timer.ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun scrollUp() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.SplitsComponent_scrollUp(ptr)
    }

    fun scrollDown() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.SplitsComponent_scrollDown(ptr)
    }

    fun setVisualSplitCount(count: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.SplitsComponent_setVisualSplitCount(ptr, count)
    }

    fun setSplitPreviewCount(count: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.SplitsComponent_setSplitPreviewCount(ptr, count)
    }

    fun setAlwaysShowLastSplit(alwaysShowLastSplit: Boolean) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative
                .SplitsComponent_setAlwaysShowLastSplit(ptr, alwaysShowLastSplit)
    }

    fun setSeparatorLastSplit(separatorLastSplit: Boolean) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative
                .SplitsComponent_setSeparatorLastSplit(ptr, separatorLastSplit)
    }
}