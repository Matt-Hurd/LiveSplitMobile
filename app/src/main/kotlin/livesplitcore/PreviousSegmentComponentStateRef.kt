package livesplitcore

open class PreviousSegmentComponentStateRef internal constructor(internal var ptr: Long) {
    fun text(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.PreviousSegmentComponentState_text(ptr)
        return result
    }

    fun time(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.PreviousSegmentComponentState_time(ptr)
        return result
    }
}