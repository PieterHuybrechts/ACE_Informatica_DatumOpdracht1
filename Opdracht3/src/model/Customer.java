/**
 * 
 */
package model;

import common.AntiMagicStrings;

/**
 * A customer's details, including name, address, e-mail and an unique ID.
 * 
 * @author Andre
 *
 */
public class Customer {
	
	private Person person;
	private Address address;
	private String email;
	private boolean spam = false;
	private AntiMagicStrings magicString;
	
	public Customer(Person person, Address address, String email) throws Exception{
		try{
			setPerson(person);
			setAddress(address);
			setEmail(email);
		}
		catch (Exception e){
			throw e;
		}
	}
	
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getSpam(){
		return spam;
	}
	public void setSpam(boolean bool){
		this.spam = bool;
	}
}