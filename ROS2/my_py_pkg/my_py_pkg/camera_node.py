#!/usr/bin/env python3
import rclpy
from rclpy.node import Node

import cv2
from sensor_msgs.msg import Image # interface para publicar o frame da camera (msg)
from cv_bridge import CvBridge # ponte para transformar a imagem do OpenCV na msg de imagem


class CameraNode(Node):

    def __init__(self):
        super().__init__("camera_node")
        self.publisher_ =  self.create_publisher(Image, "frame", 10)
        self.timer_ = self.create_timer((1/30), self.publish_frame)
        self.cap_ = cv2.VideoCapture(0)
        if not self.cap_.isOpened() or self.cap_ is None:
            self.get_logger().error("Error while opening the video capture.")
        else:
            self.get_logger().info("The video capture has been successfully opened.")

        self.bridge_ = CvBridge()
        self.get_logger().info("Camera node has been initialized.")

    def publish_frame(self):
        ret, frame = self.cap_.read()
        if not ret:
            return
        msg = self.bridge_.cv2_to_imgmsg(frame)
        self.publisher_.publish(msg)


def main(args=None):
    rclpy.init(args=args)
    node = CameraNode()
    rclpy.spin(node)
    rclpy.shutdown()
    node.cap_.release()


if __name__=='__main__':
    main()