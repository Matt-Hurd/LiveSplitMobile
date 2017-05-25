package livesplitcore

open class RunRef internal constructor(internal var ptr: Long) {
    fun gameName(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_gameName(ptr)
        return result
    }

    fun gameIcon(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_gameIcon(ptr)
        return result
    }

    fun categoryName(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_categoryName(ptr)
        return result
    }

    fun extendedFileName(useExtendedCategoryName: Boolean): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .Run_extendedFileName(ptr, useExtendedCategoryName)
        return result
    }

    fun extendedName(useExtendedCategoryName: Boolean): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .Run_extendedName(ptr, useExtendedCategoryName)
        return result
    }

    fun extendedCategoryName(showRegion: Boolean, showPlatform: Boolean, showVariables: Boolean): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .Run_extendedCategoryName(ptr, showRegion, showPlatform, showVariables)
        return result
    }

    fun attemptCount(): Int {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_attemptCount(ptr)
        return result
    }

    fun metadata(): RunMetadataRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = RunMetadataRef(LiveSplitCoreNative.Run_metadata(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun offset(): TimeSpanRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = TimeSpanRef(LiveSplitCoreNative.Run_offset(ptr))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun len(): Long {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_len(ptr)
        return result
    }

    fun segment(index: Long): SegmentRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = SegmentRef(LiveSplitCoreNative.Run_segment(ptr, index))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun attemptHistoryLen(): Long {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_attemptHistoryLen(ptr)
        return result
    }

    fun attemptHistoryIndex(index: Long): AttemptRef? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = AttemptRef(
                LiveSplitCoreNative.Run_attemptHistoryIndex(ptr, index))
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    fun saveAsLss(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.Run_saveAsLss(ptr)
        return result
    }
}