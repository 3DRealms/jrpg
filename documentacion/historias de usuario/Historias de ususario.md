#Historias de Usuario

##Crear personaje
Como jugador, quiero crear mi personaje, editando sus características principales (como raza y casta) para verme reflejado en mi avatar

* Dado un personaje cuando se va a crear entonces se le eligen casta y raza


##Ingresar al mundo-----------------------------------------------------------------------------
Como jugador, quiero ingresar a un mundo para adquirir experiencia, items y habilidades nuevas

* Dado un personaje cuando
* Debo poder ver mi experiencia acumulada y nivel.
* Debo poder ver mis habilidades actuales.
* Debo poder ver mis ítems equipados.

##Aumentar experiencia
Como jugador, quiero eliminar enemigos para aumentar mi experiencia

* Dado un personaje cuando gana una batalla contra un enemigo npc entonces gana experiencia

##Subir de nivel
Como jugador, quiero acumular experiencia para poder subir de nivel

* Dado un personaje cuando gane la suficiente experiencia entonces sube de nivel


##Asignar puntos adicionales a los estados
Como jugador, quiero subir de nivel para poder asignar puntos adicionales a mis estados

* Dado un personaje cuando sube de nivel entonces asigna puntos a sus estados


##Manipular items------------------------------------------------------------------------------------
Como jugador, quiero aumentar mis estados para poder manipular ítems de manera más eficiente

* Dado un personaje cuando aumente sus estados entonces sus items

##Equipar items
Como jugador, quiero equipar items para poder potenciar mis habilidades

* Dado un personaje cuando se equipa un item entonces algunas de sus habilidades hacen mas daño

##Estados para subir ataque, magia y defensa
Como jugador, quiero disponer de estados de destreza, fuerza, intelecto y vitalidad para afectar a mis puntos de ataque, magia y defensa

* Dado un personaje cuando suba los estados entonces seincrementan los puntos de ataque, magia o defensa dependiendo del estado elegido

##Aliarse o combatir contra otros jugadores
Como jugador, quiero encontrarme con otros jugadores en el mismo mundo para aliarme a ellos o combatir contra ellos

* Dado dos jugadores cuando se encuentren entonces tienen la opción de aliarse o batallar entre ellos

##Aumentar experiencia al aliarme con otro jugador
Como jugador, quiero aliarme con otro jugador para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo

* Dado un jugador cuando forma una alianza con otro 
* No debo poder dejar la alianza con otro jugador hasta que pase un determinado tiempo
* Debo poder combatir junto a otro jugador contra enemigos u otros jugadores
* Al ganar una batalla debo poder recibir más experiencia que al combatir solo, al igual que el otro jugador
* Al ganar una batalla debo poder recolectar ítems al igual que el otro jugador

##Obtener items al derrotar jugadores-----------------------
Como jugador, quiero combatir contra otros jugadores para obtener sus ítems al derrotarlos

* Al derrotar a un jugador debo poder recoger un ítem que tuviese equipado
* Al derrotar a un jugador que no tenga ítems no debo poder recoger ninguno

##Disolver o renovar alianza
Como jugador, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo para poder traicionar a mis aliados

* Dada una alianza cuando pase una determinada cantidad de tiempo entonces la misma se disuelve 

##Desplazarse dentro del mapa--------------------------------------------
Como jugador, quiero poder desplazarme por el mapa libremente para poder esquivar obstáculos

* Al hacer click con el botón derecho del mouse debo poder moverme a la ubicación seleccionada
* Al hacer click con el botón derecho del mouse en un obstáculo no debo poder moverme a su ubicación
* Debo poder moverme hacia arriba, abajo, izquierda, derecha y en las cuatro direcciones diagonales 

##Aprender habilidades
Como jugador, quiero aprender habilidades para usarlas en el combate contra enemigos

* Dada una batalla entre jugadores cuando sea el turno de uno de atacar entonces elige que habilidad usar


##Adquirir items al derrotar enemigos
Como jugador, quiero poder derrotar a un enemigo para conseguir ítems 

* Dada una batalla entre dos jugadores cuando uno gane entonces puede recoger un item del jugador derrotado

##Reemplazar items-----------------------------------------------------------------------------
Como jugador, quiero poder reemplazar un item para equipar uno nuevo

* Al recoger un ítem debe reemplazar al ítem que yo tenga equipado de ese mismo tipo

##Acceder a una zona neutral
Como jugador, quiero poder reaparecer en una zona neutral para no perder mi experiencia al morir

* Dado un personaje cuando es derrotado por un contrincante entonces reaparece en una zona neutral del mapa 
* Dada la muerte de un personaje cuando reaparece en una zona neutral entonces no pierde la experiencia acumulada


##Aprender habilidades subiendo niveles
Como jugador, quiero subir de nivel para aprender habilidades  

* Dado un personaje cuando suba de nivel entonces puede utilizar nuevas habilidades


##Rechazar batallas
Como jugador, quiero poder rechazar una batalla contra un enemigo

*  Dado dos jugadores cuando uno le solicita batallar al otro entonces al que le fue solicitada la batalla puede rechazarla 
*  Dada una solicitud de batalla cuando es rechazada entonces el jugador que la rechazo pierde salud
