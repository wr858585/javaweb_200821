<%@ page import="com.atguigu.pojo.Person" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
        Person person = new Person();

        person.setId(100);

        person.setCities(new String[]{"北京","上海","广州","深圳"});

        List<String> phones = new ArrayList<>();
        phones.add("18666669999");
        phones.add("13988886666");
        phones.add("18610541354");
        person.setPhones(phones);

        Map<String,Object> map = new HashMap<>();
        map.put("girl1","迪丽热巴");
        map.put("girl2","古丽娜扎");
        map.put("girl3","阿丽");
        person.setMap(map);

        request.setAttribute("p",person);
    %>
    输出整个 person 对象：${p} <br>
    输出 person.id 对象：${p.id} <br>
    输出 person.cities[0] 对象：${p.cities[0]} <br>
    输出 person.cities[1] 对象：${p.cities[1]} <br>
    输出 person.cities[2] 对象：${p.cities[2]} <br>
    输出 person.cities[3] 对象：${p.cities[3]} <br>
    输出 person.phones 对象：${p.phones} <br>
    输出 person.phones[0] 对象：${p.phones[0] } <br>
    输出 person.phones[1] 对象：${p.phones[1] } <br>
    输出 person.phones[2] 对象：${p.phones[2] } <br>
    输出 person.map 对象：${p.map} <br>
    输出 person.map.girl1 对象：${p.map.girl1} <br>
    输出 person.map.girl2 对象：${p.map.girl2} <br>
    输出 person.map.girl3 对象：${p.map.girl3} <br>
    输出 person.age 对象：${p.age} <br>
</body>
</html>
