package dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import domain.LunchDomain;

public class LunchDAO {
	
	private static LunchDAO l_dao;
	
	public static LunchDAO getInstance() {
		if (l_dao == null) {
			l_dao = new LunchDAO();
		}
		
		return l_dao;
	}
	
	public synchronized SqlSessionFactory getSessionFactory() throws IOException {
		
		Reader r = Resources.getResourceAsReader("dao/mybatis_config.xml");
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		SqlSessionFactory ssf = ssfb.build(r);
		
		return ssf;
	}
	
	public int selectTotal() throws IOException {
		int totalCnt = 0;
		
		SqlSession ss = LunchDAO.getInstance().getSessionFactory().openSession();
		totalCnt = ss.selectOne("selectTotalCnt");
		ss.close();
		
		return totalCnt;
	}
	
	public LunchDomain selectLunchMenu(int idx) throws IOException {
		LunchDomain ld = null;
		
		SqlSession ss = LunchDAO.getInstance().getSessionFactory().openSession();
		ld = ss.selectOne("selectLunch", idx);
		ss.close();
		
		return ld;
	}
	
	public static void main(String[] args) {
		LunchDAO l_dao = LunchDAO.getInstance();
		try {
			int total = l_dao.selectTotal();
			/*for(int i=0; i<5; i++) {
				System.out.println(new Random().nextInt(total)+1);
			}*/
			System.out.println(l_dao.selectLunchMenu(2));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
