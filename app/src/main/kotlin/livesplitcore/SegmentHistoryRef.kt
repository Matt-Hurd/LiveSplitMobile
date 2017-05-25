package livesplitcore

open class SegmentHistoryRef internal constructor(internal var ptr: Long) {
    fun iter(): SegmentHistoryIter? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SegmentHistoryIter(LiveSplitCoreNative.SegmentHistory_iter(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}