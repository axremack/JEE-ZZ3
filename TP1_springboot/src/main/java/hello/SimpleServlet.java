package hello;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/simple/*", loadOnStartup = 1)
public class SimpleServlet extends HttpServlet   {
    private static final long serialVersionUID = 1L;
    //private static int cpt = 0;

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{
        doGet(request,response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //cpt ++;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Hello chers ZZ3!");

        String res = request.getParameter("texte");
        out.println(res);

        //out.println(cpt);

    }
}
