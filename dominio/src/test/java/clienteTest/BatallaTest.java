package clienteTest;

import org.junit.Assert;
import org.junit.Test;

import batalla.Batalla;
import batalla.EquipoJugadores;


@SuppressWarnings("unused") // Banca un cacho que braian trabaja.
public class BatallaTest {
	
	@Test
	public void batallaJugadorContraJugador(){
		EquipoJugadores b3DR = new EquipoJugadores("3DRealms");
		EquipoJugadores bPS = new EquipoJugadores("Promotion System");
		Batalla batalla = new Batalla(b3DR,bPS);

	}
}
