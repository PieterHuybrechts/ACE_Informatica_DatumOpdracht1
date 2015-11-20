/**
 * 
 */
package model;

import java.math.BigDecimal;
import java.util.Date;

import common.enums.EnumTypeCd;
import common.enums.EnumTypeDvd;

/**
 * @author Peter
 *
 */
public class Dvd extends Item {

	private EnumTypeDvd dvdType;
	
	public EnumTypeDvd getDvdType() {
		return dvdType;
	}

	public void setDvdType(EnumTypeDvd dvdTtype) {
		this.dvdType = dvdTtype;
	}
	
	public Dvd(String titel, BigDecimal verhuurPrijsInEuro, Date beginVerhuurDatum, int verhuurPeriodeInDagen,
			Double verhuurPrijsPerDag, EnumTypeDvd type) {
		super(titel, verhuurPrijsInEuro, beginVerhuurDatum, verhuurPeriodeInDagen, verhuurPrijsPerDag);
		this.setDvdType(type);	
	}
}
