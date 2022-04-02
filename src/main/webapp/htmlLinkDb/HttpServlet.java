public class barServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		barDao bardao = new barDao();
	    ArrayList<barBean> array = bardao.select_all();
		ObjectMapper mapper = new ObjectMapper();    //提供java-json相互转换功能的类
        String json = mapper.writeValueAsString(array);//将list中的对象转换为Json格式的数组
        System.out.println(json);
        //将json数据返回给客户端
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().write(json);    
	}

}
