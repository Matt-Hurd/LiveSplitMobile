package livesplitcore

open class SegmentRef internal constructor(internal var ptr: Long) {
    fun name(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Segment_name(ptr)
        return result
    }

    fun icon(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Segment_icon(ptr)
        return result
    }

    fun comparison(comparison: String): TimeRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeRef(
                LiveSplitCoreNative.Segment_comparison(ptr, comparison))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun personalBestSplitTime(): TimeRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeRef(LiveSplitCoreNative.Segment_personalBestSplitTime(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun bestSegmentTime(): TimeRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeRef(LiveSplitCoreNative.Segment_bestSegmentTime(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun segmentHistory(): SegmentHistoryRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SegmentHistoryRef(LiveSplitCoreNative.Segment_segmentHistory(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }
}