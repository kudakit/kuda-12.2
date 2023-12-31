package kuda.runtimeapi

import kuda.prop.FlushGPUDirectRDMAWritesScope
import kuda.prop.FlushGPUDirectRDMAWritesTarget
import kuda.prop.FunctionCache
import kuda.prop.Limit

class DeviceHandler {
    companion object {

        private var isLibraryLoaded = false

        init {
            loadLibraryIfNotLoaded()
        }

        @Synchronized
        private fun loadLibraryIfNotLoaded() {
            if (!isLibraryLoaded) {
                System.loadLibrary("kudadll")
                isLibraryLoaded = true
            }
        }


        @JvmStatic
        private external fun flushGPUDirectRDMAWrites(scope : Int) : Int

        private fun flushGPUDirectRDMAWrites(target: FlushGPUDirectRDMAWritesTarget, scope : FlushGPUDirectRDMAWritesScope): Int {
            return flushGPUDirectRDMAWrites(scope.num)
        }

        fun getLimit(limit : Limit) : Int {
            return getLimit(limit.byte)
        }

        @JvmStatic
        private external fun getLimit(byte: Byte) : Int

        @JvmStatic
        external fun getMemPool(device : Int) : Long

        @JvmStatic
        external fun getPCIBusId(device : Int) : String

        @JvmStatic
        external fun getStreamPriorityRange() : Int

        @JvmStatic
        private external fun setCacheConfig(cacheConfig : Int) : Int
        fun setCacheConfig(functionCache: FunctionCache) : Int{
            return setCacheConfig(functionCache.num)
        }

        @JvmStatic
        private external fun setLimit(limit : Byte, size : Int) : Int
        fun setLimit(limit: Limit, size: Int) : Int{
            return setLimit(limit.byte, size)
        }

        @JvmStatic
        external fun synchronize() : Int

        @JvmStatic
        external fun reset() : Int
    }
}