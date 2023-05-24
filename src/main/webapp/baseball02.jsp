<%@ page language="java" contentType="text/html; charset=BIG5"
    pageEncoding="BIG5"
    import = "product.vo.product"
    %>
    
 
<!DOCTYPE html>
<html lang="zh-Hant-TW">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ixercise</title>
    <!-- �ޤJbootstarp��@��css���e========================================= -->
    <link href="lib/css/styles.css" rel="stylesheet" />
    <link href="lib/font/bootstrap-icons.min.css" rel="stylesheet" />

    <!-- �ޤJ����icon======================================================= -->
    <link rel="icon" type="image/x-icon" href="lib/img/IX-nobackground.png" />
    <!-- =========================================== -->
    <style>

    </style>
</head>

<body>

    <!-- �H�U�����C=================================================================================== -->
    <!-- �W�[w-100 sticky-top -->
    <nav class="navbar navbar-expand-lg navbar-light w-100 sticky-top navbar-color">
        <div class=" container-fluid px-4 px-lg-0 me-4 ">

            <!-- �Ӽ�===================================================================== -->
            <a class="navbar-brand m-0 px-4" href="#!">
                <img src="lib/img/IX-nobackground.png" alt="" width="91" height="60">
            </a>
            <!-- Bootstrap 5 �� Navbar Toggler ���s�A�Ω�b����M���O�����p�ù��W�A�I�����s�ɤ��������C���i�}�M���Y���A�C -->
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>

            <!-- �ӼЪ��k����============================================================ -->
            <div class="collapse navbar-collapse " id="navbarSupportedContent">

                <ul class="navbar-nav mb-2 mb-lg-0 w-100">
                    <!-- �j�M��=============================================================== -->
                    <!-- <li class="nav-item my-auto">
                        <form class="d-flex">
                            <input class="form-control" type="search" placeholder="�䬡��..." aria-label="Search">
                            <button class="btn border border-2 border-dark" type="submit">Search</button>
                        </form>
                    </li> -->

                    <li class="nav-item my-auto">
                        <form class="d-flex row">
                            <div class="row" style="width: 400px; max-width: 400px;">
                                <div class="col-8 pe-0">
                                    <input class="form-control" id="searchbar" type="search" placeholder="�j�M..."
                                        aria-label="Search" role="button">
                                    </input>
                                </div>
                                <div class="col-4 ps-0">
                                    <button class="btn border border-1 border-dark" type="submit">Search</button>
                                </div>
                            </div>

                            <!-- </form> -->
                            <!-- ================================================================== -->
                            <!-- <div class="collapse" id="collapseExample"> -->
                            <div id="searchcard" class="d-none">
                                <div class="searchbarthing w-50 position-fixed">
                                    <!-- <form action="" class="row mb-0"> -->
                                    <div class="row mb-0">
                                        <div class="col-3">
                                            <!-- <label for=""></label> -->
                                            <select class="form-select form-select-sm col-3 mb-3"
                                                aria-label="Default select example">
                                                <option selected>���� </option>
                                                <option value="1">�ӫ�</option>
                                                <option value="2">�׾�</option>
                                                <option value="3">����</option>
                                            </select>
                                        </div>
                                        <div class="col-3">
                                            <select class="form-select form-select-sm"
                                                aria-label="Default select example"
                                                onchange="javascript:location.href=this.value;">
                                                <option selected>�B������ </option>
                                                <option value="pageV5.jsp">�x�y</option>
                                                <option value="baseball01.jsp">�βy</option>
                                                <option value="soccer01.jsp">���y</option>
                                            </select>
                                        </div>
                                        <div class="col-3">
                                            <select class="form-select form-select-sm"
                                                aria-label="Default select example">
                                                <option selected>�U�۳]�w </option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                            </select>
                                        </div>
                                        <div class="col-3">
                                            <select class="form-select form-select-sm"
                                                aria-label="Default select example">
                                                <option selected>�U�۳]�w </option>
                                                <option value="1">One</option>
                                                <option value="2">Two</option>
                                                <option value="3">Three</option>
                                            </select>
                                        </div>
                                        <div class="row">
                                            <!-- <div class="col-9"></div> -->
                                            <div class="col-12 ">
                                                <!-- <button class="btn btn-primary" type="submit"> �d��
                                            </button> -->
                                                <button class="btn btn-primary" type="button"
                                                    id="btn-close-search">����</button>
                                                <button class="btn btn-primary" type="reset"
                                                    id="btn-close-search">���m</button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                    </li>

                    <!-- <div class="collapse  d-block" id="collapseExample">
                    </div> -->


                    <!-- �쬡��============================================================= -->
                    <li class="nav-item fs-5 ms-auto my-auto">
                        <a class="nav-link active h-100 " aria-current="page" href="#!">�쬡��
                        </a>
                    </li>
                    <!-- ��L�D��  ========================================================== -->
                    <li class="nav-item fs-5 dropdown my-auto">
                        <a class="nav-link dropdown-toggle navalable" id="navbarDropdown" href="#" role="button"
                            data-bs-toggle="dropdown" aria-expanded="false">��L�D��
                        </a>
                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <li><a class="dropdown-item" href="#!">����</a></li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li><a class="dropdown-item" href="#!">�ӫ�</a></li>
                            <li><a class="dropdown-item" href="#!">�׾�</a></li>
                            <li><a class="dropdown-item" href="#!">����</a></li>
                            <li><a class="dropdown-item" href="#!">�ҵ{</a></li>
                        </ul>
                    </li>
                    <!-- �a�L============================================================= -->
                    <!-- �٦��@���񺡪�bi-bell-fill -->
                    <!-- �ޱ�.n-dot�ӱ���L���I -->
                    <li class="nav-item dropdown my-auto">
                        <div class="n-dot"></div>
                        <svg width="36" height="36" fill="currentColor"
                            class="bi bi-bell dropdown-toggle dropdown-toggle" id="navbarDropdown" role="button"
                            data-bs-toggle="dropdown" viewBox="0 0 16 16">
                            <path
                                d="M8 16a2 2 0 0 0 2-2H6a2 2 0 0 0 2 2zM8 1.918l-.797.161A4.002 4.002 0 0 0 4 6c0 .628-.134 2.197-.459 3.742-.16.767-.376 1.566-.663 2.258h10.244c-.287-.692-.502-1.49-.663-2.258C12.134 8.197 12 6.628 12 6a4.002 4.002 0 0 0-3.203-3.92L8 1.917zM14.22 12c.223.447.481.801.78 1H1c.299-.199.557-.553.78-1C2.68 10.2 3 6.88 3 6c0-2.42 1.72-4.44 4.005-4.901a1 1 0 1 1 1.99 0A5.002 5.002 0 0 1 13 6c0 .88.32 4.2 1.22 6z" />
                        </svg>
                        <ul class="dropdown-menu dropdown-menu-lg-end" aria-labelledby="navbarDropdown">
                            <!-- �@���q��====================================================== -->

                            <div class="list-group">
                                <a href="#" class="list-group-item list-group-item-action" aria-current="true"
                                    style="height: 96px; width:600px;">
                                    <div class="row h-100">
                                        <div class="col-2 h-100">
                                            <img src="https://picsum.photos/150/200/?random=10"
                                                class="rounded-start h-100 w-100" alt="" style="object-fit:cover">
                                        </div>
                                        <div class="col-10">
                                            <div class="d-flex w-100 justify-content-between">
                                                <h5 class="mb-1">List group item heading</h5>
                                                <small>3 days ago</small>
                                            </div>
                                            <p class="mb-1">Some placeholder content in a paragraph.</p>
                                            <small>And some small print.</small>
                                        </div>
                                    </div>
                                </a>
                            </div>
                            <div class="list-group">
                                <a href="#" class="list-group-item list-group-item-action" aria-current="true"
                                    style="height: 96px; width:600px;">
                                    <div class="row h-100">
                                        <div class="col-2 h-100">
                                            <img src="https://picsum.photos/150/200/?random=10"
                                                class="rounded-start h-100 w-100" alt="" style="object-fit:cover">
                                        </div>
                                        <div class="col-10">
                                            <div class="d-flex w-100 justify-content-between">
                                                <h5 class="mb-1">List group item heading</h5>
                                                <small>3 days ago</small>
                                            </div>
                                            <p class="mb-1">Some placeholder content in a paragraph.</p>
                                            <small>And some small print.</small>
                                        </div>
                                    </div>
                                </a>
                            </div>
                        </ul>
                    </li>

                    <!-- �|���Y��========================================================= -->
                    <li class="nav-item dropdown mx-2 my-auto">
                        <img src="https://picsum.photos/300/200/?random=10"
                            class="nav-link dropdown-toggle overflow-hidden rounded-circle p-0" id="navbarDropdown"
                            href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" width="36"
                            height="36">

                        <ul class="dropdown-menu dropdown-menu-lg-end" aria-labelledby="navbarDropdown">

                            <li>
                                <img class="dropdown-item overflow-hidden p-2 rounded-circle"
                                    src="https://picsum.photos/200/200/?random=10" width="150" height="150">
                            </li>
                            <li>
                                <span class="dropdown-item-text justify-content-center d-flex fs-5">�W�r</span>
                            </li>
                            <li>
                                <hr class="dropdown-divider" />
                            </li>
                            <li>
                                <a class="dropdown-item" href="#!">�d�ݭӤH���</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#!">��ѦC��</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#!">���ʺ޲z</a>
                            </li>
                            <li>
                                <a class="dropdown-item" href="#!">�ҵ{�޲z</a>
                            </li>
                        </ul>
                    </li>
                </ul>
                <!-- �ʪ��������s============================================================= -->
                <form class="d-flex">
                    <button class="btn btn-outline-dark d-flex text-nowrap" type="submit">
                        <!-- �o�Ө�����class��bi-cart���� �N�|�ܦ��Ũ� -->
                        <i class="bi-cart-fill me-1"></i>
                        �ʪ���
                        <span class="badge bg-dark text-white ms-1 rounded-pill my-auto">0</span>
                    </button>
                </form>
            </div>
        </div>
    </nav>
    <!-- �����C����=================================================================================== -->

    <!-- �o�̤j���O��s�i -->
    <!-- Header====================================================================================== -->
     <!--<header>
        <div class="container-fluid p-0">
            <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
                <div class="carousel-indicators">
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0"
                        class="active" aria-current="true" aria-label="Slide 1"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                        aria-label="Slide 2"></button>
                    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                        aria-label="Slide 3"></button>
                </div>
                <div class="carousel-inner">
                    <div class="carousel-item active w-100 object-fit-cover">
                        <img src="https://picsum.photos/1920/300/?random=10" class="d-block" alt="...">
                    </div>
                    <div class="carousel-item w-100 object-fit-cover">
                        <img src="https://picsum.photos/1920/300/?random=11" class="d-block" alt="...">
                    </div>
                    <div class="carousel-item w-100 object-fit-cover">
                        <img src="https://picsum.photos/1920/300/?random=12" class="d-block" alt="...">
                    </div>
                </div>
                <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="prev">
                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Previous</span>
                </button>
                <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                    data-bs-slide="next">
                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                    <span class="visually-hidden">Next</span>
                </button>
            </div>
        </div>
    </header>-->
    <!-- Header====================================================================================== -->

   <!-- main-content -->
    <div class="container main-content">
        <!-- �Цb�o�̧@�~ -->
        <div class="row">
            <div class="col-12">
		                <!-- Section-->
		        <section class=" py-5">
		            <div class="container px-4 px-lg-5 mt-5">
		                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4">
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base01.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">Success �βy</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">NT$500</span>
		                                    NT$500
		                                </div>
		                            </div>
		                            <!-- Product actions-->
			                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
			                                <div class="text-center">
			                                	<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
			                                </div>
			                           </div>
		                          </div>
		                    </div>
		                     <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base02.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�|��y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent" >
		                                <div class="text-center">
		                                		<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                     <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base03.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�ִּβy</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <!--<span class="text-muted text-decoration-line-through">$20.00</span>-->
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center">
		                                		<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                     <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base04.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�βy��M</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center">
		                                	<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                </form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base05.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�����m�ߨ�</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center">
		                                 	<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                </form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base06.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�βy��M���ϭ�</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center">
		                                	<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                </form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base07.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">����y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center">
		                                	<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                </form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base08.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">��y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                                <div class="text-center">
		                                	<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                </form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base02.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�|��y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent" >
		                                <div class="text-center">
		                                		<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base02.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�|��y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent" >
		                                <div class="text-center">
		                                		<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base02.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�|��y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent" >
		                                <div class="text-center">
		                                		<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                    <div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Sale badge-->
		                            <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem">
		                                Sale
		                            </div>
		                            <!-- Product image-->
		                            <img class="card-img-top" src="lib/img/base02.jpg"
		                                alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4" style="color: red;">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder">�|��y��</h5>
		                                    <!-- Product reviews-->
		                                    <div class="d-flex justify-content-center small text-warning mb-2">
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                        <div class="bi-star-fill"></div>
		                                    </div>
		                                    <!-- Product price-->
		                                    <span class="text-muted text-decoration-line-through">$20.00</span>
		                                    $18.00
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent" >
		                                <div class="text-center">
		                                		<form action="BuyButtonServlet" method="post">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�ʶR" style="margin-bottom:20px">
			                                		<input name="input" class="btn btn-outline-dark mt-auto" type="submit" value="�[�J�ʪ���" style="margin-bottom:20px">
			                                	</form>
		                                </div>
		                            </div>
		                        </div>
		                    </div>
		                </div>
		            </div>
		        </section>
				<div id="pagination" style="text-align:center">
		        	<ul>
		        		<a href="javascript:history.back()">&laquo;</a>
		        		<a href="baseball01.jsp">1</a>
		        		<a href="baseball02.jsp">2</a>
		        		<a href="basketball03.jsp">3</a>
		        		<a href="javascript:history.forward()">&raquo;</a>
		        	</ul>
		        </div>
            </div>
        </div>
    </div>
			


    <!-- �H�Ufooter================================================================================= -->
    <footer class="footer py-5 footer-color">
        <div class="container">
            <div class="row">
                <div class="col-3">
                    <p class="m-0 text-white h3">�ȪA����</p>
                    <p class="m-0 text-white">Email: Ixercise@gmail.com</p>
                    <p class="m-0 text-white">Tel: 02-2712-0589</p>
                </div>
                <div class="col-3">
                    <p class="m-0 text-white h3">�ֳt�ϥ�</p>
                    <a class="d-block" href="">���U�|��</a>
                    <a class="d-block" href="">�|�쬡��</a>
                    <a class="d-block" href="">�`�����D</a>
                </div>
                <div class="col-3">
                    <p class="m-0 text-white h3">�D�n����</p>
                    <a class="d-block" href="">����</a>
                    <a class="d-block" href="">����</a>
                    <a class="d-block" href="">�׾�</a>
                    <a class="d-block" href="">�ӫ�</a>
                </div>
                <div class="col-3"></div>
            </div>
        </div>
    </footer>
    <!-- footer����================================================================================= -->
    <!-- �ޤJ�һݨ禡�w -->
    <script src="lib/js/bootstrap.bundle.min.js"></script>
    <script src="lib/js/popper.min.js"></script>
    <script src="lib/vendors/jquery/jquery-3.6.4.min.js"></script>
    <!-- ================================================================= -->

    <script>
        $("#searchbar").focus("click", function () {
            $("#searchcard").removeClass("d-none");
        });
        $("#btn-close-search").on("click", function () {
            $("#searchcard").addClass("d-none");
        })
    </script>
</body>

</html>