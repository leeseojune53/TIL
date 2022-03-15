//
//  Camera.swift
//  AVFoundationExample
//
//  Created by 이서준 on 2022/03/15.
//

import Foundation
import AVFoundation

class Camera {
    
    var captureSession: AVCaptureSession
    
    init() {
        captureSession = AVCaptureSession()
        captureSession.sessionPreset = .high
    }
    
    func bestDevice(in position: AVCaptureDevice.Position) -> AVCaptureDevice {
        var deviceTypes: [AVCaptureDevice.DeviceType]!
        if #available(iOS 11.1, *) {
            deviceTypes = [.builtInTrueDepthCamera, .builtInDualCamera, .builtInWideAngleCamera]
            
        } else {
            deviceTypes = [.builtInDualCamera, .builtInWideAngleCamera] }
        let discoverySession = AVCaptureDevice.DiscoverySession( deviceTypes: deviceTypes, mediaType: .video, position: .unspecified )
        let devices = discoverySession.devices
        print("asdf")
        guard !devices.isEmpty else { fatalError("Missing capture devices.!")}
        
        return devices.first(where: { device in device.position == position })!
        
    }
    
    func setupSession() {
        do {
            captureSession.beginConfiguration() // 1 // 2
            let videoInput = try AVCaptureDeviceInput(device: bestDevice(in: .back))
            if captureSession.canAddInput(videoInput) {
                captureSession.addInput(videoInput)
                
            } // 3
            let audioDevice = AVCaptureDevice.default(for: AVMediaType.audio)!
            let audioInput = try AVCaptureDeviceInput(device: audioDevice)
            if captureSession.canAddInput(audioInput) {
                
                captureSession.addInput(audioInput)
                
            } // 4
            
            let videoOutput = AVCaptureMovieFileOutput()
            
            if captureSession.canAddOutput(videoOutput) {
                captureSession.addOutput(videoOutput)
                
            }
            
            captureSession.commitConfiguration() // 5
            
        } catch let error as NSError { NSLog("\(error), \(error.localizedDescription)") }
        
    }
    
    func checkCameraPermission(){
           AVCaptureDevice.requestAccess(for: .video, completionHandler: { (granted: Bool) in
               if granted {
                   print("Camera: 권한 허용")
               } else {
                   print("Camera: 권한 거부")
               }
           })
        }
    
}
