# <h1 align="center">STORE_BOOKS_FINAL_PROJECT</h1>

<h1>Integrantes:</h1>

- <h4>Miguel Macia Medina</h4>
- <h4>Jesus Eduardo Velez Ramos</h4>
- <h4>Miguel angel Hernández Padilla</h4>
- <h4>Jesús David Correa Monroy</h4>

# Manual de Usuario

## Descripción del Proyecto

Este repositorio contiene un proyecto para gestionar libros favoritos y un carrito de compras mediante una interfaz gráfica en JavaFX. Los usuarios pueden mover libros entre el panel de favoritos y el carrito, a continuación, se estará dando una breve explicación del funcionamiento del programa para los usuarios del mismo. Esto se logra apreciar de manera clara y sencilla en las siguientes presentaciones.

---
### Vista del Login.

En la siguiente vista se podrá apreciar lo que sería el login, se debe llenar los campos para iniciar la sesión, en caso de que no tenga un usuario registrado puede dirigirse hasta el apartado de registro, si preciona el botón "Registrarse" que se encuentra ubicada el la parte media de la pantalla después del botón iniciar sesión ( Login ): ![image](https://github.com/user-attachments/assets/479fd921-c8b8-44ac-bba4-7145be268558)

![image](https://github.com/user-attachments/assets/756d6f29-4eff-4d16-b2d8-8632c95d74d5)

### Apartado de registro(Crea tu usuario).

En esta vista te encontrarás con los campos correspondientes para la creacion de un nuevo usuario para el programa, debes asegurarte de que los datos estén ubicados correctamente y que el dato realmente corresponda a la información solicitada para que no ocurranigún error a la hora de crear el usuario.

![image](https://github.com/user-attachments/assets/cb81e0f6-4de6-49f3-be32-ce9966a67568)

### Vista Principal(Catalogo de libros).

Esta es la vista donde el usuario podrá ingresar despues de llenar sus datos de incio, tendrá una variedad de opciones muy buena esto relacionado con la compra de libros muy reconocidos y a buenos precios.

![image](https://github.com/user-attachments/assets/81260249-1f46-4b42-ad06-6bf3a548d619)


### Apartado del carrito.

En este apartado podrás hacer efectivas tus compras o revisar de cuanto es el saldo actual.

![image](https://github.com/user-attachments/assets/e785474c-56f8-40ba-90a3-d8e6334d59a3)

### Apartado de Favoritos

En este apartado podrás gestionar tus libros favoritos y enviarlos al carrito para luego proceder con su compra.

![image](https://github.com/user-attachments/assets/703970ea-688a-472d-8096-dc364e59c2e5)

## Demostración con contenido

Carrito:
![image](https://github.com/user-attachments/assets/c05d3fcd-82f3-407f-a946-a32fdb003681)

Favoritos:
![image](https://github.com/user-attachments/assets/edf966bb-a79a-4fe3-b955-aba3775825c5)

### Apartado de detalles

En este aoartadio podrás ver más información sobre el libro que deseas adquirir así como la opcion de enviarlo al apartado de favoritos o al panel del carrito, incluso comprarlo al instante.

![image](https://github.com/user-attachments/assets/481a281a-d812-4ddd-b6eb-8a5b15246aca)

### Apartado de Pagos

Acá podrás hacer efectivo el pago por tu compra, selecionando y llenando los datos de tu banco o cartera digital.

![image](https://github.com/user-attachments/assets/46c377ae-5b7a-454b-91af-26350bb170e8)

## Manual de Desarrollador:

Acontinuación tenemos la explicación o la demostración de de la solucion en el codigo fuente(Contenido para desarrolladores).

<table align="center">
  <tr>
          <h3 align="center">Tabla de Clases</t3>
  </tr>
  <tr>
          <th>Clases</th>
          <th>Descripción</th>
  </tr>
  <tr>
          <td>App.java</td>
          <td>Esta clase se encaraga de tomar el FXML de la pagina que se iniciará cuando se ejecute el programa carga la vista y lanza la aplicación</td>
  </tr>
  <tr>
          <td>ModeloDeDatos.java</td>
          <td>Esta clase implementa el patrón de diseño singleton y gestiona las instancias de los modelos de datos</td>
  </tr>
  <tr>
          <td>Lista_Users.java</td>
          <td>Esta clase implementa los metodos para almacenar y gestionar usuarios, guarda estos en archivos.txt para la persistencia de los datos</td>
  </tr>  
  <tr>
          <td>Pila_Books.java</td>
          <td>Esta clase plementa tres pilas Stack que gestionan los diferentes archivos.txt y pilas de juegos en la aplicación</td>
  </tr>
  <tr>
          <td>Nodo_User.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de usuario en la lista usuario</td>
  </tr>
  <tr>
          <td>Nodo_Book.java</td>
          <td>Esta clase implementa los atributos y metodos necesarios para cargar la información de los juegos en las pilasStack</td>
  </tr>
  <tr>
          <td>StylesSheets.css</td>
          <td>Esta hoja.css implemeta los estlos para la vista principal</td>
  </tr>
          
</table>

<table align="center"> 
      <tr>
            <h3 align="center">Tabla de Vistas</h3>
      </tr>
      <tr>
            <th>Vista</th>
            <th>Controllador</th>
            <th>Cescripción</th>
      </tr>
      <tr>
            <td>View_Principal.fxml</td>
            <td>Controller_ViewPrincipal.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar he asignar las acciones de los botones y demás</td>
      </tr>
      <tr>
            <td>View_Login.fxml</td>
            <td>Controller_View_Login.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los eventos onClick </td>
      </tr>
      <tr>
            <td>View_Sign_in.fxml</td>
            <td>Controller_View_Sing_in.java</td>
            <td>El .fxml es la vista hecha con javaFx, el contrrolador se encarga de implementar los metodos de escritura y lectura de los datos de los usuarios</td>
      </tr>
</table>

## Instalación

### Paso 1: Clonar el Repositorio

```bash
git clone https://github.com/JesusCm26/Proyecto_STORE_BOOKS.git
cd tu-ruta-para-guardar
```

### Paso 2: Configurar el Entorno

1. Asegúrate de tener el JDK configurado correctamente en tu sistema.
2. Descarga el SDK de JavaFX y configúralo en tu IDE.
3. Configura las dependencias necesarias según las instrucciones del archivo `pom.xml`.

### Paso 3: Ejecutar la Aplicación

1. Abre el proyecto en tu IDE.
2. Ejecuta la clase principal (`App.java`).

---

## Uso de la Aplicación

### Inicio de Sesión

1. Ingresa tus credenciales (Usuario y Contraseña).
2. Haz clic en **Iniciar sesión**.

### Panel Principal

- **Panel de Favoritos**: Muestra los libros marcados como favoritos.
- **Panel del Carrito**: Muestra los libros agregados al carrito de compras.

### Agregar Libros al Carrito

1. Selecciona un libro del panel de favoritos.
2. Haz clic en el botón **Mover al Carrito**.
3. El sistema verificará que no se dupliquen libros en el carrito.

### Guardar Cambios

- Los cambios se guardan automáticamente al mover libros entre paneles.

---

## Funciones Principales

### 1. Gestión de Favoritos

- Agrega o elimina libros del panel de favoritos.
- Visualiza la lista actualizada en tiempo real.

### 2. Carrito de Compras

- Agrega libros al carrito desde favoritos.
- El sistema evita duplicados automáticamente.

### 3. Persistencia de Datos

- Los cambios realizados se guardan en archivos locales para ser recuperados en futuras sesiones.

### 4. Notificaciones

- Alertas informativas para notificar acciones exitosas o errores (Ejemplo: libro duplicado).

---

## Prototipo Figma.

Puedes ver el prototipo del proyecto en el siguiente enlace: [Prototipo en Figma](https://www.figma.com/design/4piwD2vqzGn5GImrYIWZLX/Prototype_STORE_BOOKS?node-id=0-1&t=oBTOUTDcwsMn4Kn8-1)
