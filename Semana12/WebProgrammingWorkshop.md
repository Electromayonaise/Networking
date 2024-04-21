# Parte 2: Taller Práctico: Conceptos Básicos de Programación Web 

## Actividad  1:  Explorando  URIs  y  URLs consultar  y  definir  los  temas  relacionados  a continuación: 

1. Definición y estructura de una URI (Uniform Resource Identifier). 

Una URI, o Identificador Uniforme de Recursos, es una secuencia de caracteres que identifica de manera única un recurso en la web. La estructura básica de una URI es la siguiente:

```bash
scheme:[//authority]path[?query][#fragment]
```

- `scheme`: Esquema o protocolo que se utiliza para acceder al recurso. Por ejemplo, http, https, ftp, mailto, etc.

- `authority`: Especifica la autoridad que controla el recurso. Por ejemplo, el nombre de dominio de un sitio web, o una dirección ip.

- `path`: Ruta que especifica la ubicación del recurso en el servidor.

- `query`: Parámetros que se envían al servidor para realizar una consulta o solicitud específica (opcionales).

- `fragment`: Identificador de una parte específica del recurso.

2. Tipos de URI: URL, URN, DOI. 

- `URL` (Localizador de Recursos Uniforme): Es un tipo de URI que se utiliza para identificar la ubicación de un recurso en la web. Por ejemplo, la dirección de una página web, una imagen, un archivo, etc.
- `URN` (Nombre de Recurso Uniforme): Es un tipo de URI que se utiliza para identificar de manera única un recurso, independientemente de su ubicación. Por ejemplo, un ISBN de un libro, un ISSN de una revista, etc.
- `DOI` (Identificador de Objeto Digital): Es un tipo de URN que se utiliza para identificar de manera única un objeto digital, como un artículo científico, un libro, una imagen, etc.

3.  Anatomía  de  una  URL  (Uniform  Resource  Locator):  esquema,  protocolo,  host,  puerto,  ruta, 
consulta, fragmento. 

Una URL, o Localizador de Recursos Uniforme, es un tipo de URI que se utiliza para identificar la ubicación de un recurso en la web. La estructura básica de una URL es la siguiente:

```bash
scheme://host:port/path?query#fragment
```

- `scheme`: Esquema o protocolo que se utiliza para acceder al recurso. Por ejemplo, http, https, ftp, mailto, etc.

- `host`: Nombre de dominio o dirección ip del servidor que aloja el recurso.

- `port`: Puerto del servidor en el que se encuentra el recurso (opcional).

- `path`: Ruta que especifica la ubicación del recurso en el servidor.

- `query`: Parámetros que se envían al servidor para realizar una consulta o solicitud específica (opcional).

- `fragment`: Identificador de una parte específica del recurso (opcional).


4. Presentar algunos ejemplos de URLs: URL de un sitio web, URL de una imagen, URL de un vídeo. 

- URL de un sitio web: `https://www.google.com`
- URL de una imagen: `https://ibb.co/fF9SLYt`
- URL de un vídeo: `https://www.youtube.com/watch?v=dQw4w9WgXcQ`

5. Diferencia entre URL absoluta y URL relativa. 

- URL absoluta: Es una URL que especifica la ubicación completa de un recurso en la web, incluyendo el esquema, el host, la ruta, etc. Por ejemplo, `https://www.google.com/search?q=example`.

- URL relativa: Es una URL que especifica la ubicación de un recurso en relación con la ubicación actual del recurso. Por ejemplo, si estamos en la página `https://www.google.com`, una URL relativa podría ser `search?q=example`.

6. Actividad práctica: Analizar y descomponer diferentes URLs 

Ejemplo de análisis de una URL:  

Url: https://www.google.com/search?client=firefox-b-d&q=programacion+web 

- Esquema: https (protocolo seguro) 
- Protocolo: HTTP (transferencia de hipertexto) 
- Host: www.google.com (dominio de Google) 
- Puerto: 80  (por defecto, no se especifica) 
- Ruta: /search (ruta al motor de búsqueda) 
- Consulta:  q=programacion+web (parámetros de búsqueda) 
- Fragmento: No hay (no se especifica una sección específica) 

Esta URL indica que se accede al motor de búsqueda de Google (https://www.google.com/search) 
con  los  parámetros  de  búsqueda  ‘q=programacion+web’  (búsqueda  de  "programación  web")  y 
pueden aparecer otros parámetros adicionales (‘oq’, ‘aqs’, ‘sourceid’, ‘ie’) que definen la consulta y 
el contexto de la búsqueda. 

Analisis de URL's propuestas en el punto anterior: 

URL de un sitio web: https://www.google.com
  - Esquema: https
  - Protocolo: HTTP
  - Host: www.google.com
  - Puerto: 443
  - Ruta: /
  - Consulta: No hay
  - Fragmento: No hay

Esta URL indica que se accede al sitio web de Google (https://www.google.com) sin especificar una ruta específica, consulta o fragmento.

URL de una imagen: https://ibb.co/fF9SLYt
  - Esquema: https
  - Protocolo: HTTP
  - Host: ibb.co
  - Puerto: 443
  - Ruta: /fF9SLYt
  - Consulta: No hay
  - Fragmento: No hay

Esta URL indica que se accede a una imagen alojada en el sitio ibb.co con la ruta /fF9SLYt, sin especificar una consulta o fragmento.

URL de un vídeo: https://www.youtube.com/watch?v=dQw4w9WgXcQ
  - Esquema: https
  - Protocolo: HTTP
  - Host: www.youtube.com
  - Puerto: 443
  - Ruta: /watch
  - Consulta: v=dQw4w9WgXcQ
  - Fragmento: No hay

Esta URL indica que se accede a un vídeo alojado en YouTube con el identificador dQw4w9WgXcQ, sin especificar un fragmento.

## Actividad  2:  Descubriendo  el  modelo  cliente-servidor consultar  y  definir  los  temas relacionados a continuación: 

1. Concepto básico del modelo cliente-servidor. 

El modelo cliente-servidor es un modelo de arquitectura de software en el que un cliente realiza una solicitud a un servidor para obtener un recurso o servicio. El cliente es el que inicia la comunicación y realiza la solicitud, mientras que el servidor es el que responde a la solicitud y proporciona el recurso o servicio solicitado.

2.  Funcionamiento  en  la  Web:  papel  del  navegador  como  cliente,  papel  del  servidor  web  como 
servidor. 

En la web, el navegador actúa como el cliente que realiza solicitudes a los servidores web para obtener páginas web, imágenes, vídeos, etc. El servidor web, por otro lado, es el que responde a las solicitudes del navegador y proporciona los recursos solicitados.

3. Solicitud-respuesta HTTP: solicitud del cliente, respuesta del servidor.

El intercambio de información entre el cliente y el servidor se realiza a través del protocolo HTTP (Hypertext Transfer Protocol). Cuando el cliente realiza una solicitud al servidor, envía una solicitud HTTP que contiene información sobre el recurso solicitado y otros parámetros. El servidor procesa la solicitud y envía una respuesta HTTP que contiene el recurso solicitado y otros datos relevantes.

4. Actividad  práctica:  Simular  una  interacción  cliente-servidor  utilizando  un  navegador  web  y  un 
servidor web local. 

Usando su navegador web escribir la dirección: http://direccion_ip_servidor:puerto, donde 
direccion_ip_servidor es la dirección IP del servidor y puerto es el puerto en el que el servidor está 
escuchando (en este caso, 8080).

## Actividad 3: Navegando la Web con diferentes navegadores: 

1. Función principal de los navegadores web. 

La función principal de los navegadores web es permitir a los usuarios acceder y visualizar información en la World Wide Web. Actúan como intermediarios entre los usuarios y los servidores web, interpretando y mostrando contenido HTML, CSS y JavaScript de los sitios web.

2. Estructura básica de un navegador web: motor de renderizado, interfaz de usuario, administración de memoria caché. 

- `Motor de renderizado`: Es el componente que interpreta el código HTML, CSS y JavaScript de una página web y lo convierte en la representación visual que vemos en la pantalla.

- `Interfaz de usuario` : Incluye elementos como la barra de direcciones, botones de navegación (atrás, adelante, recargar), pestañas, barras de herramientas y menús.

- `Administración de memoria caché`: Los navegadores web almacenan en caché recursos como imágenes, scripts y hojas de estilo para acelerar la carga de páginas web posteriores, reduciendo así la necesidad de volver a descargar recursos que no han cambiado.

3. Diferencias y características principales de cada navegador: Chrome, Firefox, Safari, Edge, Brave 

- `Google Chrome`: Desarrollado por Google, es conocido por su velocidad, estabilidad y compatibilidad con las últimas tecnologías web. Tiene una interfaz sencilla y limpia, y es compatible con extensiones y complementos.

- `Mozilla Firefox`: Desarrollado por la Fundación Mozilla, es conocido por su enfoque en la privacidad y la seguridad. Tiene una amplia gama de extensiones y complementos, y es altamente personalizable.

- `Safari`: Desarrollado por Apple, es el navegador predeterminado en dispositivos iOS y macOS. Es conocido por su rendimiento y eficiencia energética, así como por su integración con otros productos de Apple.

- `Microsoft Edge`: Desarrollado por Microsoft, es el sucesor de Internet Explorer y está basado en el motor de renderizado Blink de Google Chrome. Es conocido por su rendimiento y compatibilidad con las últimas tecnologías web.

- `Brave`: Es un navegador centrado en la privacidad y la seguridad, que bloquea anuncios y rastreadores de forma predeterminada. Está basado en Chromium, el mismo motor de renderizado que Google Chrome, y es conocido por su velocidad y eficiencia.

- `Opera` (adicional): Es un navegador web desarrollado por Opera Software. Es conocido por su velocidad, seguridad y funcionalidades avanzadas, como un bloqueador de anuncios integrado y un VPN gratuito.

4. Comparar y contrastar la experiencia de navegación en diferentes sitios web utilizando distintos 
navegadores. 

La experiencia de navegación en diferentes sitios web puede variar según el navegador utilizado debido a diferencias en el motor de renderizado, la compatibilidad con estándares web, la velocidad de carga, la seguridad y la privacidad. Algunos sitios web pueden funcionar mejor en ciertos navegadores debido a optimizaciones específicas o características exclusivas de cada navegador. 