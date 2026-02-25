'''
Detector de gestos com mediapipe
'''


import mediapipe as mp
from mediapipe.tasks.python import vision
import cv2
import time
import numpy as np
from math import acos, degrees


def draw_hand_landmarks(hand_landmarks, frame, landmarks_color=(0, 255, 0), connections_color=(255, 0, 0)):
    h, w, _ = frame.shape
    for landmark in hand_landmarks:
        x = int(landmark.x * w)
        y = int(landmark.y * h)
        cv2.circle(frame, (x, y), 5, landmarks_color, -1)

    for connection in vision.HandLandmarksConnections.HAND_CONNECTIONS:
        start_idx = connection.start
        end_idx = connection.end

        x0 = int(hand_landmarks[start_idx].x * w)
        y0 = int(hand_landmarks[start_idx].y * h)
        x1 = int(hand_landmarks[end_idx].x * w)
        y1 = int(hand_landmarks[end_idx].y * h)
        
        cv2.line(frame, (x0, y0), (x1, y1), connections_color, 2)

def main():
    cap = cv2.VideoCapture(0)

    options = vision.HandLandmarkerOptions(
        base_options=mp.tasks.BaseOptions(model_asset_path='hand_landmarker.task'),
        running_mode=vision.RunningMode.VIDEO
    )

    up_vector = np.array([0,-1])
    right_vector = np.array([1,0])

    with vision.HandLandmarker.create_from_options(options) as detector:

        while True:
            ret, frame = cap.read()
            if not ret:
                break

            h, w, _ = frame.shape
            rgb_frame = cv2.cvtColor(frame, cv2.COLOR_BGR2RGB)
            mp_image = mp.Image(image_format=mp.ImageFormat.SRGB, data=rgb_frame)
            timestamp_ms = int(time.time() * 1000)
            result = detector.detect_for_video(mp_image, timestamp_ms)

            if result.hand_landmarks:
                
                hand_coordinates = []

                for hand_landmarks in result.hand_landmarks:
                    # Detecta se é mão esquerda ou direita
                    handedness = result.handedness[0][0].category_name
                    if handedness == 'Left':
                        break

                    # Desenhar os pontos e conexoes na imagem da camera
                    draw_hand_landmarks(hand_landmarks, frame)

                    # Armazenar coordenadas de todos os pontos da mao
                    for i in range(21):
                        x = int(hand_landmarks[i].x * w)
                        y = int(hand_landmarks[i].y * h)
                        hand_coordinates.append([x,y])

                    # Verificar se o polegar esta extendido

                    p1 = np.array(hand_coordinates[1])
                    p2 = np.array(hand_coordinates[2])
                    p3 = np.array(hand_coordinates[4])
                    
                    l1 = np.linalg.norm(p2 - p3)
                    l2 = np.linalg.norm(p1 - p3)
                    l3 = np.linalg.norm(p1 - p2)

                    if l1 != 0 and l3 != 0:
                        cos_angle = (l1**2 + l3**2 - l2**2) / (2*l1*l3)
                        cos_angle = np.clip(cos_angle, -1.0, 1.0)
                        angle = degrees(acos(cos_angle))
                    else:
                        angle = 0
                    
                    is_thumb_extended = angle > 150

                    # Verificar direcao do polegar (cima ou baixo)
                    coordinates_thumb_fingerbase = np.array(hand_coordinates[2])
                    coordinates_thumb_fingertip = np.array(hand_coordinates[4])

                    thumb_vector = coordinates_thumb_fingertip - coordinates_thumb_fingerbase
                    thumb_vector = thumb_vector / np.linalg.norm(thumb_vector)

                    thumb_vertical_alignment = np.dot(thumb_vector, up_vector)
                    is_thumb_up = thumb_vertical_alignment > 0.7
                    is_thumb_down = thumb_vertical_alignment < -0.7

                    # Verificar se os dedos indicador, medio, anular e mindinho estao extendidos
                    
                    fingertips_coordinates = [hand_coordinates[8], hand_coordinates[12], hand_coordinates[16], hand_coordinates[20]]
                    fingertips_coordinates = np.array(fingertips_coordinates)

                    fingerbases_coordinates = [hand_coordinates[6], hand_coordinates[10], hand_coordinates[14], hand_coordinates[18]]
                    fingerbases_coordinates = np.array(fingerbases_coordinates)

                    distance_fingertips_palmBase = np.linalg.norm(hand_coordinates[0] - fingertips_coordinates, axis=1)
                    distance_fingerbases_palmBase = np.linalg.norm(hand_coordinates[0] - fingerbases_coordinates, axis=1)

                    difference = distance_fingertips_palmBase - distance_fingerbases_palmBase
                    
                    fingers_extended = difference > 0
                    
                    is_index_extended = fingers_extended[0]
                    is_middle_extended = fingers_extended[1]
                    is_ring_extended = fingers_extended[2]
                    is_pinky_extended = fingers_extended[3]

                    # Verificar direcao do dedo indicador (cima ou baixo)
                    coordinates_index_fingerbase = np.array(hand_coordinates[6])
                    coordinates_index_fingertip = np.array(hand_coordinates[8])

                    index_vector = coordinates_index_fingertip - coordinates_index_fingerbase
                    index_vector = index_vector / np.linalg.norm(index_vector)

                    index_vertical_alignment = np.dot(index_vector, up_vector)
                    is_index_up = index_vertical_alignment > 0.7
                    is_index_down = index_vertical_alignment < -0.7
                    
                    # ------- DETECÇÃO DE GESTOS -------
                    current_hand_gesture = None
                
                    # Ok
                    coordinates_index_fingertip = np.array(hand_coordinates[8])
                    d_thummbft_indexft = np.linalg.norm(coordinates_thumb_fingertip - coordinates_index_fingertip)
                    
                    if (d_thummbft_indexft < 40) and is_middle_extended and is_ring_extended and is_pinky_extended:
                        current_hand_gesture = "Ok"

                    # Hi-Five
                    elif is_thumb_extended and is_index_extended and is_middle_extended and is_ring_extended and is_pinky_extended:                  
                        current_hand_gesture = "Hi-Five"

                    # Hang-Loose
                    elif is_thumb_extended and not is_index_extended and not is_middle_extended and not is_ring_extended and is_pinky_extended:
                        current_hand_gesture = "Hang-Loose"
                    
                    # Peace
                    elif not is_thumb_extended and is_index_extended and is_middle_extended and not is_ring_extended and not is_pinky_extended:
                        current_hand_gesture = "Peace"

                    # Rock
                    elif is_thumb_extended and is_index_extended and not is_middle_extended and not is_ring_extended and is_pinky_extended:
                        current_hand_gesture = "Rock"
                    
                    # Middle finger
                    elif not is_index_extended and is_middle_extended and not is_ring_extended and not is_pinky_extended:
                        current_hand_gesture = "Middle Finger"

                    # Thumbs Up
                    elif is_thumb_up and not is_index_up and not is_index_down and is_thumb_extended and not is_index_extended and not is_middle_extended and not is_ring_extended and not is_pinky_extended:
                        current_hand_gesture = "Thumbs Up"

                    # Thumbs Down
                    elif is_thumb_down and not is_index_up and not is_index_down and is_thumb_extended and not is_index_extended and not is_middle_extended and not is_ring_extended and not is_pinky_extended:
                        current_hand_gesture = "Thumbs Down"
                    
                    # Printa o resultado
                    if current_hand_gesture is not None:
                        print(current_hand_gesture)
                    

            frame = cv2.flip(frame, 1)
            cv2.imshow("Hand Tracking", frame)

            if cv2.waitKey(1) == ord('q'):
                break

    cap.release()
    cv2.destroyAllWindows()

if __name__ == '__main__':
    main()
