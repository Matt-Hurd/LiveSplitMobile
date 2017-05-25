package livesplitcore

class TimeSpan internal constructor(ptr: Long) : TimeSpanRefMut(ptr), AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.TimeSpan_drop(ptr)
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

    companion object {
        fun fromSeconds(seconds: Double): TimeSpan? {
            val result = TimeSpan(LiveSplitCoreNative.TimeSpan_fromSeconds(seconds))
            if (result.ptr.equals(0)) {
                return null
            }
            return result
        }
    }
}