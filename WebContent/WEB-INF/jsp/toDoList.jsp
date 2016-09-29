<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css" type="text/css" media="screen">
<title>To Do List</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<c:if test="${!list.isEmpty()}">
		<div>
			<form method="post">
				<c:forEach items="${list}" var="note">
					<div>
						<input type="checkbox" class="noteCheckbox" id="${note.id}" name="toDelete" value="${note.id}"></input>
						<label for="${note.id}" class="noteLabel">
							<b>${note.id}. ${note.noteName}</b><br>
							-> ${note.noteBody}
						</label>
					</div>
					
				</c:forEach>
				<br>
				<input type="hidden" name="action" value="removeCompletedTasks"></input>
				<input type="submit" value="Remove Completed"></input>
			</form>
		</div>
		<br>
		<hr>
	</c:if>	
	<jsp:include page="addTaskForm.jsp"></jsp:include>
</body>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript">
		$(function () {
		    $("input:checkbox").on("change", function () {
		        var input = $(this).next("label");
		        if (this.checked) {
		            $(input).css("textDecoration", "line-through");
		        } else {
		            $(input).css("textDecoration", "none");
		        }
		    })
		})
	</script>
</html>