PATRON DE ARQUITECTURA DE SOFTWARE - controller->services->repositories->database
## 🚪 Capa de Controlador (Controller)
El Controlador es la capa de entrada. Su única función es recibir peticiones del cliente (por ejemplo, desde un navegador web) y devolver una respuesta.

Analogía: El camarero.

Función:

    Recibe tu pedido ("quiero una paella para la mesa 5").

    Verifica que el pedido sea válido (no pides algo que no está en el menú).

    No cocina. Simplemente pasa la orden al chef.

    Cuando la comida está lista, te la trae a la mesa.

En código: Recibe una petición HTTP (ej: GET /productos/123), valida los datos de entrada, llama al método correspondiente en la capa de servicio y, finalmente, formatea la respuesta (ej: en formato JSON) para enviarla de vuelta al cliente. No contiene lógica de negocio.

## 🧠 Capa de Servicio (Service)
El Servicio contiene la lógica de negocio de la aplicación. Es el cerebro de la operación. Aquí es donde se implementan las reglas y los procesos.

Analogía: El chef.

Función:

    Recibe la orden del camarero ("preparar una paella").

    Sabe la receta: qué ingredientes se necesitan, en qué orden se cocinan, cuánto tiempo, etc. Esta es la lógica de negocio.

    Le pide al encargado del almacén los ingredientes que necesita ("tráeme arroz, pollo y azafrán").

    Coordina todo el proceso de cocinado.

En código: Implementa las funcionalidades. Por ejemplo, para crear un usuario, el servicio podría verificar si el email ya existe, hashear la contraseña y luego pedirle al repositorio que guarde el nuevo usuario. Puede coordinar llamadas a múltiples repositorios si es necesario.

## 📦 Capa de Repositorio (Repository)
El Repositorio es una capa de abstracción que se encarga exclusivamente de la comunicación con la fuente de datos. Su trabajo es obtener y guardar datos, ocultando los detalles de cómo se hace.

Analogía: El encargado del almacén.

Función:

    Recibe una petición del chef ("necesito arroz y pollo").

    Sabe exactamente en qué estantería y en qué caja están guardados esos ingredientes.

    Los busca, los coge y se los entrega al chef.

    Al chef no le importa cómo está organizado el almacén, solo pide lo que necesita.

En código: Proporciona métodos simples para interactuar con la base de datos, como findById(), save(), findAll(), delete(). Traduce los objetos del lenguaje de programación (ej: una clase Usuario) a filas en una tabla de la base de datos, y viceversa. Si mañana cambias de MySQL a PostgreSQL, en teoría solo tendrías que modificar esta capa.

## 💾 Base de Datos (Database)
La Base de Datos es donde los datos se almacenan de forma persistente. Es el destino final.

Analogía: El almacén físico.

Función:

    Guarda todos los ingredientes (los datos) de forma organizada y segura.

En código: Es el sistema de gestión de bases de datos (como MySQL, PostgreSQL, MongoDB, etc.) que almacena la información en tablas, documentos, etc.