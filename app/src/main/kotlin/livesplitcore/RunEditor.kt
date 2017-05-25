package livesplitcore

class RunEditor : RunEditorRefMut, AutoCloseable {
    private fun drop() {
        if (!ptr.equals(0)) {
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

    constructor(run: Run) : super(0) {
        if (run.ptr.equals(0)) {
            throw RuntimeException()
        }
        ptr = LiveSplitCoreNative.RunEditor_new(run.ptr)
        run.ptr = 0
    }

    fun finish(): Run? {
        if (ptr.equals(0)) {
            throw RuntimeException()
        }
        val result = Run(LiveSplitCoreNative.RunEditor_close(ptr))
        ptr = 0
        if (result.ptr.equals(0)) {
            return null
        }
        return result
    }

    internal constructor(ptr: Long) : super(ptr) {}
}