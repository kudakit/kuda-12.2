package kuda.driverapi

import kuda.driverapi.prop.*

class DriverAPI {

    private external fun getErrorName(error: Int): String
    fun getErrorName(error: Result): String {
        return getErrorName(error.num)
    }

    private external fun getErrorString(error: Int): String
    fun getErrorString(error: Result): String {
        return getErrorString(error.num)
    }

    external fun init(flags: Int): Int

    external fun driverGetVersion(): Int

    //5. Device Management //

    external fun deviceGet(ordinal: Int): Int

    external fun deviceGetCount(): Int

    /**
     * Returns the default mempool of a device. (cuDeviceGetDefaultMemPool)
     *
     * @param dev Device to get mempool
     *
     * @return Gets the default mempool for a device.
     */
    external fun devcieGetDefaultMemPool(dev : Int) : Long

    /**
     * Gets the current mempool for a device. (cuDeviceGetMemPool)
     *
     * @param dev Device to get mempool
     *
     * @return Gets the current mempool for a device.
     */
    external fun devcieGetMemPool(dev : Int) : Long

    /**
     * Returns an identifier string for the device. (cuDeviceGetName)
     *
     * @param len Maximum length of string to store in name
     * @param dev Device to get identifier string for
     *
     * @return Returns an identifier string for the device.
     */
    external fun deviceGetName(len : Int, dev : Int) : Int

    //7. Primary Context Management //

    /**
     * Get the state of the primary context. (cuDevicePrimaryCtxGetState)
     *
     * @param dev Device to get primary context flags for
     *
     * @return Int to store context state; 0 = inactive, 1 = active
     */
    external fun devicePrimaryCtxGetState(dev : Int): Int

    external fun devicePrimaryCtxRelease(dev: Int): Int

    external fun devicePrimaryCtxReset(dev: Int): Int

    /**
     * Retain the primary context on the GPU. (cuDevicePrimaryCtxRetain)
     */
    external fun devicePrimaryCtxRetain(dev: Int): Long

    external fun devicePrimaryCtxSetFlags(dev: Int, flags: Int): Int

    /**
     * Destroy a CUDA context. (cuCtxDestroy)
     */
    external fun ctxDestroy(ctx: Long): Int

    /**
     * Gets the context's API version. (cuCtxGetApiVersion)
     */
    external fun ctxGetApiVersion(ctx: Long): Int

    /**
     * Returns the preferred cache configuration for the current context. (cuCtxGetCacheConfig)
     */
    private external fun ctxGetCacheConfig(dummy: Boolean): Int
    fun ctxGetCacheConfig(): FuncCache {
        return FuncCache.fromInt(ctxGetCacheConfig(false))!!
    }

    /**
     * Returns the CUDA context bound to the calling CPU thread. (cuCtxGetCurrent)
     */
    external fun ctxGetCurrent(): Long


    /**
     * Returns the device ID for the current context. (cuCtxGetDevice)
     */
    external fun ctxGetDevice(): Int

    //8. Context Management //
    /**
     * Create a CUDA context. (cuCtxCreate)
     *
     * @param flags Context creation flags
     * @param dev Device to create context on
     *
     * @return Returned context handle of the new context
     */
    external fun ctxCreate(flags: Int, dev: Int) : Long


    /**
     * Returns the flags for the current context. (cuCtxGetFlags)
     *
     * @return Pointer to store flags of current context
     */
    external fun ctxGetFlags(): Int

    /**
     * Returns the unique Id associated with the context supplied. (cuCtxGetId)
     *
     * @param ctx Context for which to obtain the Id
     *
     * @return Pointer to store the Id of the context
     */
    external fun ctxGetId(ctx : Long) : Long

    /**
     * Returns resource limits. (cuCtxGetLimit)
     *
     * @param limit Limit to query
     *
     * @return Returned size of limit
     */
    private external fun ctxGetLimit(limit : Int) : Int
    fun ctxGetLimit(limit : Limit) : Int {
        return ctxGetLimit(limit.num)
    }

    /**
     * Returns the current shared memory configuration for the current context. (cuCtxGetSharedMemConfig)
     */
    private external fun ctxGetSharedMemConfig(dummy: Boolean): Int
    fun ctxGetSharedMemConfig(): SharedConfig {
        return SharedConfig.fromInt(ctxGetSharedMemConfig(false))!!
    }

    /**
     * Returns numerical values that correspond to the least and greatest stream priorities. (cuCtxGetStreamPriorityRange)
     */
    external fun ctxGetStreamPriorityRange(): IntArray

    /**
     * Pops the current CUDA context from the current CPU thread. (cuCtxPopCurrent)
     */
    external fun ctxPopCurrent(): Long

    /**
     * Pushes a context on the current CPU thread. (cuCtxPushCurrent)
     */
    external fun ctxPushCurrent(ctx: Long): Int

    /**
     * Resets all persisting lines in cache to normal status.
     */
    external fun ctxResetPersistingL2Cache(): Int

    /**
     * Sets the preferred cache configuration for the current context.
     */
    private external fun ctxSetCacheConfig(config: Int): Int
    fun ctxSetCacheConfig(config: FuncCache): Int {
        return ctxSetCacheConfig(config.num)
    }

    /**
     * 	Binds the specified CUDA context to the calling CPU thread. (cuCtxSetCurrent)
     *
     * 	@param ctx Context to bind to the calling CPU thread
     */
    external fun ctxSetCurrent(ctx: Long): Int

    /**
     * Set resource limits.
     */
    private external fun ctxSetLimit(limit: Int, value: Int): Int
    fun ctxSetLimit(limit: Limit, value: Int): Int {
        return ctxSetLimit(limit.num, value)
    }

    /**
     * Sets the shared memory configuration for the current context. (cuCtxSetSharedMemConfig)
     */
    private external fun ctxSetSharedMemConfig(config: Int): Int
    fun ctxSetSharedMemConfig(config: SharedConfig): Int {
        return ctxSetSharedMemConfig(config.num)
    }

    /**
     * Block for a context's tasks to complete. (cuCtxSynchronize)
     */
    external fun ctxSynchronize(): Int

    //9. Context Management (DEPRECATED)

    //10. Module Management
    /**
     * Destroys state for a JIT linker invocation. (cuLinkDestroy)
     */
    external fun linkDestroy(state: Long): Int

    /**
     * Query lazy loading mode. (cuModuleGetLoadingMode)
     */
    private external fun moduleGetLoadingMode(dummy: Boolean): Int
    fun moduleGetLoadingMode(): ModuleLoadingMode {
        return ModuleLoadingMode.fromInt(moduleGetLoadingMode(false))!!
    }

    /**
     * Loads a compute module. (cuModuleLoad)
     *
     * @param fname Filename of module to load
     *
     * @return Loads a compute module.
     */
    external fun moduleLoad(fname: String): Long

    /**
     * Unloads a module. (cuModuleUnload)
     */
    external fun moduleUnload(hmod: Long): Int

    //11. Module Management (DEPRECATED)

    //12. Library Management
    /**
     * 	Returns a function handle. (cuKernelGetFunction)
     */
    external fun kernelGetFunction(kernel: Long): Long

    /**
     * Unloads a library. (cuLibraryUnload)
     */
    external fun libraryUnload(library: Long): Int

    /**
     * Returns a module handle. (cuLibraryGetModule)
     *
     * @param library Library to retrieve module from
     *
     * @return Returned module handle
     */
    external fun libraryGetModule(library: Long): Long

    //13. Memory Management
    /**
     * Destroys a CUDA array. (cuArrayDestroy)
     */
    external fun destroyArray(hArray: Long): Int

    /**
     * Attempts to close memory mapped with cuIpcOpenMemHandle. (cuIpcCloseMemHandle)
     */
    external fun ipcCloseMemHandle(dptr: Long): Int

    /**
     * Allocates device memory. (cuMemAlloc)
     *
     * @param byteSize Requested allocation size in bytes
     *
     * @return Returned device pointer
     */
    external fun memAlloc(byteSize : Int) : Long

    //CUresult cuMemAllocHost(void** pp, size_t bytesize)

    /**
     * Allocates memory that will be automatically managed by the Unified Memory system. (cuMemAllocManaged)
     *
     * @param byteSize Requested allocation size in bytes
     * @param flags Must be one of GLOBAL or HOST in MemAttachFlags enum class
     *
     * @return Returned device pointer
     */
    external fun memAllocManaged(byteSize : Int, flags : Int) : Long

    //CUresult cuMemAllocPitch(CUdeviceptr * dptr, size_t * pPitch, size_t WidthInBytes, size_t Height, unsigned int  ElementSizeBytes)

    /**
     * Frees device memory. (cuMemFree)
     */
    external fun memFree(dptr: Long): Int

    /**
     * Frees page-locked host memory. (cuMemFreeHost)
     */
    external fun memFreeHost(p: Long): Int

    /**
     * Unregisters a memory range that was registered with cuMemHostRegister. (cuMemHostUnregister)
     */
    external fun memHostUnregister(p: Long): Int

    /**
     * Returns a handle to a compute device. (cuDeviceGetByPCIBusId)
     */
    external fun deviceGetByPCIBusId(): String

    /**
     * Returns a PCI Bus Id string for the device. (cuDeviceGetPCIBusId)
     */
    external fun deviceGetPCIBusId(len: Int, dev: Int): String

    //14. Virtual Memory Management

    /**
     * Free an address range reservation. (cuMemAddressFree)
     *
     * @param ptr Starting address of the virtual address range to free
     * @param size Size of the virtual address region to free
     */
    external fun memAddressFree(ptr: Long, size : Int): Int

    //CUresult cuMemAddressFree(CUdeviceptr ptr, size_t size)
    //CUresult cuMemAddressReserve(CUdeviceptr* ptr, size_t size, size_t alignment, CUdeviceptr addr, unsigned long long flags)
    //CUresult cuMemCreate(CUmemGenericAllocationHandle* handle, size_t size, const CUmemAllocationProp* prop, unsigned long long flags)
    //CUresult cuMemExportToShareableHandle(void* shareableHandle, CUmemGenericAllocationHandle handle, CUmemAllocationHandleType handleType, unsigned long long flags)
    //CUresult cuMemGetAccess(unsigned long long* flags, const CUmemLocation* location, CUdeviceptr ptr)
    //CUresult cuMemGetAllocationGranularity(size_t * granularity, const CUmemAllocationProp * prop, CUmemAllocationGranularity_flags option)
    //CUresult cuMemGetAllocationPropertiesFromHandle(CUmemAllocationProp * prop, CUmemGenericAllocationHandle handle)
    //CUresult cuMemImportFromShareableHandle(CUmemGenericAllocationHandle * handle, void* osHandle, CUmemAllocationHandleType shHandleType)
    //CUresult cuMemMap(CUdeviceptr ptr, size_t size, size_t offset, CUmemGenericAllocationHandle handle, unsigned long long flags)
    //CUresult cuMemMapArrayAsync(CUarrayMapInfo * mapInfoList, unsigned int  count, CUstream hStream)

    /**
     * Release a memory handle representing a memory allocation which was previously allocated through cuMemCreate. (cuMemRelease)
     */
    external fun memRelease(handle: Long): Int

    //CUresult cuMemRetainAllocationHandle(CUmemGenericAllocationHandle * handle, void* addr)
    //CUresult cuMemSetAccess(CUdeviceptr ptr, size_t size, const CUmemAccessDesc * desc, size_t count)	//CUresult cuMemUnmap(CUdeviceptr ptr, size_t size)

    /**
     * Unmap the backing memory of a given address range. (cuMemUnmap)
     *
     * @param ptr Starting address for the virtual address range to unmap
     * @param size Size of the virtual address range to unmap
     */
    external fun memUnmap(ptr : Long, size : Int) : Int

    //15. Steam Ordered Memory Allocator //

    /**
     * Allocates memory with stream ordered semantics. (cuMemAllocAsync)
     *
     * @param bytesize Number of bytes to allocate
     * @param hStream The stream establishing the stream ordering contract and the memory pool to allocate from
     *
     * @return Returned device pointer
     */
    external fun memAllocAsync(bytesize: Int, hStream : Long): Long

    //CUresult cuMemAllocAsync(CUdeviceptr* dptr, size_t bytesize, CUstream hStream)
    //CUresult cuMemAllocFromPoolAsync(CUdeviceptr* dptr, size_t bytesize, CUmemoryPool pool, CUstream hStream)
    //CUresult cuMemFreeAsync(CUdeviceptr dptr, CUstream hStream)
    //CUresult cuMemPoolCreate(CUmemoryPool* pool, const CUmemPoolProps* poolProps)

    /**
     * Frees memory with stream ordered semantics. (cuMemFreeAsync)
     *
     * @param dptr memory to free
     * @param hStream The stream establishing the stream ordering contract.
     */
    external fun memFreeAsync(dptr: Long, hStream : Long): Int

    /**
     * Destroys the specified memory pool. (cuMemPoolDestroy)
     */
    external fun memPoolDestroy(pool: Long): Int

    //CUresult cuMemPoolExportPointer(CUmemPoolPtrExportData* shareData_out, CUdeviceptr ptr)
    //CUresult cuMemPoolExportToShareableHandle(void* handle_out, CUmemoryPool pool, CUmemAllocationHandleType handleType, unsigned long long flags)
    //CUresult cuMemPoolGetAccess(CUmemAccess_flags* flags, CUmemoryPool memPool, CUmemLocation* location)
    //CUresult cuMemPoolGetAttribute(CUmemoryPool pool, CUmemPool_attribute attr, void* value)
    //CUresult cuMemPoolImportFromShareableHandle(CUmemoryPool* pool_out, void* handle, CUmemAllocationHandleType handleType, unsigned long long flags)
    //CUresult cuMemPoolImportPointer(CUdeviceptr* ptr_out, CUmemoryPool pool, CUmemPoolPtrExportData* shareData)
    //CUresult cuMemPoolSetAccess(CUmemoryPool pool, const CUmemAccessDesc* map, size_t count)
    //CUresult cuMemPoolSetAttribute(CUmemoryPool pool, CUmemPool_attribute attr, void* value)

    /**
     * Tries to release memory back to the OS. (cuMemPoolTrimTo)
     *
     * @param pool The memory pool to trim
     * @param minBytesToKeep If the pool has less than minBytesToKeep reserved, the TrimTo operation is a no-op. Otherwise the pool will be guaranteed to have at least minBytesToKeep bytes reserved after the operation.
     */
    external fun memPoolTrimTo(pool: Long, minBytesToKeep : Int) : Int

    //16. Multicast Object Management
    /**
     * Associate a device to a multicast object. (cuMulticastAddDevice)
     *
     * @param mcHandle Handle representing a multicast object.
     * @param dev Device that will be associated to the multicast object.
     */
    external fun multicastAddDevice(mcHandle: Long, dev: Int)

    //CUresult cuMulticastBindAddr(CUmemGenericAllocationHandle mcHandle, size_t mcOffset, CUdeviceptr memptr, size_t size, unsigned long long flags)
    //CUresult cuMulticastBindMem(CUmemGenericAllocationHandle mcHandle, size_t mcOffset, CUmemGenericAllocationHandle memHandle, size_t memOffset, size_t size, unsigned long long flags)
    //CUresult cuMulticastCreate(CUmemGenericAllocationHandle* mcHandle, const CUmulticastObjectProp* prop)
    //CUresult cuMulticastGetGranularity(size_t* granularity, const CUmulticastObjectProp* prop, CUmulticastGranularity_flags option)
    //CUresult cuMulticastUnbind(CUmemGenericAllocationHandle mcHandle, CUdevice dev, size_t mcOffset, size_t size)

    //17. Unified Addressing
    //CUresult cuMemAdvise(CUdeviceptr devPtr, size_t count, CUmem_advise advice, CUdevice device)
    //CUresult cuMemAdvise_v2(CUdeviceptr devPtr, size_t count, CUmem_advise advice, CUmemLocation location)
    //CUresult cuMemPrefetchAsync(CUdeviceptr devPtr, size_t count, CUdevice dstDevice, CUstream hStream)
    //CUresult cuMemPrefetchAsync_v2(CUdeviceptr devPtr, size_t count, CUmemLocation location, unsigned int  flags, CUstream hStream)
    //CUresult cuMemRangeGetAttribute(void* data, size_t dataSize, CUmem_range_attribute attribute, CUdeviceptr devPtr, size_t count)
    //CUresult cuMemRangeGetAttributes(void** data, size_t* dataSizes, CUmem_range_attribute* attributes, size_t numAttributes, CUdeviceptr devPtr, size_t count)
    //CUresult cuPointerGetAttribute(void* data, CUpointer_attribute attribute, CUdeviceptr ptr)
    //CUresult cuPointerGetAttributes(unsigned int  numAttributes, CUpointer_attribute* attributes, void** data, CUdeviceptr ptr)
    //CUresult cuPointerSetAttribute(const void* value, CUpointer_attribute attribute, CUdeviceptr ptr)

    //18. Stream Management //

    //CUresult cuStreamAddCallback(CUstream hStream, CUstreamCallback callback, void* userData, unsigned int  flags)

    /**
     * Attach memory to a stream asynchronously. (cuStreamAttachMemAsync)
     *
     * @param hStream Stream in which to enqueue the attach operation
     * @param dptr Pointer to memory (must be a pointer to managed memory or to a valid host-accessible region of system-allocated pageable memory)
     * @param length Length of memory
     * @param flags Must be one of MemAttachFlags
     */
    external fun streamAttachMemAsync(hStream : Long, dptr : Long, length : Int, flags : Int) : Int

    /**
     * Begins graph capture on a stream. (cuStreamBeginCapture)
     *
     * @param hStream Stream in which to initiate capture
     * @param mode Controls the interaction of this capture sequence with other API calls that are potentially unsafe.
     */
    private external fun streamBeginCapture(hStream: Long, mode : Int): Int
    fun streamBeginCapture(hStream: Long, mode : StreamCaptureMode) : Int {
        return streamBeginCapture(hStream, mode.num)
    }


    //CUresult cuStreamBeginCaptureToGraph(CUstream hStream, CUgraph hGraph, const CUgraphNode* dependencies, const CUgraphEdgeData* dependencyData, size_t numDependencies, CUstreamCaptureMode mode)

    /**
     * 	Copies attributes from source stream to destination stream. (cuStreamCopyAttributes)
     */
    external fun streamCopyAttributes(dst: Long, src: Long): Int

    /**
     * 	Create a stream. (cuStreamCreate)
     *
     * 	@param flags Parameters for stream creation
     *
     * 	@return Returned newly created stream
     */
    external fun streamCreate(flags : Int) : Long

    /**
     * Create a stream with the given priority. (cuStreamCreateWithPriority)
     *
     * @param flags Flags for stream creation. See streamCreate for a list of valid flags
     * @param priority Stream priority. Lower numbers represent higher priorities. See ctxGetStreamPriorityRange for more information about meaningful stream priorities that can be passed.
     *
     * @return Returned newly created stream
     */
    external fun streamCreateWithPriority(flags : Int, priority : Int) : Long

    /**
     * 	Destroys a stream. (cuStreamDestroy)
     */
    external fun streamDestroy(hStream: Long): Int

    /**
     * 	Ends capture on a stream, returning the captured graph. (cuStreamEndCapture)
     *
     * 	@param hStream Stream to query
     *
     * 	@return The captured graph
     */
    external fun streamEndCapture(hStream: Long) : Long

    //CUresult cuStreamGetAttribute(CUstream hStream, CUstreamAttrID attr, CUstreamAttrValue* value_out)
    //CUresult cuStreamGetCaptureInfo(CUstream hStream, CUstreamCaptureStatus* captureStatus_out, cuuint64_t* id_out, CUgraph* graph_out, const CUgraphNode** dependencies_out, size_t* numDependencies_out)
    //CUresult cuStreamGetCaptureInfo_v3(CUstream hStream, CUstreamCaptureStatus * captureStatus_out, cuuint64_t * id_out, CUgraph * graph_out, const CUgraphNode * *dependencies_out, const CUgraphEdgeData * *edgeData_out, size_t * numDependencies_out)

    /**
     * Query the context associated with a stream. (cuStreamGetCtx)
     */
    external fun streamGetCtx(hStream: Long): Long

    /**
     * 	Query the flags of a given stream. (cuStreamGetFlags)
     */
    external fun streamGetFlags(hStream: Long): Int

    /**
     * 	Returns the unique Id associated with the stream handle supplied. (cuStreamGetId)
     *
     * 	@param hStream Handle to the stream to be queried
     *
     * @return
     */
    external fun streamGetId(hStream: Long) : Long

    /**
     * 	Query the priority of a given stream. (cuStreamGetPriority)
     */
    external fun streamGetPriority(hStream: Long): Int

    /**
     * Returns a stream's capture status. (cuStreamIsCapturing)
     *
     * @param hStream Stream to query
     * @param dummy do nothing...
     *
     * @return Returns the stream's capture status
     */
    private external fun streamIsCapturing(hStream : Long, dummy : Boolean) : Int
    fun streamIsCapturing(hStream : Long) : StreamCaptureStatus {
        return StreamCaptureStatus.fromInt(streamIsCapturing(hStream, false))!!
    }
    //CUresult cuStreamIsCapturing(CUstream hStream, CUstreamCaptureStatus * captureStatus)

    /**
     * 	Determine status of a compute stream. (cuStreamQuery)
     */
    external fun streamQuery(hStream: Long): Int

    //CUresult cuStreamSetAttribute(CUstream hStream, CUstreamAttrID attr, const CUstreamAttrValue * value)

    /**
     * 	Wait until a stream's tasks are completed. (cuStreamSynchronize)
     */
    external fun streamSynchronize(hStream: Long): Int

    //CUresult cuStreamUpdateCaptureDependencies(CUstream hStream, CUgraphNode * dependencies, size_t numDependencies, unsigned int  flags)
    //CUresult cuStreamUpdateCaptureDependencies_v2(CUstream hStream, CUgraphNode * dependencies, const CUgraphEdgeData * dependencyData, size_t numDependencies, unsigned int  flags)

    /**
     * 	Make a compute stream wait on an event. (cuStreamWaitEvent)
     */
    external fun streamWaitEvent(hStream: Long, hEvent: Long, flags: Int): Int

    /**
     * Update the set of dependencies in a capturing stream (11.3+). (cuThreadExchangeStreamCaptureMode)
     */
    private external fun threadExchangeStreamCaptureMode(mode: Int): Int
    fun threadExchangeStreamCaptureMode(mode: StreamCaptureMode): Int {
        return threadExchangeStreamCaptureMode(mode.num)
    }

    //19.Event Management
    /**
     * Creates an event. (cuEventCreate)
     *
     * @param flags Event creation flags
     *
     * @return event
     */
    external fun eventCreate(flags: Int): Long

    /**
     * Destroys an event. (cuEventDestroy)
     */
    external fun eventDestroy(hEvent: Long): Int

    /**
     * Computes the elapsed time between two events. (cuEventElapsedTime)
     *
     * @param hStart Starting event
     * @param hEnd Ending event
     *
     * @return Time between hStart and hEnd in ms
     */
    external fun eventElapsedTime(hStart : Long, hEnd : Long)

    /**
     * Queries an event's status (cuEventQuery)
     */
    external fun eventQuery(hEvent: Long): Int

    /**
     * Records an event. (cuEventRecord)
     *
     * @param hEvent Event to record
     * @param hStream Stream to record event for
     */
    external fun eventRecord(hEvent : Long, hStream: Long) : Int

    /**
     * Records an event. (cuEventRecordWithFlags)
     *
     * @param hEvent Event to record
     * @param hStream Stream to record event for
     * @param flags See EventRecordFlags
     */
    external fun eventRecordWithFlags(hEvent : Long, hStream: Long, flags : Int) : Int

    /**
     * Waits for an event to complete. (cuEventSynchronize)
     */
    external fun eventSynchronize(hEvent: Long): Int

    //20. External Resource Interoperability
    /**
     * Destroys an external memory object. (cuDestroyExternalMemory)
     */
    external fun destroyExternalMemory(extMem: Long): Int

    /**
     * Destroys an external semaphore. (cuDestroyExternalSemaphore)
     */
    external fun destroyExternalSemaphore(extSem: Long): Int

    //CUresult cuExternalMemoryGetMappedBuffer(CUdeviceptr* devPtr, CUexternalMemory extMem, const CUDA_EXTERNAL_MEMORY_BUFFER_DESC* bufferDesc)
    //CUresult cuExternalMemoryGetMappedMipmappedArray(CUmipmappedArray* mipmap, CUexternalMemory extMem, const CUDA_EXTERNAL_MEMORY_MIPMAPPED_ARRAY_DESC* mipmapDesc)
    //CUresult cuImportExternalMemory(CUexternalMemory* extMem_out, const CUDA_EXTERNAL_MEMORY_HANDLE_DESC* memHandleDesc)
    //CUresult cuImportExternalSemaphore(CUexternalSemaphore* extSem_out, const CUDA_EXTERNAL_SEMAPHORE_HANDLE_DESC* semHandleDesc)
    //CUresult cuSignalExternalSemaphoresAsync(const CUexternalSemaphore* extSemArray, const CUDA_EXTERNAL_SEMAPHORE_SIGNAL_PARAMS* paramsArray, unsigned int  numExtSems, CUstream stream)
    //CUresult cuWaitExternalSemaphoresAsync(const CUexternalSemaphore* extSemArray, const CUDA_EXTERNAL_SEMAPHORE_WAIT_PARAMS* paramsArray, unsigned int  numExtSems, CUstream stream)

    //21. Stream Memory Operations
    //CUresult cuStreamBatchMemOp(CUstream stream, unsigned int  count, CUstreamBatchMemOpParams* paramArray, unsigned int  flags)
    //CUresult cuStreamWaitValue32(CUstream stream, CUdeviceptr addr, cuuint32_t value, unsigned int  flags)
    //CUresult cuStreamWaitValue64(CUstream stream, CUdeviceptr addr, cuuint64_t value, unsigned int  flags)
    //CUresult cuStreamWriteValue32(CUstream stream, CUdeviceptr addr, cuuint32_t value, unsigned int  flags)
    //CUresult cuStreamWriteValue64(CUstream stream, CUdeviceptr addr, cuuint64_t value, unsigned int  flags)

    //22. Execution Control
    //CUresult cuFuncGetAttribute(int* pi, CUfunction_attribute attrib, CUfunction hfunc)
    //CUresult cuFuncGetModule(CUmodule* hmod, CUfunction hfunc)
    //CUresult cuFuncGetName(const char** name, CUfunction hfunc)
    //CUresult cuFuncSetAttribute(CUfunction hfunc, CUfunction_attribute attrib, int  value)
    //CUresult cuFuncSetCacheConfig(CUfunction hfunc, CUfunc_cache config)
    //CUresult cuFuncSetSharedMemConfig(CUfunction hfunc, CUsharedconfig config)
    //CUresult cuLaunchCooperativeKernel(CUfunction f, unsigned int  gridDimX, unsigned int  gridDimY, unsigned int  gridDimZ, unsigned int  blockDimX, unsigned int  blockDimY, unsigned int  blockDimZ, unsigned int  sharedMemBytes, CUstream hStream, void** kernelParams)
    //CUresult cuLaunchCooperativeKernelMultiDevice(CUDA_LAUNCH_PARAMS * launchParamsList, unsigned int  numDevices, unsigned int  flags)
    //CUresult cuLaunchHostFunc(CUstream hStream, CUhostFn fn, void* userData)
    //CUresult cuLaunchKernel(CUfunction f, unsigned int  gridDimX, unsigned int  gridDimY, unsigned int  gridDimZ, unsigned int  blockDimX, unsigned int  blockDimY, unsigned int  blockDimZ, unsigned int  sharedMemBytes, CUstream hStream, void** kernelParams, void** extra)
    //CUresult cuLaunchKernelEx(const CUlaunchConfig * config, CUfunction f, void** kernelParams, void** extra)

    //24. Graph Management

    //CUresult cuDeviceGetGraphMemAttribute(CUdevice device, CUgraphMem_attribute attr, void* value)

    /**
     * Free unused memory that was cached on the specified device for use with graphs back to the OS. (cuDeviceGraphMemTrim)
     */
    external fun deviceGraphMemTrim(device: Int): Int

    //CUresult cuDeviceSetGraphMemAttribute(CUdevice device, CUgraphMem_attribute attr, void* value)
    //CUresult cuGraphAddBatchMemOpNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddChildGraphNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUgraph childGraph)
    //CUresult cuGraphAddDependencies(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, size_t numDependencies)
    //CUresult cuGraphAddDependencies_v2(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, const CUgraphEdgeData * edgeData, size_t numDependencies)
    //CUresult cuGraphAddEmptyNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies)
    //CUresult cuGraphAddEventRecordNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUevent event)
    //CUresult cuGraphAddEventWaitNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUevent event)
    //CUresult cuGraphAddExternalSemaphoresSignalNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddExternalSemaphoresWaitNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_EXT_SEM_WAIT_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddHostNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddKernelNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddMemAllocNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUDA_MEM_ALLOC_NODE_PARAMS * nodeParams)
    //CUresult cuGraphAddMemFreeNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUdeviceptr dptr)
    //CUresult cuGraphAddMemcpyNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_MEMCPY3D * copyParams, CUcontext ctx)
    //CUresult cuGraphAddMemsetNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, const CUDA_MEMSET_NODE_PARAMS * memsetParams, CUcontext ctx)
    //CUresult cuGraphAddNode(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, size_t numDependencies, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphAddNode_v2(CUgraphNode * phGraphNode, CUgraph hGraph, const CUgraphNode * dependencies, const CUgraphEdgeData * dependencyData, size_t numDependencies, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphBatchMemOpNodeGetParams(CUgraphNode hNode, CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams_out)
    //CUresult cuGraphBatchMemOpNodeSetParams(CUgraphNode hNode, const CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams)

    /**
     * Gets a handle to the embedded graph of a child graph node. (cuGraphChildGraphNodeGetGraph)
     *
     * @param hNode Node to get the embedded graph for
     *
     * @return Location to store a handle to the graph
     */
    external fun graphChildGraphNodeGetGraph(hNode : Long) : Long

    /**
     * Clones a graph. (cuGraphCreate)
     *
     * @param originalGraph Graph to clone
     *
     * @return Returns newly created cloned graph
     */
    external fun graphClone(originalGraph : Long) : Long

    //CUresult cuGraphConditionalHandleCreate(CUgraphConditionalHandle * pHandle_out, CUgraph hGraph, CUcontext ctx, unsigned int  defaultLaunchValue, unsigned int  flags)

    /**
     * Creates a graph. (cuGraphCreate)
     *
     * @param flags Graph creation flags, must be 0
     *
     * @return Returns newly created graph
     */
    external fun graphCreate(flags : Int) : Long

    //CUresult cuGraphDebugDotPrint(CUgraph hGraph, const char* path, unsigned int  flags)

    /**
     * Destroys a graph. (cuGraphDestroy)
     */
    external fun graphDestroy(hGraph: Long): Int

    /**
     * Remove a node from the graph. (cuGraphDestroyNode)
     */
    external fun graphDestroyNode(hNode: Long): Int

    /**
     * Returns the event associated with an event record node. (cuGraphEventRecordNodeGetEvent)
     *
     * @param hNode Node to get the event for
     *
     * @return Pointer to return the event
     */
    external fun graphEventRecordNodeGetEvent(hNode : Long) : Long

    /**
     * Sets an event record node's event. (cuGraphEventRecordNodeSetEvent)
     */
    external fun graphEventRecordNodeSetEvent(hNode: Long, event: Long) : Int

    /**
     * Returns the event associated with an event wait node. (cuGraphEventWaitNodeGetEvent)
     *
     * @param hNode Node to get the event for
     *
     * @return Pointer to return the event
     */
    external fun graphEventWaitNodeGetEvent(hNode : Long) : Long

    /**
     * Sets an event wait node's event. (cuGraphEventWaitNodeSetEvent)
     */
    external fun graphEventWaitNodeSetEvent(hNode: Long, event: Long) : Int

    //CUresult cuGraphExecBatchMemOpNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_BATCH_MEM_OP_NODE_PARAMS * nodeParams)

    /**
     * Updates node parameters in the child graph node in the given graphExec. (cuGraphExecChildGraphNodeSetParams)
     *
     * @param hGraphExec The executable graph in which to set the specified node
     * @param hNode Host node from the graph which was used to instantiate graphExec
     * @param childGraph The graph supplying the updated parameters
     */
    external fun graphExecChildGraphNodeSetParams(hGraphExec : Long, hNode : Long, childGraph : Long) : Int

    /**
     * Destroys an executable graph. (cuGraphExecDestroy)
     */
    external fun graphExecDestroy(hGraphExec: Long): Int

    /**
     * Sets the event for an event record node in the given graphExec. (cuGraphExecEventRecordNodeSetEvent)
     *
     * @param hGraphExec The executable graph in which to set the specified node
     * @param hNode event record node from the graph from which graphExec was instantiated
     * @param event Updated event to use
     */
    external fun graphExecEventRecordNodeSetEvent(hGraphExec : Long, hNode : Long, event : Long) : Int

    /**
     * Sets the event for an event wait node in the given graphExec. (cuGraphExecEventWaitNodeSetEvent)
     *
     * @param hGraphExec The executable graph in which to set the specified node
     * @param hNode event wait node from the graph from which graphExec was instantiated
     * @param event Updated event to use
     */
    external fun graphExecEventWaitNodeSetEvent(hGraphExec : Long, hNode : Long, event : Long) : Int

    //CUresult cuGraphExecExternalSemaphoresSignalNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecExternalSemaphoresWaitNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_EXT_SEM_WAIT_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecGetFlags(CUgraphExec hGraphExec, cuuint64_t * flags)
    //CUresult cuGraphExecHostNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecKernelNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExecMemcpyNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_MEMCPY3D * copyParams, CUcontext ctx)
    //CUresult cuGraphExecMemsetNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, const CUDA_MEMSET_NODE_PARAMS * memsetParams, CUcontext ctx)
    //CUresult cuGraphExecNodeSetParams(CUgraphExec hGraphExec, CUgraphNode hNode, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphExecUpdate(CUgraphExec hGraphExec, CUgraph hGraph, CUgraphExecUpdateResultInfo * resultInfo)
    //CUresult cuGraphExternalSemaphoresSignalNodeGetParams(CUgraphNode hNode, CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * params_out)
    //CUresult cuGraphExternalSemaphoresSignalNodeSetParams(CUgraphNode hNode, const CUDA_EXT_SEM_SIGNAL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphExternalSemaphoresWaitNodeGetParams(CUgraphNode hNode, CUDA_EXT_SEM_WAIT_NODE_PARAMS * params_out)
    //CUresult cuGraphExternalSemaphoresWaitNodeSetParams(CUgraphNode hNode, const CUDA_EXT_SEM_WAIT_NODE_PARAMS * nodeParams)
    //CUresult cuGraphGetEdges(CUgraph hGraph, CUgraphNode * from, CUgraphNode * to, size_t * numEdges)
    //CUresult cuGraphGetEdges_v2(CUgraph hGraph, CUgraphNode * from, CUgraphNode * to, CUgraphEdgeData * edgeData, size_t * numEdges)

    /**
     * Returns a graph's nodes. (cuGraphGetNodes)
     *
     * @param hGraph Graph to query
     *
     * @return  Pointer to return the nodes
     */
    external fun graphGetNodes(hGraph: Long): Int

    //CUresult cuGraphGetRootNodes(CUgraph hGraph, CUgraphNode * rootNodes, size_t * numRootNodes)
    //CUresult cuGraphHostNodeGetParams(CUgraphNode hNode, CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphHostNodeSetParams(CUgraphNode hNode, const CUDA_HOST_NODE_PARAMS * nodeParams)
    //CUresult cuGraphInstantiate(CUgraphExec * phGraphExec, CUgraph hGraph, unsigned long long flags)
    //CUresult cuGraphInstantiateWithParams(CUgraphExec * phGraphExec, CUgraph hGraph, CUDA_GRAPH_INSTANTIATE_PARAMS * instantiateParams)

    /**
     * Copies attributes from source node to destination node. (cuGraphKernelNodeCopyAttributes)
     */
    external fun graphKernelNodeCopyAttributes(dst: Long, src: Long): Int

    //CUresult cuGraphKernelNodeCopyAttributes(CUgraphNode dst, CUgraphNode src)
    //CUresult cuGraphKernelNodeGetAttribute(CUgraphNode hNode, CUkernelNodeAttrID attr, CUkernelNodeAttrValue * value_out)
    //CUresult cuGraphKernelNodeGetParams(CUgraphNode hNode, CUDA_KERNEL_NODE_PARAMS * nodeParams)
    //CUresult cuGraphKernelNodeSetAttribute(CUgraphNode hNode, CUkernelNodeAttrID attr, const CUkernelNodeAttrValue * value)
    //CUresult cuGraphKernelNodeSetParams(CUgraphNode hNode, const CUDA_KERNEL_NODE_PARAMS * nodeParams)

    /**
     * Launches an executable graph in a stream. (cuGraphLaunch)
     */
    external fun graphLaunch(hGraphExec: Long, hStream: Long): Int

    //CUresult cuGraphLaunch(CUgraphExec hGraphExec, CUstream hStream)
    //CUresult cuGraphMemAllocNodeGetParams(CUgraphNode hNode, CUDA_MEM_ALLOC_NODE_PARAMS * params_out)

    /**
     * Returns a memory free node's parameters. (cuGraphMemFreeNodeGetParams)
     *
     * @param hNode Node to get the parameters for
     *
     * @return Pointer to return the device address
     */
    external fun graphMemFreeNodeGetParams(hNode : Long) : Long

    //CUresult cuGraphMemcpyNodeGetParams(CUgraphNode hNode, CUDA_MEMCPY3D * nodeParams)
    //CUresult cuGraphMemcpyNodeSetParams(CUgraphNode hNode, const CUDA_MEMCPY3D * nodeParams)
    //CUresult cuGraphMemsetNodeGetParams(CUgraphNode hNode, CUDA_MEMSET_NODE_PARAMS * nodeParams)
    //CUresult cuGraphMemsetNodeSetParams(CUgraphNode hNode, const CUDA_MEMSET_NODE_PARAMS * nodeParams)
    //CUresult cuGraphNodeFindInClone(CUgraphNode * phNode, CUgraphNode hOriginalNode, CUgraph hClonedGraph)
    //CUresult cuGraphNodeGetDependencies(CUgraphNode hNode, CUgraphNode * dependencies, size_t * numDependencies)
    //CUresult cuGraphNodeGetDependencies_v2(CUgraphNode hNode, CUgraphNode * dependencies, CUgraphEdgeData * edgeData, size_t * numDependencies)
    //CUresult cuGraphNodeGetDependentNodes(CUgraphNode hNode, CUgraphNode * dependentNodes, size_t * numDependentNodes)
    //CUresult cuGraphNodeGetDependentNodes_v2(CUgraphNode hNode, CUgraphNode * dependentNodes, CUgraphEdgeData * edgeData, size_t * numDependentNodes)
    //CUresult cuGraphNodeGetEnabled(CUgraphExec hGraphExec, CUgraphNode hNode, unsigned int* isEnabled)
    //CUresult cuGraphNodeGetType(CUgraphNode hNode, CUgraphNodeType * type)
    //CUresult cuGraphNodeSetEnabled(CUgraphExec hGraphExec, CUgraphNode hNode, unsigned int  isEnabled)
    //CUresult cuGraphNodeSetParams(CUgraphNode hNode, CUgraphNodeParams * nodeParams)
    //CUresult cuGraphReleaseUserObject(CUgraph graph, CUuserObject object, unsigned int  count)
    //CUresult cuGraphRemoveDependencies(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, size_t numDependencies)
    //CUresult cuGraphRemoveDependencies_v2(CUgraph hGraph, const CUgraphNode * from, const CUgraphNode * to, const CUgraphEdgeData * edgeData, size_t numDependencies)
    //CUresult cuGraphRetainUserObject(CUgraph graph, CUuserObject object, unsigned int  count, unsigned int  flags)

    /**
     * Uploads an executable graph in a stream. (cuGraphUpload)
     */
    external fun graphUpload(hGraphExec: Long, hStream: Long): Int

    //CUresult cuUserObjectCreate(CUuserObject * object_out, void* ptr, CUhostFn destroy, unsigned int  initialRefcount, unsigned int  flags)

    /**
     * Release a reference to a user object. (cuUserObjectRelease)
     */
    external fun userObjectRelease(cuObject: Long, count: UInt): Int

    /**
     * Retain a reference to a user object. (cuUserObjectRetain)
     */
    external fun userObjectRetain(cuObject: Long, count: UInt): Int

    //25. Occupancy
    //CUresult cuOccupancyAvailableDynamicSMemPerBlock(size_t* dynamicSmemSize, CUfunction func, int  numBlocks, int  blockSize)
    //CUresult cuOccupancyMaxActiveBlocksPerMultiprocessor(int* numBlocks, CUfunction func, int  blockSize, size_t dynamicSMemSize)
    //CUresult cuOccupancyMaxActiveBlocksPerMultiprocessorWithFlags(int* numBlocks, CUfunction func, int  blockSize, size_t dynamicSMemSize, unsigned int  flags)
    //CUresult cuOccupancyMaxActiveClusters(int* numClusters, CUfunction func, const CUlaunchConfig* config)
    //CUresult cuOccupancyMaxPotentialBlockSize(int* minGridSize, int* blockSize, CUfunction func, CUoccupancyB2DSize blockSizeToDynamicSMemSize, size_t dynamicSMemSize, int  blockSizeLimit)
    //CUresult cuOccupancyMaxPotentialBlockSizeWithFlags(int* minGridSize, int* blockSize, CUfunction func, CUoccupancyB2DSize blockSizeToDynamicSMemSize, size_t dynamicSMemSize, int  blockSizeLimit, unsigned int  flags)
    //CUresult cuOccupancyMaxPotentialClusterSize(int* clusterSize, CUfunction func, const CUlaunchConfig * config)

    //26. Texture Reference Management (DEPRECATED)

    //27. Surface Reference Management (DEPRECATED)

    //28. Texture Object Management
    //CUresult cuTexObjectCreate(CUtexObject* pTexObject, const CUDA_RESOURCE_DESC* pResDesc, const CUDA_TEXTURE_DESC* pTexDesc, const CUDA_RESOURCE_VIEW_DESC* pResViewDesc)

    /**
     * 	Destroys a texture object. (cuTextObjectDestroy)
     */
    external fun textObjectDestroy(textObject: Long): Int

    //CUresult cuTexObjectDestroy(CUtexObject texObject)
    //CUresult cuTexObjectGetResourceDesc(CUDA_RESOURCE_DESC* pResDesc, CUtexObject texObject)
    //CUresult cuTexObjectGetResourceViewDesc(CUDA_RESOURCE_VIEW_DESC * pResViewDesc, CUtexObject texObject)
    //CUresult cuTexObjectGetTextureDesc(CUDA_TEXTURE_DESC * pTexDesc, CUtexObject texObject)

    //29. Surface Object Management
    //CUresult cuSurfObjectCreate(CUsurfObject* pSurfObject, const CUDA_RESOURCE_DESC* pResDesc)

    /**
     * 	Destroys a surface object. (cuSurfObjectDestroy)
     */
    external fun surfObjectDestroy(surfObject: Long): Int

    //CUresult cuSurfObjectGetResourceDesc(CUDA_RESOURCE_DESC* pResDesc, CUsurfObject surfObject)

    //31. Peer Context Memory Access

    /**
     * 	Disables direct access to memory allocations in a peer context and unregisters any registered allocations. (cuCtxDisablePeerAccess)
     */
    external fun ctxDisablePeerAccess(peerContext: Long): Int


    /**
     * Enables direct access to memory allocations in a peer context. (cuCtxEnablePeerAccess)
     */
    external fun ctxEnablePeerAccess(peerContext: Long, flags: Int): Int

    /**
     * Queries if a device may directly access a peer device's memory. (cuDeviceCanAccessPeer)
     *
     * @param dev Device from which allocations on peerDev are to be directly accessed.
     * @param peerDev Device on which the allocations to be directly accessed by dev reside.
     *
     * @return Returned access capability
     */
    external fun deviceCanAccessPeer(dev : Int, peerDev : Int) : Int

    //CUresult cuDeviceGetP2PAttribute(int* value, CUdevice_P2PAttribute attrib, CUdevice srcDevice, CUdevice dstDevice)

    //32. Graphics Interoperability
    //CUresult cuGraphicsMapResources(unsigned int  count, CUgraphicsResource* resources, CUstream hStream)
    //CUresult cuGraphicsResourceGetMappedMipmappedArray(CUmipmappedArray * pMipmappedArray, CUgraphicsResource resource)
    //CUresult cuGraphicsResourceGetMappedPointer(CUdeviceptr * pDevPtr, size_t * pSize, CUgraphicsResource resource)

    /**
     * Set usage flags for mapping a graphics resource. (cuGraphicsResourceSetMapFlags)
     */
    external fun graphicsResourceSetMapFlags(resource: Long, flags: Int): Int

    //CUresult cuGraphicsSubResourceGetMappedArray(CUarray * pArray, CUgraphicsResource resource, unsigned int  arrayIndex, unsigned int  mipLevel)
    //CUresult cuGraphicsUnmapResources(unsigned int  count, CUgraphicsResource * resources, CUstream hStream)

    /**
     * 	Unregisters a graphics resource for access by CUDA. (cuGraphicsUnregisterResource)
     */
    external fun graphicsUnregisterResource(resource: Long): Int

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
    }
}