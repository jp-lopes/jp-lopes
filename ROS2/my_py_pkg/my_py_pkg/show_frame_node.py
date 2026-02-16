#!/usr/bin/env python3
import rclpy
from rclpy.node import Node

import cv2
from sensor_msgs.msg import Image # interface para publicar o frame da camera (msg)
from cv_bridge import CvBridge # ponte para transformar a imagem do OpenCV na msg de imagem


class ShowFrameNode(Node):

    def __init__(self):
        super().__init__("show_frame")
        self.subscriber_ = self.create_subscription(Image, "frame", self.show_frame, 10)
        self.bridge_ = CvBridge()
        self.get_logger().info("Show frame node has been initialized.")

    def show_frame(self, msg):
        try:
            frame = self.bridge_.imgmsg_to_cv2(msg)
            frame = cv2.flip(frame,1)
            cv2.imshow("FRAME",frame)
            cv2.waitKey(1)
        except Exception as e:
            self.get_logger().error("Error while showing the image")
            pass



def main(args=None):
    rclpy.init(args=args)
    node = ShowFrameNode()
    rclpy.spin(node)
    rclpy.shutdown()
    cv2.destroyAllWindows()


if __name__=='__main__':
    main()