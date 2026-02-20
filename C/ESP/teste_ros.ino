#include <ros.h>
#include <std_msgs/String.h>
#include <string.h>

#define LED 2
#define BAUD_RATE 115200

ros::NodeHandle nh;

//Atualiza a cor de acordo com o que foi detectado pela camera
void cor_callback(const std_msgs::String& cor_detectada){
  if(strcmp(cor_detectada.data,"Blue")==0) {
    digitalWrite(LED, HIGH);
  } else if(strcmp(cor_detectada.data,"Green")==0) {
    digitalWrite(LED, LOW);
  }
}

ros::Subscriber<std_msgs::String> sub_cor("cor_detectada", &cor_callback);

void setup()
{
  Serial.begin(BAUD_RATE);
  nh.getHardware()->setPort(&Serial);
  nh.getHardware()->setBaud(BAUD_RATE);
  //inicializa nó da esp
  delay(1000);
  nh.initNode();
  nh.subscribe(sub_cor);
  //inicializa componentes
  pinMode(LED,OUTPUT);
  //Aguarda até o ROS conectar, se ainda não estiver conectado
  while (!nh.connected()) {
    nh.loginfo("Tentando conectar com o ROS...");
    nh.spinOnce();   // tenta sincronizar
    delay(1);
  }
  nh.loginfo("ROS conectado!");
}

void loop(){
  nh.spinOnce();
  delay(1);
}
