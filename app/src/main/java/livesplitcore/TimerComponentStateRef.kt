package livesplitcore

open class TimerComponentStateRef internal constructor(internal var ptr: Long) {
    fun time(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TimerComponentState_time(ptr)
        return result
    }

    fun fraction(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TimerComponentState_fraction(ptr)
        return result
    }

    fun color(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.TimerComponentState_color(ptr)
        return result
    }
}