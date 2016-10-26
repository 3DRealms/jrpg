#Historias de Usuario

##Crear personaje
Como jugador, quiero crear mi personaje, editando sus características principales (como raza y casta) para verme reflejado en mi avatar

* Dado un personaje cuando se va a crear entonces se le eligen casta y raza.


##Aumentar experiencia
Como jugador, quiero eliminar enemigos para aumentar mi experiencia

* Dado un personaje cuando gana una batalla contra un equipo enemigo npc entonces gana experiencia.

##Subir de nivel
Como jugador, quiero acumular experiencia para poder subir de nivel

* Dado un personaje cuando gane la suficiente experiencia entonces sube de nivel.


##Asignar puntos adicionales a los estados
Como jugador, quiero subir de nivel para poder asignar puntos adicionales a mis estados



##Manipular items
Como jugador, quiero   manipular ítems para dañar a mis oponentes y asi aumentar mis habilidades.
//ver.

##Equipar items
Como jugador, quiero equipar ítems para aumentar mis estados y asi aumentar mis habilidades.

* Dado un personaje cuando equipe un item, sus estados se modifican entonces sus habilidades se ven afectadas.

##Estados para subir ataque, magia y defensa
Como jugador, quiero disponer de estados de destreza, fuerza, intelecto y vitalidad para afectar a mis puntos de ataque, salud y energia.

* Dado un personaje cuando suba los estados entonces se incrementan los puntos de ataque, salud o energia dependiendo del estado elegido.

##Aliarse o combatir contra otros jugadores
Como jugador, quiero encontrarme con otros jugadores en el mismo mundo para aliarme a ellos o combatir contra ellos

* Dado dos jugadores cuando se encuentren entonces tienen la opción de aliarse o batallar entre ellos

##Aumentar experiencia al aliarme con otro jugador
Como jugador, quiero aliarme con otro jugador para combatir junto a él y aumentar la experiencia que recolectamos en ese tiempo

* Dado un jugador cuando forma una alianza con otro entonces ambos reciben mas experiencia que la usual
* Dado dos personajes cuando estan aliados entonces no pueden romper la alianza hasta que no pase un determinado tiempo


##Obtener items al derrotar jugadores //VER
Como jugador, quiero combatir contra otros jugadores para obtener sus ítems al derrotarlos

* Al derrotar a un jugador debo poder recoger un ítem que tuviese equipado
* Al derrotar a un jugador que no tenga ítems no debo poder recoger ninguno

##Disolver o renovar alianza
Como jugador, quiero cambiar las alianzas establecidas cada cierta cantidad de tiempo para poder traicionar a mis aliados

* Dada una alianza cuando pase una determinada cantidad de tiempo entonces la misma se disuelve 

#Obstaculos
Como jugador, quiero que haya obstaculos en el mapa para reestringir mi paso

* Dado un obstaculo cuando me desplaze por el mapa entonces no puedo pasar sobre el.

##Aprender habilidades
Como jugador, quiero aprender habilidades para usarlas en el combate contra enemigos

* Dada una batalla entre jugadores cuando sea el turno de uno de atacar entonces elige que habilidad usar


##Adquirir items al derrotar enemigos
Como jugador, quiero poder derrotar a un enemigo para conseguir ítems 

* Dada una batalla entre dos jugadores cuando uno gane entonces puede recoger un item del jugador derrotado


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
