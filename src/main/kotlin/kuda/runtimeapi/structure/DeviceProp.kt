package kuda.runtimeapi.structure

/*
* @See https://docs.nvidia.com/cuda/cuda-runtime-api/structcudaDeviceProp.html#structcudaDeviceProp
* */

data class DeviceProp(
    var eccEnabled: Int,
    var accessPolicyMaxWindowSize : Int,
    var asyncEngineCount : Int,
    var canMapHostMemory : Int,
    var canUseHostPointerForRegisteredMem : Int,
    var clockRate : Int,
    var clusterLaunch : Int,
    var computeMode : Int,
    var computePreemptionSupported : Int,
    var concurrentKernels : Int,
    var concurrentManagedAccess : Int,
    var cooperativeLaunch : Int,
    var cooperativeMultiDeviceLaunch : Int,
    var deferredMappingCudaArraySupported : Int,
    var deviceOverlap : Int,
    var directManagedMemAccessFromHost : Int,
    var globalL1CacheSupported : Int,
    var gpuDirectRDMAFlushWritesOptions : UInt,
    var gpuDirectRDMASupported : Int,
    var gpuDirectRDMAWritesOrdering : Int,
    var hostNativeAtomicSupported : Int,
    var hostRegisterReadOnlySupported : Int,
    var hostRegisterSupported : Int,
    var integrated : Int,
    var ipcEventSupported : Int,
    var isMultiGpuBoard : Int,
    var kernelExecTimeoutEnabled : Int,
    var l2CacheSize : Int,
    var localL1CacheSupported : Int,
    var luid : String,
    var luidDeviceNodeMask : UInt,
    var major : Int,
    var managedMemory : Int,
    var maxBlocksPerMultiProcessor : Int,
    var maxGridSize : IntArray = IntArray(3) ,
    var maxSurface1D : Int,
    var maxSurface1DLayered : IntArray = IntArray(2),
    var maxSurface2D : IntArray = IntArray(2),
    var maxSurface2DLayered : IntArray = IntArray(3),
    var maxSurface3D : IntArray = IntArray(3),
    var maxSurfaceCubemap : Int,
    var maxSurfaceCubemapLayered : IntArray = IntArray(2),
    var maxTexture1D : Int,
    var maxTexture1DLayered : IntArray = IntArray(2),
    var maxTexture1DLinear : Int,
    var maxTexture1DMipmap : Int,
    var maxTexture2D : IntArray = IntArray(2),
    var maxTexture2DGather : IntArray = IntArray(2),
    var maxTexture2DLayered : IntArray = IntArray(3),
    var maxTexture2DLinear : IntArray = IntArray(3),
    var maxTexture2DMipmap : IntArray = IntArray(2),
    var maxTexture3D : IntArray = IntArray(3),
    var maxTexture3DAlt : IntArray = IntArray(3),
    var maxTextureCubemap : Int,
    var maxTextureCubemapLayered : IntArray = IntArray(2),
    var maxThreadsDim : IntArray = IntArray(3),
    var maxThreadsPerBlock : Int,
    var maxThreadsPerMultiProcessor : Int,
    var memPitch : Long,
    var memoryBusWidth : Int,
    var memoryClockRate : Int,
    var memoryPoolSupportedHandleTypes : UInt,
    var memoryPoolsSupported : Int,
    var minor : Int,
    var multiGpuBoardGroupID : Int,
    var multiProcessorCount : Int,
    var name : String,
    var pageableMemoryAccess : Int,
    var pageableMemoryAccessUsesHostPageTables : Int,
    var pciBusID : Int,
    var pciDeviceID : Int,
    var pciDomainID : Int,
    var persistingL2CacheMaxSize : Int,
    var regsPerBlock : Int,
    var regsPerMultiprocessor : Int,
    var reserved : IntArray = IntArray(61),
    var reserved2 : IntArray = IntArray(2),
    var reservedSharedMemPerBlock : Long,
    var sharedMemPerBlock : Long,
    var sharedMemPerBlockOptin : Long,
    var sharedMemPerMultiprocessor : Long,
    var singleToDoublePrecisionPerfRatio : Int,
    var sparseCudaArraySupported : Int,
    var streamPrioritiesSupported : Int,
    var surfaceAlignment : Long,
    var tccDriver : Int,
    var textureAlignment : Long,
    var texturePitchAlignment : Long,
    var timelineSemaphoreInteropSupported : Int,
    var totalConstMem : Long,
    var totalGlobalMem : Long,
    var unifiedAddressing : Int,
    var unifiedFunctionPointers : Int,
    var uuid : ByteArray = ByteArray(16),
    var warpSize : Int
)