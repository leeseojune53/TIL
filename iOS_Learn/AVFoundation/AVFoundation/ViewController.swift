//
//  ViewController.swift
//  AVFoundation
//
//  Created by 이서준 on 2022/03/15.
//

import UIKit
import AVFoundation

class ViewController: UIViewController {
    
    let camera = Camera()
    
    func checkCameraPermission(){
           AVCaptureDevice.requestAccess(for: .video, completionHandler: { (granted: Bool) in
               if granted {
                   print("Camera: 권한 허용")
               } else {
                   print("Camera: 권한 거부")
               }
           })
        }

    override func viewDidLoad() {
        super.viewDidLoad()
        checkCameraPermission()
        camera.setupSession()
        let previewLayer = AVCaptureVideoPreviewLayer(session: camera.captureSession)
        previewLayer.videoGravity = .resizeAspectFill
        previewLayer.bounds = CGRect(x: 0, y: 0, width: 100, height: 100)
        previewLayer.frame = view.frame
        view.layer.addSublayer(previewLayer)
        previewLayer.position = CGPoint(x: self.view.bounds.midX, y: self.view.bounds.midY)
        self.view.layer.insertSublayer(previewLayer, at: 0)
        camera.captureSession.startRunning()
    }


}

