package livesplitcore

open class PossibleTimeSaveComponentStateRef internal constructor(internal var ptr: Long) {
    fun text(): String {
        if (ptr.equals(0))
            throw RuntimeException()

        return LiveSplitCoreNative.PossibleTimeSaveComponentState_text(ptr)
    }

    fun time(): String {
        if (ptr.equals(0))
            throw RuntimeException()

        return LiveSplitCoreNative.PossibleTimeSaveComponentState_time(ptr)
    }
}