package web.admin.Acommunity;

import dao.CommunityListDao;
import dao.UserListDao;
import dao.impl.CommunityListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.User;
import domain.community;
import domain.communitylist;
import domain.communitypinglun;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 管理员端社区信息详情
 */

@WebServlet("/AcommunitydetailServlet")
public class AcommunitydetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String id = request.getParameter("id");

        CommunityListDao dao = new CommunityListDaoimpI();

        community community = dao.findonlycommunity(id);

        UserListDao dao1 = new UserListDaoimpl();

        communitylist communitylist  = new communitylist();



        User user = dao1.findisuser(community.getUser_username());

        List<communitypinglun> communitypingluns = dao.findcommunitypinglun(community.getId());

        List<List<String>> communityitempictures = new ArrayList<>();
        for (var j = 0 ;j<communitypingluns.size();j++){
            List<String> itemlist = JSONArray.fromObject(communitypingluns.get(j).getPictures());
            communityitempictures.add(itemlist);
        }

        List<String> communitypictures = JSONArray.fromObject(community.getPictures());

        communitylist.setCommunity(community);
        communitylist.setUser(user);
        communitylist.setCommunitypinglun(communitypingluns);
        communitylist.setCommunitypictures(communitypictures);
        communitylist.setCommunityitempictures(communityitempictures);









        request.setAttribute("communitylist",communitylist);
        request.getRequestDispatcher("admin/acommunity/acommunitydetail.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}
