#!/usr/bin/env python3
import rclpy
from rclpy.node import Node
from std_msgs.msg import Int32
import cv2
import numpy as np

'''
Reconhece a cor do pixel central da câmera e publica no tópico /color como Int32
0 = Outra
1 = Vermelho
2 = Verde
3 = Azul
'''

# Definição da classe cor e das instâncias de cores que serão detectadas
class Color:
    def __init__(self, code, name, lower, upper):
        self.code = code
        self.name = name
        self.lower = lower
        self.upper = upper
# Vermelho
red1    = Color(1, "Red",              np.array([0, 50, 50]),      np.array([10, 255, 255]))
red2    = Color(1, "Red",              np.array([170, 50, 50]),    np.array([180, 255, 255]))
# Verde
green        = Color(2, "Green",       np.array([35, 50, 50]),     np.array([65, 255, 255]))
light_green  = Color(2, "Green",       np.array([50, 30, 150]),    np.array([65, 150, 255]))
# Azul
cyan       = Color(3, "Blue",          np.array([65, 50, 50]),     np.array([85, 255, 255]))
light_blue = Color(3, "Blue",          np.array([85, 50, 150]),    np.array([100, 150, 255]))
blue       = Color(3, "Blue",          np.array([100, 50, 50]),    np.array([130, 255, 255]))
# Lista de cores a serem detectadas
colors_list = [red1, red2, green, light_green, cyan, light_blue, blue]

# Nó de reconhecimento de cores
class ColorPublisherNode(Node):

    def __init__(self):
        super().__init__("color_publisher")
        self.publisher_ =  self.create_publisher(Int32, "color", 10)
        self.timer_ = self.create_timer(0.5, self.publish_color)
        self.cap_ = cv2.VideoCapture(0)
        if not self.cap_.isOpened() or self.cap_ is None:
            self.get_logger().error("Error while opening the video capture.")
        else:
            self.get_logger().info("The video capture has been successfully opened.")

        self.get_logger().info("Color Publisher node has been initialized.")

    def publish_color(self):
        ret, frame = self.cap_.read()
        if not ret:
            return
        msg = Int32()
        msg.data = 0
        # Reconhece a cor do pixel central utilizando máscaras do openCV
        height, width, _ = frame.shape
        hsv = cv2.cvtColor(frame, cv2.COLOR_BGR2HSV)
        for color in colors_list:
            mask = cv2.inRange(hsv, color.lower, color.upper)
            if mask[height // 2][width // 2] == 255:
                # Se a cor for encontrada, publica o código dela (Int32)
                msg.data = color.code
                self.get_logger().info(f"Color detected: {color.name}")
                break
        self.publisher_.publish(msg)

def main(args=None):
    rclpy.init(args=args)
    node = ColorPublisherNode()
    rclpy.spin(node)
    rclpy.shutdown()
    node.cap_.release()


if __name__=='__main__':
    main()