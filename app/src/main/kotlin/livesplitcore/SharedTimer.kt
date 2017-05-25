package livesplitcore

class SharedTimer internal constructor(ptr: Long) : SharedTimerRefMut(ptr), AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.SharedTimer_drop(ptr)
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