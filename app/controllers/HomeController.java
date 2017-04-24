package controllers;

import controllers.*;
import models.users.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import play.api.Environment;
import java.util.ArrayList;
import java.util.List;
import models.products.*;


import views.html.*;

import play.db.ebean.Transactional;

import javax.inject.Inject;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private FormFactory formFactory;

    /** http://stackoverflow.com/a/37024198 **/
    private play.api.Environment env;

    /** http://stackoverflow.com/a/10159220/6322856 **/
    @Inject
    public HomeController(Environment e, FormFactory f) {
        this.env = e;
        this.formFactory = f;
    }
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */

    //Method Returns looged in useer (or null)
    private User getUserFormSession(){
        return User.getLoggedIn(session().get("email"));
    }



    // public Result kits() {
    //         return ok(kits.render(getUserFormSession()));
    //     }

    // public Result training() {
    //         return ok(training.render(getUserFormSession()));
    //     }

    //  public Result clothes() {
    //         return ok(clothes.render(getUserFormSession()));
    //     }

    //   public Result accessories() {
    //         return ok(accessories.render(getUserFormSession()));
    //     }


    // Delete Product
//    @Transactional
//    public Result deleteProduct(Long id) {
//        // Call delete method
//        Product.find.ref(id).delete();
//        // Add message to flash session
//        flash("success", "Product has been deleted");
//        // Redirect home
//        return redirect(controllers.routes.HomeController.accessories());
//    }

    @Transactional
    public Result boots(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(boots.render(env, categories, products, cat, filter, getUserFormSession()));
    }





    @Transactional
    public Result clothes(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(clothes.render(env, categories, products, cat, filter, getUserFormSession()));
    }


    public Result Register() {
        Form<User> addUsersForm = formFactory.form(User.class);

        return ok(signup.render(addUsersForm));
    }

    @Transactional
    public Result signupSubmit() {

        Form<User> newUsersForm = formFactory.form(User.class).bindFromRequest();

        if (newUsersForm.hasErrors()) {
            return badRequest(signup.render(newUsersForm));
        }

        User newUser = newUsersForm.get();

        newUser.save();

        flash("success", "Account " + newUser.getName() + " has been created");

        return redirect(controllers.routes.HomeController.Register());
    }


    public Result service() {
        return ok(service.render());
    }

    @Transactional
    public Result home(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(home.render(env, categories, products, cat, filter, getUserFormSession()));
    }

    @Transactional
    public Result footballs(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(footballs.render(env, categories, products, cat, filter, getUserFormSession()));
    }

    @Transactional
    public Result training(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(training.render(env, categories, products, cat, filter, getUserFormSession()));
    }
    @Transactional
    public Result accessories(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(accessories.render(env, categories, products, cat, filter, getUserFormSession()));
    }






    @Transactional
    public Result kits(Long cat, String filter) {
        // Get list of all categories in ascending order
        List<Category> categories = Category.findAll();
        // Instantiate products, an Array list of products
        List<Product> products = new ArrayList<Product>();

        if (cat == 0) {
            // Get the list of ALL products with filter
            products = Product.findAll(filter);
        }
        else {
            // Get products for the selected category and filter (search field)
            products = Product.findFilter(cat, filter);
        }
        // Render the list products view, passing parameters
        // categories and products lists
        // category id - used for filtering
        // the filter string - this will be displayed in the filter text input
        // current user - if one is logged in
        return ok(kits.render(env, categories, products, cat, filter, getUserFormSession()));
    }
}

