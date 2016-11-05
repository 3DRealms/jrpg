# Mensajeria

## Inicio de sesión
### Cliente envia al sevidor el usuario y contraseña y le indica si se quiere registrar o iniciar sesion - MensajeAutenticacion 
```sh
{"username":"eldani","password":"123456", "registro":false}
```
## Confirmación
### Confirmación o respuesta del servidor y su correspondiente mensaje en caso de error - MensajeConfirmacion
```sh
{"confirmo":false, "mensaje":"La clave y el usuario no coinciden"}
```
## Creacion de personaje
### Cliente le envia los datos del personaje a crear al servidor
```sh
{"raza":"Humano","casta":"Mago"}
```
## Mapa Actual
### Servidor le envia el mapa al que ingresó el personaje
```sh
{"mapa":"CalabozoSucio"}
```
## Movimiento de Jugadores
### Cliente envia al servidor la posicion a la que se movera el personaje, y el servidor responde con la de los demas personajes
```sh
{"personaje":"eldani", "pos":{"x":2,"y":2}}
```

## Cliente equipa un item
```sh
{"personaje":"eldani", "item":"PaloMagico","accion":"equipar"}
```
## Cliente desequipa ítem
```sh
{"personaje":"eldani", "item":"PaloMagico","accion":"desequipar"}
```
## Guardar ítem
```sh
{"personaje":"eldani", "item":"PaloMagico","accion":"guardar"}
```
## Usar ítem
```sh
{"personaje":"eldani", "item":"PocionVida","accion":"usar"}
```
## Personaje interaccion con el entorno
### Se utiliza para combate, hablar con NPC o invitar a alianza
```sh
{"personaje":"eldani", "tipo":"batalla"}
```

## Comienzo de combate
```sh
{"Equipo1":[
    {"personaje":{"nombre":"eldani1", "salud":100, "energia":50}},
    {"personaje":{"nombre":"eldani2", "salud":100, "energia":50}},
    {"personaje":{"nombre":"eldani3", "salud":100, "energia":50}},
],
"Equipo2":[
    {"personaje":{"nombre":"elalex1", "salud":100, "energia":50}},
    {"personaje":{"nombre":"elalex2", "salud":100, "energia":50}},
    {"personaje":{"nombre":"elalex3", "salud":100, "energia":50}},
]}
```

## Solicitud de acción en combate
```sh
{"personaje":"eldani1", "tipo":"accion"}
```
## Acción de combate a realizar 
```sh
{"emisor":"eldani1", "objetivo":"eldani2", "accion":"curaracionestandar", "tipo":"habilidad"}
```

