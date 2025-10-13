package dev.matheuscruz;

import io.quarkiverse.renarde.Controller;
import io.quarkus.logging.Log;
import io.quarkus.qute.CheckedTemplate;
import io.quarkus.qute.TemplateInstance;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import org.jboss.resteasy.reactive.RestForm;

public class Login extends Controller {

    @CheckedTemplate
    public static class Templates {
        public static native TemplateInstance login();

        public static native TemplateInstance home(String username);
    }

    @POST
    public TemplateInstance login(LoginForm form) {

        User user = User.find("username", form.getUsername()).firstResult();

        if (user == null) {
            Log.warn("User not found: " + form.getUsername());
            flash("loginError", "Bad credentials");
            return redirect(Login.class).loginPage();
        }

        if (user.getPassword().equals(form.getPassword())) {
            flash("username", form.getUsername());
            return redirect(Login.class).homePage(form.getUsername());
        } else {
            Log.warn("Invalid password for user: " + form.getUsername());
            flash("loginError", "Bad credentials");
            return redirect(Login.class).loginPage();
        }
    }

    @GET
    @Produces("text/html")
    @Path("/")
    public TemplateInstance loginPage() {
        return Templates.login();
    }

    @GET
    @Produces("text/html")
    @Path("/home")
    public TemplateInstance homePage(String username) {
        return Templates.home(username);
    }

    public static class LoginForm {
        @RestForm
        String username;
        @RestForm
        String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }

        @Override
        public String toString() {
            return "LoginForm{" +
                    "username='" + username + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
