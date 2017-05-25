package livesplitcore

class Segment : SegmentRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
            LiveSplitCoreNative.Segment_drop(ptr)
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

    constructor(name: String) : super(0) {
        ptr = LiveSplitCoreNative.Segment_new(name)
    }

    internal constructor(ptr: Long) : super(ptr) {}
}