package itemEquipo;

import item.ItemEquipo;

public class EscudoSvalinn extends ItemEquipo {


	public EscudoSvalinn() {
		defensaFisica = 10;
		defensaMagica = 5;
		this.descripcion = "Escudo Svalinn\nSvalin se llama el escudo,\nque se halla ante S�l,\nla refulgente deidad:\nrocas y oc�ano deben,\nser quemados,\nsi cayera de su lugar.";
	}
	
	@Override
	public String toString() {
		return "armaIzq";
	}
}
