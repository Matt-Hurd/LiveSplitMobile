package livesplitcore

class Timer : TimerRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.Timer_drop(ptr)
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

    constructor(run: Run) : super(0) {
        if (run.ptr.equals(0)) {
            throw RuntimeException()
        }
        ptr = LiveSplitCoreNative.Timer_new(run.ptr)
        run.ptr = 0
    }

    fun intoShared(): SharedTimer? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SharedTimer(LiveSplitCoreNative.Timer_intoShared(ptr))
        ptr = 0
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    internal constructor(ptr: Long) : super(ptr) {}
}