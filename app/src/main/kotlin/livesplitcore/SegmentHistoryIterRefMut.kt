package livesplitcore

open class SegmentHistoryIterRefMut internal constructor(ptr: Long) : SegmentHistoryIterRef(ptr) {
    operator fun next(): SegmentHistoryElementRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SegmentHistoryElementRef(LiveSplitCoreNative.SegmentHistoryIter_next(
                ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}