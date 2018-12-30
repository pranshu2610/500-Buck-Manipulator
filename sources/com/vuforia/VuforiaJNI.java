package com.vuforia;

import java.math.BigInteger;
import java.nio.ByteBuffer;

class VuforiaJNI {
    public static final native long AnchorList_at(long j, AnchorList anchorList, int i);

    public static final native boolean AnchorList_empty(long j, AnchorList anchorList);

    public static final native int AnchorList_size(long j, AnchorList anchorList);

    public static final native long AnchorResult_SWIGUpcast(long j);

    public static final native long AnchorResult_getClassType();

    public static final native long AnchorResult_getTrackable(long j, AnchorResult anchorResult);

    public static final native long Anchor_SWIGUpcast(long j);

    public static final native long Anchor_getClassType();

    public static final native int Area_getType(long j, Area area);

    public static final native long Box3D_getMaximumPosition(long j, Box3D box3D);

    public static final native long Box3D_getMinimumPosition(long j, Box3D box3D);

    public static final native long CameraCalibration_getDistortionParameters(long j, CameraCalibration cameraCalibration);

    public static final native long CameraCalibration_getFieldOfViewRads(long j, CameraCalibration cameraCalibration);

    public static final native long CameraCalibration_getFocalLength(long j, CameraCalibration cameraCalibration);

    public static final native long CameraCalibration_getPrincipalPoint(long j, CameraCalibration cameraCalibration);

    public static final native long CameraCalibration_getSize(long j, CameraCalibration cameraCalibration);

    public static final native boolean CameraDevice_deinit(long j, CameraDevice cameraDevice);

    public static final native long CameraDevice_getCameraCalibration(long j, CameraDevice cameraDevice);

    public static final native int CameraDevice_getCameraDirection(long j, CameraDevice cameraDevice);

    public static final native boolean CameraDevice_getCameraField(long j, CameraDevice cameraDevice, int i, long j2, CameraField cameraField);

    public static final native boolean CameraDevice_getFieldBool(long j, CameraDevice cameraDevice, String str, boolean[] zArr);

    public static final native boolean CameraDevice_getFieldFloat(long j, CameraDevice cameraDevice, String str, float[] fArr);

    public static final native boolean CameraDevice_getFieldInt64(long j, CameraDevice cameraDevice, String str, long[] jArr);

    public static final native boolean CameraDevice_getFieldInt64Range(long j, CameraDevice cameraDevice, String str, long[] jArr);

    public static final native String CameraDevice_getFieldString(long j, CameraDevice cameraDevice, String str);

    public static final native long CameraDevice_getInstance();

    public static final native int CameraDevice_getNumFields(long j, CameraDevice cameraDevice);

    public static final native int CameraDevice_getNumVideoModes(long j, CameraDevice cameraDevice);

    public static final native long CameraDevice_getVideoMode(long j, CameraDevice cameraDevice, int i);

    public static final native boolean CameraDevice_init__SWIG_0(long j, CameraDevice cameraDevice);

    public static final native boolean CameraDevice_init__SWIG_1(long j, CameraDevice cameraDevice, int i);

    public static final native boolean CameraDevice_selectVideoMode(long j, CameraDevice cameraDevice, int i);

    public static final native boolean CameraDevice_setField__SWIG_0(long j, CameraDevice cameraDevice, String str, String str2);

    public static final native boolean CameraDevice_setField__SWIG_1(long j, CameraDevice cameraDevice, String str, long j2);

    public static final native boolean CameraDevice_setField__SWIG_2(long j, CameraDevice cameraDevice, String str, float f);

    public static final native boolean CameraDevice_setField__SWIG_3(long j, CameraDevice cameraDevice, String str, boolean z);

    public static final native boolean CameraDevice_setField__SWIG_4(long j, CameraDevice cameraDevice, String str, long[] jArr);

    public static final native boolean CameraDevice_setFlashTorchMode(long j, CameraDevice cameraDevice, boolean z);

    public static final native boolean CameraDevice_setFocusMode(long j, CameraDevice cameraDevice, int i);

    public static final native boolean CameraDevice_start(long j, CameraDevice cameraDevice);

    public static final native boolean CameraDevice_stop(long j, CameraDevice cameraDevice);

    public static final native String CameraField_Key_get(long j, CameraField cameraField);

    public static final native int CameraField_Type_get(long j, CameraField cameraField);

    public static final native long CustomViewerParameters_SWIGUpcast(long j);

    public static final native void CustomViewerParameters_addDistortionCoefficient(long j, CustomViewerParameters customViewerParameters, float f);

    public static final native void CustomViewerParameters_clearDistortionCoefficients(long j, CustomViewerParameters customViewerParameters);

    public static final native void CustomViewerParameters_setButtonType(long j, CustomViewerParameters customViewerParameters, int i);

    public static final native void CustomViewerParameters_setContainsMagnet(long j, CustomViewerParameters customViewerParameters, boolean z);

    public static final native void CustomViewerParameters_setFieldOfView(long j, CustomViewerParameters customViewerParameters, long j2, Vec4F vec4F);

    public static final native void CustomViewerParameters_setInterLensDistance(long j, CustomViewerParameters customViewerParameters, float f);

    public static final native void CustomViewerParameters_setLensCentreToTrayDistance(long j, CustomViewerParameters customViewerParameters, float f);

    public static final native void CustomViewerParameters_setScreenToLensDistance(long j, CustomViewerParameters customViewerParameters, float f);

    public static final native void CustomViewerParameters_setTrayAlignment(long j, CustomViewerParameters customViewerParameters, int i);

    public static final native long CylinderTargetResult_SWIGUpcast(long j);

    public static final native long CylinderTargetResult_getClassType();

    public static final native long CylinderTargetResult_getTrackable(long j, CylinderTargetResult cylinderTargetResult);

    public static final native long CylinderTarget_SWIGUpcast(long j);

    public static final native float CylinderTarget_getBottomDiameter(long j, CylinderTarget cylinderTarget);

    public static final native long CylinderTarget_getClassType();

    public static final native float CylinderTarget_getSideLength(long j, CylinderTarget cylinderTarget);

    public static final native float CylinderTarget_getTopDiameter(long j, CylinderTarget cylinderTarget);

    public static final native boolean CylinderTarget_setBottomDiameter(long j, CylinderTarget cylinderTarget, float f);

    public static final native boolean CylinderTarget_setSideLength(long j, CylinderTarget cylinderTarget, float f);

    public static final native boolean CylinderTarget_setTopDiameter(long j, CylinderTarget cylinderTarget, float f);

    public static final native long DataSetList_at(long j, DataSetList dataSetList, int i);

    public static final native boolean DataSetList_empty(long j, DataSetList dataSetList);

    public static final native int DataSetList_size(long j, DataSetList dataSetList);

    public static final native long DataSet_createMultiTarget(long j, DataSet dataSet, String str);

    public static final native long DataSet_createTrackable(long j, DataSet dataSet, long j2, TrackableSource trackableSource);

    public static final native boolean DataSet_destroy(long j, DataSet dataSet, long j2, Trackable trackable);

    public static final native boolean DataSet_exists(String str, int i);

    public static final native int DataSet_getNumTrackables(long j, DataSet dataSet);

    public static final native long DataSet_getTrackable(long j, DataSet dataSet, int i);

    public static final native long DataSet_getTrackables(long j, DataSet dataSet);

    public static final native boolean DataSet_hasReachedTrackableLimit(long j, DataSet dataSet);

    public static final native boolean DataSet_isActive(long j, DataSet dataSet);

    public static final native boolean DataSet_load(long j, DataSet dataSet, String str, int i);

    public static final native long DeviceTrackableResult_SWIGUpcast(long j);

    public static final native long DeviceTrackableResult_getClassType();

    public static final native long DeviceTrackableResult_getTrackable(long j, DeviceTrackableResult deviceTrackableResult);

    public static final native long DeviceTrackable_SWIGUpcast(long j);

    public static final native long DeviceTrackable_getClassType();

    public static final native long DeviceTracker_SWIGUpcast(long j);

    public static final native long DeviceTracker_getClassType();

    public static final native long DeviceTracker_getWorldToDeviceBaseTransform(long j, DeviceTracker deviceTracker);

    public static final native boolean DeviceTracker_setWorldToDeviceBaseTransform(long j, DeviceTracker deviceTracker, long j2, Matrix34F matrix34F);

    public static final native long Device_getClassType();

    public static final native long Device_getInstance();

    public static final native int Device_getMode(long j, Device device);

    public static final native long Device_getRenderingPrimitives(long j, Device device);

    public static final native long Device_getSelectedViewer(long j, Device device);

    public static final native long Device_getType(long j, Device device);

    public static final native long Device_getViewerList(long j, Device device);

    public static final native boolean Device_isOfType(long j, Device device, long j2, Type type);

    public static final native boolean Device_isViewerActive(long j, Device device);

    public static final native boolean Device_selectViewer(long j, Device device, long j2, ViewerParameters viewerParameters);

    public static final native void Device_setConfigurationChanged(long j, Device device);

    public static final native boolean Device_setMode(long j, Device device, int i);

    public static final native void Device_setViewerActive(long j, Device device, boolean z);

    public static final native boolean EyewearCalibrationProfileManager_clearProfile(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i);

    public static final native int EyewearCalibrationProfileManager_getActiveProfile(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager);

    public static final native long EyewearCalibrationProfileManager_getCameraToEyePose(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i, int i2);

    public static final native long EyewearCalibrationProfileManager_getEyeProjection(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i, int i2);

    public static final native long EyewearCalibrationProfileManager_getMaxCount(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager);

    public static final native short[] EyewearCalibrationProfileManager_getProfileName(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i);

    public static final native long EyewearCalibrationProfileManager_getUsedCount(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager);

    public static final native boolean EyewearCalibrationProfileManager_isProfileUsed(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i);

    public static final native boolean EyewearCalibrationProfileManager_setActiveProfile(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i);

    public static final native boolean EyewearCalibrationProfileManager_setCameraToEyePose(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i, int i2, long j2, Matrix34F matrix34F);

    public static final native boolean EyewearCalibrationProfileManager_setEyeProjection(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i, int i2, long j2, Matrix34F matrix34F);

    public static final native boolean EyewearCalibrationProfileManager_setProfileName(long j, EyewearCalibrationProfileManager eyewearCalibrationProfileManager, int i, short[] sArr);

    public static final native float EyewearCalibrationReading_CenterX_get(long j, EyewearCalibrationReading eyewearCalibrationReading);

    public static final native void EyewearCalibrationReading_CenterX_set(long j, EyewearCalibrationReading eyewearCalibrationReading, float f);

    public static final native float EyewearCalibrationReading_CenterY_get(long j, EyewearCalibrationReading eyewearCalibrationReading);

    public static final native void EyewearCalibrationReading_CenterY_set(long j, EyewearCalibrationReading eyewearCalibrationReading, float f);

    public static final native long EyewearCalibrationReading_Pose_get(long j, EyewearCalibrationReading eyewearCalibrationReading);

    public static final native void EyewearCalibrationReading_Pose_set(long j, EyewearCalibrationReading eyewearCalibrationReading, long j2, Matrix34F matrix34F);

    public static final native float EyewearCalibrationReading_Scale_get(long j, EyewearCalibrationReading eyewearCalibrationReading);

    public static final native void EyewearCalibrationReading_Scale_set(long j, EyewearCalibrationReading eyewearCalibrationReading, float f);

    public static final native int EyewearCalibrationReading_Type_get(long j, EyewearCalibrationReading eyewearCalibrationReading);

    public static final native void EyewearCalibrationReading_Type_set(long j, EyewearCalibrationReading eyewearCalibrationReading, int i);

    public static final native long EyewearDevice_SWIGUpcast(long j);

    public static final native long EyewearDevice_getCalibrationProfileManager(long j, EyewearDevice eyewearDevice);

    public static final native long EyewearDevice_getClassType();

    public static final native int EyewearDevice_getScreenOrientation(long j, EyewearDevice eyewearDevice);

    public static final native long EyewearDevice_getUserCalibrator(long j, EyewearDevice eyewearDevice);

    public static final native boolean EyewearDevice_isDisplayExtended(long j, EyewearDevice eyewearDevice);

    public static final native boolean EyewearDevice_isDisplayExtendedGLOnly(long j, EyewearDevice eyewearDevice);

    public static final native boolean EyewearDevice_isDualDisplay(long j, EyewearDevice eyewearDevice);

    public static final native boolean EyewearDevice_isPredictiveTrackingEnabled(long j, EyewearDevice eyewearDevice);

    public static final native boolean EyewearDevice_isSeeThru(long j, EyewearDevice eyewearDevice);

    public static final native boolean EyewearDevice_setDisplayExtended(long j, EyewearDevice eyewearDevice, boolean z);

    public static final native boolean EyewearDevice_setPredictiveTracking(long j, EyewearDevice eyewearDevice, boolean z);

    public static final native float EyewearUserCalibrator_getDrawingAspectRatio(long j, EyewearUserCalibrator eyewearUserCalibrator, long j2, long j3);

    public static final native float EyewearUserCalibrator_getMaxScaleHint(long j, EyewearUserCalibrator eyewearUserCalibrator);

    public static final native float EyewearUserCalibrator_getMinScaleHint(long j, EyewearUserCalibrator eyewearUserCalibrator);

    public static final native int EyewearUserCalibrator_getProjectionMatrices(long j, EyewearUserCalibrator eyewearUserCalibrator, long[] jArr, int i, long[] jArr2, int i2, long j2, Matrix34F matrix34F, long j3, Matrix34F matrix34F2, long j4, Matrix34F matrix34F3, long j5, Matrix34F matrix34F4);

    public static final native boolean EyewearUserCalibrator_getProjectionMatrix(long j, EyewearUserCalibrator eyewearUserCalibrator, long[] jArr, int i, long j2, Matrix34F matrix34F, long j3, Matrix34F matrix34F2);

    public static final native boolean EyewearUserCalibrator_init(long j, EyewearUserCalibrator eyewearUserCalibrator, long j2, long j3, float f, float f2);

    public static final native boolean EyewearUserCalibrator_isStereoStretched(long j, EyewearUserCalibrator eyewearUserCalibrator);

    public static final native long Frame_getImage(long j, Frame frame, int i);

    public static final native long Frame_getImages(long j, Frame frame);

    public static final native int Frame_getIndex(long j, Frame frame);

    public static final native long Frame_getNumImages(long j, Frame frame);

    public static final native double Frame_getTimeStamp(long j, Frame frame);

    public static final native long GLTextureData_SWIGUpcast(long j);

    public static final native int GLTextureData_VideoBackgroundTextureID_get(long j, GLTextureData gLTextureData);

    public static final native void GLTextureData_VideoBackgroundTextureID_set(long j, GLTextureData gLTextureData, int i);

    public static final native long GLTextureUnit_SWIGUpcast(long j);

    public static final native int GLTextureUnit_TextureUnit_get(long j, GLTextureUnit gLTextureUnit);

    public static final native void GLTextureUnit_TextureUnit_set(long j, GLTextureUnit gLTextureUnit, int i);

    public static final native long GuideViewList_at(long j, GuideViewList guideViewList, int i);

    public static final native boolean GuideViewList_empty(long j, GuideViewList guideViewList);

    public static final native int GuideViewList_size(long j, GuideViewList guideViewList);

    public static final native long GuideView_getImage(long j, GuideView guideView);

    public static final native long GuideView_getIntrinsics(long j, GuideView guideView);

    public static final native long GuideView_getPose(long j, GuideView guideView);

    public static final native void GuideView_setPose(long j, GuideView guideView, long j2, Matrix34F matrix34F);

    public static final native long HandheldTransformModel_SWIGUpcast(long j);

    public static final native long HandheldTransformModel_getPivotPoint(long j, HandheldTransformModel handheldTransformModel);

    public static final native int HandheldTransformModel_getType(long j, HandheldTransformModel handheldTransformModel);

    public static final native boolean HandheldTransformModel_setPivotPoint(long j, HandheldTransformModel handheldTransformModel, long j2, Vec3F vec3F);

    public static final native long HeadTransformModel_SWIGUpcast(long j);

    public static final native long HeadTransformModel_getPivotPoint(long j, HeadTransformModel headTransformModel);

    public static final native int HeadTransformModel_getType(long j, HeadTransformModel headTransformModel);

    public static final native boolean HeadTransformModel_setPivotPoint(long j, HeadTransformModel headTransformModel, long j2, Vec3F vec3F);

    public static final native long HitTestResultList_at(long j, HitTestResultList hitTestResultList, int i);

    public static final native boolean HitTestResultList_empty(long j, HitTestResultList hitTestResultList);

    public static final native int HitTestResultList_size(long j, HitTestResultList hitTestResultList);

    public static final native long HitTestResult_getPose(long j, HitTestResult hitTestResult);

    public static final native float Illumination_AMBIENT_COLOR_TEMPERATURE_UNAVAILABLE_get();

    public static final native float Illumination_AMBIENT_INTENSITY_UNAVAILABLE_get();

    public static final native float Illumination_getAmbientColorTemperature(long j, Illumination illumination);

    public static final native float Illumination_getAmbientIntensity(long j, Illumination illumination);

    public static final native long ImageList_at(long j, ImageList imageList, int i);

    public static final native boolean ImageList_empty(long j, ImageList imageList);

    public static final native int ImageList_size(long j, ImageList imageList);

    public static final native boolean ImageTargetBuilder_build(long j, ImageTargetBuilder imageTargetBuilder, String str, float f);

    public static final native int ImageTargetBuilder_getFrameQuality(long j, ImageTargetBuilder imageTargetBuilder);

    public static final native long ImageTargetBuilder_getTrackableSource(long j, ImageTargetBuilder imageTargetBuilder);

    public static final native void ImageTargetBuilder_startScan(long j, ImageTargetBuilder imageTargetBuilder);

    public static final native void ImageTargetBuilder_stopScan(long j, ImageTargetBuilder imageTargetBuilder);

    public static final native long ImageTargetResult_SWIGUpcast(long j);

    public static final native long ImageTargetResult_getClassType();

    public static final native int ImageTargetResult_getNumVirtualButtons(long j, ImageTargetResult imageTargetResult);

    public static final native long ImageTargetResult_getTrackable(long j, ImageTargetResult imageTargetResult);

    public static final native long ImageTargetResult_getVirtualButtonResult__SWIG_0(long j, ImageTargetResult imageTargetResult, int i);

    public static final native long ImageTargetResult_getVirtualButtonResult__SWIG_1(long j, ImageTargetResult imageTargetResult, String str);

    public static final native long ImageTargetResult_getVirtualButtonResults(long j, ImageTargetResult imageTargetResult);

    public static final native long ImageTarget_SWIGUpcast(long j);

    public static final native long ImageTarget_createVirtualButton(long j, ImageTarget imageTarget, String str, long j2, Area area);

    public static final native boolean ImageTarget_destroyVirtualButton(long j, ImageTarget imageTarget, long j2, VirtualButton virtualButton);

    public static final native long ImageTarget_getClassType();

    public static final native String ImageTarget_getMetaData(long j, ImageTarget imageTarget);

    public static final native int ImageTarget_getNumVirtualButtons(long j, ImageTarget imageTarget);

    public static final native long ImageTarget_getVirtualButton__SWIG_0(long j, ImageTarget imageTarget, int i);

    public static final native long ImageTarget_getVirtualButton__SWIG_1(long j, ImageTarget imageTarget, String str);

    public static final native long ImageTarget_getVirtualButtons(long j, ImageTarget imageTarget);

    public static final native int Image_getBufferHeight(long j, Image image);

    public static final native int Image_getBufferWidth(long j, Image image);

    public static final native int Image_getFormat(long j, Image image);

    public static final native int Image_getHeight(long j, Image image);

    public static final native ByteBuffer Image_getPixels(long j, Image image);

    public static final native int Image_getStride(long j, Image image);

    public static final native int Image_getWidth(long j, Image image);

    public static final native ByteBuffer InstanceId_getBuffer(long j, InstanceId instanceId);

    public static final native int InstanceId_getDataType(long j, InstanceId instanceId);

    public static final native long InstanceId_getLength(long j, InstanceId instanceId);

    public static final native BigInteger InstanceId_getNumericValue(long j, InstanceId instanceId);

    public static final native float[] Matrix34F_data_get(long j, Matrix34F matrix34F);

    public static final native void Matrix34F_data_set(long j, Matrix34F matrix34F, float[] fArr);

    public static final native float[] Matrix44F_data_get(long j, Matrix44F matrix44F);

    public static final native void Matrix44F_data_set(long j, Matrix44F matrix44F, float[] fArr);

    public static final native ByteBuffer Mesh_getNormals(long j, Mesh mesh);

    public static final native int Mesh_getNumTriangles(long j, Mesh mesh);

    public static final native int Mesh_getNumVertices(long j, Mesh mesh);

    public static final native ByteBuffer Mesh_getPositions(long j, Mesh mesh);

    public static final native ByteBuffer Mesh_getTriangles(long j, Mesh mesh);

    public static final native ByteBuffer Mesh_getUVs(long j, Mesh mesh);

    public static final native boolean Mesh_hasNormals(long j, Mesh mesh);

    public static final native boolean Mesh_hasPositions(long j, Mesh mesh);

    public static final native boolean Mesh_hasUVs(long j, Mesh mesh);

    public static final native long ModelTargetResult_SWIGUpcast(long j);

    public static final native long ModelTargetResult_getClassType();

    public static final native long ModelTargetResult_getTrackable(long j, ModelTargetResult modelTargetResult);

    public static final native long ModelTarget_SWIGUpcast(long j);

    public static final native long ModelTarget_getBoundingBox(long j, ModelTarget modelTarget);

    public static final native long ModelTarget_getClassType();

    public static final native long ModelTarget_getGuideView(long j, ModelTarget modelTarget, int i);

    public static final native long ModelTarget_getGuideViews(long j, ModelTarget modelTarget);

    public static final native int ModelTarget_getNumGuideViews(long j, ModelTarget modelTarget);

    public static final native long ModelTarget_getSize(long j, ModelTarget modelTarget);

    public static final native String ModelTarget_getUniqueTargetId(long j, ModelTarget modelTarget);

    public static final native boolean ModelTarget_setSize(long j, ModelTarget modelTarget, long j2, Vec3F vec3F);

    public static final native long MultiTargetResult_SWIGUpcast(long j);

    public static final native long MultiTargetResult_getClassType();

    public static final native int MultiTargetResult_getNumPartResults(long j, MultiTargetResult multiTargetResult);

    public static final native long MultiTargetResult_getPartResult__SWIG_0(long j, MultiTargetResult multiTargetResult, int i);

    public static final native long MultiTargetResult_getPartResult__SWIG_1(long j, MultiTargetResult multiTargetResult, String str);

    public static final native long MultiTargetResult_getPartResults(long j, MultiTargetResult multiTargetResult);

    public static final native long MultiTargetResult_getTrackable(long j, MultiTargetResult multiTargetResult);

    public static final native long MultiTarget_SWIGUpcast(long j);

    public static final native int MultiTarget_addPart(long j, MultiTarget multiTarget, long j2, Trackable trackable);

    public static final native long MultiTarget_getClassType();

    public static final native int MultiTarget_getNumParts(long j, MultiTarget multiTarget);

    public static final native boolean MultiTarget_getPartOffset(long j, MultiTarget multiTarget, int i, long j2, Matrix34F matrix34F);

    public static final native long MultiTarget_getPart__SWIG_0(long j, MultiTarget multiTarget, int i);

    public static final native long MultiTarget_getPart__SWIG_1(long j, MultiTarget multiTarget, String str);

    public static final native long MultiTarget_getParts(long j, MultiTarget multiTarget);

    public static final native boolean MultiTarget_removePart(long j, MultiTarget multiTarget, int i);

    public static final native boolean MultiTarget_setPartOffset(long j, MultiTarget multiTarget, int i, long j2, Matrix34F matrix34F);

    public static final native long Obb2D_getCenter(long j, Obb2D obb2D);

    public static final native long Obb2D_getHalfExtents(long j, Obb2D obb2D);

    public static final native float Obb2D_getRotation(long j, Obb2D obb2D);

    public static final native long Obb3D_getCenter(long j, Obb3D obb3D);

    public static final native long Obb3D_getHalfExtents(long j, Obb3D obb3D);

    public static final native float Obb3D_getRotationZ(long j, Obb3D obb3D);

    public static final native long ObjectTargetList_at(long j, ObjectTargetList objectTargetList, int i);

    public static final native boolean ObjectTargetList_empty(long j, ObjectTargetList objectTargetList);

    public static final native int ObjectTargetList_size(long j, ObjectTargetList objectTargetList);

    public static final native long ObjectTargetResult_SWIGUpcast(long j);

    public static final native long ObjectTargetResult_getClassType();

    public static final native long ObjectTargetResult_getTrackable(long j, ObjectTargetResult objectTargetResult);

    public static final native long ObjectTarget_SWIGUpcast(long j);

    public static final native long ObjectTarget_getClassType();

    public static final native long ObjectTarget_getSize(long j, ObjectTarget objectTarget);

    public static final native String ObjectTarget_getUniqueTargetId(long j, ObjectTarget objectTarget);

    public static final native boolean ObjectTarget_setSize(long j, ObjectTarget objectTarget, long j2, Vec3F vec3F);

    public static final native long ObjectTracker_SWIGUpcast(long j);

    public static final native boolean ObjectTracker_activateDataSet(long j, ObjectTracker objectTracker, long j2, DataSet dataSet);

    public static final native long ObjectTracker_createDataSet(long j, ObjectTracker objectTracker);

    public static final native boolean ObjectTracker_deactivateDataSet(long j, ObjectTracker objectTracker, long j2, DataSet dataSet);

    public static final native boolean ObjectTracker_destroyDataSet(long j, ObjectTracker objectTracker, long j2, DataSet dataSet);

    public static final native long ObjectTracker_getActiveDataSet(long j, ObjectTracker objectTracker, int i);

    public static final native int ObjectTracker_getActiveDataSetCount(long j, ObjectTracker objectTracker);

    public static final native long ObjectTracker_getActiveDataSets(long j, ObjectTracker objectTracker);

    public static final native long ObjectTracker_getClassType();

    public static final native long ObjectTracker_getImageTargetBuilder(long j, ObjectTracker objectTracker);

    public static final native long ObjectTracker_getTargetFinder(long j, ObjectTracker objectTracker);

    public static final native long PositionalDeviceTracker_SWIGUpcast(long j);

    public static final native long PositionalDeviceTracker_createAnchor__SWIG_0(long j, PositionalDeviceTracker positionalDeviceTracker, String str, long j2, Matrix34F matrix34F);

    public static final native long PositionalDeviceTracker_createAnchor__SWIG_1(long j, PositionalDeviceTracker positionalDeviceTracker, String str, long j2, HitTestResult hitTestResult);

    public static final native boolean PositionalDeviceTracker_destroyAnchor(long j, PositionalDeviceTracker positionalDeviceTracker, long j2, Anchor anchor);

    public static final native long PositionalDeviceTracker_getAnchor(long j, PositionalDeviceTracker positionalDeviceTracker, int i);

    public static final native long PositionalDeviceTracker_getAnchors(long j, PositionalDeviceTracker positionalDeviceTracker);

    public static final native long PositionalDeviceTracker_getClassType();

    public static final native int PositionalDeviceTracker_getNumAnchors(long j, PositionalDeviceTracker positionalDeviceTracker);

    public static final native boolean PositionalDeviceTracker_reset(long j, PositionalDeviceTracker positionalDeviceTracker);

    public static final native long RectangleInt_SWIGUpcast(long j);

    public static final native int RectangleInt_getAreaSize(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getHeight(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getLeftTopX(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getLeftTopY(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getRightBottomX(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getRightBottomY(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getType(long j, RectangleInt rectangleInt);

    public static final native int RectangleInt_getWidth(long j, RectangleInt rectangleInt);

    public static final native long Rectangle_SWIGUpcast(long j);

    public static final native float Rectangle_getAreaSize(long j, Rectangle rectangle);

    public static final native float Rectangle_getHeight(long j, Rectangle rectangle);

    public static final native float Rectangle_getLeftTopX(long j, Rectangle rectangle);

    public static final native float Rectangle_getLeftTopY(long j, Rectangle rectangle);

    public static final native float Rectangle_getRightBottomX(long j, Rectangle rectangle);

    public static final native float Rectangle_getRightBottomY(long j, Rectangle rectangle);

    public static final native int Rectangle_getType(long j, Rectangle rectangle);

    public static final native float Rectangle_getWidth(long j, Rectangle rectangle);

    public static final native boolean RendererHelper_drawVideoBackground();

    public static final native void Renderer_begin(long j, Renderer renderer, long j2, State state);

    public static final native void Renderer_end(long j, Renderer renderer);

    public static final native long Renderer_getInstance();

    public static final native int Renderer_getRecommendedFps__SWIG_0(long j, Renderer renderer, int i);

    public static final native int Renderer_getRecommendedFps__SWIG_1(long j, Renderer renderer);

    public static final native long Renderer_getVideoBackgroundConfig(long j, Renderer renderer);

    public static final native long Renderer_getVideoBackgroundTextureInfo(long j, Renderer renderer);

    public static final native boolean Renderer_setTargetFps(long j, Renderer renderer, int i);

    public static final native void Renderer_setVideoBackgroundConfig(long j, Renderer renderer, long j2, VideoBackgroundConfig videoBackgroundConfig);

    public static final native boolean Renderer_setVideoBackgroundTexture(long j, Renderer renderer, long j2, TextureData textureData);

    public static final native boolean Renderer_updateVideoBackgroundTexture__SWIG_0(long j, Renderer renderer, long j2, TextureUnit textureUnit);

    public static final native boolean Renderer_updateVideoBackgroundTexture__SWIG_1(long j, Renderer renderer);

    public static final native long RenderingPrimitives_getDistortionTextureMesh(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getDistortionTextureSize(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getDistortionTextureViewport(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getEffectiveFov(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getEyeDisplayAdjustmentMatrix(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getNormalizedViewport(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getProjectionMatrix__SWIG_0(long j, RenderingPrimitives renderingPrimitives, int i, long j2, CameraCalibration cameraCalibration, boolean z);

    public static final native long RenderingPrimitives_getProjectionMatrix__SWIG_1(long j, RenderingPrimitives renderingPrimitives, int i, long j2, CameraCalibration cameraCalibration);

    public static final native long RenderingPrimitives_getRenderingViews(long j, RenderingPrimitives renderingPrimitives);

    public static final native long RenderingPrimitives_getVideoBackgroundMesh(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_0(long j, RenderingPrimitives renderingPrimitives, int i, boolean z);

    public static final native long RenderingPrimitives_getVideoBackgroundProjectionMatrix__SWIG_1(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getVideoBackgroundTextureSize(long j, RenderingPrimitives renderingPrimitives);

    public static final native long RenderingPrimitives_getViewport(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RenderingPrimitives_getViewportCentreToEyeAxis(long j, RenderingPrimitives renderingPrimitives, int i);

    public static final native long RotationalDeviceTracker_SWIGUpcast(long j);

    public static final native long RotationalDeviceTracker_getClassType();

    public static final native long RotationalDeviceTracker_getDefaultHandheldModel(long j, RotationalDeviceTracker rotationalDeviceTracker);

    public static final native long RotationalDeviceTracker_getDefaultHeadModel(long j, RotationalDeviceTracker rotationalDeviceTracker);

    public static final native long RotationalDeviceTracker_getModelCorrection(long j, RotationalDeviceTracker rotationalDeviceTracker);

    public static final native boolean RotationalDeviceTracker_getPosePrediction(long j, RotationalDeviceTracker rotationalDeviceTracker);

    public static final native boolean RotationalDeviceTracker_recenter(long j, RotationalDeviceTracker rotationalDeviceTracker);

    public static final native boolean RotationalDeviceTracker_setModelCorrection(long j, RotationalDeviceTracker rotationalDeviceTracker, long j2, TransformModel transformModel);

    public static final native boolean RotationalDeviceTracker_setPosePrediction(long j, RotationalDeviceTracker rotationalDeviceTracker, boolean z);

    public static final native long SmartTerrain_SWIGUpcast(long j);

    public static final native long SmartTerrain_getClassType();

    public static final native long SmartTerrain_getHitTestResult(long j, SmartTerrain smartTerrain, int i);

    public static final native int SmartTerrain_getHitTestResultCount(long j, SmartTerrain smartTerrain);

    public static final native void SmartTerrain_hitTest__SWIG_0(long j, SmartTerrain smartTerrain, long j2, State state, long j3, Vec2F vec2F, float f, int i);

    public static final native long SmartTerrain_hitTest__SWIG_1(long j, SmartTerrain smartTerrain, long j2, Vec2F vec2F, int i, long j3, State state, float f);

    public static final native double StateUpdater_getCurrentTimeStamp(long j, StateUpdater stateUpdater);

    public static final native long StateUpdater_getLatestState(long j, StateUpdater stateUpdater);

    public static final native long StateUpdater_updateState(long j, StateUpdater stateUpdater);

    public static final native long State_getCameraCalibration(long j, State state);

    public static final native long State_getDeviceTrackableResult(long j, State state);

    public static final native long State_getFrame(long j, State state);

    public static final native long State_getIllumination(long j, State state);

    public static final native int State_getNumTrackableResults(long j, State state);

    public static final native int State_getNumTrackables(long j, State state);

    public static final native long State_getTrackable(long j, State state, int i);

    public static final native long State_getTrackableResult(long j, State state, int i);

    public static final native long State_getTrackableResults(long j, State state);

    public static final native long TargetFinderQueryResult_results_get(long j, TargetFinderQueryResult targetFinderQueryResult);

    public static final native void TargetFinderQueryResult_results_set(long j, TargetFinderQueryResult targetFinderQueryResult, long j2, TargetSearchResultList targetSearchResultList);

    public static final native int TargetFinderQueryResult_status_get(long j, TargetFinderQueryResult targetFinderQueryResult);

    public static final native void TargetFinderQueryResult_status_set(long j, TargetFinderQueryResult targetFinderQueryResult, int i);

    public static final native void TargetFinder_clearTrackables(long j, TargetFinder targetFinder);

    public static final native boolean TargetFinder_deinit(long j, TargetFinder targetFinder);

    public static final native long TargetFinder_enableTracking(long j, TargetFinder targetFinder, long j2, TargetSearchResult targetSearchResult);

    public static final native long TargetFinder_getImageTarget(long j, TargetFinder targetFinder, int i);

    public static final native int TargetFinder_getInitState(long j, TargetFinder targetFinder);

    public static final native int TargetFinder_getNumImageTargets(long j, TargetFinder targetFinder);

    public static final native long TargetFinder_getObjectTargets(long j, TargetFinder targetFinder);

    public static final native long TargetFinder_getResult(long j, TargetFinder targetFinder, int i);

    public static final native int TargetFinder_getResultCount(long j, TargetFinder targetFinder);

    public static final native boolean TargetFinder_isRequesting(long j, TargetFinder targetFinder);

    public static final native boolean TargetFinder_startInit(long j, TargetFinder targetFinder, String str, String str2);

    public static final native boolean TargetFinder_startRecognition(long j, TargetFinder targetFinder);

    public static final native boolean TargetFinder_stop(long j, TargetFinder targetFinder);

    public static final native long TargetFinder_updateQueryResults__SWIG_0(long j, TargetFinder targetFinder, int i);

    public static final native long TargetFinder_updateQueryResults__SWIG_1(long j, TargetFinder targetFinder);

    public static final native int TargetFinder_updateSearchResults__SWIG_0(long j, TargetFinder targetFinder, int i);

    public static final native int TargetFinder_updateSearchResults__SWIG_1(long j, TargetFinder targetFinder);

    public static final native void TargetFinder_waitUntilInitFinished(long j, TargetFinder targetFinder);

    public static final native long TargetSearchResultList_at(long j, TargetSearchResultList targetSearchResultList, int i);

    public static final native boolean TargetSearchResultList_empty(long j, TargetSearchResultList targetSearchResultList);

    public static final native int TargetSearchResultList_size(long j, TargetSearchResultList targetSearchResultList);

    public static final native String TargetSearchResult_getMetaData(long j, TargetSearchResult targetSearchResult);

    public static final native String TargetSearchResult_getTargetName(long j, TargetSearchResult targetSearchResult);

    public static final native float TargetSearchResult_getTargetSize(long j, TargetSearchResult targetSearchResult);

    public static final native short TargetSearchResult_getTrackingRating(long j, TargetSearchResult targetSearchResult);

    public static final native String TargetSearchResult_getUniqueTargetId(long j, TargetSearchResult targetSearchResult);

    public static final native int TextureData_type(long j, TextureData textureData);

    public static final native int TextureUnit_type(long j, TextureUnit textureUnit);

    public static final native long Tool_convert2GLMatrix(long j, Matrix34F matrix34F);

    public static final native long Tool_convertPerspectiveProjection2GLMatrix(long j, Matrix34F matrix34F, float f, float f2);

    public static final native long Tool_convertPose2GLMatrix(long j, Matrix34F matrix34F);

    public static final native long Tool_getProjectionGL(long j, CameraCalibration cameraCalibration, float f, float f2);

    public static final native long Tool_multiplyGL(long j, Matrix44F matrix44F, long j2, Matrix44F matrix44F2);

    public static final native long Tool_multiply__SWIG_0(long j, Matrix34F matrix34F, long j2, Matrix34F matrix34F2);

    public static final native long Tool_multiply__SWIG_1(long j, Matrix44F matrix44F, long j2, Matrix44F matrix44F2);

    public static final native long Tool_multiply__SWIG_2(long j, Vec4F vec4F, long j2, Matrix44F matrix44F);

    public static final native long Tool_projectPoint(long j, CameraCalibration cameraCalibration, long j2, Matrix34F matrix34F, long j3, Vec3F vec3F);

    public static final native void Tool_setRotation(long j, Matrix34F matrix34F, long j2, Vec3F vec3F, float f);

    public static final native void Tool_setTranslation(long j, Matrix34F matrix34F, long j2, Vec3F vec3F);

    public static final native long TrackableList_at(long j, TrackableList trackableList, int i);

    public static final native boolean TrackableList_empty(long j, TrackableList trackableList);

    public static final native int TrackableList_size(long j, TrackableList trackableList);

    public static final native long TrackableResultList_at(long j, TrackableResultList trackableResultList, int i);

    public static final native boolean TrackableResultList_empty(long j, TrackableResultList trackableResultList);

    public static final native int TrackableResultList_size(long j, TrackableResultList trackableResultList);

    public static final native long TrackableResult_getClassType();

    public static final native long TrackableResult_getPose(long j, TrackableResult trackableResult);

    public static final native int TrackableResult_getStatus(long j, TrackableResult trackableResult);

    public static final native int TrackableResult_getStatusInfo(long j, TrackableResult trackableResult);

    public static final native double TrackableResult_getTimeStamp(long j, TrackableResult trackableResult);

    public static final native long TrackableResult_getTrackable(long j, TrackableResult trackableResult);

    public static final native long TrackableResult_getType(long j, TrackableResult trackableResult);

    public static final native boolean TrackableResult_isOfType(long j, TrackableResult trackableResult, long j2, Type type);

    public static final native long Trackable_getClassType();

    public static final native int Trackable_getId(long j, Trackable trackable);

    public static final native String Trackable_getName(long j, Trackable trackable);

    public static final native long Trackable_getType(long j, Trackable trackable);

    public static final native boolean Trackable_isOfType(long j, Trackable trackable, long j2, Type type);

    public static final native boolean TrackerManager_deinitTracker(long j, TrackerManager trackerManager, long j2, Type type);

    public static final native long TrackerManager_getInstance();

    public static final native long TrackerManager_getStateUpdater(long j, TrackerManager trackerManager);

    public static final native long TrackerManager_getTracker(long j, TrackerManager trackerManager, long j2, Type type);

    public static final native long TrackerManager_initTracker(long j, TrackerManager trackerManager, long j2, Type type);

    public static final native long Tracker_getClassType();

    public static final native long Tracker_getType(long j, Tracker tracker);

    public static final native boolean Tracker_isOfType(long j, Tracker tracker, long j2, Type type);

    public static final native boolean Tracker_start(long j, Tracker tracker);

    public static final native void Tracker_stop(long j, Tracker tracker);

    public static final native int TransformModel_getType(long j, TransformModel transformModel);

    public static final native boolean Type_isOfType(long j, Type type, long j2, Type type2);

    public static final native void UpdateCallback_Vuforia_onUpdate(long j, UpdateCallback updateCallback, long j2, State state);

    public static final native void UpdateCallback_change_ownership(UpdateCallback updateCallback, long j, boolean z);

    public static final native void UpdateCallback_director_connect(UpdateCallback updateCallback, long j, boolean z, boolean z2);

    public static final native float[] Vec2F_data_get(long j, Vec2F vec2F);

    public static final native void Vec2F_data_set(long j, Vec2F vec2F, float[] fArr);

    public static final native int[] Vec2I_data_get(long j, Vec2I vec2I);

    public static final native void Vec2I_data_set(long j, Vec2I vec2I, int[] iArr);

    public static final native float[] Vec3F_data_get(long j, Vec3F vec3F);

    public static final native void Vec3F_data_set(long j, Vec3F vec3F, float[] fArr);

    public static final native int[] Vec3I_data_get(long j, Vec3I vec3I);

    public static final native void Vec3I_data_set(long j, Vec3I vec3I, int[] iArr);

    public static final native float[] Vec4F_data_get(long j, Vec4F vec4F);

    public static final native void Vec4F_data_set(long j, Vec4F vec4F, float[] fArr);

    public static final native int[] Vec4I_data_get(long j, Vec4I vec4I);

    public static final native void Vec4I_data_set(long j, Vec4I vec4I, int[] iArr);

    public static final native long VideoBackgroundConfig_Position_get(long j, VideoBackgroundConfig videoBackgroundConfig);

    public static final native void VideoBackgroundConfig_Position_set(long j, VideoBackgroundConfig videoBackgroundConfig, long j2, Vec2I vec2I);

    public static final native int VideoBackgroundConfig_Reflection_get(long j, VideoBackgroundConfig videoBackgroundConfig);

    public static final native void VideoBackgroundConfig_Reflection_set(long j, VideoBackgroundConfig videoBackgroundConfig, int i);

    public static final native long VideoBackgroundConfig_Size_get(long j, VideoBackgroundConfig videoBackgroundConfig);

    public static final native void VideoBackgroundConfig_Size_set(long j, VideoBackgroundConfig videoBackgroundConfig, long j2, Vec2I vec2I);

    public static final native long VideoBackgroundTextureInfo_ImageSize_get(long j, VideoBackgroundTextureInfo videoBackgroundTextureInfo);

    public static final native int VideoBackgroundTextureInfo_PixelFormat_get(long j, VideoBackgroundTextureInfo videoBackgroundTextureInfo);

    public static final native long VideoBackgroundTextureInfo_TextureSize_get(long j, VideoBackgroundTextureInfo videoBackgroundTextureInfo);

    public static final native float VideoMode_Framerate_get(long j, VideoMode videoMode);

    public static final native int VideoMode_Height_get(long j, VideoMode videoMode);

    public static final native int VideoMode_Width_get(long j, VideoMode videoMode);

    public static final native boolean ViewList_contains(long j, ViewList viewList, int i);

    public static final native long ViewList_getNumViews(long j, ViewList viewList);

    public static final native int ViewList_getView(long j, ViewList viewList, int i);

    public static final native long ViewerParametersList_begin(long j, ViewerParametersList viewerParametersList);

    public static final native long ViewerParametersList_end(long j, ViewerParametersList viewerParametersList);

    public static final native long ViewerParametersList_getListForAuthoringTools();

    public static final native long ViewerParametersList_get__SWIG_0(long j, ViewerParametersList viewerParametersList, long j2);

    public static final native long ViewerParametersList_get__SWIG_1(long j, ViewerParametersList viewerParametersList, String str, String str2);

    public static final native long ViewerParametersList_next(long j, ViewerParametersList viewerParametersList, long j2, ViewerParameters viewerParameters);

    public static final native void ViewerParametersList_setSDKFilter(long j, ViewerParametersList viewerParametersList, String str);

    public static final native long ViewerParametersList_size(long j, ViewerParametersList viewerParametersList);

    public static final native boolean ViewerParameters_containsMagnet(long j, ViewerParameters viewerParameters);

    public static final native int ViewerParameters_getButtonType(long j, ViewerParameters viewerParameters);

    public static final native float ViewerParameters_getDistortionCoefficient(long j, ViewerParameters viewerParameters, int i);

    public static final native long ViewerParameters_getFieldOfView(long j, ViewerParameters viewerParameters);

    public static final native float ViewerParameters_getInterLensDistance(long j, ViewerParameters viewerParameters);

    public static final native float ViewerParameters_getLensCentreToTrayDistance(long j, ViewerParameters viewerParameters);

    public static final native String ViewerParameters_getManufacturer(long j, ViewerParameters viewerParameters);

    public static final native String ViewerParameters_getName(long j, ViewerParameters viewerParameters);

    public static final native long ViewerParameters_getNumDistortionCoefficients(long j, ViewerParameters viewerParameters);

    public static final native float ViewerParameters_getScreenToLensDistance(long j, ViewerParameters viewerParameters);

    public static final native int ViewerParameters_getTrayAlignment(long j, ViewerParameters viewerParameters);

    public static final native float ViewerParameters_getVersion(long j, ViewerParameters viewerParameters);

    public static final native long VirtualButtonList_at(long j, VirtualButtonList virtualButtonList, int i);

    public static final native boolean VirtualButtonList_empty(long j, VirtualButtonList virtualButtonList);

    public static final native int VirtualButtonList_size(long j, VirtualButtonList virtualButtonList);

    public static final native long VirtualButtonResultList_at(long j, VirtualButtonResultList virtualButtonResultList, int i);

    public static final native boolean VirtualButtonResultList_empty(long j, VirtualButtonResultList virtualButtonResultList);

    public static final native int VirtualButtonResultList_size(long j, VirtualButtonResultList virtualButtonResultList);

    public static final native long VirtualButtonResult_getVirtualButton(long j, VirtualButtonResult virtualButtonResult);

    public static final native boolean VirtualButtonResult_isPressed(long j, VirtualButtonResult virtualButtonResult);

    public static final native long VirtualButton_getArea(long j, VirtualButton virtualButton);

    public static final native int VirtualButton_getID(long j, VirtualButton virtualButton);

    public static final native String VirtualButton_getName(long j, VirtualButton virtualButton);

    public static final native boolean VirtualButton_isEnabled(long j, VirtualButton virtualButton);

    public static final native boolean VirtualButton_setArea(long j, VirtualButton virtualButton, long j2, Area area);

    public static final native boolean VirtualButton_setEnabled(long j, VirtualButton virtualButton, boolean z);

    public static final native boolean VirtualButton_setSensitivity(long j, VirtualButton virtualButton, int i);

    public static final native long VuMarkTargetResult_SWIGUpcast(long j);

    public static final native long VuMarkTargetResult_getClassType();

    public static final native int VuMarkTargetResult_getId(long j, VuMarkTargetResult vuMarkTargetResult);

    public static final native long VuMarkTargetResult_getTrackable(long j, VuMarkTargetResult vuMarkTargetResult);

    public static final native long VuMarkTarget_SWIGUpcast(long j);

    public static final native long VuMarkTarget_getClassType();

    public static final native long VuMarkTarget_getInstanceId(long j, VuMarkTarget vuMarkTarget);

    public static final native long VuMarkTarget_getInstanceImage(long j, VuMarkTarget vuMarkTarget);

    public static final native long VuMarkTarget_getTemplate(long j, VuMarkTarget vuMarkTarget);

    public static final native long VuMarkTemplate_SWIGUpcast(long j);

    public static final native long VuMarkTemplate_getClassType();

    public static final native long VuMarkTemplate_getOrigin(long j, VuMarkTemplate vuMarkTemplate);

    public static final native String VuMarkTemplate_getVuMarkUserData(long j, VuMarkTemplate vuMarkTemplate);

    public static final native boolean VuMarkTemplate_isTrackingFromRuntimeAppearanceEnabled(long j, VuMarkTemplate vuMarkTemplate);

    public static final native void VuMarkTemplate_setTrackingFromRuntimeAppearance(long j, VuMarkTemplate vuMarkTemplate, boolean z);

    public static final native void deinit();

    public static final native void delete_Anchor(long j);

    public static final native void delete_AnchorList(long j);

    public static final native void delete_AnchorResult(long j);

    public static final native void delete_Area(long j);

    public static final native void delete_Box3D(long j);

    public static final native void delete_CameraCalibration(long j);

    public static final native void delete_CameraDevice(long j);

    public static final native void delete_CameraField(long j);

    public static final native void delete_CustomViewerParameters(long j);

    public static final native void delete_CylinderTarget(long j);

    public static final native void delete_CylinderTargetResult(long j);

    public static final native void delete_DataSet(long j);

    public static final native void delete_DataSetList(long j);

    public static final native void delete_Device(long j);

    public static final native void delete_DeviceTrackable(long j);

    public static final native void delete_DeviceTrackableResult(long j);

    public static final native void delete_DeviceTracker(long j);

    public static final native void delete_EyewearCalibrationProfileManager(long j);

    public static final native void delete_EyewearCalibrationReading(long j);

    public static final native void delete_EyewearDevice(long j);

    public static final native void delete_EyewearUserCalibrator(long j);

    public static final native void delete_Frame(long j);

    public static final native void delete_GLTextureData(long j);

    public static final native void delete_GLTextureUnit(long j);

    public static final native void delete_GuideView(long j);

    public static final native void delete_GuideViewList(long j);

    public static final native void delete_HandheldTransformModel(long j);

    public static final native void delete_HeadTransformModel(long j);

    public static final native void delete_HitTestResult(long j);

    public static final native void delete_HitTestResultList(long j);

    public static final native void delete_Illumination(long j);

    public static final native void delete_ImageList(long j);

    public static final native void delete_ImageTarget(long j);

    public static final native void delete_ImageTargetResult(long j);

    public static final native void delete_InstanceId(long j);

    public static final native void delete_Matrix34F(long j);

    public static final native void delete_Matrix44F(long j);

    public static final native void delete_Mesh(long j);

    public static final native void delete_ModelTarget(long j);

    public static final native void delete_ModelTargetResult(long j);

    public static final native void delete_MultiTarget(long j);

    public static final native void delete_MultiTargetResult(long j);

    public static final native void delete_Obb2D(long j);

    public static final native void delete_Obb3D(long j);

    public static final native void delete_ObjectTarget(long j);

    public static final native void delete_ObjectTargetList(long j);

    public static final native void delete_ObjectTargetResult(long j);

    public static final native void delete_ObjectTracker(long j);

    public static final native void delete_PositionalDeviceTracker(long j);

    public static final native void delete_Rectangle(long j);

    public static final native void delete_RectangleInt(long j);

    public static final native void delete_Renderer(long j);

    public static final native void delete_RendererHelper(long j);

    public static final native void delete_RenderingPrimitives(long j);

    public static final native void delete_RotationalDeviceTracker(long j);

    public static final native void delete_SmartTerrain(long j);

    public static final native void delete_State(long j);

    public static final native void delete_StateUpdater(long j);

    public static final native void delete_TargetFinder(long j);

    public static final native void delete_TargetFinderQueryResult(long j);

    public static final native void delete_TargetSearchResult(long j);

    public static final native void delete_TargetSearchResultList(long j);

    public static final native void delete_Tool(long j);

    public static final native void delete_Trackable(long j);

    public static final native void delete_TrackableList(long j);

    public static final native void delete_TrackableResult(long j);

    public static final native void delete_TrackableResultList(long j);

    public static final native void delete_TrackableSource(long j);

    public static final native void delete_Tracker(long j);

    public static final native void delete_TrackerManager(long j);

    public static final native void delete_TransformModel(long j);

    public static final native void delete_Type(long j);

    public static final native void delete_UpdateCallback(long j);

    public static final native void delete_Vec2F(long j);

    public static final native void delete_Vec2I(long j);

    public static final native void delete_Vec3F(long j);

    public static final native void delete_Vec3I(long j);

    public static final native void delete_Vec4F(long j);

    public static final native void delete_Vec4I(long j);

    public static final native void delete_VideoBackgroundConfig(long j);

    public static final native void delete_VideoBackgroundTextureInfo(long j);

    public static final native void delete_VideoMode(long j);

    public static final native void delete_ViewList(long j);

    public static final native void delete_ViewerParameters(long j);

    public static final native void delete_ViewerParametersList(long j);

    public static final native void delete_VirtualButtonList(long j);

    public static final native void delete_VirtualButtonResultList(long j);

    public static final native void delete_VuMarkTarget(long j);

    public static final native void delete_VuMarkTargetResult(long j);

    public static final native void delete_VuMarkTemplate(long j);

    public static final native int getActiveFusionProvider();

    public static final native int getBitsPerPixel(int i);

    public static final native int getBufferSize(int i, int i2, int i3);

    public static final native String getLibraryVersion();

    public static final native int init();

    public static final native boolean isInitialized();

    public static final native long new_AnchorList(long j, AnchorList anchorList);

    public static final native long new_Box3D__SWIG_0();

    public static final native long new_Box3D__SWIG_1(long j, Box3D box3D);

    public static final native long new_Box3D__SWIG_2(long j, Vec3F vec3F, long j2, Vec3F vec3F2);

    public static final native long new_CameraField();

    public static final native long new_CustomViewerParameters__SWIG_0(float f, String str, String str2);

    public static final native long new_CustomViewerParameters__SWIG_1(long j, CustomViewerParameters customViewerParameters);

    public static final native long new_DataSetList(long j, DataSetList dataSetList);

    public static final native long new_EyewearCalibrationReading();

    public static final native long new_Frame__SWIG_0();

    public static final native long new_Frame__SWIG_1(long j, Frame frame);

    public static final native long new_GLTextureData__SWIG_0(int i);

    public static final native long new_GLTextureData__SWIG_1();

    public static final native long new_GLTextureUnit__SWIG_0(int i);

    public static final native long new_GLTextureUnit__SWIG_1();

    public static final native long new_GuideViewList(long j, GuideViewList guideViewList);

    public static final native long new_HandheldTransformModel__SWIG_0();

    public static final native long new_HandheldTransformModel__SWIG_1(long j, HandheldTransformModel handheldTransformModel);

    public static final native long new_HandheldTransformModel__SWIG_2(long j, Vec3F vec3F);

    public static final native long new_HeadTransformModel__SWIG_0();

    public static final native long new_HeadTransformModel__SWIG_1(long j, HeadTransformModel headTransformModel);

    public static final native long new_HeadTransformModel__SWIG_2(long j, Vec3F vec3F);

    public static final native long new_HitTestResultList(long j, HitTestResultList hitTestResultList);

    public static final native long new_ImageList(long j, ImageList imageList);

    public static final native long new_Matrix34F__SWIG_0();

    public static final native long new_Matrix34F__SWIG_1(long j, Matrix34F matrix34F);

    public static final native long new_Matrix44F__SWIG_0();

    public static final native long new_Matrix44F__SWIG_1(long j, Matrix44F matrix44F);

    public static final native long new_Obb2D__SWIG_0();

    public static final native long new_Obb2D__SWIG_1(long j, Obb2D obb2D);

    public static final native long new_Obb2D__SWIG_2(long j, Vec2F vec2F, long j2, Vec2F vec2F2, float f);

    public static final native long new_Obb3D__SWIG_0();

    public static final native long new_Obb3D__SWIG_1(long j, Obb3D obb3D);

    public static final native long new_Obb3D__SWIG_2(long j, Vec3F vec3F, long j2, Vec3F vec3F2, float f);

    public static final native long new_ObjectTargetList(long j, ObjectTargetList objectTargetList);

    public static final native long new_RectangleInt__SWIG_0();

    public static final native long new_RectangleInt__SWIG_1(long j, RectangleInt rectangleInt);

    public static final native long new_RectangleInt__SWIG_2(int i, int i2, int i3, int i4);

    public static final native long new_Rectangle__SWIG_0();

    public static final native long new_Rectangle__SWIG_1(long j, Rectangle rectangle);

    public static final native long new_Rectangle__SWIG_2(float f, float f2, float f3, float f4);

    public static final native long new_RendererHelper();

    public static final native long new_RenderingPrimitives(long j, RenderingPrimitives renderingPrimitives);

    public static final native long new_State__SWIG_0();

    public static final native long new_State__SWIG_1(long j, State state);

    public static final native long new_TargetSearchResultList(long j, TargetSearchResultList targetSearchResultList);

    public static final native long new_Tool();

    public static final native long new_TrackableList(long j, TrackableList trackableList);

    public static final native long new_TrackableResultList(long j, TrackableResultList trackableResultList);

    public static final native long new_TrackableSource();

    public static final native long new_Type__SWIG_0();

    public static final native long new_Type__SWIG_1(short s);

    public static final native long new_UpdateCallback();

    public static final native long new_Vec2F__SWIG_0();

    public static final native long new_Vec2F__SWIG_1(float[] fArr);

    public static final native long new_Vec2F__SWIG_2(float f, float f2);

    public static final native long new_Vec2F__SWIG_3(long j, Vec2F vec2F);

    public static final native long new_Vec2I__SWIG_0();

    public static final native long new_Vec2I__SWIG_1(int[] iArr);

    public static final native long new_Vec2I__SWIG_2(int i, int i2);

    public static final native long new_Vec2I__SWIG_3(long j, Vec2I vec2I);

    public static final native long new_Vec3F__SWIG_0();

    public static final native long new_Vec3F__SWIG_1(float[] fArr);

    public static final native long new_Vec3F__SWIG_2(float f, float f2, float f3);

    public static final native long new_Vec3F__SWIG_3(long j, Vec3F vec3F);

    public static final native long new_Vec3I__SWIG_0();

    public static final native long new_Vec3I__SWIG_1(int[] iArr);

    public static final native long new_Vec4F__SWIG_0();

    public static final native long new_Vec4F__SWIG_1(float[] fArr);

    public static final native long new_Vec4F__SWIG_2(float f, float f2, float f3, float f4);

    public static final native long new_Vec4F__SWIG_3(long j, Vec4F vec4F);

    public static final native long new_Vec4I__SWIG_0();

    public static final native long new_Vec4I__SWIG_1(int[] iArr);

    public static final native long new_VideoBackgroundConfig();

    public static final native long new_VideoBackgroundTextureInfo();

    public static final native long new_VideoMode__SWIG_0();

    public static final native long new_VideoMode__SWIG_1(long j, VideoMode videoMode);

    public static final native long new_ViewerParameters(long j, ViewerParameters viewerParameters);

    public static final native long new_VirtualButtonList(long j, VirtualButtonList virtualButtonList);

    public static final native long new_VirtualButtonResultList(long j, VirtualButtonResultList virtualButtonResultList);

    public static final native void onPause();

    public static final native void onResume();

    public static final native void onSurfaceChanged(int i, int i2);

    public static final native void onSurfaceCreated();

    public static final native void registerCallback(long j, UpdateCallback updateCallback);

    public static final native boolean requiresAlpha();

    public static final native int setAllowedFusionProviders(int i);

    public static final native boolean setDriverLibrary(String str);

    public static final native boolean setFrameFormat(int i, boolean z);

    public static final native boolean setHint(long j, int i);

    private static final native void swig_module_init();

    VuforiaJNI() {
    }

    public static void SwigDirector_UpdateCallback_Vuforia_onUpdate(UpdateCallback updateCallback, long j) {
        updateCallback.Vuforia_onUpdate(new State(j, false));
    }

    static {
        swig_module_init();
    }
}
