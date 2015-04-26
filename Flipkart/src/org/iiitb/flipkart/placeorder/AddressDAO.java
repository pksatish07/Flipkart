package org.iiitb.flipkart.placeorder;

import java.util.List;

public interface AddressDAO {
	public List<AddressVO> getAddressList(String Email);

}
