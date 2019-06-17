<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="view/includeResources.jsp"%>
</head>
<body>
<%@ include file="view/include/header.jsp"%>
 <!-- Start of Project FORM -->

    <div class="project">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <h5 class="display-4 text-center"> Edit Project form</h5>
                    <hr />
                    <form action="UpdateTaskController?project_identifier=${task.project_identifier}&project_sequence=${task.project_sequence}&id=${task.id}" method="post">
                    	 
                    	    <div class="form-group">
                           project_identifier : <input type="text" class="form-control form-control-lg " name="project_identifier" value="${task.project_identifier}" disabled="disabled">
                        </div>
                         <div class="form-group">
                           project_sequence :  <input type="text" class="form-control form-control-lg " name="project_sequence" value="${task.project_sequence}" disabled="disabled">
                        </div>
                        <div class="form-group">
                            acceptance_criteria :<input type="text" class="form-control form-control-lg " name="acceptance_criteria" value="${task.acceptance_criteria}">
                        </div>
                         <div class="form-group">
                           summary  <input type="text" class="form-control form-control-lg " name="summary" value="${task.summary}">
                        </div>
                        <div class="form-group">
                            Due Date <input type="date" class="form-control form-control-lg" name="dueDate" />
                        </div>
                        Status :<div class="form-group">
                            <select class="form-control form-control-lg" name="status">
                                <option value="">${task.status}</option>
                                <option value="TO_DO">TO DO</option>
                                <option value="IN_PROGRESS">IN PROGRESS</option>
                                <option value="DONE">DONE</option>
                            </select>
                        </div>
                        <input type="submit" class="btn btn-primary btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>

    <!-- END OF PROJECT FORM -->


</body>
</html>