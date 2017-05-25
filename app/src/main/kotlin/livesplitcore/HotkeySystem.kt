package livesplitcore

class HotkeySystem : HotkeySystemRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.HotkeySystem_drop(ptr)
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

    constructor(sharedTimer: SharedTimer) : super(0) {
        if (sharedTimer.ptr.equals(0))
            throw RuntimeException()

        ptr = LiveSplitCoreNative.HotkeySystem_new(sharedTimer.ptr)
        sharedTimer.ptr = 0
    }

    internal constructor(ptr: Long) : super(ptr) {}
}