# V1

En esta versión se se propone una solución al problema ilustrado en la V0
deben estudiar la estructura y proponer mejoras al aplicativo 

## Sender 

contiene el aplicativo que permite leer la canción y enviarla a un cliente
Compilar y ejecutar MusicSender.java
debe configurar la ip del servidor, debe poder probarlo con localhost

## Receiver

Contiene el aplicativo que permite establecer la solicitud al servidor y empezar a recibir la canción
Compilar y ejecutar MusicReceiver.java
debe configurar la ip del servidor

## Explicación del funcionamiento del código: 

1. **MusicReceiver.java**:
   - Establece la conexión con el servidor.
   - Configura el reproductor de audio.
   - Envía una solicitud al servidor para que inicie el envío de la canción.
   - Recibe los paquetes de audio del servidor y los pasa al reproductor de audio.

2. **PlayerThread.java**:
   - Administra una cola de bytes para almacenar los paquetes de audio recibidos.
   - Lee continuamente la cola y escribe los bytes en la tarjeta de audio.

3. **MusicSender.java**:
   - Espera la solicitud de conexión del cliente.
   - Inicia un objeto `PlayerSender` para enviar la canción al cliente.

4. **PlayerSender.java**:
   - Lee la canción del archivo especificado.
   - Divide la canción en paquetes de bytes y los envía al cliente a través de datagramas.
   - Cada paquete de datos contiene un identificador de paquete para su ordenación.

Descripción del flujo de ejecución del código:

- El cliente de recepción de música (`MusicReceiver.java`) se ejecuta primero después de establecer la conexión con el servidor.
- Se establece una conexión con el servidor (`MusicSender.java`).
- Se configura el reproductor de audio y se inicia un hilo para reproducir el audio entrante (`PlayerThread.java`).
- Se envía una solicitud al servidor para iniciar el envío de la canción (`MusicReceiver.java`).
- El servidor recibe la solicitud, prepara la canción para ser enviada y espera la conexión del cliente.
- El cliente de envío de música (`MusicSender.java`) se ejecuta y espera la solicitud de conexión del cliente.
- Cuando el cliente se conecta, el cliente de envío envía la canción al cliente utilizando la clase `PlayerSender.java`.
- El cliente de recepción de música (`MusicReceiver.java`) recibe los paquetes de audio y los pasa al reproductor de audio.
- El reproductor de audio reproduce continuamente los paquetes recibidos.

## Explicación del código


### MusicReceiver.java:
- Este archivo contiene la clase principal `MusicReceiver`.
- En el método `main`, se establece una conexión con el servidor utilizando un socket Datagram.
- Se configura el reproductor de audio utilizando un formato específico.
- Se inicia un hilo (`PlayerThread`) para reproducir el audio recibido.
- Se envía una solicitud al servidor para iniciar el envío de la canción.
- Se recibe la canción en paquetes UDP y se pasa al hilo del reproductor de audio para ser reproducida.

### PlayerThread.java:
- Esta clase es un hilo que administra una cola de bytes para almacenar los paquetes de audio recibidos.
- En el constructor, se inicializa la cola de bytes y se configura y se inicia la línea de datos de audio.
- El método `addBytes` permite agregar bytes a la cola de reproducción.
- El método `run` se ejecuta continuamente, leyendo bytes de la cola y escribiéndolos en la línea de datos de audio para su reproducción.

### MusicSender.java:
- Este archivo contiene la clase principal `MusicSender`.
- En el método `main`, se espera la solicitud de conexión del cliente.
- Cuando se recibe una solicitud de conexión, se crea un objeto `PlayerSender` para enviar la canción al cliente.

### PlayerSender.java:
- Esta clase se encarga de enviar la canción al cliente.
- En el constructor, se inicializan la ruta del archivo de la canción, la dirección IP y el puerto del cliente, así como el socket.
- El método `sendAudio` lee la canción del archivo especificado y la envía al cliente en paquetes UDP.
- Los paquetes de datos contienen un identificador de paquete para su ordenación.
- El método `sendPacket` arma el datagrama con los datos de audio y lo envía al cliente a través del socket.

## Posibles mejoras 

### Modularización y Abstracción:

1. **División de Responsabilidades**:

   - **Problema Actual**: La lógica de comunicación de red y la lógica de reproducción de audio están entrelazadas en las clases `MusicReceiver` y `MusicSender`.
   - **Cambio Propuesto**: Separar la lógica de comunicación de red en una clase aparte, `NetworkManager`.

   ```java
   // Cambio Propuesto
   // Crear una clase separada para la gestión de la red
   public class NetworkManager {
       // Métodos para enviar y recibir datos
       public void sendPacket(DatagramPacket packet) {
           // Lógica para enviar un paquete
       }
       public DatagramPacket receivePacket() {
           // Lógica para recibir un paquete
           return null;
       }
   }
   ```

2. **Abstracción de la Lógica de Red**:

   - **Problema Actual**: La lógica específica de envío y recepción de datos se implementa directamente en `MusicReceiver` y `MusicSender`.
   - **Cambio Propuesto**: Introducir una interfaz `NetworkHandler` para abstraer la lógica de red.

   ```java
   // Cambio Propuesto
   // Definir una interfaz para la gestión de la red
   public interface NetworkHandler {
       void sendPacket(byte[] data, InetAddress address, int port);
       byte[] receivePacket();
   }
   ```

### Mejoras en la Eficiencia:

1. **Optimización del Tamaño del Búfer**:

   - **Problema Actual**: El tamaño del búfer (`BUFFER_SIZE`) se fija en 1024 bytes, lo cual puede no ser óptimo para todas las situaciones.
   - **Cambio Propuesto**: Ajustar dinámicamente el tamaño del búfer en función de los requisitos de la aplicación.

   ```java
   // Cambio Propuesto
   // Tamaño del búfer ajustable
   int BUFFER_SIZE = calculateOptimalBufferSize();
   ```

2. **Manejo Eficiente de la Cola de Bytes**:

   - **Problema Actual**: Se utiliza una implementación de `BlockingQueue` en `PlayerThread`, lo cual puede no ser la opción más eficiente.
   - **Cambio Propuesto**: Cambiar a una implementación más eficiente como `ConcurrentLinkedQueue`.

   ```java
   // Cambio Propuesto
   // Utilizar ConcurrentLinkedQueue para una gestión más eficiente de la cola de bytes
   ConcurrentLinkedQueue<byte[]> buffer = new ConcurrentLinkedQueue<>();
   ```

Estos cambios ayudarán a mejorar la modularización, abstracción y eficiencia del código, haciendo que sea más fácil de mantener y escalar en el futuro.