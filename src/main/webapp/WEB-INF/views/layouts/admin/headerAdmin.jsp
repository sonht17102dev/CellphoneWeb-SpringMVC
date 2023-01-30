<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="sidebar col-12 col-lg-2 d-block">
				<div class="left-sidebar">

					<ul class="flex-column nav-pills">
						<li class="nav-item">
							<p class="nav-link logo">${usernameAdmin == null ? "Welcome to Admin page" : usernameAdmin}</p>
						</li>
						<li class="nav-item">
							<p class="nav-link logo">CELLPHONE S</p>
						</li>

						<li class="nav-item"><a class="nav-link active"
							aria-current="page" href="/CellPhoneShop/admin/"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-speedometer2"
									viewBox="0 0 16 16">
                                    <path
										d="M8 4a.5.5 0 0 1 .5.5V6a.5.5 0 0 1-1 0V4.5A.5.5 0 0 1 8 4zM3.732 5.732a.5.5 0 0 1 .707 0l.915.914a.5.5 0 1 1-.708.708l-.914-.915a.5.5 0 0 1 0-.707zM2 10a.5.5 0 0 1 .5-.5h1.586a.5.5 0 0 1 0 1H2.5A.5.5 0 0 1 2 10zm9.5 0a.5.5 0 0 1 .5-.5h1.5a.5.5 0 0 1 0 1H12a.5.5 0 0 1-.5-.5zm.754-4.246a.389.389 0 0 0-.527-.02L7.547 9.31a.91.91 0 1 0 1.302 1.258l3.434-4.297a.389.389 0 0 0-.029-.518z" />
                                    <path fill-rule="evenodd"
										d="M0 10a8 8 0 1 1 15.547 2.661c-.442 1.253-1.845 1.602-2.932 1.25C11.309 13.488 9.475 13 8 13c-1.474 0-3.31.488-4.615.911-1.087.352-2.49.003-2.932-1.25A7.988 7.988 0 0 1 0 10zm8-7a7 7 0 0 0-6.603 9.329c.203.575.923.876 1.68.63C4.397 12.533 6.358 12 8 12s3.604.532 4.923.96c.757.245 1.477-.056 1.68-.631A7 7 0 0 0 8 3z" />
                                </svg> Dashboard</span>
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <svg
									xmlns="http://www.w3.org/2000/svg" width="16" height="16"
									fill="currentColor" class="bi bi-person-fill"
									viewBox="0 0 16 16">
                                <path
										d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6z" />
                              </svg> Staff Manager
						</a></li>
					</ul>
				</div>
			</div>
			<div class="col-lg-10 col-12 main mx-0 px-0 d-flex flex-column">
				<div class="w-100 image-container">
					<img class="admin-image w-100"
						src="<c:url value="/resources/images/banner-admin.jpg"/>"
						style="position: relative;" alt="">
				</div>