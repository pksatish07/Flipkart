package org.iiitb.flipkart.userdetails;

import java.util.List;



public interface MyAccountDao {
	public void ChangePassword(String email,String newpassword);
	public void UpdateEmail(String email,String newemailid);
	public void deactivateAccount(String email,String password);
	public List<AddressInfo> getAddress(String mail);
}
