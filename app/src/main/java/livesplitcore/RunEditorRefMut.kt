package livesplitcore

open class RunEditorRefMut internal constructor(ptr: Long) : RunEditorRef(ptr) {
    fun stateAsJson(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.RunEditor_stateAsJson(ptr)
        return result
    }

    fun selectTimingMethod(method: Byte) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_selectTimingMethod(ptr, method)
    }

    fun unselect(index: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_unselect(ptr, index)
    }

    fun selectAdditionally(index: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_selectAdditionally(ptr, index)
    }

    fun selectOnly(index: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_selectOnly(ptr, index)
    }

    fun setGameName(game: String) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_setGameName(ptr, game)
    }

    fun setCategoryName(category: String) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_setCategoryName(ptr, category)
    }

    fun parseAndSetOffset(offset: String): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.RunEditor_parseAndSetOffset(ptr, offset)
        return result
    }

    fun parseAndSetAttemptCount(attempts: String): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .RunEditor_parseAndSetAttemptCount(ptr, attempts)
        return result
    }

    fun setGameIcon(data: Long, length: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_setGameIcon(ptr, data, length)
    }

    fun insertSegmentAbove() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_insertSegmentAbove(ptr)
    }

    fun insertSegmentBelow() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_insertSegmentBelow(ptr)
    }

    fun removeSegments() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_removeSegments(ptr)
    }

    fun moveSegmentsUp() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_moveSegmentsUp(ptr)
    }

    fun moveSegmentsDown() {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_moveSegmentsDown(ptr)
    }

    fun selectedSetIcon(data: Long, length: Long) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_selectedSetIcon(ptr, data, length)
    }

    fun selectedSetName(name: String) {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        LiveSplitCoreNative.RunEditor_selectedSetName(ptr, name)
    }

    fun selectedParseAndSetSplitTime(time: String): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .RunEditor_selectedParseAndSetSplitTime(ptr, time)
        return result
    }

    fun selectedParseAndSetSegmentTime(time: String): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .RunEditor_selectedParseAndSetSegmentTime(ptr, time)
        return result
    }

    fun selectedParseAndSetBestSegmentTime(time: String): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .RunEditor_selectedParseAndSetBestSegmentTime(ptr, time)
        return result
    }

    fun selectedParseAndSetComparisonTime(comparison: String, time: String): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative
                .RunEditor_selectedParseAndSetComparisonTime(ptr, comparison, time)
        return result
    }
}