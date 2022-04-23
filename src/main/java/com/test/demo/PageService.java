package com.test.demo;

public class PageService {

	public static pageBean searchPage(int rows, int currentPage) {
		pageBean pb = new pageBean();
		pb.setRows(rows);
		pb.setCurrentPage(currentPage);
		MyDAO md = new MyDAO();
		
		pb.setList(md.findPage(rows, currentPage));
		pb.setTotalCount(MyDAO.get_apk_count());

		if ((MyDAO.get_apk_count() % rows) == 0) {
			pb.setTotalPage(MyDAO.get_apk_count() / rows);
		} else {
			pb.setTotalPage((MyDAO.get_apk_count() / rows) + 1);
		}
		return pb;
	}

}
