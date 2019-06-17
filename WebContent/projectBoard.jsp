<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%@ include file="view/includeResources.jsp"%>
</head>
<body>
	<%@ include file="view/include/header.jsp"%>
	<c:set var="pid" value="${param.project_identifier}" />
	<jsp:useBean id="projectTask"
		class="com.yash.ppmtoolweb.serviceimpl.ProjectTaskServiceImpl" />
	<c:set var="listTaskInProgress" scope="request"
		value="${projectTask.listAllProjectTask(pid) }" />

	<!-- Project Board Starts Here MIND OTHER COMPONENTS WHEN COPY AND PASTING -->
	<div class="container">
		<a
			href="projectTask.jsp?project_identifier=${param.project_identifier}"
			class="btn btn-primary mb-3"> <i class="fas fa-plus-circle">
				Create Project Task</i>
		</a> <br />
		<hr />

		<!-- Backlog STARTS HERE -->
		<div class="container">

			<div class="row">
				<div class="col-md-4">
					<div class="card text-center mb-2">
						<div class="card-header bg-secondary text-white">
							<h3>TO DO</h3>
						</div>
					</div>

					<!-- SAMPLE PROJECT TASK STARTS HERE -->
					<c:forEach items="${listTaskInProgress}" var="p">
						<c:if test="${p.status == 'TO_DO'}">
							<div class="card mb-1 bg-light">

								<div class="card-header text-primary">
									ID:
									<c:out value='${p.project_sequence }' />
									Priority:
									<c:out value="${p.priority }" />
								</div>
								<div class="card-body bg-light">
									<h5 class="card-title">
										<c:out value="${p.summary }"></c:out>
									</h5>
									<p class="card-text text-truncate ">
										<c:out value="${p.acceptance_criteria }"></c:out>
									</p>
									<a href="GetInfoOfProjectTaskController?project_sequence=${p.project_sequence}" class="btn btn-primary"> View / Update </a>

									<button class="btn btn-danger ml-4">Delete</button>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<!-- SAMPLE PROJECT TASK ENDS HERE -->
				</div>
				<div class="col-md-4">
					<div class="card text-center mb-2">
						<div class="card-header bg-primary text-white">
							<h3>In Progress</h3>
						</div>
					</div>
					<!-- SAMPLE PROJECT TASK STARTS HERE -->
					<c:forEach items="${listTaskInProgress}" var="p">
						<c:if test="${p.status == 'IN_PROGRESS' }">
							<div class="card mb-1 bg-light">

								<div class="card-header text-primary">
									ID:
									<c:out value='${p.project_sequence }' />
									Priority:
									<c:out value="${p.priority }" />
								</div>
								<div class="card-body bg-light">
									<h5 class="card-title">
										<c:out value="${p.summary }"></c:out>
									</h5>
									<p class="card-text text-truncate ">
										<c:out value="${p.acceptance_criteria }"></c:out>
									</p>
									<a href="GetInfoOfProjectTaskController?project_sequence=${p.project_sequence}" class="btn btn-primary"> View / Update </a>

									<button class="btn btn-danger ml-4">Delete</button>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<!-- SAMPLE PROJECT TASK ENDS HERE -->
				</div>
				<div class="col-md-4">
					<div class="card text-center mb-2">
						<div class="card-header bg-success text-white">
							<h3>Done</h3>
						</div>
					</div>
					<!-- SAMPLE PROJECT TASK STARTS HERE -->
					<c:forEach items="${listTaskInProgress}" var="p">
						<c:if test="${p.status == 'DONE' }">
							<div class="card mb-1 bg-light">

								<div class="card-header text-primary">
									ID:
									<c:out value='${p.project_sequence }' />
									Priority:
									<c:out value="${p.priority }" />
								</div>
								<div class="card-body bg-light">
									<h5 class="card-title">
										<c:out value="${p.summary }"></c:out>
									</h5>
									<p class="card-text text-truncate ">
										<c:out value="${p.acceptance_criteria }"></c:out>
									</p>
									<a href="GetInfoOfProjectTaskController?project_sequence=${p.project_sequence}" class="btn btn-primary"> View / Update </a>

									<button class="btn btn-danger ml-4">Delete</button>
								</div>
							</div>
						</c:if>
					</c:forEach>
					<!-- SAMPLE PROJECT TASK ENDS HERE -->
				</div>
			</div>
		</div>

		<!-- Backlog ENDS HERE -->
	</div>

</body>
</html>