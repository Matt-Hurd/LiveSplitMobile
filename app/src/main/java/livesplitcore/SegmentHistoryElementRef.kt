package livesplitcore

open class SegmentHistoryElementRef internal constructor(internal var ptr: Long) {
    fun index(): Int {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.SegmentHistoryElement_index(ptr)
        return result
    }

    fun time(): TimeRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeRef(LiveSplitCoreNative.SegmentHistoryElement_time(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}