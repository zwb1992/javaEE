package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zwb on 17/3/22.
 * 验证servlet路径问题
 */
@WebServlet(name = "PathServlet")
public class PathServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //当前项目路径=/day04_servlet_path
        System.out.print("成功进入servlet"+request.getContextPath());
        //使用相对路径   /day04_servlet_path/next.jsp
//        request.getRequestDispatcher("next.jsp").forward(request,response);
        //使用根目录   /day04_servlet_path/next.jsp
//        request.getRequestDispatcher("/next.jsp").forward(request,response);
        //退到上一级目录，再请求--失败
//        request.getRequestDispatcher("../next.jsp").forward(request,response);


        //http://localhost:8080/day04_servlet_path/next.jsp
        response.sendRedirect("next.jsp");

        //http://localhost:8080/next.jsp
//        response.sendRedirect("/next.jsp");

        //http://localhost:8080/next.jsp
//        response.sendRedirect("../next.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
