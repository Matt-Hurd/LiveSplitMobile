package livesplitcore

class TimerComponent : TimerComponentRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.TimerComponent_drop(ptr)
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
        ptr = LiveSplitCoreNative.TimerComponent_new()
    }

    internal constructor(ptr: Long) : super(ptr) {}
}