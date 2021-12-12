package entidades;

public class Inventario {

	private ObjetoPasivo itemPas1;
	private ObjetoPasivo itemPas2;
	private ObjetoPasivo itemPas3;
	private ObjetoPasivo itemPas4;
	
	private ObjetoActivo item1;
	private ObjetoActivo item2;
	private ObjetoActivo item3;
	private ObjetoActivo item4;
	private ObjetoActivo item5;
	
	public Inventario(ObjetoPasivo itemPas1, ObjetoPasivo itemPas2,ObjetoPasivo itemPas3, ObjetoPasivo itemPas4, ObjetoActivo item1, ObjetoActivo item2,
			ObjetoActivo item3, ObjetoActivo item4, ObjetoActivo item5) {
		this.itemPas1 = itemPas1;
		this.itemPas2 = itemPas2;
		this.itemPas3 = itemPas3;
		this.itemPas4 = itemPas4;
		this.item1 = item1;
		this.item2 = item2;
		this.item3 = item3;
		this.item4 = item4;
		this.item5 = item5;
	}

	@Override
	public String toString() {
		
		String inventario = "INVENTARIO:";
		inventario+= "\n\t1_";
		if (itemPas1 != null && itemPas1.isEquipado()) {
			inventario += "[" + itemPas1.getNombre() + "]: " + itemPas1.getDescripcion();
		} else if (itemPas1 != null && !itemPas1.isEquipado()) {
			inventario += itemPas1.getNombre() + ": " + itemPas1.getDescripcion();
		}
		inventario+= "\n\t2_";
		if (itemPas2 != null && itemPas2.isEquipado()) {
			inventario += "[" + itemPas2.getNombre() + "]: " + itemPas2.getDescripcion();
		} else if (itemPas2 != null && !itemPas2.isEquipado()) {
			inventario += itemPas2.getNombre() + ": " + itemPas2.getDescripcion();
		}
		inventario+= "\n\t3_";
		if (itemPas3 != null && itemPas3.isEquipado()) {
			inventario += "[" + itemPas3.getNombre() + "]: " + itemPas3.getDescripcion();
		} else if (itemPas3 != null && !itemPas3.isEquipado()) {
			inventario += itemPas3.getNombre() + ": " + itemPas3.getDescripcion();
		}
		inventario+= "\n\t4_";
		if (itemPas4 != null && itemPas4.isEquipado()) {
			inventario += "[" + itemPas4.getNombre() + "]: " + itemPas4.getDescripcion();
		} else if (itemPas4 != null && !itemPas4.isEquipado()) {
			inventario += itemPas4.getNombre() + ": " + itemPas4.getDescripcion();
		}
		inventario+= "\n\t5_";
		if (item1 != null) {
			inventario += item1.getNombre() +": " + item1.getDescripcion() + "["+ item1.getCantidad() +"]";
		}
		inventario+= "\n\t6_";
		if (item2 != null) {
			inventario +=  item2.getNombre() +": " + item2.getDescripcion() + "["+ item2.getCantidad() +"]";
		}
		inventario+= "\n\t7_";
		if (item3 != null) {
			inventario +=  item3.getNombre() +": " + item3.getDescripcion() + "["+ item3.getCantidad() +"]";
		}
		inventario+= "\n\t8_";
		if (item4 != null) {
			inventario +=  item4.getNombre() +": " + item4.getDescripcion() + "["+ item4.getCantidad() +"]";
		}
		inventario+= "\n\t9_";
		if (item5 != null) {
			inventario +=  item5.getNombre() +": " + item5.getDescripcion() + "["+ item5.getCantidad() +"]";
		}
		
		return inventario;  
							  
							
	}
	
	

	public ObjetoPasivo getItemPas1() {
		return itemPas1;
	}

	public void setItemPas1(ObjetoPasivo itemPas1) {
		this.itemPas1 = itemPas1;
	}

	public ObjetoPasivo getItemPas2() {
		return itemPas2;
	}

	public void setItemPas2(ObjetoPasivo itemPas2) {
		this.itemPas2 = itemPas2;
	}

	public ObjetoActivo getItem1() {
		return item1;
	}

	public void setItem1(ObjetoActivo item1) {
		this.item1 = item1;
	}

	public ObjetoActivo getItem2() {
		return item2;
	}

	public void setItem2(ObjetoActivo item2) {
		this.item2 = item2;
	}

	public ObjetoActivo getItem3() {
		return item3;
	}

	public void setItem3(ObjetoActivo item3) {
		this.item3 = item3;
	}

	public ObjetoActivo getItem4() {
		return item4;
	}

	public void setItem4(ObjetoActivo item4) {
		this.item4 = item4;
	}

	public ObjetoActivo getItem5() {
		return item5;
	}

	public void setItem5(ObjetoActivo item5) {
		this.item5 = item5;
	}

	public ObjetoPasivo getItemPas3() {
		return itemPas3;
	}

	public void setItemPas3(ObjetoPasivo itemPas3) {
		this.itemPas3 = itemPas3;
	}

	public ObjetoPasivo getItemPas4() {
		return itemPas4;
	}

	public void setItemPas4(ObjetoPasivo itemPas4) {
		this.itemPas4 = itemPas4;
	}
		
	
}
