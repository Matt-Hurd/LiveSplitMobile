package livesplitcore

open class SumOfBestComponentStateRef internal constructor(internal var ptr: Long) {
    fun text(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SumOfBestComponentState_text(ptr)
        return result
    }

    fun time(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SumOfBestComponentState_time(ptr)
        return result
    }
}