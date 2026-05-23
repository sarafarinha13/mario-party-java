# Mario Party Java

Juego inspirado en Mario Party desarrollado en Java.

## Funcionalidades

- Sistema de turnos y rondas
- Tirada de dado aleatoria
- Tablero con caminos y bifurcaciones
- Diferentes tipos de casillas
- Sistema de monedas y estrellas
- Elección de rutas
- Determinación automática del ganador
- Posibilidad de volver a jugar

## Tecnologías utilizadas

- Java
- Programación Orientada a Objetos (POO)
- ArrayList
- Herencia
- Polimorfismo
- Clases abstractas
- Scanner
- Random

## Conceptos trabajados

- Herencia (`Casilla` → `CAzul`, `CRoja`, etc.)
- Métodos `@Override`
- Uso de `ArrayList`
- Gestión de objetos
- Bucles y condicionales
- Interfaces por consola
- Gestión de estados y turnos

## Funcionamiento

El tablero se construye conectando casillas mediante un `ArrayList<Casilla>` que permite crear distintos caminos y bifurcaciones

Cada tipo de casilla tiene un efecto diferente sobre el jugador:
- Casillas azules → ganan monedas
- Casillas rojas → pierden monedas
- Casillas verdes → eventos aleatorios
- Casillas estrella → compra de estrellas

El juego se desarrolla por rondas y el ganador se decide según estrellas y monedas. 
