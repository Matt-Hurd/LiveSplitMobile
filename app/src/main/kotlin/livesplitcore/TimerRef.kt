package livesplitcore

open class TimerRef internal constructor(internal var ptr: Long) {
    fun currentTimingMethod(): Byte {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Timer_currentTimingMethod(ptr)
        return result
    }

    fun currentComparison(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Timer_currentComparison(ptr)
        return result
    }

    val isGameTimeInitialized: Boolean
        get() {
            if (ptr.equals(0)) {
                throw RuntimeException()
            }
            val result = LiveSplitCoreNative.Timer_isGameTimeInitialized(ptr)
            return result
        }
    val isGameTimePaused: Boolean
        get() {
            if (ptr.equals(0)) {
                throw RuntimeException()
            }
            val result = LiveSplitCoreNative.Timer_isGameTimePaused(ptr)
            return result
        }

    fun loadingTimes(): TimeSpanRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeSpanRef(LiveSplitCoreNative.Timer_loadingTimes(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun currentPhase(): Byte {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Timer_currentPhase(ptr)
        return result
    }

    val run: RunRef?
        get() {
            if (ptr.equals(0)) {
                throw RuntimeException()
            }
            val result = RunRef(LiveSplitCoreNative.Timer_getRun(ptr))
            if (result.ptr.equals(0)) {
                return null
            }
            return result
        }

    fun cloneRun(): Run? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = Run(LiveSplitCoreNative.Timer_cloneRun(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun printDebug() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.Timer_printDebug(ptr)
    }
}