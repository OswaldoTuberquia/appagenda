package co.edu.umb.academia.webservice;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Developer
 */
public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
          // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext();
        dispatcherContext.register(WebConfig.class);

        // Register and map the dispatcher1 servlet
        ServletRegistration.Dynamic dispatcher1 = (ServletRegistration.Dynamic) servletContext.addServlet("dispatcher1", new DispatcherServlet(dispatcherContext));
        dispatcher1.setLoadOnStartup(1);
        dispatcher1.addMapping("/");

        ServletRegistration.Dynamic dispatcher2 = (ServletRegistration.Dynamic) servletContext.addServlet("dispatcher2", new DispatcherServlet(dispatcherContext));
        dispatcher2.setLoadOnStartup(1);
        dispatcher2.addMapping("/agendaws/*");
    }

}
