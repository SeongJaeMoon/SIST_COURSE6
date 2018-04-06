package com.test;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServlet extends HttpServlet {


	// <Ŀ�ǵ�, �ڵ鷯�ν��Ͻ�> ���� ���� ����
	private Map<String, CommandHandler> commandHandlerMap = new HashMap<>();

	@Override
	public void init() throws ServletException {
		String configFile = getInitParameter("configFile");
		Properties prop = new Properties();
		String configFilePath = getServletContext().getRealPath(configFile);
		try (FileReader fis = new FileReader(configFilePath)) {
			prop.load(fis);
		} catch (IOException e) {
			throw new ServletException(e);
		}
		Iterator<Object> keyIter = prop.keySet().iterator();
		while (keyIter.hasNext()) {
			String command = (String) keyIter.next();
			String handlerClassName = prop.getProperty(command);
			try {
				Class<?> handlerClass = Class.forName(handlerClassName);
				CommandHandler handlerInstance = (CommandHandler) handlerClass.newInstance();
				this.commandHandlerMap.put(command, handlerInstance);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				throw new ServletException(e);
			}
		}
	}

	// 1�ܰ�. ����� ��û ����
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����� ���� �޼ҵ�
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ����� ���� �޼ҵ�
		process(req, resp);
	}

	private void process(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 2�ܰ�. ��û �м�
		// ->��û URI + ������Ƽ(*.properties) ��� �ּ� �м�
		String uri = request.getRequestURI();
		if (uri.indexOf(request.getContextPath()) == 0) {
			uri = uri.substring(request.getContextPath().length());
		}

		// 3�ܰ�. ���� ����Ͽ� ��û�� ��� ���� -> ���
		CommandHandler handler = this.commandHandlerMap.get(uri);
		String viewPage = handler.process(request, response);

		// 5�ܰ�. 
		// ��(*.jsp)�� ������ -> RequestDispatcher
		// �Ǵ� �����̷�Ʈ -> response.sendRedirect() 
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
