/**
 * 
 */
package domain;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Arvind
 *
 */
public class Customer{

	public String customerName;
	public int customerId;
	public boolean billPayed;

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public boolean isBillPayed() {
		return billPayed;
	}

	public void setBillPayed(boolean billPayed) {
		this.billPayed = billPayed;
	}

	public Customer() {
	}

	public Customer(int customerId, String customerName, boolean billPayed) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.billPayed = billPayed;
	}

	static List<Customer> customerDetails = new CopyOnWriteArrayList<Customer>();
	static {

		customerDetails.add(new Customer(1, "Arvind", true));
		customerDetails.add(new Customer(2, "Pawan", false));
	}

	public static List<Customer> showAll() {
		return customerDetails;
	}

	public static void addCustomer(Customer customer) {

		customerDetails.add(new Customer(customer.customerId, customer.customerName, customer.billPayed));
	}

	public static void delete(int customerId) {
		for (Customer customer : customerDetails) {
			if (customer.getCustomerId() == customerId) {
				customerDetails.remove(customer);
			}
		}

	}

	public static Customer showCustomerDetails(int customerId) {
		for (Customer customer : customerDetails) {
			if (customer.getCustomerId() == customerId) {
				return customer;
			}
		}
		return null;
	}

	public static void updateData(Customer customer) {
		for (Customer cust : customerDetails) {
			if (cust.getCustomerId() == customer.getCustomerId() || cust.getCustomerName() == customer.getCustomerName()) {
				customerDetails.remove(cust);
				customerDetails.add(customer);
			}
		}
	}

}