<%--
  ** weblog post template.
  ** @author Matthias L. Jugel
  ** @version $Id$
  --%>

<%@ taglib uri="http://snipsnap.com/snipsnap" prefix="s" %>
<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<div class="snip-wrapper">
 <div class="snip-title"><h1 class="snip-name">Post To Weblog: <c:out value="${snip.name}"/></h1></div>
 <div class="snip-content">
  <s:check name="${param.snip}" roles="Owner:Editor">
  <c:if test="${not empty preview}">
   <div class="preview"><div class="snip-content"><c:out value="${preview}" escapeXml="false"/></div></div>
  </c:if>
   <form class="form" method="post" action="<c:out value='${app.configuration.path}'/>/exec/storepost" enctype="multipart/form-data">
    <table>
     <tr><td>Title<br><input name="title" value="<c:out value="${title}" escapeXml="false"/>"/></td></tr>
     <tr><td><textarea name="content" type="text" cols="80" rows="20"><c:out value="${content}" escapeXml="true"/></textarea></td></tr>
     <tr><td class="form-buttons">
      <input value="Preview" name="preview" type="submit"/>
      <input value="Post" name="save" type="submit"/>
      <input value="Cancel" name="cancel" type="submit"/>
     </td></tr>
    </table>
    <input name="name" type="hidden" value="<c:out value='${param.name}'/>"/>
    <input name="post" type="hidden" value="weblog"/>
    <input name="referer" type="hidden" value="<%= request.getHeader("REFERER") %>"/>
   </form>
  </s:check>
  <s:check roles="Owner:Editor" invert="true">
   Please <a href="<c:out value='${app.configuration.path}'/>/exec/login.jsp">login!</a> as editor.
  </s:check>
 </div>
</div>
