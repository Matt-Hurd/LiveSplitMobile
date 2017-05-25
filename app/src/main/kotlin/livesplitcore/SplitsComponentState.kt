package livesplitcore

class SplitsComponentState internal constructor(ptr: Long) : SplitsComponentStateRefMut(ptr), AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.SplitsComponentState_drop(ptr)
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