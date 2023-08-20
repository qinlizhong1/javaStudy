<%
    /**
     * 操作Reuqest域对象（获取）
     */
    System.out.println("222222222222222");
    String requestAttribute = (String) request.getAttribute("request");
    System.out.println(requestAttribute);
    String pageContextAttribute = (String) pageContext.getAttribute("request", PageContext.REQUEST_SCOPE);
    System.out.println(pageContextAttribute);

    /**
     * 操作Session域对象（获取）
     */
    String pageContextAttribute1 = (String) pageContext.getAttribute("session", PageContext.SESSION_SCOPE);
    System.out.println(pageContextAttribute1);

    /**
     * 操作application域对象（获取）
     */
    String pageContextAttribute2 = (String) pageContext.getAttribute("application", PageContext.APPLICATION_SCOPE);
    System.out.println(pageContextAttribute2);
%>
