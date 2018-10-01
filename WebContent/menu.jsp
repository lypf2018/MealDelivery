<%@ page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
</head>
<body>
	<a href="<%=request.getContextPath()%>/ProfileController">profile</a><br>
	<a href="<%=request.getContextPath()%>/CartController">shopping cart</a>

	<div class="container">
		<h2>Menu</h2>
		<ul class="nav nav-tabs nav-justified">
			<li class="active"><a data-toggle="pill" href="#home">Dish Category 1</a></li>
			<li><a data-toggle="pill" href="#menu1">Dish Category 2</a></li>
			<li><a data-toggle="pill" href="#menu2">Dish Category 3</a></li>
			<li><a data-toggle="pill" href="#menu3">Dish Category 4</a></li>
			<li><a data-toggle="pill" href="#menu4">Dish Category 5</a></li>
		</ul>
		
		<sql:setDataSource var="menudata"
			driver="${initParam['driver']}"
			url="${initParam['dburl']}" scope="page"
			user="${initParam['user']}" password="${initParam['password']}" />
		
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<sql:query var="pizzaQuery"
					sql="select menu_id,menu_name,menu_description,'.'||menu_imageurl as menu_imageurl,menu_price 
				from RA_MENU m,RA_MENU_CATEGORY c
				where m.CATEGORY_ID=c.CATEGORY_ID
					and c.CATEGORY_NAME='Dish Category 1'"
					dataSource="${menudata}"></sql:query>
				<h3>Dish Category 1</h3>
				<a href = "dishdetail.jsp">Dish Detail</a>
				<div class="row">
					<c:forEach var="row" items="${disCategory1Query.rows}" varStatus="status">
						<div class="col-sm-4">
							<img class="img-rounded" width=304 alt="${row.menu_name}"
								src="${row.menu_imageurl}">
							<h2>
								<c:out value="${row.menu_name}" />
							</h2>
							<h4>
								$
								<c:out value="${row.menu_price}" />
								- <input type="button" class="btn btn-info" value="Order" onclick="onOrder(${row.menu_id});"/>
							</h4>
							<p>
								<c:out value="${row.menu_description}" />
							</p>
						</div>
						<c:if test="${status.count%3 ==0}">
				</div>
				<div class="row">
					</c:if>

					</c:forEach>
				</div>
			</div>

			<div id="menu1" class="tab-pane fade">
				<sql:query var="sideQuery"
					sql="select menu_id,menu_name,menu_description,'.'||menu_imageurl as menu_imageurl,menu_price 
				from RA_MENU m,RA_MENU_CATEGORY c
				where m.CATEGORY_ID=c.CATEGORY_ID
					and c.CATEGORY_NAME='Dish Category 2'"
					dataSource="${menudata}"></sql:query>
				<h3>Dish Category 2</h3>
				<div class="row">
					<c:forEach var="row" items="${dishCategory2Query.rows}" varStatus="status">
						<div class="col-sm-4">
							<img class="img-rounded" width=304 alt="${row.menu_name}"
								src="${row.menu_imageurl}">
							<h2>
								<c:out value="${row.menu_name}" />
							</h2>
							<h4>
								$
								<c:out value="${row.menu_price}" />
								- <input type="button" class="btn btn-info" value="Order" onclick="onOrder(${row.menu_id});"/>
							</h4>
							<p>
								<c:out value="${row.menu_description}" />
							</p>
						</div>
						<c:if test="${status.count%3 ==0}">
				</div>
				<div class="row">
					</c:if>

					</c:forEach>
				</div>
			</div>
			<div id="menu2" class="tab-pane fade">
				<sql:query var="DrinkQuery"
					sql="select menu_id,menu_name,menu_description,'.'||menu_imageurl as menu_imageurl,menu_price 
				from RA_MENU m,RA_MENU_CATEGORY c
				where m.CATEGORY_ID=c.CATEGORY_ID
					and c.CATEGORY_NAME='Dish Category 3'"
					dataSource="${menudata}"></sql:query>
				<h3>Dish Category 3</h3>
				<div class="row">
					<c:forEach var="row" items="${dishCategory3Query.rows}" varStatus="status">
						<div class="col-sm-4">
							<img class="img-rounded" width=304 alt="${row.menu_name}"
								src="${row.menu_imageurl}">
							<h2>
								<c:out value="${row.menu_name}" />
							</h2>
							<h4>
								$
								<c:out value="${row.menu_price}" />
								- <input type="button" class="btn btn-info" value="Order" onclick="onOrder(${row.menu_id});"/>
							</h4>
							<p>
								<c:out value="${row.menu_description}" />
							</p>
						</div>
						<c:if test="${status.count%3 ==0}">
				</div>
				<div class="row">
					</c:if>
					</c:forEach>
				</div>

			</div>
			<div id="menu3" class="tab-pane fade">
				<sql:query var="DessertQuery"
					sql="select menu_id,menu_name,menu_description,'.'||menu_imageurl as menu_imageurl,menu_price 
				from RA_MENU m,RA_MENU_CATEGORY c
				where m.CATEGORY_ID=c.CATEGORY_ID
					and c.CATEGORY_NAME='Desserts'"
					dataSource="${menudata}"></sql:query>
				<h3>Dish Category 4</h3>
				<div class="row">
					<c:forEach var="row" items="${dishCategory4Query.rows}"
						varStatus="status">
						<div class="col-sm-4">
							<img class="img-rounded" width=304 alt="${row.menu_name}"
								src="${row.menu_imageurl}">
							<h2>
								<c:out value="${row.menu_name}" />
							</h2>
							<h4>
								$
								<c:out value="${row.menu_price}" />
								- <input type="button" class="btn btn-info" value="Order" onclick="onOrder(${row.menu_id});"/>
							</h4>
							<p>
								<c:out value="${row.menu_description}" />
							</p>
						</div>
						<c:if test="${status.count%3 ==0}">
				</div>
				<div class="row">
					</c:if>
					</c:forEach>
				</div>
			</div>
			<div id="menu4" class="tab-pane fade">
				<sql:query var="extrasQuery"
					sql="select menu_id,menu_name,menu_description,'.'||menu_imageurl as menu_imageurl,menu_price 
				from RA_MENU m,RA_MENU_CATEGORY c
				where m.CATEGORY_ID=c.CATEGORY_ID
					and c.CATEGORY_NAME='Extras'"
					dataSource="${menudata}"></sql:query>
				<h3>Dish Category 5</h3>
				<div class="row">
					<c:forEach var="row" items="${dishCategory5Query.rows}" varStatus="status">
						<div class="col-sm-4">
							<img class="img-rounded" width=304 alt="${row.menu_name}"
								src="${row.menu_imageurl}">
							<h2>
								<c:out value="${row.menu_name}" />
							</h2>
							<h4>
								$
								<c:out value="${row.menu_price}" />
								- <input type="button" class="btn btn-info" value="Order" onclick="onOrder(${row.menu_id});"/>
							</h4>
							<p>
								<c:out value="${row.menu_description}" />
							</p>
						</div>
						<c:if test="${status.count%3 ==0}">
				</div>
				<div class="row">
					</c:if>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
