package web.user.community;

import dao.CommunityListDao;
import dao.UserListDao;
import dao.impl.CommunityListDaoimpI;
import dao.impl.UserListDaoimpl;
import domain.*;
import domain.login.loginuser;
import net.sf.json.JSONArray;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 社区信息详情
 */

@WebServlet("/UserCommunityDetailServlet")
public class UserCommunityDetailServlet extends HttpServlet {
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


//        获取点赞数据
        var price = false;

        if (request.getSession().getAttribute("logintype").equals("师生用户")){
            loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");
            communityprice communityprice = dao.findcommunityprice(id,loginuser.getUsername());
            if (communityprice !=null){
                price = true;
            }
        }






        request.setAttribute("communitylist",communitylist);
        request.setAttribute("price",price);
        request.getRequestDispatcher("user/usercommunity/communitydetail.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("UTF-8");


        loginuser loginuser = (domain.login.loginuser) request.getSession().getAttribute("loginuser");

        boolean mutipartContent = ServletFileUpload.isMultipartContent(request);

        if (!mutipartContent){

            response.getWriter().print("系统错误，添加失败");
            throw new RuntimeException("不是上传的类型");

        }


        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");

        communitypinglun communitypinglun = new communitypinglun();

        List<String> pictures = new ArrayList<>();

        try {
            List<FileItem> items = upload.parseRequest(request);

            for (FileItem item : items){

                if (item.isFormField()) {

                    String name = item.getFieldName();
                    String string = item.getString("utf-8");
                    if (name.equals("id")){

                        communitypinglun.setCommunity_id(Integer.parseInt(string));
                    }else if (name.equals("maintext")){
                        communitypinglun.setMaintext(string);
                    }
                }else {

                    System.out.println("扫到图片路径");

                    String filename = item.getName();
                    System.out.println("我的文件名字"+filename);
                    if (filename.length()==0 || filename.trim().equals("")){

                        continue;
                    }

                    String imgpath = "upload/";

                    String timestamp = Long.toString(System.currentTimeMillis());
                    String realPath =  this.getServletContext().getRealPath("/upload");

//                    判断上传路径存不存在

                    File file = new File(realPath);

                    if (!file.exists()){
                        file.mkdir();
                    }

                    item.write(new File(file,timestamp +filename));

                    String imgsrc = imgpath+timestamp +filename;

                    System.out.println("上传文件"+imgsrc);
                    pictures.add(imgsrc);

                }


            }


            communitypinglun.setPictures(JSONArray.fromObject(pictures).toString());
            communitypinglun.setCreatetime();
            communitypinglun.setUser_username(loginuser.getUsername());
            communitypinglun.setStatus("未读");

            System.out.println("添加社区评论"+communitypinglun);

            CommunityListDao dao = new CommunityListDaoimpI();

            dao.addcommunitypinglun(communitypinglun);

            response.sendRedirect("UserCommunityDetailServlet?id="+ communitypinglun.getCommunity_id());




        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }



    }
}
