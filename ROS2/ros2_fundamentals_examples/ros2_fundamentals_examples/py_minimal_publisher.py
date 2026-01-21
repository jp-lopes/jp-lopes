#! /usr/bin/env python3

"""

https://youtu.be/jsVEhmXSTgc?si=KM3OkipazmLq2j8B

Nó de ROS 2 que publica periodicamente a string "Hello World" em um tópico

Tópicos nos quais esse nó publica:
    Tópico onde a string "Hello World" é publicada
    /py_example_topic - std_msgs/String

Tópicos nos quais esse nó é inscrito:
    Nenhum

"""

import rclpy # Importa biblioteca de ROS 2 para python
from rclpy.node import Node # Importa a classe Node, usada para criar nós
from std_msgs.msg import String # Importa o tipo de mensagem String para ROS 2

class MinimalPythonPublisher(Node):
    # Inicializa nó e variáveis
    def __init__(self):
        # Inicializa o nó com o nome
        super().__init__('minimal_py_publisher')
        # Cria um publisher no tópico com queue size de 10 mensagens
        self.publisher_1 = self.create_publisher(String,'py_example_topic',10)
        # Cria um timer com um període de 0.5 segundos para acionar a publicação de uma mensagem
        timer_period = 0.5
        self.timer = self.create_timer(timer_period, self.timer_callback)
        # Cria uma variável para contar as mensagens publicadas
        self.i = 0

    # Função callback executada periódicamente
    def timer_callback(self):
        # Cria objeto de mensagem do tipo String vazia
        msg = String()
        # Cria a mensagem com o contador
        msg.data = f"Hello World: {self.i}"
        # Publica a mensagem criada em um tópico
        self.publisher_1.publish(msg)
        # Mensagem no terminal (log) informando que a mensagem foi publicada
        self.get_logger().info(f"Publicando: \"{msg.data}\"")
        # Incrementa contador
        self.i += 1


# Funcão principal para iniciar nó de ROS 2
def main(args=None):
    # Inicia comunicação com ROS 2
    rclpy.init(args=args)
    # Cria instância de MinimalPythonPublisher
    minimal_py_publisher = MinimalPythonPublisher()
    # Mantém o nó rodando até CTRL+C 
    rclpy.spin(minimal_py_publisher)
    # Destrói o nó explicitamente
    minimal_py_publisher.destroy_node()
    # Finaliza comunicação com ROS 2
    rclpy.shutdown()

if __name__ == '__main__':
    # Executa função main se o script for executado diretamente
    main()