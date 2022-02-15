# Rabbit Example
## Descripcion

Se va a dessarrollar un sistema que cuando recibe 
euna petición HTTP de registro envía un mensaje a RabbitMQ, 
el cual desencadena el envío de un email y de un sms.


## Implementacion

Para llevar a cabo ste programa usaremos un fanout exchange **(register_exchange)**
que tendrá dos colas asociadas: **register_email_queue** y register_sms_queue.
