package cn.itcast.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class dowm1Servlet
 */
public class dowm1Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dowm1Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 1 鑾峰緱 鎵�湁鍙傛暟鐨勯敭
		Enumeration<String> en = request.getParameterNames();
		//OutputStream os = response.getOutputStream();
		response.setContentType("UTF-8");
		// 2 閬嶅巻鎵�湁閿�
		String type=request.getParameter("type");
		String string=new String("{\"totalCount\":28,\"currentPage\":1,\"totalPage\":28,\"pageSize\":1,\"list\":[{\"id\":1,\"name\":\"鑱旀兂榛慭");
		//String string=new String("绉﹀皬灏忎竴鐩村埌鐜板湪鎵嶅洖杩囩鏉ワ紝涓嶈嚜瑙夊湴杩滅浜嗘睙闄屼竴浜涳紝鐢熸�涓庝粬鎵笂鍏崇郴锛屽ス鐭ラ亾姹熼檶寰堝己锛屼絾鍦ㄥス鐪嬫潵锛屾睙闄屾渶澶氫節绾у穮宄扮殑瀹炲姏锛岃繖鏍风殑瀹炲姏鍙互纰惧帇鍙跺锛屼絾鎯冲拰闄嗗鐩告瘮鏃犲紓浜庝互鍗靛嚮鐭炽�鍦ㄧЕ灏忓皬鐪嬫潵锛屾睙闄屽凡缁忔槸姝讳汉浜嗭紝閭ｄ箞鍦ㄦ亹鎬栫殑澶╄祴涔熶笉杩囨槸杩囩溂浜戠儫锛屽ス鑷劧鐭ラ亾杩欐椂鍊欒濡備綍閫夋嫨锛岀敋鑷冲ス蹇冮噷杩樻湁浜涚獌鍠滐紝濂硅拷姹傛睙闄岀殑鏃跺�姹熼檶瀵瑰ス鐖辩悊涓嶇悊鐨勶紝鐜板湪鐪嬬潃浠栧懡涓嶄箙鐭ｏ紝绔熸湁涓�鑾悕鐨勫揩鎰熴�"
		//		+"绉﹀皬灏忎竴鐩村埌鐜板湪鎵嶅洖杩囩鏉ワ紝涓嶈嚜瑙夊湴杩滅浜嗘睙闄屼竴浜涳紝鐢熸�涓庝粬鎵笂鍏崇郴锛屽ス鐭ラ亾姹熼檶寰堝己锛屼絾鍦ㄥス鐪嬫潵锛屾睙闄屾渶澶氫節绾у穮宄扮殑瀹炲姏锛岃繖鏍风殑瀹炲姏鍙互纰惧帇鍙跺锛屼絾鎯冲拰闄嗗鐩告瘮鏃犲紓浜庝互鍗靛嚮鐭炽�鍦ㄧЕ灏忓皬鐪嬫潵锛屾睙闄屽凡缁忔槸姝讳汉浜嗭紝閭ｄ箞鍦ㄦ亹鎬栫殑澶╄祴涔熶笉杩囨槸杩囩溂浜戠儫锛屽ス鑷劧鐭ラ亾杩欐椂鍊欒濡備綍閫夋嫨锛岀敋鑷冲ス蹇冮噷杩樻湁浜涚獌鍠滐紝濂硅拷姹傛睙闄岀殑鏃跺�姹熼檶瀵瑰ス鐖辩悊涓嶇悊鐨勶紝鐜板湪鐪嬬潃浠栧懡涓嶄箙鐭ｏ紝绔熸湁涓�鑾悕鐨勫揩鎰熴�"
		//		+"绉﹀皬灏忎竴鐩村埌鐜板湪鎵嶅洖杩囩鏉ワ紝涓嶈嚜瑙夊湴杩滅浜嗘睙闄屼竴浜涳紝鐢熸�涓庝粬鎵笂鍏崇郴锛屽ス鐭ラ亾姹熼檶寰堝己锛屼絾鍦ㄥス鐪嬫潵锛屾睙闄屾渶澶氫節绾у穮宄扮殑瀹炲姏锛岃繖鏍风殑瀹炲姏鍙互纰惧帇鍙跺锛屼絾鎯冲拰闄嗗鐩告瘮鏃犲紓浜庝互鍗靛嚮鐭炽�鍦ㄧЕ灏忓皬鐪嬫潵锛屾睙闄屽凡缁忔槸姝讳汉浜嗭紝閭ｄ箞鍦ㄦ亹鎬栫殑澶╄祴涔熶笉杩囨槸杩囩溂浜戠儫锛屽ス鑷劧鐭ラ亾杩欐椂鍊欒濡備綍閫夋嫨锛岀敋鑷冲ス蹇冮噷杩樻湁浜涚獌鍠滐紝濂硅拷姹傛睙闄岀殑鏃跺�姹熼檶瀵瑰ス鐖辩悊涓嶇悊鐨勶紝鐜板湪鐪嬬潃浠栧懡涓嶄箙鐭ｏ紝绔熸湁涓�鑾悕鐨勫揩鎰熴�"
		//		+"绉﹀皬灏忎竴鐩村埌鐜板湪鎵嶅洖杩囩鏉ワ紝涓嶈嚜瑙夊湴杩滅浜嗘睙闄屼竴浜涳紝鐢熸�涓庝粬鎵笂鍏崇郴锛屽ス鐭ラ亾姹熼檶寰堝己锛屼絾鍦ㄥス鐪嬫潵锛屾睙闄屾渶澶氫節绾у穮宄扮殑瀹炲姏锛岃繖鏍风殑瀹炲姏鍙互纰惧帇鍙跺锛屼絾鎯冲拰闄嗗鐩告瘮鏃犲紓浜庝互鍗靛嚮鐭炽�鍦ㄧЕ灏忓皬鐪嬫潵锛屾睙闄屽凡缁忔槸姝讳汉浜嗭紝閭ｄ箞鍦ㄦ亹鎬栫殑澶╄祴涔熶笉杩囨槸杩囩溂浜戠儫锛屽ス鑷劧鐭ラ亾杩欐椂鍊欒濡備綍閫夋嫨锛岀敋鑷冲ス蹇冮噷杩樻湁浜涚獌鍠滐紝濂硅拷姹傛睙闄岀殑鏃跺�姹熼檶瀵瑰ス鐖辩悊涓嶇悊鐨勶紝鐜板湪鐪嬬潃浠栧懡涓嶄箙鐭ｏ紝绔熸湁涓�鑾悕鐨勫揩鎰熴�");
		response.getWriter().write(string);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
