<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: 12468
  Date: 2021/11/24
  Time: 22:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <%
      Person person = new Person();
      person.setName("李超");
      person.setPhone(new String[]{"15755135890", "15755135891", "15755135892"});

      ArrayList<String> cities = new ArrayList<>();
      cities.add("北京");
      cities.add("上海");
      cities.add("南京");
      person.setCities(cities);

      HashMap<String, Object> map = new HashMap<>();
      map.put("key1", "value1");
      map.put("key2", "value2");
      map.put("key3", "value3");
      person.setMap(map);

      pageContext.setAttribute("person", person);
  %>

输出Person：${person} <br />
输出Person的name属性值： ${person.name} <br />
输出Person的phone数组属性值： ${person.phone[0]} <br />
输出Person的List属性值： ${person.cities} <br />
输出Person的List属性中的某一项值： ${person.cities[1]} <br />
输出Person的map属性中的值： ${person.map} <br />
输出Person的map属性中的某一项值： ${person.map.key1} <br />

</body>
</html>
