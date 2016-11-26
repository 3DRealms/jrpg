Para testear el juego, primero se debe ejecutar el proyecto servidor. En el proyecto hay una clase llamada Servidor, esta contiene al main principal. Al abrirse debe aparecer una ventana con una consola. 
Luego debo abrir el proyecto cliente, donde su clase main es Juego. Al ejecutarse debe aparecer una pantalla de login/registrar. 
Los dos proyectos anteriores conocen al proyecto dominio (por lo cual debe estar referenciado a cada uno).
Hay 2 archivos de configuración, uno del server y otro del cliente, el server.properties y cliente.properties respectivamente, ambos contiene el puerto y la dirección ip. (nota: la dirección local host es para probar en un mismo pc).
Se debe tener los puertos abiertos (utilizamos el 27015, pero cualquiera abierto está bien).
Una vez hecho esto el cliente intenta conectarse al servidor, si lo hace, el servidor empieza a escucharlo y se hace toda la mensajería,( el intercambio de mensajes serializados en json con las librerías gson).
Cuando se conecta al servidor y entra al mundo, el servidor le envía la posición de todos los demás personajes, su nombre y sprite. 
Las interacciones humano juego son: clic derecho para moverse, esto lo que hace es capturar el punto donde quiero ir , se calcula dijkstra y de ser posible hace el camino. Al encontrar camino le envía al servidor la posición donde quiero ir y él se encarga de re enviarle este punto a todos los clientes de ese mapa. En cada cliente se calcula el dijkstra y se hace el movimiento del jugador remoto.
Click izquierdo sirve para hacer interacciones con el mapa, por el momento hay dos, que son jugador y cofres: 
Cuando es sobre un jugador se envía la petición de combate (sin confirmación) y cuando es un cofre se abre el cofre y se pide el ítem que contiene a la base de datos (ósea al servidor) este se lo devuelve y se guarda en la mochila. 
Click de ruedita (se puede cambiar por una tecla): abre un panel de opciones del jugador donde muestra su estadística y su equipo. Acá es donde se puede aumentar los atributos en caso de tener los puntos (que se suben con el nivel).

El combate: cuando un jugador inicia un combate con otro, se los saca del mapa, se muestra una nueva interfaz gráfica para combatir y al terminar la batalla se lo devuelve al mapa, con el personaje actualizado (exp , nivel, item, oro).
Dentro del combate parecen todos los jugadores de ambas alianzas, (lo cual la alianza está resuelta pero no implementada), y cada jugador elige su acción al principio de cada turno, luego que todos los jugadores han elegido su acción, el servidor captura todos las acciones y las ordena por velocidad ( que esta depende de la acción en sí y del atributo del personaje velocidad). 
La batalla sigue de igual manera hasta que un equipo muera todos los integrantes, dando así un ganador. 

Clases: 
Juego: main del client, acá es donde se lanza la pantalla del login.
JuegoPanel: acá es donde pasa todo lo central del juego, las actualizaciones de mouse, gráficos, y el juego en sí.
Mapa gráfico: aquí es donde se calcula todo lo central a lo gráfico.
El constructor del mapa, funciona así: 
Primero abre el “.map”, lee la primeras líneas que son ID, las dimensiones , y el nombre de la hoja de sprite a usar, luego levanta en una matriz todos los tiles del piso, (que en el archivo de mapa está representado como número, el sprite para usar). Luego sigue una matriz de obstáculos, que si hay:
0 significa que no hay obstáculo.
1 hay obstáculo pero no se dibuja nada(trasparente).
>2 hay obstáculo y se dibuja el sprite 64x64.
Luego sigue un numero n que indica la cantidad de cofres que hay en el map y luego n líneas con la información de cada cofre (nombre ubicación y sprite). 

Si hay un cofre se guarda en la matriz de obstáculo ( pisando si había un obstáculo). 

Dijkstra: se construye un grado a partir de la matriz de obstáculos. Este grafo solo se construye una vez y después se realiza el "Algoritmo del tacho" cada vez que un jugador desea moverse.
