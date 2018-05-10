package com.sboot.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sboot.model.Customer;
import com.sboot.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerRepo crepo;

	Iterable<Customer> customerList = new ArrayList<Customer>();

	/*
	 * 
	 * 
	 * */
	@Override
	public List<Customer> viewAllCustomer() {
		// TODO find all customers

		return (List<Customer>) crepo.findAll();
	}

	/*
	 * taking customer objects to add in url
	 * 
	 */
	@Override
	public String addCustomers(List<Customer> customer) {
		// TODO Auto-generated method stub
		String string = "";
		Optional<Customer> id = null;

		List<Customer> failedAddCustomers = new ArrayList<Customer>();

		for (Customer c : customer) {
			try {
				id = crepo.findById(c.getCustomerId());

				if (id.isPresent() && c.getCustomerId() != null && c.getCustomerAddress() != null
						&& c.getCustomerName() != null && c.getOperation() != null) {

					c.setOperation(false);
					failedAddCustomers.add(c);

				} else {
					try {
						c.setOperation(true);
						crepo.save(c);
					} catch (Exception e) {
						string = e.getMessage();
					}
				}

			} catch (Exception e) {
				string = e.getMessage();
			}

		}

		if (failedAddCustomers.isEmpty()) {
			string = "Customers added succesfully!";
		} else {
			int size = failedAddCustomers.size();
			int fac[] = new int[size];
			int i = 0;
			for (Customer x : failedAddCustomers) {
				fac[i] = x.getCustomerId();
				i++;
			}
			String facstr = Arrays.toString(fac);
			string = facstr + " Customers can not be added!";
		}

		return string;

	}

	/*
	 * taking ids to remove
	 * 
	 */
	@Override
	public String removeCustomers(List<Integer> id) {
		// TODO Auto-generated method stub

		// crepo.deleteById(cid);

		String string = "";
		List<Integer> failedRemoveCustomers = new ArrayList<Integer>();
		int count = id.size();

		Iterable<Customer> customerlist = new ArrayList<Customer>();

		customerlist = crepo.findAll();
		int t = 0;
		for (Integer c : id) {
			for (Customer cu : customerlist) {
				if (c == cu.getCustomerId()) {
					try {
						crepo.deleteById(c);
					} catch (Exception e) {
						string = e.getMessage();
					}

				}
				t++;

				if (t == count) {
					failedRemoveCustomers.add(c);
				}
			}
		}

		if (failedRemoveCustomers.isEmpty()) {
			string = " Customers removed succesfully!";
		} else {
			int size = failedRemoveCustomers.size();
			int fac[] = new int[size];
			int i = 0;
			for (Integer x : failedRemoveCustomers) {
				fac[i] = x;
				i++;
			}
			String facstr = Arrays.toString(fac);
			string = " failed to remove Customers!" + facstr;
		}

		return string;

	}

	@Override
	public String updateCustomers(List<Customer> customer) {
		// TODO Auto-generated method stub

		String string = "";

		List<Customer> failedUpdateCustomers = new ArrayList<Customer>();

		for (Customer c : customer) {
			try
			{
			Optional<Customer> id = crepo.findById(c.getCustomerId());

			if (id.isPresent() && c.getCustomerId() != null && c.getCustomerAddress() != null
					&& c.getCustomerName() != null && c.getOperation() != null) {

				c.setOperation(false);
				failedUpdateCustomers.add(c);

			} else {
				c.setOperation(true);
				crepo.save(c);
			}
			}
			catch(Exception e)
			{
				string=e.getMessage();
			}
		}

		if (failedUpdateCustomers.isEmpty()) {
			string = "Customers updated succesfully!";
		} else {
			int size = failedUpdateCustomers.size();
			int fac[] = new int[size];
			int i = 0;
			for (Customer x : failedUpdateCustomers) {
				fac[i] = x.getCustomerId();
				i++;
			}
			String facstr = Arrays.toString(fac);
			string = facstr + " Customers can not be updated!";
		}

		return string;

	}

}
