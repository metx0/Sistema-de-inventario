# ITSystem

## Descripción

ITSystem es un sistema de gestión de inventario escrito en Java, que permite añadir productos (que se tratan como lotes), visualizarlos en una tabla de stock, simular su venta y crear reportes del stock en formato CSV. 

Los productos tienen fechas de caducidad, por lo que la lista de productos se ordena de menor a mayor fecha, para así guardarlo en un CSV.

## Requerimientos

- Tener instalado la JVM en tu equipo (Java Virtual Machine)
- Si quieres editar el código, te recomendamos usar el IDE Netbeans, y tener instalado el JDK (Java Development Kit).

## El programa en funcionamiento
- Inserta el nombre, la ID, la cantidad en stock, el precio y la fecha de caducidad de un lote de productos.
  
![sys](https://i.imgur.com/ZjJ8Gz3.png)
- Inserte la cantidad a vender de productos sustituyendo el valor predeterminado de la tercera columna y oprima el botón las veces que quiera.
  
![sys](https://i.imgur.com/XXM7WDB.png)

- Consulte en una tabla el nombre, ID, cantidad en stock y la fecha de caducidad de un lote de productos. Estos están en el orden en que se insertaron.

![sys](https://i.imgur.com/A1Xx4Qx.png)

- Cree un reporte de los lotes disponibles, con las fechas de caducidad ordenadas.
  
![sys](https://i.imgur.com/tFlhqEa.png)


## Cómo ejecutarlo

Clona el repositorio o descárgalo en un zip. El repo tiene un archivo JAR, que es el ejecutable del proyecto. Dale click para ejecutarlo.

## Mejoras posibles

Por tiempo, algunas funcionalidades extra no se han implementado. Entre ellas, está la de guardar todo el stock en un archivo para que al abrir de nuevo el programa, este refleje la información de dicho archivo. Tambien es necesario que el usuario acceda a la carpeta donde esta ubicado el programa para acceder a los reportes.
