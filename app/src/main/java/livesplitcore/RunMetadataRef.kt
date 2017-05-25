package livesplitcore

open class RunMetadataRef internal constructor(internal var ptr: Long) {
    fun runId(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.RunMetadata_runId(ptr)
        return result
    }

    fun platformName(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.RunMetadata_platformName(ptr)
        return result
    }

    fun usesEmulator(): Boolean {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.RunMetadata_usesEmulator(ptr)
        return result
    }

    fun regionName(): String {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = LiveSplitCoreNative.RunMetadata_regionName(ptr)
        return result
    }
}