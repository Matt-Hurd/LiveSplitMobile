package livesplitcore

class Run : RunRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.Run_drop(ptr)
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

    constructor() : super(0) {
        ptr = LiveSplitCoreNative.Run_new()
    }

    internal constructor(ptr: Long) : super(ptr) {}

    companion object {
        fun parse(data: Long, length: Long): Run? {
            val result = Run(LiveSplitCoreNative.Run_parse(data, length))
            if (result.ptr.equals(0)) {
                return null
            }
            return result
        }

        fun parse(data: String): Run? {
            val result = Run(LiveSplitCoreNative.Run_parseString(data))
            if (result.ptr.equals(0)) {
                return null
            }
            return result
        }
    }
}