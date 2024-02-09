
<a name="gjdgxs"></a>**GUÍA DE ESTUDIO**

Martín Gómez Caicedo

**MEDIOS DE TRANSMISIÓN**

1. ¿Cómo está construido un cable coaxial? ¿Por cuál razón se emplea ese tipo de construcción?

**Cable coaxial:**

- Construcción: Un cable coaxial está formado por un conductor central, generalmente de cobre, rodeado por un material dieléctrico y una malla metálica o lámina conductora que actúa como la segunda línea de transmisión. Finalmente, todo está cubierto por una cubierta exterior aislante.

- Razón de empleo:  Se emplea esta construcción para evitar interferencias electromagnéticas y para permitir la transmisión de señales de alta frecuencia con mínima pérdida de señal.

1. Mencione dos ventajas y dos desventajas del cable coaxial.

**Ventajas y desventajas del cable coaxial:**

Ventajas:

- Buen rendimiento en largas distancias.

- Mayor inmunidad a interferencias electromagnéticas en comparación con otros tipos de cables.

Desventajas:

- Costo más alto que el cable de par trenzado.

- Mayor dificultad en la instalación y mantenimiento.


1. ¿Cuál es la diferencia fundamental entre los cables UTP, STP y ScTP?

**Diferencia entre UTP, STP y ScTP:**

La diferencia principal radica en el nivel de protección contra interferencias electromagnéticas:

- UTP (Unshielded Twisted Pair): No tiene blindaje.
- STP (Shielded Twisted Pair): Tiene una capa de blindaje que envuelve los pares de cables.
- ScTP (Screened Twisted Pair): Tiene blindaje individual para cada par de cables.

1. ¿Cuántos pares de alambres trenzados tiene un cable UTP? ¿Para qué se trenzan?

- Pares de alambres trenzados: Un cable UTP tiene 4 pares de alambres trenzados.

- Trenzado: Se trenzan los cables para reducir la interferencia electromagnética entre los pares y mejorar la integridad de la señal.

1. ¿Qué tipo de conector se emplea en los cables UTP?

**Conector empleado en cables UTP**: El conector más comúnmente utilizado en los cables UTP es el conector RJ-45.

1. ¿Qué diferencia hay entre un cable UTP derecho y un cable UTP cruzado (crossover)? ¿Para qué se usa cada uno de ellos?

**Diferencia entre UTP derecho y UTP cruzado:**

- UTP derecho: Se utiliza para conectar dispositivos diferentes, como un ordenador a un switch.
- UTP cruzado (crossover):Se utiliza para conectar dispositivos del mismo tipo, como dos ordenadores directamente entre sí, sin necesidad de un dispositivo de red intermediario como un switch.


1. ¿Qué tipos de dispositivos se pueden usar para emitir la luz que se transmite por una fibra óptica?

**Dispositivos para emitir luz en fibra óptica:** Se utilizan diodos emisores de luz (LED) y láseres.

1. ¿Cuáles son los dos tipos principales de fibra óptica? ¿Cuáles son sus aplicaciones?

**Tipos principales de fibra óptica:**

- Fibra óptica monomodo: Se utiliza para largas distancias y alta velocidad.
- Fibra óptica multimodo: Se utiliza para distancias más cortas y velocidades más bajas.

1. Realizar una tabla a modo de resumen comparando los diferentes tipos de medios de transmisión, incluir por ejemplo longitud máxima permitida, tipo de conector, nomenclatura usada para reconocerlo.









|**Medio de Transmisión** |**Longitud Máxima** |**Tipo de Conector** |**Nomenclatura**|**Tasas de transmisión** |**Usos Comunes**|
| :- | :- | :- | :- | :- | :- |
|Cable Coaxial |Hasta varios km|Conector F|RG-6, RG-59, ect. |Hasta varios Gbps |Televisión por cable, internet de banda ancha |
|UTP|100 metros |RJ-45|Cat5, Cat6, Cat7  se puede encontrar con “e” o “a” |Hasta 10 Gbps |Redes de área local (LAN), telefonía |
|STP|100 metros |RJ-45|Cat5, Cat6, Cat7, se puede encontrar con “e” o “a”  |Hasta 10 Gbps |Ambientes con alta interferencia electromagnética |
|ScTP|100 metros |RJ-45|Cat5, Cat6, Cat7, se puede encontrar con “e” o “a”  |Hasta 10 Gbps |Ambientes con alta interferencia electromagnética |
|Fibra Óptica Monomodo |Kilómetros |Conector LC, SC, ST, etc.|OS1, OS2|Hasta varios Tbps |Redes de larga distancia, telecomunicaciones|
|Fibra Óptica Multimodo |Varios cientos de metros|Conector LC, SC, ST, etc.|` `OM1, OM2, OM3, OM4|Hasta varios Gbps |Redes de área local (LAN), sistemas de seguridad|





**REDES INALÁMBRICAS Y TOPOLOGÍAS DE RED**

1. ¿Qué labor hizo el grupo de trabajo 802.11 de la IEEE?

El grupo de trabajo 802.11 de la IEEE se encargó de desarrollar los estándares para tecnologías de redes inalámbricas locales (WLAN), comúnmente conocidas como Wi-Fi. Estos estándares definen aspectos como las frecuencias de operación, métodos de acceso al medio, protocolos de seguridad, entre otros.

1. ¿En qué consiste el esquema de acceso CSMA/CA?

CSMA/CA (Carrier Sense Multiple Access with Collision Avoidance) es un esquema de acceso al medio utilizado en redes inalámbricas, como Wi-Fi. Funciona detectando la presencia de señales en el medio antes de transmitir datos y utiliza técnicas para evitar colisiones entre paquetes de datos, como el mecanismo de espera aleatoria.

1. ¿Cuáles son los dos rangos de frecuencias empleados en Wifi?

Los dos rangos de frecuencias empleados en Wi-Fi son 2.4 GHz y 5 GHz.

1. Haga una tabla de los diferentes estándares de Wifi (a, b, g, n, ac). Incluya las siguientes columnas: Nombre del estándar, velocidad de transferencia de datos que puede alcanzar, banda (o bandas) de frecuencia que emplea. Complemente la tabla con el estándar Wifi ax, con datos que encuentre en Internet.



|Nombre del estándar |Velocidad de transferencia de datos|Banda de frecuencia |
| :- | :- | :- |
|802\.11a|Hasta 54 Mbps|5 GHz|
|802\.11b|Hasta 11 Mbps|2\.4 GHz|
|802\.11g	|Hasta 54 Mbps|<p>2\.4 GHz</p><p></p>|
|802\.11n|Hasta 600 Mbps|<p>2\.4 GHz y 5 GHz</p><p></p>|
|802\.11ac|Hasta 1.3 Gbps|5 GHz|
|802\.11ax (Wi-Fi 6)	|Hasta 9.6 Gbps|2\.4 GHz y 5 GHz|


1. ¿Cuál es la diferencia fundamental entre una red Wifi en modo infraestructura, y una en modo ad-hoc?

En una red Wi-Fi en modo infraestructura, los dispositivos se conectan a un punto de acceso central que gestiona y controla el tráfico de la red. En cambio, en una red Wi-Fi en modo ad-hoc, los dispositivos se conectan directamente entre sí sin necesidad de un punto de acceso central, lo que permite la comunicación directa entre ellos.

1. Haga una tabla de las diferentes topologías de red: Bus, anillo, estrella y malla. Incluya las siguientes columnas: Un pequeño esquema gráfico, resumen de ventajas y resumen de desventajas.



<table><tr><th valign="top">Topología </th><th valign="top">Esquema Gráfico </th><th valign="top">Ventajas</th><th valign="top">Desventajas</th></tr>
<tr><td rowspan="2" valign="top">Bus</td><td rowspan="2" valign="top"></td><td valign="top">Fácil de implementar.</td><td valign="top">Un fallo en el cable puede paralizar toda la red.</td></tr>
<tr><td valign="top">Requiere menos cableado que otras topologías.</td><td valign="top">El rendimiento puede degradarse con la adición de más dispositivos.</td></tr>
<tr><td rowspan="2" valign="top">Anillo</td><td rowspan="2" valign="top"></td><td valign="top">No hay necesidad de un nodo central.</td><td valign="top">Una falla en un nodo puede afectar a toda la red.</td></tr>
<tr><td valign="top">El tráfico de datos fluye en una dirección clara.</td><td valign="top">La adición o eliminación de nodos puede ser complicada</td></tr>
<tr><td rowspan="2" valign="top">Estrella </td><td rowspan="2" valign="top"></td><td valign="top">Fácil de instalar y mantener.</td><td valign="top">La falla del nodo central puede inutilizar toda la red.</td></tr>
<tr><td valign="top">El rendimiento de la red no se ve afectado por la adición de más dispositivos.</td><td valign="top">Requiere más cableado que otras topologías</td></tr>
<tr><td rowspan="2" valign="top">Malla </td><td rowspan="2" valign="top"></td><td valign="top">Tolerancia a fallos mejorada.</td><td valign="top">Requiere más nodos y dispositivos</td></tr>
<tr><td valign="top">La comunicación puede ser más eficiente al haber múltiples rutas.</td><td valign="top">La configuración y gestión pueden ser complejas.</td></tr>
</table>


1. ¿Cuál es la diferencia entre una topología física y una topología lógica?

La diferencia entre una topología física y una topología lógica en una red se encuentra en la forma en que se estructuran y visualizan las conexiones y el flujo de datos:

**Topología física:** Se refiere a la disposición física real de los dispositivos de red y los cables que los conectan. Esta topología describe cómo están físicamente interconectados los nodos de la red, incluyendo la ubicación de los dispositivos, los tipos de cables utilizados y la disposición de los dispositivos de red, como switches, routers y computadoras. Ejemplos de topologías físicas incluyen estrella, bus, anillo, malla, entre otras.

**Topología lógica:** Se refiere a la forma en que los datos viajan a través de la red, independientemente de su disposición física. Describe cómo los datos se transmiten entre los nodos de la red, cómo se direccionan y cómo se gestionan las rutas de comunicación. La topología lógica se enfoca en los protocolos y algoritmos utilizados para el intercambio de datos, así como en la forma en que se organizan y administran los recursos de red. Ejemplos de topologías lógicas incluyen el modelo de interconexión de sistemas abiertos (OSI) y el modelo TCP/IP.

**CAPA DE ENLACE DE DATOS  -SWITCHES** 

**Preguntas para el capítulo “Capa de enlace de datos”:**

1. ¿Qué hace la capa de enlace de datos para transferir un mensaje entre dos nodos?

La capa de enlace de datos se encarga de facilitar la comunicación entre nodos adyacentes en la misma red local. Para transferir un mensaje entre dos nodos, la capa de enlace de datos encapsula los datos en tramas y las envía a través del medio físico, asegurando una transmisión confiable y sin errores.

1. Mencione y explique brevemente las cuatro funciones básicas de la capa de enlace de datos.

1. Encapsulación: Agrega encabezados y pies de trama a los datos del nivel superior para crear tramas.
1. Control de acceso al medio: Gestiona el acceso al medio compartido, garantizando que los dispositivos no transmitan al mismo tiempo para evitar colisiones.
1. Detección y corrección de errores: Verifica la integridad de las tramas enviadas y, en algunos casos, puede corregir errores detectados.
1. Control de flujo: Regula el flujo de datos entre los dispositivos emisores y receptores para evitar la congestión en la red.

1. ¿Qué dispositivo implementa la capa de enlace de datos?

El dispositivo que implementa la capa de enlace de datos es el switch.

**Preguntas para el capítulo “Direcciones MAC”:** 


4\. ¿Qué dirección identifica a un nodo en la capa de enlace de datos? ¿Cómo está compuesta dicha dirección?

La dirección que identifica a un nodo en la capa de enlace de datos es la dirección MAC (Media Access Control). Esta dirección está compuesta por 48 bits y es única para cada dispositivo de red.

5\. Investigue la estructura de una trama Ethernet. ¿Cuántos y cuáles campos tiene?

Una trama Ethernet consta de varios campos, incluyendo: preámbulo, SFD, dirección MAC de destino, dirección MAC de origen, tipo de protocolo, datos, y suma de verificación (FCS). En total, tiene 7 campos. Cada uno hace: 


- Preámbulo: Es un patrón de bits que indica el comienzo de la trama y ayuda a sincronizar los relojes de los dispositivos receptores.

- SFD (Start Frame Delimiter): Inmediatamente después del preámbulo, el SFD indica el inicio del campo de dirección MAC de destino.

- Dirección MAC de destino: Es la dirección MAC (Media Access Control) del dispositivo receptor al que se envía la trama.

- Dirección MAC de origen: Es la dirección MAC del dispositivo emisor que está enviando la trama.

- Tipo de protocolo: Indica el tipo de protocolo de capa superior al que se enviarán los datos de la trama Ethernet, como IPv4, ARP, IPv6, etc.

- Datos: Contiene los datos de la capa superior que se están transmitiendo a través de la red, como segmentos TCP/IP o paquetes IP.

- FCS (Frame Check Sequence): Es un campo de verificación de errores que contiene una suma de comprobación cíclica (CRC) de los datos de la trama. Se utiliza para verificar la integridad de los datos durante la transmisión y recepción de la trama.

6. ¿Cuál es la función de un switch?

La función principal de un switch es interconectar dispositivos en una red local (LAN) y facilitar la comunicación entre ellos al determinar la ruta óptima para enviar paquetes de datos.

7\. ¿Cuál es la diferencia entre las modalidades de paso de tramas (forwarding) cut-through y store-and-forward?

En el forwarding cut-through, el switch comienza a reenviar la trama tan pronto como ha leído la dirección de destino, mientras que en store-and-forward, el switch espera a recibir la trama completa antes de reenviarla.

8\. ¿Cómo funciona el algoritmo de forwarding? ¿Qué papel juega en él la CAM?

El algoritmo de forwarding determina a qué puerto del switch debe ser enviada una trama según la dirección MAC de destino. La Content Addressable Memory (CAM) es la tabla utilizada por el switch para asociar direcciones MAC con los puertos del switch.


9\. ¿Cuál es la diferencia entre un switch no administrable y uno administrable?

Un switch no administrable no permite configuraciones avanzadas y opera de manera automática, mientras que un switch administrable ofrece funcionalidades avanzadas como la configuración de VLANs, monitoreo de tráfico, y gestión remota a través de interfaces de línea de comandos o interfaces gráficas de usuario.

