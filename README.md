# Automatas

Este proyecto implementa una simulación de autómatas finitos deterministas (AFD) en Java. Permite evaluar recorridos de cadenas y visualizar la estructura del autómata generado mediante Graphviz.

## Características

- **Modelado de nodos:** Cada estado del autómata es representado por la clase `Node`.
- **Lógica del autómata:** La clase `Automaton` permite evaluar cadenas y generar representaciones visuales del autómata.
- **Interfaz gráfica:** Uso de `JOptionPane` para la interacción con el usuario.
- **Visualización con Graphviz:** Generación de imágenes del autómata mediante `GraphvizController`.

## Estructura del Proyecto

```
Automatas/
│── src/
│   ├── Bean/
│   │   ├── Node.java
│   ├── Logic/
│   │   ├── Automaton.java
│   ├── Utility/
│   │   ├── GraphvizController.java
│   │   ├── ConfigGraphviz.txt (generado automáticamente)
│   ├── View/
│   │   ├── Graph.jpg (generado automáticamente)
│   │   ├── Menu.java
│   ├── Main.java
│── libraries/
│   ├── Graphviz/
│   │   ├── dot.exe
│   │   ├── .....
│   │   ├── .....
```

## Instalación y Ejecución

### Requisitos Previos
- Java JDK 8 o superior.
- Graphviz instalado y accesible.

### Instrucciones
1. Clonar el repositorio o descargar los archivos.
2. Configurar el archivo `GraphvizController.java` con la ruta correcta de `dot.exe`.
3. Compilar y ejecutar:
   ```sh
   javac -d bin src/**/*.java
   java -cp bin Main
   ```

## Uso

Al ejecutar el programa, se mostrará un menú con las siguientes opciones:

1. **Evaluar recorrido:** Permite ingresar una cadena y verificar si es aceptada por el autómata.
2. **Ver autómata:** Genera una representación visual del autómata.
3. **Salir:** Termina la ejecución del programa.

## Ejemplo de Configuración de Autómata

El código de `Main.java` configura un autómata con los siguientes estados y transiciones:

```
   Q0 →(a)→ Q4 →(a)→ Q6 →(a)→ Q6
        ↘(b)         ↘(b)       ↘(b)
         Q1           Q1         Q7
```

## Notas

- Si `dot.exe` no está en la ruta especificada, la generación de imágenes fallará.
- El archivo `ConfigGraphviz.txt` es generado automáticamente y no debe modificarse manualmente.


