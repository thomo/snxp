<%--
  ** Template for editing Snips.
  ** @author Matthias L. Jugel
  ** @version $Id$
  --%>

<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<%@ taglib uri="http://snipsnap.com/snipsnap" prefix="s" %>

<div id="snip-wrapper">
 <s:check roles="Authenticated" permission="Edit" snip="${snip}">
  <div id="snip-title">
   <h1 class="snip-name"><c:out value="${snip_name}" escapeXml="false"/></h1>
  </div>
  <c:if test="${not empty preview}">
   <div id="preview"><div id="snip-content"><c:out value="${preview}" escapeXml="false"/></div></div>
  </c:if>
  <div id="snip-content">
   <div id="snip-input">
    <form id="form" name="f" method="POST" action="../exec/store">
     <table>
      <tr><td><textarea name="content" type="text" cols="80" rows="20"><c:out value="${content}" escapeXml="false"/></textarea></td></tr>
      <tr><td class="form-buttons">
       <input value="Preview" name="preview" type="submit"/>
       <input value="Save" name="save" type="submit"/>
       <input value="Cancel" name="cancel" type="submit"/>
      </td></tr>
     </table>
     <input name="name" type="hidden" value="<c:out value="${snip_name}"/>"/>
     <input name="referer" type="hidden" value="<%= request.getHeader("REFERER") %>"/>
    </form>
   </div>
  </div>
 </s:check>
 <s:check roles="Authenticated" permission="Edit" snip="${snip}" invert="true">
  <a href="../exec/login.jsp">Please login!</a>
 </s:check>
</div>