package demo.ip;

import com.mysql.jdbc.Driver;
import demo.util.Db;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import static java.lang.System.out;

/**
 * Created by 高伟冬 on 2017/6/10.
 * ip_1702
 * 10:26
 * 星期六
 */
@WebServlet(urlPatterns = "/index")
public class IPServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ip = req.getParameter("ip");

        Connection connection = Db.getConnection();
        ResultSet resultSet = null;

        try {
            if (ip != null) {
                new Driver();
                String url = "jdbc:mysql:///db_ip?user=root&password=password";
                connection = DriverManager.getConnection(url);
                String sql = "SELECT * FROM db_exam.ip WHERE inet_aton(?) BETWEEN inet_aton(min) AND inet_aton(max)";
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1, ip);
                resultSet = preparedStatement.executeQuery();
                resultSet.next();
                out.print(ip + " 的地理位置是：" + resultSet.getString("geo"));
                resultSet.close();
                preparedStatement.close();
                connection.close();
            }
            assert resultSet != null;
            if (resultSet.next()) {
                req.getSession().setAttribute("message", resultSet.getString("geo"));
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            } else {
                req.setAttribute("message", "此IP地址不存在");
                req.getRequestDispatcher("index.jsp").forward(req, resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Db.close(resultSet, connection);
        }
    }
}
