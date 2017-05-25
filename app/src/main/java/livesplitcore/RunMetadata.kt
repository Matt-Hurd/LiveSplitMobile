package livesplitcore

class RunMetadata internal constructor(ptr: Long) : RunMetadataRefMut(ptr), AutoCloseable {
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
}