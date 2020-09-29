package objectstructures;

//1-1 association 
public class Partner {
	private String name; //the name of partner
	private Partner partner; //a partner
	
	//Constructor
	public Partner(String name) {
		this.name = name;
	}
	
	//Returns the name
	public String getName() {
		return name;
	}
	
	//Returns the partner 
	public Partner getPartner() {
		return partner;
	}

	public String toString() {
		return this.name + " partner: " + this.partner;
	}
	//Sets partner
	public void setPartner(Partner partner) {
		if (this.partner == partner) {
			return;
		}
		Partner oldPartner = this.partner;
		this.partner = partner;
		
		if (oldPartner != null && oldPartner.getPartner() == this) {
			oldPartner.setPartner(null);
		}
		if (this.partner != null) {
			this.partner.setPartner(this);
		}
	}

}
	
	

	

