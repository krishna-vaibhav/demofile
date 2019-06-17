<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="view/includeResources.jsp" %>
</head>

<body>
<!-- Start of Project FORM -->

    <div class="project">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <h5 class="display-4 text-center">Create Project form</h5>
                    <hr />
                    <form action="./UpdateProjectController?project_sequence=${project.project_sequence }" method="post">
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg " name="project_name" value="${project.project_name}" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="project_identifier" value="${project.project_identifier}"
                             disabled  />
                        </div>
                        <!-- disabled for Edit Only!! remove "disabled" for the Create operation -->
                        <div class="form-group">
                            <textarea class="form-control form-control-lg" name="description" placeholder="Project Description"></textarea>
                        </div>
                        <h6>Start Date</h6>
                        <div class="form-group">
                            <input type="date" class="form-control form-control-lg" name="start_date" />
                        </div>
                        <h6>Estimated End Date</h6>
                        <div class="form-group">
                            <input type="date" class="form-control form-control-lg" name="end_date" />
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