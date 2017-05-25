package livesplitcore

open class TimerRefMut internal constructor(ptr: Long) : TimerRef(ptr) {
    fun split() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_split(ptr)
    }

    fun skipSplit() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_skipSplit(ptr)
    }

    fun undoSplit() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_undoSplit(ptr)
    }

    fun reset(updateSplits: Boolean) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_reset(ptr, updateSplits)
    }

    fun pause() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_pause(ptr)
    }

    fun setCurrentTimingMethod(method: Byte) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_setCurrentTimingMethod(ptr, method)
    }

    fun switchToNextComparison() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_switchToNextComparison(ptr)
    }

    fun switchToPreviousComparison() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_switchToPreviousComparison(ptr)
    }

    fun initializeGameTime() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_initializeGameTime(ptr)
    }

    fun uninitializeGameTime() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_uninitializeGameTime(ptr)
    }

    fun pauseGameTime() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_pauseGameTime(ptr)
    }

    fun unpauseGameTime() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_unpauseGameTime(ptr)
    }

    fun setGameTime(time: TimeSpanRef) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (time.ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_setGameTime(ptr, time.ptr)
    }

    fun setLoadingTimes(time: TimeSpanRef) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        if (time.ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_setLoadingTimes(ptr, time.ptr)
    }
}