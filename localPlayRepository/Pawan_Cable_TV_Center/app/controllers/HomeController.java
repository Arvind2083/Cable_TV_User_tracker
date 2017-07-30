package controllers;

import javax.inject.Inject;

import domain.Customer;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.home.createCustomer;
import views.html.home.showCustomer;
import views.html.home.home;
import views.html.home.update;

/**
 * This controller contains an action to handle HTTP requests to the
 * application's home page.
 */
public class HomeController extends Controller {
	
	private final FormFactory formFactory;
	
	@Inject
    public HomeController(final FormFactory formFactory) {
        this.formFactory = formFactory;
    }

	/**
	 * An action that renders an HTML page with a welcome message. The
	 * configuration in the <code>routes</code> file means that this method will
	 * be called when the application receives a <code>GET</code> request with a
	 * path of <code>/</code>.
	 */
	public Result showAll() {

		return ok(home.render(Customer.showAll()));
	}

	public Result createCustomer() {

		Form<Customer> customerForm = formFactory.form(Customer.class);
	
		return ok(createCustomer.render(customerForm));
	}

	public Result save() {
         
		Form<Customer> customerForm = formFactory.form(Customer.class).bindFromRequest();
		
		Customer customer =customerForm.get();
	    System.out.println("Hello");
	    Customer.addCustomer(customer);
		return redirect(routes.HomeController.showAll());
	}
	
	public Result delete(int customerId) { 

		Customer.delete(customerId);
		System.out.println("delete");
		return redirect(routes.HomeController.showAll());
	}

	public Result update(int customerId) { 

		Form<Customer> customerForm = formFactory.form(Customer.class).fill(Customer.showCustomerDetails(customerId));
		return ok(update.render(customerForm));
	}

	public Result updateData() {
        
		Form<Customer> customerForm = formFactory.form(Customer.class).bindFromRequest();
		
		Customer customer =customerForm.get();
	    Customer.updateData(customer);
		return redirect(routes.HomeController.showAll());
	}
	
	public Result showCustomer(int customerId) {

		return ok(showCustomer.render(Customer.showCustomerDetails(customerId)));
	}
	
}