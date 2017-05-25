package livesplitcore

class SplitsComponent : SplitsComponentRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.SplitsComponent_drop(ptr)
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
        ptr = LiveSplitCoreNative.SplitsComponent_new()
    }

    internal constructor(ptr: Long) : super(ptr) {}
}