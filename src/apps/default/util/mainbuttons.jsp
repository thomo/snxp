<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://snipsnap.com/snipsnap" prefix="s" %>

[ <c:choose>
 <c:when test="${snip.name=='start'}"><span class="inactive">start</span></c:when>
 <c:otherwise><a href="<c:url value='../space/start'/>">start</a></c:otherwise>
</c:choose> | <a href="<c:url value='../space/snipsnap-index'/>">index</a> |
<s:check roles="Authenticated">logged in as <a href="<c:url value='../space/${app.user.login}'/>"><c:out value="${app.user.login}"/></a> | <a href="<c:url value='../exec/authenticate?logoff=true'/>">logoff</a></s:check>
<s:check roles="Authenticated" invert="true"><a href="<c:url value='../exec/login.jsp'/>">login</a> or <a href="<c:url value='../exec/register.jsp'/>">register</a></s:check>
<s:check roles="Editor"> | <a href="<c:url value='../exec/post.jsp'/>">post blog</a></s:check>
<c:if test="${app.user.admin}"> | <a href="<c:url value='../manager/'/>">manager</a></c:if> ]
