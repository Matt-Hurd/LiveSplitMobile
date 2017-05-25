package livesplitcore

class Attempt internal constructor(ptr: Long) : AttemptRefMut(ptr), AutoCloseable {
    private fun drop() {
        ptr = 0
    }

    @Throws(Throwable::class)
    protected fun finalize() {
        drop()
    }

    override fun close() {
        drop()
    }
}