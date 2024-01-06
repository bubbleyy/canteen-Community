package web.user.community;

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
 * 用户社区列表
 */

@WebServlet("/UserCommunityServlet")
public class UserCommunityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        CommunityListDao dao = new CommunityListDaoimpI();

        List<community> communities = dao.findallcommunities();

        UserListDao dao1 = new UserListDaoimpl();

        List<communitylist> communitylist  = new ArrayList<>();

        for (int i =0;i<communities.size();i++){

            User user = dao1.findisuser(communities.get(i).getUser_username());

            List<communitypinglun> communitypingluns = dao.findcommunitypinglun(communities.get(i).getId());

            List<List<String>> communityitempictures = new ArrayList<>();
            for (int j = 0 ;j<communitypingluns.size();j++){
                List<String> itemlist = JSONArray.fromObject(communitypingluns.get(j).getPictures());
                communityitempictures.add(itemlist);
            }

            List<String> communitypictures = JSONArray.fromObject(communities.get(i).getPictures());
            if (communitypictures != null){
                System.out.println(communitypictures);
                System.out.println("返回true");
            }else {
                System.out.println(communitypictures);
                System.out.println("返回false");
            }
            communitylist list = new communitylist();
            list.setCommunity(communities.get(i));
            list.setUser(user);
            list.setCommunitypinglun(communitypingluns);
            list.setCommunitypictures(communitypictures);
            list.setCommunityitempictures(communityitempictures);
            communitylist.add(list);
        }

        System.out.println("最后展示"+communitylist);



        request.setAttribute("communitylist",communitylist);
        request.getRequestDispatcher("user/usercommunity/community.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
