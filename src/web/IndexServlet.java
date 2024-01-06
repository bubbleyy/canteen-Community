package web;

import dao.CommunityListDao;
import dao.MenuListDao;
import dao.StListDao;
import dao.UserListDao;
import dao.impl.CommunityListDaoimpI;
import dao.impl.MenuListDaoimpI;
import dao.impl.StListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.User;
import domain.community;
import domain.communitylist;
import domain.communitypinglun;
import domain.st;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
 * 首页
 */

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        StListDao dao = new StListDaoimpI();

        List<st> sts = dao.findallst();
        List<List<String>> stpictures = new ArrayList<>();

        for (int i =0;i<sts.size() ;i++ ){
            if (sts.get(i).getPictures().length() != 0){
                List<String> itempicture =   JSONArray.fromObject(sts.get(i).getPictures());
                stpictures.add(itempicture);
            }else {
                List<String> itempicture = new ArrayList<>();
                stpictures.add(itempicture);
            }

        }




        CommunityListDao dao2 = new CommunityListDaoimpI();

        List<community> communities = dao2.findallcommunities();

        UserListDao dao3 = new UserListDaoimpl();

        List<communitylist> communitylist  = new ArrayList<>();

        for (int i =0;i<communities.size();i++){

            User user = dao3.findisuser(communities.get(i).getUser_username());

            List<communitypinglun> communitypingluns = dao2.findcommunitypinglun(communities.get(i).getId());

            List<List<String>> communityitempictures = new ArrayList<>();
            for (int j = 0 ;j<communitypingluns.size();j++){
                List<String> itemlist = JSONArray.fromObject(communitypingluns.get(j).getPictures());
                communityitempictures.add(itemlist);
            }

            List<String> communitypictures = JSONArray.fromObject(communities.get(i).getPictures());

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

        request.setAttribute("sts",sts);
        request.setAttribute("stpictures",stpictures);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);

    }
}
