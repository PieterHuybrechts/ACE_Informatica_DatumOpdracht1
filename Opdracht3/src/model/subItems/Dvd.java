package model.subItems;

import java.math.BigDecimal;
import common.enums.EnumTypeDvd;

/**
 * 
 * @author Vervoort Peter
 *
 */

public class Dvd extends model.Item {

	private static final long serialVersionUID = -4229997050252388319L;
	private EnumTypeDvd dvdType;
	
	public EnumTypeDvd getDvdType() {
		return dvdType;
	}

	public void setDvdType(EnumTypeDvd dvdTtype) {
		this.dvdType = dvdTtype;
	}
	
	public Dvd(String titel, BigDecimal verhuurPrijsInEuro, Double verhuurPrijsPerDag, EnumTypeDvd type) {
		super(titel, verhuurPrijsInEuro, verhuurPrijsPerDag);
		setDvdType(type);	
	}
	
	public Dvd() {
		super();
		setDvdType(EnumTypeDvd.values()[0]);
	}
	
	@Override
	public String toString() {
		return "Dvd [dvdType=" + dvdType + ", " + super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dvdType == null) ? 0 : dvdType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dvd other = (Dvd) obj;
		if (dvdType != other.dvdType)
			return false;
		return true;
	}
	
}
