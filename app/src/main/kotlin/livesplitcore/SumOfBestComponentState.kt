package livesplitcore

class SumOfBestComponentState internal constructor(ptr: Long) : SumOfBestComponentStateRefMut(ptr), AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.SumOfBestComponentState_drop(ptr)
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