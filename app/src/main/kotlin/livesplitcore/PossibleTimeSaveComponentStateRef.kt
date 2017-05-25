package livesplitcore

open class PossibleTimeSaveComponentStateRef internal constructor(internal var ptr: Long) {
    fun text(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.PossibleTimeSaveComponentState_text(ptr)
        return result
    }

    fun time(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.PossibleTimeSaveComponentState_time(ptr)
        return result
    }
}