package livesplitcore

class PossibleTimeSaveComponentState internal constructor(ptr: Long) : PossibleTimeSaveComponentStateRefMut(ptr), AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.PossibleTimeSaveComponentState_drop(ptr)
            ptr = 0
        }
    }

    @Throws(Throwable::class)
    private fun finalize() {
        drop()
    }

    override fun close() {
        drop()
    }
}